package pkuhit.iih.mr.wr;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.OptimisticLockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.MrAmrGroupDao;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.MrDocValueDao;
import pkuhit.iih.mr.dao.auto.MrSignDao;
import pkuhit.iih.mr.dao.auto.MrTplDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.dao.auto.entity.MrTpl;
import pkuhit.iih.mr.md.MrStatus;
import pkuhit.iih.mr.md.MrType;
import pkuhit.iih.mr.md.dao.auto.MdMrTpCcatDao;
import pkuhit.iih.mr.md.dao.auto.MdMrTpDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm;
import pkuhit.iih.mr.md.dao.custom.CusEmpDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatItmDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpDao;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.tpl.MrTemplateService;
import pkuhit.iih.mr.tpl.dao.CusTemplateDao;
import pkuhit.iih.mr.wr.dao.CusMrAmrDao;
import pkuhit.iih.mr.wr.dao.CusMrDao;
import pkuhit.iih.mr.wr.dao.CusMrDocValueDao;
import pkuhit.iih.mr.wr.dao.CusMrSignDao;
import pkuhit.iih.mr.wr.dao.CusQaItemMrTpDao;
import pkuhit.iih.pub.IihUtils;
import pkuhit.iih.pub.PerformancePrinter;
import pkuhit.md.DictionaryService;
import pkuhit.md.OwnerType;
import pkuhit.md.SysFunctionCode;
import pkuhit.me.DataObjectService;
import pkuhit.org.WorkGroupEmpService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.UserService;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.UUIDGenerator;

public class NsvMedocalRecordServiceImpl implements NsvMedocalRecordService {

	private Logger log = LoggerFactory.getLogger(NsvMedocalRecordServiceImpl.class);
	
//	@Reference
//	AmrService amrService;

	@Reference
	UserService userService;

	@Reference
	DataObjectService dataObjectService;

	@Reference
	DictionaryService dictionaryService;

	@Reference
	WorkGroupEmpService workGroupEmpService;

	// @Reference
	// ConfigItemDataService configItemDataService;

	@Reference
	SignUserService signUserService;

	@Reference
	MrTemplateService mrTemplateService;

	@Reference
	FileService fileService;

	@Reference
	ParamsService paramsService;
	
	@Reference
	ParamsSetService paramsSetService;
	
	@Autowired
	MrDao mrDao;

	@Autowired
	MdMrTpDao mdMrTpDao;

	@Autowired
	MrDocValueDao mrDocValueDao;

	@Autowired
	CusMrDocValueDao cusMrDocValueDao;

	@Autowired
	MrSignDao mrSignDao;

	@Autowired
	MdMrTpCcatDao mdMrTpCcatDao;

	@Autowired
	MrAmrDao mrAmrDao;

	@Autowired
	MrAmrGroupDao mrAmrGroupDao;

	@Autowired
	CusMrDao cusMrDao;

	@Autowired
	CusMdMrTpDao cusMdMrTpDao;

	@Autowired
	CusMrSignDao cusMrSignDao;

	@Autowired
	CusMdMrTpCcatDao cusMdMrTpCcatDao;

	@Autowired
	CusMdMrTpCcatItmDao cusMdMrTpCcatItmDao;

	@Autowired
	CusEmpDao cusEmpDao;

	@Autowired
	CusQaItemMrTpDao cusQaItemMrTpDao;

	@Autowired
	MrTplDao autoGenDao;

	@Autowired
	CusTemplateDao cusTemplateDao;

	@Autowired
	CusMrAmrDao cusMrAmrDao;
	
	@Reference
	OutMedicalRecordService outMedicalRecordService;
	
	
	@Transactional
	@Override
	public SingleResult<MedicalRecord> create(MedicalRecord value)throws Throwable {
		SingleResult<MedicalRecord> result;
		// 检查是否可新建
		//Amr amr = amrService.get(value.getEncounterPk()).getData();
		//actionCheck.checkCanCreate(value, amr, this);
		// 补全数据
		Mr mr = new Mr();
		BeanCopyUtil.modelToEntity(mr, value);
		mr.setMrPk(UUIDGenerator.getUUID());
		//mr.setEncounterSn(value.getEncounterPk());
		mr.setDeptCd(Session.get().getDeptId());
		mr.setBizTime(new Timestamp(value.getBizTime().getTime()));
		mr.setMrStaCd(MrStatus.CREATED);
		mr.setCompletedF(Short.valueOf("0"));
		mr.setPrintCount(0);
		// 字符大字段
		String fileData = value.getFileData();
		// 持久化
		log.debug("fileData is :" + fileData);
		log.debug("null=fileService is :"
				+ Boolean.valueOf(null == fileService));
		FileObject xmlFileObject = null;
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		try {
			xmlFileObject = fileService.createFile("biz", value
					.getXmlFileData().getBytes());
		} catch (Exception e) {
			log.error("业务文件发生错误：fileObject data :" + value.getXmlFileData()
					+ "错误信息如下：");
			e.printStackTrace();
		}
		mr.setXmlFilePk(xmlFileObject.getId());
		// 保存业务文件
		FileObject fileObject = null;
		try {
			fileObject = fileService.createFile("biz", fileData.getBytes());
		} catch (Exception e) {
			log.error("创建业务文件发生错误：fileObject data :" + fileData + "错误信息如下：");
			e.printStackTrace();
		}
		mr.setFilePk(fileObject.getId());
		log.debug("null=fileObject is :" + Boolean.valueOf(null == fileObject));
		if (null != fileObject) {
			log.debug("fileObject id is :" + fileObject.getId());
		}

		// 保存到MR表
		mrDao.insertExludeNull(mr);
		// 门诊暂时没有使用引用元素，先注释掉
		//saveDocValue(mr.getEnPk(), mr.getMrPk(), value.getReferenceElem());
		// 判断是否是新建时直接点的提交，如果是则调用提交服务
		if (MrStatus.SUBMITTED.equals(value.getStatusCode())) {
			result = outMedicalRecordService.sign(mr.getMrPk(), outMedicalRecordService.searchById(mr.getMrPk(), true).getData());
		} else {
			result = this.searchById(mr.getMrPk(), false);
		}
		return result;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.mr.wr.MedicalRecordService#delete(pkuhit.iih.mr.wr.MedicalRecord
	 * )
	 */
	@Transactional
	@Override
	public SingleResult<MedicalRecord> delete(String id, MedicalRecord value)
			throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(
					MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		String userId = session.getUserId();
		Mr mr = mrDao.selectById(id);
		//Amr amr = amrService.get(mr.getEnPk()).getData();
		// 检查是否可删除
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		MedicalRecord medicalRecord = result.getData();
		//actionCheck.checkCanDelete(medicalRecord, amr, userId);

		// 持久化
		mr.setDelF(Short.valueOf("1"));
		try {
			mrDao.markDelete(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		// 删除xmlfileData
		if (!StringUtils.isEmpty(medicalRecord.getXmlFilePk())) {
			fileService.deleteFile(medicalRecord.getXmlFilePk());
		}
		FileObject fileObject = null;
		try {
			fileObject = fileService.deleteFile(medicalRecord.getFilePk());
		} catch (Exception e) {
			log.error("调用文件服务删除文件发生错误，可能业务文件[" + medicalRecord.getFilePk()
					+ "]不存在,错误信息如下：");
			e.printStackTrace();
		}
		// 判断业务文件是否存在
		if (null == fileObject) {
			Notification msg = null;
			msg = new Notification(MessageCode.BIZ_FILE_NO_EXITS,
					medicalRecord.getFilePk());
			throw new NotificationException(msg);
		}
		// 返回被删除的记录
		return result;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.mr.wr.MedicalRecordService#update(pkuhit.iih.mr.wr.MedicalRecord
	 * )
	 */
	@Transactional
	@Override
	public SingleResult<MedicalRecord> update(String id, MedicalRecord value) throws Throwable {
		if (null == id||"".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		SingleResult<MedicalRecord> result;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		String userId = session.getUserId();
		//Amr amr = amrService.get(value.getEncounterPk()).getData();
//		Amr amr = amrService.get(value.getEncounterPk()).getData();
		MedicalRecord medicalRecord = this.searchById(id, false).getData();
		// 检查是否可更新
		Param[] params=paramsService.getParam(SysFunctionCode.MR_UPDATE_TIME_LIMIT_CONFIG).getDataList();
		//actionCheck.checkCanSave(medicalRecord, amr,userId, dataObjectService, params);
		// 持久化
		Mr mr = new Mr();
		BeanCopyUtil.modelToEntity(mr, value);
		
		FileObject xmlFileObject=null;	
		if(!StringUtils.isEmpty(mr.getXmlFilePk())){
			xmlFileObject=fileService.getFile(mr.getXmlFilePk());
		}
		//先将xmlFile加入bizFile表，将返回id加入mr表		
		if(!StringUtils.isEmpty(value.getXmlFileData())){
			try{
				if(xmlFileObject!=null){
					xmlFileObject = fileService.updateFile(xmlFileObject.getId(), value.getXmlFileData().getBytes());
				}else{
					xmlFileObject = fileService.createFile("biz", value.getXmlFileData().getBytes());
					mr.setXmlFilePk(xmlFileObject.getId());
				}
			}catch(Exception e){
				log.error("业务文件发生错误：fileObject data :" + value.getXmlFileData()+"错误信息如下：");
				e.printStackTrace();
			}
		}
		
		
		mr.setUpdCnt(value.getUpdateCount());
		log.debug("业务文件[" + value.getFilePk() + "],colb["+value.getFileData()+"]");
		if (null != value.getFileData() && value.getFileData().trim().length() > 0) {
			try {
				fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());
			} catch (Exception e) {
				log.error("调用文件服务修改文件发生错误，可能业务文件[" +value.getFileData() + "]不存在,错误信息如下：");
				e.printStackTrace();
			}
		}
		
		try{
			mrDao.updateExcludeNull(mr);
		}catch (OptimisticLockException e){
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		MedicalRecord returnData=this.searchById(value.getMrPk(), false).getData();
		builder.withData(returnData);
		result=builder.build();
		return result;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#searchById(java.lang.String)
	 */
	@Override
	public SingleResult<MedicalRecord> searchById(String id, boolean withFile) throws Throwable {
		if (null == id||"".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		String userId = session.getUserId();

		SingleResult<MedicalRecord> result;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		Mr mr = mrDao.selectById(id);
		if (null == mr) {
			Notification msg = null;
			msg = new Notification(MessageCode.BIZ_FILE_NO_EXITS, id);
			throw new NotificationException(msg);
		}
		// 查询就诊
		//Amr amr = amrService.get(mr.getEnPk()).getData();
//		if (null == amr) {
//			Notification notification = new Notification(MessageCode.AMR_NOT_EXITS, mr.getEnPk());
//			throw new NotificationException(notification);
//		}
		// 补全数据（用户名转用户名称）
		MedicalRecord medicalRecord = new MedicalRecord();
		PerformancePrinter.start("userIdToName");
		BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
		medicalRecord.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
		medicalRecord.setLastUpdateUserName(IihUtils.userIdToName(dataObjectService, mr.getLastUpdUserId()));
		medicalRecord.setSubmitName(IihUtils.userIdToName(dataObjectService, mr.getSubmitCd()));
		PerformancePrinter.end("userIdToName");
		PerformancePrinter.start("MrTemplate");
		MrTpl po = autoGenDao.selectById(mr.getMrTplCd());
		if(null!=po){
			medicalRecord.setTempleName(po.getNm());
		}
		PerformancePrinter.end("MrTemplate");
		//增加一列记录自定义类型组编码
		PerformancePrinter.start("mrTypeCustomCode");
		List<MdMrTpCcatItm> ccatItms = cusMdMrTpCcatItmDao.getMdMrTpCcatItmByTemplateType(medicalRecord.getTypeCode());
		String mrTypeCustomCode = "";
		for (MdMrTpCcatItm ccatItm : ccatItms) {
			if ("".equals(mrTypeCustomCode)) {
				mrTypeCustomCode = ccatItm.getMrTpCcatCd();
			}
		}
		PerformancePrinter.end("mrTypeCustomCode");
		medicalRecord.setMrTypeCustomCode(mrTypeCustomCode);
		if (withFile) {
			// 获取业务文件
			FileObject fileObject = null;
			try {
				if(null!=medicalRecord.getFilePk()){
					fileObject = fileService.getFile(medicalRecord.getFilePk());
				}
			} catch (Exception e) {
				log.error("调用文件服务获取文件发生错误，可能业务文件[" + medicalRecord.getFilePk() + "]不存在,错误信息如下：");
				e.printStackTrace();
			}
			// 判断业务文件是否存在
			if (null == fileObject) {
				Notification msg = null;
				msg = new Notification(MessageCode.BIZ_FILE_NO_EXITS, medicalRecord.getFilePk());
				throw new NotificationException(msg);
			}
			medicalRecord.setFileData(new String(fileObject.asByteArray()));
		}
		
		PerformancePrinter.start("getContinuePrintF");
		//增加是否可续打标识
		MdMrTpCcat mdMrTpCcat=mdMrTpCcatDao.selectById(mrTypeCustomCode);
		medicalRecord.setCanContinuePrint(mdMrTpCcat.getContinuePrintF());
		PerformancePrinter.end("getContinuePrintF");
		
		PerformancePrinter.start("getNewPageF");
		//增加是否新起一页打印标识
		MdMrTp mdMrTp=mdMrTpDao.selectById(mr.getMrTpCd());
		medicalRecord.setNewPageF(mdMrTp.getNewPageF());
		PerformancePrinter.end("getNewPageF");
		PerformancePrinter.start("setActionFlag");
		Param[] params=paramsService.getParam(SysFunctionCode.MR_UPDATE_TIME_LIMIT_CONFIG).getDataList();
		
		// 检查全部的5个操作标志，并赋予医疗记录对象
		//medicalRecord = actionCheck.setActionFlag(medicalRecord, amr,userId, dataObjectService,params,paramsService);
		PerformancePrinter.end("setActionFlag");
		if(medicalRecord.getCanErpSign()!=null&&medicalRecord.getCanErpSign()==1){
			//可修改签章
			if(medicalRecord.getCanEdit()==0){
				medicalRecord.setCanErpSign(0);
			}
		}
		builder.withData(medicalRecord);
		result = builder.build();
		return result;
	}
	


	/*
	 * (non-Javadoc)
	 * @see pkuhit.iih.mr.wr.OutMedicalRecordService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<MedicalRecord> search(Map<String, String> paramMap) throws Throwable {

		ArrayResult<MedicalRecord> result = null;
		ArrayResultBuilder<MedicalRecord> builder = ArrayResultBuilder.newArrayResult(MedicalRecord.class);
		List<MedicalRecord> listMr = new ArrayList<MedicalRecord>();
		String encounterPk = paramMap.get("encounterPk");
		String merge=paramMap.get("merge");
		if (null == encounterPk||"".equals(encounterPk.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊序号");
			throw new NotificationException(notification);
		}
		MrAmr mrAmr=mrAmrDao.selectById(encounterPk);
		String mrTypeCustomCode = paramMap.get("mrTypeCustomCode");
		List<String> mrTypeCustomCodes=new ArrayList<String>();
		//如果是合并显示的话，则查询门诊病历和病程记录类型组
		if("true".equals(merge)){
			mrTypeCustomCodes.add("MRM14.09");
			mrTypeCustomCodes.add("MRM14.03");
		}
		
		String mrTypeCode = paramMap.get("mrTypeCode");
		String withFile = paramMap.get("withFile");
		List<Mr> list = new ArrayList<Mr>();
		boolean amrGroupEnable=false;
		List<String> enPks=new ArrayList<String>();
		List<String> enTpCdList=new ArrayList<String>();
		enTpCdList.add(EncounterType.EMERGENCY);
		enTpCdList.add(EncounterType.OUTPATIENT);
		Param[] params=paramsService.getParam(SysFunctionCode.AMR_GROUP_ENABLE).getDataList();
		if(params.length>0){
			Param param=params[0];
			if("1".equals(param.getValue())){
				amrGroupEnable=true;
			}
		}
		
		//如果启用就诊组并且就诊类型为急诊则进行就诊组处理
		if(amrGroupEnable&&EncounterType.EMERGENCY.equals(mrAmr.getEnTpCd())&&null!=mrAmr.getMrAmrGroupCd()){
			List<MrAmr> amrs=cusMrAmrDao.selectMrAmrs(null, null,null, mrAmr.getEnTpCd(), mrAmr.getPaId(),mrAmr.getMrAmrGroupCd());
			for(MrAmr mrAmr2:amrs){
				enPks.add(mrAmr2.getEnPk());
			}
			if (mrTypeCustomCodes.size()>0) {
				list = cusMrDao.selectByEnPksForMerge(enPks, mrTypeCustomCodes);
			}else{
				list = cusMrDao.selectByEnPks(enPks,mrTypeCustomCode, mrTypeCode);
			}
		}else{
			if (mrTypeCustomCodes.size()>0) {
				list = cusMrDao.selectByEnPkForMerge(encounterPk, mrTypeCustomCodes);
			}else{
				list = cusMrDao.selectByEnPk(encounterPk, mrTypeCustomCode, mrTypeCode,null,0,null);
			}
		}
		
		if (list == null)
			return null;
		// 此处有循环调用，需要控制记录条数，否则影响性能
		for (Mr mr : list) {
			MedicalRecord medicalRecord = new MedicalRecord();
			BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
			medicalRecord.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
			medicalRecord.setLastUpdateUserName(IihUtils.userIdToName(dataObjectService, mr.getLastUpdUserId()));
			//是否查询文件
			if (null != withFile && ("1".equals(withFile)||"true".equals(withFile))) {
				// 获取业务文件
				FileObject fileObject = null;
				try {
					fileObject = fileService.getFile(medicalRecord.getFilePk());
				} catch (Exception e) {
					log.error("调用文件服务获取文件发生错误，可业务文件[" + medicalRecord.getFilePk() + "]不存在,错误信息如下：");
					e.printStackTrace();
				}
				// 判断业务文件是否存在
				if (null == fileObject) {
					Notification msg = null;
					msg = new Notification(MessageCode.BIZ_FILE_NO_EXITS, medicalRecord.getFilePk());
					throw new NotificationException(msg);
				}
				medicalRecord.setFileData(new String(fileObject.asByteArray()));
			}
			listMr.add(medicalRecord);
		}
		if (listMr.size() > 0) {
			builder.withData(listMr.toArray(new MedicalRecord[0]));
		}
		result = builder.build();
		result.setTotal(listMr.size());
		return result;
	}

	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SingleResult<Map> nsvDocTree(Map<String, String> condition) throws Throwable {
		// 返回结果map
				Map mapResult = new HashMap();
				SingleResult<Map> result = new SingleResult<Map>();
				mapResult.put("text", "root");
//				String encounterPk = condition.get("encounterPk");
//				Amr amr = amrService.get(encounterPk).getData();
				String showAllCourse = condition.get("showAllCourse");
				//就诊状态
				String enTpCd = EncounterType.INPATIENT;
				List<MdMrTpCcat> mdMrTpCcatList = cusMdMrTpCcatDao.selectMrDocTree(enTpCd,null,2);
				List<Map> mapChilds = new ArrayList<Map>();
				if (null != mdMrTpCcatList && mdMrTpCcatList.size() > 0) {
					//显示合并病历项
//					Map mapMerge = new HashMap();
//					mapMerge.put("merge", "merge");
//					mapMerge.put("id", "merge");
//					mapMerge.put("text", "合并病历");
//					mapMerge.put("leaf", true);
//					mapChilds.add(mapMerge);
					
					for (int i = 0; i < mdMrTpCcatList.size(); i++) {
						// 得到分类下的文书列表
						List<Map<String, Object>> mrlist = cusMrDao.selectMrByEnPk(null, mdMrTpCcatList.get(i).getMrTpCcatCd(), null,null);

						Map mapChild = new HashMap();
						String mrTpCcatCd=mdMrTpCcatList.get(i).getMrTpCcatCd();
						String mdMrTpCcatNm=mdMrTpCcatList.get(i).getNm();
						mapChild.put("ccatCode", mrTpCcatCd);
						mapChild.put("id", mrTpCcatCd);
						mapChild.put("text", mdMrTpCcatNm);
						
						List<Map> mrMaps = new ArrayList<Map>();
						
						DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						if (mrlist.size() > 0) {
							if("1".equals(showAllCourse)){/*
								MdMrTpCcat mdMrTpCcat=mdMrTpCcatDao.selectById(mrTpCcatCd);
								if(1==mdMrTpCcat.getContinuePrintF()){
									Map mrMap = new HashMap();
									mrMap.put("mrTpCcatCd", mrTpCcatCd);
									mrMap.put("text", "全部"+mdMrTpCcat.getNm());
									mrMap.put("leaf", true);
									mrMaps.add(mrMap);
								}*/
							}
							for (int j = 0; j < mrlist.size(); j++) {
							    //得到文书业务时间，转换格式
							    Object crtTime = mrlist.get(j).get("BIZ_TIME");
							    String timeStr = sdf.format(crtTime);
							    String mrPk = (String) mrlist.get(j).get("MR_PK");
							    
							    MedicalRecord medicalRecord=this.searchById(mrPk, false).getData();
							    
							    medicalRecord.setMrTypeCustomCode(mrTpCcatCd);
								Map mrMap = IihUtils.convertBean(medicalRecord);
								mrMap.put("text", mrlist.get(j).get("NM")+"_"+timeStr+"_"+mrlist.get(j).get("USER_NM"));
								mrMap.put("leaf", true);
								mrMap.put("id", medicalRecord.getMrPk());
								mrMaps.add(mrMap);
							}
							mapChild.put("children", mrMaps);
						} else {
							mapChild.put("leaf", true);
						}
						mapChilds.add(mapChild);
					}
					mapResult.put("expanded", "true");
					mapResult.put("children", mapChilds);
				}
				result.setData(mapResult);
				return result;
	}
    
	@Override
	public SingleResult<MedicalRecord> sign(String id, MedicalRecord value)
			throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(
					MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();

		//Amr amr = amrService.get(value.getEncounterPk()).getData();
		//System.out.println(value.getEncounterPk() + amr.getAmrNo());
		// 检查是否可以签名
		//actionCheck.checkCanSign(value, amr, userId, dataObjectService);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData()
				.getBytes());
		
		Timestamp date = new Timestamp(System.currentTimeMillis());
		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		// 设置医疗记录状态为已提交
		mr.setMrStaCd(MrStatus.SUBMITTED);
		// 设置提交人
		mr.setSubmitCd(userId);
		// 设置提交时间
		mr.setSubmitDate(date);
		// 首次提交设置逻辑提交时间
		if (null == mr.getLgcSmtTime()) {
			mr.setLgcSmtTime(date);
		}
		FileObject xmlFileObject=null;
		if(!StringUtils.isEmpty(mr.getXmlFilePk())){
			xmlFileObject=fileService.getFile(mr.getXmlFilePk());
		}
		//先将xmlFile加入bizFile表，将返回id加入mr表		
		if(!StringUtils.isEmpty(value.getXmlFileData())){
			try{
				if(xmlFileObject!=null){
					xmlFileObject = fileService.updateFile(xmlFileObject.getId(), value.getXmlFileData().getBytes());
				}else{
					xmlFileObject = fileService.createFile("biz", value.getXmlFileData().getBytes());
				}
			}catch(Exception e){
				log.error("业务文件发生错误：fileObject data :" + value.getXmlFileData()+"错误信息如下：");
				e.printStackTrace();
			}
		}
		mr.setXmlFilePk(xmlFileObject.getId());
		
		// 设置完成标志
		// if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLvlCd())) {
		// 当提交后，如果医疗记录审签等级为一级审签，则不需要继续进行审签
		mr.setCompletedF(Short.valueOf("1"));
		// }
		// mr.setUpdCnt(value.getUpdateCount());
		
		//判断是否保存病历的Pdf
		String param= paramsSetService.searchFunFlagByKey("OMR_SAVE_YESNO_PDF").getData();
		FileObject mrPdfFileObject=null;
		if(!StringUtils.isEmpty(mr.getCaFilePk())){
			mrPdfFileObject=fileService.getFile(mr.getCaFilePk());
		}
		if(!StringUtils.isBlank(param)&&param.equals("1")&&!StringUtils.isBlank(value.getMrPdfData())){
			try{
				if(mrPdfFileObject!=null){
					mrPdfFileObject = fileService.updateFile(mrPdfFileObject.getId(), value.getMrPdfData().getBytes());
				}else{
					mrPdfFileObject = fileService.createFile("biz",value.getMrPdfData().getBytes());
				}
			}catch(Exception e){
				log.error("业务文件发生错误：mrPdfData data :" + value.getMrPdfData()+"错误信息如下：");
				e.printStackTrace();
			}
			mr.setCaFilePk(mrPdfFileObject.getId());
		}
		// 持久化
		try {
			mrDao.updateExcludeNull(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		
		// 保存引用元素
//		saveDocValue(value.getEncounterPk(), value.getMrPk(),
//				value.getReferenceElem());
		// 返回最新的医疗记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		return result;
	}
	

}
