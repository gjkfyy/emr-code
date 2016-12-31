package pkuhit.xap.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * XAP_STALOG
 */
@Entity(listener = XapStalogListener.class)
@Table(name = "XAP_STALOG")
public class XapStalog {

    /** */
    @Id
    @Column(name = "STALOG_PK")
    String stalogPk;

    /** */
    @Column(name = "USER_ID")
    String userId;

    /** */
    @Column(name = "OBJ_ATTR_CD")
    String objAttrCd;

    /** */
    @Column(name = "OB_PK")
    String obPk;

    /** */
    @Column(name = "PRE_STA_CD")
    String preStaCd;

    /** */
    @Column(name = "NEXT_STA_CD")
    String nextStaCd;

    /** */
    @Column(name = "ACT_TIME")
    Timestamp actTime;

    /** */
    @Column(name = "ACT_DEPT_CD")
    String actDeptCd;

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
     * Returns the stalogPk.
     * 
     * @return the stalogPk
     */
    public String getStalogPk() {
        return stalogPk;
    }

    /** 
     * Sets the stalogPk.
     * 
     * @param stalogPk the stalogPk
     */
    public void setStalogPk(String stalogPk) {
        this.stalogPk = stalogPk;
    }

    /** 
     * Returns the userId.
     * 
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * Sets the userId.
     * 
     * @param userId the userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** 
     * Returns the objAttrCd.
     * 
     * @return the objAttrCd
     */
    public String getObjAttrCd() {
        return objAttrCd;
    }

    /** 
     * Sets the objAttrCd.
     * 
     * @param objAttrCd the objAttrCd
     */
    public void setObjAttrCd(String objAttrCd) {
        this.objAttrCd = objAttrCd;
    }

    /** 
     * Returns the obPk.
     * 
     * @return the obPk
     */
    public String getObPk() {
        return obPk;
    }

    /** 
     * Sets the obPk.
     * 
     * @param obPk the obPk
     */
    public void setObPk(String obPk) {
        this.obPk = obPk;
    }

    /** 
     * Returns the preStaCd.
     * 
     * @return the preStaCd
     */
    public String getPreStaCd() {
        return preStaCd;
    }

    /** 
     * Sets the preStaCd.
     * 
     * @param preStaCd the preStaCd
     */
    public void setPreStaCd(String preStaCd) {
        this.preStaCd = preStaCd;
    }

    /** 
     * Returns the nextStaCd.
     * 
     * @return the nextStaCd
     */
    public String getNextStaCd() {
        return nextStaCd;
    }

    /** 
     * Sets the nextStaCd.
     * 
     * @param nextStaCd the nextStaCd
     */
    public void setNextStaCd(String nextStaCd) {
        this.nextStaCd = nextStaCd;
    }

    /** 
     * Returns the actTime.
     * 
     * @return the actTime
     */
    public Timestamp getActTime() {
        return actTime;
    }

    /** 
     * Sets the actTime.
     * 
     * @param actTime the actTime
     */
    public void setActTime(Timestamp actTime) {
        this.actTime = actTime;
    }

    /** 
     * Returns the actDeptCd.
     * 
     * @return the actDeptCd
     */
    public String getActDeptCd() {
        return actDeptCd;
    }

    /** 
     * Sets the actDeptCd.
     * 
     * @param actDeptCd the actDeptCd
     */
    public void setActDeptCd(String actDeptCd) {
        this.actDeptCd = actDeptCd;
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