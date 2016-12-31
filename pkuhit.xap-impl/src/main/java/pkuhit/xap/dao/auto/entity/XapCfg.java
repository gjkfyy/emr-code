package pkuhit.xap.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * XAP_CFG
 */
@Entity(listener = XapCfgListener.class)
@Table(name = "XAP_CFG")
public class XapCfg {

    /** */
    @Id
    @Column(name = "CFG_CD")
    String cfgCd;

    /** 01：自由录入
02：单选
03：多选
04：范围 */
    @Column(name = "CFG_TP_CD")
    String cfgTpCd;

    /** */
    @Column(name = "CFG_CAT_CD")
    String cfgCatCd;

    /** */
    @Column(name = "NM")
    String nm;

    /** */
    @Column(name = "DES")
    String des;

    /** */
    @Column(name = "DT_TP_CD")
    String dtTpCd;

    /** */
    @Column(name = "DT_FMT")
    String dtFmt;

    /** */
    @Column(name = "OBJ_CD")
    String objCd;

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
     * Returns the cfgCd.
     * 
     * @return the cfgCd
     */
    public String getCfgCd() {
        return cfgCd;
    }

    /** 
     * Sets the cfgCd.
     * 
     * @param cfgCd the cfgCd
     */
    public void setCfgCd(String cfgCd) {
        this.cfgCd = cfgCd;
    }

    /** 
     * Returns the cfgTpCd.
     * 
     * @return the cfgTpCd
     */
    public String getCfgTpCd() {
        return cfgTpCd;
    }

    /** 
     * Sets the cfgTpCd.
     * 
     * @param cfgTpCd the cfgTpCd
     */
    public void setCfgTpCd(String cfgTpCd) {
        this.cfgTpCd = cfgTpCd;
    }

    /** 
     * Returns the cfgCatCd.
     * 
     * @return the cfgCatCd
     */
    public String getCfgCatCd() {
        return cfgCatCd;
    }

    /** 
     * Sets the cfgCatCd.
     * 
     * @param cfgCatCd the cfgCatCd
     */
    public void setCfgCatCd(String cfgCatCd) {
        this.cfgCatCd = cfgCatCd;
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
     * Returns the dtTpCd.
     * 
     * @return the dtTpCd
     */
    public String getDtTpCd() {
        return dtTpCd;
    }

    /** 
     * Sets the dtTpCd.
     * 
     * @param dtTpCd the dtTpCd
     */
    public void setDtTpCd(String dtTpCd) {
        this.dtTpCd = dtTpCd;
    }

    /** 
     * Returns the dtFmt.
     * 
     * @return the dtFmt
     */
    public String getDtFmt() {
        return dtFmt;
    }

    /** 
     * Sets the dtFmt.
     * 
     * @param dtFmt the dtFmt
     */
    public void setDtFmt(String dtFmt) {
        this.dtFmt = dtFmt;
    }

    /** 
     * Returns the objCd.
     * 
     * @return the objCd
     */
    public String getObjCd() {
        return objCd;
    }

    /** 
     * Sets the objCd.
     * 
     * @param objCd the objCd
     */
    public void setObjCd(String objCd) {
        this.objCd = objCd;
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