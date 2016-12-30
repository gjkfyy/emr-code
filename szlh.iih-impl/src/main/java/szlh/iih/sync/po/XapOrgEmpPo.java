package szlh.iih.sync.po;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(listener = XapOrgEmpPoListener.class)
@Table(name = "iemr_org_emp")
public class XapOrgEmpPo {
	@Id
    @Column(name = "ORG_EMP_ID")
    private int  orgEmpId;
	private String empId;//EMP_ID;
	private String deptCd;//dept_cd;
	private String empNo;//emp_no;
	private String nm;//NM;
	private String nmSpell;//NM_SPELL;
	private String sexCd;//SEX_CD;
	private String birthday;//BIRTHDAY;
	private String idCardNo;//ID_CARD_NO;
	private String email;//EMAIL;
	private String jobTitleCd;//JOB_TITLE_CD;
	private String positionCd;//POSITION_CD;
	private String profCd;//PROF_CD;
	private String telNo;//TEL_NO;
	private String mobileNo;//MOBILE_NO;
	private String iemrJobTitleCd;//IEMR_JOB_TITLE_CD;
	private String delF;//del_f;
	private String flag;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		if(birthday != null){
			 this.birthday = birthday.substring(0,birthday.lastIndexOf("."));
		}else{
		    this.birthday = birthday;
		}
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobTitleCd() {
		return jobTitleCd;
	}
	public void setJobTitleCd(String jobTitleCd) {
		this.jobTitleCd = jobTitleCd;
	}
	public String getPositionCd() {
		return positionCd;
	}
	public void setPositionCd(String positionCd) {
		this.positionCd = positionCd;
	}
	public String getProfCd() {
		return profCd;
	}
	public void setProfCd(String profCd) {
		this.profCd = profCd;
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
	public String getIemrJobTitleCd() {
		return iemrJobTitleCd;
	}
	public void setIemrJobTitleCd(String iemrJobTitleCd) {
		this.iemrJobTitleCd = iemrJobTitleCd;
	}
	public String getDelF() {
		return delF;
	}
	public void setDelF(String delF) {
		this.delF = delF;
	}
	public int getOrgEmpId() {
		return orgEmpId;
	}
	public void setOrgEmpId(int orgEmpId) {
		this.orgEmpId = orgEmpId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
	

	
}
