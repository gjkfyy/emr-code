package pkuhit.iih.iemr.mr;
/**
 * 病历模板类型bean
 * */
public class MrTemplateTypeModel {
	private String mrTypeCode; //模板类型编码
	private String mrTypeName;//模板类型名称
	private String mrTypeNameWithCount;//模板类型名称（下面模板个数）
	private int tplCountOfMrType ;//模板个数
	private Boolean canDisplay;//是否显示
	public MrTemplateTypeModel(){
		
	}
	public MrTemplateTypeModel(String mrTypeCode,String mrTypeName){
		this.mrTypeCode = mrTypeCode;
		this.mrTypeName = mrTypeName;
		this.mrTypeNameWithCount = mrTypeName;
		this.tplCountOfMrType = 0;
		this.canDisplay = true ;
	}
	public String getMrTypeCode() {
		return mrTypeCode;
	}
	public void setMrTypeCode(String mrTypeCode) {
		this.mrTypeCode = mrTypeCode;
	}
	public String getMrTypeName() {
		return mrTypeName;
	}
	public void setMrTypeName(String mrTypeName) {
		this.mrTypeName = mrTypeName;
	}
	public String getMrTypeNameWithCount() {
		return mrTypeNameWithCount;
	}
	public void setMrTypeNameWithCount(String mrTypeNameWithCount) {
		this.mrTypeNameWithCount = mrTypeNameWithCount;
	}
	public int getTplCountOfMrType() {
		return tplCountOfMrType;
	}
	public void setTplCountOfMrType(int tplCountOfMrType) {
		this.tplCountOfMrType = tplCountOfMrType;
	}
	public Boolean getCanDisplay() {
		return canDisplay;
	}
	public void setCanDisplay(Boolean canDisplay) {
		this.canDisplay = canDisplay;
	}
	
}
