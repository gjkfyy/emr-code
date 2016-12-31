package pkuhit.iih.mr.tpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.MrFrTplDao;
import pkuhit.iih.mr.dao.auto.entity.MrFrTpl;
import pkuhit.iih.mr.md.MrBaseTemplateStatus;
import pkuhit.iih.mr.md.MrTemplateStatus;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.tpl.dao.CusFrTplDao;
import pkuhit.md.Dictionary;
import pkuhit.md.DictionaryService;
import pkuhit.md.SysFunctionCode;
import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.UUIDGenerator;

/**
 * @author guo_zhongbao
 * 基础模板服务实现类
 */
public class MrFrTplServiceImpl implements MrFrTplService {
	private Logger log = LoggerFactory.getLogger(MrFrTplServiceImpl.class);
	@Reference
	ParamsService paramsService;
	@Autowired
	//自动生成dao
	MrFrTplDao mrFrTplDao;
	//文件服务
	@Reference
	FileService fileService ;
	
	@Autowired
	CusFrTplDao cusDao ;
	
	@Reference 
	DictionaryService dictionaryService;
	
	/**
	 *  【基础模板】新建服务（单记录）
	 * @param MrFrTemplate value
	 * @return 单条基础模板
	 */
	@Override
	public SingleResult<MrFrTemplate> create(MrFrTemplate io) {
		if(null == io.getOdtFile()){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"文件流");
			throw new NotificationException(notification);
		}
		if(null == io.getNm()){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"名称");
			throw new NotificationException(notification);
		}
		if(null == io.getMrFrTplTpCd()){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"模板类型");
			throw new NotificationException(notification);
		}
		//字符大字段
		String baseFileContent = io.getOdtFile();
		//保存到文件 
		log.debug("baseFileContent is :"+baseFileContent);
		log.debug("null=fileService is :"+Boolean.valueOf(null == fileService));
		FileObject fo = null ;
		try{
		    fo = fileService.createFile("base", baseFileContent.getBytes());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		log.debug("null=fo is :"+Boolean.valueOf(null == fo));
		if(null != fo){
			log.debug("fo id is :"+ fo.getId());
		}
		//创建持久化对象  基础模板对象
		MrFrTpl mrFrTpl = new MrFrTpl();
		if(null == io.getMrFrTplCd()){
		}
		mrFrTpl.setMrFrTplCd(UUIDGenerator.getUUID());
		//设置名称
		mrFrTpl.setNm(io.getNm());
		//设置描述
		mrFrTpl.setMemo(io.getMemo());
		//设置纸张类型
		mrFrTpl.setMrFrTplTpCd(io.getMrFrTplTpCd());
		//设置文件pk
		if(null != fo){
		mrFrTpl.setFilePk(fo.getId());
		}
		//设置状态为 新建
		if(io.getStatus()!=null && io.getStatus().length()!=0){
			mrFrTpl.setStatus(MrBaseTemplateStatus.ACTIVED);
		}else{
			mrFrTpl.setStatus(MrBaseTemplateStatus.CREATED);
		}
//		mrFrTpl.setOrgCd(getOrgCode());
		mrFrTplDao.insertExludeNull(mrFrTpl);
		MrFrTpl po = mrFrTplDao.selectById(mrFrTpl.getMrFrTplCd());
		MrFrTemplate model = transPo2Vo(po);
		SingleResultBuilder<MrFrTemplate> builder = SingleResultBuilder.newSingleResult(MrFrTemplate.class);
		builder.withData(model);
		SingleResult<MrFrTemplate> rs = builder.build();
		return rs;
	}
	private MrFrTemplate transPo2Vo(MrFrTpl po) {
		MrFrTemplate model = new MrFrTemplate();
		BeanCopyUtil.entityToModel(model, po, MrFrTemplate.OBJ_CD, dictionaryService);
		//设置可操作状态
		if(!MrBaseTemplateStatus.CREATED.equalsIgnoreCase(po.getStatus()) ){
			model.setCanDelete(0);
//			model.setCanUpdate(0);
		}else{
			model.setCanDelete(1);
//			model.setCanUpdate(1);
		}
		model.setCanUpdate(1);//始终可以编辑
		if(MrBaseTemplateStatus.CREATED.equalsIgnoreCase(po.getStatus()) || MrBaseTemplateStatus.STOPED.equalsIgnoreCase(po.getStatus())){
			model.setCanActivated(1);
		}else{
			model.setCanActivated(0);
		}
		if(!MrBaseTemplateStatus.ACTIVED.equalsIgnoreCase(po.getStatus())){
			model.setCanStop(0);
		}else{
			model.setCanStop(1);
		}
		//转换
		
		return model;
	}
	/**
	 *  【基础模板】更新服务（单记录）
	 * @param MrFrTemplate value
	 * @return 单条基础模板
	 */
	@Override
	public SingleResult<MrFrTemplate> update(String id ,MrFrTemplate io) {
		//获取实例化对象
		MrFrTpl old = mrFrTplDao.selectById(io.getMrFrTplCd());
		//只能新建状态的，才能提供修改
//		if(!MrBaseTemplateStatus.CREATED.equals( old.getStatus())){
//			Notification notification = new Notification(MessageCode.UN_UPDATE_TEMPLATE,"只能处理新建状态的基础模板", "");
//			throw new NotificationException(notification);
//		}
		if(null == io.getOdtFile()){
			//只是更新属性
			//设置名称
			old.setNm(io.getNm());
			//设置描述
			old.setMemo(io.getMemo());
			//设置类型
			old.setMrFrTplTpCd(io.getMrFrTplTpCd());
			mrFrTplDao.updateExcludeNull(old);
		}else{
			//只是更新模板文件
			String baseFileContent =  io.getOdtFile() ;
			log.debug("baseFileContent is :"+baseFileContent);
			log.debug("null=fileService is :"+Boolean.valueOf(null == fileService));
			try {
				fileService.updateBaseFile(io.getFilePk(), baseFileContent.getBytes());
			} catch (SQLException e) {
				e.printStackTrace();
				Notification notification = new Notification(MessageCode.FILE_UPDATE_FAILURE, "文件保存失败,请重试保存。");
				throw new NotificationException(notification);
			} catch (Exception e) {
				e.printStackTrace();
				Notification notification = new Notification(MessageCode.FILE_UPDATE_FAILURE, "文件保存失败,请重试保存。");
				throw new NotificationException(notification);
			}
			FileObject fo = null ;
			try{
			    fo = fileService.createFile("base", baseFileContent.getBytes());
			}catch(Exception ex){
				ex.printStackTrace();
			}
			log.debug("null=fo is :"+Boolean.valueOf(null == fo));
			if(null != fo){
				log.debug("fo id is :"+ fo.getId());
			}
			old.setContentText(io.getContentText());
			mrFrTplDao.updateExcludeNull(old);
		}
		//设置名称
		MrFrTpl po = mrFrTplDao.selectById(io.getMrFrTplCd());
		MrFrTemplate model = this.transPo2Vo(po);
		SingleResultBuilder<MrFrTemplate> builder = SingleResultBuilder.newSingleResult(MrFrTemplate.class);
		builder.withData(model);
		SingleResult<MrFrTemplate> rs = builder.build();
		return rs;
	}
	
	/**
	 *  【基础模板】查询服务（单记录）
	 * @param String id
	 * @return 单条基础模板
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#search(java.lang.String)
	 */
	@Override
	public SingleResult<MrFrTemplate> searchById(String id) {
		SingleResultBuilder<MrFrTemplate> builder = SingleResultBuilder.newSingleResult(MrFrTemplate.class);
		MrFrTpl po = mrFrTplDao.selectById(id);
		if(null != po){
			MrFrTemplate model =transPo2Vo(po);
			builder.withData(model);
		}else{
			Notification notification = new Notification(MessageCode.NOT_EXIST,"片段模板"+id);
			throw new NotificationException(notification);
		}		
		SingleResult<MrFrTemplate> rs = builder.build();
		return rs;
	}
	
	/**
	 *  【基础模板】查询服务（多记录）
	 * @param  MrFrTemplate condition
	 * @return List<MrFrTemplate>
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<MrFrTemplate> search(Map<String,Object> condition) {
		String excludeDelete = "" ; //默认空，表示不
		String mrFrTplCd = null ;
		if(condition.containsKey("excludeDelete") &&("false".equalsIgnoreCase((String)condition.get("excludeDelete"))  ||"0".equalsIgnoreCase((String)condition.get("excludeDelete")) )){
			excludeDelete = null ;
		}
		if(condition.containsKey("mrFrTplCd") && null != condition.get("mrFrTplCd") ){ //状态码
			mrFrTplCd = (String)condition.get("mrFrTplCd");
		}
		String name = null;
		if(condition.containsKey("name") ){
			name = (String)condition.get("name");
		}
		ArrayResultBuilder<MrFrTemplate>  builder = ArrayResultBuilder.newArrayResult(MrFrTemplate.class);
		long total = 0;
		/*分页实现部分*/
		String pageNum = null; 
		String pageSize = null; 
		if(condition.containsKey("pageNum") && condition.containsKey("pageSize")){ 
		pageNum = (String)condition.get("pageNum"); 
		pageSize = (String)condition.get("pageSize"); 
		} 
		if(null == pageNum || !StringUtils.isNumeric(pageNum) || null == pageSize || !StringUtils.isNumeric(pageSize) ) 
		{ 
		pageNum= "1"; 
		pageSize = "25"; 
		} 
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		List<MrFrTpl> poList  = cusDao.selectAll(excludeDelete,name,mrFrTplCd,options) ;
		if(poList.size() > 0){
			MrFrTemplate[] voArray = new MrFrTemplate[poList.size()];
			for(int i = 0 ; i < poList.size() ; i++){
				MrFrTpl po = poList.get(i);
				MrFrTemplate vo =transPo2Vo(po );
				voArray[i]=vo ;
			}
			builder.withData(voArray);
			total = options.getCount();
		}else{
			ArrayResult<MrFrTemplate> rs = builder.build();
			rs.setPageNum(Integer.valueOf(pageNum));
			rs.setPageSize(Integer.valueOf(pageSize));
			rs.setTotal(0);
		}
		ArrayResult<MrFrTemplate> rs = builder.build();
		rs.setPageNum(Integer.valueOf(pageNum));
		rs.setPageSize(Integer.valueOf(pageSize));
		rs.setTotal(Long.valueOf(total).intValue());
		return rs;
	}

	/**
	 * 【基础模板】删除服务（单记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#delete(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> delete(ArrayInputModel arrayInputModel) {		
		String[] ids = arrayInputModel.getIds() ;
		SingleResult<BatchOperationResult> result = new SingleResult<BatchOperationResult>();
		BatchOperationResult operationMessge = new BatchOperationResult();
		//参数验证
		if(null == ids || ids.length == 0){
			operationMessge.setSuccess("fail");
			operationMessge.setMessage("传入参数为空");			
			result.setData(operationMessge);
			return result;			
		}
		//初始化操作结果对象
		int successCount = 0 ;
		int failCount = 0 ;
		FailItem[] failItemsTemp = new FailItem[ids.length] ; 
		//循环遍历，对每个id进行处理
		for(int i = 0 ; i < ids.length ; i++){
			String id = ids[i] ;
			//获取数据库持久化对象
			MrFrTpl po = mrFrTplDao.selectById(id);
			if(!MrBaseTemplateStatus.CREATED.equalsIgnoreCase(po.getStatus()) ){
				//非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrFrTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item ;
				failCount++ ;				
			}else{
				//进行正常操作
				//updCount，主键，del_f（=1）
				//fileService.deleteFile(po.getFilePk());
				po.setUpdCnt(po.getUpdCnt().add(BigInteger.valueOf(1)));
				po.setDelF(Short.valueOf("1"));
				mrFrTplDao.markDelete(po);
				successCount++;
			}
		}
		FailItem[]	 failItems = null ;
		if(failCount > 0){
			failItems = Arrays.copyOfRange(failItemsTemp, 0, failCount-1);
		}
		operationMessge.setFailCount(failCount);
		operationMessge.setFailItems(failItems);
		operationMessge.setSuccess("true");
		operationMessge.setSuccessCount(successCount);
		operationMessge.setMessage("操作结果：成功_"+successCount+"_个，失败_"+failCount+"个");
		result.setData(operationMessge);
		return result ;
	}
	
	/**
	 * 【基础模板】启用服务（单记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 * @
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#activate(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> activate(ArrayInputModel arrayInputModel) {		
		String[] ids = arrayInputModel.getIds() ;
		SingleResult<BatchOperationResult> result = new SingleResult<BatchOperationResult>();
		BatchOperationResult operationMessge = new BatchOperationResult();
		if(null == ids || ids.length == 0){
			operationMessge.setSuccess("fail");
			operationMessge.setMessage("传入参数为空");			
			result.setData(operationMessge);
			return result;			
		}
		//初始化操作结果对象
		int successCount = 0 ;
		int failCount = 0 ;
		FailItem[] failItemsTemp = new FailItem[ids.length] ; 
		//循环遍历，对每个id进行处理
		for(int i = 0 ; i < ids.length ; i++){
			String id = ids[i] ;
			//获取数据库持久化对象
			MrFrTpl po = mrFrTplDao.selectById(id);
			if(!(MrBaseTemplateStatus.CREATED.equalsIgnoreCase(po.getStatus()) || MrBaseTemplateStatus.STOPED.equalsIgnoreCase(po.getStatus()))){
				//非新建状态或者非停用,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrFrTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item ;
				failCount++ ;				
			}else{
				//进行正常操作
				po.setStatus(MrBaseTemplateStatus.ACTIVED);
				mrFrTplDao.update(po);
/*				String pageNum = "1"; 
				String pageSize = "1000"; 
				SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
				List<MrFrTpl> poList  = cusDao.selectAll("", new ArrayList<String>(), null, po.getRtMrBaseTplCd(),getOrgCode(),options);
				if(null != poList && poList.size() > 0){
					for(MrFrTpl po_stop :poList){
						if(po_stop.getMrBaseTplCd().equalsIgnoreCase(po.getMrBaseTplCd())){
							continue;
						}
						po_stop.setMrBaseTplStaCd(MrBaseTemplateStatus.STOPED);
						po_stop.setDelF(Short.valueOf("1"));
					}
					mrFrTplDao.batchUpdate(poList);
				}*/
				successCount++;
			}
		}
		FailItem[]	 failItems = null ;
		if(failCount > 0){
			failItems = Arrays.copyOfRange(failItemsTemp, 0, failCount-1);
		}
		operationMessge.setFailCount(failCount);
		operationMessge.setFailItems(failItems);
		operationMessge.setSuccess("true");
		operationMessge.setSuccessCount(successCount);
		operationMessge.setMessage("操作结果：成功_"+successCount+"_个，失败_"+failCount+"个");
		result.setData(operationMessge);
		return result ;		
	}

	/**
	 * 【基础模板】停用服务（单记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#stop(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> stop(ArrayInputModel arrayInputModel) {		
		String[] ids = arrayInputModel.getIds() ;
		SingleResult<BatchOperationResult> result = new SingleResult<BatchOperationResult>();
		BatchOperationResult operationMessge = new BatchOperationResult();
		if(null == ids || ids.length == 0){
			operationMessge.setSuccess("fail");
			operationMessge.setMessage("传入参数为空");			
			result.setData(operationMessge);
			return result;			
		}
		//初始化操作结果对象
		int successCount = 0 ;
		int failCount = 0 ;
		FailItem[] failItemsTemp = new FailItem[ids.length] ; 
		//循环遍历，对每个id进行处理
		for(int i = 0 ; i < ids.length ; i++){
			String id = ids[i] ;
			//获取数据库持久化对象
			MrFrTpl po = mrFrTplDao.selectById(id);
			if(!MrBaseTemplateStatus.ACTIVED.equalsIgnoreCase(po.getStatus())){
				//非启用,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrFrTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item ;
				failCount++ ;				
			}else{
				//进行正常操作
				po.setStatus(MrBaseTemplateStatus.STOPED);
				mrFrTplDao.update(po);
				successCount++;
			}
		}
		FailItem[]	 failItems = null ;
		if(failCount > 0){
			failItems = Arrays.copyOfRange(failItemsTemp, 0, failCount-1);
		}
		operationMessge.setFailCount(failCount);
		operationMessge.setFailItems(failItems);
		operationMessge.setSuccess("true");
		operationMessge.setSuccessCount(successCount);
		operationMessge.setMessage("操作结果：成功_"+successCount+"_个，失败_"+failCount+"个");
		result.setData(operationMessge);
		return result ;			
	}
	
	@Override
	public SingleResult<Boolean> HasDuplicationOfName(String code,String name) {
		SingleResultBuilder<Boolean> builder = SingleResultBuilder.newSingleResult(Boolean.class);
		Boolean isDuplicationOfName = Boolean.TRUE ;
		int count = this.cusDao.getCountOfName(code,name);
		if(count == 0){
			isDuplicationOfName =  Boolean.FALSE ; 
		}
		builder.withData(isDuplicationOfName);
		SingleResult<Boolean> rs = builder.build();
		return rs;
	}
	
	private String getStatusName(String statusCode){
		SimpleItem[] simpleItems = dictionaryService.getSimpleItems(MrTemplateStatus.OBJ_CD, statusCode);
		String statusName = simpleItems[0].getText() ;
		log.debug( "statusCode:"+statusCode);
		log.debug( "statusName:"+statusName);
		return statusName;
	}
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.MrFrTplService#searchOutdisposalTemp()
	 */
	@Override
	public SingleResult<MrPrescriptionAndDisposeTemplate> searchOutdisposalTemp() throws UnsupportedEncodingException, IOException {
		SingleResultBuilder<MrPrescriptionAndDisposeTemplate> builder = SingleResultBuilder.newSingleResult(MrPrescriptionAndDisposeTemplate.class);
		MrPrescriptionAndDisposeTemplate model =new MrPrescriptionAndDisposeTemplate();
		model.setPrescriptionAndDisposeSignFile(new String(getFileObject(SysFunctionCode.OUT_DISPOSAL_AND_PRESCRIPTION_SIGN_TEMPLATE_CONFIG).asByteArray()));
		model.setPrescriptionSignFile(new String(getFileObject(SysFunctionCode.OUT_PRESCRIPTION_SIGN_TEMPLATE_CONFIG).asByteArray()));
		model.setDisposeSignFile(new String(getFileObject(SysFunctionCode.OUT_DISPOSAL_SIGN_TEMPLATE_CONFIG).asByteArray()));
		model.setPrescriptionFile(new String(getFileObject(SysFunctionCode.OUT_PRESCRIPTION_TEMPLATE_CONFIG).asByteArray()));
		builder.withData(model);
		SingleResult<MrPrescriptionAndDisposeTemplate> rs = builder.build();
		return rs;
	}
	
	public FileObject getFileObject(String sysFunctionCode){
		FileObject fileObject=null;
		Map<String, String> map=new HashMap<String, String>();
		map.put(SysFunctionCode.OUT_DISPOSAL_AND_PRESCRIPTION_SIGN_TEMPLATE_CONFIG,MessageCode.OUT_PRESCRIPTION_AND_PRESCRIPTION_SIGN_TEMPLATE_NOT_SET);
		map.put(SysFunctionCode.OUT_PRESCRIPTION_TEMPLATE_CONFIG,MessageCode.OUT_PRESCRIPTION_TEMPLATE_NOT_SET);
		map.put(SysFunctionCode.OUT_PRESCRIPTION_SIGN_TEMPLATE_CONFIG,MessageCode.OUT_PRESCRIPTION_SIGN_TEMPLATE_NOT_SET);
		map.put(SysFunctionCode.OUT_DISPOSAL_SIGN_TEMPLATE_CONFIG,MessageCode.OUT_DISPOSAL_SIGN_TEMPLATE_NOT_SET);
		
		Param[] params=paramsService.getParam(sysFunctionCode).getDataList();
		if(params.length>0){
			Param param=params[0];
			String tempCode=param.getValue();
			MrFrTpl  mrFrTpl=mrFrTplDao.selectById(tempCode);
			if(null!=mrFrTpl){
				String filePk=mrFrTpl.getFilePk();
				fileObject=fileService.getFile(filePk);
				if(null==fileObject){
					Notification notification = new Notification(MessageCode.FILE_GET_FATAL, tempCode);
					throw new NotificationException(notification);
				}
			}else{
				Notification notification = new Notification(map.get(sysFunctionCode), tempCode);
				throw new NotificationException(notification);
			}
		}
		return fileObject;
	}
	
	
	@Override
	public SingleResult<Map<String,Object>> searchTree(Map<String, String> condition) throws IOException{
    	SingleResult<Map<String,Object>> result = new SingleResult<Map<String,Object>>();
        String keyword = (String) condition.get("keyword");
		// 返回结果map
		Map<String,Object> mapResult = new HashMap<String,Object>();
		mapResult.put("text", "root");
		
		Dictionary typeList = dictionaryService.getDictionary("MRM12");
		List<Map<String,Object>> firstChild = new ArrayList<Map<String,Object>>(), mSecondMaps = new ArrayList<Map<String,Object>>();
		Map<String,Object>  mfirstChild = null, secondMap = null;
		String gsCd = null,typeNm=null,mrFrTplCd=null,mrFrTplNm=null,contentText=null,odtFile = null,filePk = null;
		FileObject file = null;
		List<Map<String, Object>> mrFrTplList = null;
		
		if (null != typeList && typeList.getData().size() > 0) {
			mfirstChild = new HashMap<String,Object>();
			for (int i = 0; i < typeList.getData().size(); i++) {
				gsCd = (String)typeList.getData().get(i).get("value");
				typeNm = (String)typeList.getData().get(i).get("text");
				//判断该类型下是否有数据
				mfirstChild = new HashMap<String,Object>();
				mfirstChild.put("id","gsCd_"+gsCd);
				mfirstChild.put("text",typeNm);
				mfirstChild.put("content","content_"+typeNm);
				mfirstChild.put("odtFile","odtFile_"+typeNm);
				mrFrTplList = cusDao.selectMrFrTplTree(keyword, gsCd);
				if(null != mrFrTplList && mrFrTplList.size() > 0){
					mSecondMaps = new ArrayList<Map<String,Object>>();
					for (int j = 0; j < mrFrTplList.size(); j++) {
						secondMap = new HashMap<String,Object>();
						mrFrTplCd = (String)mrFrTplList.get(j).get("MR_FR_TPL_CD");
						mrFrTplNm = (String)mrFrTplList.get(j).get("NM");
						contentText = (String)mrFrTplList.get(j).get("CONTENT_TEXT");
						filePk = (String)mrFrTplList.get(j).get("FILE_PK");
						file = fileService.getFile(filePk);
						if(file!=null){
							odtFile = new String(file.asByteArray());
						}
						secondMap.put("id", mrFrTplCd);
						secondMap.put("text",mrFrTplNm);
						secondMap.put("content",contentText);
						secondMap.put("odtFile",odtFile);
						secondMap.put("leaf",true);
						mSecondMaps.add(secondMap);
					}
					mfirstChild.put("children", mSecondMaps);
				}	
				firstChild.add(mfirstChild);
			}
		}
		mapResult.put("children",firstChild );

		result.setData(mapResult);
		return result;
	}
}
