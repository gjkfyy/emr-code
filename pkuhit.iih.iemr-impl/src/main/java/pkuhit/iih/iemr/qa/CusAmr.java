package pkuhit.iih.iemr.qa;

import java.math.BigDecimal;
import java.util.Date;

import pkuhit.iih.mr.wr.Amr;

public class CusAmr extends Amr {
	
	private  BigDecimal faultTotal;
	private  BigDecimal faultTodoReform;
	private  BigDecimal faultTodoReview;
	private Date executeEndTime;
	private String executeDeptName;
	private String excuteUserName;
	
	public BigDecimal getFaultTotal() {
		return faultTotal;
	}
	public void setFaultTotal(BigDecimal faultTotal) {
		this.faultTotal = faultTotal;
	}
	public BigDecimal getFaultTodoReform() {
		return faultTodoReform;
	}
	public void setFaultTodoReform(BigDecimal faultTodoReform) {
		this.faultTodoReform = faultTodoReform;
	}
	public BigDecimal getFaultTodoReview() {
		return faultTodoReview;
	}
	public void setFaultTodoReview(BigDecimal faultTodoReview) {
		this.faultTodoReview = faultTodoReview;
	}
	public Date getExecuteEndTime() {
		return executeEndTime;
	}
	public void setExecuteEndTime(Date executeEndTime) {
		this.executeEndTime = executeEndTime;
	}
	public String getExecuteDeptName() {
		return executeDeptName;
	}
	public void setExecuteDeptName(String executeDeptName) {
		this.executeDeptName = executeDeptName;
	}
	public String getExcuteUserName() {
		return excuteUserName;
	}
	public void setExcuteUserName(String excuteUserName) {
		this.excuteUserName = excuteUserName;
	}
	 
}
