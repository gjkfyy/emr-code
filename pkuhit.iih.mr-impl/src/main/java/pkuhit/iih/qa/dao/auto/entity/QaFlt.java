package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 缺陷
 */
@Entity(listener = QaFltListener.class)
@Table(name = "QA_FLT")
public class QaFlt {

    /** 主键 */
    @Id
    @Column(name = "QA_FLT_PK")
    String qaFltPk;

    /** 质控项 */
    @Column(name = "QA_ITM_CD")
    String qaItmCd;

    /** 质控类型 */
    @Column(name = "QA_TY_CD")
    String qaTyCd;

    /** 缺陷状态 */
    @Column(name = "FLT_STA_CD")
    String fltStaCd;

    /** 整改通知 */
    @Column(name = "REVISION_CD")
    String revisionCd;

    /** 提出时间 */
    @Column(name = "SBMT_TIME")
    Timestamp sbmtTime;

    /** 提出人 */
    @Column(name = "SBMT_USER_ID")
    String sbmtUserId;

    /** 提出科室 */
    @Column(name = "SBMT_DEPT_CD")
    String sbmtDeptCd;

    /** 整改要求 */
    @Column(name = "RFM_REQ")
    String rfmReq;

    /** 整改时间 */
    @Column(name = "RFM_TIME")
    Timestamp rfmTime;

    /** 整改人 */
    @Column(name = "RFM_USER_ID")
    String rfmUserId;

    /** 整改科室 */
    @Column(name = "RFM_DEPT_CD")
    String rfmDeptCd;

    /** 整改说明 */
    @Column(name = "RFM_DES")
    String rfmDes;

    /** 审核时间 */
    @Column(name = "VRF_TIME")
    Timestamp vrfTime;

    /** 审核人 */
    @Column(name = "VRF_USER_ID")
    String vrfUserId;

    /** 审核科室 */
    @Column(name = "VRF_DEPT_CD")
    String vrfDeptCd;

    /** 扣分说明 */
    @Column(name = "DRP_DES")
    String drpDes;

    /** 就诊序号 */
    @Column(name = "EN_PK")
    String enPk;

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

    /** 病历文书编码 */
    @Column(name = "MR_PK")
    String mrPk;

    /** 缺扣分次数 */
    @Column(name = "DEDUCT_SCR_TIMES")
    Integer deductScrTimes;

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
     * Returns the fltStaCd.
     * 
     * @return the fltStaCd
     */
    public String getFltStaCd() {
        return fltStaCd;
    }

    /** 
     * Sets the fltStaCd.
     * 
     * @param fltStaCd the fltStaCd
     */
    public void setFltStaCd(String fltStaCd) {
        this.fltStaCd = fltStaCd;
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
     * Returns the sbmtTime.
     * 
     * @return the sbmtTime
     */
    public Timestamp getSbmtTime() {
        return sbmtTime;
    }

    /** 
     * Sets the sbmtTime.
     * 
     * @param sbmtTime the sbmtTime
     */
    public void setSbmtTime(Timestamp sbmtTime) {
        this.sbmtTime = sbmtTime;
    }

    /** 
     * Returns the sbmtUserId.
     * 
     * @return the sbmtUserId
     */
    public String getSbmtUserId() {
        return sbmtUserId;
    }

    /** 
     * Sets the sbmtUserId.
     * 
     * @param sbmtUserId the sbmtUserId
     */
    public void setSbmtUserId(String sbmtUserId) {
        this.sbmtUserId = sbmtUserId;
    }

    /** 
     * Returns the sbmtDeptCd.
     * 
     * @return the sbmtDeptCd
     */
    public String getSbmtDeptCd() {
        return sbmtDeptCd;
    }

    /** 
     * Sets the sbmtDeptCd.
     * 
     * @param sbmtDeptCd the sbmtDeptCd
     */
    public void setSbmtDeptCd(String sbmtDeptCd) {
        this.sbmtDeptCd = sbmtDeptCd;
    }

    /** 
     * Returns the rfmReq.
     * 
     * @return the rfmReq
     */
    public String getRfmReq() {
        return rfmReq;
    }

    /** 
     * Sets the rfmReq.
     * 
     * @param rfmReq the rfmReq
     */
    public void setRfmReq(String rfmReq) {
        this.rfmReq = rfmReq;
    }

    /** 
     * Returns the rfmTime.
     * 
     * @return the rfmTime
     */
    public Timestamp getRfmTime() {
        return rfmTime;
    }

    /** 
     * Sets the rfmTime.
     * 
     * @param rfmTime the rfmTime
     */
    public void setRfmTime(Timestamp rfmTime) {
        this.rfmTime = rfmTime;
    }

    /** 
     * Returns the rfmUserId.
     * 
     * @return the rfmUserId
     */
    public String getRfmUserId() {
        return rfmUserId;
    }

    /** 
     * Sets the rfmUserId.
     * 
     * @param rfmUserId the rfmUserId
     */
    public void setRfmUserId(String rfmUserId) {
        this.rfmUserId = rfmUserId;
    }

    /** 
     * Returns the rfmDeptCd.
     * 
     * @return the rfmDeptCd
     */
    public String getRfmDeptCd() {
        return rfmDeptCd;
    }

    /** 
     * Sets the rfmDeptCd.
     * 
     * @param rfmDeptCd the rfmDeptCd
     */
    public void setRfmDeptCd(String rfmDeptCd) {
        this.rfmDeptCd = rfmDeptCd;
    }

    /** 
     * Returns the rfmDes.
     * 
     * @return the rfmDes
     */
    public String getRfmDes() {
        return rfmDes;
    }

    /** 
     * Sets the rfmDes.
     * 
     * @param rfmDes the rfmDes
     */
    public void setRfmDes(String rfmDes) {
        this.rfmDes = rfmDes;
    }

    /** 
     * Returns the vrfTime.
     * 
     * @return the vrfTime
     */
    public Timestamp getVrfTime() {
        return vrfTime;
    }

    /** 
     * Sets the vrfTime.
     * 
     * @param vrfTime the vrfTime
     */
    public void setVrfTime(Timestamp vrfTime) {
        this.vrfTime = vrfTime;
    }

    /** 
     * Returns the vrfUserId.
     * 
     * @return the vrfUserId
     */
    public String getVrfUserId() {
        return vrfUserId;
    }

    /** 
     * Sets the vrfUserId.
     * 
     * @param vrfUserId the vrfUserId
     */
    public void setVrfUserId(String vrfUserId) {
        this.vrfUserId = vrfUserId;
    }

    /** 
     * Returns the vrfDeptCd.
     * 
     * @return the vrfDeptCd
     */
    public String getVrfDeptCd() {
        return vrfDeptCd;
    }

    /** 
     * Sets the vrfDeptCd.
     * 
     * @param vrfDeptCd the vrfDeptCd
     */
    public void setVrfDeptCd(String vrfDeptCd) {
        this.vrfDeptCd = vrfDeptCd;
    }

    /** 
     * Returns the drpDes.
     * 
     * @return the drpDes
     */
    public String getDrpDes() {
        return drpDes;
    }

    /** 
     * Sets the drpDes.
     * 
     * @param drpDes the drpDes
     */
    public void setDrpDes(String drpDes) {
        this.drpDes = drpDes;
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
     * Returns the deductScrTimes.
     * 
     * @return the deductScrTimes
     */
    public Integer getDeductScrTimes() {
        return deductScrTimes;
    }

    /** 
     * Sets the deductScrTimes.
     * 
     * @param deductScrTimes the deductScrTimes
     */
    public void setDeductScrTimes(Integer deductScrTimes) {
        this.deductScrTimes = deductScrTimes;
    }
}