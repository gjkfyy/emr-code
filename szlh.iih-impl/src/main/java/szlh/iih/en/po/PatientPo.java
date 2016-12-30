/**
 * 
 */
package szlh.iih.en.po;

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

}
