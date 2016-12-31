package pkuhit.iih.mr.wr;

import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class MedicalRecord extends BaseBizModel {

	public MedicalRecord() {

		super();

	}

	public MedicalRecord(String code) {

		super(code);

	}

	public static final String OBJ_CD = "MRB02";
	// 医疗记录主键
	public static final String MR_PK = "MRB02.AT01";
	// 就诊主键
	public static final String ENCOUNTER_PK = "MRB02.AT02";
	// 医疗记录模板编码
	public static final String TEMPLE_CODE = "MRB02.AT03";
	// 文件主键
	public static final String FILE_PK = "MRB02.AT04";
	// 医疗记录名称
	public static final String NAME = "MRB02.AT05";
	// 医疗记录类型编码
	public static final String TYPE_CODE = "MRB02.AT06";
	// 医疗记录状态编码
	public static final String STATUS_CODE = "MRB02.AT07";
	// 终末质控状态编码
	public static final String QA_STATUS_CODE = "MRB02.AT08";
	// 编辑锁标志
	public static final String EDIT_LOCK_FLAG = "MRB02.AT09";
	// 驳回标志
	public static final String REJECTED_FLAG = "MRB02.AT10";
	// 完成标志
	public static final String COMPLETED_FLAG = "MRB02.AT11";
	// 审签级别编码
	public static final String SIGN_LEVEL_CODE = "MRB02.AT12";
	// 业务时间
	public static final String BIZ_TIME = "MRB02.AT13";
	// 上级查房医生ID
	public static final String SUPERIOR_DOCTOR_ID = "MRB02.AT14";
	// 医疗记录主键
	@Column(name = "MR_PK")
	private String mrPk;

	// 就诊主键
	@Column(name = "EN_PK")
	private String encounterPk;

	// 医疗记录模板编码
	@Column(name = "MR_TPL_CD")
	private String templeCode;

	// 文件主键
	@Column(name = "FILE_PK")
	private String filePk;

	// xml文件主键
	@Column(name = "XML_FILE_PK")
	private String xmlFilePk;

	// xml文件
	private String xmlFileData;

	// 签章文件主键
	@Column(name = "CA_FILE_PK")
	private String caFilePk;

	// 医疗记录名称
	@Column(name = "NM")
	private String name;

	// 一级分类编码
	@Column(name = "FST_CD")
	private String firstCode;

	// 医疗记录类型编码
	@Column(name = "MR_TP_CD")
	private String typeCode;

	// 医疗记录状态编码
	@Column(name = "MR_STA_CD")
	private String statusCode;

	// 终末质控状态编码
	@Column(name = "MR_QA_STA_CD")
	private String qaStatusCode;

	// 整改标志
	private boolean reformFlag;

	// 完成标志
	@Column(name = "COMPLETED_F")
	private Short completedFlag;

	// 审签级别编码
	@Column(name = "SIGN_LVL_CD")
	private String signLevelCode;

	// 业务时间
	@Column(name = "BIZ_TIME")
	private Date bizTime;

	// 上级查房医生ID
	@Column(name = "SUP_DCT_ID")
	private String superiorDoctorId;

	// 逻辑提交时间
	@Column(name = "LGC_SMT_TIME")
	private Date logicSubmitTime;

	// 提交人编码
	@Column(name = "SUBMIT_CD")
	String submitCd;

	// 提交人名称
	String submitName;

	// 经治医师编码
	@Column(name = "TREAT_DOCTOR_CD")
	String treatDoctorCd;

	// 经治医师姓名
	String treatDoctorName;

	// 主治医师
	@Column(name = "MAST_DOCTOR_CD")
	String mastDoctorCd;

	// 主治医师 姓名*/
	String masterDoctorName;

	// 主治审签时间
	@Column(name = "MAST_DOCTOR_DATE")
	Timestamp mastDoctorDate;

	// 主任医师
	@Column(name = "DIR_DOCTOR_CD")
	String dirDoctorCd;

	// 主任医师姓名
	String dirDoctorName;

	// 主任审签时间
	@Column(name = "DIR_DOCTOR_DATE")
	Timestamp dirDoctorDate;

	// 提交时间
	@Column(name = "SUBMIT_DATE")
	private Date submitDate;

	// 科室编码
	@Column(name = "DEPT_CD")
	private String deptCd;

	// 科室名称
	@DictionaryTag(code = "deptCd", objCd = "ORGB01")
	private String deptName;

	// 创建时间
	@Column(name = "CRT_TIME")
	Date crtTime;

	// 创建时间
	@Column(name = "LAST_UPD_TIME")
	Date lastUpdTime;

	// 审签级别
	@Column(name = "SIGN_LVL_NM")
	private String signLvlNm;
	// 归档结果
	@Column(name = "ARC_F")
	private Short arcF;
	// 创建人
	@Column(name = "CRT_USER_ID")
	String crtUserId;
	// 医疗记录模板名称
	private String templeName;
	// 医疗记录类型名称
	@DictionaryTag(code = "typeCode", objCd = "MRM16")
	private String typeName;
	// 医疗记录状态名称
	@DictionaryTag(code = "statusCode", objCd = "MRM04")
	private String statusName;
	// 终末质控状态名称
	@DictionaryTag(code = "qaStatusCode", objCd = "QAM04")
	private String qaStatusName;
	// 审签级别名称
	@DictionaryTag(code = "signLevelCode", objCd = "MRM02")
	private String signLevelName;
	// 上级查房医生名
	// @DictionaryTag(code = "superiorDoctorId",objCd ="XAPM12")
	private String superiorDoctorName;
	// 当前用户对此份病历的审签等级
	private String userSignLevelCode;
	// 创建人名
	// @DictionaryTag(code = "crtUserId",objCd ="XAPM12")
	private String crtUserName;
	// 引用元素值
	private Map<String, Object> referenceElem;
	// 医疗记录自定义分类编码
	private String mrTypeCustomCode;
	// 可编辑标志0不可，1可以
	private Integer canEdit;
	// 可另存为模板0不可，1可以
	private Integer canSaveAsTemplate;
	// 可创建标志0不可，1可以
	private Integer canCreate;
	// 可签名提交标志0不可，1可以
	private Integer canSign;
	// 可撤销签名提交标志0不可，1可以
	private Integer canCancelSigned;
	// 可审签标志0不可，1可以
	private Integer canApprove;
	// 可开始审签标志0不可，1可以
	private Integer canStartApprove;
	// 可撤销审签标志0不可，1可以
	private Integer canCancelApprove;
	// 可驳回标志0不可，1可以
	private Integer canReject;
	// 可删除标志0不可，1可以
	private Integer canDelete;
	// 可更新标志0不可，1可以
	private Integer canUpdate;
	// 可续打标志0不可，1可以
	private Integer canContinuePrint;
	// 可打印标志0不可，1可以
	private Integer canPrint;
	// 可电子签名标志0不可，1可以
	private Integer canErpSign;
	// 新起一页打印标志
	private BigInteger newPageF;
	//独占一页打印标识 
	private BigInteger alonePageF;
	// 文件数据
	private String fileData;
	// XML数据
	private String xml;
	// 签章文件数据
	private String caFileData;
	// 需整改缺陷数
	private String defectCount;

	// 整个病案的对象
	private Amr amr;
	
	private String mrPdfData;
	
	// TXT文件主键
	@Column(name = "TXT_FILE_PK")
	private String txtFilePk;

	// TXT文件
	private String txtFileData;
	// 是否可以打印
	private Boolean checkPrint=false;
	
	private String timeAutoGenerated;
	// 是否是实习医生
	private String practiceDoctor;
	
    /** */
    @Column(name = "CERT_VALUE")
    String certValue;
    
    /**证书序号 */
    @Column(name = "CERT_ID")
    String certId;

    /**签名值 */
    @Column(name = "CA_DATA")
    String caData;
	
	/** 验证是否是上级申签医师提交 */
    @Column(name = "UP_DOC_CHECK_SUBMIT")
    String upDocCheckSubmit;
    
    /**标志：xml需要转换成odt*/
    private Boolean onlyXmlNeedToTransfer = false  ;
    
	public Boolean getOnlyXmlNeedToTransfer() {
		return onlyXmlNeedToTransfer;
	}

	public void setOnlyXmlNeedToTransfer(Boolean onlyXmlNeedToTransfer) {
		this.onlyXmlNeedToTransfer = onlyXmlNeedToTransfer;
	}
	
    /**病程记录最新的来源:odt,xml。移动医护通过接口保存xml的时候，该字段为xml，在pc端打开时，需要把模板和xml合并，保存后设置为odt。当移动再次修改xml的时候，该字段为xml。再次在pc端打开电子病历时，更新再次合并，更新该字段为odt。*/
    @Column(name = "MR_SOURCE")
    String mrSource;
    
    public String getMrSource() {
		return mrSource;
	}

	public void setMrSource(String mrSource) {
		this.mrSource = mrSource;
	}

	public String getUpDocCheckSubmit() {
		return upDocCheckSubmit;
	}

	public void setUpDocCheckSubmit(String upDocCheckSubmit) {
		this.upDocCheckSubmit = upDocCheckSubmit;
	}

	public String getPracticeDoctor() {
		return practiceDoctor;
	}

	public void setPracticeDoctor(String practiceDoctor) {
		this.practiceDoctor = practiceDoctor;
	}

	public String getMrPdfData() {
		return mrPdfData;
	}

	public void setMrPdfData(String mrPdfData) {
		this.mrPdfData = mrPdfData;
	}

	public String getTimeAutoGenerated() {
		return timeAutoGenerated;
	}

	public void setTimeAutoGenerated(String timeAutoGenerated) {
		this.timeAutoGenerated = timeAutoGenerated;
	}

	//是否允许非本人修改病历
    @Column(name = "PERMIT_F")
    Short permitF;
    
    /** 表格转换二维表完成标识对应bizFile; */
    @Column(name = "SPL_FM_PK")
    String splFmPk;
    
	public String getSplFmPk() {
		return splFmPk;
	}

	public void setSplFmPk(String splFmPk) {
		this.splFmPk = splFmPk;
	}

	public Short getPermitF() {
		return permitF;
	}

	public void setPermitF(Short permitF) {
		this.permitF = permitF;
	}

	public Boolean getCheckPrint() {
		return checkPrint;
	}

	public void setCheckPrint(Boolean checkPrint) {
		this.checkPrint = checkPrint;
	}

	public String getTxtFilePk() {
		return txtFilePk;
	}

	public void setTxtFilePk(String txtFilePk) {
		this.txtFilePk = txtFilePk;
	}

	public String getTxtFileData() {
		return txtFileData;
	}

	public void setTxtFileData(String txtFileData) {
		this.txtFileData = txtFileData;
	}

	public String getXmlFilePk() {
		return xmlFilePk;
	}

	public void setXmlFilePk(String xmlFilePk) {
		this.xmlFilePk = xmlFilePk;
	}

	public String getXmlFileData() {
		return xmlFileData;
	}

	public void setXmlFileData(String xmlFileData) {
		this.xmlFileData = xmlFileData;
	}

	public Short getArcF() {
		return arcF;
	}

	public void setArcF(Short arcF) {
		this.arcF = arcF;
	}

	public Date getLastUpdTime() {
		return lastUpdTime;
	}

	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	public String getCaFileData() {
		return caFileData;
	}

	public void setCaFileData(String caFileData) {
		this.caFileData = caFileData;
	}

	public String getCaFilePk() {
		return caFilePk;
	}

	public void setCaFilePk(String caFilePk) {
		this.caFilePk = caFilePk;
	}

	public Integer getCanErpSign() {
		return canErpSign;
	}

	public void setCanErpSign(Integer canErpSign) {
		this.canErpSign = canErpSign;
	}

	public Amr getAmr() {
		return amr;
	}

	public void setAmr(Amr amr) {
		this.amr = amr;
	}

	public String getSignLvlNm() {
		return signLvlNm;
	}

	public void setSignLvlNm(String signLvlNm) {
		this.signLvlNm = signLvlNm;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getMrPk() {
		return this.mrPk;
	}

	public void setMrPk(String mrPk) {
		this.mrPk = mrPk;
	}

	public String getEncounterPk() {
		return this.encounterPk;
	}

	public void setEncounterPk(String encounterPk) {
		this.encounterPk = encounterPk;
	}

	public String getTempleCode() {
		return this.templeCode;
	}

	public void setTempleCode(String templeCode) {
		this.templeCode = templeCode;
	}

	public String getFilePk() {
		return this.filePk;
	}

	public void setFilePk(String filePk) {
		this.filePk = filePk;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getQaStatusCode() {
		return this.qaStatusCode;
	}

	public void setQaStatusCode(String qaStatusCode) {
		this.qaStatusCode = qaStatusCode;
	}

	/*
	 * public Short getEditLockFlag() { return this.editLockFlag; }
	 * 
	 * public void setEditLockFlag(Short editLockFlag) { this.editLockFlag =
	 * editLockFlag; }
	 */

	public Short getCompletedFlag() {
		return this.completedFlag;
	}

	public boolean getReformFlag() {
		return reformFlag;
	}

	public void setReformFlag(boolean reformFlag) {
		this.reformFlag = reformFlag;
	}

	public void setCompletedFlag(Short completedFlag) {
		this.completedFlag = completedFlag;
	}

	public String getSignLevelCode() {
		return this.signLevelCode;
	}

	public void setSignLevelCode(String signLevelCode) {
		this.signLevelCode = signLevelCode;
	}

	public Date getBizTime() {
		return this.bizTime;
	}

	public void setBizTime(Date bizTime) {
		this.bizTime = bizTime;
	}

	public String getSuperiorDoctorId() {
		return this.superiorDoctorId;
	}

	public void setSuperiorDoctorId(String superiorDoctorId) {
		this.superiorDoctorId = superiorDoctorId;
	}

	public Date getLogicSubmitTime() {
		return this.logicSubmitTime;
	}

	public void setLogicSubmitTime(Date logicSubmitTime) {
		this.logicSubmitTime = logicSubmitTime;
	}

	public String getSubmitCd() {
		return submitCd;
	}

	public void setSubmitCd(String submitCd) {
		this.submitCd = submitCd;
	}

	public String getTempleName() {
		return this.templeName;
	}

	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getQaStatusName() {
		return this.qaStatusName;
	}

	public void setQaStatusName(String qaStatusName) {
		this.qaStatusName = qaStatusName;
	}

	public String getSignLevelName() {
		return this.signLevelName;
	}

	public void setSignLevelName(String signLevelName) {
		this.signLevelName = signLevelName;
	}

	public String getSuperiorDoctorName() {
		return this.superiorDoctorName;
	}

	public void setSuperiorDoctorName(String superiorDoctorName) {
		this.superiorDoctorName = superiorDoctorName;
	}

	public Integer getCanEdit() {
		return this.canEdit;
	}

	public void setCanEdit(Integer canEdit) {
		this.canEdit = canEdit;
	}

	public Integer getCanSign() {
		return this.canSign;
	}

	public void setCanSign(Integer canSign) {
		this.canSign = canSign;
	}

	public Integer getCanCancelSigned() {
		return canCancelSigned;
	}

	public void setCanCancelSigned(Integer canCancelSigned) {
		this.canCancelSigned = canCancelSigned;
	}

	public Integer getCanReject() {
		return this.canReject;
	}

	public void setCanReject(Integer canReject) {
		this.canReject = canReject;
	}

	public Integer getCanDelete() {
		return this.canDelete;
	}

	public void setCanDelete(Integer canDelete) {
		this.canDelete = canDelete;
	}

	public Integer getCanUpdate() {
		return this.canUpdate;
	}

	public void setCanUpdate(Integer canUpdate) {
		this.canUpdate = canUpdate;
	}

	public Integer getCanPrint() {
		return this.canPrint;
	}

	public void setCanPrint(Integer canPrint) {
		this.canPrint = canPrint;
	}

	public String getFileData() {
		return this.fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}

	public Date getCrtTime() {

		return crtTime;
	}

	public void setCrtTime(Date crtTime) {

		this.crtTime = crtTime;
	}

	public String getCrtUserId() {

		return crtUserId;
	}

	public void setCrtUserId(String crtUserId) {

		this.crtUserId = crtUserId;
	}

	public String getCrtUserName() {

		return crtUserName;
	}

	public void setCrtUserName(String crtUserName) {

		this.crtUserName = crtUserName;
	}

	public String getDefectCount() {

		return defectCount;
	}

	public void setDefectCount(String defectCount) {

		this.defectCount = defectCount;
	}

	public String getMrTypeCustomCode() {

		return mrTypeCustomCode;
	}

	public void setMrTypeCustomCode(String mrTypeCustomCode) {

		this.mrTypeCustomCode = mrTypeCustomCode;
	}

	public Integer getCanCreate() {

		return canCreate;
	}

	public void setCanCreate(Integer canCreate) {

		this.canCreate = canCreate;
	}

	public Integer getCanApprove() {
		return canApprove;
	}

	public void setCanApprove(Integer canApprove) {
		this.canApprove = canApprove;
	}

	public Integer getCanCancelApprove() {
		return canCancelApprove;
	}

	public void setCanCancelApprove(Integer canCancelApprove) {
		this.canCancelApprove = canCancelApprove;
	}

	public String getFirstCode() {
		return firstCode;
	}

	public void setFirstCode(String firstCode) {
		this.firstCode = firstCode;
	}

	public Map<String, Object> getReferenceElem() {
		return referenceElem;
	}

	public void setReferenceElem(Map<String, Object> referenceElem) {
		this.referenceElem = referenceElem;
	}

	public Integer getCanStartApprove() {
		return canStartApprove;
	}

	public void setCanStartApprove(Integer canStartApprove) {
		this.canStartApprove = canStartApprove;
	}

	public String getMastDoctorCd() {

		return mastDoctorCd;
	}

	public void setMastDoctorCd(String mastDoctorCd) {

		this.mastDoctorCd = mastDoctorCd;
	}

	public Timestamp getMastDoctorDate() {

		return mastDoctorDate;
	}

	public void setMastDoctorDate(Timestamp mastDoctorDate) {

		this.mastDoctorDate = mastDoctorDate;
	}

	public String getDirDoctorCd() {

		return dirDoctorCd;
	}

	public void setDirDoctorCd(String dirDoctorCd) {

		this.dirDoctorCd = dirDoctorCd;
	}

	public Timestamp getDirDoctorDate() {

		return dirDoctorDate;
	}

	public void setDirDoctorDate(Timestamp dirDoctorDate) {

		this.dirDoctorDate = dirDoctorDate;
	}

	public Integer getCanContinuePrint() {

		return canContinuePrint;
	}

	public void setCanContinuePrint(Integer canContinuePrint) {

		this.canContinuePrint = canContinuePrint;
	}

	public BigInteger getNewPageF() {

		return newPageF;
	}

	public void setNewPageF(BigInteger newPageF) {

		this.newPageF = newPageF;
	}

	public String getUserSignLevelCode() {

		return userSignLevelCode;
	}

	public void setUserSignLevelCode(String userSignLevelCode) {

		this.userSignLevelCode = userSignLevelCode;
	}

	public Integer getCanSaveAsTemplate() {

		return canSaveAsTemplate;
	}

	public void setCanSaveAsTemplate(Integer canSaveAsTemplate) {

		this.canSaveAsTemplate = canSaveAsTemplate;
	}

	public String getMasterDoctorName() {

		return masterDoctorName;
	}

	public void setMasterDoctorName(String masterDoctorName) {

		this.masterDoctorName = masterDoctorName;
	}

	public String getSubmitName() {

		return submitName;
	}

	public void setSubmitName(String submitName) {

		this.submitName = submitName;
	}

	public String getDirDoctorName() {

		return dirDoctorName;
	}

	public void setDirDoctorName(String dirDoctorName) {

		this.dirDoctorName = dirDoctorName;
	}

	public String getDeptCd() {

		return deptCd;
	}

	public void setDeptCd(String deptCd) {

		this.deptCd = deptCd;
	}

	public String getDeptName() {

		return deptName;
	}

	public void setDeptName(String deptName) {

		this.deptName = deptName;
	}

	public String getTreatDoctorCd() {

		return treatDoctorCd;
	}

	public void setTreatDoctorCd(String treatDoctorCd) {

		this.treatDoctorCd = treatDoctorCd;
	}

	public String getTreatDoctorName() {

		return treatDoctorName;
	}

	public void setTreatDoctorName(String treatDoctorName) {

		this.treatDoctorName = treatDoctorName;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public BigInteger getAlonePageF() {
		return alonePageF;
	}

	public void setAlonePageF(BigInteger alonePageF) {
		this.alonePageF = alonePageF;
	}

	public String getCertValue() {
		return certValue;
	}

	public void setCertValue(String certValue) {
		this.certValue = certValue;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getCaData() {
		return caData;
	}

	public void setCaData(String caData) {
		this.caData = caData;
	}

}