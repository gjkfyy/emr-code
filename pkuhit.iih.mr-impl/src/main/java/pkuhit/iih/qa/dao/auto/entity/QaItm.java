package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 质控项
 */
@Entity(listener = QaItmListener.class)
@Table(name = "QA_ITM")
public class QaItm {

    /** 主键 */
    @Id
    @Column(name = "QA_ITM_CD")
    String qaItmCd;

    /** 质控要求 */
    @Column(name = "REQ")
    String req;

    /** 质控扣分类型 */
    @Column(name = "QA_DRP_SCR_TP_CD")
    String qaDrpScrTpCd;

    /** 单次扣分值 */
    @Column(name = "ONCE_DRP_SCR")
    BigDecimal onceDrpScr;

    /** 累计最大扣分值 */
    @Column(name = "MAX_DRP_SCR")
    BigDecimal maxDrpScr;

    /** 默认整改标志 */
    @Column(name = "DFT_RFM_F")
    Short dftRfmF;

    /** 自动质控标志 */
    @Column(name = "AUTO_QA_F")
    Short autoQaF;

    /** 一级分类 */
    @Column(name = "FST_CD")
    String fstCd;

    /** 二级分类 */
    @Column(name = "SND_CD")
    String sndCd;

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

    /** 扣分说明 */
    @Column(name = "DEDUCT_DES")
    String deductDes;

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
     * Returns the qaDrpScrTpCd.
     * 
     * @return the qaDrpScrTpCd
     */
    public String getQaDrpScrTpCd() {
        return qaDrpScrTpCd;
    }

    /** 
     * Sets the qaDrpScrTpCd.
     * 
     * @param qaDrpScrTpCd the qaDrpScrTpCd
     */
    public void setQaDrpScrTpCd(String qaDrpScrTpCd) {
        this.qaDrpScrTpCd = qaDrpScrTpCd;
    }

    /** 
     * Returns the onceDrpScr.
     * 
     * @return the onceDrpScr
     */
    public BigDecimal getOnceDrpScr() {
        return onceDrpScr;
    }

    /** 
     * Sets the onceDrpScr.
     * 
     * @param onceDrpScr the onceDrpScr
     */
    public void setOnceDrpScr(BigDecimal onceDrpScr) {
        this.onceDrpScr = onceDrpScr;
    }

    /** 
     * Returns the maxDrpScr.
     * 
     * @return the maxDrpScr
     */
    public BigDecimal getMaxDrpScr() {
        return maxDrpScr;
    }

    /** 
     * Sets the maxDrpScr.
     * 
     * @param maxDrpScr the maxDrpScr
     */
    public void setMaxDrpScr(BigDecimal maxDrpScr) {
        this.maxDrpScr = maxDrpScr;
    }

    /** 
     * Returns the dftRfmF.
     * 
     * @return the dftRfmF
     */
    public Short getDftRfmF() {
        return dftRfmF;
    }

    /** 
     * Sets the dftRfmF.
     * 
     * @param dftRfmF the dftRfmF
     */
    public void setDftRfmF(Short dftRfmF) {
        this.dftRfmF = dftRfmF;
    }

    /** 
     * Returns the autoQaF.
     * 
     * @return the autoQaF
     */
    public Short getAutoQaF() {
        return autoQaF;
    }

    /** 
     * Sets the autoQaF.
     * 
     * @param autoQaF the autoQaF
     */
    public void setAutoQaF(Short autoQaF) {
        this.autoQaF = autoQaF;
    }

    /** 
     * Returns the fstCd.
     * 
     * @return the fstCd
     */
    public String getFstCd() {
        return fstCd;
    }

    /** 
     * Sets the fstCd.
     * 
     * @param fstCd the fstCd
     */
    public void setFstCd(String fstCd) {
        this.fstCd = fstCd;
    }

    /** 
     * Returns the sndCd.
     * 
     * @return the sndCd
     */
    public String getSndCd() {
        return sndCd;
    }

    /** 
     * Sets the sndCd.
     * 
     * @param sndCd the sndCd
     */
    public void setSndCd(String sndCd) {
        this.sndCd = sndCd;
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
     * Returns the deductDes.
     * 
     * @return the deductDes
     */
    public String getDeductDes() {
        return deductDes;
    }

    /** 
     * Sets the deductDes.
     * 
     * @param deductDes the deductDes
     */
    public void setDeductDes(String deductDes) {
        this.deductDes = deductDes;
    }
}