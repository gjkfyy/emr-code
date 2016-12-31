package iih.di.model;

public class UserModel {
	private String userCd; // 用户编码
	private String userNm; // 用户姓名
	private String jobTitleCd;// 用户职称编码
	private String jobTitleNm;// 用户职称名称
	private String deptCd;// 所属科室编码
	private String deptNm;// 所属科室名称
	private String orgCd;// 组织机构编码
	private String orgNm;// 组织结构名称

	public String getUserCd() {
		return userCd;
	}

	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getJobTitleCd() {
		return jobTitleCd;
	}

	public void setJobTitleCd(String jobTitleCd) {
		this.jobTitleCd = jobTitleCd;
	}

	public String getJobTitleNm() {
		return jobTitleNm;
	}

	public void setJobTitleNm(String jobTitleNm) {
		this.jobTitleNm = jobTitleNm;
	}

	public String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
}
