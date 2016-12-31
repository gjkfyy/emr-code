package pkuhit.iih.en.md;

import xap.model.BaseMasterModel;

public class EncounterType extends BaseMasterModel {

	public EncounterType() {

		super();

	}

	public EncounterType(String code) {

		super(code);

	}

	public static final String OBJ_CD = "ENM01";
	/**
	 * 门诊
	 */
	public static final String OUTPATIENT = "ENM01.01";

	/**
	 * 急诊
	 */
	public static final String EMERGENCY = "ENM01.02";
	/**
	 * 留观
	 */
	public static final String EMERGENCY_OBSERVATION = "ENM01.03";
	/**
	 * 住院
	 */
	public static final String INPATIENT = "ENM01.04";
	/**
	 * 体检
	 */
	public static final String PHYSICAL_EXAMINATION = "ENM01.05";
}