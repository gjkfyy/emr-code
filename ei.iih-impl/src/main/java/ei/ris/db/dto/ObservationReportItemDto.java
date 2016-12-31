package ei.ris.db.dto;

import org.seasar.doma.Column;



public class ObservationReportItemDto {

	private String reportdoctor;

	private String examdate;
	
	@Column(name = "OB_FNDG")
	private String imagingfindings;

	@Column(name = "ADV")
	private String remark;

	private String imageindexno;

	private String reagentdosage;

	private String examdoctor;

	private String reportdate;
	
	@Column(name = "RLS_TIME")
	private String verifydate;
	
	@Column(name = "RLS_USER_NM")
	private String verifydoctor;

	private String reagent;

	private String examdept;
	
	@Column(name = "OB_IMPR")
	private String imagingresult;

	private String reagentunit;
	
	

	public void setReportdoctor(String reportdoctor){
	this.reportdoctor = reportdoctor;
	}
	public String getReportdoctor(){
	return this.reportdoctor;
	}
	public void setExamdate(String examdate){
	this.examdate = examdate;
	}
	public String getExamdate(){
	return this.examdate;
	}
	public void setImagingfindings(String imagingfindings){
	this.imagingfindings = imagingfindings;
	}
	public String getImagingfindings(){
	return this.imagingfindings;
	}
	public void setRemark(String remark){
	this.remark = remark;
	}
	public String getRemark(){
	return this.remark;
	}
	public void setImageindexno(String imageindexno){
	this.imageindexno = imageindexno;
	}
	public String getImageindexno(){
	return this.imageindexno;
	}
	public void setReagentdosage(String reagentdosage){
	this.reagentdosage = reagentdosage;
	}
	public String getReagentdosage(){
	return this.reagentdosage;
	}
	public void setExamdoctor(String examdoctor){
	this.examdoctor = examdoctor;
	}
	public String getExamdoctor(){
	return this.examdoctor;
	}
	public void setReportdate(String reportdate){
	this.reportdate = reportdate;
	}
	public String getReportdate(){
	return this.reportdate;
	}
	public void setVerifydate(String verifydate){
	this.verifydate = verifydate;
	}
	public String getVerifydate(){
	return this.verifydate;
	}
	public void setVerifydoctor(String verifydoctor){
	this.verifydoctor = verifydoctor;
	}
	public String getVerifydoctor(){
	return this.verifydoctor;
	}
	public void setReagent(String reagent){
	this.reagent = reagent;
	}
	public String getReagent(){
	return this.reagent;
	}
	public void setExamdept(String examdept){
	this.examdept = examdept;
	}
	public String getExamdept(){
	return this.examdept;
	}
	public void setImagingresult(String imagingresult){
	this.imagingresult = imagingresult;
	}
	public String getImagingresult(){
	return this.imagingresult;
	}
	public void setReagentunit(String reagentunit){
	this.reagentunit = reagentunit;
	}
	public String getReagentunit(){
	return this.reagentunit;
	}
	
}
