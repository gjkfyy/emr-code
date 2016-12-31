package pkuhit.iih.qa.qacustom.bizmodel;

import xap.model.BaseBizModel;
import xap.sv.model.ArrayResult;

import java.util.List;

import pkuhit.iih.qa.QaFault;

public class CusQaFault extends BaseBizModel {

	public CusQaFault() {

		super();

	}

	public CusQaFault(String code) {

		super(code);

	}

	private String currentQaPk;
	
	private String revisionCd;
	
	/*是否质控完成*/
	private String btnFlag;
	
	public String getBtnFlag() {
		return btnFlag;
	}

	public void setBtnFlag(String btnFlag) {
		this.btnFlag = btnFlag;
	}

	private ArrayResult<QaFault> qaFaultList;

	public String getCurrentQaPk() {
		return currentQaPk;
	}

	public void setCurrentQaPk(String currentQaPk) {
		this.currentQaPk = currentQaPk;
	}
	
	

	public String getRevisionCd() {
		return revisionCd;
	}

	public void setRevisionCd(String revisionCd) {
		this.revisionCd = revisionCd;
	}

	public ArrayResult<QaFault> getQaFaultList() {
		return qaFaultList;
	}

	public void setQaFaultList(ArrayResult<QaFault> qaFaultList) {
		this.qaFaultList = qaFaultList;
	}
	

}