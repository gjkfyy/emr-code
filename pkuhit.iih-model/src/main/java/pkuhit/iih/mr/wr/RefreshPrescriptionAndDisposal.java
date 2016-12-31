/**
 * 
 */
package pkuhit.iih.mr.wr;

import java.util.List;

import pkuhit.iih.or.OrderModel;

/**
 * 刷新处方及处置所用的数据
 * 
 * @author li_chunxue
 * 
 */
public class RefreshPrescriptionAndDisposal {
	/**
	 * 西药处方
	 */
	private List<Prescription> prescriptions;
	/**
	 * 中成药处方
	 */
	private List<Prescription> cpmPrescriptions;
	/**
	 * 中医治疗处方
	 */
	private List<OrderModel> cZlPrescriptionsList;
	/**
	 * 草药协定处方
	 */
	private List<OrderModel> cmXdPrescriptionsList;
	/**
	 * 草药非协定处方
	 */
	private List<OrderModel> cmFxdPrescriptionsList;
	/**
	 * 处置
	 */
	private List<OrderModel> disposals;
	/**
	 * 中成药处方小模板文件
	 */
	private String cpmPrescriptionsTemplateFile;
	/**
	 * 非协定草药处方小模板文件
	 */
	private String cmFxdPrescriptionsTemplateFile;
	/**
	 * 中成药处方占位小模板文件
	 */
	private String cpmPrescriptionsSignTemplateFile;
	/**
	 * 处方小模板文件
	 */
	private String prescriptionsTemplateFile;
	/**
	 * 处方及处置占位小模板
	 */
	private String prescriptionsAndDisposalsTemplateFile;
	/**
	 * 处方占位小模板
	 */
	private String prescriptionsSignTemplateFile;
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public String getPrescriptionsTemplateFile() {
		return prescriptionsTemplateFile;
	}

	public void setPrescriptionsTemplateFile(String prescriptionsTemplateFile) {
		this.prescriptionsTemplateFile = prescriptionsTemplateFile;
	}
	public List<OrderModel> getDisposals() {
		return disposals;
	}
	public void setDisposals(List<OrderModel> disposals) {
		this.disposals = disposals;
	}
	public String getPrescriptionsAndDisposalsTemplateFile() {
		return prescriptionsAndDisposalsTemplateFile;
	}
	public void setPrescriptionsAndDisposalsTemplateFile(
			String prescriptionsAndDisposalsTemplateFile) {
		this.prescriptionsAndDisposalsTemplateFile = prescriptionsAndDisposalsTemplateFile;
	}
	public String getPrescriptionsSignTemplateFile() {
		return prescriptionsSignTemplateFile;
	}
	public void setPrescriptionsSignTemplateFile(String prescriptionsSignTemplateFile) {
		this.prescriptionsSignTemplateFile = prescriptionsSignTemplateFile;
	}
	public String getCpmPrescriptionsTemplateFile() {
		return cpmPrescriptionsTemplateFile;
	}
	public void setCpmPrescriptionsTemplateFile(String cpmPrescriptionsTemplateFile) {
		this.cpmPrescriptionsTemplateFile = cpmPrescriptionsTemplateFile;
	}
	public List<Prescription> getCpmPrescriptions() {
		return cpmPrescriptions;
	}
	public void setCpmPrescriptions(List<Prescription> cpmPrescriptions) {
		this.cpmPrescriptions = cpmPrescriptions;
	}
	public String getCpmPrescriptionsSignTemplateFile() {
		return cpmPrescriptionsSignTemplateFile;
	}
	public void setCpmPrescriptionsSignTemplateFile(String cpmPrescriptionsSignTemplateFile) {
		this.cpmPrescriptionsSignTemplateFile = cpmPrescriptionsSignTemplateFile;
	}
	public List<OrderModel> getcZlPrescriptionsList() {
		return cZlPrescriptionsList;
	}
	public void setcZlPrescriptionsList(List<OrderModel> cZlPrescriptionsList) {
		this.cZlPrescriptionsList = cZlPrescriptionsList;
	}
	public List<OrderModel> getCmXdPrescriptionsList() {
		return cmXdPrescriptionsList;
	}
	public void setCmXdPrescriptionsList(List<OrderModel> cmXdPrescriptionsList) {
		this.cmXdPrescriptionsList = cmXdPrescriptionsList;
	}
	public List<OrderModel> getCmFxdPrescriptionsList() {
		return cmFxdPrescriptionsList;
	}
	public void setCmFxdPrescriptionsList(List<OrderModel> cmFxdPrescriptionsList) {
		this.cmFxdPrescriptionsList = cmFxdPrescriptionsList;
	}
	public String getCmFxdPrescriptionsTemplateFile() {
		return cmFxdPrescriptionsTemplateFile;
	}
	public void setCmFxdPrescriptionsTemplateFile(String cmFxdPrescriptionsTemplateFile) {
		this.cmFxdPrescriptionsTemplateFile = cmFxdPrescriptionsTemplateFile;
	}
	
}
