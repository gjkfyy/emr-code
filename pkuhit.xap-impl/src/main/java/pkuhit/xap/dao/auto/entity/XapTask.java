package pkuhit.xap.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 任务表
 */
@Entity(listener = XapTaskListener.class)
@Table(name = "XAP_TASK")
public class XapTask {

    /** 主键 */
    @Id
    @Column(name = "TASK_ID")
    String taskId;

    /** 任务类型 */
    @Column(name = "TASK_TYPE_CD")
    String taskTypeCd;

    /** 文书 */
    @Column(name = "DOC_SN")
    String docSn;

    /** 事件编码 */
    @Column(name = "EVENT_ID")
    String eventId;

    /** 开始时间 */
    @Column(name = "BEGIN_TIME")
    Timestamp beginTime;

    /** 结束时间 */
    @Column(name = "END_TIME")
    Timestamp endTime;

    /** 就诊序号 */
    @Column(name = "ENCOUNTER_SN")
    String encounterSn;

    /** 完成时间 */
    @Column(name = "COMPLETE_TIME")
    Timestamp completeTime;

    /** 状态。待处理、处理中、已处理 */
    @Column(name = "STATUS")
    String status;

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

    /** 
     * Returns the taskId.
     * 
     * @return the taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /** 
     * Sets the taskId.
     * 
     * @param taskId the taskId
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

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
     * Returns the docSn.
     * 
     * @return the docSn
     */
    public String getDocSn() {
        return docSn;
    }

    /** 
     * Sets the docSn.
     * 
     * @param docSn the docSn
     */
    public void setDocSn(String docSn) {
        this.docSn = docSn;
    }

    /** 
     * Returns the eventId.
     * 
     * @return the eventId
     */
    public String getEventId() {
        return eventId;
    }

    /** 
     * Sets the eventId.
     * 
     * @param eventId the eventId
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /** 
     * Returns the beginTime.
     * 
     * @return the beginTime
     */
    public Timestamp getBeginTime() {
        return beginTime;
    }

    /** 
     * Sets the beginTime.
     * 
     * @param beginTime the beginTime
     */
    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    /** 
     * Returns the endTime.
     * 
     * @return the endTime
     */
    public Timestamp getEndTime() {
        return endTime;
    }

    /** 
     * Sets the endTime.
     * 
     * @param endTime the endTime
     */
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    /** 
     * Returns the encounterSn.
     * 
     * @return the encounterSn
     */
    public String getEncounterSn() {
        return encounterSn;
    }

    /** 
     * Sets the encounterSn.
     * 
     * @param encounterSn the encounterSn
     */
    public void setEncounterSn(String encounterSn) {
        this.encounterSn = encounterSn;
    }

    /** 
     * Returns the completeTime.
     * 
     * @return the completeTime
     */
    public Timestamp getCompleteTime() {
        return completeTime;
    }

    /** 
     * Sets the completeTime.
     * 
     * @param completeTime the completeTime
     */
    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    /** 
     * Returns the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /** 
     * Sets the status.
     * 
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
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
}