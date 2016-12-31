package ei.ass.di.auto.po;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MzPatientDiagnosisEntityListener.class)
@Table(name = "mz_patient_diagnosis")
public class MzPatientDiagnosisEntity {

    /** */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(sequence = "")
    @Column(name = "sn")
    Integer sn;

    /** */
    @Column(name = "patient_id")
    String patientId;

    /** */
    @Column(name = "times")
    Short times;

    /** */
    @Column(name = "doctor_sn")
    String doctorSn;

    /** */
    @Column(name = "dept_sn")
    String deptSn;

    /** */
    @Column(name = "diag_str")
    String diagStr;

    /** */
    @Column(name = "diag_code")
    String diagCode;

    /** */
    @Column(name = "icd_code")
    String icdCode;

    /** */
    @Column(name = "comment_str")
    String commentStr;

    /** */
    @Column(name = "main_flag")
    String mainFlag;

    /** */
    @Column(name = "uncertain_flag")
    String uncertainFlag;
    
    /** */
    @Column(name = "suspected_flag")
    String suspectedFlag;

    /** */
    @Column(name = "contagion_flag")
    String contagionFlag;

    /** */
    @Column(name = "lvl1_sort_no")
    String lv1sortNo;

    /** */
    @Column(name = "lvl2_sort_no")
    String lv2sortNo;
        
    
    public String getLv1sortNo() {
		return lv1sortNo;
	}

	public void setLv1sortNo(String lv1sortNo) {
		this.lv1sortNo = lv1sortNo;
	}

	public String getLv2sortNo() {
		return lv2sortNo;
	}

	public void setLv2sortNo(String lv2sortNo) {
		this.lv2sortNo = lv2sortNo;
	}

	/** */
    @Column(name = "input_date")
    Timestamp inputDate;

    public String getSuspectedFlag() {
		return suspectedFlag;
	}

	public void setSuspectedFlag(String suspectedFlag) {
		this.suspectedFlag = suspectedFlag;
	}

	/** */
    @Column(name = "symptom")
    String symptom;

    /** 
     * Returns the sn.
     * 
     * @return the sn
     */
    public Integer getSn() {
        return sn;
    }

    /** 
     * Sets the sn.
     * 
     * @param sn the sn
     */
    public void setSn(Integer sn) {
        this.sn = sn;
    }

    /** 
     * Returns the patientId.
     * 
     * @return the patientId
     */
    public String getPatientId() {
        return patientId;
    }

    /** 
     * Sets the patientId.
     * 
     * @param patientId the patientId
     */
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    /** 
     * Returns the times.
     * 
     * @return the times
     */
    public Short getTimes() {
        return times;
    }

    /** 
     * Sets the times.
     * 
     * @param times the times
     */
    public void setTimes(Short times) {
        this.times = times;
    }

    /** 
     * Returns the doctorSn.
     * 
     * @return the doctorSn
     */
    public String getDoctorSn() {
        return doctorSn;
    }

    /** 
     * Sets the doctorSn.
     * 
     * @param doctorSn the doctorSn
     */
    public void setDoctorSn(String doctorSn) {
        this.doctorSn = doctorSn;
    }

    /** 
     * Returns the deptSn.
     * 
     * @return the deptSn
     */
    public String getDeptSn() {
        return deptSn;
    }

    /** 
     * Sets the deptSn.
     * 
     * @param deptSn the deptSn
     */
    public void setDeptSn(String deptSn) {
        this.deptSn = deptSn;
    }

    /** 
     * Returns the diagStr.
     * 
     * @return the diagStr
     */
    public String getDiagStr() {
        return diagStr;
    }

    /** 
     * Sets the diagStr.
     * 
     * @param diagStr the diagStr
     */
    public void setDiagStr(String diagStr) {
        this.diagStr = diagStr;
    }

    /** 
     * Returns the diagCode.
     * 
     * @return the diagCode
     */
    public String getDiagCode() {
        return diagCode;
    }

    /** 
     * Sets the diagCode.
     * 
     * @param diagCode the diagCode
     */
    public void setDiagCode(String diagCode) {
        this.diagCode = diagCode;
    }

    /** 
     * Returns the icdCode.
     * 
     * @return the icdCode
     */
    public String getIcdCode() {
        return icdCode;
    }

    /** 
     * Sets the icdCode.
     * 
     * @param icdCode the icdCode
     */
    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    /** 
     * Returns the commentStr.
     * 
     * @return the commentStr
     */
    public String getCommentStr() {
        return commentStr;
    }

    /** 
     * Sets the commentStr.
     * 
     * @param commentStr the commentStr
     */
    public void setCommentStr(String commentStr) {
        this.commentStr = commentStr;
    }

    /** 
     * Returns the mainFlag.
     * 
     * @return the mainFlag
     */
    public String getMainFlag() {
        return mainFlag;
    }

    /** 
     * Sets the mainFlag.
     * 
     * @param mainFlag the mainFlag
     */
    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }

    /** 
     * Returns the uncertainFlag.
     * 
     * @return the uncertainFlag
     */
    public String getUncertainFlag() {
        return uncertainFlag;
    }

    /** 
     * Sets the uncertainFlag.
     * 
     * @param uncertainFlag the uncertainFlag
     */
    public void setUncertainFlag(String uncertainFlag) {
        this.uncertainFlag = uncertainFlag;
    }

    /** 
     * Returns the contagionFlag.
     * 
     * @return the contagionFlag
     */
    public String getContagionFlag() {
        return contagionFlag;
    }

    /** 
     * Sets the contagionFlag.
     * 
     * @param contagionFlag the contagionFlag
     */
    public void setContagionFlag(String contagionFlag) {
        this.contagionFlag = contagionFlag;
    }

    /** 
     * Returns the inputDate.
     * 
     * @return the inputDate
     */
    public Timestamp getInputDate() {
        return inputDate;
    }

    /** 
     * Sets the inputDate.
     * 
     * @param inputDate the inputDate
     */
    public void setInputDate(Timestamp inputDate) {
        this.inputDate = inputDate;
    }

    /** 
     * Returns the symptom.
     * 
     * @return the symptom
     */
    public String getSymptom() {
        return symptom;
    }

    /** 
     * Sets the symptom.
     * 
     * @param symptom the symptom
     */
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}