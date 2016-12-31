package iih.dr.model;

import xap.model.BaseBizModel;

public class AmrRetrievalModel extends BaseBizModel{

	public AmrRetrievalModel(){
		 super();
	}

	public AmrRetrievalModel(String code){
		 super(code);
	}
	
    private String enPk;
    
    private String mrPk;
    
    private String xmlStr;

	public String getEnPk() {
		return enPk;
	}

	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}

	public String getMrPk() {
		return mrPk;
	}

	public void setMrPk(String mrPk) {
		this.mrPk = mrPk;
	}

	public String getXmlStr() {
		return xmlStr;
	}

	public void setXmlStr(String xmlStr) {
		this.xmlStr = xmlStr;
	}
 	
}