package iih.kr.model;

import java.util.Date;

/**
 * @author guo_zhongbao
 * 诊断关联的诊断model,只包括诊断编码和顺序
 */
public class RelDiModel {
	private String diTplKc;//关联主键
   private String diCode ;//诊断编码
   private String diName ;//诊断名称
   private String icdCode ;//icd编码
   private String ownerType ;//所属类型
   private String ownerCode ;//所属编码
   private int sortNo ;//顺序
   private Date creatTime ;//创建时间
   private String creatId ;//创建人
   private String creatName ;//创建人
   private String ownerTypeName ;//所属类型
   private String ownerName;//所属编码对应的名称
  public RelDiModel(String diTplKc ,String diCode,String diName,String icdCode,String ownerType,String ownerCode,String creatId,int sortNo,Date creatTime,String ownerName,String creatName){
	  this.diTplKc = diTplKc ;
	  this.creatId = creatId ;
	   this.diCode = diCode ;
	   this.diName = diName;
	   this.icdCode = icdCode ;
	   this.ownerType = ownerType ;
	   this.ownerCode = ownerCode ;
	   this.sortNo  = sortNo ;
	   this.creatTime = creatTime ;
	   if("BCM001.01".equalsIgnoreCase(ownerType) ){
		   ownerTypeName = "全院";
	   }else if("BCM001.02".equalsIgnoreCase(ownerType) ){
		   ownerTypeName = "科室";
	   }else if("BCM001.03".equalsIgnoreCase(ownerType) ){
		   ownerTypeName = "个人";
	   }
	   this.ownerName = ownerName;
	   this.creatName =creatName ;
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

public String getDiCode() {
	return diCode;
}
public void setDiCode(String diCode) {
	this.diCode = diCode;
}
public int getSortNo() {
	return sortNo;
}
public void setSortNo(int sortNo) {
	this.sortNo = sortNo;
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
public String getDiName() {
	return diName;
}
public void setDiName(String diName) {
	this.diName = diName;
}
public Date getCreatTime() {
	return creatTime;
}
public void setCreatTime(Date creatTime) {
	this.creatTime = creatTime;
}
public String getCreatId() {
	return creatId;
}
public void setCreatId(String creatId) {
	this.creatId = creatId;
}
public String getIcdCode() {
	return icdCode;
}
public void setIcdCode(String icdCode) {
	this.icdCode = icdCode;
}

public String getCreatName() {
	return creatName;
}

public void setCreatName(String creatName) {
	this.creatName = creatName;
}

public String getDiTplKc() {
	return diTplKc;
}

public void setDiTplKc(String diTplKc) {
	this.diTplKc = diTplKc;
}

}
