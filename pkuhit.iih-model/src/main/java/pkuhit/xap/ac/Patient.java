package pkuhit.xap.ac;
import java.math.BigInteger;
import java.sql.Timestamp;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;

public class Patient {
	 public Patient(){
		  super();
		 }
	
	//患者ID
	@Column(name="PATIENT_ID")
	String patientId;
		//患者姓名
	@Column(name="PATIENT_NAME") 
	 String patientName;
		// 住院号
	@Column(name="INPATIENT_NO") 
	 String inpatientNo;
		// X片号
	@Column(name="XPIAN_NO") 
	 String xpianNo;
		// 患者性别
	@Column(name="SEX") 
	 String sex;
	
	String sexValue;
		// 父母名
	@Column(name="PARENT_NAME") 
	 String parentName;
		// 年龄
	@Column(name="AGE") 
	 String age;
		// 民族
	@Column(name="NATION") 
	 String nation;
	
	// 胎次
	@Column(name = "PARITY")
	 String parity;
	
	// 婚姻
	@Column(name = "MARRIAGE")
	 String marriage;
		// 入院日期
	@Column(name="ADMISSION_DATE") 
	Timestamp admissionDate;
		// 职业
	@Column(name="OCCUPATION") 
	 String occupation;
		// 文化程度
	@Column(name="EDUCATION") 
	 String education;
	
	// 发病年龄
	@Column(name="ONSET_AGE") 
	 String onsetAge;
	
	// 家族史
	@Column(name="FAMILY_HISTORY") 
	 String familyHistory;
		// 病因
	@Column(name="PATHOGENY") 
	 String pathogeny;
	
	// 供史者
	@Column(name="PROVIDER") 
	 String provider;
		// 病史
	@Column(name="MEDICAL_HISTORY") 
	 String medicalHistory;
	
	// 治疗史
	@Column(name="TREATMENT_HISTORY") 
	 String treatmentHistory;
	
	// 腰部治疗史
	@Column(name="LUMBAR_SURGERY_HISTORY") 
	 String lumbarSurgeryHistory;
	
	// 矫形手术史
	@Column(name="ORTHOPEDIC_SURGERY_HISTORY") 
	 String orthopedicSurgeryHistory;
	
	// 地址
	@Column(name="ADRESS") 
	 String adress;
	
	// 手机号码
	@Column(name="TEL") 
	 String tel;
	
	// QQ/微信/EMAIL
	@Column(name="OTHER_CONTACT") 
	 String otherContact;
	
	// 体检
	@Column(name="PHYSICAL_EXAM") 
	 String physicalExam;
	
	// 发育
	@Column(name="GROWTH") 
	 String growth;
	
	// 营养
	@Column(name="NUTRITION") 
	 String nutrition;
	
	// 身高
	@Column(name="HEIGHT") 
	 String height;
	
	// 体重
	@Column(name="WEIGHT") 
	 String weight;
	
	// 专科检查
	@Column(name="SPECIALITY_EXAM") 
	 String specialityExam;
	
	// 照相
	@Column(name="IS_PIC") 
	 String isPic;
	
	// 录像
	@Column(name="IS_VIDEO") 
	 String isVideo;
	
	//其它疾病史
	@Column(name="OTHER_DISEASES_HISTORY") 
	 String otherDiseasesHistory;
	
	//修改次数
    @Column(name = "UPD_CNT")
    BigInteger updCnt;

    //创建时间
    @Column(name = "CRT_TIME")
    Timestamp crtTime;

    //创建人ID
    @Column(name = "CRT_USER_ID")
    String crtUserId;

    //创建科室ID
    @Column(name = "CRT_DEPT_CD")
    String crtDeptCd;

    //最后修改时间
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    //最后修改科室ID
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    //最后修改人ID
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;

    //删除标识
    @Column(name = "DEL_F")
    Short delF;
    
    String flag;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getInpatientNo() {
		return inpatientNo;
	}

	public void setInpatientNo(String inpatientNo) {
		this.inpatientNo = inpatientNo;
	}

	public String getXpianNo() {
		return xpianNo;
	}

	public void setXpianNo(String xpianNo) {
		this.xpianNo = xpianNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getSexValue() {
		return sexValue;
	}

	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getParity() {
		return parity;
	}

	public void setParity(String parity) {
		this.parity = parity;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public Timestamp getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Timestamp admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOnsetAge() {
		return onsetAge;
	}

	public void setOnsetAge(String onsetAge) {
		this.onsetAge = onsetAge;
	}
	
	public String getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	public String getPathogeny() {
		return pathogeny;
	}

	public void setPathogeny(String pathogeny) {
		this.pathogeny = pathogeny;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getTreatmentHistory() {
		return treatmentHistory;
	}

	public void setTreatmentHistory(String treatmentHistory) {
		this.treatmentHistory = treatmentHistory;
	}

	public String getLumbarSurgeryHistory() {
		return lumbarSurgeryHistory;
	}

	public void setLumbarSurgeryHistory(String lumbarSurgeryHistory) {
		this.lumbarSurgeryHistory = lumbarSurgeryHistory;
	}

	public String getOrthopedicSurgeryHistory() {
		return orthopedicSurgeryHistory;
	}

	public void setOrthopedicSurgeryHistory(String orthopedicSurgeryHistory) {
		this.orthopedicSurgeryHistory = orthopedicSurgeryHistory;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOtherContact() {
		return otherContact;
	}

	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}

	public String getPhysicalExam() {
		return physicalExam;
	}

	public void setPhysicalExam(String physicalExam) {
		this.physicalExam = physicalExam;
	}

	public String getGrowth() {
		return growth;
	}

	public void setGrowth(String growth) {
		this.growth = growth;
	}

	public String getNutrition() {
		return nutrition;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSpecialityExam() {
		return specialityExam;
	}

	public void setSpecialityExam(String specialityExam) {
		this.specialityExam = specialityExam;
	}

	public String getIsPic() {
		return isPic;
	}

	public void setIsPic(String isPic) {
		this.isPic = isPic;
	}

	public String getIsVideo() {
		return isVideo;
	}

	public void setIsVideo(String isVideo) {
		this.isVideo = isVideo;
	}

	public String getOtherDiseasesHistory() {
		return otherDiseasesHistory;
	}

	public void setOtherDiseasesHistory(String otherDiseasesHistory) {
		this.otherDiseasesHistory = otherDiseasesHistory;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}