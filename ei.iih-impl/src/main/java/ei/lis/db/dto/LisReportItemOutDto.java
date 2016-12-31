package ei.lis.db.dto;

import java.util.List;

import org.seasar.doma.Column;



public class LisReportItemOutDto {

		private LisReportItemDto[] subItem ;

		private String sampletypename;

		private String labdept;

		private String diagnosis;

		private String lisaim;

		private String labward;

		private String reportdate;

		private String reportmemo;

		private String composite_item_sn;

		private String item_code;

		private String itemname;

		private String labbed;

		@Column(name = "LAB_RP_NO")
		private String reportno;

		private String technicalnote;

		@Column(name = "EXEC_DCT_TIME")
		private String auditname;

		private String reviewername;

		private String reporttypename;

		@Column(name = "EXEC_TIME")
		private String receivetime;

		private String samplingtime;

		private String senddoctor;

		private String auditdate;

		private String requesttime;

		private String reporttypecode;

		private String testername;

		private String sampleno;

		private String reviewerdate;

		private String applydoctorname;
		
		private String result;
		
		private String appearance;

		
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public String getAppearance() {
			return appearance;
		}
		public void setAppearance(String appearance) {
			this.appearance = appearance;
		}
		public void setSampletypename(String sampletypename){
		this.sampletypename = sampletypename;
		}
		public String getSampletypename(){
		return this.sampletypename;
		}
		public void setLabdept(String labdept){
		this.labdept = labdept;
		}
		public String getLabdept(){
		return this.labdept;
		}
		public void setDiagnosis(String diagnosis){
		this.diagnosis = diagnosis;
		}
		public String getDiagnosis(){
		return this.diagnosis;
		}
		public void setLisaim(String lisaim){
		this.lisaim = lisaim;
		}
		public String getLisaim(){
		return this.lisaim;
		}
		public void setLabward(String labward){
		this.labward = labward;
		}
		public String getLabward(){
		return this.labward;
		}
		public void setReportdate(String reportdate){
		this.reportdate = reportdate;
		}
		public String getReportdate(){
		return this.reportdate;
		}
		public void setReportmemo(String reportmemo){
		this.reportmemo = reportmemo;
		}
		public String getReportmemo(){
		return this.reportmemo;
		}

		public String getComposite_item_sn() {
			return composite_item_sn;
		}
		public void setComposite_item_sn(String composite_item_sn) {
			this.composite_item_sn = composite_item_sn;
		}
		public void setItem_code(String item_code){
		this.item_code = item_code;
		}
		public String getItem_code(){
		return this.item_code;
		}
		public void setItemname(String itemname){
		this.itemname = itemname;
		}
		public String getItemname(){
		return this.itemname;
		}
		public void setLabbed(String labbed){
		this.labbed = labbed;
		}
		public String getLabbed(){
		return this.labbed;
		}
		public void setReportno(String reportno){
		this.reportno = reportno;
		}
		public String getReportno(){
		return this.reportno;
		}
		public void setTechnicalnote(String technicalnote){
		this.technicalnote = technicalnote;
		}
		public String getTechnicalnote(){
		return this.technicalnote;
		}
		public void setAuditname(String auditname){
		this.auditname = auditname;
		}
		public String getAuditname(){
		return this.auditname;
		}
		public void setReviewername(String reviewername){
		this.reviewername = reviewername;
		}
		public String getReviewername(){
		return this.reviewername;
		}
		public void setReporttypename(String reporttypename){
		this.reporttypename = reporttypename;
		}
		public String getReporttypename(){
		return this.reporttypename;
		}
		public void setReceivetime(String receivetime){
		this.receivetime = receivetime;
		}
		public String getReceivetime(){
		return this.receivetime;
		}
		public void setSamplingtime(String samplingtime){
		this.samplingtime = samplingtime;
		}
		public String getSamplingtime(){
		return this.samplingtime;
		}
		public void setSenddoctor(String senddoctor){
		this.senddoctor = senddoctor;
		}
		public String getSenddoctor(){
		return this.senddoctor;
		}
		public void setAuditdate(String auditdate){
		this.auditdate = auditdate;
		}
		public String getAuditdate(){
		return this.auditdate;
		}
		public void setRequesttime(String requesttime){
		this.requesttime = requesttime;
		}
		public String getRequesttime(){
		return this.requesttime;
		}
		public void setReporttypecode(String reporttypecode){
		this.reporttypecode = reporttypecode;
		}
		public String getReporttypecode(){
		return this.reporttypecode;
		}
		public void setTestername(String testername){
		this.testername = testername;
		}
		public String getTestername(){
		return this.testername;
		}
		public void setSampleno(String sampleno){
		this.sampleno = sampleno;
		}
		public String getSampleno(){
		return this.sampleno;
		}
		public void setReviewerdate(String reviewerdate){
		this.reviewerdate = reviewerdate;
		}
		public String getReviewerdate(){
		return this.reviewerdate;
		}
		public void setApplydoctorname(String applydoctorname){
		this.applydoctorname = applydoctorname;
		}
		public String getApplydoctorname(){
		return this.applydoctorname;
		}
		public LisReportItemDto[] getSubItem() {
			return subItem;
		}
		public void setSubItem(LisReportItemDto[] subItem) {
			this.subItem = subItem;
		}

	
}
