package pkuhit.iih.mr.wr;


public class MrXML {
	//文档流水号
	private String id;
	//病历状态编码
	private String mrStatusCode;
	//文档生成时间yyyymmddhhmmss
	private String effectiveTime;
	//域ID
	private String domainId;
	//住院号标识
	private String enPk;
	private String title;
	//文档创作者Id
	private String authorId;
	//文档创作者姓名
	private String authorName;
	//文档时间yyyymmdd
	private String docTime;
	//文档医生编号
	private String doctorId;
	//文档医生
	private String doctorName;
	
	//接诊审核日期
	private String treatDoctorTime;
	//接诊审核医生编码
	private String treatDoctorId;
	//接诊审核医生姓名
	private String treatDoctorName;
	
	//住院审核日期
	private String mastDoctorTime;
	//住院审核医生编码
	private String mastDoctorId;
	//住院审核医生姓名
	private String mastDoctorName;
	
	//主治审核日期
	private String dirDoctorTime;
	//主治审核医生编码
	private String dirDoctorId;
	//主治审核医生姓名
	private String dirDoctorName;
		
	//最终审核日期
	private String auditTime;
	//最终审核医生编码
	private String auditDoctorId;
	//最终审核医生姓名
	private String auditDoctorName;
	

	public String getEnPk() {
		return enPk;
	}

	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}

	public String getTreatDoctorTime() {
		return treatDoctorTime;
	}

	public void setTreatDoctorTime(String treatDoctorTime) {
		this.treatDoctorTime = treatDoctorTime;
	}


	public String getTreatDoctorId() {
		return treatDoctorId;
	}

	public void setTreatDoctorId(String treatDoctorId) {
		this.treatDoctorId = treatDoctorId;
	}

	public String getTreatDoctorName() {
		return treatDoctorName;
	}

	public void setTreatDoctorName(String treatDoctorName) {
		this.treatDoctorName = treatDoctorName;
	}

	public String getMastDoctorTime() {
		return mastDoctorTime;
	}

	public void setMastDoctorTime(String mastDoctorTime) {
		this.mastDoctorTime = mastDoctorTime;
	}

	public String getMastDoctorId() {
		return mastDoctorId;
	}

	public void setMastDoctorId(String mastDoctorId) {
		this.mastDoctorId = mastDoctorId;
	}

	public String getMastDoctorName() {
		return mastDoctorName;
	}

	public void setMastDoctorName(String mastDoctorName) {
		this.mastDoctorName = mastDoctorName;
	}

	public String getDirDoctorTime() {
		return dirDoctorTime;
	}

	public void setDirDoctorTime(String dirDoctorTime) {
		this.dirDoctorTime = dirDoctorTime;
	}

	public String getDirDoctorId() {
		return dirDoctorId;
	}

	public void setDirDoctorId(String dirDoctorId) {
		this.dirDoctorId = dirDoctorId;
	}

	public String getDirDoctorName() {
		return dirDoctorName;
	}

	public void setDirDoctorName(String dirDoctorName) {
		this.dirDoctorName = dirDoctorName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDocTime() {
		return docTime;
	}

	public void setDocTime(String docTime) {
		this.docTime = docTime;
	}

	public String getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getAuditDoctorId() {
		return auditDoctorId;
	}

	public void setAuditDoctorId(String auditDoctorId) {
		this.auditDoctorId = auditDoctorId;
	}

	public String getAuditDoctorName() {
		return auditDoctorName;
	}

	public void setAuditDoctorName(String auditDoctorName) {
		this.auditDoctorName = auditDoctorName;
	}

	public String getMrStatusCode() {
		return mrStatusCode;
	}

	public void setMrStatusCode(String mrStatusCode) {
		this.mrStatusCode = mrStatusCode;
	}

	
}
