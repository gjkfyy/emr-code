package iih.kr.model;

import java.util.Date;

/**
 * @author guo_zhongbao
 * 诊断关联的诊断model,只包括诊断编码和顺序
 */
public class RelDiModelSimple {
	private String diSuiteDiCode;//关联主键
   private String diCode ;//诊断编码
   private String diName ;//诊断名称
   private String icdCode ;//icd编码
   private Integer sortNo ;//顺序
   
   private String ownerType ;//所属类型
   private String ownerCode ;//所属编码
  public RelDiModelSimple(String diSuiteDiCode ,String diCode,String diName,String icdCode,Integer sortNo){
	  this.diSuiteDiCode = diSuiteDiCode ;
	   this.diCode = diCode ;
	   this.diName = diName;
	   this.icdCode = icdCode ;
	   this.sortNo  = sortNo ;
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

public String getDiCode() {
	return diCode;
}
public void setDiCode(String diCode) {
	this.diCode = diCode;
}
public Integer getSortNo() {
	return sortNo;
}
public void setSortNo(Integer sortNo) {
	this.sortNo = sortNo;
}
public String getDiName() {
	return diName;
}
public void setDiName(String diName) {
	this.diName = diName;
}
public String getIcdCode() {
	return icdCode;
}
public void setIcdCode(String icdCode) {
	this.icdCode = icdCode;
}

public String getDiSuiteDiCode() {
	return diSuiteDiCode;
}

public void setDiSuiteDiCode(String diSuiteDiCode) {
	this.diSuiteDiCode = diSuiteDiCode;
}



}
