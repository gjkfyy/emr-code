package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 自动质控缺陷表
 */
@Entity(listener = QaAutoFltListener.class)
@Table(name = "QA_AUTO_FLT")
public class QaAutoFlt {

    /** 主键 */
    @Id
    @Column(name = "QA_AUTO_FLT_PK")
    String qaAutoFltPk;

    /** 质控项编码 */
    @Column(name = "QA_ITM_CD")
    String qaItmCd;

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

    /** 申请标识。0：未生成申请 1已生成申请 */
    @Column(name = "APPLY_FLAG")
    Short applyFlag;

    /** 缺陷标识。0：未生成缺陷 1已生成缺陷 */
    @Column(name = "FLT_FLAG")
    Short fltFlag;

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

    /** */
	 @Column(name = "DIV_FLAG")
	 Short divFlag;
	 
    public Short getDivFlag() {
		return divFlag;
	}

	public void setDivFlag(Short divFlag) {
		this.divFlag = divFlag;
	}

	/** 
     * Returns the qaAutoFltPk.
     * 
     * @return the qaAutoFltPk
     */
    public String getQaAutoFltPk() {
        return qaAutoFltPk;
    }

    /** 
     * Sets the qaAutoFltPk.
     * 
     * @param qaAutoFltPk the qaAutoFltPk
     */
    public void setQaAutoFltPk(String qaAutoFltPk) {
        this.qaAutoFltPk = qaAutoFltPk;
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
     * Returns the applyFlag.
     * 
     * @return the applyFlag
     */
    public Short getApplyFlag() {
        return applyFlag;
    }

    /** 
     * Sets the applyFlag.
     * 
     * @param applyFlag the applyFlag
     */
    public void setApplyFlag(Short applyFlag) {
        this.applyFlag = applyFlag;
    }

    /** 
     * Returns the fltFlag.
     * 
     * @return the fltFlag
     */
    public Short getFltFlag() {
        return fltFlag;
    }

    /** 
     * Sets the fltFlag.
     * 
     * @param fltFlag the fltFlag
     */
    public void setFltFlag(Short fltFlag) {
        this.fltFlag = fltFlag;
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