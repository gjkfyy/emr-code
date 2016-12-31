/**
 * 
 */
package ei.pa.po;

import org.seasar.doma.Entity;

/**
 * @author wang_yanli
 * 患者信息视图(按照适配器标准，该视图信息作为病历文书XML的一部分)
 */
@Entity
public class PatientInfoForXMLPo {
	private String 		hospitalCode; //医院编码
	private String 		hospitalName; //医院名称
	private String  	roomNo;		  //房间号
	private String 		age;		  //年龄
	
	private String      patientId;
	private String      legalName;    //姓名
	private String      socialNo;     //身份证号
	private String      gender;       //性别编码
	private String      genderTxt;    //性别
	private String      maritalStatusCode;//婚姻编码
	private String      maritalTxt;   //婚姻
	private String      birthTime;    //出生日期
	private String      bloodType;    //血型
	private String      raceCode;     //民族代码
	private String      raceName;     //民族
	private String      citizenCode;  //国籍编码
	private String      citizenName;  //国籍
	private String      birthPlace;   //出生地编码
	private String      birthPlaceName; //出生地名称
	private String      occupationCode;//职业编码 
	private String      occupationName;//职业
	private String      patientAddress;//病人现住址
	private String      address;       //住址
	private String      telAddr;       //联系电话
	private String      relationName;  //联系人姓名
	private String      relationCode;  //联系人关系编码
	private String      relationCodeNm;//关系名称
	private String      responseType;  //医保类型
	private String      responseName;  //医保名称
	private String      encType;       //就诊类型
	private String      patientNo;     //住院号/门诊号
	private String      encId;         //就诊号
	private String      effectiveB;    //入院时间
	private String      admissionResponsibleParty; //入院科室编码
	private String      admissWard;	   //入院病区编码
	private String      admitter;      //入院医生 
	private String      activityB;     //入科时间
	private String      ryzd;		   //入院诊断编码
	private String      ryzdmc;        //入院诊断名称
	private String      orgId;         //科室编码
	private String      orgName;       //科室名称
	private String      wardCode;      //病区编码
	private String      ward;          //病区名称
	private String      bed;           //床号
	private String      attender;      //主管医生
	private String      nurser;        //主管护士
	private String      deptDirector;  //科室主任
	private String      activityE;     //出科时间
	private String      effectiveE;    //出院时间
	private String      dischargeResponsibleParty;//出院科室
	private String      disWard;       //出院病区
	private String      discharger;    //出院医生
	private String      cyzd;          //出院诊断编码
	private String      cyzdmc;        //出院诊断名称
	private String      inVisitTimes;  //住院次数
	private String      nurseLevel;    //护理级别
	private String      nurseLevelName; //护理级别名称
	
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getSocialNo() {
		return socialNo;
	}
	public void setSocialNo(String socialNo) {
		this.socialNo = socialNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGenderTxt() {
		return genderTxt;
	}
	public void setGenderTxt(String genderTxt) {
		this.genderTxt = genderTxt;
	}
	public String getMaritalStatusCode() {
		return maritalStatusCode;
	}
	public void setMaritalStatusCode(String maritalStatusCode) {
		this.maritalStatusCode = maritalStatusCode;
	}
	public String getMaritalTxt() {
		return maritalTxt;
	}
	public void setMaritalTxt(String maritalTxt) {
		this.maritalTxt = maritalTxt;
	}
	public String getBirthTime() {
		return birthTime;
	}
	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getRaceCode() {
		return raceCode;
	}
	public void setRaceCode(String raceCode) {
		this.raceCode = raceCode;
	}
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public String getCitizenCode() {
		return citizenCode;
	}
	public void setCitizenCode(String citizenCode) {
		this.citizenCode = citizenCode;
	}
	public String getCitizenName() {
		return citizenName;
	}
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getBirthPlaceName() {
		return birthPlaceName;
	}
	public void setBirthPlaceName(String birthPlaceName) {
		this.birthPlaceName = birthPlaceName;
	}
	public String getOccupationCode() {
		return occupationCode;
	}
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}
	public String getOccupationName() {
		return occupationName;
	}
	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelAddr() {
		return telAddr;
	}
	public void setTelAddr(String telAddr) {
		this.telAddr = telAddr;
	}
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	public String getRelationCode() {
		return relationCode;
	}
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}
	public String getRelationCodeNm() {
		return relationCodeNm;
	}
	public void setRelationCodeNm(String relationCodeNm) {
		this.relationCodeNm = relationCodeNm;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public String getResponseName() {
		return responseName;
	}
	public void setResponseName(String responseName) {
		this.responseName = responseName;
	}
	public String getEncType() {
		return encType;
	}
	public void setEncType(String encType) {
		this.encType = encType;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getEncId() {
		return encId;
	}
	public void setEncId(String encId) {
		this.encId = encId;
	}
	public String getEffectiveB() {
		return effectiveB;
	}
	public void setEffectiveB(String effectiveB) {
		this.effectiveB = effectiveB;
	}
	public String getAdmissionResponsibleParty() {
		return admissionResponsibleParty;
	}
	public void setAdmissionResponsibleParty(String admissionResponsibleParty) {
		this.admissionResponsibleParty = admissionResponsibleParty;
	}
	public String getAdmissWard() {
		return admissWard;
	}
	public void setAdmissWard(String admissWard) {
		this.admissWard = admissWard;
	}
	public String getAdmitter() {
		return admitter;
	}
	public void setAdmitter(String admitter) {
		this.admitter = admitter;
	}
	public String getActivityB() {
		return activityB;
	}
	public void setActivityB(String activityB) {
		this.activityB = activityB;
	}
	public String getRyzd() {
		return ryzd;
	}
	public void setRyzd(String ryzd) {
		this.ryzd = ryzd;
	}
	public String getRyzdmc() {
		return ryzdmc;
	}
	public void setRyzdmc(String ryzdmc) {
		this.ryzdmc = ryzdmc;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getWardCode() {
		return wardCode;
	}
	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getAttender() {
		return attender;
	}
	public void setAttender(String attender) {
		this.attender = attender;
	}
	public String getNurser() {
		return nurser;
	}
	public void setNurser(String nurser) {
		this.nurser = nurser;
	}
	public String getDeptDirector() {
		return deptDirector;
	}
	public void setDeptDirector(String deptDirector) {
		this.deptDirector = deptDirector;
	}
	public String getActivityE() {
		return activityE;
	}
	public void setActivityE(String activityE) {
		this.activityE = activityE;
	}
	public String getEffectiveE() {
		return effectiveE;
	}
	public void setEffectiveE(String effectiveE) {
		this.effectiveE = effectiveE;
	}
	public String getDischargeResponsibleParty() {
		return dischargeResponsibleParty;
	}
	public void setDischargeResponsibleParty(String dischargeResponsibleParty) {
		this.dischargeResponsibleParty = dischargeResponsibleParty;
	}
	public String getDisWard() {
		return disWard;
	}
	public void setDisWard(String disWard) {
		this.disWard = disWard;
	}
	public String getDischarger() {
		return discharger;
	}
	public void setDischarger(String discharger) {
		this.discharger = discharger;
	}
	public String getCyzd() {
		return cyzd;
	}
	public void setCyzd(String cyzd) {
		this.cyzd = cyzd;
	}
	public String getCyzdmc() {
		return cyzdmc;
	}
	public void setCyzdmc(String cyzdmc) {
		this.cyzdmc = cyzdmc;
	}
	public String getInVisitTimes() {
		return inVisitTimes;
	}
	public void setInVisitTimes(String inVisitTimes) {
		this.inVisitTimes = inVisitTimes;
	}
	public String getNurseLevel() {
		return nurseLevel;
	}
	public void setNurseLevel(String nurseLevel) {
		this.nurseLevel = nurseLevel;
	}
	public String getNurseLevelName() {
		return nurseLevelName;
	}
	public void setNurseLevelName(String nurseLevelName) {
		this.nurseLevelName = nurseLevelName;
	}

	

}
