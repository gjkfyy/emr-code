package iih.dr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = IemrRetrievalListener.class)
@Table(name = "IEMR_RETRIEVAL")
public class IemrRetrieval {

    /** */
    @Id
    @Column(name = "RETRIEVAL_CD")
    String retrievalCd;

    /** */
    @Column(name = "RETRIEVAL_NM")
    String retrievalNm;

    /** 全院、科室 */
    @Column(name = "OWN_TP_CD")
    String ownTpCd;

    /** 用","分隔 */
    @Column(name = "DEPT_CD")
    String deptCd;

    /** */
    @Column(name = "RESPONSIBLE_CD")
    String responsibleCd;

    /** */
    @Column(name = "RETRIEVAL_KEY")
    String retrievalKey;

    /** */
    @Column(name = "STATUS_F")
    Short statusF;

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
     * Returns the retrievalCd.
     * 
     * @return the retrievalCd
     */
    public String getRetrievalCd() {
        return retrievalCd;
    }

    /** 
     * Sets the retrievalCd.
     * 
     * @param retrievalCd the retrievalCd
     */
    public void setRetrievalCd(String retrievalCd) {
        this.retrievalCd = retrievalCd;
    }

    /** 
     * Returns the retrievalNm.
     * 
     * @return the retrievalNm
     */
    public String getRetrievalNm() {
        return retrievalNm;
    }

    /** 
     * Sets the retrievalNm.
     * 
     * @param retrievalNm the retrievalNm
     */
    public void setRetrievalNm(String retrievalNm) {
        this.retrievalNm = retrievalNm;
    }

    /** 
     * Returns the ownTpCd.
     * 
     * @return the ownTpCd
     */
    public String getOwnTpCd() {
        return ownTpCd;
    }

    /** 
     * Sets the ownTpCd.
     * 
     * @param ownTpCd the ownTpCd
     */
    public void setOwnTpCd(String ownTpCd) {
        this.ownTpCd = ownTpCd;
    }

    /** 
     * Returns the deptCd.
     * 
     * @return the deptCd
     */
    public String getDeptCd() {
        return deptCd;
    }

    /** 
     * Sets the deptCd.
     * 
     * @param deptCd the deptCd
     */
    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    /** 
     * Returns the responsibleCd.
     * 
     * @return the responsibleCd
     */
    public String getResponsibleCd() {
        return responsibleCd;
    }

    /** 
     * Sets the responsibleCd.
     * 
     * @param responsibleCd the responsibleCd
     */
    public void setResponsibleCd(String responsibleCd) {
        this.responsibleCd = responsibleCd;
    }

    /** 
     * Returns the retrievalKey.
     * 
     * @return the retrievalKey
     */
    public String getRetrievalKey() {
        return retrievalKey;
    }

    /** 
     * Sets the retrievalKey.
     * 
     * @param retrievalKey the retrievalKey
     */
    public void setRetrievalKey(String retrievalKey) {
        this.retrievalKey = retrievalKey;
    }

    /** 
     * Returns the statusF.
     * 
     * @return the statusF
     */
    public Short getStatusF() {
        return statusF;
    }

    /** 
     * Sets the statusF.
     * 
     * @param statusF the statusF
     */
    public void setStatusF(Short statusF) {
        this.statusF = statusF;
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