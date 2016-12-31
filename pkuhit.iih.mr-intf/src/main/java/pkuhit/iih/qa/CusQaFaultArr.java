package pkuhit.iih.qa;

import xap.model.BaseBizModel;
import xap.sv.model.ArrayResult;

import java.util.List;

import pkuhit.iih.qa.old.QaFault;

public class CusQaFaultArr extends BaseBizModel {

	public CusQaFaultArr() {

		super();

	}

	public CusQaFaultArr(String code) {

		super(code);

	}

	private List<QaFault> qaFaultList;

	public List<QaFault> getQaFaultList() {
		return qaFaultList;
	}

	public void setQaFaultList(List<QaFault> qaFaultList) {
		this.qaFaultList = qaFaultList;
	}

}