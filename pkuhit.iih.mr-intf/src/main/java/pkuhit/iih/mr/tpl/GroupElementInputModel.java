package pkuhit.iih.mr.tpl;

public class GroupElementInputModel {
	// 医疗记录组合元素编码
	private  String code;
	// 文件主键
	private  String filePk;
	// 医疗记录组合元素类型编码
	private  String typeCode;
	// 名称
	private  String name;
	// 描述
	private  String description;
	// 所属类型编码
	private  String ownerTypeCode;
	// 医疗记录组合元素的自定义分类编码
	private  String customCategoryCode;
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
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
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
	public String getCustomCategoryCode() {
		return customCategoryCode;
	}
	public void setCustomCategoryCode(String customCategoryCode) {
		this.customCategoryCode = customCategoryCode;
	}
	public String getOdtFile() {
		return odtFile;
	}
	public void setOdtFile(String odtFile) {
		this.odtFile = odtFile;
	}
	
}
