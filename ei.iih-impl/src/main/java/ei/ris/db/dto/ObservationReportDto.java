package ei.ris.db.dto;

import org.seasar.doma.Column;



public class ObservationReportDto {
	
	private String reportdoctor;

	@Column(name = "RQS_TIME")
	private int rown;
	
	@Column(name = "EXEC_TIME")
	private String examdate;
	
	@Column(name = "RQS_TIME")
	private String applydate;
	
	@Column(name = "examResult")
	private String examresult;

	private String orderlid;
	
	@Column(name = "OB_RP_NO")
	private String reportlid;
	
	@Column(name = "RQS_DCT_NM")
	private String applydoctor;

	private String imageindexno;

	private String itemsn;

	private String itemclass;

	private String ordertype;
	
	@Column(name = "EXEC_DCT_NM")
	private String examdoctor;

	private String ordersn;

	private String examregion;

	private String exammethod;
	
	@Column(name = "OB_RP_NM")
	private String itemname;
	
	@Column(name = "OB_RP_STA_NM")
	private String orderstatusname;

	private int recallstatus;
	
	@Column(name = "EXEC_DEPT_NM")
	private String examdept;

	@Column(name = "OB_RP_PK")
	private String reportsn;

	private String datasource;
	
	@Column(name = "OB_ITM_NM")
	//检查项目名称同检查报告名称
	private String obitmnm;
	
	public void setReportdoctor(String reportdoctor){
	this.reportdoctor = reportdoctor;
	}
	public String getReportdoctor(){
	return this.reportdoctor;
	}
	public void setRown(int rown){
	this.rown = rown;
	}
	public int getRown(){
	return this.rown;
	}
	public void setExamdate(String examdate){
	this.examdate = examdate;
	}
	public String getExamdate(){
	return this.examdate;
	}
	public void setApplydate(String applydate){
	this.applydate = applydate;
	}
	public String getApplydate(){
	return this.applydate;
	}
	public void setExamresult(String examresult){
	this.examresult = examresult;
	}
	public String getExamresult(){
	return this.examresult;
	}
	public void setOrderlid(String orderlid){
	this.orderlid = orderlid;
	}
	public String getOrderlid(){
	return this.orderlid;
	}
	public void setReportlid(String reportlid){
	this.reportlid = reportlid;
	}
	public String getReportlid(){
	return this.reportlid;
	}
	public void setApplydoctor(String applydoctor){
	this.applydoctor = applydoctor;
	}
	public String getApplydoctor(){
	return this.applydoctor;
	}
	public void setImageindexno(String imageindexno){
	this.imageindexno = imageindexno;
	}
	public String getImageindexno(){
	return this.imageindexno;
	}
	public void setItemsn(String itemsn){
	this.itemsn = itemsn;
	}
	public String getItemsn(){
	return this.itemsn;
	}
	public void setItemclass(String itemclass){
	this.itemclass = itemclass;
	}
	public String getItemclass(){
	return this.itemclass;
	}
	public void setOrdertype(String ordertype){
	this.ordertype = ordertype;
	}
	public String getOrdertype(){
	return this.ordertype;
	}
	public void setExamdoctor(String examdoctor){
	this.examdoctor = examdoctor;
	}
	public String getExamdoctor(){
	return this.examdoctor;
	}
	public void setOrdersn(String ordersn){
	this.ordersn = ordersn;
	}
	public String getOrdersn(){
	return this.ordersn;
	}
	public void setExamregion(String examregion){
	this.examregion = examregion;
	}
	public String getExamregion(){
	return this.examregion;
	}
	public void setExammethod(String exammethod){
	this.exammethod = exammethod;
	}
	public String getExammethod(){
	return this.exammethod;
	}
	public void setItemname(String itemname){
	this.itemname = itemname;
	this.obitmnm = itemname;//平台不传 这个字段，需将itemname值传给obitmnm
	}
	public String getItemname(){
	return this.itemname;
	}
	public void setOrderstatusname(String orderstatusname){
	this.orderstatusname = orderstatusname;
	}
	public String getOrderstatusname(){
	return this.orderstatusname;
	}
	public void setRecallstatus(int recallstatus){
	this.recallstatus = recallstatus;
	}
	public int getRecallstatus(){
	return this.recallstatus;
	}
	public void setExamdept(String examdept){
	this.examdept = examdept;
	}
	public String getExamdept(){
	return this.examdept;
	}
	public void setReportsn(String reportsn){
	this.reportsn = reportsn;
	}
	public String getReportsn(){
	return this.reportsn;
	}
	public void setDatasource(String datasource){
	this.datasource = datasource;
	}
	public String getDatasource(){
	return this.datasource;
	}
	public String getObitmnm() {
		return obitmnm;
	}
	public void setObitmnm(String obitmnm) {
		//this.obitmnm = obitmnm;
	}
	
	
}
