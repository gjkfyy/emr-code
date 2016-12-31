package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 质控工作记录
 */
@Entity(listener = QaListener.class)
@Table(name = "QA")
public class Qa {

    /** 主键 */
    @Id
    @Column(name = "QA_PK")
    String qaPk;

    /** 就诊序号 */
    @Column(name = "EN_PK")
    String enPk;

    /** 质控类型 */
    @Column(name = "QA_TY_CD")
    String qaTyCd;

    /** 计划开始时间 */
    @Column(name = "PLAN_TIME")
    Timestamp planTime;

    /** 实际开始时间 */
    @Column(name = "EXEC_BEGIN_TIME")
    Timestamp execBeginTime;

    /** 实际结束时间 */
    @Column(name = "EXEC_END_TIME")
    Timestamp execEndTime;

    /** 实际执行人 */
    @Column(name = "EXEC_USER_ID")
    String execUserId;

    /** 实际执行科室 */
    @Column(name = "EXEC_DEPT_CD")
    String execDeptCd;

    /** 完成标志 */
    @Column(name = "CMPL_F")
    Short cmplF;

    /** 有缺陷标志 */
    @Column(name = "HAVE_FLT_F")
    Short haveFltF;

    /** 有需整改标志 */
    @Column(name = "NEED_RFM_FLT_F")
    Short needRfmFltF;

    /** 整改期限 */
    @Column(name = "RFM_DEADLINE")
    BigInteger rfmDeadline;

    /** 整改截止日期 */
    @Column(name = "DEADLINE")
    Timestamp deadline;

    /** 整改通知编码 */
    @Column(name = "REVISION_CD")
    String revisionCd;

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

    /** 质控工作编码，标识一次质控工作 */
    @Column(name = "QA_WORK_CD")
    String qaWorkCd;

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
     * Returns the enPk.
     * 
     * @return the enPk
     */
    public String getEnPk() {
        return enPk;
    }

    /** 
     * Sets the enPk.
     * 
     * @param enPk the enPk
     */
    public void setEnPk(String enPk) {
        this.enPk = enPk;
    }

    /** 
     * Returns the qaTyCd.
     * 
     * @return the qaTyCd
     */
    public String getQaTyCd() {
        return qaTyCd;
    }

    /** 
     * Sets the qaTyCd.
     * 
     * @param qaTyCd the qaTyCd
     */
    public void setQaTyCd(String qaTyCd) {
        this.qaTyCd = qaTyCd;
    }

    /** 
     * Returns the planTime.
     * 
     * @return the planTime
     */
    public Timestamp getPlanTime() {
        return planTime;
    }

    /** 
     * Sets the planTime.
     * 
     * @param planTime the planTime
     */
    public void setPlanTime(Timestamp planTime) {
        this.planTime = planTime;
    }

    /** 
     * Returns the execBeginTime.
     * 
     * @return the execBeginTime
     */
    public Timestamp getExecBeginTime() {
        return execBeginTime;
    }

    /** 
     * Sets the execBeginTime.
     * 
     * @param execBeginTime the execBeginTime
     */
    public void setExecBeginTime(Timestamp execBeginTime) {
        this.execBeginTime = execBeginTime;
    }

    /** 
     * Returns the execEndTime.
     * 
     * @return the execEndTime
     */
    public Timestamp getExecEndTime() {
        return execEndTime;
    }

    /** 
     * Sets the execEndTime.
     * 
     * @param execEndTime the execEndTime
     */
    public void setExecEndTime(Timestamp execEndTime) {
        this.execEndTime = execEndTime;
    }

    /** 
     * Returns the execUserId.
     * 
     * @return the execUserId
     */
    public String getExecUserId() {
        return execUserId;
    }

    /** 
     * Sets the execUserId.
     * 
     * @param execUserId the execUserId
     */
    public void setExecUserId(String execUserId) {
        this.execUserId = execUserId;
    }

    /** 
     * Returns the execDeptCd.
     * 
     * @return the execDeptCd
     */
    public String getExecDeptCd() {
        return execDeptCd;
    }

    /** 
     * Sets the execDeptCd.
     * 
     * @param execDeptCd the execDeptCd
     */
    public void setExecDeptCd(String execDeptCd) {
        this.execDeptCd = execDeptCd;
    }

    /** 
     * Returns the cmplF.
     * 
     * @return the cmplF
     */
    public Short getCmplF() {
        return cmplF;
    }

    /** 
     * Sets the cmplF.
     * 
     * @param cmplF the cmplF
     */
    public void setCmplF(Short cmplF) {
        this.cmplF = cmplF;
    }

    /** 
     * Returns the haveFltF.
     * 
     * @return the haveFltF
     */
    public Short getHaveFltF() {
        return haveFltF;
    }

    /** 
     * Sets the haveFltF.
     * 
     * @param haveFltF the haveFltF
     */
    public void setHaveFltF(Short haveFltF) {
        this.haveFltF = haveFltF;
    }

    /** 
     * Returns the needRfmFltF.
     * 
     * @return the needRfmFltF
     */
    public Short getNeedRfmFltF() {
        return needRfmFltF;
    }

    /** 
     * Sets the needRfmFltF.
     * 
     * @param needRfmFltF the needRfmFltF
     */
    public void setNeedRfmFltF(Short needRfmFltF) {
        this.needRfmFltF = needRfmFltF;
    }

    /** 
     * Returns the rfmDeadline.
     * 
     * @return the rfmDeadline
     */
    public BigInteger getRfmDeadline() {
        return rfmDeadline;
    }

    /** 
     * Sets the rfmDeadline.
     * 
     * @param rfmDeadline the rfmDeadline
     */
    public void setRfmDeadline(BigInteger rfmDeadline) {
        this.rfmDeadline = rfmDeadline;
    }

    /** 
     * Returns the deadline.
     * 
     * @return the deadline
     */
    public Timestamp getDeadline() {
        return deadline;
    }

    /** 
     * Sets the deadline.
     * 
     * @param deadline the deadline
     */
    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    /** 
     * Returns the revisionCd.
     * 
     * @return the revisionCd
     */
    public String getRevisionCd() {
        return revisionCd;
    }

    /** 
     * Sets the revisionCd.
     * 
     * @param revisionCd the revisionCd
     */
    public void setRevisionCd(String revisionCd) {
        this.revisionCd = revisionCd;
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
     * Returns the qaWorkCd.
     * 
     * @return the qaWorkCd
     */
    public String getQaWorkCd() {
        return qaWorkCd;
    }

    /** 
     * Sets the qaWorkCd.
     * 
     * @param qaWorkCd the qaWorkCd
     */
    public void setQaWorkCd(String qaWorkCd) {
        this.qaWorkCd = qaWorkCd;
    }
}