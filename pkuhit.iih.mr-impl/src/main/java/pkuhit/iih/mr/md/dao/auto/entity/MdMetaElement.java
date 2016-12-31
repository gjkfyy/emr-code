package pkuhit.iih.mr.md.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MdMetaElementListener.class)
@Table(name = "MD_META_ELEMENT")
public class MdMetaElement {

    /** */
    @Id
    @Column(name = "DATA_ELEMENT_CD")
    String dataElementCd;

    /** */
    @Column(name = "DATA_ELEMENT_NM_EN")
    String dataElementNmEn;

    /** */
    @Column(name = "DATA_ELEMENT_NM")
    String dataElementNm;

    /** */
    @Column(name = "DATA_META_TYPE_CD")
    String dataMetaTypeCd;

    /** */
    @Column(name = "DATA_META_STATUS_CD")
    String dataMetaStatusCd;

    /** */
    @Column(name = "DATA_TYPE_CD")
    String dataTypeCd;

    /** */
    @Column(name = "DEFAULT_VALUE")
    String defaultValue;

    /** */
    @Column(name = "DEFAULT_UNIT_CD")
    String defaultUnitCd;

    /** */
    @Column(name = "RELATED_MASTER_TABLE_CD")
    String relatedMasterTableCd;

    /** */
    @Column(name = "MEMO")
    String memo;

    /** */
    @Column(name = "SORT_NO")
    String sortNo;

    /** */
    @Column(name = "SPELL_NO")
    String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    String wubiNo;

    /** */
    @Column(name = "UPD_CNT")
    BigInteger updCnt;

    /** */
    @Column(name = "CRT_TIME")
    Timestamp crtTime;

    /** */
    @Column(name = "CRT_USER_ID")
    String crtUserId;

    /** */
    @Column(name = "CRT_DEPT_CD")
    String crtDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    /** */
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;

    /** */
    @Column(name = "DEL_F")
    Short delF;

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
     * Returns the dataElementNmEn.
     * 
     * @return the dataElementNmEn
     */
    public String getDataElementNmEn() {
        return dataElementNmEn;
    }

    /** 
     * Sets the dataElementNmEn.
     * 
     * @param dataElementNmEn the dataElementNmEn
     */
    public void setDataElementNmEn(String dataElementNmEn) {
        this.dataElementNmEn = dataElementNmEn;
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

    /** 
     * Returns the dataMetaTypeCd.
     * 
     * @return the dataMetaTypeCd
     */
    public String getDataMetaTypeCd() {
        return dataMetaTypeCd;
    }

    /** 
     * Sets the dataMetaTypeCd.
     * 
     * @param dataMetaTypeCd the dataMetaTypeCd
     */
    public void setDataMetaTypeCd(String dataMetaTypeCd) {
        this.dataMetaTypeCd = dataMetaTypeCd;
    }

    /** 
     * Returns the dataMetaStatusCd.
     * 
     * @return the dataMetaStatusCd
     */
    public String getDataMetaStatusCd() {
        return dataMetaStatusCd;
    }

    /** 
     * Sets the dataMetaStatusCd.
     * 
     * @param dataMetaStatusCd the dataMetaStatusCd
     */
    public void setDataMetaStatusCd(String dataMetaStatusCd) {
        this.dataMetaStatusCd = dataMetaStatusCd;
    }

    /** 
     * Returns the dataTypeCd.
     * 
     * @return the dataTypeCd
     */
    public String getDataTypeCd() {
        return dataTypeCd;
    }

    /** 
     * Sets the dataTypeCd.
     * 
     * @param dataTypeCd the dataTypeCd
     */
    public void setDataTypeCd(String dataTypeCd) {
        this.dataTypeCd = dataTypeCd;
    }

    /** 
     * Returns the defaultValue.
     * 
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /** 
     * Sets the defaultValue.
     * 
     * @param defaultValue the defaultValue
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /** 
     * Returns the defaultUnitCd.
     * 
     * @return the defaultUnitCd
     */
    public String getDefaultUnitCd() {
        return defaultUnitCd;
    }

    /** 
     * Sets the defaultUnitCd.
     * 
     * @param defaultUnitCd the defaultUnitCd
     */
    public void setDefaultUnitCd(String defaultUnitCd) {
        this.defaultUnitCd = defaultUnitCd;
    }

    /** 
     * Returns the relatedMasterTableCd.
     * 
     * @return the relatedMasterTableCd
     */
    public String getRelatedMasterTableCd() {
        return relatedMasterTableCd;
    }

    /** 
     * Sets the relatedMasterTableCd.
     * 
     * @param relatedMasterTableCd the relatedMasterTableCd
     */
    public void setRelatedMasterTableCd(String relatedMasterTableCd) {
        this.relatedMasterTableCd = relatedMasterTableCd;
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