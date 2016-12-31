package pkuhit.iih.mr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MrSignListener.class)
@Table(name = "MR_SIGN")
public class MrSign {

    /** */
    @Id
    @Column(name = "MR_SIGN_PK")
    String mrSignPk;

    /** */
    @Column(name = "MR_PK")
    String mrPk;

    /** */
    @Column(name = "SIGN_LVL_CD")
    String signLvlCd;

    /** */
    @Column(name = "SIGN_TIME")
    Timestamp signTime;

    /** */
    @Column(name = "SIGN_USER_ID")
    String signUserId;

    /** */
    @Column(name = "SIGN_DEPT_CD")
    String signDeptCd;

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
     * Returns the mrSignPk.
     * 
     * @return the mrSignPk
     */
    public String getMrSignPk() {
        return mrSignPk;
    }

    /** 
     * Sets the mrSignPk.
     * 
     * @param mrSignPk the mrSignPk
     */
    public void setMrSignPk(String mrSignPk) {
        this.mrSignPk = mrSignPk;
    }

    /** 
     * Returns the mrPk.
     * 
     * @return the mrPk
     */
    public String getMrPk() {
        return mrPk;
    }

    /** 
     * Sets the mrPk.
     * 
     * @param mrPk the mrPk
     */
    public void setMrPk(String mrPk) {
        this.mrPk = mrPk;
    }

    /** 
     * Returns the signLvlCd.
     * 
     * @return the signLvlCd
     */
    public String getSignLvlCd() {
        return signLvlCd;
    }

    /** 
     * Sets the signLvlCd.
     * 
     * @param signLvlCd the signLvlCd
     */
    public void setSignLvlCd(String signLvlCd) {
        this.signLvlCd = signLvlCd;
    }

    /** 
     * Returns the signTime.
     * 
     * @return the signTime
     */
    public Timestamp getSignTime() {
        return signTime;
    }

    /** 
     * Sets the signTime.
     * 
     * @param signTime the signTime
     */
    public void setSignTime(Timestamp signTime) {
        this.signTime = signTime;
    }

    /** 
     * Returns the signUserId.
     * 
     * @return the signUserId
     */
    public String getSignUserId() {
        return signUserId;
    }

    /** 
     * Sets the signUserId.
     * 
     * @param signUserId the signUserId
     */
    public void setSignUserId(String signUserId) {
        this.signUserId = signUserId;
    }

    /** 
     * Returns the signDeptCd.
     * 
     * @return the signDeptCd
     */
    public String getSignDeptCd() {
        return signDeptCd;
    }

    /** 
     * Sets the signDeptCd.
     * 
     * @param signDeptCd the signDeptCd
     */
    public void setSignDeptCd(String signDeptCd) {
        this.signDeptCd = signDeptCd;
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