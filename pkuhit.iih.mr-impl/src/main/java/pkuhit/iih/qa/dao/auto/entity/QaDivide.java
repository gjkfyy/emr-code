package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 质控评分表
 */
@Entity(listener = QaDivideListener.class)
@Table(name = "QA_DIVIDE")
public class QaDivide {

    /** 评分编码 */
    @Id
    @Column(name = "QA_DIVIDE_CD")
    String qaDivideCd;

    /** 质控项 */
    @Column(name = "QA_ITM_PK")
    String qaItmPk;

    /** 质控类型 */
    @Column(name = "QA_TY_CD")
    String qaTyCd;

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

    /** 扣分说明 */
    @Column(name = "DRP_DES")
    String drpDes;

    /** 就诊序号 */
    @Column(name = "EN_PK")
    String enPk;

    /** 缺扣分次数 */
    @Column(name = "DEDUCT_SCR_TIMES")
    Integer deductScrTimes;

    /** 最后得分 */
    @Column(name = "QA_SCR")
    Integer qaScr;

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
     * Returns the qaDivideCd.
     * 
     * @return the qaDivideCd
     */
    public String getQaDivideCd() {
        return qaDivideCd;
    }

    /** 
     * Sets the qaDivideCd.
     * 
     * @param qaDivideCd the qaDivideCd
     */
    public void setQaDivideCd(String qaDivideCd) {
        this.qaDivideCd = qaDivideCd;
    }

    /** 
     * Returns the qaItmPk.
     * 
     * @return the qaItmPk
     */
    public String getQaItmPk() {
        return qaItmPk;
    }

    /** 
     * Sets the qaItmPk.
     * 
     * @param qaItmPk the qaItmPk
     */
    public void setQaItmPk(String qaItmPk) {
        this.qaItmPk = qaItmPk;
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

    /** 
     * Returns the qaScr.
     * 
     * @return the qaScr
     */
    public Integer getQaScr() {
        return qaScr;
    }

    /** 
     * Sets the qaScr.
     * 
     * @param qaScr the qaScr
     */
    public void setQaScr(Integer qaScr) {
        this.qaScr = qaScr;
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