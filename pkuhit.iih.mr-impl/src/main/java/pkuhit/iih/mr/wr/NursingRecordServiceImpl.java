package pkuhit.iih.mr.wr;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
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
import pkuhit.iih.mr.dao.auto.MrSignDao;
import pkuhit.iih.mr.dao.auto.MrSplFmDao;
import pkuhit.iih.mr.dao.auto.MrTplDao;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.dao.auto.entity.MrSplFm;
import pkuhit.iih.mr.dao.auto.entity.MrTpl;
import pkuhit.iih.mr.md.Code;
import pkuhit.iih.mr.md.MrSignLevel;
import pkuhit.iih.mr.md.MrSource;
import pkuhit.iih.mr.md.MrStatus;
import pkuhit.iih.mr.md.dao.auto.MdMrTpCcatDao;
import pkuhit.iih.mr.md.dao.auto.MdMrTpDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
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
import pkuhit.iih.mr.wr.dao.CusMrSplFmDao;
import pkuhit.iih.mr.wr.dao.CusQaItemMrTpDao;
import pkuhit.iih.pub.IihUtils;
import pkuhit.iih.pub.PerformancePrinter;
import pkuhit.iih.qa.dao.qacustom.CusQaFltItmDao;
import pkuhit.iih.qa.md.QaStaus;
import pkuhit.md.DictionaryService;
import pkuhit.md.SysFunctionCode;
import pkuhit.me.DataObject;
import pkuhit.me.DataObjectService;
import pkuhit.org.WorkGroupEmpService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.UserService;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.mes.Message;
import pkuhit.xap.mes.MessageService;
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

public class NursingRecordServiceImpl implements NursingRecordService {

	private Logger log = LoggerFactory.getLogger(NursingRecordServiceImpl.class);
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

	@Reference
	MedicalRecordService medicalRecordService;

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
	CusQaFltItmDao cusQaFltItmDao;

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
	MrTplDao mrTplDao;

	@Autowired
	CusTemplateDao cusTemplateDao;

	@Autowired
	CusMrAmrDao cusMrAmrDao;

	@Autowired
	MrSplFmDao mrSplFmDao;

	@Autowired
	CusMrSplFmDao cusMrSplFmDao;
	
	@Reference
	MrToCisService mrToCisService;
	
	@Reference
	MessageService messageService;

	private NmrActionCheck actionCheck = new NmrActionCheck();

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
		// 补全数据
		Mr mr = new Mr();
		BeanCopyUtil.modelToEntity(mr, value);
		mr.setMrPk(UUIDGenerator.getUUID());
		mr.setEncounterSn(value.getEncounterPk());
		mr.setEnPk(value.getEncounterPk());
		mr.setDeptCd(Session.get().getDeptId());
		mr.setBizTime(new Timestamp(value.getBizTime().getTime()));
		mr.setMrStaCd(MrStatus.CREATED);
		mr.setCompletedF(Short.valueOf("0"));
		// 保存病历xml文件
		String xmlFilePk = IihUtils.updateMrBizFile(mr.getXmlFilePk(), value.getXmlFileData(), fileService);
		if (xmlFilePk != null)
			mr.setXmlFilePk(xmlFilePk);
		// 保存业务文件
		String filePk = IihUtils.updateMrBizFile(null, value.getFileData(), fileService);
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		if (filePk != null)
			mr.setFilePk(filePk);
		
		String checkSplData = paramsSetService.searchFunFlagByKey("NMR_CHECK_SPL_DATA").getData();
		if(checkSplData!=null&&checkSplData.equals("1")){
		// 根据系统配置colm解析将xml表格解析保存到二维表
			String xmlToTableIsColumn = paramsSetService.searchFunFlagByKey("XML_TO_TABLE_IS_COLUMN").getData();
			List<String> columns = new ArrayList<String>();
			if (!StringUtils.isBlank(xmlToTableIsColumn)) {
				String[] string = xmlToTableIsColumn.split(",");
				for (String str : string) {
					if (str != null && str.length() != 0) {
						columns.add(str);
					}
				}
			}
			//拆分病历表单内容
			splMrFmData(value, amr, mr, columns);
		}
		// 保存到MR表
		mrDao.insertExludeNull(mr);
		
		// 判断是否是新建时直接点的提交，如果是则调用提交服务
		if (MrStatus.SUBMITTED.equals(value.getStatusCode())) {
			MedicalRecord medicalRecord = this.searchById(mr.getMrPk(), true).getData();
			medicalRecord.setXmlFileData(value.getXmlFileData());
			medicalRecord.setMrPdfData(value.getMrPdfData());
			result = this.sign(mr.getMrPk(), medicalRecord);
			// this.fireEvent("SUBMIT_MR", result.getData());
		} else {
			result = this.searchById(mr.getMrPk(), false);
			// this.fireEvent("CREATE_MR", result.getData());
		}

		//result = this.searchById(mr.getMrPk(), false);
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
			Notification notification = new Notification(MessageCode.MISS_PARAM, "护理记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		String userId = session.getUserId();
		Mr mr = mrDao.selectById(id);
		Amr amr = amrService.get(mr.getEnPk()).getData();
		// 检查是否可删除
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		MedicalRecord medicalRecord = result.getData();
		actionCheck.checkCanDelete(medicalRecord, userId);

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

	@Transactional
	@Override
	public SingleResult<MedicalRecord> sign(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "护理记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		// 得到userId
		String userId = session.getUserId();
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		// 检查是否可以签名
		actionCheck.checkCanSign(value, amr, userId, dataObjectService);
		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());
		Timestamp date = new Timestamp(System.currentTimeMillis());
		// 得到护理记录
		Mr mr = mrDao.selectById(id);
		// 设置护理记录状态为已提交
		mr.setMrStaCd(MrStatus.SUBMITTED);
		// 设置提交人
		mr.setSubmitCd(userId);
		// 设置提交时间
		mr.setSubmitDate(date);
		// 首次提交设置逻辑提交时间
		if (null == mr.getLgcSmtTime()) {
			mr.setLgcSmtTime(date);
		}

		// 更新xml文件
		// this.updateXmlFile(value, mr);
		String xmlFilePk = IihUtils.updateMrBizFile(mr.getXmlFilePk(), value.getXmlFileData(), fileService);
		if (xmlFilePk != null)
			mr.setXmlFilePk(xmlFilePk);
		
		// 更新Pdf文件
		String pdfFilePk = IihUtils.updateMrBizFile(mr.getCaFilePk(), value.getMrPdfData(), fileService);
		if (pdfFilePk != null)
			mr.setCaFilePk(pdfFilePk);
		// 更新txt文件
		// this.updateTxtFile(value, mr);
		String txtFilePk = IihUtils.updateMrBizFile(mr.getTxtFilePk(), value.getTxtFileData(), fileService);
		if (txtFilePk != null)
			mr.setTxtFilePk(txtFilePk);
		// 设置完成标志
		if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLvlCd()) || mr.getSignLvlCd().equals(MrSignLevel.NEED_NOT_SIGN)) {
			// 当提交后，如果护理记录审签等级为一级审签，则不需要继续进行审签
			mr.setCompletedF(Short.valueOf("1"));
		}
		// 设置整改状态
		if (mr.getCompletedF() == 1
				&& (QaStaus.REFORM_FAULT_RECEIVED_.equals(mr.getMrQaStaCd()) || QaStaus.REFORM_FAULT_SUBMITTED
						.equals(mr.getMrQaStaCd()))) {
			mr.setMrQaStaCd(QaStaus.REFORM_FAULT__COMPLETED);
		}
		// // 提交人如果是经治医师的话，把经治医师带入病历的经治医师里面
		// if (userId.equals(amr.getCurrentManageNurseId())) {
		// mr.setTreatDoctorCd(userId);
		// }
		mr.setUpdCnt(value.getUpdateCount());

		// //设置三级捡诊护师
		// mr.setTreatDoctorCd(amr.getCurMngDctId());
		// mr.setDirDoctorCd(amr.getCurDrcDctId());
		// mr.setMastDoctorCd(amr.getCurMojDctId());

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
		medicalRecordService.saveDocValue(value.getEncounterPk(), value.getMrPk(), value.getReferenceElem());
		// 返回最新的护理记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		// this.fireEvent("SUBMIT_NMR", result.getData());
		return result;
	}
	
	private void splMrFmData(MedicalRecord value, Amr amr, Mr mr, List<String> columns) {
		if (!StringUtils.isBlank(value.getXmlFileData())) {
			Map<String, Object> maps = new HashMap<String, Object>();
			Document document = null;
			document = IihUtils.xmlConvertDom(value.getXmlFileData());
			//根据表格名称，保存总评分数据
			String[] totalScoreTbNms = { "Braden-TotalScoreTable","Fall-TotalScoreTable","Catheter-TotalScoreTable","Barther-TotalScoreTable"};
			//根据表格名称，保存中医特色数据
			String[] chDocFeatureTbNms = { "Inside-ChDocFeatureTable", "Outside-ChDocFeatureTable","Skin-ChDocFeatureTable" };
			if (document != null)
				IihUtils.getColumnISFromMap(columns, maps, document, totalScoreTbNms, chDocFeatureTbNms);
			// cusMrSplFmDao.deleteSplFmOnMrPk(mr.getMrPk());
			if (maps != null && maps.size() > 0) {
				List<MrSplFmValue> fmValues =  (List<MrSplFmValue>) maps.get(maps.keySet().iterator().next());
				if(fmValues!=null&&fmValues.get(0)!=null){
					MrSplFmValue fmValue = fmValues.get(0);
					List<MrSplFm> mrSplFms = cusMrSplFmDao.selectAll(mr.getEnPk(), fmValue.getFmType(), fmValue.getFmName());
					if (mrSplFms != null && mrSplFms.size() > 0) {
						int[] ids = mrSplFmDao.batchDelete(mrSplFms);
						}
					if (fmValue.getKey().equals("总评分")) {
						MrSplFm msf = new MrSplFm();
						msf.setSplFmCd(UUIDGenerator.getUUID());
						msf.setMrPk(mr.getMrPk());
						msf.setEnPk(mr.getEnPk());
						msf.setPaId(amr.getPatientId());
						msf.setName(fmValue.getKey());
						msf.setContent(fmValue.getValue());
						msf.setFmType(fmValue.getFmType());
						msf.setFmName(fmValue.getFmName());
						msf.setDelF(Short.valueOf(0 + ""));
						mrSplFmDao.insertExludeNull(msf);
					}else{
						for (String s : maps.keySet()) {// 行
							List<MrSplFmValue> msfvs = (List<MrSplFmValue>) maps.get(s);
							MrSplFmValue splFmK = msfvs.get(0);
							if (!StringUtils.isBlank(splFmK.getValue())) {
								MrSplFm msf = new MrSplFm();
								msf.setSplFmCd(UUIDGenerator.getUUID());
								msf.setMrPk(mr.getMrPk());
								msf.setEnPk(mr.getEnPk());
								msf.setPaId(amr.getPatientId());
								msf.setName(splFmK.getValue());
								msf.setFmType(splFmK.getFmType());
								msf.setFmName(splFmK.getFmName());
								if(msfvs.size()>1){
									MrSplFmValue splFmV = msfvs.get(1);
									msf.setContent(splFmV.getValue());
								}
								msf.setDelF(Short.valueOf(0 + ""));
								mrSplFmDao.insertExludeNull(msf);
							}
						}
					}
					
				}
			}
		}
	}

	@Transactional
	@Override
	public SingleResult<MedicalRecord> reject(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "护理记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		String userSignLevelCode = medicalRecordService.getSignLevelCode();
		// 检查是否可以签名
		actionCheck.checkCanReject(value, amr, userSignLevelCode, userId, dataObjectService);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());

		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		
		//发送消息
		Message message = new Message();
		String msgContent = "审签未通过，患者【"+amr.getPatientName()+"】的病历需要修改";
		String msgPk = UUIDGenerator.getUUID();
		message.setMesId(msgPk);
		message.setSendUserId(userId);//发送人-审签医生
		message.setSendDate(new Timestamp(System.currentTimeMillis()));//发送时间
		message.setReceiveUserId(mr.getSubmitCd());//接收人-整改医生
		message.setReceiveDate(new Timestamp(System.currentTimeMillis()));
		message.setPortalCd(Code.NUR_MR_PORTAL);
		message.setMenuCd(Code.NUR_MR_MENU); //菜单编码
		message.setContent(msgContent);
		message.setReadFlag(0+""); //未读
		message.setMesLevel((short)0); //级别问一般
		message.setMesType("1");//质控消息
		messageService.sendMessage(message);
		
		// 补全数据
		// 将mr的完成标志置为0
		mr.setCompletedF(Short.valueOf("0"));
		// 设置医疗记录状态为上一个状态
//		MrStatus mrStatus = dataObjectService.getObject(MrStatus.OBJ_CD, mr.getMrStaCd()).getObject(MrStatus.class);
//		MrStatus preMrStatusCode = dataObjectService.getObject(MrStatus.OBJ_CD, mrStatus.getPreMrStatusCode())
//				.getObject(MrStatus.class);
		mr.setMrStaCd(MrStatus.CREATED);
		mr.setSubmitCd(null);//清空提交审签信息
		mr.setSubmitDate(null);
		mr.setMastDoctorCd(null);//清空二级审签信息
		mr.setMastDoctorDate(null);
		mr.setDirDoctorCd(null);//清空三级审签信息
		mr.setDirDoctorDate(null);
		mr.setUpdCnt(value.getUpdateCount());
		// 更新xml文件
		String xmlFilePk = IihUtils.updateMrBizFile(mr.getXmlFilePk(), value.getXmlFileData(), fileService);
		if (xmlFilePk != null)
			mr.setXmlFilePk(xmlFilePk);
		// 更新txt文件
		String txtFilePk = IihUtils.updateMrBizFile(mr.getTxtFilePk(), value.getTxtFileData(), fileService);
		if (txtFilePk != null)
			mr.setTxtFilePk(txtFilePk);
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

	@Transactional
	@Override
	public SingleResult<MedicalRecord> cancelSigned(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "护理记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();
		// 检查是否可以签名
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		actionCheck.checkCanCancelSigned(value, amr, userId);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());

		// 得到护理记录
		Mr mr = mrDao.selectById(id);
		// 设置完成标志
		mr.setCompletedF(Short.valueOf("0"));
		// 设置整改状态
		if (QaStaus.REFORM_FAULT__COMPLETED.equals(mr.getMrQaStaCd()))
			mr.setMrQaStaCd(QaStaus.REFORM_FAULT_RECEIVED_);
		// // 查询当前护理记录的护理记录状态
		// DataObject dataObject = dataObjectService.getObject("MRM04",
		// mr.getMrStaCd());
		// MrStatus mrStatus = dataObject.getObject(MrStatus.class);
		// 将mr的状态改为上一个状态
		mr.setMrStaCd(MrStatus.CREATED);
		mr.setSubmitCd(null);
		mr.setSubmitDate(null);
		mr.setUpdCnt(value.getUpdateCount());
		// 更新xml文件
		// this.updateXmlFile(value, mr);
		// 更新txt文件
		// this.updateTxtFile(value, mr);
		String xmlFilePk = IihUtils.updateMrBizFile(mr.getXmlFilePk(), value.getXmlFileData(), fileService);
		if (xmlFilePk != null)
			mr.setXmlFilePk(xmlFilePk);
		// 更新txt文件
		// this.updateTxtFile(value, mr);
		String txtFilePk = IihUtils.updateMrBizFile(mr.getTxtFilePk(), value.getTxtFileData(), fileService);
		if (txtFilePk != null)
			mr.setTxtFilePk(txtFilePk);
		// 持久化
		try {
			mrDao.update(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		// 返回最新的护理记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		// this.fireEvent("REVOKE_MR", result.getData());
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
			Notification notification = new Notification(MessageCode.MISS_PARAM, "护理记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		SingleResult<MedicalRecord> result;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		String userId = session.getUserId();
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		// Amr amr = amrService.get(value.getEncounterPk()).getData();
		String userSignLevelCode = medicalRecordService.getSignLevelCode();
		MedicalRecord medicalRecord = this.searchById(id, false).getData();
		// 检查是否可更新
		actionCheck.checkCanSave(medicalRecord, amr, userSignLevelCode, userId, dataObjectService);

		/*
		 * if(value.getMrSource() == null
		 * ||!value.getMrSource().equalsIgnoreCase(MrSource.XML)){
		 * log.debug("开始验证更新权限,mrPk is "+value.getMrPk());
		 * 
		 * }else{
		 * log.debug("mr source is xml ,跳过验证更新权限,mrPk is "+value.getMrPk());
		 * value.setXmlFileData(null); }
		 */
		// 持久化
		Mr mr = new Mr();
		BeanCopyUtil.modelToEntity(mr, value);
		if (value.getMrSource() == null || !value.getMrSource().equalsIgnoreCase(MrSource.XML)) {
			log.debug("mr source is 非 xml , 更新xml ,mrPk is " + value.getMrPk());
			// 更新xml文件
			// this.updateXmlFile(value, mr);
			// 更新txt文件
			// this.updateTxtFile(value, mr);
			String xmlFilePk = IihUtils.updateMrBizFile(mr.getXmlFilePk(), value.getXmlFileData(), fileService);
			if (xmlFilePk != null)
				mr.setXmlFilePk(xmlFilePk);
			// 更新txt文件
			// this.updateTxtFile(value, mr);
			String txtFilePk = IihUtils.updateMrBizFile(mr.getTxtFilePk(), value.getTxtFileData(), fileService);
			if (txtFilePk != null)
				mr.setTxtFilePk(txtFilePk);
		} else {
			log.debug("mr source is xml ,跳过更新xml, 设置成odt,mrPk is " + value.getMrPk());
			mr.setMrSource(MrSource.ODT);
		}
		mr.setUpdCnt(value.getUpdateCount());
		// updateOdtFile(value,mr);
		String checkSplData = paramsSetService.searchFunFlagByKey("NMR_CHECK_SPL_DATA").getData();
		if(checkSplData!=null&&checkSplData.equals("1")){
			// 根据系统配置colm解析将xml表格解析保存到二维表
			String xmlToTableIsColumn = paramsSetService.searchFunFlagByKey("XML_TO_TABLE_IS_COLUMN").getData();
			List<String> columns = new ArrayList<String>();
			if (!StringUtils.isBlank(xmlToTableIsColumn)) {
				String[] string = xmlToTableIsColumn.split(",");
				for (String str : string) {
					if (str != null && str.length() != 0) {
						columns.add(str);
					}
				}
			}
			//拆分病历表单内容
			splMrFmData(value, amr, mr, columns);
		}
		String odtFilePk = IihUtils.updateMrBizFile(mr.getFilePk(), value.getFileData(), fileService);
		if (odtFilePk != null)
			mr.setFilePk(odtFilePk);
		try {
			mrDao.updateExcludeNull(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		MedicalRecord returnData = this.searchById(value.getMrPk(), false).getData();
		builder.withData(returnData);
		result = builder.build();
		return result;
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
				list = cusMrDao.selectByEnPk(encounterPk, mrTypeCustomCode, mrTypeCode, null, 0, null);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#searchById(java.lang.String)
	 */
	@Override
	public SingleResult<MedicalRecord> searchById(String id, boolean withFile) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "护理记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		String userId = session.getUserId();
		String userSignLevelCode = medicalRecordService.getSignLevelCode();
		SingleResult<MedicalRecord> result;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		Mr mr = mrDao.selectById(id);
		if (null == mr) {
			Notification msg = null;
			msg = new Notification(MessageCode.BIZ_FILE_NO_EXITS, id);
			throw new NotificationException(msg);
		}
		// 查询就诊
		Amr amr = amrService.get(mr.getEnPk()).getData();
		if (null == amr) {
			Notification notification = new Notification(MessageCode.AMR_NOT_EXITS, mr.getEnPk());
			throw new NotificationException(notification);
		}
		// 补全数据（用户名转用户名称）
		MedicalRecord medicalRecord = new MedicalRecord();
		PerformancePrinter.start("userIdToName");
		BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
		medicalRecord.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
		medicalRecord.setLastUpdateUserName(IihUtils.userIdToName(dataObjectService, mr.getLastUpdUserId()));
		medicalRecord.setSubmitName(IihUtils.userIdToName(dataObjectService, mr.getSubmitCd()));
		PerformancePrinter.end("userIdToName");
		PerformancePrinter.start("MrTemplate");
		MrTpl po = mrTplDao.selectById(mr.getMrTplCd());
		if (null != po) {
			medicalRecord.setTempleName(po.getNm());
		}
		PerformancePrinter.end("MrTemplate");
		// //增加一列记录自定义类型组编码
		// PerformancePrinter.start("mrTypeCustomCode");
		// List<MdMrTpCcatItm> ccatItms =
		// cusMdMrTpCcatItmDao.getMdMrTpCcatItmByTemplateType(medicalRecord.getTypeCode());
		// String mrTypeCustomCode = "";
		// for (MdMrTpCcatItm ccatItm : ccatItms) {
		// if ("".equals(mrTypeCustomCode)) {
		// mrTypeCustomCode = ccatItm.getMrTpCcatCd();
		// }
		// }
		// PerformancePrinter.end("mrTypeCustomCode");
		// medicalRecord.setMrTypeCustomCode(mrTypeCustomCode);
		// 操作权限
		if (withFile) {
			// 获取业务文件
			FileObject fileObject = null;
			try {
				if (null != medicalRecord.getFilePk()) {
					fileObject = fileService.getFile(medicalRecord.getFilePk());
				} else {
					if (StringUtils.isNotBlank(mr.getMrTplCd())) {
						log.debug("获取业务文件,odt文件不存在,判断 该记录的模板文件 ，mr_tp_cd =" + mr.getMrTplCd());

						MrTpl mrTemplate = mrTplDao.selectById(mr.getMrTplCd());
						if (null != mrTemplate) {
							fileObject = fileService.getFile(mrTemplate.getFilePk());

						} else {
							log.info("病历模板不存在,mr_tp_cd =" + mr.getMrTplCd());
						}

					} else {
						log.info("获取业务文件,odt文件不存在 ,模板文件mr_tp_cd为空");
					}
				}

				// 判断病程记录 最新的数据来源
				if (null != mr.getMrSource() && mr.getMrSource().equalsIgnoreCase(MrSource.XML)) {
					log.debug("病程记录的模板最新来源 是 xml ,mr_pk =" + mr.getMrPk());
					if (null != mr.getXmlFilePk()) {
						log.debug("病程记录的模板,XmlFilePk=" + mr.getXmlFilePk() + "|mr_pk =" + mr.getMrPk());
						FileObject xmlFileObject = fileService.getFile(mr.getXmlFilePk());
						medicalRecord.setXmlFileData(new String(xmlFileObject.asByteArray(), "UTF-8"));
						medicalRecord.setXmlFilePk(mr.getXmlFilePk());
						medicalRecord.setOnlyXmlNeedToTransfer(true);
					} else {
						log.debug("病程记录的模板,XmlFilePk is null ,mrPk =" + mr.getMrPk());
					}
				} else {
					log.debug("病程记录的模板最新来源  非xml，无需合并,mr_pk =" + mr.getMrPk());
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
		// 增加是否可续打标识
		// MdMrTpCcat mdMrTpCcat=mdMrTpCcatDao.selectById(mrTypeCustomCode);
		// medicalRecord.setCanContinuePrint(mdMrTpCcat.getContinuePrintF());
		PerformancePrinter.end("getContinuePrintF");

		PerformancePrinter.start("getNewPageF");
		// 增加是否新起一页打印标识
		// MdMrTp mdMrTp=mdMrTpDao.selectById(mr.getMrTpCd());
		// medicalRecord.setNewPageF(mdMrTp.getNewPageF());
		PerformancePrinter.end("getNewPageF");
		PerformancePrinter.start("setActionFlag");
		MdMrTp mdMrTp = mdMrTpDao.selectById(mr.getMrTpCd());
		medicalRecord.setPermitF(mdMrTp.getPermitF() == null ? 1 : mdMrTp.getPermitF());
		// 检查全部的5个操作标志，并赋予护理记录对象
		medicalRecord = actionCheck.setActionFlag(medicalRecord, amr, userSignLevelCode, userId, dataObjectService);
		PerformancePrinter.end("setActionFlag");
		medicalRecord.setUserSignLevelCode(userSignLevelCode);
		builder.withData(medicalRecord);
		result = builder.build();
		return result;
	}

	@Transactional
	@Override
	public SingleResult<MedicalRecord> approve(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		String userSignLevelCode = medicalRecordService.getSignLevelCode();
		// 检查是否可以签名
		actionCheck.checkCanApprove(value, amr, userSignLevelCode, userId, dataObjectService);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());
		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		Timestamp date = new Timestamp(System.currentTimeMillis());
		// 根据用户审签等级设置医疗记录对应的状态
		if (MrSignLevel.LEVEL_TWO_SIGN.equals(userSignLevelCode)) {
			mr.setMrStaCd(MrStatus.SIGNED_LEVEL_2);
			mr.setMastDoctorDate(date);
			mr.setMastDoctorCd(userId);
		} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(userSignLevelCode)) {
			mr.setMrStaCd(MrStatus.SIGNED_LEVEL_3);
			mr.setDirDoctorDate(date);
			mr.setDirDoctorCd(userId);
		}
		// 更新xml文件
		// this.updateXmlFile(value, mr);
		String xmlFilePk = IihUtils.updateMrBizFile(mr.getXmlFilePk(), value.getXmlFileData(), fileService);
		if (xmlFilePk != null)
			mr.setXmlFilePk(xmlFilePk);
		// 更新txt文件
		// this.updateTxtFile(value, mr);
		String txtFilePk = IihUtils.updateMrBizFile(mr.getTxtFilePk(), value.getTxtFileData(), fileService);
		if (txtFilePk != null)
			mr.setTxtFilePk(txtFilePk);
		// 当审签后，医疗记录状态=医疗记录对应的审签级别时，变为已完成
		MrStatus ms = dataObjectService.getObject(MrStatus.OBJ_CD, mr.getMrStaCd()).getObject(MrStatus.class);
		if (ms.getSignLevelCode().equals(mr.getSignLvlCd())) {
			mr.setCompletedF(Short.valueOf("1"));
		}
		// 设置整改状态
		if (mr.getCompletedF() == 1
				&& (QaStaus.REFORM_FAULT_RECEIVED_.equals(mr.getMrQaStaCd()) || QaStaus.REFORM_FAULT_SUBMITTED
						.equals(mr.getMrQaStaCd()))) {
			mr.setMrQaStaCd(QaStaus.REFORM_FAULT__COMPLETED);
		}

		mr.setUpdCnt(value.getUpdateCount());

		// 持久化
		try {
			mrDao.updateExcludeNull(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}

		// 保存引用元素
		medicalRecordService.saveDocValue(value.getEncounterPk(), value.getMrPk(), value.getReferenceElem());
		// 返回最新的医疗记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#auditRevoke(java.lang.String,
	 * pkuhit.iih.mr.wr.MedicalRecord)
	 */
	@Transactional
	@Override
	public SingleResult<MedicalRecord> auditRevoke(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();
		String userSignLevelCode = medicalRecordService.getSignLevelCode();
		// 检查是否可以签名
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		actionCheck.checkCanCancelApprove(value, amr, userId, userSignLevelCode);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());
		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		// 设置完成标志
		mr.setCompletedF(Short.valueOf("0"));
		// 设置整改状态
		if (QaStaus.REFORM_FAULT__COMPLETED.equals(mr.getMrQaStaCd()))
			mr.setMrQaStaCd(QaStaus.REFORM_FAULT_RECEIVED_);
		// 查询当前医疗记录的医疗记录状态
		DataObject dataObject = dataObjectService.getObject(MrStatus.OBJ_CD, mr.getMrStaCd());
		MrStatus mrStatus = dataObject.getObject(MrStatus.class);
		// 将mr的状态改为上一个状态
		mr.setMrStaCd(mrStatus.getPreMrStatusCode());

		mr.setUpdCnt(value.getUpdateCount());
		// 更新xml文件
		String xmlFilePk = IihUtils.updateMrBizFile(mr.getXmlFilePk(), value.getXmlFileData(), fileService);
		if (xmlFilePk != null)
			mr.setXmlFilePk(xmlFilePk);
		// 更新txt文件
		String txtFilePk = IihUtils.updateMrBizFile(mr.getTxtFilePk(), value.getTxtFileData(), fileService);
		if (txtFilePk != null)
			mr.setTxtFilePk(txtFilePk);
		// updateTxtFile(value,mr);
		// 持久化
		try {
			mrDao.updateExcludeNull(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		// 返回最新的医疗记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		return result;
	}

	@Transactional
	@Override
	public SingleResult<MedicalRecord> startApprove(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "护理记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();
		// Amr amr = amrService.get(value.getEncounterPk()).getData();
		String userSignLevelCode = medicalRecordService.getSignLevelCode();
		value = this.searchById(id, false).getData();
		// 检查是否可以签名
		actionCheck.checkCanStartApprove(value, userSignLevelCode, dataObjectService, userId);

		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		// 根据用户审签等级设置医疗记录对应的状态
		if (MrSignLevel.LEVEL_TWO_SIGN.equals(userSignLevelCode)) {
			mr.setMrStaCd(MrStatus.SIGNED_LEVEL_2ING);
		} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(userSignLevelCode)) {
			mr.setMrStaCd(MrStatus.SIGNED_LEVEL_3ING);
		}

		mr.setUpdCnt(value.getUpdateCount());

		// 持久化
		try {
			mrDao.updateExcludeNull(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		// 返回最新的医疗记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		return result;
	}

	public MedicalRecord searchByMrPk(String id, Amr amr) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		String userSignLevelCode = medicalRecordService.getSignLevelCode();
		Mr mr = mrDao.selectById(id);
		// 补全数据（用户名转用户名称）
		MedicalRecord medicalRecord = new MedicalRecord();
		BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
		// Param[] params =
		// paramsService.getParam(SysFunctionCode.MR_UPDATE_TIME_LIMIT_CONFIG).getDataList();
		// 检查全部的5个操作标志，并赋予护理记录对象
		MdMrTp mdMrTp = mdMrTpDao.selectById(mr.getMrTpCd());
		medicalRecord.setPermitF(mdMrTp.getPermitF() == null ? 1 : mdMrTp.getPermitF());
		medicalRecord = actionCheck.setActionFlag(medicalRecord, amr, userSignLevelCode, userId, dataObjectService);
		return medicalRecord;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SingleResult<Map> nmrDocTree(Map<String, String> condition) throws Throwable {
		// 返回结果map
		Map mapResult = new HashMap();
		SingleResult<Map> result = new SingleResult<Map>();
		mapResult.put("text", "root");
		String encounterPk = condition.get("encounterPk");
		Amr mrAmr = amrService.get(encounterPk).getData();
		// 就诊状态
		String enTpCd = EncounterType.INPATIENT;
		List<MdMrTpCcat> mdMrTpCcatList = cusMdMrTpCcatDao.selectMrDocTree(enTpCd, encounterPk, 0);
		List<Map> mapChilds = new ArrayList<Map>();
		if (null != mdMrTpCcatList && mdMrTpCcatList.size() > 0) {
			for (int i = 0; i < mdMrTpCcatList.size(); i++) {
				// 得到分类下的文书列表
				List<Map<String, Object>> mrlist = cusMrDao.selectMrByEnPk(encounterPk, mdMrTpCcatList.get(i)
						.getMrTpCcatCd(), null, null);

				Map mapChild = new HashMap();
				String mrTpCcatCd = mdMrTpCcatList.get(i).getMrTpCcatCd();
				String mdMrTpCcatNm = mdMrTpCcatList.get(i).getNm();
				mapChild.put("ccatCode", mrTpCcatCd);
				mapChild.put("id", mrTpCcatCd);
				mapChild.put("text", mdMrTpCcatNm);

				List<Map> mrMaps = new ArrayList<Map>();

				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if (mrlist.size() > 0) {
					for (int j = 0; j < mrlist.size(); j++) {
						// 得到文书业务时间，转换格式
						Object crtTime = mrlist.get(j).get("BIZ_TIME");
						String timeStr = sdf.format(crtTime);
						String mrPk = (String) mrlist.get(j).get("MR_PK");
						Amr amr = amrService.get(encounterPk).getData();
						MedicalRecord medicalRecord = this.searchByMrPk(mrPk, amr);
						medicalRecord.setMrTypeCustomCode(mrTpCcatCd);
						Map mrMap = this.convertBean(medicalRecord);
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
			mapResult.put("amr", mrAmr);
		}
		result.setData(mapResult);
		return result;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 *            要转化的JavaBean 对象
	 * @return 转化出来的 Map 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map convertBean(Object bean) throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		Class type = bean.getClass();
		Map returnMap = new HashMap();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	@Override
	public SingleResult<Map> splData(String enPk) throws Throwable {
		SingleResult<Map> resultMap = new SingleResult<Map>(); 
		Map<String, String> map = new HashMap<String, String>();
		List<MrSplFm> mrSplFms = cusMrSplFmDao.selectAll(enPk,1,null);
		if (mrSplFms != null && mrSplFms.size() > 0) {
			for (MrSplFm mrSplFm : mrSplFms) {
				String string=mrSplFm.getContent()==null?"":mrSplFm.getContent();
				if (map.get(mrSplFm.getName()) != null) {
					map.put(mrSplFm.getName(), map.get(mrSplFm.getName()) + ";" + string);
				} else {
					map.put(mrSplFm.getName(), string);
				}
			}
		}
		resultMap.setData(map);
		return resultMap;
	}

	@Override
	public SingleResult<List<MrSplFmValue>> splFmTypeData(String enPk,String fmType) throws Throwable {
		SingleResult<List<MrSplFmValue>> result=new SingleResult<List<MrSplFmValue>>();
		List<MrSplFmValue> list=new ArrayList<MrSplFmValue>();
		if(!StringUtils.isBlank(enPk)&&!StringUtils.isBlank(fmType)){
			List<MrSplFm> mrSplFms = cusMrSplFmDao.selectAll(enPk,Integer.valueOf(fmType),null);
			if(mrSplFms!=null&&mrSplFms.size()>0){
				for (MrSplFm mrSplFm : mrSplFms) {
					MrSplFmValue msf=new MrSplFmValue();
					msf.setKey(mrSplFm.getName());
					msf.setValue(mrSplFm.getContent());
					msf.setFmType(mrSplFm.getFmType());
					msf.setFmName(mrSplFm.getFmName());
					list.add(msf);
				}
			}
		}
		result.setData(list);
		return result;
	}
	

	@Override
	public SingleResult<Map<String,Object>> searchPrintMrs(Map<String, String> param) throws Throwable {
		SingleResult<Map<String,Object>> result=new SingleResult<Map<String,Object>>();
		Map<String,Object> map=new HashMap<String, Object>();
		List<MedicalRecord> resultMrs=new ArrayList<MedicalRecord>();
		String enPk = param.get("enPk");
		String tpCcatCd = param.get("tpCcatCd");
		String DctNsF = param.get("DctNsF");
		String pageNum = null;
		String pageSize = null;
		if (param.containsKey("pageNum") && param.containsKey("pageSize")) {
			pageNum = (String) param.get("pageNum");
			pageSize = (String) param.get("pageSize");
		}
		if (!StringUtils.isNumeric(pageNum) || !StringUtils.isNumeric(pageSize)) {
			pageNum = "1";
			pageSize = "20";
		}
		if (StringUtils.isBlank(pageNum)) {
			pageNum = "1";
		}
		if (StringUtils.isBlank(pageSize)) {
			pageSize = "20";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		List<Mr> mrs= cusMrDao.selectBatchPrintMrs(enPk, tpCcatCd, DctNsF, options);
		if(mrs!=null&&mrs.size()>0){
			for (Mr mr : mrs) {
				MedicalRecord medicalRecord=new MedicalRecord();
				BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
				medicalRecord.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
				medicalRecord.setLastUpdateUserName(IihUtils.userIdToName(dataObjectService, mr.getLastUpdUserId()));
				resultMrs.add(medicalRecord);
			}
		}
		map.put("total", options.getCount());
		map.put("mrs", resultMrs);
		result.setData(map);
		return result;
	}

	@Override
	public SingleResult<Map<String, String>> checkFinish(String enPk) throws Throwable {
		// TODO Auto-generated method stub
		SingleResult<Map<String, String>> result=new SingleResult<Map<String,String>>();
		Map<String, String> map=new HashMap<String, String>();//位整改的，未审签的
		List<Mr> mrs= cusMrDao.selectByEnPk(enPk, null, null, null, 0, null);
		String msg="";
		Integer count= cusQaFltItmDao.selectCountQaFltByEnPk("QAM13.01", enPk);
		if(count>0){
			msg="请到【护士工作站，环节质控通知】完成整改项。";
		}
		String submitMsg="";
		String approveMsg="";
		if(mrs!=null&&mrs.size()>0)
		for (Mr mr : mrs) {//检查病历审签流程是否完成
			if((mr.getCompletedF()+"").equals("0")){
					if(mr.getSignLvlCd()!=null&&mr.getSignLvlCd().equals(MrSignLevel.NEED_NOT_SIGN)){
						submitMsg+=mr.getNm()+"、";
					}else{
						approveMsg+=mr.getNm()+"、";
					}
			}
		}
		if(!StringUtils.isBlank(submitMsg)){
			submitMsg=submitMsg.substring(0,submitMsg.length()-1);
			msg+="【"+submitMsg+"】需要提交，";
		}
		if(!StringUtils.isBlank(approveMsg)){
			approveMsg=approveMsg.substring(0,approveMsg.length()-1);
			msg+="【"+approveMsg+"】需要审签完成。";
		}
		if(!StringUtils.isBlank(msg)){
			msg=msg.substring(0,msg.length()-1);
			msg+="！";
		}
		map.put("msg", msg);
		result.setData(map);
		return result;
	}

}
