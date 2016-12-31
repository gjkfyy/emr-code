package pkuhit.me.dao.auto.entity;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MeXsvListener.class)
@Table(name = "ME_XSV")
public class MeXsv {

    /** */
    @Id
    @Column(name = "XSV_CD")
    String xsvCd;

    /** */
    @Column(name = "OBJ_CD")
    String objCd;

    /** */
    @Column(name = "RT_XSV_CD")
    String rtXsvCd;

    /** */
    @Column(name = "VER_NO")
    String verNo;

    /** */
    @Column(name = "NM")
    String nm;

    /** */
    @Column(name = "DES")
    String des;

    /** */
    @Column(name = "SHT_NM_EN")
    String shtNmEn;

    /** */
    @Column(name = "NM_EN")
    String nmEn;

    /** */
    @Column(name = "REST_ACT_CD")
    String restActCd;

    /** */
    @Column(name = "REST_RE")
    String restRe;

    /** */
    @Column(name = "AC_AU_F")
    Short acAuF;

    /** */
    @Column(name = "PFM_AU_F")
    Short pfmAuF;

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
    Short updCnt;

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
     * Returns the xsvCd.
     * 
     * @return the xsvCd
     */
    public String getXsvCd() {
        return xsvCd;
    }

    /** 
     * Sets the xsvCd.
     * 
     * @param xsvCd the xsvCd
     */
    public void setXsvCd(String xsvCd) {
        this.xsvCd = xsvCd;
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
     * Returns the rtXsvCd.
     * 
     * @return the rtXsvCd
     */
    public String getRtXsvCd() {
        return rtXsvCd;
    }

    /** 
     * Sets the rtXsvCd.
     * 
     * @param rtXsvCd the rtXsvCd
     */
    public void setRtXsvCd(String rtXsvCd) {
        this.rtXsvCd = rtXsvCd;
    }

    /** 
     * Returns the verNo.
     * 
     * @return the verNo
     */
    public String getVerNo() {
        return verNo;
    }

    /** 
     * Sets the verNo.
     * 
     * @param verNo the verNo
     */
    public void setVerNo(String verNo) {
        this.verNo = verNo;
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
     * Returns the shtNmEn.
     * 
     * @return the shtNmEn
     */
    public String getShtNmEn() {
        return shtNmEn;
    }

    /** 
     * Sets the shtNmEn.
     * 
     * @param shtNmEn the shtNmEn
     */
    public void setShtNmEn(String shtNmEn) {
        this.shtNmEn = shtNmEn;
    }

    /** 
     * Returns the nmEn.
     * 
     * @return the nmEn
     */
    public String getNmEn() {
        return nmEn;
    }

    /** 
     * Sets the nmEn.
     * 
     * @param nmEn the nmEn
     */
    public void setNmEn(String nmEn) {
        this.nmEn = nmEn;
    }

    /** 
     * Returns the restActCd.
     * 
     * @return the restActCd
     */
    public String getRestActCd() {
        return restActCd;
    }

    /** 
     * Sets the restActCd.
     * 
     * @param restActCd the restActCd
     */
    public void setRestActCd(String restActCd) {
        this.restActCd = restActCd;
    }

    /** 
     * Returns the restRe.
     * 
     * @return the restRe
     */
    public String getRestRe() {
        return restRe;
    }

    /** 
     * Sets the restRe.
     * 
     * @param restRe the restRe
     */
    public void setRestRe(String restRe) {
        this.restRe = restRe;
    }

    /** 
     * Returns the acAuF.
     * 
     * @return the acAuF
     */
    public Short getAcAuF() {
        return acAuF;
    }

    /** 
     * Sets the acAuF.
     * 
     * @param acAuF the acAuF
     */
    public void setAcAuF(Short acAuF) {
        this.acAuF = acAuF;
    }

    /** 
     * Returns the pfmAuF.
     * 
     * @return the pfmAuF
     */
    public Short getPfmAuF() {
        return pfmAuF;
    }

    /** 
     * Sets the pfmAuF.
     * 
     * @param pfmAuF the pfmAuF
     */
    public void setPfmAuF(Short pfmAuF) {
        this.pfmAuF = pfmAuF;
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
    public Short getUpdCnt() {
        return updCnt;
    }

    /** 
     * Sets the updCnt.
     * 
     * @param updCnt the updCnt
     */
    public void setUpdCnt(Short updCnt) {
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