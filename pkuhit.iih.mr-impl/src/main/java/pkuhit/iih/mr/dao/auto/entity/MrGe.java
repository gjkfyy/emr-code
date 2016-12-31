package pkuhit.iih.mr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MrGeListener.class)
@Table(name = "MR_GE")
public class MrGe {

    /** */
    @Id
    @Column(name = "MR_GE_CD")
    String mrGeCd;

    /** */
    @Column(name = "ORG_CD")
    String orgCd;

    /** */
    @Column(name = "FILE_PK")
    String filePk;

    /** */
    @Column(name = "MR_GE_CCAT_CD")
    String mrGeCcatCd;

    /** */
    @Column(name = "RT_MR_EG_CD")
    String rtMrEgCd;

    /** */
    @Column(name = "VER_NO")
    BigInteger verNo;

    /** */
    @Column(name = "MR_GE_TP_CD")
    String mrGeTpCd;

    /** */
    @Column(name = "MR_GE_STA_CD")
    String mrGeStaCd;

    /** */
    @Column(name = "NM")
    String nm;

    /** */
    @Column(name = "DES")
    String des;

    /** */
    @Column(name = "OWN_TP_CD")
    String ownTpCd;

    /** */
    @Column(name = "OWN_CD")
    String ownCd;

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
    @Column(name = "RLS_TIME")
    Timestamp rlsTime;

    /** */
    @Column(name = "RLS_USER_ID")
    String rlsUserId;

    /** */
    @Column(name = "RLS_DEPT_CD")
    String rlsDeptCd;

    /** 
     * Returns the mrGeCd.
     * 
     * @return the mrGeCd
     */
    public String getMrGeCd() {
        return mrGeCd;
    }

    /** 
     * Sets the mrGeCd.
     * 
     * @param mrGeCd the mrGeCd
     */
    public void setMrGeCd(String mrGeCd) {
        this.mrGeCd = mrGeCd;
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
     * Returns the filePk.
     * 
     * @return the filePk
     */
    public String getFilePk() {
        return filePk;
    }

    /** 
     * Sets the filePk.
     * 
     * @param filePk the filePk
     */
    public void setFilePk(String filePk) {
        this.filePk = filePk;
    }

    /** 
     * Returns the mrGeCcatCd.
     * 
     * @return the mrGeCcatCd
     */
    public String getMrGeCcatCd() {
        return mrGeCcatCd;
    }

    /** 
     * Sets the mrGeCcatCd.
     * 
     * @param mrGeCcatCd the mrGeCcatCd
     */
    public void setMrGeCcatCd(String mrGeCcatCd) {
        this.mrGeCcatCd = mrGeCcatCd;
    }

    /** 
     * Returns the rtMrEgCd.
     * 
     * @return the rtMrEgCd
     */
    public String getRtMrEgCd() {
        return rtMrEgCd;
    }

    /** 
     * Sets the rtMrEgCd.
     * 
     * @param rtMrEgCd the rtMrEgCd
     */
    public void setRtMrEgCd(String rtMrEgCd) {
        this.rtMrEgCd = rtMrEgCd;
    }

    /** 
     * Returns the verNo.
     * 
     * @return the verNo
     */
    public BigInteger getVerNo() {
        return verNo;
    }

    /** 
     * Sets the verNo.
     * 
     * @param verNo the verNo
     */
    public void setVerNo(BigInteger verNo) {
        this.verNo = verNo;
    }

    /** 
     * Returns the mrGeTpCd.
     * 
     * @return the mrGeTpCd
     */
    public String getMrGeTpCd() {
        return mrGeTpCd;
    }

    /** 
     * Sets the mrGeTpCd.
     * 
     * @param mrGeTpCd the mrGeTpCd
     */
    public void setMrGeTpCd(String mrGeTpCd) {
        this.mrGeTpCd = mrGeTpCd;
    }

    /** 
     * Returns the mrGeStaCd.
     * 
     * @return the mrGeStaCd
     */
    public String getMrGeStaCd() {
        return mrGeStaCd;
    }

    /** 
     * Sets the mrGeStaCd.
     * 
     * @param mrGeStaCd the mrGeStaCd
     */
    public void setMrGeStaCd(String mrGeStaCd) {
        this.mrGeStaCd = mrGeStaCd;
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
     * Returns the des.
     * 
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /** 
     * Sets the des.
     * 
     * @param des the des
     */
    public void setDes(String des) {
        this.des = des;
    }

    /** 
     * Returns the ownTpCd.
     * 
     * @return the ownTpCd
     */
    public String getOwnTpCd() {
        return ownTpCd;
    }

    /** 
     * Sets the ownTpCd.
     * 
     * @param ownTpCd the ownTpCd
     */
    public void setOwnTpCd(String ownTpCd) {
        this.ownTpCd = ownTpCd;
    }

    /** 
     * Returns the ownCd.
     * 
     * @return the ownCd
     */
    public String getOwnCd() {
        return ownCd;
    }

    /** 
     * Sets the ownCd.
     * 
     * @param ownCd the ownCd
     */
    public void setOwnCd(String ownCd) {
        this.ownCd = ownCd;
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
     * Returns the rlsTime.
     * 
     * @return the rlsTime
     */
    public Timestamp getRlsTime() {
        return rlsTime;
    }

    /** 
     * Sets the rlsTime.
     * 
     * @param rlsTime the rlsTime
     */
    public void setRlsTime(Timestamp rlsTime) {
        this.rlsTime = rlsTime;
    }

    /** 
     * Returns the rlsUserId.
     * 
     * @return the rlsUserId
     */
    public String getRlsUserId() {
        return rlsUserId;
    }

    /** 
     * Sets the rlsUserId.
     * 
     * @param rlsUserId the rlsUserId
     */
    public void setRlsUserId(String rlsUserId) {
        this.rlsUserId = rlsUserId;
    }

    /** 
     * Returns the rlsDeptCd.
     * 
     * @return the rlsDeptCd
     */
    public String getRlsDeptCd() {
        return rlsDeptCd;
    }

    /** 
     * Sets the rlsDeptCd.
     * 
     * @param rlsDeptCd the rlsDeptCd
     */
    public void setRlsDeptCd(String rlsDeptCd) {
        this.rlsDeptCd = rlsDeptCd;
    }
}