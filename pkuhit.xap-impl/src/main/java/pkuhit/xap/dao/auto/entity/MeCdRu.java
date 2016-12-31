package pkuhit.xap.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * ME_CD_RU
 */
@Entity(listener = MeCdRuListener.class)
@Table(name = "ME_CD_RU")
public class MeCdRu {

    /** */
    @Id
    @Column(name = "OBJ_ATTR_CD")
    String objAttrCd;

    /** */
    @Column(name = "ORG_CD")
    String orgCd;

    /** */
    @Column(name = "FST_MAX_CD")
    String fstMaxCd;

    /** */
    @Column(name = "SND_MAX_CD")
    String sndMaxCd;

    /** */
    @Column(name = "TRD_MAX_CD")
    String trdMaxCd;

    /** */
    @Column(name = "FST_FMT")
    String fstFmt;

    /** */
    @Column(name = "SND_FMT")
    String sndFmt;

    /** */
    @Column(name = "TRD_FMT")
    String trdFmt;

    /** */
    @Column(name = "FST_BIT")
    String fstBit;

    /** */
    @Column(name = "SND_BIT")
    String sndBit;

    /** */
    @Column(name = "TRD_BIT")
    String trdBit;

    /** */
    @Column(name = "MAX_LVL")
    String maxLvl;

    /** */
    @Column(name = "PREFIX")
    String prefix;

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
     * Returns the orgCd.
     * 
     * @return the orgCd
     */
    public String getOrgCd() {
        return orgCd;
    }

    /** 
     * Sets the orgCd.
     * 
     * @param orgCd the orgCd
     */
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    /** 
     * Returns the fstMaxCd.
     * 
     * @return the fstMaxCd
     */
    public String getFstMaxCd() {
        return fstMaxCd;
    }

    /** 
     * Sets the fstMaxCd.
     * 
     * @param fstMaxCd the fstMaxCd
     */
    public void setFstMaxCd(String fstMaxCd) {
        this.fstMaxCd = fstMaxCd;
    }

    /** 
     * Returns the sndMaxCd.
     * 
     * @return the sndMaxCd
     */
    public String getSndMaxCd() {
        return sndMaxCd;
    }

    /** 
     * Sets the sndMaxCd.
     * 
     * @param sndMaxCd the sndMaxCd
     */
    public void setSndMaxCd(String sndMaxCd) {
        this.sndMaxCd = sndMaxCd;
    }

    /** 
     * Returns the trdMaxCd.
     * 
     * @return the trdMaxCd
     */
    public String getTrdMaxCd() {
        return trdMaxCd;
    }

    /** 
     * Sets the trdMaxCd.
     * 
     * @param trdMaxCd the trdMaxCd
     */
    public void setTrdMaxCd(String trdMaxCd) {
        this.trdMaxCd = trdMaxCd;
    }

    /** 
     * Returns the fstFmt.
     * 
     * @return the fstFmt
     */
    public String getFstFmt() {
        return fstFmt;
    }

    /** 
     * Sets the fstFmt.
     * 
     * @param fstFmt the fstFmt
     */
    public void setFstFmt(String fstFmt) {
        this.fstFmt = fstFmt;
    }

    /** 
     * Returns the sndFmt.
     * 
     * @return the sndFmt
     */
    public String getSndFmt() {
        return sndFmt;
    }

    /** 
     * Sets the sndFmt.
     * 
     * @param sndFmt the sndFmt
     */
    public void setSndFmt(String sndFmt) {
        this.sndFmt = sndFmt;
    }

    /** 
     * Returns the trdFmt.
     * 
     * @return the trdFmt
     */
    public String getTrdFmt() {
        return trdFmt;
    }

    /** 
     * Sets the trdFmt.
     * 
     * @param trdFmt the trdFmt
     */
    public void setTrdFmt(String trdFmt) {
        this.trdFmt = trdFmt;
    }

    /** 
     * Returns the fstBit.
     * 
     * @return the fstBit
     */
    public String getFstBit() {
        return fstBit;
    }

    /** 
     * Sets the fstBit.
     * 
     * @param fstBit the fstBit
     */
    public void setFstBit(String fstBit) {
        this.fstBit = fstBit;
    }

    /** 
     * Returns the sndBit.
     * 
     * @return the sndBit
     */
    public String getSndBit() {
        return sndBit;
    }

    /** 
     * Sets the sndBit.
     * 
     * @param sndBit the sndBit
     */
    public void setSndBit(String sndBit) {
        this.sndBit = sndBit;
    }

    /** 
     * Returns the trdBit.
     * 
     * @return the trdBit
     */
    public String getTrdBit() {
        return trdBit;
    }

    /** 
     * Sets the trdBit.
     * 
     * @param trdBit the trdBit
     */
    public void setTrdBit(String trdBit) {
        this.trdBit = trdBit;
    }

    /** 
     * Returns the maxLvl.
     * 
     * @return the maxLvl
     */
    public String getMaxLvl() {
        return maxLvl;
    }

    /** 
     * Sets the maxLvl.
     * 
     * @param maxLvl the maxLvl
     */
    public void setMaxLvl(String maxLvl) {
        this.maxLvl = maxLvl;
    }

    /** 
     * Returns the prefix.
     * 
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /** 
     * Sets the prefix.
     * 
     * @param prefix the prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
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