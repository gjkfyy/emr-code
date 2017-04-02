package pkuhit.iih.mr.wr;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.OptimisticLockException;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.MrToCisService;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.MrAmrGroupDao;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.MrDocValueDao;
import pkuhit.iih.mr.dao.auto.MrPrintOpLogDao;
import pkuhit.iih.mr.dao.auto.MrSignDao;
import pkuhit.iih.mr.dao.auto.MrTplDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.dao.auto.entity.MrDocValue;
import pkuhit.iih.mr.dao.auto.entity.MrPrintOpLog;
import pkuhit.iih.mr.dao.auto.entity.MrTpl;
import pkuhit.iih.mr.md.MrStatus;
import pkuhit.iih.mr.md.MrType;
import pkuhit.iih.mr.md.MrTypeCustomCategory;
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
import pkuhit.org.Employee;
import pkuhit.org.WorkGroupEmpService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.User;
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
import ei.cis.service.CisSignPicService;

public class OutMedicalRecordServiceImpl implements OutMedicalRecordService {

	private Logger log = LoggerFactory.getLogger(OutMedicalRecordServiceImpl.class);
	@Reference
	AmrService amrService;

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
	
	@Reference
	CisSignPicService cisSignPicService;

	@Autowired
	MrDao mrDao;

	@Autowired
	MrPrintOpLogDao mrPrintOpLogDao;
	
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
	MrToCisService mrToCisService;

	private OutMrActionCheck actionCheck = new OutMrActionCheck();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.mr.wr.MedicalRecordService#create(pkuhit.iih.mr.wr.MedicalRecord
	 * )
	 */
	@Transactional
	@Override
	public SingleResult<MedicalRecord> create(MedicalRecord value) throws Throwable {
		SingleResult<MedicalRecord> result;
		// 检查是否可新建
//		Amr amr = amrService.get(value.getEncounterPk()).getData();
//		actionCheck.checkCanCreate(value, amr, this);
		// 补全数据
		Mr mr = new Mr();
		BeanCopyUtil.modelToEntity(mr, value);
		mr.setMrPk(UUIDGenerator.getUUID());
		mr.setEncounterSn(value.getEncounterPk());
		mr.setDeptCd(Session.get().getDeptId());
		if (value.getTimeAutoGenerated() != null && value.getTimeAutoGenerated().equals("1")) {// 树模板新建查房病历
			String time = cusMrAmrDao.selectOracleDate();
			mr.setBizTime(Timestamp.valueOf(time));
		} else {
			mr.setBizTime(new Timestamp(value.getBizTime().getTime()));
		}
		mr.setMrStaCd(MrStatus.CREATED);
		mr.setCompletedF(Short.valueOf("0"));
		mr.setPrintCount(0);
		// 字符大字段
		String fileData = value.getFileData();
		// 持久化
		log.debug("fileData is :" + fileData);
		log.debug("null=fileService is :" + Boolean.valueOf(null == fileService));
		FileObject xmlFileObject = null;
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		try {
			xmlFileObject = fileService.createFile("biz", value.getXmlFileData().getBytes());
		} catch (Exception e) {
			log.error("业务文件发生错误：fileObject data :" + value.getXmlFileData() + "错误信息如下：");
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

		// 判断是否保存病历的Pdf
		String param = paramsSetService.searchFunFlagByKey("OMR_SAVE_YESNO_PDF").getData();
		if (!StringUtils.isBlank(param) && param.equals("1") && !StringUtils.isBlank(value.getMrPdfData())) {
			String pdfFilePk= IihUtils.updateMrBizFile(mr.getCaFilePk(),value.getMrPdfData(),fileService);
			if(!StringUtils.isEmpty(pdfFilePk))
			mr.setCaFilePk(pdfFilePk);
		}

		// 保存到MR表
		mrDao.insertExludeNull(mr);
		// 门诊暂时没有使用引用元素，先注释掉
//		saveDocValue(mr.getEnPk(), mr.getMrPk(), value.getReferenceElem());
		// 判断是否是新建时直接点的提交，如果是则调用提交服务
		if (MrStatus.SUBMITTED.equals(value.getStatusCode())) {
			result = this.sign(mr.getMrPk(), this.searchById(mr.getMrPk(), true).getData());
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
	public SingleResult<MedicalRecord> delete(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		String userId = session.getUserId();
		Mr mr = mrDao.selectById(id);
		Amr amr = amrService.get(mr.getEnPk()).getData();
		// 检查是否可删除
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		MedicalRecord medicalRecord = result.getData();
		actionCheck.checkCanDelete(medicalRecord, amr, userId);

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
			log.error("调用文件服务删除文件发生错误，可能业务文件[" + medicalRecord.getFilePk() + "]不存在,错误信息如下：");
			e.printStackTrace();
		}
		// 判断业务文件是否存在
		if (null == fileObject) {
			Notification msg = null;
			msg = new Notification(MessageCode.BIZ_FILE_NO_EXITS, medicalRecord.getFilePk());
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
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		SingleResult<MedicalRecord> result;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		String userId = session.getUserId();
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		// Amr amr = amrService.get(value.getEncounterPk()).getData();
		MedicalRecord medicalRecord = this.searchById(id, false).getData();
		// 检查是否可更新
		Param[] params = paramsService.getParam(SysFunctionCode.MR_UPDATE_TIME_LIMIT_CONFIG).getDataList();
		actionCheck.checkCanSave(medicalRecord, amr, userId, dataObjectService, params, paramsSetService);
		// 持久化
		Mr mr = new Mr();
		BeanCopyUtil.modelToEntity(mr, value);
		mr.setUpdCnt(value.getUpdateCount());
		log.debug("业务文件[" + value.getFilePk() + "],colb[" + value.getFileData() + "]");
		if (null != value.getFileData() && value.getFileData().trim().length() > 0) {
			try {
				fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());
			} catch (Exception e) {
				log.error("调用文件服务修改文件发生错误，可能业务文件[" + value.getFileData() + "]不存在,错误信息如下：");
				e.printStackTrace();
			}
		}
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		String xmlFilePk= IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
		if(!StringUtils.isEmpty(xmlFilePk))
		mr.setXmlFilePk(xmlFilePk);
		// 判断是否保存病历的Pdf
		String param = paramsSetService.searchFunFlagByKey("OMR_SAVE_YESNO_PDF").getData();
		if (!StringUtils.isBlank(param) && param.equals("1") && !StringUtils.isBlank(value.getMrPdfData())) {
			String pdfFilePk= IihUtils.updateMrBizFile(mr.getCaFilePk(),value.getMrPdfData(),fileService);
			if(!StringUtils.isEmpty(pdfFilePk))
			mr.setCaFilePk(pdfFilePk);
		}
		try {
			mrDao.updateExcludeNull(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		// 门诊暂时没有使用引用元素，先注释掉
		saveDocValue(value.getEncounterPk(), value.getMrPk(), value.getReferenceElem());
		MedicalRecord returnData = this.searchById(value.getMrPk(), false).getData();
		builder.withData(returnData);
		result = builder.build();
		return result;
	}

	/**
	 * 保存引用元素前参数验证
	 * 
	 * @param enPk
	 * @param mrPk
	 * @param elemValue
	 * @return
	 */
	public boolean saveDocValue(String enPk, String mrPk, Map<String, Object> elemValue) {
		if ("".equals(enPk) || "".equals(mrPk)) {
			log.error("就诊流水号或文档编码为空");
			return false;
		}
		if (elemValue != null) {
			saveMrbMrDocValueData(enPk, mrPk, elemValue);
			return true;
		} else {
			log.warn("就诊序号" + enPk + ":文书序号：" + mrPk + "引用元素列表为空");
			return false;
		}
	}

	/**
	 * 保存引用元素
	 * 
	 * @param enPk
	 * @param mrPk
	 * @param elemValue
	 */
	public void saveMrbMrDocValueData(String enPk, String mrPk, Map<String, Object> elemValue) {

		MrDocValue mrDocValue = null;

		Iterator<Map.Entry<String, Object>> it = elemValue.entrySet().iterator();
		// int n = 0;
		while (it.hasNext()) {
			// n++;
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) it.next();
			if (!"".equals(entry.getKey().toString())) {
				String mrbMrDocValueId = existMrbMrDocValueData(enPk, mrPk, entry.getKey().toString());
				if ("".equals(mrbMrDocValueId)) {
					mrDocValue = new MrDocValue();
					mrbMrDocValueId = UUIDGenerator.getUUID();
					mrDocValue.setMrbMrDocValueId(mrbMrDocValueId);
					mrDocValue.setEncounterSn(enPk);
					mrDocValue.setMrDocSn(mrPk);
					mrDocValue.setDataElementId(entry.getKey().toString());
					mrDocValue.setValue(entry.getValue().toString());
					mrDocValueDao.insertExludeNull(mrDocValue);
				} else {
					mrDocValue = mrDocValueDao.selectById(mrbMrDocValueId);
					mrDocValue.setEncounterSn(enPk);
					mrDocValue.setMrDocSn(mrPk);
					mrDocValue.setDataElementId(entry.getKey().toString());
					mrDocValue.setValue(entry.getValue().toString());
					mrDocValueDao.updateExcludeNull(mrDocValue);
				}
			}
		}
	}

	/**
	 * 查询数据库是否存在该引用元素，存在折返回该引用元素的值，否则返回""
	 * 
	 * @param enPk
	 * @param mrPk
	 * @param elemId
	 * @return
	 */
	public String existMrbMrDocValueData(String enPk, String mrPk, String elemId) {
		String strId = "";
		List<MrDocValue> mrDocValueList = cusMrDocValueDao.selectByEnPkAndMrPkAndElemId(enPk, null, elemId);
		if (mrDocValueList != null) {
			if (mrDocValueList.size() > 0)
				strId = mrDocValueList.get(0).getMrbMrDocValueId().toString();
		}
		return strId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.OutMedicalRecordService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<MedicalRecord> search(Map<String, String> paramMap) throws Throwable {

		ArrayResult<MedicalRecord> result = null;
		ArrayResultBuilder<MedicalRecord> builder = ArrayResultBuilder.newArrayResult(MedicalRecord.class);
		List<MedicalRecord> listMr = new ArrayList<MedicalRecord>();
		String encounterPk = paramMap.get("encounterPk");
		String merge = paramMap.get("merge");
		if (null == encounterPk || "".equals(encounterPk.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊序号");
			throw new NotificationException(notification);
		}
		MrAmr mrAmr = mrAmrDao.selectById(encounterPk);
		String mrTypeCustomCode = paramMap.get("mrTypeCustomCode");
		List<String> mrTypeCustomCodes = new ArrayList<String>();
		// 如果是合并显示的话，则查询门诊病历和病程记录类型组
		if ("true".equals(merge)) {
			mrTypeCustomCodes.add("MRM14.09");
			mrTypeCustomCodes.add("MRM14.03");
		}

		String mrTypeCode = paramMap.get("mrTypeCode");
		String withFile = paramMap.get("withFile");
		List<Mr> list = new ArrayList<Mr>();
		boolean amrGroupEnable = false;
		List<String> enPks = new ArrayList<String>();
		List<String> enTpCdList = new ArrayList<String>();
		enTpCdList.add(EncounterType.EMERGENCY);
		enTpCdList.add(EncounterType.OUTPATIENT);
		Param[] params = paramsService.getParam(SysFunctionCode.AMR_GROUP_ENABLE).getDataList();
		if (params.length > 0) {
			Param param = params[0];
			if ("1".equals(param.getValue())) {
				amrGroupEnable = true;
			}
		}

		// 如果启用就诊组并且就诊类型为急诊则进行就诊组处理
		if (amrGroupEnable && EncounterType.EMERGENCY.equals(mrAmr.getEnTpCd()) && null != mrAmr.getMrAmrGroupCd()) {
			List<MrAmr> amrs = cusMrAmrDao.selectMrAmrs(null, null, null, mrAmr.getEnTpCd(), mrAmr.getPaId(),
					mrAmr.getMrAmrGroupCd());
			for (MrAmr mrAmr2 : amrs) {
				enPks.add(mrAmr2.getEnPk());
			}
			if (mrTypeCustomCodes.size() > 0) {
				list = cusMrDao.selectByEnPksForMerge(enPks, mrTypeCustomCodes);
			} else {
				list = cusMrDao.selectByEnPks(enPks, mrTypeCustomCode, mrTypeCode);
			}
		} else {
			if (mrTypeCustomCodes.size() > 0) {
				list = cusMrDao.selectByEnPkForMerge(encounterPk, mrTypeCustomCodes);
			} else {
				list = cusMrDao.selectByEnPk(encounterPk, mrTypeCustomCode, mrTypeCode, null, 1,null);
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
			// 是否查询文件
			if (null != withFile && ("1".equals(withFile) || "true".equals(withFile))) {
				// 获取业务文件
				FileObject fileObject = null;
				try {
					fileObject = fileService.getFile(medicalRecord.getFilePk());
				} catch (Exception e) {
					log.error("调用文件服务获取文件发生错误，可业务文件[" + medicalRecord.getFilePk() + "]不存在,错误信息如下："
							+ e.getLocalizedMessage());
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

   // 国际康复使用 患者病历列表
	@Override
	public ArrayResult<MedicalRecord> search2(String enPk,Map<String, String> params) throws Throwable {
		String pageNum = null;
		String pageSize = null;
		if (params.containsKey("pageNum") && params.containsKey("pageSize")) {
			pageNum = (String) params.get("pageNum");
			pageSize = (String) params.get("pageSize");
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(pageNum)) {
			pageNum = "1";
		}
		if (org.apache.commons.lang3.StringUtils.isBlank(pageSize)) {
			pageSize = "20";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize))
				.limit(Integer.valueOf(pageSize)).count();
		
		ArrayResult<MedicalRecord> result = null;
		ArrayResultBuilder<MedicalRecord> builder = ArrayResultBuilder.newArrayResult(MedicalRecord.class);
		List<MedicalRecord> listMr = new ArrayList<MedicalRecord>();
		List<Mr> list = new ArrayList<Mr>();
		list = cusMrDao.selectByEnPkForEmergencyMrNumber(enPk);
		// 此处有循环调用，需要控制记录条数，否则影响性能
		if(list != null && list.size() > 0){
				MedicalRecord[] mrList = new MedicalRecord[list.size()];
				int i = 0;
				for (Mr mr : list) {
					MedicalRecord medicalRecord = new MedicalRecord();
					BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
					medicalRecord.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
					medicalRecord.setLastUpdateUserName(IihUtils.userIdToName(dataObjectService, mr.getLastUpdUserId()));
					//文件注释  lz修改
 					// 是否查询文件
					/*if (null != withFile && ("1".equals(withFile) || "true".equals(withFile))) {
						// 获取业务文件
						FileObject fileObject = null;
						try {
							fileObject = fileService.getFile(medicalRecord.getFilePk());
						} catch (Exception e) {
							log.error("调用文件服务获取文件发生错误，可业务文件[" + medicalRecord.getFilePk() + "]不存在,错误信息如下："
									+ e.getLocalizedMessage());
							e.printStackTrace();
						}
						// 判断业务文件是否存在
						if (null == fileObject) {
							Notification msg = null;
							msg = new Notification(MessageCode.BIZ_FILE_NO_EXITS, medicalRecord.getFilePk());
							throw new NotificationException(msg);
						}
						medicalRecord.setFileData(new String(fileObject.asByteArray()));
					}*/
					mrList[i] = medicalRecord;
					i++;
					listMr.add(medicalRecord);
				}
				builder.withData(mrList);
		}
		result = builder.build();
		result.setTotal(Integer.valueOf(options.getCount()+""));
		return result;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#searchById(java.lang.String)
	 */
	@Override
	public SingleResult<MedicalRecord> searchById(String id, boolean withFile) throws Throwable {
		if (null == id || "".equals(id.trim())) {
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
		// PerformancePrinter.start("amrService.get");
//		Amr amr = amrService.get(mr.getEnPk()).getData();
		// PerformancePrinter.end("amrService.get");
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
		// medicalRecord.setSuperiorDoctorName(IihUtils.userIdToName(dataObjectService,
		// medicalRecord.getSuperiorDoctorId()));
		// medicalRecord.setTreatDoctorName(IihUtils.userIdToName(dataObjectService,
		// medicalRecord.getTreatDoctorCd()));
		// medicalRecord.setMasterDoctorName(IihUtils.userIdToName(dataObjectService,
		// mr.getMastDoctorCd()));
		// medicalRecord.setDirDoctorName(IihUtils.userIdToName(dataObjectService,
		// medicalRecord.getDirDoctorCd()));
		PerformancePrinter.end("userIdToName");
		PerformancePrinter.start("MrTemplate");
		MrTpl po = autoGenDao.selectById(mr.getMrTplCd());
		if (null != po) {
			medicalRecord.setTempleName(po.getNm());
		}
		PerformancePrinter.end("MrTemplate");
		// 增加一列记录自定义类型组编码
		PerformancePrinter.start("mrTypeCustomCode");
		List<MdMrTpCcatItm> ccatItms = cusMdMrTpCcatItmDao.getOutMdMrTpCcatItmByTemplateType(medicalRecord
				.getTypeCode());
		String mrTypeCustomCode = "";
		for (MdMrTpCcatItm ccatItm : ccatItms) {
			if ("".equals(mrTypeCustomCode)) {
				mrTypeCustomCode = ccatItm.getMrTpCcatCd();
			}/*
			 * else { mrTypeCustomCode = mrTypeCustomCode + "," +
			 * ccatItm.getMrTpCcatCd(); }
			 */
		}
		PerformancePrinter.end("mrTypeCustomCode");
		medicalRecord.setMrTypeCustomCode(mrTypeCustomCode);
		// medicalRecord.setUserSignLevelCode(userSignLevelCode);
		if (withFile) {
			// 获取业务文件
			FileObject fileObject = null;
			FileObject caFileObject = null;
			try {
				if (null != medicalRecord.getFilePk()) {
					fileObject = fileService.getFile(medicalRecord.getFilePk());
				}
				if (null != medicalRecord.getCaFilePk()) {
					caFileObject = fileService.getFile(medicalRecord.getCaFilePk());
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
			if (null != caFileObject) {
				medicalRecord.setCaFileData(new String(caFileObject.asByteArray()));
				medicalRecord.setCanErpSign(0);
			} else {
				medicalRecord.setCanErpSign(1);
			}
			medicalRecord.setFileData(new String(fileObject.asByteArray()));
		}

		PerformancePrinter.start("getContinuePrintF");
		// 增加是否可续打标识
		MdMrTpCcat mdMrTpCcat = mdMrTpCcatDao.selectById(mrTypeCustomCode);
		//medicalRecord.setCanContinuePrint(mdMrTpCcat.getContinuePrintF());
		PerformancePrinter.end("getContinuePrintF");

		PerformancePrinter.start("getNewPageF");
		// 增加是否新起一页打印标识
		MdMrTp mdMrTp = mdMrTpDao.selectById(mr.getMrTpCd());
		medicalRecord.setNewPageF(mdMrTp.getNewPageF());
		PerformancePrinter.end("getNewPageF");
		PerformancePrinter.start("setActionFlag");
		Param[] params = paramsService.getParam(SysFunctionCode.MR_UPDATE_TIME_LIMIT_CONFIG).getDataList();

		// 检查全部的5个操作标志，并赋予医疗记录对象
//		medicalRecord = actionCheck.setActionFlag(medicalRecord, amr, userId, dataObjectService, params, paramsService,
//				paramsSetService);
		PerformancePrinter.end("setActionFlag");
		if (medicalRecord.getCanErpSign() != null && medicalRecord.getCanErpSign() == 1) {
			// 可修改签章
			if (medicalRecord.getCanEdit() == 0) {
				medicalRecord.setCanErpSign(0);
			}
		}
		// medicalRecord.setAmr(amr);
		builder.withData(medicalRecord);
		result = builder.build();
		return result;
	}

	public MedicalRecord searchByMrPk(String id, Amr amr) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();

		Mr mr = mrDao.selectById(id);
		// 补全数据（用户名转用户名称）
		MedicalRecord medicalRecord = new MedicalRecord();
		BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
		Param[] params = paramsService.getParam(SysFunctionCode.MR_UPDATE_TIME_LIMIT_CONFIG).getDataList();
		// 检查全部的5个操作标志，并赋予医疗记录对象
		medicalRecord = actionCheck.setActionFlag(medicalRecord, amr, userId, dataObjectService, params, paramsService,
				paramsSetService);
		return medicalRecord;
	}

	/**
	 * 根据就诊类型查询对应医疗记录自定义分类
	 * 
	 * @param enTypeCd
	 * @return
	 */
	public List<MrTypeCustomCategory> getMrTypeCustomCategorysByEnTypeCd(String enTypeCd) {

		List<MrTypeCustomCategory> mrTypeCustomCategorys = new ArrayList<MrTypeCustomCategory>();
		List<MdMrTpCcat> mdMrTpCcats = cusMdMrTpCcatDao.selectByEnTpCd(enTypeCd, 1);
		for (MdMrTpCcat mdMrTpCcat : mdMrTpCcats) {
			MrTypeCustomCategory mrTypeCustomCategory = new MrTypeCustomCategory();
			BeanCopyUtil
					.entityToModel(mrTypeCustomCategory, mdMrTpCcat, MrTypeCustomCategory.OBJ_CD, dictionaryService);
			mrTypeCustomCategorys.add(mrTypeCustomCategory);
		}
		return mrTypeCustomCategorys;
	}

	/**
	 * 根据就诊类型查询对应医疗记录类型
	 * 
	 * @param enTypeCd
	 * @return
	 */
	public ArrayResult<MrType> getMrTypesByMrTypeCustomCategoryCd(Map<String, String> value) {

		ArrayResult<MrType> result = null;
		List<MrType> mrTypes = new ArrayList<MrType>();
		ArrayResultBuilder<MrType> builder = ArrayResultBuilder.newArrayResult(MrType.class);
		String mrTpCcatCd = value.get("mrTypeCustomCategoryCd");
		String enTypeCd = value.get("enTypeCd");
		List<MdMrTp> mdMrTypes = cusMdMrTpDao.selectByEnTpCd(enTypeCd, mrTpCcatCd);
		for (MdMrTp mdMrTp : mdMrTypes) {
			MrType mrType = new MrType();
			BeanCopyUtil.entityToModel(mrType, mdMrTp, MrType.OBJ_CD, dictionaryService);
			mrTypes.add(mrType);
		}
		if (mdMrTypes.size() > 0) {
			builder.withData(mrTypes.toArray(new MrType[0]));
		}
		result = builder.build();
		return result;
	}

	/**
	 * 根据角色编码和工作组编码查询上级医师
	 * 
	 * @param enTypeCd
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Employee> getSuperDoctors(String deptCd) {

		List<Map<String, Object>> maps = cusEmpDao.selectByDeptCdAndJobTitleCd(deptCd);
		List<Employee> employees = new ArrayList<Employee>();
		for (Map map : maps) {
			Employee employee = new Employee();
			BeanCopyUtil.mapToModel(employee, map, dictionaryService);
			employees.add(employee);
		}
		return employees;
	}

	/**
	 * 根据角色编码和工作组编码查询上级医师
	 * 
	 * @param enTypeCd
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Employee> getApproveDoctors(String deptCd, String signLvlCd) {

		List<Map<String, Object>> maps = cusEmpDao.selectByDeptCdAndSignLvlCd(deptCd, signLvlCd);
		List<Employee> employees = new ArrayList<Employee>();
		for (Map map : maps) {
			Employee employee = new Employee();
			BeanCopyUtil.mapToModel(employee, map, dictionaryService);
			employees.add(employee);
		}
		return employees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#canCreate(pkuhit.iih.mr.wr.
	 * MedicalRecord)
	 */
	@Override
	public SingleResult<MedicalRecord> canCreate(MedicalRecord value) throws Throwable {

		String mrTypeCode = value.getTypeCode();
		String encounterPk = value.getEncounterPk();
		if(null ==encounterPk){
			encounterPk="0001";
		}
		if (null == mrTypeCode) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "mrTypeCode【医疗记录类型编码】");
			throw new NotificationException(notification);
		}
		if (null == encounterPk) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "encounterPk【就诊序号】");
			throw new NotificationException(notification);
		}
		SingleResult<MedicalRecord> result = null;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		// 检查是否可新建 
		 // lizheng start
		//Amr amr = amrService.get(value.getEncounterPk()).getData();
		//actionCheck.checkCanCreate(value, amr, this);
		// Notification msg=actionCheck.checkCanCreateMessage(value, this);
		//lizheng end
		value.setCanCreate(1);
		// if (msg != null){
		// value.setCanCreate(0);
		// throw new NotificationException(msg);
		// }
		builder.withData(value);
		result = builder.build();
		return result;
	}

	/**
	 * 获取指定元素id的引用元素值
	 * 
	 * @param enPk
	 * @param elemIdList
	 * @return
	 */
	@SuppressWarnings("unused")
	private MrElemValue[] getDocValue(String enPk, List<String> elemIdList) {
		MrElemValue[] elemValues = new MrElemValue[0];
		List<MrElemValue> elemValueList = new ArrayList<MrElemValue>();
		if (elemIdList != null && !"".equals(enPk)) {
			if (elemIdList.size() > 0) {
				for (int i = 0; i < elemIdList.size(); i++) {
					List<MrDocValue> list = cusMrDocValueDao
							.selectByEnPkAndMrPkAndElemId(enPk, null, elemIdList.get(i));
					for (MrDocValue mrDocValue : list) {
						this.addToList(mrDocValue, elemValueList);
					}
				}
			}
		}
		if (elemValueList.size() > 0) {
			elemValues = elemValueList.toArray(new MrElemValue[0]);
		}
		return elemValues;
	}

	// 增加去重复逻辑，如果有重复取最后更新时间最新的那条
	private boolean addToList(MrDocValue mrDocValue, List<MrElemValue> elemValueList) {
		boolean flag = true;
		for (int i = 0; i < elemValueList.size(); i++) {
			MrElemValue elem = elemValueList.get(i);
			if (mrDocValue.getDataElementId().equals(elem.getDataElementId())) {
				if (mrDocValue.getLastUpdTime().getTime() < elem.getLastUpdateTime().getTime()) {
					flag = false;
				}
			}
		}
		if (flag) {
			MrElemValue elemValue = new MrElemValue();
			BeanCopyUtil.entityToModel(elemValue, mrDocValue, null, dictionaryService);
			elemValueList.add(elemValue);
			return true;
		}

		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SingleResult<Map> omrDocTree(Map<String, String> condition) throws Throwable {
		// 返回结果map
		Map mapResult = new HashMap();
		SingleResult<Map> result = new SingleResult<Map>();
		mapResult.put("text", "root");
		String encounterPk = condition.get("encounterPk");
		Amr amr = amrService.get(encounterPk).getData();
		String showAllCourse = condition.get("showAllCourse");
		// 就诊状态
		String enTpCd = amr.getEncounterTypeCode();
		List<String> enTpCdList = new ArrayList<String>();
		List<String> enPks = new ArrayList<String>();
		enPks.add(amr.getPk());
		enTpCdList.add(EncounterType.EMERGENCY);
		enTpCdList.add(EncounterType.OUTPATIENT);
		// 是否启用就诊组标识,默认不启用
		boolean amrGroupEnable = false;

		Param[] params = paramsService.getParam(SysFunctionCode.AMR_GROUP_ENABLE).getDataList();
		if (params.length > 0) {
			Param param = params[0];
			if ("1".equals(param.getValue())) {
				amrGroupEnable = true;
			}
		}

		// 如果启用就诊组并且就诊类型为急诊则进行就诊组处理
		if (amrGroupEnable && EncounterType.EMERGENCY.equals(enTpCd) && null != amr.getMrAmrGroupCode()) {
			List<MrAmr> amrs = cusMrAmrDao.selectMrAmrs(null, null, null, enTpCd, amr.getPatientId(),
					amr.getMrAmrGroupCode());
			for (MrAmr mrAmr : amrs) {
				enPks.add(mrAmr.getEnPk());
			}
		}
		List<MdMrTpCcat> mdMrTpCcatList = cusMdMrTpCcatDao.selectMrDocTreeByGroup(enTpCdList, enPks);
		List<Map> mapChilds = new ArrayList<Map>();
		if (null != mdMrTpCcatList && mdMrTpCcatList.size() > 0) {
			// 显示合并病历项
			Map mapMerge = new HashMap();
			mapMerge.put("merge", "merge");
			mapMerge.put("id", "merge");
			mapMerge.put("text", "合并病历");
			mapMerge.put("leaf", true);
			mapChilds.add(mapMerge);

			for (int i = 0; i < mdMrTpCcatList.size(); i++) {
				// 得到分类下的文书列表
				List<Map<String, Object>> mrlist = cusMrDao.selectMrByAmrGroup(enPks, mdMrTpCcatList.get(i)
						.getMrTpCcatCd(), null);

				Map mapChild = new HashMap();
				String mrTpCcatCd = mdMrTpCcatList.get(i).getMrTpCcatCd();
				String mdMrTpCcatNm = mdMrTpCcatList.get(i).getNm();
				mapChild.put("ccatCode", mrTpCcatCd);
				mapChild.put("id", mrTpCcatCd);
				mapChild.put("text", mdMrTpCcatNm);

				List<Map> mrMaps = new ArrayList<Map>();

				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if (mrlist.size() > 0) {
					if ("1".equals(showAllCourse)) {/*
													 * MdMrTpCcat
													 * mdMrTpCcat=mdMrTpCcatDao
													 * .selectById(mrTpCcatCd);
													 * if(1==mdMrTpCcat.
													 * getContinuePrintF()){ Map
													 * mrMap = new HashMap();
													 * mrMap.put("mrTpCcatCd",
													 * mrTpCcatCd);
													 * mrMap.put("text",
													 * "全部"+mdMrTpCcat.getNm());
													 * mrMap.put("leaf", true);
													 * mrMaps.add(mrMap); }
													 */
					}
					for (int j = 0; j < mrlist.size(); j++) {
						// 得到文书业务时间，转换格式
						Object crtTime = mrlist.get(j).get("BIZ_TIME");
						String timeStr = sdf.format(crtTime);
						String mrPk = (String) mrlist.get(j).get("MR_PK");
						MedicalRecord medicalRecord = this.searchByMrPk(mrPk, amr);
						medicalRecord.setMrTypeCustomCode(mrTpCcatCd);
						Map mrMap = IihUtils.convertBean(medicalRecord);
						mrMap.put("text", mrlist.get(j).get("NM") + "_" + timeStr + "_" + mrlist.get(j).get("USER_NM"));
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
	public SingleResult<MedicalRecord> sign(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();

		Amr amr = amrService.get(value.getEncounterPk()).getData();
		System.out.println(value.getEncounterPk() + amr.getAmrNo());
		// 检查是否可以签名
		actionCheck.checkCanSign(value, amr, userId, dataObjectService);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());

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
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getXmlFileData())) {
			String xmlFilePk= IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
			if(!StringUtils.isEmpty(xmlFilePk))
			mr.setXmlFilePk(xmlFilePk);
		}

		// 设置完成标志
		// if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLvlCd())) {
		// 当提交后，如果医疗记录审签等级为一级审签，则不需要继续进行审签
		mr.setCompletedF(Short.valueOf("1"));
		// }
		// mr.setUpdCnt(value.getUpdateCount());

		// 判断是否保存病历的Pdf
		String param = paramsSetService.searchFunFlagByKey("OMR_SAVE_YESNO_PDF").getData();
		if (!StringUtils.isBlank(param) && param.equals("1") && !StringUtils.isBlank(value.getMrPdfData())) {
			String pdfFilePk= IihUtils.updateMrBizFile(mr.getCaFilePk(),value.getMrPdfData(),fileService);
			if(!StringUtils.isEmpty(pdfFilePk))
			mr.setCaFilePk(pdfFilePk);
		}
		// 持久化
		try {
			mrDao.updateExcludeNull(mr);
			String mrSubmitCis=paramsSetService.searchFunFlagByKey("MR_SUBMIT_CIS").getData();
			if(mrSubmitCis!=null&&mrSubmitCis.equals("1")){
				mrToCisService.saveMrToCis(value);
			}
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}

		// 保存引用元素
		saveDocValue(value.getEncounterPk(), value.getMrPk(), value.getReferenceElem());
		// 返回最新的医疗记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		return result;
	}

	@Override
	public SingleResult<MedicalRecord> cancelSigned(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		// 检查是否可以签名
		actionCheck.checkCanCancelSigned(value, amr, userId, paramsService);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());
		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		// 设置完成标志
		mr.setCompletedF(Short.valueOf("0"));
		// 将mr的状态改为上一个状态
		mr.setMrStaCd(MrStatus.CREATED);
		mr.setSubmitCd(null);
		mr.setSubmitDate(null);

		mr.setUpdCnt(value.getUpdateCount());
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getXmlFileData())) {
			String xmlFilePk= IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
			if(!StringUtils.isEmpty(xmlFilePk))
			mr.setXmlFilePk(xmlFilePk);
		}

		// 持久化
		try {
			mrDao.update(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		// 返回最新的医疗记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		return result;
	}

	@Override
	public String getEmergencyMrNumber(Map<String, String> map) throws Throwable {
		int emergencyMrNumber = 0;
		String opType = (String) map.get("opType");
		String encounterPk = (String) map.get("encounterPk");
		MrAmr mrAmr = mrAmrDao.selectById(encounterPk);
		String enTypeCd = EncounterType.OUTPATIENT;
		boolean amrGroupEnable = false;
		boolean matchAmrGroupF = false;
		List<String> enPks = new ArrayList<String>();
		enPks.add(encounterPk);
		Param[] params = paramsService.getParam(SysFunctionCode.AMR_GROUP_ENABLE).getDataList();
		if (params.length > 0) {
			Param param = params[0];
			if ("1".equals(param.getValue())) {
				amrGroupEnable = true;
			}
		}

		String typeCode = (String) map.get("typeCode");
		List<MdMrTpCcatItm> ccatItms = cusMdMrTpCcatItmDao.getMdMrTpCcatItmByTemplateTypeAndEnTpCd(typeCode, enTypeCd);
		// 如果启用就诊组并且就诊类型为急诊则进行就诊组处理
		if (amrGroupEnable && EncounterType.EMERGENCY.equals(mrAmr.getEnTpCd()) && null != mrAmr.getMrAmrGroupCd()) {
			List<MrAmr> amrs = cusMrAmrDao.selectMrAmrs(null, null, null, mrAmr.getEnTpCd(), mrAmr.getPaId(),
					mrAmr.getMrAmrGroupCd());
			for (MrAmr mrAmr2 : amrs) {
				enPks.add(mrAmr2.getEnPk());
			}
			matchAmrGroupF = true;
		}

		if (ccatItms.size() > 0) {
			MdMrTpCcatItm ccatItm = ccatItms.get(0);
			String mrTpCcatCd = ccatItm.getMrTpCcatCd();
			if ("MRM14.03".equals(mrTpCcatCd) || "MRM14.09".equals(mrTpCcatCd)) {
				List<Mr> list = new ArrayList<Mr>();
				if (matchAmrGroupF) {
					list = cusMrDao.selectByEnPksForEmergencyMrNumber(enPks);
				} else {
					list = cusMrDao.selectByEnPkForEmergencyMrNumber(encounterPk);
				}
				if ("new".equals(opType)) {
					emergencyMrNumber = list.size() + 1;
				} else {
					String mrPk = (String) map.get("mrPk");
					for (int i = 0; i < list.size(); i++) {
						Mr mr = list.get(i);
						if (mrPk.equals(mr.getMrPk())) {
							emergencyMrNumber = i + 1;
						}
					}
				}
			}
		}
		return IihUtils.partTranslate(emergencyMrNumber);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SingleResult<Map> omrTreeInit(Map<String, String> condition) throws Throwable {
		SingleResult<Map> result = new SingleResult<Map>();
		Session session = Session.get();
		String deptCode = session.getDeptId();
		String orgCode = session.getOrgCd();
		String encounterPk = condition.get("encounterPk");
		Map mapResult = this.omrDocTree(condition).getData();
		List<Map> list = (List<Map>) mapResult.get("children");
		if (null == list || list.size() == 0) {
			List<MrTpl> mrTpls = cusTemplateDao.getDefaultTemplate(deptCode, OwnerType.DEPARTMENT,
					MrType.OUT_FIRST_RECORD);
			if (null == mrTpls || mrTpls.size() == 0) {
				mrTpls = cusTemplateDao.getDefaultTemplate(orgCode, OwnerType.HOSPITAL_WIDE, MrType.OUT_FIRST_RECORD);
			}
			if (null != mrTpls && mrTpls.size() > 0) {
				MrTpl mrTpl = mrTpls.get(0);
				MedicalRecord medicalRecord = new MedicalRecord();
				medicalRecord.setName(mrTpl.getNm());
				medicalRecord.setTypeCode(mrTpl.getMrTpCd());
				medicalRecord.setFilePk(mrTpl.getFilePk());
				medicalRecord.setBizTime(new Date());
				medicalRecord.setTempleCode(mrTpl.getMrTplCd());
				medicalRecord.setEncounterPk(encounterPk);
				medicalRecord.setSignLevelCode(mrTpl.getMrSignLvlCd());
				FileObject file = fileService.getFile(mrTpl.getFilePk());
				medicalRecord.setFileData(new String(file.asByteArray(), "UTF-8"));
				mapResult.put("medicalRecord", medicalRecord);
			}
		}
		result.setData(mapResult);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.mr.wr.OutMedicalRecordService#createCaFile(pkuhit.iih.mr.wr
	 * .MedicalRecord)
	 */
	@Override
	public void createCaFile(MedicalRecord value) throws Throwable {
		Mr mr = mrDao.selectById(value.getMrPk());
		FileObject caFileObject = null;
		if (!StringUtils.isBlank(mr.getCaFilePk())) {
			caFileObject = fileService.getFile(mr.getCaFilePk());
		}
		if (value.getCaFileData() != null && !value.getCaFileData().equals("")) {
			try {// 验证对于Id的文件是否存在，如果存在则修改
				if (caFileObject != null && !StringUtils.isEmpty(caFileObject.getId())) {
					caFileObject = fileService.updateFile(caFileObject.getId(), value.getCaFileData().getBytes());
				} else {
					caFileObject = fileService.createFile("biz", value.getCaFileData().getBytes());
				}
			} catch (Exception e) {
				log.error("创建业务文件发生错误：fileObject data :" + value.getCaFileData() + "错误信息如下：");
				e.printStackTrace();
			}
		}
		if (caFileObject != null) {
			mr.setCaFilePk(caFileObject.getId());
			mrDao.updateExcludeNull(mr);
		}
	}
	
	@Override
	public SingleResult<User> omrSignPicByUser(String userCd) throws Throwable {
	    SingleResult<User> result = new SingleResult<User>();
	    SingleResult<String> checkFlg= paramsSetService.searchFunFlagByKey("OMR_PIC_SIGN_CHECK");
	    if(!StringUtils.isEmpty(checkFlg.getData()) && checkFlg.getData().equals("1")){
	        System.out.println("sign pic check flag is " + checkFlg.getData());
	        SingleResult<String> param = paramsSetService.searchFunFlagByKey("SIGN_PIC_DATASOURCE");
	        System.out.println("sign pic datasource is " + param.getData());
	        if(!StringUtils.isEmpty(param.getData()) && param.getData().equals("0")){
	            //本地图片
	            System.out.println("get sign pic from local database!");
	            result = userService.selectMrSignById(userCd);
	        }else if(!StringUtils.isEmpty(param.getData()) && param.getData().equals("1")){
	            //读取cis库图片
	            System.out.println("get sign pic from CIS database!");
	            result = cisSignPicService.selectSignPicByUser(userCd);
	        }
	        result.getData().setUsePicSign(checkFlg.getData());
	    }else{
	        User user=new User();
	        result.setData(user);
	    }
        return result;
	}

	@Override
	public void createOmrPrintLog(MrPrintOpLogModel value)
			throws Throwable {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		MrPrintOpLog mrPrintOpLog = new MrPrintOpLog();
		BeanCopyUtil.modelToEntity(mrPrintOpLog, value);
		mrPrintOpLog.setPrintLogCd(UUIDGenerator.getUUID());
		mrPrintOpLog.setPrintTime(date);
		mrPrintOpLogDao.insertExludeNull(mrPrintOpLog);		
	}


}
