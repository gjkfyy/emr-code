package iih.dr.model;

import java.util.Date;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class PatientRetrievalModel extends BaseBizModel{

	public PatientRetrievalModel(){
		 super();
	}

	public PatientRetrievalModel(String code){
		 super(code);
	}
	
	// 就诊主键
	@Column(name = "EN_PK")
    private String enPk;
    
	//患者ID
	@Column(name = "PA_ID")
    private String paId;
    
    //患者名称
  	@Column(name = "PA_NM")
    private String paNm;
    
    //性别编码
  	@Column(name = "SEX_CD")
	private String sexCd;
  	
  	//年龄
  	@Column(name = "AGE")
    private String age;
    
	// 病案号
	@Column(name = "AMR_NO")
	private String amrNo;
    
	// 当前科室编码
	@Column(name = "CUR_DEPT_CD")
	private String currentDeptCode;
	
	// 当前科室编码
	@Column(name = "CUR_DEPT_NM")
	private String currentDeptName;
	
	// 当前科室入科时间
	@Column(name = "CUR_DEPT_INTO_TIME")
	private Date currentDeptIntoTime;
	
	// 诊毕时间
	@Column(name = "FNSH_TIME")
	private Date finishTime;
    
    // 当前主诊断编码
 	@Column(name = "CUR_MAIN_DI_CD")
 	private String currentMainDiagnosisCode;
 	
 	// 病情状态编码
  	@Column(name = "ILL_STA_CD")
  	private String illStatusCode	;
  	
     @Column(name = "MEMO")
     private String memo;
    
    // 当前主诊断名称
    @Column(name = "CUR_MAIN_DI_NM")
 	private String currentMainDiagnosisName;
 	
 	// 病情状态名称
    @Column(name = "ILL_STA_NM")
 	private String illStatusName;
 	
	// 性别名称
    @Column(name = "SEX_NM")
 	private String sexName;

	public String getEnPk() {
		return enPk;
	}

	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}

	public String getPaId() {
		return paId;
	}

	public void setPaId(String paId) {
		this.paId = paId;
	}

	public String getPaNm() {
		return paNm;
	}

	public void setPaNm(String paNm) {
		this.paNm = paNm;
	}

	public String getSexCd() {
		return sexCd;
	}

	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAmrNo() {
		return amrNo;
	}

	public void setAmrNo(String amrNo) {
		this.amrNo = amrNo;
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

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getCurrentMainDiagnosisCode() {
		return currentMainDiagnosisCode;
	}

	public void setCurrentMainDiagnosisCode(String currentMainDiagnosisCode) {
		this.currentMainDiagnosisCode = currentMainDiagnosisCode;
	}

	public String getIllStatusCode() {
		return illStatusCode;
	}

	public void setIllStatusCode(String illStatusCode) {
		this.illStatusCode = illStatusCode;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCurrentMainDiagnosisName() {
		return currentMainDiagnosisName;
	}

	public void setCurrentMainDiagnosisName(String currentMainDiagnosisName) {
		this.currentMainDiagnosisName = currentMainDiagnosisName;
	}

	public String getIllStatusName() {
		return illStatusName;
	}

	public void setIllStatusName(String illStatusName) {
		this.illStatusName = illStatusName;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getCurrentDeptName() {
		return currentDeptName;
	}

	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}
 	
}