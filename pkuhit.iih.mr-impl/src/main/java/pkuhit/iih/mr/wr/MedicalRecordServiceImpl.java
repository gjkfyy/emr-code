package pkuhit.iih.mr.wr;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import pkuhit.iih.iemr.pub.CaUtil;
import pkuhit.iih.mr.MrToCisService;
import pkuhit.iih.mr.dao.auto.CaDataDao;
import pkuhit.iih.mr.dao.auto.MdMrParaDao;
import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.MrDao;
import pkuhit.iih.mr.dao.auto.MrDocValueDao;
import pkuhit.iih.mr.dao.auto.MrParaDao;
import pkuhit.iih.mr.dao.auto.MrSignDao;
import pkuhit.iih.mr.dao.auto.MrTplDao;
import pkuhit.iih.mr.dao.auto.entity.CaData;
import pkuhit.iih.mr.dao.auto.entity.MdMrPara;
import pkuhit.iih.mr.dao.auto.entity.MdMrTpPara;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.dao.auto.entity.MrDocValue;
import pkuhit.iih.mr.dao.auto.entity.MrPara;
import pkuhit.iih.mr.dao.auto.entity.MrTpl;
import pkuhit.iih.mr.md.MrSignLevel;
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
import pkuhit.iih.mr.wr.dao.CusCaDataDao;
import pkuhit.iih.mr.wr.dao.CusMdMrTpParaDao;
import pkuhit.iih.mr.wr.dao.CusMrAmrDao;
import pkuhit.iih.mr.wr.dao.CusMrDao;
import pkuhit.iih.mr.wr.dao.CusMrDocValueDao;
import pkuhit.iih.mr.wr.dao.CusMrSignDao;
import pkuhit.iih.mr.wr.dao.CusQaItemMrTpDao;
import pkuhit.iih.pub.IihUtils;
import pkuhit.iih.pub.PerformancePrinter;
import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.dao.auto.entity.QaItemMrTp;
import pkuhit.iih.qa.md.QaStaus;
import pkuhit.iih.qa.qamrwite.QaMrTypeService;
import pkuhit.md.DictionaryService;
import pkuhit.md.SysFunctionCode;
import pkuhit.me.DataObject;
import pkuhit.me.DataObjectService;
import pkuhit.org.Employee;
import pkuhit.org.WorkGroupEmpService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserRoleService;
import pkuhit.xap.ac.UserService;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.ru.engin.validate.ValidateResult;
import xap.sv.annotation.Reference;
import xap.sv.app.Application;
import xap.sv.dao.DaoFactory;
import xap.sv.event.engin.EventEngin;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.Composite;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;
import xap.sv.model.TreeResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.UUIDGenerator;

/**
 * 
 * <p>
 * MedicalRecordServiceImpl
 * </p>
 * 医疗记录服务
 * 
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李春学</td>
 *          <td>2015年1月14日 上午9:15:52</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class MedicalRecordServiceImpl implements MedicalRecordService {

	private Logger log = LoggerFactory.getLogger(MedicalRecordServiceImpl.class);
	@Autowired
	CusMrAmrDao cusMrAmrDao;

	@Reference
	AmrService amrService;

	@Reference
	UserService userService;

	@Reference
	ParamsSetService paramsSetService;

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
	MrToCisService mrToCisService;
	
	@Reference
	UserRoleService userRoleService;
	
	@Reference
	QaMrTypeService qaMrTypeService;
	
	@Reference
	EventEngin eventEngin;
	
	@Autowired
	CaDataDao caDataDao;

	@Autowired
	MrDao mrDao;

	@Autowired
	MrParaDao mrParaDao;
	
	@Autowired
	MdMrTpDao mdMrTpDao;
	
	@Autowired
	MdMrParaDao mdMrParaDao;

	@Autowired
	MrDocValueDao mrDocValueDao;

	@Autowired
	CusMrDocValueDao cusMrDocValueDao;

	@Autowired
	MrSignDao mrSignDao;
	
	@Autowired
	MdMrTpCcatDao mdMrTpCcatDao;
	
	@Autowired
	CusMdMrTpParaDao cusMdMrTpParaDao;

	@Autowired
	MrAmrDao mrAmrDao;

	@Autowired
	CusMrDao cusMrDao;
	
	@Autowired
	CusCaDataDao cusCaDataDao;

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

	private MrActionCheck actionCheck = new MrActionCheck();

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
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		actionCheck.checkCanCreate(amr);
		// 补全数据
		Mr mr = new Mr();

		FileObject xmlFileObject = null;
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		try {
			xmlFileObject = fileService.createFile("biz", value.getXmlFileData().getBytes());
		} catch (Exception e) {
			log.error("业务文件发生错误：xmlFileObject data :" + value.getXmlFileData() + "错误信息如下：");
			e.printStackTrace();
		}
		FileObject txtFileObject = null;
		// 先将txtFile加入bizFile表，将返回id加入mr表
		try {
			txtFileObject = fileService.createFile("biz", value.getTxtFileData().getBytes());
		} catch (Exception e) {
			log.error("业务文件发生错误：txtFileObject data :" + value.getTxtFileData() + "错误信息如下：");
			e.printStackTrace();
		}
		BeanCopyUtil.modelToEntity(mr, value);
		mr.setMrPk(UUIDGenerator.getUUID());
		mr.setEncounterSn(amr.getPk());
		mr.setDeptCd(Session.get().getDeptId());
		if (value.getTimeAutoGenerated() != null && value.getTimeAutoGenerated().equals("1")) {// 树模板新建查房病历
			DataBaseTime dataBaseTime = getDataBaseTime().getData();
			mr.setBizTime(Timestamp.valueOf(dataBaseTime.getDataBaseTime()));
		} else {
			mr.setBizTime(new Timestamp(value.getBizTime().getTime()));
		}
		mr.setMrStaCd(MrStatus.CREATED);
		mr.setCompletedF(Short.valueOf("0"));
		mr.setTreatDoctorCd(amr.getCurMngDctId());
		mr.setDirDoctorCd(amr.getCurDrcDctId());
		mr.setMastDoctorCd(amr.getCurMojDctId());
		mr.setXmlFilePk(xmlFileObject.getId());
		mr.setTxtFilePk(txtFileObject.getId());
		// 字符大字段
		String fileData = value.getFileData();
		// 持久化
		log.debug("fileData is :" + fileData);
		log.debug("null=fileService is :" + Boolean.valueOf(null == fileService));
		// 保存业务文件
		FileObject fileObject = null;
		try {
			fileObject = fileService.createFile("biz", fileData.getBytes());
		} catch (Exception e) {
			log.error("创建业务文件发生错误：fileObject data :" + fileData + "错误信息如下：");
			e.printStackTrace();
		}
		// FileObject fileObject = fileService.createFile("biz",
		// fileData.getBytes());
		mr.setFilePk(fileObject.getId());
		log.debug("null=fileObject is :" + Boolean.valueOf(null == fileObject));
		if (null != fileObject) {
			log.debug("fileObject id is :" + fileObject.getId());
		}
		String mrCheckSavePdf=paramsSetService.searchFunFlagByKey("MR_CHECK_SAVE_PDFDATA").getData();
		// 创建病历保存PDF
		if (mrCheckSavePdf != null && mrCheckSavePdf.equals("1")) {
			String pdfFilePk= IihUtils.updateMrBizFile(mr.getCaFilePk(),value.getMrPdfData(),fileService);
			if(!StringUtils.isEmpty(pdfFilePk))
			mr.setCaFilePk(pdfFilePk);
		}
		// 保存到MR表
		if(value.getUpDocCheckSubmit()!=null&&value.getUpDocCheckSubmit().equals("1")){
			mr.setUpDocCheckSubmit("1");
		}else{
			mr.setUpDocCheckSubmit("0");
		}
		mrDao.insertExludeNull(mr);
		saveDocValue(mr.getEncounterSn(), mr.getMrPk(), value.getReferenceElem());

		// 判断是否是新建时直接点的提交，如果是则调用提交服务
		if (MrStatus.SUBMITTED.equals(value.getStatusCode())) {
			MedicalRecord medicalRecord=this.searchById(mr.getMrPk(), true).getData();
			if(value.getPracticeDoctor()!=null&&value.getPracticeDoctor().equals("1")){
				medicalRecord.setPracticeDoctor("1");
				medicalRecord.setSubmitCd(value.getSubmitCd());
			}
			medicalRecord.setTxtFileData(value.getTxtFileData());
			if(value.getCertId() != "" && value.getCertId() != null){
				medicalRecord.setCertId(value.getCertId());
				medicalRecord.setCertValue(value.getCertValue());
				medicalRecord.setCaData(value.getCaData());
				medicalRecord.setXmlFileData(value.getXmlFileData());
			}
			result = this.sign(mr.getMrPk(), medicalRecord);
			this.fireEvent("SUBMIT_MR", result.getData());
		} else {
			result = this.searchById(mr.getMrPk(), false);
			this.fireEvent("CREATE_MR", result.getData());
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
		// 检查是否可删除
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		MedicalRecord medicalRecord = result.getData();
		actionCheck.checkCanDelete(medicalRecord, userId);

		// 持久化
		Mr mr = new Mr();
		mr.setMrPk(id);
		mr.setDelF(Short.valueOf("1"));

		mr.setUpdCnt(value.getUpdateCount());

		try {
			mrDao.markDelete(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}
		// 删除ca数据
		List<Map<String, Object>> caList = cusCaDataDao.getCaSn(id);
		if(caList.size() >0){
			deleteCaData(caList);
		}
		// 删除xmlfileData
		if (!StringUtils.isEmpty(medicalRecord.getXmlFilePk())) {
			fileService.deleteFile(medicalRecord.getXmlFilePk());
		}
		// 删除txtfileData
		if (!StringUtils.isEmpty(medicalRecord.getTxtFilePk())) {
			fileService.deleteFile(medicalRecord.getTxtFilePk());
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
		this.fireEvent("DELETE_MR", result.getData());
		// 返回被删除的记录
		return result;
	}

	private void deleteCaData(List<Map<String, Object>> caList) {
		DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
		this.caDataDao = df.getDao(CaDataDao.class);
		for(int i=0;i<caList.size();i++){
			String caSn=(String) caList.get(i).get("caSn");
			CaData caData = new CaData();
			caData.setCaSn(caSn);
			caDataDao.markDelete(caData);
			
		}
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
		String userSignLevelCode = this.getSignLevelCode();
		// 检查是否可更新
		SingleResult<MedicalRecord> sr = this.searchById(id, false);
		// 如果不是整改模式，则进行是否可保存权限验证
		if (!value.getReformFlag()) {
			actionCheck.checkCanSave(sr.getData(), amr, userSignLevelCode, userId, dataObjectService);
		}
		// 持久化
		Mr mr = new Mr();
		BeanCopyUtil.modelToEntity(mr, value);
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getXmlFileData())) {
			String xmlFilePk= IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
			if(!StringUtils.isEmpty(xmlFilePk))
			mr.setXmlFilePk(xmlFilePk);
		}
		// 先将txtFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getTxtFileData())) {
			String txtFilePk= IihUtils.updateMrBizFile(mr.getTxtFilePk(),value.getTxtFileData(),fileService);
			if(!StringUtils.isEmpty(txtFilePk))
			mr.setTxtFilePk(txtFilePk);
		}
		log.debug("业务文件[" + value.getFilePk() + "],colb[" + value.getFileData() + "]");
		if (null != value.getFileData() && value.getFileData().trim().length() > 0) {
			try {
				fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());
			} catch (Exception e) {
				log.error("调用文件服务修改文件发生错误，可能业务文件[" + value.getFileData() + "]不存在,错误信息如下：");
				e.printStackTrace();
			}
		}
		String mrCheckSavePdf=paramsSetService.searchFunFlagByKey("MR_CHECK_SAVE_PDFDATA").getData();
		// 创建病历保存PDF
		if (mrCheckSavePdf != null && mrCheckSavePdf.equals("1")) {
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

		saveDocValue(value.getEncounterPk(), value.getMrPk(), value.getReferenceElem());
		MedicalRecord returnData = this.searchById(value.getMrPk(), false).getData();
		// 设置整改模式标识
		returnData.setReformFlag(value.getReformFlag());
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
	@Override
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
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<MedicalRecord> search(Map<String, String> param) throws Throwable {

		ArrayResult<MedicalRecord> result = null;
		ArrayResultBuilder<MedicalRecord> builder = ArrayResultBuilder.newArrayResult(MedicalRecord.class);
		List<MedicalRecord> listMr = new ArrayList<MedicalRecord>();
		String encounterPk = param.get("encounterPk");
		if (null == encounterPk || "".equals(encounterPk.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊序号");
			throw new NotificationException(notification);
		}

		String mrTypeCustomCode = param.get("mrTypeCustomCode");
		String mrType = param.get("mrType");
		String deptCd = param.get("deptCd");
		String withFile = param.get("withFile");
		// 查询就诊对应的医疗记录
		List<Mr> list = cusMrDao.selectByEnPk(encounterPk, mrTypeCustomCode, null, deptCd, 1,mrType);
		if (list == null)
			return null;
		// 此处有循环调用，需要控制记录条数，否则影响性能
		for (Mr mr : list) {
			MedicalRecord medicalRecord = new MedicalRecord();
			BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
			medicalRecord.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
			medicalRecord.setLastUpdateUserName(IihUtils.userIdToName(dataObjectService, mr.getLastUpdUserId()));
			medicalRecord.setMasterDoctorName(IihUtils.userIdToName(dataObjectService, mr.getMastDoctorCd()));
			MdMrTp mdMrTp = mdMrTpDao.selectById(mr.getMrTpCd());
			medicalRecord.setNewPageF(mdMrTp.getNewPageF());
			medicalRecord.setAlonePageF(mdMrTp.getAlonePageF());
			if (null != withFile && "1".equals(withFile)) {
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
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<MedicalRecord> searchForContinuePrint(Map<String, String> param) throws Throwable {

		ArrayResult<MedicalRecord> result = null;
		ArrayResultBuilder<MedicalRecord> builder = ArrayResultBuilder.newArrayResult(MedicalRecord.class);
		List<MedicalRecord> listMr = new ArrayList<MedicalRecord>();
		String encounterPk = param.get("encounterPk");
		if (null == encounterPk || "".equals(encounterPk.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊序号");
			throw new NotificationException(notification);
		}
		String mrTypeCustomCode = param.get("mrTypeCustomCode");
		String deptCd = param.get("deptCd");
		if (null == mrTypeCustomCode || "".equals(mrTypeCustomCode.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "病历类型组编码");
			throw new NotificationException(notification);
		}
//		if (null == deptCd || "".equals(deptCd.trim())) {
//			Notification notification = new Notification(MessageCode.MISS_PARAM, "科室编码");
//			throw new NotificationException(notification);
//		}
		// 查询就诊对应的医疗记录
		List<Mr> list = cusMrDao.selectByEnPkForContinuePrint(encounterPk, mrTypeCustomCode, deptCd);
		if (list == null)
			return null;
		// 此处有循环调用，需要控制记录条数，否则影响性能
		for (Mr mr : list) {
			MedicalRecord medicalRecord = new MedicalRecord();
			BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, null);
			MdMrTp mdMrTp = mdMrTpDao.selectById(mr.getMrTpCd());
			medicalRecord.setNewPageF(mdMrTp.getNewPageF());
			medicalRecord.setAlonePageF(mdMrTp.getAlonePageF());
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
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		String userId = session.getUserId();

		SingleResult<MedicalRecord> result;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		Mr mr = mrDao.selectById(id);
		// 查询就诊
		PerformancePrinter.start("amrService.get");
		Amr amr = amrService.get(mr.getEncounterSn()).getData();
		PerformancePrinter.end("amrService.get");
		if (null == amr) {
			Notification notification = new Notification(MessageCode.AMR_NOT_EXITS, mr.getEncounterSn());
			throw new NotificationException(notification);
		}
		PerformancePrinter.start("getSignLevelCode");
		String userSignLevelCode = this.getSignLevelCode();
		PerformancePrinter.end("getSignLevelCode");
		// 补全数据（用户名转用户名称）
		MedicalRecord medicalRecord = new MedicalRecord();
		PerformancePrinter.start("userIdToName");
		BeanCopyUtil.entityToModel(medicalRecord, mr, MedicalRecord.OBJ_CD, dictionaryService);
		medicalRecord.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
		medicalRecord.setLastUpdateUserName(IihUtils.userIdToName(dataObjectService, mr.getLastUpdUserId()));
		medicalRecord.setSubmitName(IihUtils.userIdToName(dataObjectService, mr.getSubmitCd()));
		medicalRecord.setSuperiorDoctorName(IihUtils.userIdToName(dataObjectService,
				medicalRecord.getSuperiorDoctorId()));
		medicalRecord.setTreatDoctorName(IihUtils.userIdToName(dataObjectService, medicalRecord.getTreatDoctorCd()));
		medicalRecord.setMasterDoctorName(IihUtils.userIdToName(dataObjectService, mr.getMastDoctorCd()));
		medicalRecord.setDirDoctorName(IihUtils.userIdToName(dataObjectService, medicalRecord.getDirDoctorCd()));
		PerformancePrinter.end("userIdToName");
		PerformancePrinter.start("MrTemplate");
		MrTpl po = autoGenDao.selectById(mr.getMrTplCd());
		if (null != po) {
			medicalRecord.setTempleName(po.getNm());
		}
		PerformancePrinter.end("MrTemplate");
		// 增加一列记录自定义类型组编码
		PerformancePrinter.start("mrTypeCustomCode");
		String enTypeCd = amrService.getAmr(medicalRecord.getEncounterPk()).getData().getEncounterTypeCode();
		List<MdMrTpCcatItm> ccatItms = cusMdMrTpCcatItmDao.getMdMrTpCcatItmByTemplateTypeAndEnTpCd(
				medicalRecord.getTypeCode(), enTypeCd);
		String mrTypeCustomCode = "";
		for (MdMrTpCcatItm ccatItm : ccatItms) {
			if ("".equals(mrTypeCustomCode)) {
				mrTypeCustomCode = ccatItm.getMrTpCcatCd();
			} else {
				mrTypeCustomCode = mrTypeCustomCode + "," + ccatItm.getMrTpCcatCd();
			}
		}
		PerformancePrinter.end("mrTypeCustomCode");
		medicalRecord.setMrTypeCustomCode(mrTypeCustomCode);
		medicalRecord.setUserSignLevelCode(userSignLevelCode);
		if (withFile) {
			// 获取业务文件
			FileObject fileObject = null;
			try {
				fileObject = fileService.getFile(medicalRecord.getFilePk());
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
		PerformancePrinter.start("getFstCd");
		// 加上质控项目一级分类属性--王艳丽
		List<QaItemMrTp> qaItemMrTps = cusQaItemMrTpDao.selectByMrTpCd(medicalRecord.getTypeCode());
		if (null != qaItemMrTps && qaItemMrTps.size() == 1) {
			medicalRecord.setFirstCode(qaItemMrTps.get(0).getFstCd());
		}
		PerformancePrinter.end("getFstCd");

		PerformancePrinter.start("getContinuePrintF");
		// 增加是否可续打标识
		MdMrTpCcat mdMrTpCcat = mdMrTpCcatDao.selectById(mrTypeCustomCode);
		//medicalRecord.setCanContinuePrint(mdMrTpCcat.getContinuePrintF());
		PerformancePrinter.end("getContinuePrintF");

		PerformancePrinter.start("getNewPageF");
		// 增加是否新起一页打印标识
		MdMrTp mdMrTp = mdMrTpDao.selectById(mr.getMrTpCd());
		//medicalRecord.setNewPageF(mdMrTp.getNewPageF());
		//medicalRecord.setPermitF(mdMrTp.getPermitF() == null ? 1 : mdMrTp.getPermitF());
		PerformancePrinter.end("getNewPageF");
		PerformancePrinter.start("setActionFlag");
		// 检查全部的5个操作标志，并赋予医疗记录对象
		medicalRecord = actionCheck.setActionFlag(medicalRecord, amr, userSignLevelCode, userId, dataObjectService);
		PerformancePrinter.end("setActionFlag");
		medicalRecord.setAmr(amr);
		builder.withData(medicalRecord);
		result = builder.build();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#sign(java.lang.String,
	 * pkuhit.iih.mr.wr.MedicalRecord)
	 */
	@Transactional
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
		if(value.getPracticeDoctor()!=null&&value.getPracticeDoctor().equals("1")){
			mr.setSubmitCd(value.getSubmitCd());
		}else{
			mr.setSubmitCd(userId);
		}
		if(value.getUpDocCheckSubmit()!=null&&value.getUpDocCheckSubmit().equals("1")){
			mr.setUpDocCheckSubmit("1");
		}else{
			mr.setUpDocCheckSubmit("0");
		}
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
		// 先将txtFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getTxtFileData())) {
			String txtFilePk= IihUtils.updateMrBizFile(mr.getTxtFilePk(),value.getTxtFileData(),fileService);
			if(!StringUtils.isEmpty(txtFilePk))
			mr.setTxtFilePk(txtFilePk);
		}
		
		// 设置完成标志
		if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLvlCd()) || mr.getSignLvlCd().equals(MrSignLevel.NEED_NOT_SIGN)) {
			// 当提交后，如果医疗记录审签等级为一级审签，则不需要继续进行审签
			mr.setCompletedF(Short.valueOf("1"));
		}
		// 设置整改状态
		if (mr.getCompletedF() == 1
				&& (QaStaus.REFORM_FAULT_RECEIVED_.equals(mr.getMrQaStaCd()) || QaStaus.REFORM_FAULT_SUBMITTED
						.equals(mr.getMrQaStaCd()))) {
			mr.setMrQaStaCd(QaStaus.REFORM_FAULT__COMPLETED);
		}
		// 提交人如果是经治医师的话，把经治医师带入病历的经治医师里面
		if (userId.equals(amr.getCurMngDctId())) {
			mr.setTreatDoctorCd(userId);
		}
		mr.setUpdCnt(value.getUpdateCount());

		// 设置三级捡诊医师
		mr.setTreatDoctorCd(amr.getCurMngDctId());
		mr.setDirDoctorCd(amr.getCurDrcDctId());
		mr.setMastDoctorCd(amr.getCurMojDctId());
		String mrCheckSavePdf=paramsSetService.searchFunFlagByKey("MR_CHECK_SAVE_PDFDATA").getData();
		// 创建病历保存PDF
		if (mrCheckSavePdf != null && mrCheckSavePdf.equals("1")) {
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

		//保存北京ca数据
		if(value.getCertId() != "" && value.getCertId() != null){
			String module = "MEM";//提交
			saveCaData(value,userId,id,module);
		}
		// 保存引用元素
		saveDocValue(value.getEncounterPk(), value.getMrPk(), value.getReferenceElem());
		// 返回最新的医疗记录对象
		SingleResult<MedicalRecord> result = this.searchById(id, false);
		this.fireEvent("SUBMIT_MR", result.getData());
		return result;
	}

	private void saveCaData(MedicalRecord value,String userId,String id,String module) throws Exception {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		//获取时间戳
		String tsRep = CaUtil.getTimeStamp(value.getXmlFileData());
		/*FileObject caDataFileObject = null;
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		try {
			caDataFileObject = fileService.createCaFile("cadata", value.getXmlFileData().getBytes(),tsRep);
		} catch (Exception e) {
			log.error("业务文件发生错误：caDataFileObject data :" + value.getXmlFileData() + "错误信息如下：");
			e.printStackTrace();
		}*/
		CaData cadata = new CaData();
		DaoFactory df = Application.getInstance().getBundleContext().getServiceOfType(DaoFactory.class);
		this.caDataDao = df.getDao(CaDataDao.class);
        Clob clob = caDataDao.createClob();
        String data = new String(value.getXmlFileData());//病历原文
        clob.setString(1, data);
        Clob clob1 = caDataDao.createClob();
        String data1 = new String(value.getCaData());//签名值
        clob1.setString(1, data1);
        Clob clob2 = caDataDao.createClob(); 
        String data2 = new String(tsRep); //时间戳
        clob2.setString(1, data2);
        cadata.setCaSn(UUIDGenerator.getUUID());
        cadata.setDataXml(clob);
        cadata.setCaData(clob1);
        cadata.setTsData(clob2);
        cadata.setCertValue(value.getCertValue());
        cadata.setEmpId(userId);
        cadata.setEnPk(value.getEncounterPk());
        cadata.setDataId(id);//文书id
        cadata.setCertId(value.getCertId());
        cadata.setCreateTime(date);
		cadata.setSysCode("CIS");
		cadata.setModule(module);
		caDataDao.insertExludeNull(cadata);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#cancelSigned(java.lang.String,
	 * pkuhit.iih.mr.wr.MedicalRecord)
	 */
	@Transactional
	@Override
	public SingleResult<MedicalRecord> cancelSigned(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
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

		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		// 设置完成标志
		mr.setCompletedF(Short.valueOf("0"));
		// 设置整改状态
		if (QaStaus.REFORM_FAULT__COMPLETED.equals(mr.getMrQaStaCd()))
			mr.setMrQaStaCd(QaStaus.REFORM_FAULT_RECEIVED_);
		// 查询当前医疗记录的医疗记录状态
		// DataObject dataObject = dataObjectService.getObject("MRM04",
		// mr.getMrStaCd());
		// MrStatus mrStatus = dataObject.getObject(MrStatus.class);
		// 将mr的状态改为上一个状态
		mr.setMrStaCd(MrStatus.CREATED);

		mr.setUpdCnt(value.getUpdateCount());
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getXmlFileData())) {
			String xmlFilePk= IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
			if(!StringUtils.isEmpty(xmlFilePk))
			mr.setXmlFilePk(xmlFilePk);
		}
		// 先将txtFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getTxtFileData())) {
			String txtFilePk= IihUtils.updateMrBizFile(mr.getTxtFilePk(),value.getTxtFileData(),fileService);
			if(!StringUtils.isEmpty(txtFilePk))
			mr.setTxtFilePk(txtFilePk);
		}

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
		this.fireEvent("REVOKE_MR", result.getData());
		return result;
	}

	private void fireEvent(String eventCode, MedicalRecord medicalRecord) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(eventCode, medicalRecord);
		eventEngin.fire(eventCode, map);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#reject(java.lang.String,
	 * pkuhit.iih.mr.wr.MedicalRecord)
	 */
	@Transactional
	@Override
	public SingleResult<MedicalRecord> reject(String id, MedicalRecord value) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();
		Amr amr = amrService.get(value.getEncounterPk()).getData();
		String userSignLevelCode = this.getSignLevelCode();
		// 检查是否可以签名
		actionCheck.checkCanReject(value, amr, userSignLevelCode, userId, dataObjectService);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());

		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		// 补全数据
		// 将mr的完成标志置为0
		mr.setCompletedF(Short.valueOf("0"));
		// 设置医疗记录状态为上一个状态
		MrStatus mrStatus = dataObjectService.getObject(MrStatus.OBJ_CD, mr.getMrStaCd()).getObject(MrStatus.class);
		MrStatus preMrStatusCode = dataObjectService.getObject(MrStatus.OBJ_CD, mrStatus.getPreMrStatusCode())
				.getObject(MrStatus.class);
		mr.setMrStaCd(preMrStatusCode.getPreMrStatusCode());

		mr.setUpdCnt(value.getUpdateCount());
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getXmlFileData())) {
			String xmlFilePk= IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
			if(!StringUtils.isEmpty(xmlFilePk))
			mr.setXmlFilePk(xmlFilePk);
		}
		// 先将txtFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getTxtFileData())) {
			String txtFilePk= IihUtils.updateMrBizFile(mr.getTxtFilePk(),value.getTxtFileData(),fileService);
			if(!StringUtils.isEmpty(txtFilePk))
			mr.setTxtFilePk(txtFilePk);
		}
		String mrCheckSavePdf=paramsSetService.searchFunFlagByKey("MR_CHECK_SAVE_PDFDATA").getData();
		// 创建病历保存PDF
		if (mrCheckSavePdf != null && mrCheckSavePdf.equals("1")) {
			String pdfFilePk= IihUtils.updateMrBizFile(mr.getCaFilePk(),value.getMrPdfData(),fileService);
			if(!StringUtils.isEmpty(pdfFilePk))
			mr.setCaFilePk(pdfFilePk);
		}
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#createMrInit()
	 */
	@Override
	public SingleResult<MedicalRecordCreateInit> createMrInit(Map<String, String> value) throws Throwable {
		String enTypeCd = value.get("enTypeCd");
		String doctorNuserFlagStr = value.get("doctorNuserFlag");
		int doctorNuserFlag = 1;// 默认为医生的
		if (!StringUtils.isEmpty(doctorNuserFlagStr)) {
			doctorNuserFlag = Integer.parseInt(value.get("doctorNuserFlag"));
		}
		if (null == enTypeCd) {
			enTypeCd = EncounterType.INPATIENT;
		}
		SingleResult<MedicalRecordCreateInit> result;
		SingleResultBuilder<MedicalRecordCreateInit> builder = SingleResultBuilder
				.newSingleResult(MedicalRecordCreateInit.class);
		MedicalRecordCreateInit medicalRecordCreateInit = new MedicalRecordCreateInit();
		Map<String, String> map = new HashMap<String, String>();
		if (enTypeCd.equals(EncounterType.EMERGENCY) || enTypeCd.equals(EncounterType.OUTPATIENT)
				|| enTypeCd.equals(EncounterType.EMERGENCY_OBSERVATION)) {
			Param[] params = paramsService.getParam(SysFunctionCode.SEARCH_TEMPLATE_CONFIG).getDataList();
			if (params.length > 0) {
				String flag = params[0].getValue();
				if ("1".equals(flag)) {
					medicalRecordCreateInit.setSearchTemplateConfig(flag);
				}
			}
		}
		map.put("enTypeCd", enTypeCd);
		map.put("mrTpCcatCd", null);
		//不再返回病历类型
	//	medicalRecordCreateInit.setMrTypes(this.getMrTypesByMrTypeCustomCategoryCd(map).getDataList());
		medicalRecordCreateInit.setMrTypeCustomCategorys(this.getMrTypeCustomCategorysByEnTypeCd(enTypeCd,
				doctorNuserFlag));
		//不再返回上级医师
//		String deptCd = value.get("deptCd");
//		medicalRecordCreateInit.setEmployees(this.getSuperDoctors(deptCd));
		SingleResult<String> str = paramsSetService.searchFunFlagByKey("DESELECTED_ENABLED");

		if (!StringUtils.isEmpty(str.getData()) && str.getData().equals("0")) {
			// 全选开关值为0择返回false
			medicalRecordCreateInit.setDeselectedEnabled(false);
		} else {
			medicalRecordCreateInit.setDeselectedEnabled(true);
		}
		builder.withData(medicalRecordCreateInit);
		result = builder.build();
		return result;
	}

	/**
	 * 根据就诊类型查询对应医疗记录自定义分类
	 * 
	 * @param enTypeCd
	 * @return
	 */
	public List<MrTypeCustomCategory> getMrTypeCustomCategorysByEnTypeCd(String enTypeCd, int doctorNuserFlag) {

		List<MrTypeCustomCategory> mrTypeCustomCategorys = new ArrayList<MrTypeCustomCategory>();
		List<MdMrTpCcat> mdMrTpCcats = cusMdMrTpCcatDao.selectByEnTpCd(enTypeCd, doctorNuserFlag);
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

	@Override
	public TreeResult<MrTreeData> tree(Map<String, String> condition) {
		// ■ 校验参数
		String encounterCode = condition.get("encounterCode");
		if (StringUtils.isBlank(encounterCode)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊编码");
			throw new NotificationException(notification);
		}

		String custCategoryCode = condition.get("custCategoryCode");

		// ■　查询导航树数据
		Composite<MrTreeData> treeNode = null;

		MrTreeData treeData = new MrTreeData();
		treeData.setEncounterCode(encounterCode);
		treeData.setCustCategoryCode(custCategoryCode);
		treeNode = new MrCustCategoryNode(treeData, condition);

		// 加载树数据
		treeNode.loadChildren();
		treeNode.setupCounter();

		// ■　设置返回值
		TreeNode<MrTreeData> root = new TreeNode<MrTreeData>();
		// 根据加载模式装载树结构数据到返回结果树
		String loadMode = condition.get("loadMode");
		if ("2".equals(loadMode)) {
			treeNode.shallowCopyToTreeNode(root);
		} else {
			treeNode.copyToTreeNode(root);
		}
		// TreeResult<MrTreeData> result = new TreeResult<MrTreeData>();
		// result.setRoot(root);
		// return result;

		TreeResultBuilder<MrTreeData> newTreeResult = TreeResultBuilder.newTreeResult(MrTreeData.class);
		newTreeResult.withRoot(root);
		TreeResult<MrTreeData> build = newTreeResult.build();
		return build;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public SingleResult<Map> mrDocTree(Map<String, String> condition) throws Throwable {
		// 返回结果map
		Map mapResult = new HashMap();
		SingleResult<Map> result = new SingleResult<Map>();
		mapResult.put("text", "root");
		// 住院
		String encounterPk = condition.get("encounterPk");
		// 住院
		String showAllCourse = condition.get("showAllCourse");
		//返回提交后的病历
		String mrType = condition.get("mrType");
		String enTpCd = amrService.getAmr(encounterPk).getData().getEncounterTypeCode();
		if (EncounterType.EMERGENCY.equals(enTpCd)) {// 急诊没有单独的portal的，所以查病历树时暂时和门诊一致
			enTpCd = EncounterType.OUTPATIENT;
		}
		// String enTpCd = EncounterType.INPATIENT;
		List<MdMrTpCcat> mdMrTpCcatList = cusMdMrTpCcatDao.selectMrDocTree(enTpCd, encounterPk, null);

		List<Map> mapChilds = new ArrayList<Map>();
		if (null != mdMrTpCcatList && mdMrTpCcatList.size() > 0) {
			for (int i = 0; i < mdMrTpCcatList.size(); i++) {
				// 得到分类下的文书列表
				List<Map<String, Object>> mrlist = null;
				if(!StringUtils.isBlank(mrType)&&mrType.equals("MRM04.01")){
					mrlist = cusMrDao.selectMrByEnPk(encounterPk, mdMrTpCcatList.get(i).getMrTpCcatCd(), null,mrType);
				}else{
					mrlist = cusMrDao.selectMrByEnPk(encounterPk, mdMrTpCcatList.get(i).getMrTpCcatCd(), null,null);
				}
				Map mapChild = new HashMap();
				String mrTpCcatCd = mdMrTpCcatList.get(i).getMrTpCcatCd();
				// String mdMrTpCcatNm=mdMrTpCcatList.get(i).getNm();
				mapChild.put("ccatCode", mdMrTpCcatList.get(i).getMrTpCcatCd());
				mapChild.put("text", mdMrTpCcatList.get(i).getNm());

				List<Map> mrMaps = new ArrayList<Map>();

				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				boolean bool=false;
				if (mrlist.size() > 0) {
					if ("1".equals(showAllCourse)) {
						MdMrTpCcat mdMrTpCcat = mdMrTpCcatDao.selectById(mrTpCcatCd);
						if (1 == mdMrTpCcat.getContinuePrintF()) {
							Map mrMap = new HashMap();
							mrMap.put("mrTpCcatCd", mrTpCcatCd);
							mrMap.put("text", "全部" + mdMrTpCcat.getNm());
							mrMap.put("leaf", true);
							mrMaps.add(mrMap);
						}
					}
					for (int j = 0; j < mrlist.size(); j++) {
						// 得到文书创建时间，转换格式
						// Timestamp crtTime = mrlist.get(j).getSubmitDate();
						Object crtTime = mrlist.get(j).get("CRT_TIME");
						String timeStr = sdf.format(crtTime);
						Map mrMap = new HashMap();
						mrMap.put("mrPk", mrlist.get(j).get("MR_PK"));
						mrMap.put("text", mrlist.get(j).get("NM") + "_" + timeStr + "_" + mrlist.get(j).get("USER_NM"));
						mrMap.put("leaf", true);
						mrMap.put("nm", mrlist.get(j).get("NM"));
						mrMaps.add(mrMap);
					}
					if(mrMaps.size()>0)bool=true;
					mapChild.put("children", mrMaps);
				} else {
					mapChild.put("leaf", true);
				}
				if(bool)
				mapChilds.add(mapChild);
			}
			mapResult.put("expanded", "true");
			mapResult.put("children", mapChilds);
		}
		result.setData(mapResult);
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public SingleResult<Map> sortTree(Map<String, String> condition) {
		// 返回结果map
		Map mapResult = new HashMap();
		SingleResult<Map> result = new SingleResult<Map>();
		mapResult.put("text", "root");
		// 住院
		String encounterPk = condition.get("encounterPk");
		String enTpCd = EncounterType.INPATIENT;
		List<MdMrTpCcat> mdMrTpCcatList = cusMdMrTpCcatDao.selectSortTree(enTpCd, encounterPk, 1);
		List<Map> mapChilds = new ArrayList<Map>();
		if (null != mdMrTpCcatList && mdMrTpCcatList.size() > 0) {
			Map all = new HashMap();
			all.put("id", "");
			all.put("text", mdMrTpCcatList.get(mdMrTpCcatList.size() - 1).getNm());
			all.put("leaf", true);
			mapChilds.add(all);
			for (int i = 0; i < mdMrTpCcatList.size() - 1; i++) {
				Map mapChild = new HashMap();
				mapChild.put("id", mdMrTpCcatList.get(i).getMrTpCcatCd());
				mapChild.put("text", mdMrTpCcatList.get(i).getNm());
				mapChild.put("leaf", true);
				mapChilds.add(mapChild);
			}
			mapResult.put("expanded", "true");
			mapResult.put("children", mapChilds);
		}
		result.setData(mapResult);
		return result;
	}

	@Override
	public ArrayResult<SignMr> getSignedPatients(Map<String, String> condition) throws Throwable {
		ArrayResult<SignMr> result = null;
		ArrayResultBuilder<SignMr> build = ArrayResultBuilder.newArrayResult(SignMr.class);
		String userId = (String) condition.get("userId");
		String deptCd = condition.get("deptCd");
		List<Map<String, Object>> mrList = cusMrDao.selectSignedPatients(userId, deptCd);
		SignMr[] signMrs = new SignMr[mrList.size()];
		for (int i = 0; i < mrList.size(); i++) {
			SignMr signMr = new SignMr();
			Map<String, Object> map = mrList.get(i);
			BeanCopyUtil.mapToModel(signMr, map);
			signMrs[i] = signMr;
		}
		if (signMrs.length > 0) {
			build.withData(signMrs);
		}
		result = build.build();
		result.setTotal(signMrs.length);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#getSignedMrs(java.util.Map)
	 */
	@Override
	public ArrayResult<SignMr> getSignedMrs(Map<String, String> condition) throws Throwable {
		ArrayResult<SignMr> result = null;
		ArrayResultBuilder<SignMr> build = ArrayResultBuilder.newArrayResult(SignMr.class);
		String userId = (String) condition.get("userId");
		String deptCd = condition.get("deptCd");
		String patientId = condition.get("patientId");
		String pageNum = null;
		String pageSize = null;
		if (condition.containsKey("pageNum") && condition.containsKey("pageSize")) {
			pageNum = (String) condition.get("pageNum");
			pageSize = (String) condition.get("pageSize");
		}
		if (!StringUtils.isNumeric(pageNum) || !StringUtils.isNumeric(pageSize)) {
			pageNum = "1";
			pageSize = "25";
		}
		if (StringUtils.isBlank(pageNum)) {
			pageNum = "1";
		}
		if (StringUtils.isBlank(pageSize)) {
			pageSize = "25";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize))
				.limit(Integer.valueOf(pageSize)).count();

		List<Map<String, Object>> mrList = cusMrDao.selectSignedMrs(userId, deptCd, patientId, options);
		SignMr[] signMrs = new SignMr[mrList.size()];
		for (int i = 0; i < mrList.size(); i++) {
			SignMr signMr = new SignMr();
			Map<String, Object> map = mrList.get(i);
			BeanCopyUtil.mapToModel(signMr, map);
			signMrs[i] = signMr;
		}
		if (signMrs.length > 0) {
			build.withData(signMrs);
		}
		result = build.build();
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		result = build.build();
		result.setTotal(total);
		return result;
	}

	/**
	 * 根据就诊序号和userId查询审签等级
	 * 
	 * @param encounterPk
	 * @param userId
	 * @return
	 * @throws Throwable
	 */
	@Override
	public String getSignLevelCode() throws Throwable {
		User user = signUserService.searchSignUser().getData();
		return user.getSignLevelCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.mr.wr.MedicalRecordService#getWaitSignedMrs(java.util.Map)
	 */
	@Override
	public ArrayResult<SignMr> getWaitSignedMrs(Map<String, String> condition) throws Throwable {
		ArrayResult<SignMr> result = null;
		ArrayResultBuilder<SignMr> build = ArrayResultBuilder.newArrayResult(SignMr.class);
		String userId = (String) condition.get("userId");
		String pageNum = null;
		String deptCd = condition.get("deptCd");
		String pageSize = null;
		if (condition.containsKey("pageNum") && condition.containsKey("pageSize")) {
			pageNum = (String) condition.get("pageNum");
			pageSize = (String) condition.get("pageSize");
		}
		if (!StringUtils.isNumeric(pageNum) ||!StringUtils.isNumeric(pageSize)) {
			pageNum = "1";
			pageSize = "25";
		}
		if (StringUtils.isBlank(pageNum)) {
			pageNum = "1";
		}
		if (StringUtils.isBlank(pageSize)) {
			pageSize = "25";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize))
				.limit(Integer.valueOf(pageSize)).count();

		List<Map<String, Object>> mrList = cusMrDao.selectWaitSignedMrs(userId, deptCd, options);
		SignMr[] signMrs = new SignMr[mrList.size()];
		for (int i = 0; i < mrList.size(); i++) {
			SignMr signMr = new SignMr();
			Map<String, Object> map = mrList.get(i);
			BeanCopyUtil.mapToModel(signMr, map);
			signMrs[i] = signMr;
		}
		if (signMrs.length > 0) {
			build.withData(signMrs);
		}
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		result = build.build();
		result.setTotal(total);
		return result;
	}

	@Override
	public ArrayResult<SignMr> getWaitDeptSignedMrs(Map<String, String> condition) throws Throwable {
		ArrayResult<SignMr> result = null;
		ArrayResultBuilder<SignMr> build = ArrayResultBuilder.newArrayResult(SignMr.class);
		String userId = (String) condition.get("userId");
		String deptCd = condition.get("deptCd");
		String patientId = condition.get("patientId");
		String pageNum = null;
		String pageSize = null;
		if (condition.containsKey("pageNum") && condition.containsKey("pageSize")) {
			pageNum = (String) condition.get("pageNum");
			pageSize = (String) condition.get("pageSize");
		}
		if ( !StringUtils.isNumeric(pageNum) || !StringUtils.isNumeric(pageSize)) {
			pageNum = "1";
			pageSize = "25";
		}
		if (StringUtils.isBlank(pageNum)) {
			pageNum = "1";
		}
		if (StringUtils.isBlank(pageSize)) {
			pageSize = "25";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize))
				.limit(Integer.valueOf(pageSize)).count();

		List<Map<String, Object>> mrList = cusMrDao.selectWaitDeptSignedMrs(userId, deptCd, patientId, options);
		SignMr[] signMrs = new SignMr[mrList.size()];
		for (int i = 0; i < mrList.size(); i++) {
			SignMr signMr = new SignMr();
			Map<String, Object> map = mrList.get(i);
			BeanCopyUtil.mapToModel(signMr, map);
			signMrs[i] = signMr;
		}
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		if (signMrs.length > 0) {
			build.withData(signMrs);
		}
		result = build.build();
		result.setTotal(total);
		return result;
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
		if (null == mrTypeCode) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "mrTypeCode【医疗记录类型编码】");
			throw new NotificationException(notification);
		}
		if (null == encounterPk) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "encounterPk【就诊序号】");
			throw new NotificationException(notification);
		}
		Session session = Session.get();
		SingleResult<MedicalRecord> result = null;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		value.setCanCreate(1);

		MdMrTp mdMrTp = mdMrTpDao.selectById(mrTypeCode);
		if (1 == mdMrTp.getOnlyF().intValue()) {
			List<Mr> mrList = cusMrDao.selectByEnPk(encounterPk, null, mrTypeCode, null, 1,null);
			if (mrList.size() > 0) {
				value.setCanCreate(0);
			}
		}
		builder.withData(value);
		result = builder.build();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.wr.MedicalRecordService#approve(java.lang.String,
	 * pkuhit.iih.mr.wr.MedicalRecord)
	 */
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
		String userSignLevelCode = this.getSignLevelCode();
		// 检查是否可以签名
		actionCheck.checkCanApprove(value, amr, userSignLevelCode, userId, dataObjectService);

		// 保存业务文件
		fileService.updateFile(value.getFilePk(), value.getFileData().getBytes());
		// 得到医疗记录
		Mr mr = mrDao.selectById(id);
		Timestamp date = new Timestamp(System.currentTimeMillis());
		// 根据用户审签等级设置医疗记录对应的状态
		if ("MRM16.19".equals(mr.getMrTpCd()) || "MRM16.20".equals(mr.getMrTpCd())) {
			mr.setMrStaCd(MrStatus.SIGNED_LEVEL_2);
			mr.setMastDoctorDate(date);
			mr.setMastDoctorCd(userId);
		} else if (MrSignLevel.LEVEL_TWO_SIGN.equals(userSignLevelCode)) {
			mr.setMrStaCd(MrStatus.SIGNED_LEVEL_2);
			mr.setMastDoctorDate(date);
			mr.setMastDoctorCd(userId);
		} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(userSignLevelCode)) {
			mr.setMrStaCd(MrStatus.SIGNED_LEVEL_3);
			mr.setDirDoctorDate(date);
			mr.setDirDoctorCd(userId);
		}
		FileObject xmlFileObject = null;
		if (!StringUtils.isEmpty(mr.getXmlFilePk())) {
			xmlFileObject = fileService.getFile(mr.getXmlFilePk());
		}
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getXmlFileData())) {
			String xmlFilePk= IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
			if(!StringUtils.isEmpty(xmlFilePk))
			mr.setXmlFilePk(xmlFilePk);
		}
		// 先将txtFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getTxtFileData())) {
			String txtFilePk= IihUtils.updateMrBizFile(mr.getTxtFilePk(),value.getTxtFileData(),fileService);
			if(!StringUtils.isEmpty(txtFilePk))
			mr.setTxtFilePk(txtFilePk);
		}

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
		
		String mrCheckSavePdf=paramsSetService.searchFunFlagByKey("MR_CHECK_SAVE_PDFDATA").getData();
		// 创建病历保存PDF
		if (mrCheckSavePdf != null && mrCheckSavePdf.equals("1")) {
			String pdfFilePk= IihUtils.updateMrBizFile(mr.getCaFilePk(),value.getMrPdfData(),fileService);
			if(!StringUtils.isEmpty(pdfFilePk))
			mr.setCaFilePk(pdfFilePk);
		}
		
		// 持久化
		try {
			mrDao.updateExcludeNull(mr);
		} catch (OptimisticLockException e) {
			Notification msg = null;
			msg = new Notification(MessageCode.OPTIMISTIC_LOCK);
			throw new NotificationException(msg);
		}

		//保存北京ca数据
		if(value.getCertId() != "" && value.getCertId() != null){
			String module = "MRM";//审签
			saveCaData(value,userId,id,module);
		}
		
		// 保存引用元素
		saveDocValue(value.getEncounterPk(), value.getMrPk(), value.getReferenceElem());
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
		String userSignLevelCode = this.getSignLevelCode();
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
		// 先将xmlFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getXmlFileData())) {
			String xmlFilePk= IihUtils.updateMrBizFile(mr.getXmlFilePk(),value.getXmlFileData(),fileService);
			if(!StringUtils.isEmpty(xmlFilePk))
			mr.setXmlFilePk(xmlFilePk);
		}
		// 先将txtFile加入bizFile表，将返回id加入mr表
		if (!StringUtils.isEmpty(value.getTxtFileData())) {
			String txtFilePk= IihUtils.updateMrBizFile(mr.getTxtFilePk(),value.getTxtFileData(),fileService);
			if(!StringUtils.isEmpty(txtFilePk))
			mr.setTxtFilePk(txtFilePk);
		}

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
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		// 得到session
		Session session = Session.get();
		String userId = session.getUserId();
		// Amr amr = amrService.get(value.getEncounterPk()).getData();
		String userSignLevelCode = this.getSignLevelCode();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.mr.wr.MedicalRecordService#searchMrDocValueByMrPk(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public ArrayResult<MrElemValue> searchMrDocValueByMrPk(String id, String enPk) throws Throwable {
		ArrayResult<MrElemValue> result = null;
		ArrayResultBuilder<MrElemValue> builder = ArrayResultBuilder.newArrayResult(MrElemValue.class);
		MrElemValue[] elemValues = new MrElemValue[0];
		if (id.trim().length() > 0) {
			String[] strArray = id.split(",");
			List<String> elemIdList = Arrays.asList(strArray);
			elemValues = getDocValue(enPk, elemIdList);
		}
		if (elemValues.length > 0) {
			builder.withData(elemValues);
		}
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

	@Override
	public SingleResult<ApproveAndSupDoctors> getSuperDoctors(Map<String, String> value) throws Throwable {
		String deptCd = value.get("deptCd");
		SingleResult<ApproveAndSupDoctors> result;
		SingleResultBuilder<ApproveAndSupDoctors> builder = SingleResultBuilder
				.newSingleResult(ApproveAndSupDoctors.class);
		ApproveAndSupDoctors approveAndSupDoctors = new ApproveAndSupDoctors();
		approveAndSupDoctors.setSupDoctors(this.getSuperDoctors(deptCd));
		approveAndSupDoctors.setTwoSignLevelDoctors(this.getApproveDoctors(deptCd, MrSignLevel.LEVEL_TWO_SIGN));
		approveAndSupDoctors.setThreeSignLevelDoctors(this.getApproveDoctors(deptCd, MrSignLevel.LEVEL_THREE_SIGN));
		builder.withData(approveAndSupDoctors);
		result = builder.build();
		return result;
	}

	@Override
	public ArrayResult<SignMr> getWaitDeptSignPatients(Map<String, String> condition) throws Throwable {
		ArrayResult<SignMr> result = null;
		ArrayResultBuilder<SignMr> build = ArrayResultBuilder.newArrayResult(SignMr.class);
		String userId = (String) condition.get("userId");
		String deptCd = condition.get("deptCd");
		List<Map<String, Object>> mrList = cusMrDao.selectWaitDeptSignPatients(userId, deptCd);
		SignMr[] signMrs = new SignMr[mrList.size()];
		for (int i = 0; i < mrList.size(); i++) {
			SignMr signMr = new SignMr();
			Map<String, Object> map = mrList.get(i);
			BeanCopyUtil.mapToModel(signMr, map);
			signMrs[i] = signMr;
		}
		if (signMrs.length > 0) {
			build.withData(signMrs);
		}
		result = build.build();
		result.setTotal(signMrs.length);
		return result;
	}

	/*
	 * @Override public SingleResult<Map> omrDocTree(Map<String, String>
	 * condition) throws Throwable { // 返回结果map Map mapResult = new HashMap();
	 * SingleResult<Map> result = new SingleResult<Map>(); mapResult.put("text",
	 * "root"); // 住院 String encounterPk = condition.get("encounterPk"); // 住院
	 * String showAllCourse = condition.get("showAllCourse"); String enTpCd =
	 * EncounterType.INPATIENT; List<MdMrTpCcat> mdMrTpCcatList =
	 * cusMdMrTpCcatDao.selectMrDocTree(enTpCd, encounterPk);
	 * 
	 * List<Map> mapChilds = new ArrayList<Map>(); if (null != mdMrTpCcatList &&
	 * mdMrTpCcatList.size() > 0) { for (int i = 0; i < mdMrTpCcatList.size();
	 * i++) { // 得到分类下的文书列表 List<Map<String, Object>> mrlist =
	 * cusMrDao.selectMrByEnPk(encounterPk,
	 * mdMrTpCcatList.get(i).getMrTpCcatCd(), null);
	 * 
	 * Map mapChild = new HashMap(); String
	 * mrTpCcatCd=mdMrTpCcatList.get(i).getMrTpCcatCd(); String
	 * mdMrTpCcatNm=mdMrTpCcatList.get(i).getNm(); mapChild.put("ccatCode",
	 * mdMrTpCcatList.get(i).getMrTpCcatCd()); mapChild.put("text",
	 * mdMrTpCcatList.get(i).getNm());
	 * 
	 * List<Map> mrMaps = new ArrayList<Map>();
	 * 
	 * DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); if (mrlist.size() >
	 * 0) { if("1".equals(showAllCourse)){ MdMrTpCcat
	 * mdMrTpCcat=mdMrTpCcatDao.selectById(mrTpCcatCd);
	 * if(1==mdMrTpCcat.getContinuePrintF()){ Map mrMap = new HashMap();
	 * mrMap.put("mrTpCcatCd", mrTpCcatCd); mrMap.put("text",
	 * "全部"+mdMrTpCcat.getNm()); mrMap.put("leaf", true); mrMaps.add(mrMap); } }
	 * for (int j = 0; j < mrlist.size(); j++) { //得到文书创建时间，转换格式 Object crtTime
	 * = mrlist.get(j).get("CRT_TIME"); String timeStr = sdf.format(crtTime);
	 * String mrPk = (String) mrlist.get(j).get("MR_PK"); MedicalRecord
	 * medicalRecord=this.searchById(mrPk, false).getData(); Map mrMap =
	 * this.convertBean(medicalRecord); mrMap.put("text",
	 * mrlist.get(j).get("NM")+"_"+timeStr+"_"+mrlist.get(j).get("USER_NM"));
	 * mrMap.put("leaf", true); mrMaps.add(mrMap); } mapChild.put("children",
	 * mrMaps); } else { mapChild.put("leaf", true); } mapChilds.add(mapChild);
	 * } mapResult.put("expanded", "true"); mapResult.put("children",
	 * mapChilds); } result.setData(mapResult); return result; }
	 */

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
	public static Map convertBean(Object bean) throws IntrospectionException, IllegalAccessException,
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
	public SingleResult<MedicalRecord> searchFilePk(String id) throws Throwable {
		SingleResult<MedicalRecord> result;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		MedicalRecord medicalRecord = new MedicalRecord();
		// 获取业务文件
		FileObject fileObject = null;
		try {
			fileObject = fileService.getFile(id);
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
		builder.withData(medicalRecord);
		result = builder.build();
		return result;
	}

	@Override
	public SingleResult<MedicalRecord> searchFileById(String id) throws Throwable {
		if (null == id || "".equals(id.trim())) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录编码");
			throw new NotificationException(notification);
		}
		SingleResult<MedicalRecord> result;
		SingleResultBuilder<MedicalRecord> builder = SingleResultBuilder.newSingleResult(MedicalRecord.class);
		Mr mr = mrDao.selectById(id);
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setFilePk(mr.getFilePk());
		medicalRecord.setMrPk(mr.getMrPk());
		medicalRecord.setTypeCode(mr.getMrTpCd());
		MdMrTp mdMrTp = mdMrTpDao.selectById(mr.getMrTpCd());
		medicalRecord.setTypeName(mdMrTp.getNm());
		medicalRecord.setCreateUserId(mr.getCrtUserId());
		medicalRecord.setStatusCode(mr.getMrStaCd());
		medicalRecord.setDeptCd(mr.getDeptCd());
		// 获取业务文件
		FileObject fileObject = null;
		try {
			fileObject = fileService.getFile(medicalRecord.getFilePk());
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
		// 加上质控项目一级分类属性--王艳丽
		List<QaItemMrTp> qaItemMrTps = cusQaItemMrTpDao.selectByMrTpCd(medicalRecord.getTypeCode());
		if (null != qaItemMrTps && qaItemMrTps.size() == 1) {
			medicalRecord.setFirstCode(qaItemMrTps.get(0).getFstCd());
		}
		medicalRecord.setFileData(new String(fileObject.asByteArray()));
		builder.withData(medicalRecord);
		result = builder.build();
		return result;
	}

	@Override
	public ArrayResult<MedicalRecord> searchArchivceMrs(Map<String, String> param) throws Throwable {
		ArrayResult<MedicalRecord> result;
		String enPk = param.get("enPk");
		String pageNum = param.get("pageNum");
		String pageSize = param.get("pageSize");
		if (StringUtils.isEmpty(pageNum)) {
			pageNum = "1";
		}
		if (StringUtils.isEmpty(pageSize)) {
			pageSize = "25";
		}
		int total = 0;
		ArrayResultBuilder<MedicalRecord> builder = ArrayResultBuilder.newArrayResult(MedicalRecord.class);
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1) * Integer.valueOf(pageSize))
				.limit(Integer.valueOf(pageSize)).count();
		List<String> mrTypeCodes = null;
		Param[] params = paramsService.getParam(SysFunctionCode.EMR_WRITER_FILE_PATH).getDataList();
		if (params.length > 0) {
			for (Param parameter : params) {
				if (parameter.getKey().equals("TYPE_ARCHIVE_PARAM")) {
					mrTypeCodes = Arrays.asList(parameter.getValue().split(","));
				}
			}
		}
		List<Mr> mrs = cusMrDao.selectMrsByEnPk(enPk, mrTypeCodes, options);
		List<MedicalRecord> medrs = new ArrayList<MedicalRecord>();
		if (mrs != null && mrs.size() > 0) {
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			for (Mr mr : mrs) {
				MedicalRecord medr = new MedicalRecord();
				BeanCopyUtil.entityToModel(medr, mr, MedicalRecord.OBJ_CD, dictionaryService);
				medr.setCreateUserName(IihUtils.userIdToName(dataObjectService, mr.getCrtUserId()));
				// medr.setMasterDoctorName(IihUtils.userIdToName(dataObjectService,
				// mr.getMastDoctorCd()));
				// medr.setNewPageF(mdMrTpDao.selectById(mr.getMrTpCd()).getNewPageF());

				medrs.add(medr);
			}
		}

		builder.withData(medrs.toArray(new MedicalRecord[0]));
		result = builder.build();
		result.setTotal(total);
		return result;
	}

	@Override
	public SingleResult<DataBaseTime> getDataBaseTime() {
		// TODO Auto-generated method stub
		SingleResult<DataBaseTime> result = new SingleResult<DataBaseTime>();
		DataBaseTime ogd = new DataBaseTime();
		ogd.setDataBaseTime(cusMrAmrDao.selectOracleDate());
		result.setData(ogd);
		return result;
	}

	@Override
	public SingleResult<MedicalRecord> checkMrPrint(String id) throws Throwable {
		SingleResult<MedicalRecord> result = new SingleResult<MedicalRecord>();
		MedicalRecord medicalRecord = new MedicalRecord();
		Param[] params = paramsService.getParam(SysFunctionCode.EMR_SELF_PRINT_NUMBER).getDataList();
		Integer printValue = 0;
		if (params.length > 0) {
			for (Param parameter : params) {
				if (parameter.getKey().equals("PRINT_MR_COUNT_CONFIG")) {
					printValue = Integer.valueOf(parameter.getValue());
				}
			}
		}
		Mr mr = mrDao.selectById(id);
		if (mr != null && mr.getPrintCount() == null) {
			mr.setPrintCount(0);
		}
		if (mr.getPrintCount() < printValue) {
			medicalRecord.setCheckPrint(true);
		}
		result.setData(medicalRecord);
		return result;
	}

	@Override
	public SingleResult<MedicalRecord> updateMrPrintCount(String id) throws Throwable {
		SingleResult<MedicalRecord> result = new SingleResult<MedicalRecord>();
		Mr mr = mrDao.selectById(id);
		if (mr.getPrintCount() == null || mr.getPrintCount().equals("")) {
			mr.setPrintCount(0);
		}
		mr.setPrintCount(mr.getPrintCount() + 1);
		mrDao.updateExcludeNull(mr);
		result.setData(new MedicalRecord());
		return result;
	}
	
//	@Transactional
	@Override
	public boolean xmlConvertToTable() throws Throwable {
		Integer mrDaysConvertRegionalContent=null;
		Date beginDate = new Date();
		String xmlToTableEnabled=paramsSetService.searchFunFlagByKey("XML_TO_TABLE_ENABLED").getData();
		String mDCRC=paramsSetService.searchFunFlagByKey("MR_DAYS_COVERT_REGIONAL_CONTENT").getData();
		if(!StringUtils.isBlank(mDCRC))
		mrDaysConvertRegionalContent=Integer.valueOf(mDCRC);
		Integer regionAnalyticMethod=Integer.valueOf(paramsSetService.searchFunFlagByKey("REGION_ANALYTIC_METHOD").getData());	
		if (xmlToTableEnabled.equals("1")&&mrDaysConvertRegionalContent!=null&&mrDaysConvertRegionalContent>0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar date = Calendar.getInstance();
			date.setTime(beginDate);
			date.set(Calendar.DATE, date.get(Calendar.DATE) - mrDaysConvertRegionalContent);
			Date endDate = sdf.parse(sdf.format(date.getTime()));
			List<MrAmr> mrAmrs=cusMrAmrDao.selectUnXmlConvertMrAmrs(sdf.format(endDate));
			if(mrAmrs!=null&&mrAmrs.size()>0)
			for (MrAmr mrAmr:mrAmrs) {
				List<Mr> mrs=cusMrDao.selectUnXmlConvertMrs(mrAmr.getEnPk());
				if(mrs!=null&&mrs.size()>0)
				for (Mr mr:mrs) {
					if(StringUtils.isBlank(mr.getXmlFilePk()))continue;
					FileObject xmlFileObject=fileService.getFile(mr.getXmlFilePk());
					String xmlStr=new String(xmlFileObject.asByteArray(),"UTF-8");
					List<MdMrTpPara> mdMrTpParas=cusMdMrTpParaDao.selectByMdMrTpCd(mr.getMrTpCd());
					if(mdMrTpParas!=null&&mdMrTpParas.size()>0){
						for (MdMrTpPara mdMrTpPara:mdMrTpParas) {
							MdMrPara mdMrPara=mdMrParaDao.selectById(mdMrTpPara.getMdMrParaCd());
							if(StringUtils.isBlank(xmlStr))continue;
							String paraContent=IihUtils.xmlStringReader(xmlStr, mdMrPara.getNm(),regionAnalyticMethod);			
							if(StringUtils.isBlank(paraContent))continue;
							MrPara mrPara=new MrPara();
							mrPara.setDelF(new Short("0"));
							mrPara.setEnPk(mrAmr.getEnPk());
							mrPara.setPaId(mrAmr.getPaId());
							mrPara.setMrPk(mr.getMrPk());
							mrPara.setMrTpCd(mr.getMrTpCd());
							mrPara.setMrTplCd(mr.getMrTplCd());
							mrPara.setParaCd(mdMrPara.getMdMrParaCd());
							Clob clob = mrParaDao.createClob();
							clob.setString(1,paraContent);
							mrPara.setParaContent(clob);
							mrPara.setParaNm(mdMrPara.getNm());
							mrPara.setParaPk(UUIDGenerator.getUUID());
							mrParaDao.insert(mrPara);
						}
						MrPara mrPara=new MrPara();
						mrPara.setDelF(new Short("0"));
						mrPara.setEnPk(mrAmr.getEnPk());
						mrPara.setPaId(mrAmr.getPaId());
						mrPara.setMrPk(mr.getMrPk());
						mrPara.setMrTpCd(mr.getMrTpCd());
						mrPara.setMrTplCd(mr.getMrTplCd());
						mrPara.setParaCd(null);
						String clobStr="";
						if(!StringUtils.isBlank(mr.getTxtFilePk())){
							FileObject fileObject = fileService.getFile(mr.getTxtFilePk());
							if(fileObject!=null){
								clobStr=new String(fileObject.asByteArray());
							}
						}else{
							clobStr=IihUtils.xmlStringReader(new String(xmlFileObject.asByteArray(), "UTF-8"),
									null,0);
						}
						Clob clob = mrParaDao.createClob();
						clob.setString(1,clobStr);
						mrPara.setParaContent(clob);
						
						mrPara.setParaNm("病历纯文本");
						mrPara.setParaPk(UUIDGenerator.getUUID());
						mrParaDao.insert(mrPara);
						mr.setXmlCvetF(1);
						mrDao.updateExcludeNull(mr);
					}
				}
				mrAmr.setXmlCvetF(1);
				mrAmrDao.updateExcludeNull(mrAmr);
				}
		}
		Date endDateTs=new Date();
		long t=endDateTs.getTime()-beginDate.getTime();
		log.debug("xml解析区域内容耗时多少（毫秒）："+t);
		return true;
	}
	 public static String oracleClob2Str(Clob clob) throws Exception { 
	        return (clob != null ? clob.getSubString(1, (int) clob.length()) : null); 
	    } 
	@Override
	public Object xapUserCheckMrSubmit(MedicalRecord value) throws Throwable {
		Boolean bool=userRoleService.checkPracticeDoctor(value.getCrtUserId(),null);//value.getDeptCd()
		MrAmr mrAmr= mrAmrDao.selectById(value.getEncounterPk());
		if(bool){//非实习医生
			return mrAmr;
		}else{
			mrAmr.setMemo("XAPM14.24");
			return mrAmr;
		}
	}

	@Override
	public SingleResult<Map> qaCheckCreateMr(Map<String, String> condition) throws Throwable {
		SingleResult<Map> resultMap=new SingleResult<Map>();
		Map<String, String> map=new HashMap<String, String>();
		String enPk=(String) condition.get("enPk");
		//String qaItmTpCd=(String) condition.get("qaItmTpCd");
		String qaMrType=(String) condition.get("qaMrType");
		map.put("enPk", enPk);
		map.put("qaItmTpCd",CusQaAutoItmConfig.DEPENDENT);
		map.put("qaMrType", qaMrType);
		ValidateResult<QaValidateModel> validateResult =qaMrTypeService.haveMrDocValidate(map);
		List<QaValidateModel> resultList = validateResult.getResultList();
		if(resultList!=null && resultList.size()>0){
			for(QaValidateModel qaValidateModel:resultList)
		    	if(null!=qaValidateModel && !qaValidateModel.isValidateResult()){
		    		String msg= qaValidateModel.getValidateMessage();
		    		map.put("validateResult", qaValidateModel.isValidateResult()==true?"0":"1");
		    		map.put("msg", msg);
				}
	    }
		//List<QaValidateModel> qaValidateModel= validateResult.getKey("haveMrDocValidate");
		resultMap.setData(map);
		return resultMap;
	}
}
