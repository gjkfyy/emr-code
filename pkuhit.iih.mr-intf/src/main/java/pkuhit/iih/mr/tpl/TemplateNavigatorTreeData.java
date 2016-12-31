package pkuhit.iih.mr.tpl;


public class TemplateNavigatorTreeData {
	private String enTypeCode;//就诊类型
	private String hisOrgCode;//院区编码
	private String hisOrgName;//院区名称
	private String ownerTypeCode ;//所属类型编码
	private String ownerTypeName ;//所属类型编码
	private String ownerName ;//所属名称
	private String ownerCode;//所属编码  
	private String templateCategoryCode; //自定义分类编码
	private String templateCategoryName;//自定义分类名称
	private String templateTypeCode; //类型名称
	private String templateTypeName;//类型名称
	private String templateCode;//模板编码
	private String templateName;//模板名称
	private String signLevelCode; // 审签等级
	private String filePk;//模板对于的文件filePk
	private String id;// 与text对应的id
	private String text ;//显示名称
	private Boolean leaf;//是否显示
	private Boolean expanded;//是否展示
	private String nodeType;//节点类型
	private Boolean checked; //默认选中
	private String dctNsF; //默认选中
	private String keyWord;//搜索关键词
	private String scTemplateCategoryCode;//搜索特定的自定义分类
	private String scTemplateTypeCode;//搜索特定的自定义分类
	private String scStatusCode ;//搜索特定的状态编码
	
	public String getDctNsF() {
		return dctNsF;
	}
	public void setDctNsF(String dctNsF) {
		this.dctNsF = dctNsF;
	}

	public String getScStatusCode() {
		return scStatusCode;
	}
	public void setScStatusCode(String scStatusCode) {
		this.scStatusCode = scStatusCode;
	}
	public String getScTemplateCategoryCode() {
		return scTemplateCategoryCode;
	}
	public void setScTemplateCategoryCode(String scTemplateCategoryCode) {
		this.scTemplateCategoryCode = scTemplateCategoryCode;
	}
	public String getScTemplateTypeCode() {
		return scTemplateTypeCode;
	}
	public void setScTemplateTypeCode(String scTemplateTypeCode) {
		this.scTemplateTypeCode = scTemplateTypeCode;
	}
	public String getEnTypeCode() {
		return enTypeCode;
	}
	public void setEnTypeCode(String enTypeCode) {
		this.enTypeCode = enTypeCode;
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHisOrgCode() {
		return hisOrgCode;
	}
	public void setHisOrgCode(String hisOrgCode) {
		this.hisOrgCode = hisOrgCode;
	}
	public String getHisOrgName() {
		return hisOrgName;
	}
	public void setHisOrgName(String hisOrgName) {
		this.hisOrgName = hisOrgName;
	}
	public String getOwnerTypeCode() {
		return ownerTypeCode;
	}
	public void setOwnerTypeCode(String ownerTypeCode) {
		this.ownerTypeCode = ownerTypeCode;
	}
	public String getOwnerTypeName() {
		return ownerTypeName;
	}
	public void setOwnerTypeName(String ownerTypeName) {
		this.ownerTypeName = ownerTypeName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerCode() {
		return ownerCode;
	}
	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}
	public String getTemplateCategoryCode() {
		return templateCategoryCode;
	}
	public void setTemplateCategoryCode(String templateCategoryCode) {
		this.templateCategoryCode = templateCategoryCode;
	}
	public String getTemplateCategoryName() {
		return templateCategoryName;
	}
	public void setTemplateCategoryName(String templateCategoryName) {
		this.templateCategoryName = templateCategoryName;
	}
	public String getTemplateTypeCode() {
		return templateTypeCode;
	}
	public void setTemplateTypeCode(String templateTypeCode) {
		this.templateTypeCode = templateTypeCode;
	}
	public String getTemplateTypeName() {
		return templateTypeName;
	}
	public void setTemplateTypeName(String templateTypeName) {
		this.templateTypeName = templateTypeName;
	}
	
	public String getTemplateCode() {
		return templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getFilePk() {
		return filePk;
	}
	public void setFilePk(String filePk) {
		this.filePk = filePk;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getLeaf() {
		return leaf;
	}
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	public Boolean getExpanded() {
		return expanded;
	}
	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getSignLevelCode() {
		return signLevelCode;
	}
	public void setSignLevelCode(String signLevelCode) {
		this.signLevelCode = signLevelCode;
	}
	
	
	}
