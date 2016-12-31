package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 数据元值域表
 */
@Entity(listener = QaAutoItmConfigListener.class)
@Table(name = "QA_AUTO_ITM_CONFIG")
public class QaAutoItmConfig {

    /** */
    @Id
    @Column(name = "QA_ITM_CONFIG_CD")
    String qaItmConfigCd;

    /** ????? */
    @Column(name = "QA_ITM_CD")
    String qaItmCd;

    /** ????? */
    @Column(name = "REQ")
    String req;

    /** ?????? */
    @Column(name = "MR_TYPES")
    String mrTypes;

    /** ???? */
    @Column(name = "EVENT_TYPE_CODE")
    String eventTypeCode;

    /** ???? */
    @Column(name = "DEAD_HOURS")
    BigDecimal deadHours;

    /** ???? */
    @Column(name = "USE_FLAG")
    String useFlag;

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

    /** ?????? */
    @Column(name = "MR_OP_TYPE")
    String mrOpType;

    /** ??????,???QAM06???????????? */
    @Column(name = "QA_ITM_TP_CD")
    String qaItmTpCd;

    /** ?????? 01?? 02?? */
    @Column(name = "DCT_OP_TP_CD")
    String dctOpTpCd;

    /** ???? */
    @Column(name = "JOB_TITLE_CD")
    String jobTitleCd;

    /** ????????????01??? 02??? */
    @Column(name = "QA_RL_TP_CD")
    String qaRlTpCd;

    /** ???? */
    @Column(name = "QA_RL_CD")
    String qaRlCd;

    /** 剩余时间提醒 */
    @Column(name = "RE_TIME_REMIND")
    BigDecimal reTimeRemind;

    /** 
     * Returns the qaItmConfigCd.
     * 
     * @return the qaItmConfigCd
     */
    public String getQaItmConfigCd() {
        return qaItmConfigCd;
    }

    /** 
     * Sets the qaItmConfigCd.
     * 
     * @param qaItmConfigCd the qaItmConfigCd
     */
    public void setQaItmConfigCd(String qaItmConfigCd) {
        this.qaItmConfigCd = qaItmConfigCd;
    }

    /** 
     * Returns the qaItmCd.
     * 
     * @return the qaItmCd
     */
    public String getQaItmCd() {
        return qaItmCd;
    }

    /** 
     * Sets the qaItmCd.
     * 
     * @param qaItmCd the qaItmCd
     */
    public void setQaItmCd(String qaItmCd) {
        this.qaItmCd = qaItmCd;
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
     * Returns the mrTypes.
     * 
     * @return the mrTypes
     */
    public String getMrTypes() {
        return mrTypes;
    }

    /** 
     * Sets the mrTypes.
     * 
     * @param mrTypes the mrTypes
     */
    public void setMrTypes(String mrTypes) {
        this.mrTypes = mrTypes;
    }

    /** 
     * Returns the eventTypeCode.
     * 
     * @return the eventTypeCode
     */
    public String getEventTypeCode() {
        return eventTypeCode;
    }

    /** 
     * Sets the eventTypeCode.
     * 
     * @param eventTypeCode the eventTypeCode
     */
    public void setEventTypeCode(String eventTypeCode) {
        this.eventTypeCode = eventTypeCode;
    }

    /** 
     * Returns the deadHours.
     * 
     * @return the deadHours
     */
    public BigDecimal getDeadHours() {
        return deadHours;
    }

    /** 
     * Sets the deadHours.
     * 
     * @param deadHours the deadHours
     */
    public void setDeadHours(BigDecimal deadHours) {
        this.deadHours = deadHours;
    }

    /** 
     * Returns the useFlag.
     * 
     * @return the useFlag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /** 
     * Sets the useFlag.
     * 
     * @param useFlag the useFlag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
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

    /** 
     * Returns the mrOpType.
     * 
     * @return the mrOpType
     */
    public String getMrOpType() {
        return mrOpType;
    }

    /** 
     * Sets the mrOpType.
     * 
     * @param mrOpType the mrOpType
     */
    public void setMrOpType(String mrOpType) {
        this.mrOpType = mrOpType;
    }

    /** 
     * Returns the qaItmTpCd.
     * 
     * @return the qaItmTpCd
     */
    public String getQaItmTpCd() {
        return qaItmTpCd;
    }

    /** 
     * Sets the qaItmTpCd.
     * 
     * @param qaItmTpCd the qaItmTpCd
     */
    public void setQaItmTpCd(String qaItmTpCd) {
        this.qaItmTpCd = qaItmTpCd;
    }

    /** 
     * Returns the dctOpTpCd.
     * 
     * @return the dctOpTpCd
     */
    public String getDctOpTpCd() {
        return dctOpTpCd;
    }

    /** 
     * Sets the dctOpTpCd.
     * 
     * @param dctOpTpCd the dctOpTpCd
     */
    public void setDctOpTpCd(String dctOpTpCd) {
        this.dctOpTpCd = dctOpTpCd;
    }

    /** 
     * Returns the jobTitleCd.
     * 
     * @return the jobTitleCd
     */
    public String getJobTitleCd() {
        return jobTitleCd;
    }

    /** 
     * Sets the jobTitleCd.
     * 
     * @param jobTitleCd the jobTitleCd
     */
    public void setJobTitleCd(String jobTitleCd) {
        this.jobTitleCd = jobTitleCd;
    }

    /** 
     * Returns the qaRlTpCd.
     * 
     * @return the qaRlTpCd
     */
    public String getQaRlTpCd() {
        return qaRlTpCd;
    }

    /** 
     * Sets the qaRlTpCd.
     * 
     * @param qaRlTpCd the qaRlTpCd
     */
    public void setQaRlTpCd(String qaRlTpCd) {
        this.qaRlTpCd = qaRlTpCd;
    }

    /** 
     * Returns the qaRlCd.
     * 
     * @return the qaRlCd
     */
    public String getQaRlCd() {
        return qaRlCd;
    }

    /** 
     * Sets the qaRlCd.
     * 
     * @param qaRlCd the qaRlCd
     */
    public void setQaRlCd(String qaRlCd) {
        this.qaRlCd = qaRlCd;
    }

    /** 
     * Returns the reTimeRemind.
     * 
     * @return the reTimeRemind
     */
    public BigDecimal getReTimeRemind() {
        return reTimeRemind;
    }

    /** 
     * Sets the reTimeRemind.
     * 
     * @param reTimeRemind the reTimeRemind
     */
    public void setReTimeRemind(BigDecimal reTimeRemind) {
        this.reTimeRemind = reTimeRemind;
    }
}