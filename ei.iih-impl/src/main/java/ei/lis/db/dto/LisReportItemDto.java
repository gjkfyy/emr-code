package ei.lis.db.dto;

import java.util.List;

import org.seasar.doma.Column;



public class LisReportItemDto {

	//labItmCompare
	@Column(name = "LAB_ITM_COMPARE")
	private String normalflagname;
	
	@Column(name = "LAB_ITM_CD")
	private String subitemcode;

	private String warnhighvalue;

	@Column(name = "MEMO")
	private String memo;

	//返回数值类型结果
	private String numresult;
	
	@Column(name = "LAB_ITM_VAL")
	private String labitmval;//numresult;


	@Column(name = "LAB_ITM_NM")
	private String subitemname;

	
	private String warnlowvalue;
	
	@Column(name = "LAB_ITM_UNIT_NM")
	private String unit;


	private String item_code;

	private String referencemax;

	private String referencemin;
	
	//@Column(name = "MR_LAB_RP_ITM_PK")
	private String lab_result_composite_item_sn;
	
	//@Column(name = "LAB_ITM_VAL")
	//文本类结果
	private String textresult;
	
	private List micro ;
	
	private String referencetext;
	
	@Column(name = "REFERENCE_RANGE")
	private String referenceRange;

	public void setReferencetext(String referencetext){
		if(this.referencetext != null && !this.referencetext.equals("")){
			this.referenceRange = referencetext;
		}
		this.referencetext = referencetext;
	}
	public String getReferencetext(){
	return this.referencetext;
	}
	public void setNormalflagname(String normalflagname){
	this.normalflagname = normalflagname;
	}
	public String getNormalflagname(){
	return this.normalflagname;
	}
	public void setSubitemcode(String subitemcode){
	this.subitemcode = subitemcode;
	}
	public String getSubitemcode(){
	return this.subitemcode;
	}
	public void setWarnhighvalue(String warnhighvalue){
	this.warnhighvalue = warnhighvalue;
	}
	public String getWarnhighvalue(){
	return this.warnhighvalue;
	}
	public void setMemo(String memo){
	this.memo = memo;
	}
	public String getMemo(){
	return this.memo;
	}
	public void setNumresult(String numresult){
		if(numresult != null ){
			System.out.println("numresult==="+numresult);
			this.labitmval = numresult;
		}
		this.numresult = numresult;
	}
	public String getNumresult(){
	return this.numresult;
	}
	public void setSubitemname(String subitemname){
	this.subitemname = subitemname;
	}
	public String getSubitemname(){
	return this.subitemname;
	}
	public void setWarnlowvalue(String warnlowvalue){
	this.warnlowvalue = warnlowvalue;
	}
	public String getWarnlowvalue(){
	return this.warnlowvalue;
	}
	public void setUnit(String unit){
	this.unit = unit;
	}
	public String getUnit(){
	return this.unit;
	}
	public void setItem_code(String item_code){
	this.item_code = item_code;
	}
	public String getItem_code(){
	return this.item_code;
	}
	public void setReferencemax(String referencemax){
		if(referencemax != null && referencemax != null){
			this.referenceRange = referenceRange != null ? referenceRange +"-"+referencemax:referencemax;
		}
		this.referencemax = referencemax;
	}
	public String getReferencemax(){
	return this.referencemax;
	}
	public void setReferencemin(String referencemin){
		if(referencemin != null && referencemax != null){
			this.referenceRange = referenceRange != null? referencemin+"-"+referenceRange:referencemin;
		}
		this.referencemin = referencemin;
	}
	public String getReferencemin(){
	return this.referencemin;
	}
	
	public String getLab_result_composite_item_sn() {
		return lab_result_composite_item_sn;
	}
	public void setLab_result_composite_item_sn(String lab_result_composite_item_sn) {
		this.lab_result_composite_item_sn = lab_result_composite_item_sn;
	}
	public void setTextresult(String textresult){
		if(textresult != null ){
			System.out.println("textresult==="+textresult);
			this.labitmval = textresult;
		}
		this.textresult = textresult;
	}
	public String getTextresult(){
	return this.textresult;
	}
	public List getMicro() {
		return micro;
	}
	public void setMicro(List micro) {
		this.micro = micro;
	}
	
	public String getReferenceRange() {
		return referenceRange;
	}
	public void setReferenceRange(String referenceRange) {
		/*if(this.referencetext != null && !this.referencetext.equals("")){
			this.referenceRange = referencetext;
		}else if(this.referencemin != null && this.referencemax != null){
			this.referenceRange = referencemin+"-"+referencemax;
		}else{
			this.referenceRange = referenceRange;
		}*/
	}
	public String getLabitmval() {
		return labitmval;
	}
	public void setLabitmval(String labitmval) {
		
	}
	
}
