package pkuhit.iih.mr.md;

import xap.sv.annotation.Column;

/**
 */
public class MetaElement{
	
	public MetaElement(){
		super();
	}

    /** */
    @Column(name = "DATA_ELEMENT_CD")
    private String dataElementCd;
    
    /** */
    @Column(name = "DATA_ELEMENT_NM")
    private String dataElementNm;
    
    
    @Column(name = "MEMO")
    private String memo;


    public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	/** 
     * Returns the dataElementCd.
     * 
     * @return the dataElementCd
     */
    public String getDataElementCd() {
        return dataElementCd;
    }

    /** 
     * Sets the dataElementCd.
     * 
     * @param dataElementCd the dataElementCd
     */
    public void setDataElementCd(String dataElementCd) {
        this.dataElementCd = dataElementCd;
    }
    
    /** 
     * Returns the dataElementNm.
     * 
     * @return the dataElementNm
     */
    public String getDataElementNm() {
        return dataElementNm;
    }

    /** 
     * Sets the dataElementNm.
     * 
     * @param dataElementNm the dataElementNm
     */
    public void setDataElementNm(String dataElementNm) {
        this.dataElementNm = dataElementNm;
    }

}