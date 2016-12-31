package pkuhit.iih.mr.tpl;

public class BaseTemplateInputModel {
	// 医疗记录基础模板编码
	private  String code;

	// 文件主键
	private  String filePk;

	// 名称
	private  String name;

	// 描述
	private  String description;

	//模板状态
	private  String statusCode;
	
	// 纸张类型编码
	private  String paperTypeCode;
	
	// 文件数据
	private  String odtFile;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFilePk() {
		return filePk;
	}

	public void setFilePk(String filePk) {
		this.filePk = filePk;
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

	public String getPaperTypeCode() {
		return paperTypeCode;
	}

	public void setPaperTypeCode(String paperTypeCode) {
		this.paperTypeCode = paperTypeCode;
	}

	public String getOdtFile() {
		return odtFile;
	}

	public void setOdtFile(String odtFile) {
		this.odtFile = odtFile;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
