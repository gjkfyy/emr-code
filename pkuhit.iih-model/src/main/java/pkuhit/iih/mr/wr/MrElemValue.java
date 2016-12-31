package pkuhit.iih.mr.wr;

import java.sql.Timestamp;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;

/**
 * 引用元素
 */
public class MrElemValue extends BaseBizModel{
	public MrElemValue() {

		super();

	}

	public MrElemValue(String code) {

		super(code);

	}

    /** */
    @Column(name = "ENCOUNTER_SN")
    String encounterSn;

    /** */
    @Column(name = "MR_DOC_SN")
    String mrDocSn;

    /** */
    @Column(name = "DATA_ELEMENT_ID")
    String dataElementId;

    /** */
    @Column(name = "VALUE")
    String value;

    /** */
    @Column(name = "MRB_MR_DOC_VALUE_ID")
    String mrbMrDocValueId;
    /** */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;


    
	public Timestamp getLastUpdTime() {
	
		return lastUpdTime;
	}

	
	public void setLastUpdTime(Timestamp lastUpdTime) {
	
		this.lastUpdTime = lastUpdTime;
	}

	/** 
     * Returns the encounterSn.
     * 
     * @return the encounterSn
     */
    public String getEncounterSn() {
        return encounterSn;
    }

    /** 
     * Sets the encounterSn.
     * 
     * @param encounterSn the encounterSn
     */
    public void setEncounterSn(String encounterSn) {
        this.encounterSn = encounterSn;
    }

    /** 
     * Returns the mrDocSn.
     * 
     * @return the mrDocSn
     */
    public String getMrDocSn() {
        return mrDocSn;
    }

    /** 
     * Sets the mrDocSn.
     * 
     * @param mrDocSn the mrDocSn
     */
    public void setMrDocSn(String mrDocSn) {
        this.mrDocSn = mrDocSn;
    }

    /** 
     * Returns the dataElementId.
     * 
     * @return the dataElementId
     */
    public String getDataElementId() {
        return dataElementId;
    }

    /** 
     * Sets the dataElementId.
     * 
     * @param dataElementId the dataElementId
     */
    public void setDataElementId(String dataElementId) {
        this.dataElementId = dataElementId;
    }

    /** 
     * Returns the value.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /** 
     * Sets the value.
     * 
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /** 
     * Returns the mrbMrDocValueId.
     * 
     * @return the mrbMrDocValueId
     */
    public String getMrbMrDocValueId() {
        return mrbMrDocValueId;
    }

    /** 
     * Sets the mrbMrDocValueId.
     * 
     * @param mrbMrDocValueId the mrbMrDocValueId
     */
    public void setMrbMrDocValueId(String mrbMrDocValueId) {
        this.mrbMrDocValueId = mrbMrDocValueId;
    }
}