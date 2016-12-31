/**
 * 
 */
package iih.kr.model;

import java.util.Date;

/**
 * @author guo_zhongbao
 * 诊断关联病历模板列表，只包含病历模板code，顺序
 */
public class RelMrTemplateModel {
	   private String mrTemplateCode ;//病历模板编码
	   private String mrTemplateName ;//病历模板编码
	   private String ownerType ;//所属类型
	   private String ownerCode ;//所属编码
	   private Date creatTime ;//创建时间
	   private String creatId ;//创建人
	   private String creatName ;//创建人
	   private String ownerTypeName ;//所属类型名称
	   private String ownerName;//所属编码对应的名称
	   private Short sortNo ;//顺序
	   public RelMrTemplateModel(String mrTemplateCode,String mrTemplateName,String ownerType,String ownerCode,String creatId,Short sortNo,Date creatTime,String ownerName,String creatName){
		   this.mrTemplateCode = mrTemplateCode ;
		   this.mrTemplateName = mrTemplateName ;
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
		   this.creatId = creatId ;
		   this.creatName =creatName ;
	   }
	public String getMrTemplateCode() {
		return mrTemplateCode;
	}
	public void setMrTemplateCode(String mrTemplateCode) {
		this.mrTemplateCode = mrTemplateCode;
	}
	public Short getSortNo() {
		return sortNo;
	}
	public void setSortNo(Short sortNo) {
		this.sortNo = sortNo;
	}
	public String getMrTemplateName() {
		return mrTemplateName;
	}
	public void setMrTemplateName(String mrTemplateName) {
		this.mrTemplateName = mrTemplateName;
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
	public String getCreatName() {
		return creatName;
	}
	public void setCreatName(String creatName) {
		this.creatName = creatName;
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
	
}
