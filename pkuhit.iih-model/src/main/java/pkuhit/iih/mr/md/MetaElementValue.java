package pkuhit.iih.mr.md;

import java.math.BigInteger;
import java.sql.Timestamp;
import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;

public class MetaElementValue extends BaseMasterModel {

	public MetaElementValue(){
		super();
	}

	public MetaElementValue(String code){
		 super(code);
	}
		 
    @Column(name = "DATA_ELEMENT_VALUE_CD")
    private String dataElementValueCd;

    @Column(name = "DATA_ELEMENT_CD")
    private String dataElementCd;

    @Column(name = "VALUE_CODE")
    private String valueCode;

    @Column(name = "VALUE_DISPLAY")
    private String valueDisplay;

    @Column(name = "MEMO")
    private String memo;

    @Column(name = "SORT_NO")
    private String sortNo;

    @Column(name = "SPELL_NO")
    private String spellNo;

    @Column(name = "WUBI_NO")
    private String wubiNo;

    @Column(name = "UPD_CNT")
    private BigInteger updCnt;

    @Column(name = "CRT_TIME")
    private Timestamp crtTime;

    @Column(name = "CRT_USER_ID")
    private String crtUserId;

    @Column(name = "CRT_DEPT_CD")
    private String crtDeptCd;

    @Column(name = "LAST_UPD_TIME")
    private Timestamp lastUpdTime;

    @Column(name = "LAST_UPD_DEPT_CD")
    private String lastUpdDeptCd;

    @Column(name = "LAST_UPD_USER_ID")
    private String lastUpdUserId;

    @Column(name = "DEL_F")
    private Short delF;

    /** 
     * Returns the dataElementValueCd.
     * 
     * @return the dataElementValueCd
     */
    public String getDataElementValueCd() {
        return dataElementValueCd;
    }

    /** 
     * Sets the dataElementValueCd.
     * 
     * @param dataElementValueCd the dataElementValueCd
     */
    public void setDataElementValueCd(String dataElementValueCd) {
        this.dataElementValueCd = dataElementValueCd;
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
     * Returns the valueCode.
     * 
     * @return the valueCode
     */
    public String getValueCode() {
        return valueCode;
    }

    /** 
     * Sets the valueCode.
     * 
     * @param valueCode the valueCode
     */
    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    /** 
     * Returns the valueDisplay.
     * 
     * @return the valueDisplay
     */
    public String getValueDisplay() {
        return valueDisplay;
    }

    /** 
     * Sets the valueDisplay.
     * 
     * @param valueDisplay the valueDisplay
     */
    public void setValueDisplay(String valueDisplay) {
        this.valueDisplay = valueDisplay;
    }

    /** 
     * Returns the memo.
     * 
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /** 
     * Sets the memo.
     * 
     * @param memo the memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /** 
     * Returns the sortNo.
     * 
     * @return the sortNo
     */
    public String getSortNo() {
        return sortNo;
    }

    /** 
     * Sets the sortNo.
     * 
     * @param sortNo the sortNo
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    /** 
     * Returns the spellNo.
     * 
     * @return the spellNo
     */
    public String getSpellNo() {
        return spellNo;
    }

    /** 
     * Sets the spellNo.
     * 
     * @param spellNo the spellNo
     */
    public void setSpellNo(String spellNo) {
        this.spellNo = spellNo;
    }

    /** 
     * Returns the wubiNo.
     * 
     * @return the wubiNo
     */
    public String getWubiNo() {
        return wubiNo;
    }

    /** 
     * Sets the wubiNo.
     * 
     * @param wubiNo the wubiNo
     */
    public void setWubiNo(String wubiNo) {
        this.wubiNo = wubiNo;
    }

    /** 
     * Returns the updCnt.
     * 
     * @return the updCnt
     */
    public BigInteger getUpdCnt() {
        return updCnt;
    }

    /** 
     * Sets the updCnt.
     * 
     * @param updCnt the updCnt
     */
    public void setUpdCnt(BigInteger updCnt) {
        this.updCnt = updCnt;
    }

    /** 
     * Returns the crtTime.
     * 
     * @return the crtTime
     */
    public Timestamp getCrtTime() {
        return crtTime;
    }

    /** 
     * Sets the crtTime.
     * 
     * @param crtTime the crtTime
     */
    public void setCrtTime(Timestamp crtTime) {
        this.crtTime = crtTime;
    }

    /** 
     * Returns the crtUserId.
     * 
     * @return the crtUserId
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /** 
     * Sets the crtUserId.
     * 
     * @param crtUserId the crtUserId
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    /** 
     * Returns the crtDeptCd.
     * 
     * @return the crtDeptCd
     */
    public String getCrtDeptCd() {
        return crtDeptCd;
    }

    /** 
     * Sets the crtDeptCd.
     * 
     * @param crtDeptCd the crtDeptCd
     */
    public void setCrtDeptCd(String crtDeptCd) {
        this.crtDeptCd = crtDeptCd;
    }

    /** 
     * Returns the lastUpdTime.
     * 
     * @return the lastUpdTime
     */
    public Timestamp getLastUpdTime() {
        return lastUpdTime;
    }

    /** 
     * Sets the lastUpdTime.
     * 
     * @param lastUpdTime the lastUpdTime
     */
    public void setLastUpdTime(Timestamp lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /** 
     * Returns the lastUpdDeptCd.
     * 
     * @return the lastUpdDeptCd
     */
    public String getLastUpdDeptCd() {
        return lastUpdDeptCd;
    }

    /** 
     * Sets the lastUpdDeptCd.
     * 
     * @param lastUpdDeptCd the lastUpdDeptCd
     */
    public void setLastUpdDeptCd(String lastUpdDeptCd) {
        this.lastUpdDeptCd = lastUpdDeptCd;
    }

    /** 
     * Returns the lastUpdUserId.
     * 
     * @return the lastUpdUserId
     */
    public String getLastUpdUserId() {
        return lastUpdUserId;
    }

    /** 
     * Sets the lastUpdUserId.
     * 
     * @param lastUpdUserId the lastUpdUserId
     */
    public void setLastUpdUserId(String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }

    /** 
     * Returns the delF.
     * 
     * @return the delF
     */
    public Short getDelF() {
        return delF;
    }

    /** 
     * Sets the delF.
     * 
     * @param delF the delF
     */
    public void setDelF(Short delF) {
        this.delF = delF;
    }
}