package pkuhit.xap.dao.auto.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 任务类型表
 */
@Entity(listener = XapTaskTypeListener.class)
@Table(name = "XAP_TASK_TYPE")
public class XapTaskType {

    /** 主键 */
    @Id
    @Column(name = "TASK_TYPE_CD")
    String taskTypeCd;

    /** 名称 */
    @Column(name = "NM")
    String nm;

    /** 文书类型 */
    @Column(name = "MD_MR_TP_CD")
    String mdMrTpCd;

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

    /** 期限时间 */
    @Column(name = "DEAD_HOURS")
    BigDecimal deadHours;

    /** 启用标记 */
    @Column(name = "USE_FLAG")
    String useFlag;

    /** 质控项目类别,主数据QAM06：时限性、频率性、完整性 */
    @Column(name = "QA_ITM_TP_CD")
    String qaItmTpCd;

    /** 医生操作类型 01提交 02查房 */
    @Column(name = "DCT_OP_TP_CD")
    String dctOpTpCd;

    /** 医生职称 */
    @Column(name = "JOB_TITLE_CD")
    String jobTitleCd;

    /** 校验规则类型，频率质控：01重复性 02连续性 */
    @Column(name = "QA_RL_TP_CD")
    String qaRlTpCd;

    /** 校验规则 */
    @Column(name = "QA_RL_CD")
    String qaRlCd;

    /** 
     * Returns the taskTypeCd.
     * 
     * @return the taskTypeCd
     */
    public String getTaskTypeCd() {
        return taskTypeCd;
    }

    /** 
     * Sets the taskTypeCd.
     * 
     * @param taskTypeCd the taskTypeCd
     */
    public void setTaskTypeCd(String taskTypeCd) {
        this.taskTypeCd = taskTypeCd;
    }

    /** 
     * Returns the nm.
     * 
     * @return the nm
     */
    public String getNm() {
        return nm;
    }

    /** 
     * Sets the nm.
     * 
     * @param nm the nm
     */
    public void setNm(String nm) {
        this.nm = nm;
    }

    /** 
     * Returns the mdMrTpCd.
     * 
     * @return the mdMrTpCd
     */
    public String getMdMrTpCd() {
        return mdMrTpCd;
    }

    /** 
     * Sets the mdMrTpCd.
     * 
     * @param mdMrTpCd the mdMrTpCd
     */
    public void setMdMrTpCd(String mdMrTpCd) {
        this.mdMrTpCd = mdMrTpCd;
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
}