package pkuhit.iih.iemr.qa;

import pkuhit.iih.qa.old.QaFault;
import xap.model.BaseBizModel;
import xap.sv.model.ArrayResult;

public class CusQaFault extends BaseBizModel {

	public CusQaFault() {

		super();

	}

	public CusQaFault(String code) {

		super(code);

	}

	private String currentQaPk;
	private ArrayResult<QaFault> qaFaultList;

	public String getCurrentQaPk() {
		return currentQaPk;
	}

	public void setCurrentQaPk(String currentQaPk) {
		this.currentQaPk = currentQaPk;
	}

	public ArrayResult<QaFault> getQaFaultList() {
		return qaFaultList;
	}

	public void setQaFaultList(ArrayResult<QaFault> qaFaultList) {
		this.qaFaultList = qaFaultList;
	}

}