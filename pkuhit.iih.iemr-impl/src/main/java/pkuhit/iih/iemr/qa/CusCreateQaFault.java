package pkuhit.iih.iemr.qa;

import pkuhit.iih.qa.old.QaFault;

public class CusCreateQaFault {

	private String enPk;
	
	private String qaTypeCode;
	
	private QaFault[] qaFaultArray;

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

//	public List<QaFault> getListValue() {
//		return listValue;
//	}
//
//	public void setListValue(List<QaFault> listValue) {
//		this.listValue = listValue;
//	}

}
