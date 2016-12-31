package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = QaSysMrListener.class)
@Table(name = "QA_SYS_MR")
public class QaSysMr {

    /** */
    @Id
    @Column(name = "QA_SYS_MR_CD")
    String qaSysMrCd;

    /** */
    @Column(name = "QA_SYS_AMR_CD")
    String qaSysAmrCd;

    /** */
    @Column(name = "MR_TP_CD")
    String mrTpCd;

    /** */
    @Column(name = "REQ")
    String req;

    /** */
    @Column(name = "TTL_SCR")
    BigInteger ttlScr;

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
     * Returns the qaSysMrCd.
     * 
     * @return the qaSysMrCd
     */
    public String getQaSysMrCd() {
        return qaSysMrCd;
    }

    /** 
     * Sets the qaSysMrCd.
     * 
     * @param qaSysMrCd the qaSysMrCd
     */
    public void setQaSysMrCd(String qaSysMrCd) {
        this.qaSysMrCd = qaSysMrCd;
    }

    /** 
     * Returns the qaSysAmrCd.
     * 
     * @return the qaSysAmrCd
     */
    public String getQaSysAmrCd() {
        return qaSysAmrCd;
    }

    /** 
     * Sets the qaSysAmrCd.
     * 
     * @param qaSysAmrCd the qaSysAmrCd
     */
    public void setQaSysAmrCd(String qaSysAmrCd) {
        this.qaSysAmrCd = qaSysAmrCd;
    }

    /** 
     * Returns the mrTpCd.
     * 
     * @return the mrTpCd
     */
    public String getMrTpCd() {
        return mrTpCd;
    }

    /** 
     * Sets the mrTpCd.
     * 
     * @param mrTpCd the mrTpCd
     */
    public void setMrTpCd(String mrTpCd) {
        this.mrTpCd = mrTpCd;
    }

    /** 
     * Returns the req.
     * 
     * @return the req
     */
    public String getReq() {
        return req;
    }

    /** 
     * Sets the req.
     * 
     * @param req the req
     */
    public void setReq(String req) {
        this.req = req;
    }

    /** 
     * Returns the ttlScr.
     * 
     * @return the ttlScr
     */
    public BigInteger getTtlScr() {
        return ttlScr;
    }

    /** 
     * Sets the ttlScr.
     * 
     * @param ttlScr the ttlScr
     */
    public void setTtlScr(BigInteger ttlScr) {
        this.ttlScr = ttlScr;
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