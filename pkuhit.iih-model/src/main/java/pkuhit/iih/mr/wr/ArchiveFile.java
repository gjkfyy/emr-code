package pkuhit.iih.mr.wr;


public class ArchiveFile  {


	private String mrPk;
	private String odtBase64;
	private String pdfBase64;
	private byte[] odtBuffer;
	private byte[] pdfBuffer;
	private String sysCode;//系统标示编码
	private String empSn;//归档护士Id
	private String enPk;//病人编号
	private String mrSatusCode;//病历状态编码
	private String patientId;//病人编号
	private String times;//就诊次数
	private String docType="住院";
	private String visitFlag;
	private String result;
	private Integer resultCount;
	private String nm;
	
	private String creatorName;  //创建者姓名
	private String createDateTime;//创建时间
	private String lastModifyDateTime;//最后修改时间
	private String signPaperDatetime;//经治医生签名的时间(显示在病历中的时间)
	private String createDisplayDateTime;//病程显示在病历上的创建时间
	private String fileFlag;//病历签名等级T－未签名 1－经治签名 2－上级签名 3－主任签名,	该字段值如果为T，则代表未完成
	private Integer nRate;//完成比率
	
	private String xmlFileData;//模板或者病历记录的xml内容 added by  guo_zhongbao 2016-08-29 for 山东鲁中医院 移动护理，获取xml内容
	
	public String getCreateDisplayDateTime() {
		return createDisplayDateTime;
	}
	public void setCreateDisplayDateTime(String createDisplayDateTime) {
		this.createDisplayDateTime = createDisplayDateTime;
	}
	public String getFileFlag() {
		return fileFlag;
	}
	public void setFileFlag(String fileFlag) {
		this.fileFlag = fileFlag;
	}
	public Integer getnRate() {
		return nRate;
	}
	public void setnRate(Integer nRate) {
		this.nRate = nRate;
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
	public String getSignPaperDatetime() {
		return signPaperDatetime;
	}
	public void setSignPaperDatetime(String signPaperDatetime) {
		this.signPaperDatetime = signPaperDatetime;
	}
	public String getMrSatusCode() {
		return mrSatusCode;
	}
	public void setMrSatusCode(String mrSatusCode) {
		this.mrSatusCode = mrSatusCode;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public Integer getResultCount() {
		return resultCount;
	}
	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSysCode() {
		return sysCode;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getEmpSn() {
		return empSn;
	}
	public void setEmpSn(String empSn) {
		this.empSn = empSn;
	}
	public String getEnPk() {
		return enPk;
	}
	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getVisitFlag() {
		return visitFlag;
	}
	public void setVisitFlag(String visitFlag) {
		this.visitFlag = visitFlag;
	}
	public String getMrPk() {
		return mrPk;
	}
	public void setMrPk(String mrPk) {
		this.mrPk = mrPk;
	}
	public String getOdtBase64() {
		return odtBase64;
	}
	public void setOdtBase64(String odtBase64) {
		this.odtBase64 = odtBase64;
	}
	public String getPdfBase64() {
		return pdfBase64;
	}
	public void setPdfBase64(String pdfBase64) {
		this.pdfBase64 = pdfBase64;
	}
	public byte[] getOdtBuffer() {
		return odtBuffer;
	}
	public void setOdtBuffer(byte[] odtBuffer) {
		this.odtBuffer = odtBuffer;
	}
	public byte[] getPdfBuffer() {
		return pdfBuffer;
	}
	public void setPdfBuffer(byte[] pdfBuffer) {
		this.pdfBuffer = pdfBuffer;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getXmlFileData() {
		return xmlFileData;
	}
	public void setXmlFileData(String xmlFileData) {
		this.xmlFileData = xmlFileData;
	}

}