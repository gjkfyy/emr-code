package iih.dr.model;

import java.sql.Clob;

/**
 * 病历模板对象
 */
public class BaseTemplateModel {
	
	private String nm;
	
	private String mrTplCd;
	
	private String xmlFilePk;
	
	private Clob fileData;

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getMrTplCd() {
		return mrTplCd;
	}

	public void setMrTplCd(String mrTplCd) {
		this.mrTplCd = mrTplCd;
	}

	public String getXmlFilePk() {
		return xmlFilePk;
	}

	public void setXmlFilePk(String xmlFilePk) {
		this.xmlFilePk = xmlFilePk;
	}

	public Clob getFileData() {
		return fileData;
	}

	public void setFileData(Clob fileData) {
		this.fileData = fileData;
	}
	
}
