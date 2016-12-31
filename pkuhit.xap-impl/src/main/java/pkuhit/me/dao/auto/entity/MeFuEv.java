package pkuhit.me.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * ME_FU_EV

 */
@Entity(listener = MeFuEvListener.class)
@Table(name = "ME_FU_EV")
public class MeFuEv {

    /** */
    @Id
    @Column(name = "FU_EV_CD")
    String fuEvCd;

    /** */
    @Column(name = "FU_EL_CD")
    String fuElCd;

    /** */
    @Column(name = "FU_ACT_CD")
    String fuActCd;

    /** */
    @Column(name = "EV_TP_CD")
    String evTpCd;

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
     * Returns the fuEvCd.
     * 
     * @return the fuEvCd
     */
    public String getFuEvCd() {
        return fuEvCd;
    }

    /** 
     * Sets the fuEvCd.
     * 
     * @param fuEvCd the fuEvCd
     */
    public void setFuEvCd(String fuEvCd) {
        this.fuEvCd = fuEvCd;
    }

    /** 
     * Returns the fuElCd.
     * 
     * @return the fuElCd
     */
    public String getFuElCd() {
        return fuElCd;
    }

    /** 
     * Sets the fuElCd.
     * 
     * @param fuElCd the fuElCd
     */
    public void setFuElCd(String fuElCd) {
        this.fuElCd = fuElCd;
    }

    /** 
     * Returns the fuActCd.
     * 
     * @return the fuActCd
     */
    public String getFuActCd() {
        return fuActCd;
    }

    /** 
     * Sets the fuActCd.
     * 
     * @param fuActCd the fuActCd
     */
    public void setFuActCd(String fuActCd) {
        this.fuActCd = fuActCd;
    }

    /** 
     * Returns the evTpCd.
     * 
     * @return the evTpCd
     */
    public String getEvTpCd() {
        return evTpCd;
    }

    /** 
     * Sets the evTpCd.
     * 
     * @param evTpCd the evTpCd
     */
    public void setEvTpCd(String evTpCd) {
        this.evTpCd = evTpCd;
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