package pkuhit.iih.iemr.qa;

import pkuhit.iih.en.EncounterModel;
import xap.model.BaseBizModel;
/**
 * 
 * @author cheng_feng
 *
 */
public class CusQaPatient extends BaseBizModel {

	public CusQaPatient() {

		super();

	}

	public CusQaPatient(String code) {

		super(code);

	}

	private EncounterModel encounterModel;
	private CusAmr cusAmr;
	
	public EncounterModel getEncounterModel() {
		return encounterModel;
	}

	public void setEncounterModel(EncounterModel encounterModel) {
		this.encounterModel = encounterModel;
	}

	public CusAmr getCusAmr() {
		return cusAmr;
	}

	public void setCusAmr(CusAmr cusAmr) {
		this.cusAmr = cusAmr;
	}

}