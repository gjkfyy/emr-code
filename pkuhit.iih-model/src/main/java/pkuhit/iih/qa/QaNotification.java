package pkuhit.iih.qa;

import java.math.BigInteger;
import java.sql.Timestamp;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class QaNotification extends BaseBizModel {

	public QaNotification() {

		super();

	}

	public QaNotification(String code) {

		super(code);

	}

	public static final String OBJ_CD  = "QAM11";
	
	@Column(name = "REVISION_CD")
	private String revisionCd;
	
	@Column(name = "STATUS")
	private String status;
	
	@DictionaryTag(code = "status",objCd = "QAM11")
	private String statusNM;
	
	@Column(name = "SEND_TIME")
	private Timestamp sendTime;
	
	@Column(name = "EXEC_DOCTOR_CD")
	private String execDoctorCd;
	
	@DictionaryTag(code = "execDoctorCd", objCd = "ORGB04")
	private String execDoctorNM;
	
	@Column(name = "RFM_DEADLINE")
	private BigInteger rfmDeadline;
	
	@Column(name = "DEADLINE")
	private Timestamp deadline;
	
	@Column(name = "EXEC_DEPT_CD")
	private String execDeptCd;
	
	@DictionaryTag(code = "execDeptCd", objCd = "ORGB01")
	private String execDeptNM;
	
	@Column(name = "EN_PK")
	private String enPk;
	
	@Column(name = "RFM_DOCTOR_CD")
	private String rfmDoctorCd;
	
	@DictionaryTag(code = "rfmDoctorCd", objCd = "ORGB04")
	private String rfmDoctorNM;
	
	@Column(name = "RFM_DEPT_CD")
	private String rfmDeptCd;
	
	@DictionaryTag(code = "rfmDeptCd", objCd = "ORGB01")
	private String rfmDeptNM;
	
	@Column(name = "QA_TY_CD")
	private String qaTyCd;
	
	@DictionaryTag(code = "qaTyCd" ,objCd="QAM13")
	private String qaTyNM;
	
	@Column(name = "CMPL_F")
	private String cmplF;
	
	@Column(name = "MEMO")
	private String memo;
	
	@Column(name = "SORT_NO")
	private String sortNo;
	
	@Column(name = "SPELL_NO")
	private String spellNo;
	
	@Column(name = "WUBI_NO")
	private String wubiNo;
	
	@Column(name = "UPD_CNT")
	private BigInteger updCnt;
	
	@Column(name = "CRT_TIME")
	private Timestamp crtTime;
	
	@Column(name = "CRT_USER_ID")
	private String crtUserId;
	
	@Column(name = "CRT_DEPT_CD")
	private String crtDeptCd;
	
	@Column(name = "LAST_UPD_TIME")
	private Timestamp lastUpdTime;
	
	@Column(name = "LAST_UPD_DEPT_CD")
	private String lastUpdDeptCd;
	
	@Column(name = "LAST_UPD_USER_ID")
	private String lastUpdUserId;
	
	@Column(name = "DEL_F")
	private Short delF;
	
	@Column(name = "PA_NM")
	private String patientName;
	
	@Column(name = "PA_ID")
	private String patientId;
	
	@Column(name = "SEX_CD")
	private String sexCode;
	
	@DictionaryTag(code = "sexCode", objCd = "MDM05")
	private String sexName;
	
	@Column(name = "AGE")
	private String age;
	
	@Column(name = "AMR_NO")
	private String amrNo;
	
	@Column(name = "EN_NO")
	private String encounterNo;
	
	@Column(name = "CUR_MAIN_DI_CD")
	private String currentMainDiagnosisCode;
	
	@DictionaryTag(code = "currentMainDiagnosisCode", objCd = "DIM01")
	private String currentMainDiagnosisName;
	
	@Column(name = "CUR_DEPT_INTO_TIME")
	private Timestamp currentDeptIntoTime;
	
	@Column(name = "CUR_BED_CD")
	private String currentBedCode;
	
    @Column(name = "RFM_TIME")
    private Timestamp rfmTime;
	
	private int defectCount;

	public String getRevisionCd() {
		return revisionCd;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getDefectCount() {
		return defectCount;
	}

	public void setDefectCount(int defectCount) {
		this.defectCount = defectCount;
	}

	public void setRevisionCd(String revisionCd) {
		this.revisionCd = revisionCd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getExecDoctorCd() {
		return execDoctorCd;
	}

	public void setExecDoctorCd(String execDoctorCd) {
		this.execDoctorCd = execDoctorCd;
	}

	public BigInteger getRfmDeadline() {
		return rfmDeadline;
	}

	public void setRfmDeadline(BigInteger rfmDeadline) {
		this.rfmDeadline = rfmDeadline;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public String getExecDeptCd() {
		return execDeptCd;
	}

	public void setExecDeptCd(String execDeptCd) {
		this.execDeptCd = execDeptCd;
	}

	public String getEnPk() {
		return enPk;
	}

	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}

	public String getRfmDoctorCd() {
		return rfmDoctorCd;
	}

	public void setRfmDoctorCd(String rfmDoctorCd) {
		this.rfmDoctorCd = rfmDoctorCd;
	}

	public String getRfmDeptCd() {
		return rfmDeptCd;
	}

	public void setRfmDeptCd(String rfmDeptCd) {
		this.rfmDeptCd = rfmDeptCd;
	}

	public String getQaTyCd() {
		return qaTyCd;
	}

	public void setQaTyCd(String qaTyCd) {
		this.qaTyCd = qaTyCd;
	}

	public String getCmplF() {
		return cmplF;
	}

	public void setCmplF(String cmplF) {
		this.cmplF = cmplF;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSortNo() {
		return sortNo;
	}

	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	public String getSpellNo() {
		return spellNo;
	}

	public void setSpellNo(String spellNo) {
		this.spellNo = spellNo;
	}

	public String getWubiNo() {
		return wubiNo;
	}

	public void setWubiNo(String wubiNo) {
		this.wubiNo = wubiNo;
	}

	public BigInteger getUpdCnt() {
		return updCnt;
	}

	public void setUpdCnt(BigInteger updCnt) {
		this.updCnt = updCnt;
	}

	public Timestamp getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Timestamp crtTime) {
		this.crtTime = crtTime;
	}

	public String getCrtUserId() {
		return crtUserId;
	}

	public void setCrtUserId(String crtUserId) {
		this.crtUserId = crtUserId;
	}

	public String getCrtDeptCd() {
		return crtDeptCd;
	}

	public void setCrtDeptCd(String crtDeptCd) {
		this.crtDeptCd = crtDeptCd;
	}

	public Timestamp getLastUpdTime() {
		return lastUpdTime;
	}

	public void setLastUpdTime(Timestamp lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	public String getLastUpdDeptCd() {
		return lastUpdDeptCd;
	}

	public void setLastUpdDeptCd(String lastUpdDeptCd) {
		this.lastUpdDeptCd = lastUpdDeptCd;
	}

	public String getLastUpdUserId() {
		return lastUpdUserId;
	}

	public void setLastUpdUserId(String lastUpdUserId) {
		this.lastUpdUserId = lastUpdUserId;
	}

	public Short getDelF() {
		return delF;
	}

	public void setDelF(Short delF) {
		this.delF = delF;
	}

    public String getExecDoctorNM()
    {
        return execDoctorNM;
    }

    public void setExecDoctorNM(String execDoctorNM)
    {
        this.execDoctorNM = execDoctorNM;
    }

    public String getExecDeptNM()
    {
        return execDeptNM;
    }

    public void setExecDeptNM(String execDeptNM)
    {
        this.execDeptNM = execDeptNM;
    }

    public String getRfmDoctorNM()
    {
        return rfmDoctorNM;
    }

    public void setRfmDoctorNM(String rfmDoctorNM)
    {
        this.rfmDoctorNM = rfmDoctorNM;
    }

    public String getRfmDeptNM()
    {
        return rfmDeptNM;
    }

    public void setRfmDeptNM(String rfmDeptNM)
    {
        this.rfmDeptNM = rfmDeptNM;
    }

    public String getQaTyNM()
    {
        return qaTyNM;
    }

    public void setQaTyNM(String qaTyNM)
    {
        this.qaTyNM = qaTyNM;
    }

    public String getStatusNM()
    {
        return statusNM;
    }

    public void setStatusNM(String statusNM)
    {
        this.statusNM = statusNM;
    }

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
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

	public String getCurrentMainDiagnosisCode() {
		return currentMainDiagnosisCode;
	}

	public void setCurrentMainDiagnosisCode(String currentMainDiagnosisCode) {
		this.currentMainDiagnosisCode = currentMainDiagnosisCode;
	}

	public Timestamp getCurrentDeptIntoTime() {
		return currentDeptIntoTime;
	}

	public void setCurrentDeptIntoTime(Timestamp currentDeptIntoTime) {
		this.currentDeptIntoTime = currentDeptIntoTime;
	}

	public String getCurrentBedCode() {
		return currentBedCode;
	}

	public void setCurrentBedCode(String currentBedCode) {
		this.currentBedCode = currentBedCode;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getCurrentMainDiagnosisName() {
		return currentMainDiagnosisName;
	}

	public void setCurrentMainDiagnosisName(String currentMainDiagnosisName) {
		this.currentMainDiagnosisName = currentMainDiagnosisName;
	}

	public Timestamp getRfmTime() {
		return rfmTime;
	}

	public void setRfmTime(Timestamp rfmTime) {
		this.rfmTime = rfmTime;
	}

}