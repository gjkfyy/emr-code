package pkuhit.iih.qa.qacustom.bizmodel;

import java.util.Date;

import pkuhit.iih.qa.QaFault;


public class CusCreateQaFault {

	private String enPk;
	
	private String qaTypeCode;
	
	private QaFault[] qaFaultArray;
	
	private int reformDeadline;
	
	private Date executeEndTime;
	
	private String reformedDescription;
	
	private String reformMemo;
	
	private boolean haveFault;
	
	private String currentDeptCode;//患者当前科室编码
	
	private String curMngDctId;//整改医生编码
	
	private String workScreen;
	
	private String revisionCd;

	private String patientName;
	
//	private List<QaFault> listValue;

	public String getEnPk() {
		return enPk;
	}

	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}

	public String getQaTypeCode() {
		return qaTypeCode;
	}

	public void setQaTypeCode(String qaTypeCode) {
		this.qaTypeCode = qaTypeCode;
	}

	public QaFault[] getQaFaultArray() {
		return qaFaultArray;
	}

	public void setQaFaultArray(QaFault[] qaFaultArray) {
		this.qaFaultArray = qaFaultArray;
	}

	public int getReformDeadline() {
		return reformDeadline;
	}

	public void setReformDeadline(int reformDeadline) {
		this.reformDeadline = reformDeadline;
	}

	public Date getExecuteEndTime() {
		return executeEndTime;
	}

	public void setExecuteEndTime(Date executeEndTime) {
		this.executeEndTime = executeEndTime;
	}

	public String getReformedDescription() {
		return reformedDescription;
	}

	public void setReformedDescription(String reformedDescription) {
		this.reformedDescription = reformedDescription;
	}

	public String getReformMemo() {
		return reformMemo;
	}

	public void setReformMemo(String reformMemo) {
		this.reformMemo = reformMemo;
	}

	public boolean getHaveFault() {
		return haveFault;
	}

	public void setHaveFault(boolean haveFault) {
		this.haveFault = haveFault;
	}

	public String getCurrentDeptCode() {
		return currentDeptCode;
	}

	public void setCurrentDeptCode(String currentDeptCode) {
		this.currentDeptCode = currentDeptCode;
	}

	public String getCurMngDctId() {
		return curMngDctId;
	}

	public void setCurMngDctId(String curMngDctId) {
		this.curMngDctId = curMngDctId;
	}

	public String getWorkScreen() {
		return workScreen;
	}

	public void setWorkScreen(String workScreen) {
		this.workScreen = workScreen;
	}

	public String getRevisionCd() {
		return revisionCd;
	}

	public void setRevisionCd(String revisionCd) {
		this.revisionCd = revisionCd;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	
//	public List<QaFault> getListValue() {
//		return listValue;
//	}
//
//	public void setListValue(List<QaFault> listValue) {
//		this.listValue = listValue;
//	}

}
