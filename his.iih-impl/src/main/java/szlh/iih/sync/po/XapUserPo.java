package szlh.iih.sync.po;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(listener = XapUserPoListener.class)
@Table(name = "iemr_xap_user")
public class XapUserPo {
	@Id
    @Column(name = "XAP_USER_ID")
	private int   xapUserId;
	private String xapUserPk;//主键	XAP_USER_PK
	private String userId;//用户编码	USER_ID
	private String empId;//人员编码	EMP_ID
	private String userStaCd;//用户状态	USER_STA_CD
	private String SignPic;//用户图片	SIGN_PIC
	private String pwd;//密码	PWD
	private String nm;//名称	NM
	private String nmSpell;//名称拼音	NM_SPELL
	private String sexCd;//性别编码	SEX_CD
	private String email;//邮箱	EMAIL
	private String jobTitleCd;//职称	JOB_TITLE_CD
	private String mobileNo;//手机	MOBILE_NO
	private String telNo;//电话	TEL_NO
	private String orgCd;//科室	ORG_CD
	private String loginNm;
	private String delF;
	private String dctNsF;
	
	private String flag;   //I 插入，U 更新，D 删除
	public String getXapUserPk() {
		return xapUserPk;
	}
	public void setXapUserPk(String xapUserPk) {
		this.xapUserPk = xapUserPk;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getUserStaCd() {
		return userStaCd;
	}
	public void setUserStaCd(String userStaCd) {
		this.userStaCd = userStaCd;
	}
	public String getSignPic() {
		return SignPic;
	}
	public void setSignPic(String signPic) {
		SignPic = signPic;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getNmSpell() {
		return nmSpell;
	}
	public void setNmSpell(String nmSpell) {
		this.nmSpell = nmSpell;
	}
	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	 
	 
	public String getJobTitleCd() {
		return jobTitleCd;
	}
	public void setJobTitleCd(String jobTitleCd) {
		this.jobTitleCd = jobTitleCd;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	public String getDelF() {
		return delF;
	}
	public void setDelF(String delF) {
		this.delF = delF;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLoginNm() {
		return loginNm;
	}
	public void setLoginNm(String loginNm) {
		this.loginNm = loginNm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getXapUserId() {
		return xapUserId;
	}
	public void setXapUserId(int xapUserId) {
		this.xapUserId = xapUserId;
	}
	public String getDctNsF() {
		return dctNsF;
	}
	public void setDctNsF(String dctNsF) {
		this.dctNsF = dctNsF;
	}
 
	
	
	
    

}
