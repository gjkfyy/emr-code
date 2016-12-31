package pkuhit.xap.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * XAP_ACLOG
 */
@Entity(listener = XapAclogListener.class)
@Table(name = "XAP_ACLOG")
public class XapAclog {

    /** */
    @Id
    @Column(name = "ACLOG_PK")
    String aclogPk;

    /** */
    @Column(name = "USER_ID")
    String userId;

    /** */
    @Column(name = "XSV_CD")
    String xsvCd;

    /** */
    @Column(name = "INPUT")
    String input;

    /** */
    @Column(name = "OUTPUT")
    String output;

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
     * Returns the aclogPk.
     * 
     * @return the aclogPk
     */
    public String getAclogPk() {
        return aclogPk;
    }

    /** 
     * Sets the aclogPk.
     * 
     * @param aclogPk the aclogPk
     */
    public void setAclogPk(String aclogPk) {
        this.aclogPk = aclogPk;
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
     * Returns the xsvCd.
     * 
     * @return the xsvCd
     */
    public String getXsvCd() {
        return xsvCd;
    }

    /** 
     * Sets the xsvCd.
     * 
     * @param xsvCd the xsvCd
     */
    public void setXsvCd(String xsvCd) {
        this.xsvCd = xsvCd;
    }

    /** 
     * Returns the input.
     * 
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /** 
     * Sets the input.
     * 
     * @param input the input
     */
    public void setInput(String input) {
        this.input = input;
    }

    /** 
     * Returns the output.
     * 
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /** 
     * Sets the output.
     * 
     * @param output the output
     */
    public void setOutput(String output) {
        this.output = output;
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