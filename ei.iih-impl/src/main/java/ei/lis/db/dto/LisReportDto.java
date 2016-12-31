package ei.lis.db.dto;

import org.seasar.doma.Column;



public class LisReportDto {

		private int rown;
		
		@Column(name = "RQS_TIME")
		private String applydate;

		private String sampletypename;
		
		@Column(name = "RQS_DCT_NM")
		private String applydoctor;
		
		@Column(name = "EXEC_DEPT_NM")
		private String labdept;

		private String reportername;

		@Column(name = "RLS_TIME")
		private String reportdate;

		private String sampletype;

		private int ordersn;

		@Column(name = "LAB_RP_NM")
		private String itemname;

		private String orgname;

		private String recallstatus;

		private String listype;

		@Column(name = "LAB_RP_PK")
		private String reportsn;

		private String statuscode;
		
		private String labdoctor;
		
		private String itemclassname;
		
		private String labdate;

		public void setRown(int rown){
		this.rown = rown;
		}
		public int getRown(){
		return this.rown;
		}
		public void setApplydate(String applydate){
		this.applydate = applydate;
		}
		public String getApplydate(){
		return this.applydate;
		}
		public void setSampletypename(String sampletypename){
		this.sampletypename = sampletypename;
		}
		public String getSampletypename(){
		return this.sampletypename;
		}
		public void setApplydoctor(String applydoctor){
		this.applydoctor = applydoctor;
		}
		public String getApplydoctor(){
		return this.applydoctor;
		}
		public void setLabdept(String labdept){
		this.labdept = labdept;
		}
		public String getLabdept(){
		return this.labdept;
		}
		public void setReportername(String reportername){
		this.reportername = reportername;
		}
		public String getReportername(){
		return this.reportername;
		}
		public void setReportdate(String reportdate){
		this.reportdate = reportdate;
		}
		public String getReportdate(){
		return this.reportdate;
		}
		public void setSampletype(String sampletype){
		this.sampletype = sampletype;
		}
		public String getSampletype(){
		return this.sampletype;
		}
		public void setOrdersn(int ordersn){
		this.ordersn = ordersn;
		}
		public int getOrdersn(){
		return this.ordersn;
		}
		public void setItemname(String itemname){
		this.itemname = itemname;
		}
		public String getItemname(){
		return this.itemname;
		}
		public void setOrgname(String orgname){
		this.orgname = orgname;
		}
		public String getOrgname(){
		return this.orgname;
		}
		public void setRecallstatus(String recallstatus){
		this.recallstatus = recallstatus;
		}
		public String getRecallstatus(){
		return this.recallstatus;
		}
		public void setListype(String listype){
		this.listype = listype;
		}
		public String getListype(){
		return this.listype;
		}
		public void setReportsn(String reportsn){
		this.reportsn = reportsn;
		}
		public String getReportsn(){
		return this.reportsn;
		}
		public void setStatuscode(String statuscode){
		this.statuscode = statuscode;
		}
		public String getStatuscode(){
		return this.statuscode;
		}
		public String getLabdoctor() {
			return labdoctor;
		}
		public void setLabdoctor(String labdoctor) {
			this.labdoctor = labdoctor;
		}
		public String getItemclassname() {
			return itemclassname;
		}
		public void setItemclassname(String itemclassname) {
			this.itemclassname = itemclassname;
		}
		public String getLabdate() {
			return labdate;
		}
		public void setLabdate(String labdate) {
			this.labdate = labdate;
		}

	
	
}
