package pkuhit.iih.mr.tpl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.MrBaseTplDao;
import pkuhit.iih.mr.dao.auto.entity.MrBaseTpl;
import pkuhit.iih.mr.md.MrBaseTemplateStatus;
import pkuhit.iih.mr.md.MrTemplateStatus;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.tpl.dao.CusBaseTemplateDao;
import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.md.DictionaryService;
import pkuhit.org.Organization;
import pkuhit.xap.ac.Session;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.me.MeCdRuService;
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
public class BaseTemplateServiceImpl implements BaseTemplateService {
	private Logger log = LoggerFactory.getLogger(BaseTemplateServiceImpl.class);
	@Autowired
	//自动生成dao
	MrBaseTplDao autoGenDao;
	//文件服务
	@Reference
	FileService fileService ;
	//根记录模板编码生成服务
/*	@Reference
	MeCdRuService  meCdRuService ;*/
	//自定义dao
	@Autowired
	CusBaseTemplateDao cusDao ;
	
	@Reference 
	DictionaryService dictionaryService;
	
/*	@Reference
	DataObjectService dataObjectService;
	
	@Reference
	OrganizationService organizationService;
	*/
	/**
	 *  【基础模板】新建服务（单记录）
	 * @param MrBaseTemplate value
	 * @return 单条基础模板
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#create(pkuhit.iih.mr.tpl.MrBaseTemplate)
	 */
	@Override
	public SingleResult<MrBaseTemplate> create(BaseTemplateInputModel io) {
		if(null == io.getOdtFile()){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"文件流");
			throw new NotificationException(notification);
		}
		if(null == io.getName()){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"名称");
			throw new NotificationException(notification);
		}
		if(null == io.getPaperTypeCode()){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"纸张类型");
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
		MrBaseTpl baseTemplate = new MrBaseTpl();
		String rootCode = null ;
		BigInteger verNo = null ;
		if(null == io.getCode()){
/*			//新建对象
			verNo = BigInteger.ONE;
			//根医疗记录基础模板编码
			rootCode = meCdRuService.selectById(MrBaseTemplate.ROOT_CODE).getId();
			if(null == rootCode){
				
			}*/
		}else{
			//判断是否是最高版本的停用记录，如果是可以升级
			//升级对象，获取数据库对象，然后更新版本号，文件流
			MrBaseTpl old = autoGenDao.selectById(io.getCode());
//			rootCode = old.getRtMrBaseTplCd() ;
			BigInteger currVersion = cusDao.selectMaxVersionByRootCode(rootCode) ;
//			if(! ( MrBaseTemplateStatus.ACTIVED.equalsIgnoreCase(old.getMrBaseTplStaCd())  ||  MrBaseTemplateStatus.STOPED.equalsIgnoreCase(old.getMrBaseTplStaCd())  )){
//				Notification notification = new Notification(MessageCode.UN_UPGRADE_TEMPLATE,"只能升级操作只适用于启用或停用状态的基础模板");
//				throw new NotificationException(notification);
//			}
			verNo = currVersion.add(BigInteger.ONE);
		}		
		//设置版本
//		baseTemplate.setVerNo(verNo);
		//String code = rootCode +"."+ String.format("%04d", verNo); 
		//医疗记录基础模板编码
		baseTemplate.setMrBaseTplCd(UUIDGenerator.getUUID());
		//根医疗记录基础模板编码
//		baseTemplate.setRtMrBaseTplCd(rootCode);
		//设置名称
		baseTemplate.setNm(io.getName() );
		//设置描述
		baseTemplate.setDes(io.getDescription());
		//设置纸张类型
		baseTemplate.setPaperTpCd(io.getPaperTypeCode());
		//设置文件pk
		if(null != fo){
		baseTemplate.setFilePk(fo.getId());
		}
		//设置状态为 新建
		if(io.getStatusCode()!=null && io.getStatusCode().length()!=0){
			baseTemplate.setMrBaseTplStaCd(MrBaseTemplateStatus.ACTIVED);
		}else{
			baseTemplate.setMrBaseTplStaCd(MrBaseTemplateStatus.CREATED);
		}
//		baseTemplate.setOrgCd(getOrgCode());
		autoGenDao.insertExludeNull(baseTemplate);
		MrBaseTpl po = autoGenDao.selectById(baseTemplate.getMrBaseTplCd());
		MrBaseTemplate model = transPo2Vo(po );
		SingleResultBuilder<MrBaseTemplate> builder = SingleResultBuilder.newSingleResult(MrBaseTemplate.class);
		builder.withData(model);
		SingleResult<MrBaseTemplate> rs = builder.build();
		return rs;
	}
	private MrBaseTemplate transPo2Vo(MrBaseTpl po) {
		MrBaseTemplate model = new MrBaseTemplate();
		BeanCopyUtil.entityToModel(model, po, MrBaseTemplate.OBJ_CD, dictionaryService);
		//设置可操作状态
		if(!MrBaseTemplateStatus.CREATED.equalsIgnoreCase(po.getMrBaseTplStaCd()) ){
			model.setCanDelete(0);
//			model.setCanUpdate(0);
		}else{
			model.setCanDelete(1);
//			model.setCanUpdate(1);
		}
		model.setCanUpdate(1);//始终可以编辑
		if(MrBaseTemplateStatus.CREATED.equalsIgnoreCase(po.getMrBaseTplStaCd()) || MrBaseTemplateStatus.STOPED.equalsIgnoreCase(po.getMrBaseTplStaCd())){
			model.setCanActivated(1);
		}else{
			model.setCanActivated(0);
		}
		if(!MrBaseTemplateStatus.ACTIVED.equalsIgnoreCase(po.getMrBaseTplStaCd())){
			model.setCanStop(0);
			model.setCanAapply(0);
		}else{
			model.setCanStop(1);
			model.setCanAapply(1);
		}
		
		//判断是否是最高版本的停用记录，如果是可以升级
//		String rootCode = po.getRtMrBaseTplCd() ;
//		BigInteger currMaxVersion = cusDao.selectMaxVersionByRootCode(rootCode) ;
//		if( MrBaseTemplateStatus.ACTIVED.equalsIgnoreCase(po.getMrBaseTplStaCd()) || currMaxVersion.intValue() == (po.getVerNo().intValue())){
//			model.setCanUpgrade(1);
//		}else{
//			model.setCanUpgrade(0);
//		}
		return model;
	}
	/**
	 *  【基础模板】更新服务（单记录）
	 * @param MrBaseTemplate value
	 * @return 单条基础模板
	 */
	/* (non-Javadoc)rt_mr_base_tpl_cd
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#update(java.lang.String, pkuhit.iih.mr.tpl.MrBaseTemplate)
	 */
	@Override
	public SingleResult<MrBaseTemplate> update(String id ,BaseTemplateInputModel io) {
		//获取实例化对象
		MrBaseTpl old = autoGenDao.selectById(io.getCode());
		//只能新建状态的，才能提供修改
//		if(!MrBaseTemplateStatus.CREATED.equals( old.getMrBaseTplStaCd())){
//			Notification notification = new Notification(MessageCode.UN_UPDATE_TEMPLATE,"只能处理新建状态的基础模板", "");
//			throw new NotificationException(notification);
//		}
		if(null == io.getOdtFile()){
			//只是更新属性
			//设置名称
			old.setNm(io.getName() );
			//设置描述
			old.setDes(io.getDescription());
			//设置纸张类型
			old.setPaperTpCd(io.getPaperTypeCode());
			autoGenDao.updateExcludeNull(old);
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
			
		}
		//设置名称
		MrBaseTpl po = autoGenDao.selectById(io.getCode());
		MrBaseTemplate model = this.transPo2Vo(po);
		SingleResultBuilder<MrBaseTemplate> builder = SingleResultBuilder.newSingleResult(MrBaseTemplate.class);
		builder.withData(model);
		SingleResult<MrBaseTemplate> rs = builder.build();
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
	public SingleResult<MrBaseTemplate> searchById(String id) {
		SingleResultBuilder<MrBaseTemplate> builder = SingleResultBuilder.newSingleResult(MrBaseTemplate.class);
		MrBaseTpl po = autoGenDao.selectById(id);
		if(null != po){
			MrBaseTemplate model =transPo2Vo(po );
			builder.withData(model);
		}else{
			Notification notification = new Notification(MessageCode.NOT_EXIST);
			throw new NotificationException(notification);
		}		
		SingleResult<MrBaseTemplate> rs = builder.build();
		return rs;
	}
	
	/**
	 *  【基础模板】查询服务（多记录）
	 * @param  MrBaseTemplate condition
	 * @return List<MrBaseTemplate>
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<MrBaseTemplate> search(Map condition) {
		String excludeDelete = "" ; //默认空，表示不
		String statusCode = null ;
		if(condition.containsKey("excludeDelete") &&("false".equalsIgnoreCase((String)condition.get("excludeDelete"))  ||"0".equalsIgnoreCase((String)condition.get("excludeDelete")) )){
			excludeDelete = null ;
		}
		List<String> statusCodeList =new ArrayList<String>(); ;
		if(condition.containsKey("statusCode") && null != condition.get("statusCode") ){ //状态码
			statusCode = (String)condition.get("statusCode");
			String[] statusCodeArray = statusCode.split(",");
			statusCodeList = Arrays.asList(statusCodeArray);
		}
		String name = null;
		if(condition.containsKey("name") ){
			name = (String)condition.get("name");
		}
		ArrayResultBuilder<MrBaseTemplate>  builder = ArrayResultBuilder.newArrayResult(MrBaseTemplate.class);
		long total = 0;
		String orgCode =  getOrgCode();
		if(condition.containsKey("orgCode") && null != condition.get("orgCode")){
			orgCode = (String)condition.get("orgCode");
		}
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
		List<MrBaseTpl> poList  = cusDao.selectAll(excludeDelete,statusCodeList, name,null,options) ;
		if(poList.size() > 0){
			MrBaseTemplate[] voArray = new MrBaseTemplate[poList.size()];
			for(int i = 0 ; i < poList.size() ; i++){
				MrBaseTpl po = poList.get(i);
				MrBaseTemplate vo =transPo2Vo(po );
				voArray[i]=vo ;
			}
			builder.withData(voArray);
			total = options.getCount();
		}else{
			ArrayResult<MrBaseTemplate> rs = builder.build();
			rs.setPageNum(Integer.valueOf(pageNum));
			rs.setPageSize(Integer.valueOf(pageSize));
			rs.setTotal(0);
		}
		ArrayResult<MrBaseTemplate> rs = builder.build();
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
			MrBaseTpl po = autoGenDao.selectById(id);
			if(!MrBaseTemplateStatus.CREATED.equalsIgnoreCase(po.getMrBaseTplStaCd()) ){
				//非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item ;
				failCount++ ;				
			}else{
				//进行正常操作
				//updCount，主键，del_f（=1）
				//fileService.deleteFile(po.getFilePk());
				po.setUpdCnt(po.getUpdCnt().add(BigInteger.valueOf(1)));
				po.setDelF(Short.valueOf("1"));
				autoGenDao.markDelete(po);
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
			MrBaseTpl po = autoGenDao.selectById(id);
			if(!(MrBaseTemplateStatus.CREATED.equalsIgnoreCase(po.getMrBaseTplStaCd()) || MrBaseTemplateStatus.STOPED.equalsIgnoreCase(po.getMrBaseTplStaCd()))){
				//非新建状态或者非停用,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item ;
				failCount++ ;				
			}else{
				//进行正常操作
				po.setMrBaseTplStaCd(MrBaseTemplateStatus.ACTIVED);
				autoGenDao.update(po);
/*				String pageNum = "1"; 
				String pageSize = "1000"; 
				SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
				List<MrBaseTpl> poList  = cusDao.selectAll("", new ArrayList<String>(), null, po.getRtMrBaseTplCd(),getOrgCode(),options);
				if(null != poList && poList.size() > 0){
					for(MrBaseTpl po_stop :poList){
						if(po_stop.getMrBaseTplCd().equalsIgnoreCase(po.getMrBaseTplCd())){
							continue;
						}
						po_stop.setMrBaseTplStaCd(MrBaseTemplateStatus.STOPED);
						po_stop.setDelF(Short.valueOf("1"));
					}
					autoGenDao.batchUpdate(poList);
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
			MrBaseTpl po = autoGenDao.selectById(id);
			if(!MrBaseTemplateStatus.ACTIVED.equalsIgnoreCase(po.getMrBaseTplStaCd())){
				//非启用,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item ;
				failCount++ ;				
			}else{
				//进行正常操作
				po.setMrBaseTplStaCd(MrBaseTemplateStatus.STOPED);
				autoGenDao.update(po);
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
	 * 【基础模板】导航树
	 * @return 导航树
	 */
	/* (non-Javadoc)
	 * @see pkuhit.iih.mr.tpl.BaseTemplateService#tree()
	 */
	@Override
	public SingleResult<Map> tree(String keyWord) {
		//返回结果map
		Map mapResult= new HashMap();
		SingleResult<Map> result = new SingleResult<Map>();
		//院区或者医院名字
		String orgName = "" ;
		SimpleItem[] simpleItems = dictionaryService.getSimpleItems(Organization.OBJ_CD, getOrgCode());
		if(simpleItems.length > 0 && null != simpleItems[0] ){
			orgName = simpleItems[0].getText() ;
		}
		//organizationService.selectByCode(getOrgCode()).getData().getName();
		mapResult.put("orgCode", getOrgCode());
		mapResult.put("text", orgName);
		mapResult.put("expanded", Boolean.TRUE);
		//搜索所有的非删除的记录
		Map searchCondition= new HashMap();
		//查询包含停用
		searchCondition.put("excludeStop","0");
		searchCondition.put("orgCode",getOrgCode());
		searchCondition.put("name",keyWord);
		
		searchCondition.put("pageNum","1");
		searchCondition.put("pageSize","10000");
		
		//查询结果
		ArrayResult<MrBaseTemplate> arrayResultTemp = this.search(searchCondition);
		//开始过滤掉 停用的历史版本
		/*
		 * 当该记录为停用时，根据rootCode 获取最大版本号码
		 * 当该记录为最大版本，则显示。否则，不显示
		 * */
		MrBaseTemplate[] baseTemplatesTemp = arrayResultTemp.getDataList();
		List<BaseTemplateTreeModel> baseTemplateTreeModels =  new ArrayList<BaseTemplateTreeModel>();
		if(null != arrayResultTemp && baseTemplatesTemp.length > 0){
			for(int i = 0 ; i < baseTemplatesTemp.length ; i++){
				MrBaseTemplate baseTemplate = baseTemplatesTemp[i];
					//非停用的记录
				BaseTemplateTreeModel baseTemplateTreeModel = new BaseTemplateTreeModel();
				baseTemplateTreeModel.setId(baseTemplate.getCode());
				baseTemplateTreeModel.setCode(baseTemplate.getCode());//编码
				baseTemplateTreeModel.setFilePk(baseTemplate.getFilePk());//文件pk
				baseTemplateTreeModel.setStatusCode(baseTemplate.getStatusCode());//状态
				baseTemplateTreeModel.setText(baseTemplate.getName()+"（"+(getStatusName(baseTemplate.getStatusCode()))+"）");
				baseTemplateTreeModel.setNameWithStatus(baseTemplate.getName()+"（"+(getStatusName(baseTemplate.getStatusCode()))+"）");
				baseTemplateTreeModel.setLeaf(Boolean.TRUE);
				baseTemplateTreeModels.add(baseTemplateTreeModel);
			}
			mapResult.put("expanded", "true");		
			mapResult.put("children", baseTemplateTreeModels);
		}else{
			mapResult.put("expanded", "true");
			mapResult.put("children", null);
		}
		result.setData(mapResult);
		return result;
	}
	private String getOrgCode()
	{
		Session session = Session.get();
		String orgCode =  session.getOrgCd() ;//"SZLH";	//????全院， String orgCode = getOrgCodeByDept();
		return orgCode;
	}
	
	private String getStatusName(String statusCode)
	{
		
		SimpleItem[] simpleItems = dictionaryService.getSimpleItems(MrTemplateStatus.OBJ_CD, statusCode);
		String statusName = simpleItems[0].getText() ;
		log.debug( "statusCode:"+statusCode);
		log.debug( "statusName:"+statusName);
		return statusName;
/*		DataObject object = dataObjectService.getObject(GeneralData.OBJ_CD, statusCode);
		return object.getObject(GeneralData.class).getName();*/
	}
	
	@Override
	public SingleResult<Boolean> HasDuplicationOfName(String code,String name) {
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean isDuplicationOfName = Boolean.TRUE ;
		int count = this.cusDao.getCountOfName(code,name);
		if(count == 0){
			isDuplicationOfName =  Boolean.FALSE ; 
		}
		builder.withData(isDuplicationOfName);
		SingleResult<Boolean> rs = builder.build();
		return rs;
	}
}
