package pkuhit.iih.mr.tpl;


public class TemplateInputModel {
	
	private String code;//医疗记录模板编码
	private String mrTypeCode;//医疗记录类型编码
	private String name;//医疗记录名称
	private String description;//描述
	private String ownerTypeCode;//所属类型
	private String baseTemplateCode;//基础模板编码
	private String filePk;//文件主键
	private String xmlFilePk;//文件主键
	private String customerData;//文件主键
	private String diCds;//适用病种
	private String symptoms;//症状
	private String odtFile;//流文件
	private String xmlFile;//流文件
	private String paperTypeCode;//纸张类型
	private String ownDeptCd;//所属科室
	private String signLevel;//审签级别
	private String tplUseTypeCode;//适用类型，模板给谁用
	private String tplUseCode;//适用编码，当tplUseType为科室时，以','分隔
	private String enTypeCode ;//就诊类型
	private String statusCode ;//状态编码
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getEnTypeCode() {
		return enTypeCode;
	}
	public void setEnTypeCode(String enTypeCode) {
		this.enTypeCode = enTypeCode;
	}
	public String getMrTypeCode() {
		return mrTypeCode;
	}
	public void setMrTypeCode(String mrTypeCode) {
		this.mrTypeCode = mrTypeCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwnerTypeCode() {
		return ownerTypeCode;
	}
	public void setOwnerTypeCode(String ownerTypeCode) {
		this.ownerTypeCode = ownerTypeCode;
	}
	public String getBaseTemplateCode() {
		return baseTemplateCode;
	}
	public void setBaseTemplateCode(String baseTemplateCode) {
		this.baseTemplateCode = baseTemplateCode;
	}
	public String getFilePk() {
		return filePk;
	}
	public void setFilePk(String filePk) {
		this.filePk = filePk;
	}
	public String getDiCds() {
		return diCds;
	}
	public void setDiCds(String diCds) {
		this.diCds = diCds;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getOdtFile() {
		return odtFile;
	}
	public void setOdtFile(String odtFile) {
		this.odtFile = odtFile;
	}
	public String getPaperTypeCode() {
		return paperTypeCode;
	}
	public void setPaperTypeCode(String paperTypeCode) {
		this.paperTypeCode = paperTypeCode;
	}
	public String getOwnDeptCd() {
		return ownDeptCd;
	}
	public void setOwnDeptCd(String ownDeptCd) {
		this.ownDeptCd = ownDeptCd;
	}
	public String getSignLevel() {
		return signLevel;
	}
	public void setSignLevel(String signLevel) {
		this.signLevel = signLevel;
	}
	public String getTplUseTypeCode() {
		return tplUseTypeCode;
	}
	public void setTplUseTypeCode(String tplUseTypeCode) {
		this.tplUseTypeCode = tplUseTypeCode;
	}
	public String getTplUseCode() {
		return tplUseCode;
	}
	public void setTplUseCode(String tplUseCode) {
		this.tplUseCode = tplUseCode;
	}
	public String getXmlFile() {
		return xmlFile;
	}
	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
	public String getXmlFilePk() {
		return xmlFilePk;
	}
	public void setXmlFilePk(String xmlFilePk) {
		this.xmlFilePk = xmlFilePk;
	}
	public String getCustomerData() {
		return customerData;
	}
	public void setCustomerData(String customerData) {
		this.customerData = customerData;
	}
	
}
