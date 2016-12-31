package pkuhit.iih.mr.tpl;

/**
 * 
 * <p>MrPrescriptionAndDisposeTemplate</p>
 * <p>门诊处方及处置相关小模板</p>
 */
public class MrPrescriptionAndDisposeTemplate {
    
    /**
     * 门诊处方小模板文件数据
     */
 	private  String prescriptionFile;
 	
    /**
     * 门诊处方占位小模板文件数据
     */
 	private  String prescriptionSignFile;
 	
 	/**
 	 * 门诊处方和处置占位小模板文件数据
 	 */
 	private  String prescriptionAndDisposeSignFile;
 	
    /**
     * 门诊处置占位小模板文件数据
     */
 	private  String disposeSignFile;

	public String getPrescriptionFile() {
		return prescriptionFile;
	}

	public void setPrescriptionFile(String prescriptionFile) {
		this.prescriptionFile = prescriptionFile;
	}

	public String getPrescriptionSignFile() {
		return prescriptionSignFile;
	}

	public void setPrescriptionSignFile(String prescriptionSignFile) {
		this.prescriptionSignFile = prescriptionSignFile;
	}

	public String getPrescriptionAndDisposeSignFile() {
		return prescriptionAndDisposeSignFile;
	}

	public void setPrescriptionAndDisposeSignFile(
			String prescriptionAndDisposeSignFile) {
		this.prescriptionAndDisposeSignFile = prescriptionAndDisposeSignFile;
	}

	public String getDisposeSignFile() {
		return disposeSignFile;
	}

	public void setDisposeSignFile(String disposeSignFile) {
		this.disposeSignFile = disposeSignFile;
	}

}