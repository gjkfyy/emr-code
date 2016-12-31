package pkuhit.iih.mr.tpl;
/**
 *  导航树应用于基础模板、组合元素、 病历模板
 * */
public class BaseTemplateTreeModel {
	private String id; //id主键
	private String 	code	;//	医疗记录基础模板编码
	private String 	filePk	;//	文件主键
	private String 	text	;//	名称
	private String 	statusCode	;//	基础模板状态
	private String 	nameWithStatus	;//	名称带状态
	private boolean leaf;//是否是叶节点
	private boolean expanded;//是否展开
	public String getCode() {
		return code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getNameWithStatus() {
		return nameWithStatus;
	}
	public void setNameWithStatus(String nameWithStatus) {
		this.nameWithStatus = nameWithStatus;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

}
