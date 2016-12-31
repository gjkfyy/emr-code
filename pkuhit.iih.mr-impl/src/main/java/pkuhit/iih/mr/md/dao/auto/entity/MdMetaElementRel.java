package pkuhit.iih.mr.md.dao.auto.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MdMetaElementRelListener.class)
@Table(name = "MD_META_ELEMENT_REL")
public class MdMetaElementRel {

    /** */
    @Id
    @Column(name = "DATA_ELEMENT_REL_CD")
    String dataElementRelCd;

    /** */
    @Column(name = "DATA_ELEMENT_CD")
    String dataElementCd;

    /** */
    @Column(name = "CODE_SYSTEM_CD")
    String codeSystemCd;

    /** */
    @Column(name = "CODE_SYSTEM_DATA_ELEMENT_CD")
    String codeSystemDataElementCd;

    /** */
    @Column(name = "CODE_SYSTEM_DATA_ELEMENT_VER")
    BigDecimal codeSystemDataElementVer;

    /** */
    @Column(name = "DESCRIPTIONS")
    String descriptions;

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
     * Returns the dataElementRelCd.
     * 
     * @return the dataElementRelCd
     */
    public String getDataElementRelCd() {
        return dataElementRelCd;
    }

    /** 
     * Sets the dataElementRelCd.
     * 
     * @param dataElementRelCd the dataElementRelCd
     */
    public void setDataElementRelCd(String dataElementRelCd) {
        this.dataElementRelCd = dataElementRelCd;
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
     * Returns the codeSystemCd.
     * 
     * @return the codeSystemCd
     */
    public String getCodeSystemCd() {
        return codeSystemCd;
    }

    /** 
     * Sets the codeSystemCd.
     * 
     * @param codeSystemCd the codeSystemCd
     */
    public void setCodeSystemCd(String codeSystemCd) {
        this.codeSystemCd = codeSystemCd;
    }

    /** 
     * Returns the codeSystemDataElementCd.
     * 
     * @return the codeSystemDataElementCd
     */
    public String getCodeSystemDataElementCd() {
        return codeSystemDataElementCd;
    }

    /** 
     * Sets the codeSystemDataElementCd.
     * 
     * @param codeSystemDataElementCd the codeSystemDataElementCd
     */
    public void setCodeSystemDataElementCd(String codeSystemDataElementCd) {
        this.codeSystemDataElementCd = codeSystemDataElementCd;
    }

    /** 
     * Returns the codeSystemDataElementVer.
     * 
     * @return the codeSystemDataElementVer
     */
    public BigDecimal getCodeSystemDataElementVer() {
        return codeSystemDataElementVer;
    }

    /** 
     * Sets the codeSystemDataElementVer.
     * 
     * @param codeSystemDataElementVer the codeSystemDataElementVer
     */
    public void setCodeSystemDataElementVer(BigDecimal codeSystemDataElementVer) {
        this.codeSystemDataElementVer = codeSystemDataElementVer;
    }

    /** 
     * Returns the descriptions.
     * 
     * @return the descriptions
     */
    public String getDescriptions() {
        return descriptions;
    }

    /** 
     * Sets the descriptions.
     * 
     * @param descriptions the descriptions
     */
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
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