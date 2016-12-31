package iih.kr.model;

import java.util.List;

/**
 * @author guo_zhongbao
 * 医生用的组套，诊断节点，应该包括所属。--20150522 需求变更。科室使用其他科室共享的组套，查询参数应该为 共享源科室
 */
public class DiSuiteTreeNodeModel {
	private String diName;//诊断名称
	private String diCode;//诊断编码
	private String ownerType;//所属类型
	private String ownerCode;//所属编码
	private String orgCode;//组织类型
	private String diSuiteTypeCode;//自定义分类编码
	private String diSuiteTypeName;//自定义分类名称
	private String diSuiteCode ;//所属类型 所属编码 的 自定义分类与诊断关系
	private String id;
	private String text;
	private List<DiSuiteTreeNodeModel> children;
	
	public List<DiSuiteTreeNodeModel> getChildren() {
		return children;
	}
	public void setChildren(List<DiSuiteTreeNodeModel> children) {
		this.children = children;
	}
	public String getDiSuiteTypeName() {
		return diSuiteTypeName;
	}
	public void setDiSuiteTypeName(String diSuiteTypeName) {
		this.diSuiteTypeName = diSuiteTypeName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDiName() {
		return diName;
	}
	public void setDiName(String diName) {
		this.diName = diName;
	}
	public String getDiCode() {
		return diCode;
	}
	public void setDiCode(String diCode) {
		this.diCode = diCode;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public String getOwnerCode() {
		return ownerCode;
	}
	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getDiSuiteTypeCode() {
		return diSuiteTypeCode;
	}
	public void setDiSuiteTypeCode(String DiSuiteTypeCode) {
		this.diSuiteTypeCode = DiSuiteTypeCode;
	}
	public String getDiSuiteCode() {
		return diSuiteCode;
	}
	public void setDiSuiteCode(String diSuiteCode) {
		this.diSuiteCode = diSuiteCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
