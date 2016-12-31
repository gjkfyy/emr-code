/**
 * 
 */
package ei.en.db.dao.po;

import org.seasar.doma.Entity;

/**
 * @author guo_zhongbao
 * 患者视图model
 */
@Entity
public class PatientPo {
	private String	 	paId	;	//	患者ID
	private String	 	nm	;	//	姓名
	private String	 	birthday	;	//	出生日期
	private String	 	idCardNo	;	//	身份证号
	private String	 	sexCd	;	//	性别编码
	private String	 	sexNm	;	//	性别名称
	private String	 	mariCd	;	//	婚姻状况编码
	private String	 	mariNm	;	//	婚姻状况名称
	private Integer	 	deathF	;	//	死亡标志
	private String	 	deathDate	;	//	死亡日期
	private Integer	 	autopsyF	;	//	尸检标志
	private String	 	telNo	;	//	固定电话
	private String	 	mobileNo	;	//	移动电话
	private String	 	email	;	//	电子邮箱
	private String	 	workOrgCd	;	//	工作单位编码
	private String	 	workOrgNm	;	//	工作单位名称
	private String	 	nationCd;	//	民族编码
	private String	 	nationNm;	//	民族名称
	private String	 	occuCd;	//	职业编码
	private String	 	occuNm;	//	职业名称
	private String	 	distCd;	//	出生地编码
	private String	 	distNm;	//	出生地名称
	private String      encounterCardNo;//门诊卡号
	private String      homeAddress;//家庭住址	
	private String		idCardAdress;//户口地址
	private String		relationName;//联系人
	private String		relation;//关系
	private String		relationTel;//联系人电话
	private String		reservedColumn1;//预留字段1
	private String		reservedColumn2;//预留字段2
	private String		reservedColumn3;//预留字段3
	private String		reservedColumn4;//预留字段4
	private String		reservedColumn5;//预留字段5
	private String		reservedColumn6;//预留字段6
	private String		reservedColumn7;//预留字段7
	private String		reservedColumn8;//预留字段8
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getPaId() {
		return paId;
	}
	public void setPaId(String paId) {
		this.paId = paId;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	public String getSexNm() {
		return sexNm;
	}
	public void setSexNm(String sexNm) {
		this.sexNm = sexNm;
	}
	public String getMariCd() {
		return mariCd;
	}
	public void setMariCd(String mariCd) {
		this.mariCd = mariCd;
	}
	public String getMariNm() {
		return mariNm;
	}
	public void setMariNm(String mariNm) {
		this.mariNm = mariNm;
	}
	public Integer getDeathF() {
		return deathF;
	}
	public void setDeathF(Integer deathF) {
		this.deathF = deathF;
	}
	public String getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
	public Integer getAutopsyF() {
		return autopsyF;
	}
	public void setAutopsyF(Integer autopsyF) {
		this.autopsyF = autopsyF;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWorkOrgCd() {
		return workOrgCd;
	}
	public void setWorkOrgCd(String workOrgCd) {
		this.workOrgCd = workOrgCd;
	}
	public String getWorkOrgNm() {
		return workOrgNm;
	}
	public void setWorkOrgNm(String workOrgNm) {
		this.workOrgNm = workOrgNm;
	}
	public String getNationCd() {
		return nationCd;
	}
	public void setNationCd(String nationCd) {
		this.nationCd = nationCd;
	}
	public String getNationNm() {
		return nationNm;
	}
	public void setNationNm(String nationNm) {
		this.nationNm = nationNm;
	}
	public String getOccuCd() {
		return occuCd;
	}
	public void setOccuCd(String occuCd) {
		this.occuCd = occuCd;
	}
	public String getOccuNm() {
		return occuNm;
	}
	public void setOccuNm(String occuNm) {
		this.occuNm = occuNm;
	}
	public String getDistCd() {
		return distCd;
	}
	public void setDistCd(String distCd) {
		this.distCd = distCd;
	}
	public String getDistNm() {
		return distNm;
	}
	public void setDistNm(String distNm) {
		this.distNm = distNm;
	}
	public String getEncounterCardNo() {
		return encounterCardNo;
	}
	public void setEncounterCardNo(String encounterCardNo) {
		this.encounterCardNo = encounterCardNo;
	}
	public String getIdCardAdress() {
		return idCardAdress;
	}
	public void setIdCardAdress(String idCardAdress) {
		this.idCardAdress = idCardAdress;
	}
	
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getRelationTel() {
		return relationTel;
	}
	public void setRelationTel(String relationTel) {
		this.relationTel = relationTel;
	}
	
	public String getReservedColumn1() {
		return reservedColumn1;
	}
	public void setReservedColumn1(String reservedColumn1) {
		this.reservedColumn1 = reservedColumn1;
	}
	public String getReservedColumn2() {
		return reservedColumn2;
	}
	public void setReservedColumn2(String reservedColumn2) {
		this.reservedColumn2 = reservedColumn2;
	}
	public String getReservedColumn3() {
		return reservedColumn3;
	}
	public void setReservedColumn3(String reservedColumn3) {
		this.reservedColumn3 = reservedColumn3;
	}
	public String getReservedColumn4() {
		return reservedColumn4;
	}
	public void setReservedColumn4(String reservedColumn4) {
		this.reservedColumn4 = reservedColumn4;
	}
	public String getReservedColumn5() {
		return reservedColumn5;
	}
	public void setReservedColumn5(String reservedColumn5) {
		this.reservedColumn5 = reservedColumn5;
	}
	public String getReservedColumn6() {
		return reservedColumn6;
	}
	public void setReservedColumn6(String reservedColumn6) {
		this.reservedColumn6 = reservedColumn6;
	}
	public String getReservedColumn7() {
		return reservedColumn7;
	}
	public void setReservedColumn7(String reservedColumn7) {
		this.reservedColumn7 = reservedColumn7;
	}
	public String getReservedColumn8() {
		return reservedColumn8;
	}
	public void setReservedColumn8(String reservedColumn8) {
		this.reservedColumn8 = reservedColumn8;
	}

}
