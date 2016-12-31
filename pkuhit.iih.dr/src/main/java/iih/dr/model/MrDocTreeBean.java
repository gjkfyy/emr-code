package iih.dr.model;

/**
 * 病历文书内容树节点数据对象
 */
public class MrDocTreeBean {
	private String mrPk;//文档主键;
	
	private String docType;//文档类型编码
	
	private String nodeType;//节点类型 segment group element
	
	private String segmType;//段落类型
	
	private String segmName;//段落名称
	
	private String groupType;//组合元素类型
	
	private String groupName;//组合元素名称
	
	private String elemDisplayValue;//元素内容
	
	private String elemType;//元素类型
	
	private String elemName;//元素名称

//	private String parentName;//父节点
	
	private String elemPath;//路径path
	
	private int isLeaf;//是否叶子节点 0-否 1-是
	
	private String id;// 与text对应的id
	private String text ;//显示名称
	private Boolean leaf;//是否叶子节点
	private Boolean expanded;//是否展开
//	private String nodeType;//节点类型
//	private Boolean checked; //默认选中

	public String getMrPk() {
		return mrPk;
	}

	public void setMrPk(String mrPk) {
		this.mrPk = mrPk;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getSegmType() {
		return segmType;
	}

	public void setSegmType(String segmType) {
		this.segmType = segmType;
	}

	public String getSegmName() {
		return segmName;
	}

	public void setSegmName(String segmName) {
		this.segmName = segmName;
	}

	public String getElemDisplayValue() {
		return elemDisplayValue;
	}

	public void setElemDisplayValue(String elemDisplayValue) {
		this.elemDisplayValue = elemDisplayValue;
	}

	public String getElemType() {
		return elemType;
	}

	public void setElemType(String elemType) {
		this.elemType = elemType;
	}

	public String getElemName() {
		return elemName;
	}

	public void setElemName(String elemName) {
		this.elemName = elemName;
	}

	public String getElemPath() {
		return elemPath;
	}

	public void setElemPath(String elemPath) {
		this.elemPath = elemPath;
	}
	
	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setExpanded(Boolean expanded ) {
		this.expanded = expanded;
	}
	
}
