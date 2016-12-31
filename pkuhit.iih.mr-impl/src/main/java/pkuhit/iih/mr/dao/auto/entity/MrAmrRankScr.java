package pkuhit.iih.mr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MrAmrRankScrListener.class)
@Table(name = "MR_AMR_RANK_SCR")
public class MrAmrRankScr {

    /** */
    @Id
    @Column(name = "AMR_RANK_SCR_CD")
    String amrRankScrCd;

    /** */
    @Column(name = "AMR_RANK_CD")
    String amrRankCd;

    /** */
    @Column(name = "ORG_CD")
    String orgCd;

    /** */
    @Column(name = "MAX_SCR")
    BigInteger maxScr;

    /** */
    @Column(name = "MIN_SCR")
    BigInteger minScr;

    /** */
    @Column(name = "SORT_NO")
    String sortNo;

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
     * Returns the amrRankScrCd.
     * 
     * @return the amrRankScrCd
     */
    public String getAmrRankScrCd() {
        return amrRankScrCd;
    }

    /** 
     * Sets the amrRankScrCd.
     * 
     * @param amrRankScrCd the amrRankScrCd
     */
    public void setAmrRankScrCd(String amrRankScrCd) {
        this.amrRankScrCd = amrRankScrCd;
    }

    /** 
     * Returns the amrRankCd.
     * 
     * @return the amrRankCd
     */
    public String getAmrRankCd() {
        return amrRankCd;
    }

    /** 
     * Sets the amrRankCd.
     * 
     * @param amrRankCd the amrRankCd
     */
    public void setAmrRankCd(String amrRankCd) {
        this.amrRankCd = amrRankCd;
    }

    /** 
     * Returns the orgCd.
     * 
     * @return the orgCd
     */
    public String getOrgCd() {
        return orgCd;
    }

    /** 
     * Sets the orgCd.
     * 
     * @param orgCd the orgCd
     */
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    /** 
     * Returns the maxScr.
     * 
     * @return the maxScr
     */
    public BigInteger getMaxScr() {
        return maxScr;
    }

    /** 
     * Sets the maxScr.
     * 
     * @param maxScr the maxScr
     */
    public void setMaxScr(BigInteger maxScr) {
        this.maxScr = maxScr;
    }

    /** 
     * Returns the minScr.
     * 
     * @return the minScr
     */
    public BigInteger getMinScr() {
        return minScr;
    }

    /** 
     * Sets the minScr.
     * 
     * @param minScr the minScr
     */
    public void setMinScr(BigInteger minScr) {
        this.minScr = minScr;
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