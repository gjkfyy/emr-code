package pkuhit.iih.qa;
import java.sql.Timestamp;
import java.util.Date;

import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseBizModel;

/**
 * 
 * @author wang_yanli
 * 自动质控model
 */public class QaAutoModel extends BaseBizModel {
 public QaAutoModel(){
  super();
 }
 public QaAutoModel(String code){
  super(code);
 }
//医疗记录主键
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

	// 编辑锁标志
//	@Column(name = "EDIT_LOCK_F")
//	private Short editLockFlag;

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

  /** 提交人 */
  @Column(name = "SUBMIT_CD")
  String submitCd;
  
  /** 主治医师 */
  @Column(name = "MAST_DOCTOR_CD")
  String mastDoctorCd;

  /** 主治审签时间 */
  @Column(name = "MAST_DOCTOR_DATE")
  Timestamp mastDoctorDate;

  /** 主任医师 */
  @Column(name = "DIR_DOCTOR_CD")
  String dirDoctorCd;

  /** 主任审签时间 */
  @Column(name = "DIR_DOCTOR_DATE")
  Timestamp dirDoctorDate;
  
  //提交时间
  @Column(name = "SUBMIT_DATE")
  private Date submitDate;

	// 逻辑提交科室编码
	@Column(name = "LGC_SMT_DEPT_CD")
	private String logicSubmitDeptCode;

	// 最后签名时间
	@Column(name = "LAST_SIGN_TIME")
	private Date lastSignedTime;

	// 最后签名人ID
	@Column(name = "LAST_SIGN_USER_ID")
	private String lastSignedUserId;

	// 最后签名科室编码
	@Column(name = "LAST_SIGN_DEPT_CD")
	private String lastSignedDeptCode;
	
	  //创建时间
	  @Column(name = "CRT_TIME")
	  private Date crtTime;
	  
	  // 审签级别
	  @Column(name = "SIGN_LVL_NM")
	  private String signLvlNm;
	
	  //创建人
	  @Column(name = "CRT_USER_ID")
	  private String crtUserId;
  
 /** 当前入科时间 */
 @Column(name = "CUR_DEPT_INTO_TIME")
 private Timestamp curDeptIntoTime;

 
 /** 职称编码 */
 @Column(name = "JOB_TITLE_CD")
 private String jobTitleCd;


 /** 病情状态编码 */
 @Column(name = "ILL_STA_CD")
 private String illStaCd;
 
public Timestamp getCurDeptIntoTime() {
	return curDeptIntoTime;
}

public void setCurDeptIntoTime(Timestamp curDeptIntoTime) {
	this.curDeptIntoTime = curDeptIntoTime;
}

public String getJobTitleCd() {
	return jobTitleCd;
}

public void setJobTitleCd(String jobTitleCd) {
	this.jobTitleCd = jobTitleCd;
}

public String getMrPk() {
	return mrPk;
}

public void setMrPk(String mrPk) {
	this.mrPk = mrPk;
}

public String getEncounterPk() {
	return encounterPk;
}

public void setEncounterPk(String encounterPk) {
	this.encounterPk = encounterPk;
}

public String getTempleCode() {
	return templeCode;
}

public void setTempleCode(String templeCode) {
	this.templeCode = templeCode;
}

public String getFilePk() {
	return filePk;
}

public void setFilePk(String filePk) {
	this.filePk = filePk;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getFirstCode() {
	return firstCode;
}

public void setFirstCode(String firstCode) {
	this.firstCode = firstCode;
}

public String getTypeCode() {
	return typeCode;
}

public void setTypeCode(String typeCode) {
	this.typeCode = typeCode;
}

public String getStatusCode() {
	return statusCode;
}

public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}

public String getQaStatusCode() {
	return qaStatusCode;
}

public void setQaStatusCode(String qaStatusCode) {
	this.qaStatusCode = qaStatusCode;
}

public boolean isReformFlag() {
	return reformFlag;
}

public void setReformFlag(boolean reformFlag) {
	this.reformFlag = reformFlag;
}

public Short getCompletedFlag() {
	return completedFlag;
}

public void setCompletedFlag(Short completedFlag) {
	this.completedFlag = completedFlag;
}

public String getSignLevelCode() {
	return signLevelCode;
}

public void setSignLevelCode(String signLevelCode) {
	this.signLevelCode = signLevelCode;
}

public Date getBizTime() {
	return bizTime;
}

public void setBizTime(Date bizTime) {
	this.bizTime = bizTime;
}

public String getSuperiorDoctorId() {
	return superiorDoctorId;
}

public void setSuperiorDoctorId(String superiorDoctorId) {
	this.superiorDoctorId = superiorDoctorId;
}

public Date getLogicSubmitTime() {
	return logicSubmitTime;
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

public Date getSubmitDate() {
	return submitDate;
}

public void setSubmitDate(Date submitDate) {
	this.submitDate = submitDate;
}

public String getLogicSubmitDeptCode() {
	return logicSubmitDeptCode;
}

public void setLogicSubmitDeptCode(String logicSubmitDeptCode) {
	this.logicSubmitDeptCode = logicSubmitDeptCode;
}

public Date getLastSignedTime() {
	return lastSignedTime;
}

public void setLastSignedTime(Date lastSignedTime) {
	this.lastSignedTime = lastSignedTime;
}

public String getLastSignedUserId() {
	return lastSignedUserId;
}

public void setLastSignedUserId(String lastSignedUserId) {
	this.lastSignedUserId = lastSignedUserId;
}

public String getLastSignedDeptCode() {
	return lastSignedDeptCode;
}

public void setLastSignedDeptCode(String lastSignedDeptCode) {
	this.lastSignedDeptCode = lastSignedDeptCode;
}

public Date getCrtTime() {
	return crtTime;
}

public void setCrtTime(Date crtTime) {
	this.crtTime = crtTime;
}

public String getSignLvlNm() {
	return signLvlNm;
}

public void setSignLvlNm(String signLvlNm) {
	this.signLvlNm = signLvlNm;
}

public String getCrtUserId() {
	return crtUserId;
}

public void setCrtUserId(String crtUserId) {
	this.crtUserId = crtUserId;
}

public String getIllStaCd() {
	return illStaCd;
}

public void setIllStaCd(String illStaCd) {
	this.illStaCd = illStaCd;
}

 
}