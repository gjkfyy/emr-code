package pkuhit.me.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MeObjListener.class)
@Table(name = "ME_OBJ")
public class MeObj {

    /** */
    @Id
    @Column(name = "OBJ_CD")
    String objCd;

    /** */
    @Column(name = "PAR_OBJ_CD")
    String parObjCd;

    /** */
    @Column(name = "DO_CD")
    String doCd;

    /** */
    @Column(name = "RT_OBJ_CD")
    String rtObjCd;

    /** */
    @Column(name = "VER_NO")
    String verNo;

    /** */
    @Column(name = "OBJ_TP_CD")
    String objTpCd;

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
    @Column(name = "TAB_NM")
    String tabNm;

    /** */
    @Column(name = "COM_MD_F")
    Short comMdF;

    /** */
    @Column(name = "TAB_F")
    Short tabF;

    /** */
    @Column(name = "CACHE_F")
    Short cacheF;

    /** */
    @Column(name = "CONSTANT_F")
    Short constantF;

    /** */
    @Column(name = "PACKAGE_PATH")
    String packagePath;

    /** */
    @Column(name = "BASE_CLASS")
    String baseClass;

    /** */
    @Column(name = "MR_USE_F")
    Short mrUseF;

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
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;

    /** */
    @Column(name = "DEL_F")
    Short delF;

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
     * Returns the parObjCd.
     * 
     * @return the parObjCd
     */
    public String getParObjCd() {
        return parObjCd;
    }

    /** 
     * Sets the parObjCd.
     * 
     * @param parObjCd the parObjCd
     */
    public void setParObjCd(String parObjCd) {
        this.parObjCd = parObjCd;
    }

    /** 
     * Returns the doCd.
     * 
     * @return the doCd
     */
    public String getDoCd() {
        return doCd;
    }

    /** 
     * Sets the doCd.
     * 
     * @param doCd the doCd
     */
    public void setDoCd(String doCd) {
        this.doCd = doCd;
    }

    /** 
     * Returns the rtObjCd.
     * 
     * @return the rtObjCd
     */
    public String getRtObjCd() {
        return rtObjCd;
    }

    /** 
     * Sets the rtObjCd.
     * 
     * @param rtObjCd the rtObjCd
     */
    public void setRtObjCd(String rtObjCd) {
        this.rtObjCd = rtObjCd;
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
     * Returns the objTpCd.
     * 
     * @return the objTpCd
     */
    public String getObjTpCd() {
        return objTpCd;
    }

    /** 
     * Sets the objTpCd.
     * 
     * @param objTpCd the objTpCd
     */
    public void setObjTpCd(String objTpCd) {
        this.objTpCd = objTpCd;
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
     * Returns the tabNm.
     * 
     * @return the tabNm
     */
    public String getTabNm() {
        return tabNm;
    }

    /** 
     * Sets the tabNm.
     * 
     * @param tabNm the tabNm
     */
    public void setTabNm(String tabNm) {
        this.tabNm = tabNm;
    }

    /** 
     * Returns the comMdF.
     * 
     * @return the comMdF
     */
    public Short getComMdF() {
        return comMdF;
    }

    /** 
     * Sets the comMdF.
     * 
     * @param comMdF the comMdF
     */
    public void setComMdF(Short comMdF) {
        this.comMdF = comMdF;
    }

    /** 
     * Returns the tabF.
     * 
     * @return the tabF
     */
    public Short getTabF() {
        return tabF;
    }

    /** 
     * Sets the tabF.
     * 
     * @param tabF the tabF
     */
    public void setTabF(Short tabF) {
        this.tabF = tabF;
    }

    /** 
     * Returns the cacheF.
     * 
     * @return the cacheF
     */
    public Short getCacheF() {
        return cacheF;
    }

    /** 
     * Sets the cacheF.
     * 
     * @param cacheF the cacheF
     */
    public void setCacheF(Short cacheF) {
        this.cacheF = cacheF;
    }

    /** 
     * Returns the constantF.
     * 
     * @return the constantF
     */
    public Short getConstantF() {
        return constantF;
    }

    /** 
     * Sets the constantF.
     * 
     * @param constantF the constantF
     */
    public void setConstantF(Short constantF) {
        this.constantF = constantF;
    }

    /** 
     * Returns the packagePath.
     * 
     * @return the packagePath
     */
    public String getPackagePath() {
        return packagePath;
    }

    /** 
     * Sets the packagePath.
     * 
     * @param packagePath the packagePath
     */
    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    /** 
     * Returns the baseClass.
     * 
     * @return the baseClass
     */
    public String getBaseClass() {
        return baseClass;
    }

    /** 
     * Sets the baseClass.
     * 
     * @param baseClass the baseClass
     */
    public void setBaseClass(String baseClass) {
        this.baseClass = baseClass;
    }

    /** 
     * Returns the mrUseF.
     * 
     * @return the mrUseF
     */
    public Short getMrUseF() {
        return mrUseF;
    }

    /** 
     * Sets the mrUseF.
     * 
     * @param mrUseF the mrUseF
     */
    public void setMrUseF(Short mrUseF) {
        this.mrUseF = mrUseF;
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