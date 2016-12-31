/**
 * 
 */
package iih.kr.model;

import pkuhit.md.OwnerType;


/**
 * @author guo_zhongbao
 * 诊断关联病历模板列表，
 */
public class RelMrTemplateModelSimple {
	   private String mrTemplateCode ;//病历模板编码
	   private String mrTemplateName ;//病历模板名称
	   private String filePk ;//文件编码
	   private String mrTypeCode ;//病历类型编码
	   private String ownerType ;//所属类型
	   private String ownerCode ;//所属编码
	   private String ownerTypeName ;//所属类型名称
	   private String ownerName;//所属编码对应的名称
	   private Integer sortNo ;//顺序
	   private boolean checked;//是否选中
	   public RelMrTemplateModelSimple(String mrTemplateCode,String mrTemplateName,String filePk,String mrTypeCode,String ownerType,String ownerCode,Integer sortNo,String ownerName,boolean checked){
		   this.mrTemplateCode = mrTemplateCode ;
		   this.mrTemplateName = mrTemplateName ;
		   this.filePk=filePk;
		   this.mrTypeCode=mrTypeCode;
		   this.ownerType = ownerType ;
		   this.ownerCode = ownerCode ;
		   this.sortNo  = sortNo ;
		   if(OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(ownerType) ){
			   ownerTypeName = "全院";
		   }else if(OwnerType.DEPARTMENT.equalsIgnoreCase(ownerType) ){
			   ownerTypeName = "科室";
		   }else if(OwnerType.PERSONAL.equalsIgnoreCase(ownerType) ){
			   ownerTypeName = "个人";
		   }
		   this.ownerName = ownerName;
		   this.checked = checked;
	   }
	   
	   
	   
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getMrTemplateCode() {
		return mrTemplateCode;
	}
	public void setMrTemplateCode(String mrTemplateCode) {
		this.mrTemplateCode = mrTemplateCode;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
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
	public String getMrTypeCode() {
		return mrTypeCode;
	}
	public void setMrTypeCode(String mrTypeCode) {
		this.mrTypeCode = mrTypeCode;
	}
	public String getFilePk() {
		return filePk;
	}
	public void setFilePk(String filePk) {
		this.filePk = filePk;
	}
	
}
