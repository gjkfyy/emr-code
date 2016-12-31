/**
 * 
 */
package pkuhit.iih.mr.wr;

import java.util.List;

import pkuhit.iih.en.md.PatientModel;
import pkuhit.iih.nu.Vitalsign;

/**
 * 患者宏元素值
 * 
 * @author li_chunxue
 * 
 */
public class MacroElementValue {
	private PatientModel patient;
	private Amr amr;
	private Vitalsign vitalsign;
    private String allDiagnosis;
    private String emergencyMrNumber;
    private List<MrSplFmValue> mrSplFmValue;
    
    
	public List<MrSplFmValue> getMrSplFmValue() {
		return mrSplFmValue;
	}
	public void setMrSplFmValue(List<MrSplFmValue> mrSplFmValue) {
		this.mrSplFmValue = mrSplFmValue;
	}
	public String getAllDiagnosis() {
		return allDiagnosis;
	}
	public void setAllDiagnosis(String allDiagnosis) {
		this.allDiagnosis = allDiagnosis;
	}
	public String getEmergencyMrNumber() {
		return emergencyMrNumber;
	}
	public void setEmergencyMrNumber(String emergencyMrNumber) {
		this.emergencyMrNumber = emergencyMrNumber;
	}

	public Vitalsign getVitalsign() {

		return vitalsign;
	}

	public void setVitalsign(Vitalsign vitalsign) {

		this.vitalsign = vitalsign;
	}

	public PatientModel getPatient() {

		return patient;
	}

	public void setPatient(PatientModel patient) {

		this.patient = patient;
	}

	public Amr getAmr() {

		return amr;
	}

	public void setAmr(Amr amr) {

		this.amr = amr;
	}
}
