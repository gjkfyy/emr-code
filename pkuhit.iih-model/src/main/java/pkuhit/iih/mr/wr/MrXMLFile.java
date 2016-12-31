package pkuhit.iih.mr.wr;

public class MrXMLFile {
	private String mrPk;
	private String mrXmlData;
	private String mrName;
	private String patientId;//病人编号
	private String mrSatusCode;//病历状态编码
	private String creatorName;  //创建者姓名
	private String createDateTime;//创建时间
	private String lastModifyDateTime;//最后修改时间
	public String getMrPk() {
		return mrPk;
	}
	public void setMrPk(String mrPk) {
		this.mrPk = mrPk;
	}
	public String getMrXmlData() {
		return mrXmlData;
	}
	public void setMrXmlData(String mrXmlData) {
		this.mrXmlData = mrXmlData;
	}
	
	public String getMrName() {
		return mrName;
	}
	public void setMrName(String mrName) {
		this.mrName = mrName;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getMrSatusCode() {
		return mrSatusCode;
	}
	public void setMrSatusCode(String mrSatusCode) {
		this.mrSatusCode = mrSatusCode;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getLastModifyDateTime() {
		return lastModifyDateTime;
	}
	public void setLastModifyDateTime(String lastModifyDateTime) {
		this.lastModifyDateTime = lastModifyDateTime;
	}
	
	
}
