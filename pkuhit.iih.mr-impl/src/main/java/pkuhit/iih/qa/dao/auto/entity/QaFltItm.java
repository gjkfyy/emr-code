package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = QaFltItmListener.class)
@Table(name = "QA_FLT_ITM")
public class QaFltItm {

    /** */
    @Id
    @Column(name = "QA_FLT_ITM_PK")
    String qaFltItmPk;

    /** */
    @Column(name = "QA_PK")
    String qaPk;

    /** */
    @Column(name = "QA_FLT_PK")
    String qaFltPk;

    /** */
    @Column(name = "ACTIVE_F")
    Short activeF;

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
     * Returns the qaFltItmPk.
     * 
     * @return the qaFltItmPk
     */
    public String getQaFltItmPk() {
        return qaFltItmPk;
    }

    /** 
     * Sets the qaFltItmPk.
     * 
     * @param qaFltItmPk the qaFltItmPk
     */
    public void setQaFltItmPk(String qaFltItmPk) {
        this.qaFltItmPk = qaFltItmPk;
    }

    /** 
     * Returns the qaPk.
     * 
     * @return the qaPk
     */
    public String getQaPk() {
        return qaPk;
    }

    /** 
     * Sets the qaPk.
     * 
     * @param qaPk the qaPk
     */
    public void setQaPk(String qaPk) {
        this.qaPk = qaPk;
    }

    /** 
     * Returns the qaFltPk.
     * 
     * @return the qaFltPk
     */
    public String getQaFltPk() {
        return qaFltPk;
    }

    /** 
     * Sets the qaFltPk.
     * 
     * @param qaFltPk the qaFltPk
     */
    public void setQaFltPk(String qaFltPk) {
        this.qaFltPk = qaFltPk;
    }

    /** 
     * Returns the activeF.
     * 
     * @return the activeF
     */
    public Short getActiveF() {
        return activeF;
    }

    /** 
     * Sets the activeF.
     * 
     * @param activeF the activeF
     */
    public void setActiveF(Short activeF) {
        this.activeF = activeF;
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