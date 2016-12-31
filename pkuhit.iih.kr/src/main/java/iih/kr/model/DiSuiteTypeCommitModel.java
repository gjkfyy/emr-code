package iih.kr.model;

public class DiSuiteTypeCommitModel {
private String ownerType;//所属类型
private String ownerCode;//所属编码
private String enTypeCode;//就诊类型
private String[] diSuiteTypeNames;//自定义分类名称数组
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
public String[] getDiSuiteTypeNames() {
	return diSuiteTypeNames;
}
public void setDiSuiteTypeNames(String[] diSuiteTypeNames) {
	this.diSuiteTypeNames = diSuiteTypeNames;
}


}
