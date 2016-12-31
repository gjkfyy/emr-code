
package pkuhit.iih.mr.wr;

import java.math.BigDecimal;
import java.util.Date;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class Amr extends BaseBizModel {

	public Amr() {

		super();

	}

	public Amr(String code) {

		super(code);

	}
	public static final Short ARC_F=1;
	//已上传
	public static final String OBJ_CD = "MRB01";

	// 就诊主键
	public static final String PK = "MRB01.AT01";
	// 病案号
	public static final String AMR_NO = "MRB01.AT02";
	// 病案状态编码
	public static final String STATUS_CODE = "MRB01.AT03";
	// 病案等级编码
	public static final String RANK_CODE = "MRB01.AT04";
	// 质控评分
	public static final String SCORE = "MRB01.AT05";
	// 终末质控完成时间
	public static final String TERMINATE_QA_COMPLETED_TIME = "MRB01.AT06";
	// 终末质控完成人ID
	public static final String TERMINATE_QA_USER_ID = "MRB01.AT07";
	// 终末质控完成科室编码
	public static final String TERMINATE_QA_DEPT_CODE = "MRB01.AT08";

	// 就诊主键
	@Column(name = "EN_PK")
	private String pk;
	
	//患者ID
	@Column(name = "PA_ID")
	private String patientId;
	
	//就诊次数
	@Column(name = "EN_CNT")
//	private BigInteger encounterCount;
	private String encounterCount;
	
	//患者名称
	@Column(name = "PA_NM")
	private String patientName;
	
	//性别编码
	@Column(name = "SEX_CD")
	private String sexCode;
	
	//年龄
	@Column(name = "AGE")
	private String age;
	
	//组织机构编码
	@Column(name = "ORG_CD")
	private String organizationCode;

	// 病案号
	@Column(name = "AMR_NO")
	private String amrNo;
	
	// 就诊号
	@Column(name = "EN_NO")
	private String encounterNo;
	
	// 就诊类型编码
	@Column(name = "EN_TP_CD")
	private String encounterTypeCode;  //EncounterType	
	
	// 就诊状态编码
	@Column(name = "EN_STA_CD")
	private String encounterStatusCode;  //EncounterStatus	
	
	// 病案状态编码
	@Column(name = "AMR_STA_CD")
	private String statusCode;

	// 病案等级编码
	@Column(name = "AMR_RANK_CD")
	private String rankCode;

	// 质控评分
	@Column(name = "QA_SCR")
	private BigDecimal score;
	
	// 质控评分
	@Column(name = "QA_AUTO_SCR")
	private BigDecimal qaAutoScr;
	
	// 就诊登记时间 
	@Column(name = "REG_TIME")
	private Date registerTime;

	// 就诊登记人ID 
	@Column(name = "REG_USER_ID")
	private String registerUserId;
	
	// 就诊登记科室编码 
	@Column(name = "REG_DEPT_CD")
	private String registerDeptCode;
	
	// 就诊接诊时间
	@Column(name = "RCV_TIME")
	private Date receiveTime;

	// 就诊接诊人ID
	@Column(name = "RCV_USER_ID")
	private String receiveUserId;
	
	// 就诊接诊科室编码
	@Column(name = "RCV_DEPT_CD")
	private String receiveDeptCode;
	
	// 病情状态编码
	@Column(name = "ILL_STA_CD")
	private String illStatusCode	;//  IllStatus	
	
	// 护理等级编码
	@Column(name = "NU_LVL_CD")
	private String nuserLevelCode	;//  NurseLevel	
	
	// 当前主诊断编码
	@Column(name = "CUR_MAIN_DI_CD")
	private String currentMainDiagnosisCode;
	
	// 当前科室编码
	@Column(name = "CUR_DEPT_CD")
	private String currentDeptCode;
	
	// 当前科室入科时间
	@Column(name = "CUR_DEPT_INTO_TIME")
	private Date currentDeptIntoTime;
	
	// 当前病区编码
	@Column(name = "CUR_WARD_CD")
	private String currentWardCode;
	
	// 当前病区入病区时间
	@Column(name = "CUR_WARD_INTO_TIME")
	private Date currentWardIntoTime;
	
	// 当前诊疗组编码
	@Column(name = "CUR_GRP_CD")
	private String currentGroupCode;
	
	// 当前床位编码
	@Column(name = "CUR_BED_CD")
	private String currentBedCode;
	
	// 当前主管医生ID
	@Column(name = "CUR_MNG_DCT_ID")
	private String currentManageDoctorId;
	
	// 当前主治医生ID
	@Column(name = "CUR_MOJ_DCT_ID")
	private String currentMajorDoctorId;
	
	// 当前主任(副主任)医生ID
	@Column(name = "CUR_DRC_DCT_ID")
	private String currentDirectorDoctorId;
	
	// 当前责任护士ID
	@Column(name = "CUR_MNG_NUR_ID")
	private String currentManageNurseId;
	
	// 手术标志
	@Column(name = "SU_F")
	private BigDecimal surgeryFlag;
	
	// 死亡标志
	@Column(name = "DEATH_F")
	private BigDecimal deathFlag;
	
	// 再入院标志
	@Column(name = "READM_F")
	private BigDecimal retryAdmissionFlag;
	
	// 召回标志
	@Column(name = "CALL_BACK_F")
	private BigDecimal callBackFlag;
	
	// 随访标志
	@Column(name = "FLUP_VISIT_F")
	private BigDecimal followUpVisitFlag;
	
	// 诊毕时间
	@Column(name = "FNSH_TIME")
	private Date finishTime;
	
	// 诊毕人ID
	@Column(name = "FNSH_USER_ID")
	private String finishUserId;
	
	// 诊毕科室编码
	@Column(name = "FNSH_DEPT_CD")
	private String finishDeptCode;
	
	// 终末质控完成时间
	@Column(name = "TERM_QA_CMPL_TIME")
	private Date termQaCmplTime;
	
	// 终末质控完成人ID
	@Column(name = "TERM_QA_CMPL_USER_ID")
	private String termQaCmplUserId;
	
	// 终末质控完成科室编码
	@Column(name = "TERM_QA_CMPL_DEPT_CD")
	private String termQaCmplDeptCd;
	
	// 终末质控完成时间
	@Column(name = "TERM_QA_CMPL_TIME")
	private Date terminateQaCompletedTime;

	// 终末质控完成人ID
	@Column(name = "TERM_QA_CMPL_USER_ID")
	private String terminateQaUserId;

	// 终末质控完成科室编码
	@Column(name = "TERM_QA_CMPL_DEPT_CD")
	private String terminateQaDeptCode;
	
	// 病案状态名称
	@DictionaryTag(code = "statusCode", objCd = "MRM22")
	private String statusName;
	
	// 病案等级名称
	@DictionaryTag(code = "rankCode", objCd = "MRM10")
	private String rankName;
	
	// 终末质控完成人名称
	//@DictionaryTag(code = "terminateQaUserId", objCd = "XAPM12")
	private String terminateQaUserName;
	
	// 终末质控完成科室名称
	//@DictionaryTag(code = "terminateQaDeptCode", objCd = "ORGB01")
	private String terminateQaDeptName;
	
	// 当前主诊断名称
	@DictionaryTag(code = "currentMainDiagnosisCode", objCd = "DIM01")
	private String currentMainDiagnosisName;

	// 就诊类型名称
	@DictionaryTag(code = "encounterTypeCode", objCd = "ENM01")
	private String encounterTypeName;
	
	// 就诊状态名称
	@DictionaryTag(code = "encounterStatusCode", objCd = "ENM02")
	private String encounterStatusName;
	
	// 病情状态名称
	@DictionaryTag(code = "illStatusCode", objCd = "ENM05")
	private String illStatusName;
	
	// 当前科室名称
	@DictionaryTag(code = "currentDeptCode", objCd = "ORGB01")
	private String currentDeptName;

	// 主管医师
	@Column(name = "CUR_MNG_DCT_ID")
	private String curMngDctId;
	
	// 主治医师
	@Column(name = "CUR_MOJ_DCT_ID")
	private String curMojDctId;
	
	// 主任医师
	@Column(name = "CUR_DRC_DCT_ID")
	private String curDrcDctId;
	
	// 性别名称
	@DictionaryTag(code = "sexCode", objCd = "MDM05")
	private String sexName;
	
	// 组织机构名称
	//@DictionaryTag(code = "organizationCode", objCd = "ORGB01")
	private String organizationName;
	
	// 护理等级名称
	@DictionaryTag(code = "nuserLevelCode", objCd = "ENM04")
	private String nuserLevelName;
	
	// 就诊接诊人名称
	//@DictionaryTag(code = "receiveUserId", objCd = "XAPM12")
	private String receiveUserName;
	
	// 就诊接诊科室名称
	//@DictionaryTag(code = "receiveDeptCode", objCd = "ORGB01")
	private String receiveDeptName;
	
	// 就诊登记人名称
	//@DictionaryTag(code = "registerUserId", objCd = "XAPM12")
	private String registerUserName;
	
	// 就诊登记科室名称
	//@DictionaryTag(code = "registerDeptCode", objCd = "ORGB01")
	private String registerDeptName;
	
	// 当前病区名称
	@DictionaryTag(code = "currentWardCode", objCd = "ORGB01")
	private String currentWardName;
	
	// 当前主管医生名称
	@DictionaryTag(code = "currentManageDoctorId", objCd = "ORGB04")
	private String currentManageDoctorName;
	
	// 当前主治医生名称
	@DictionaryTag(code = "currentMajorDoctorId", objCd = "ORGB04")
	private String majorDoctorName;
	
	// 当前主任(副主任)医生名称
	@DictionaryTag(code = "currentDirectorDoctorId", objCd = "ORGB04")
	private String directorDoctorName;
	
	// 当前责任护士名称
	@DictionaryTag(code = "currentManageNurseId", objCd = "ORGB04")
	private String currentManageNurseName;
	
	// 诊毕人名称
	//@DictionaryTag(code = "finishUserId", objCd = "XAPM12")
	private String finishUserName;
	
	// 诊毕科室名称
	//@DictionaryTag(code = "finishDeptCode", objCd = "ORGB01")
	private String finishDeptName;
	
	//~~~~~~~~~~~~~~~
	// 住院天数
	@Column(name = "ADMISSIONDAY")
	private BigDecimal admissionDay; //当前时间-就诊接诊时间
	
	// 住院号
	@Column(name = "AMR_NO")
	private String inpatientNo; //就诊类型为住院的就诊号
	
	// 门诊号
	@Column(name = "EN_NO")
	private String outpatientNo; //就诊类型为门诊的就诊号
	
	// 质控标志
	@Column(name = "QAFLAG")
	private BigDecimal qaFlag;
	
	// 可编辑标志
	@Column(name = "CANEDIT")
	private BigDecimal canEdit;

	//缺陷数
	@Column(name = "FAULTTOTAL")
	private BigDecimal faultTotal;
	
	//待改数
	@Column(name = "FAULTTODOREFORM")
	private BigDecimal faultTodoReform;
	
	//待审数
	@Column(name = "FAULTTODOREVIEW")
	private BigDecimal faultTodoReview;
	
	//逾期数
	@Column(name = "FAULTOVERDEADLINE")
	private BigDecimal faultOverDeadline;
	
	//质控时间
	@Column(name = "EXECUTEENDTIME")
	private Date executeEndTime;
	
	//质控科室	
	@Column(name = "EXECUTEDEPTNAME")
	private String executeDeptName;
	
	//质控医师	
	@Column(name = "EXCUTEUSERNAME")
	private String excuteUserName;
	
	//环节质控标识
	@Column(name = "INPROCESS")
	private String inprocess;
	
	//终末质控标识
	@Column(name = "TERMINAL")
	private String terminal;
	
	//科室质控
    @Column(name = "DEPT_TERMINAL")
    private String deptTerminal;
	
	/** 级别 -评分等级表*/
    @Column(name = "LVL")
    private String lvl;
    
    private int qaCount;
    
    //患者医保编码
    private String paInsurCd;
    
    //患者医保名称
    @Column(name = "PA_INSUR_NM")
    private String paInsurNm;
    
	//评分等级 -评分等级表
    @Column(name = "QA_DIVIDE_LEVEL_CD")
    private String qaDivideLevelCd;
 	
    //医嘱执行科室
    @Column(name = "exec_unit")
    private String execUnit;
    
    //医嘱执行科室名称
    @DictionaryTag(code = "execUnit", objCd = "ORGB01")
    private String execUnitName;
    
    //申请科室
    @Column(name = "requestDeptCode")
    private String requestDeptCode;
    
    //申请科室名称
    @Column(name = "requestDeptName")
    private String requestDeptName;
    
    //描述
    @Column(name = "mr_summary")
    private String mrSummary;
    
    //应答时间
    @Column(name = "resp_time")
    private Date respTime;
    
    @Column(name = "DEL_F")
    Short delF;
    @Column(name = "ARC_F")
    Short arcF;
    
    //患者本次就诊的病历文书数
    @Column(name = "MRTOTAL")
    private BigDecimal mrTotal;
  	
  	//视图读取标记
    @Column(name = "VIEW_F")
    private String viewF;
  	
    /** 科室质控评分 */
    @Column(name = "DEPT_QA_SCR")
    BigDecimal deptQaScr;
 	

	public String getViewF() {
		return viewF;
	}

	public void setViewF(String viewF) {
		this.viewF = viewF;
	}

	public BigDecimal getMrTotal() {
		return mrTotal;
	}

	public void setMrTotal(BigDecimal mrTotal) {
		this.mrTotal = mrTotal;
	}

	

	public Short getArcF() {
		return arcF;
	}

	public void setArcF(Short arcF) {
		this.arcF = arcF;
	}

	public Short getDelF() {
		return delF;
	}

	public void setDelF(Short delF) {
		this.delF = delF;
	}

	private String btnFlag;
 	
	/** 就诊组编码*/
    @Column(name = "MR_AMR_GROUP_CD")
    private String mrAmrGroupCode;
 	
	public String getBtnFlag() {
		return btnFlag;
	}

	public void setBtnFlag(String btnFlag) {
		this.btnFlag = btnFlag;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getEncounterCount() {
		return encounterCount;
	}

	public void setEncounterCount(String encounterCount) {
		this.encounterCount = encounterCount;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getSexCode() {
		return sexCode;
	}

	public void setSexCode(String sexCode) {
		this.sexCode = sexCode;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getAmrNo() {
		return amrNo;
	}

	public void setAmrNo(String amrNo) {
		this.amrNo = amrNo;
	}

	public String getEncounterNo() {
		return encounterNo;
	}

	public void setEncounterNo(String encounterNo) {
		this.encounterNo = encounterNo;
	}

	public String getEncounterTypeCode() {
		return encounterTypeCode;
	}

	public void setEncounterTypeCode(String encounterTypeCode) {
		this.encounterTypeCode = encounterTypeCode;
	}

	public String getEncounterStatusCode() {
		return encounterStatusCode;
	}

	public void setEncounterStatusCode(String encounterStatusCode) {
		this.encounterStatusCode = encounterStatusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getRankCode() {
		return rankCode;
	}

	public void setRankCode(String rankCode) {
		this.rankCode = rankCode;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}
	
	public BigDecimal getQaAutoScr() {
		return qaAutoScr;
	}

	public void setQaAutoScr(BigDecimal qaAutoScr) {
		this.qaAutoScr = qaAutoScr;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegisterUserId() {
		return registerUserId;
	}

	public void setRegisterUserId(String registerUserId) {
		this.registerUserId = registerUserId;
	}

	public String getRegisterDeptCode() {
		return registerDeptCode;
	}

	public void setRegisterDeptCode(String registerDeptCode) {
		this.registerDeptCode = registerDeptCode;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getReceiveUserId() {
		return receiveUserId;
	}

	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	public String getReceiveDeptCode() {
		return receiveDeptCode;
	}

	public void setReceiveDeptCode(String receiveDeptCode) {
		this.receiveDeptCode = receiveDeptCode;
	}

	public String getIllStatusCode() {
		return illStatusCode;
	}

	public void setIllStatusCode(String illStatusCode) {
		this.illStatusCode = illStatusCode;
	}

	public String getNuserLevelCode() {
		return nuserLevelCode;
	}

	public void setNuserLevelCode(String nuserLevelCode) {
		this.nuserLevelCode = nuserLevelCode;
	}

	public String getCurrentMainDiagnosisCode() {
		return currentMainDiagnosisCode;
	}

	public void setCurrentMainDiagnosisCode(String currentMainDiagnosisCode) {
		this.currentMainDiagnosisCode = currentMainDiagnosisCode;
	}

	public String getCurrentDeptCode() {
		return currentDeptCode;
	}

	public void setCurrentDeptCode(String currentDeptCode) {
		this.currentDeptCode = currentDeptCode;
	}

	public Date getCurrentDeptIntoTime() {
		return currentDeptIntoTime;
	}

	public void setCurrentDeptIntoTime(Date currentDeptIntoTime) {
		this.currentDeptIntoTime = currentDeptIntoTime;
	}

	public String getCurrentWardCode() {
		return currentWardCode;
	}

	public void setCurrentWardCode(String currentWardCode) {
		this.currentWardCode = currentWardCode;
	}

	public Date getCurrentWardIntoTime() {
		return currentWardIntoTime;
	}

	public void setCurrentWardIntoTime(Date currentWardIntoTime) {
		this.currentWardIntoTime = currentWardIntoTime;
	}

	public String getCurrentBedCode() {
		return currentBedCode;
	}

	public void setCurrentBedCode(String currentBedCode) {
		this.currentBedCode = currentBedCode;
	}

	public String getCurrentManageDoctorId() {
		return currentManageDoctorId;
	}

	public void setCurrentManageDoctorId(String currentManageDoctorId) {
		this.currentManageDoctorId = currentManageDoctorId;
	}

	public String getCurrentMajorDoctorId() {
		return currentMajorDoctorId;
	}

	public void setCurrentMajorDoctorId(String currentMajorDoctorId) {
		this.currentMajorDoctorId = currentMajorDoctorId;
	}

	public String getCurrentDirectorDoctorId() {
		return currentDirectorDoctorId;
	}

	public void setCurrentDirectorDoctorId(String currentDirectorDoctorId) {
		this.currentDirectorDoctorId = currentDirectorDoctorId;
	}

	public String getCurrentManageNurseId() {
		return currentManageNurseId;
	}

	public void setCurrentManageNurseId(String currentManageNurseId) {
		this.currentManageNurseId = currentManageNurseId;
	}

	public BigDecimal getSurgeryFlag() {
		return surgeryFlag;
	}

	public void setSurgeryFlag(BigDecimal surgeryFlag) {
		this.surgeryFlag = surgeryFlag;
	}

	public BigDecimal getDeathFlag() {
		return deathFlag;
	}

	public void setDeathFlag(BigDecimal deathFlag) {
		this.deathFlag = deathFlag;
	}

	public BigDecimal getRetryAdmissionFlag() {
		return retryAdmissionFlag;
	}

	public void setRetryAdmissionFlag(BigDecimal retryAdmissionFlag) {
		this.retryAdmissionFlag = retryAdmissionFlag;
	}

	public BigDecimal getCallBackFlag() {
		return callBackFlag;
	}

	public void setCallBackFlag(BigDecimal callBackFlag) {
		this.callBackFlag = callBackFlag;
	}

	public BigDecimal getFollowUpVisitFlag() {
		return followUpVisitFlag;
	}

	public void setFollowUpVisitFlag(BigDecimal followUpVisitFlag) {
		this.followUpVisitFlag = followUpVisitFlag;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getFinishUserId() {
		return finishUserId;
	}

	public void setFinishUserId(String finishUserId) {
		this.finishUserId = finishUserId;
	}

	public String getFinishDeptCode() {
		return finishDeptCode;
	}

	public void setFinishDeptCode(String finishDeptCode) {
		this.finishDeptCode = finishDeptCode;
	}

	public Date getTermQaCmplTime() {
		return termQaCmplTime;
	}

	public void setTermQaCmplTime(Date termQaCmplTime) {
		this.termQaCmplTime = termQaCmplTime;
	}

	public String getTermQaCmplUserId() {
		return termQaCmplUserId;
	}

	public void setTermQaCmplUserId(String termQaCmplUserId) {
		this.termQaCmplUserId = termQaCmplUserId;
	}

	public String getTermQaCmplDeptCd() {
		return termQaCmplDeptCd;
	}

	public void setTermQaCmplDeptCd(String termQaCmplDeptCd) {
		this.termQaCmplDeptCd = termQaCmplDeptCd;
	}

	public Date getTerminateQaCompletedTime() {
		return terminateQaCompletedTime;
	}

	public void setTerminateQaCompletedTime(Date terminateQaCompletedTime) {
		this.terminateQaCompletedTime = terminateQaCompletedTime;
	}

	public String getTerminateQaUserId() {
		return terminateQaUserId;
	}

	public void setTerminateQaUserId(String terminateQaUserId) {
		this.terminateQaUserId = terminateQaUserId;
	}

	public String getTerminateQaDeptCode() {
		return terminateQaDeptCode;
	}

	public void setTerminateQaDeptCode(String terminateQaDeptCode) {
		this.terminateQaDeptCode = terminateQaDeptCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public String getTerminateQaUserName() {
		return terminateQaUserName;
	}

	public void setTerminateQaUserName(String terminateQaUserName) {
		this.terminateQaUserName = terminateQaUserName;
	}

	public String getTerminateQaDeptName() {
		return terminateQaDeptName;
	}

	public void setTerminateQaDeptName(String terminateQaDeptName) {
		this.terminateQaDeptName = terminateQaDeptName;
	}

	public String getCurrentMainDiagnosisName() {
		return currentMainDiagnosisName;
	}

	public void setCurrentMainDiagnosisName(String currentMainDiagnosisName) {
		this.currentMainDiagnosisName = currentMainDiagnosisName;
	}

	public String getEncounterTypeName() {
		return encounterTypeName;
	}

	public void setEncounterTypeName(String encounterTypeName) {
		this.encounterTypeName = encounterTypeName;
	}

	public String getEncounterStatusName() {
		return encounterStatusName;
	}

	public void setEncounterStatusName(String encounterStatusName) {
		this.encounterStatusName = encounterStatusName;
	}

	public String getIllStatusName() {
		return illStatusName;
	}

	public void setIllStatusName(String illStatusName) {
		this.illStatusName = illStatusName;
	}

	public String getCurrentDeptName() {
		return currentDeptName;
	}

	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getNuserLevelName() {
		return nuserLevelName;
	}

	public void setNuserLevelName(String nuserLevelName) {
		this.nuserLevelName = nuserLevelName;
	}

	public String getReceiveUserName() {
		return receiveUserName;
	}

	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}

	public String getReceiveDeptName() {
		return receiveDeptName;
	}

	public void setReceiveDeptName(String receiveDeptName) {
		this.receiveDeptName = receiveDeptName;
	}

	public String getRegisterUserName() {
		return registerUserName;
	}

	public void setRegisterUserName(String registerUserName) {
		this.registerUserName = registerUserName;
	}

	public String getRegisterDeptName() {
		return registerDeptName;
	}

	public void setRegisterDeptName(String registerDeptName) {
		this.registerDeptName = registerDeptName;
	}

	public String getCurrentWardName() {
		return currentWardName;
	}

	public void setCurrentWardName(String currentWardName) {
		this.currentWardName = currentWardName;
	}

	public String getCurrentManageDoctorName() {
		return currentManageDoctorName;
	}

	public void setCurrentManageDoctorName(String currentManageDoctorName) {
		this.currentManageDoctorName = currentManageDoctorName;
	}

	public String getMajorDoctorName() {
		return majorDoctorName;
	}

	public void setMajorDoctorName(String majorDoctorName) {
		this.majorDoctorName = majorDoctorName;
	}

	public String getDirectorDoctorName() {
		return directorDoctorName;
	}

	public void setDirectorDoctorName(String directorDoctorName) {
		this.directorDoctorName = directorDoctorName;
	}

	public String getCurrentManageNurseName() {
		return currentManageNurseName;
	}

	public void setCurrentManageNurseName(String currentManageNurseName) {
		this.currentManageNurseName = currentManageNurseName;
	}

	public String getFinishUserName() {
		return finishUserName;
	}

	public void setFinishUserName(String finishUserName) {
		this.finishUserName = finishUserName;
	}

	public String getFinishDeptName() {
		return finishDeptName;
	}

	public void setFinishDeptName(String finishDeptName) {
		this.finishDeptName = finishDeptName;
	}

	public BigDecimal getAdmissionDay() {
		return admissionDay;
	}

	public void setAdmissionDay(BigDecimal admissionDay) {
		this.admissionDay = admissionDay;
	}

	public String getInpatientNo() {
		return inpatientNo;
	}

	public void setInpatientNo(String inpatientNo) {
		this.inpatientNo = inpatientNo;
	}

	public String getOutpatientNo() {
		return outpatientNo;
	}

	public void setOutpatientNo(String outpatientNo) {
		this.outpatientNo = outpatientNo;
	}

	public BigDecimal getQaFlag() {
		return qaFlag;
	}

	public void setQaFlag(BigDecimal qaFlag) {
		this.qaFlag = qaFlag;
	}

	public BigDecimal getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(BigDecimal canEdit) {
		this.canEdit = canEdit;
	}
	
	
	public String getCurrentGroupCode() {
	
		return currentGroupCode;
	}

	
	public void setCurrentGroupCode(String currentGroupCode) {
	
		this.currentGroupCode = currentGroupCode;
	}

	
	public String getCurMngDctId() {
	
		return curMngDctId;
	}

	
	public void setCurMngDctId(String curMngDctId) {
	
		this.curMngDctId = curMngDctId;
	}

	
	public String getCurMojDctId() {
	
		return curMojDctId;
	}

	
	public void setCurMojDctId(String curMojDctId) {
	
		this.curMojDctId = curMojDctId;
	}

	
	public String getCurDrcDctId() {
	
		return curDrcDctId;
	}

	
	public void setCurDrcDctId(String curDrcDctId) {
	
		this.curDrcDctId = curDrcDctId;
	}

	public BigDecimal getFaultTotal() {
		return faultTotal;
	}

	public void setFaultTotal(BigDecimal faultTotal) {
		this.faultTotal = faultTotal;
	}

	public BigDecimal getFaultTodoReform() {
		return faultTodoReform;
	}

	public void setFaultTodoReform(BigDecimal faultTodoReform) {
		this.faultTodoReform = faultTodoReform;
	}

	public BigDecimal getFaultTodoReview() {
		return faultTodoReview;
	}

	public void setFaultTodoReview(BigDecimal faultTodoReview) {
		this.faultTodoReview = faultTodoReview;
	}

	public BigDecimal getFaultOverDeadline() {
		return faultOverDeadline;
	}

	public void setFaultOverDeadline(BigDecimal faultOverDeadline) {
		this.faultOverDeadline = faultOverDeadline;
	}

	public Date getExecuteEndTime() {
		return executeEndTime;
	}

	public void setExecuteEndTime(Date executeEndTime) {
		this.executeEndTime = executeEndTime;
	}

	public String getExecuteDeptName() {
		return executeDeptName;
	}

	public void setExecuteDeptName(String executeDeptName) {
		this.executeDeptName = executeDeptName;
	}

	public String getExcuteUserName() {
		return excuteUserName;
	}

	public void setExcuteUserName(String excuteUserName) {
		this.excuteUserName = excuteUserName;
	}

	public String getInprocess() {
		return inprocess;
	}

	public void setInprocess(String inprocess) {
		this.inprocess = inprocess;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getQaDivideLevelCd() {
		return qaDivideLevelCd;
	}

	public void setQaDivideLevelCd(String qaDivideLevelCd) {
		this.qaDivideLevelCd = qaDivideLevelCd;
	}

	public String getDeptTerminal() {
		return deptTerminal;
	}

	public void setDeptTerminal(String deptTerminal) {
		this.deptTerminal = deptTerminal;
	}

    public String getPaInsurCd()
    {
        return paInsurCd;
    }

    public void setPaInsurCd(String paInsurCd)
    {
        this.paInsurCd = paInsurCd;
    }

    public String getPaInsurNm()
    {
        return paInsurNm;
    }

    public void setPaInsurNm(String paInsurNm)
    {
        this.paInsurNm = paInsurNm;
    }

	public int getQaCount() {
		return qaCount;
	}

	public void setQaCount(int qaCount) {
		this.qaCount = qaCount;
	}

	public String getMrAmrGroupCode() {
		return mrAmrGroupCode;
	}

	public void setMrAmrGroupCode(String mrAmrGroupCode) {
		this.mrAmrGroupCode = mrAmrGroupCode;
	}

    public String getExecUnit()
    {
        return execUnit;
    }

    public void setExecUnit(String execUnit)
    {
        this.execUnit = execUnit;
    }

    public String getExecUnitName()
    {
        return execUnitName;
    }

    public void setExecUnitName(String execUnitName)
    {
        this.execUnitName = execUnitName;
    }

    public Date getRespTime()
    {
        return respTime;
    }

    public void setRespTime(Date respTime)
    {
        this.respTime = respTime;
    }

    public String getRequestDeptCode()
    {
        return requestDeptCode;
    }

    public void setRequestDeptCode(String requestDeptCode)
    {
        this.requestDeptCode = requestDeptCode;
    }

    public String getRequestDeptName()
    {
        return requestDeptName;
    }

    public void setRequestDeptName(String requestDeptName)
    {
        this.requestDeptName = requestDeptName;
    }

    public String getMrSummary()
    {
        return mrSummary;
    }

    public void setMrSummary(String mrSummary)
    {
        this.mrSummary = mrSummary;
    }

	public BigDecimal getDeptQaScr() {
		return deptQaScr;
	}

	public void setDeptQaScr(BigDecimal deptQaScr) {
		this.deptQaScr = deptQaScr;
	}
	
	
	
}
