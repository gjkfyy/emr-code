package iih.kr.model;

public class DiSuiteCommitModel {
private String ownerType;//所属类型
private String ownerCode;//所属编码
private String enTypeCode;//就诊类型
private String diSuiteTypeCode;//自定义分类编码
private String diSuiteCode ;//组套编码，所属类型 所属编码 的 自定义分类与诊断关系
private String diCode;//诊断编码
private String[] relDiList ;//关联诊断数组
private String[] relMrList ;//关联病历数组

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
public String getEnTypeCode() {
	return enTypeCode;
}
public void setEnTypeCode(String enTypeCode) {
	this.enTypeCode = enTypeCode;
}
public String getDiSuiteTypeCode() {
	return diSuiteTypeCode;
}
public void setDiSuiteTypeCode(String diSuiteTypeCode) {
	this.diSuiteTypeCode = diSuiteTypeCode;
}
public String getDiSuiteCode() {
	return diSuiteCode;
}
public void setDiSuiteCode(String diSuiteCode) {
	this.diSuiteCode = diSuiteCode;
}
public String[] getRelDiList() {
	return relDiList;
}
public void setRelDiList(String[] relDiList) {
	this.relDiList = relDiList;
}
public String[] getRelMrList() {
	return relMrList;
}
public void setRelMrList(String[] relMrList) {
	this.relMrList = relMrList;
}

}
