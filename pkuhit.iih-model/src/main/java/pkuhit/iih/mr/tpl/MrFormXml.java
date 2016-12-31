package pkuhit.iih.mr.tpl;

import java.util.List;
import java.util.Map;

import xap.model.BaseMasterModel;

public class MrFormXml extends BaseMasterModel {

	public MrFormXml() {
		super();
	}

	public MrFormXml(String code) {
		super(code);
	}
	
	public MrFormXml(List<Map<String, Object>> mrFormXml) {
		super();
		this.mrFormXml = mrFormXml;
	}

	private String xmlFile;
	private List<Map<String,Object>> mrFormXml;

	
	
	public String getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}

	public List<Map<String, Object>> getMrFormXml() {
		return mrFormXml;
	}

	public void setMrFormXml(List<Map<String, Object>> mrFormXml) {
		this.mrFormXml = mrFormXml;
	}

}