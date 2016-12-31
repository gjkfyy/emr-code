package pkuhit.me.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MeObjAttrListener.class)
@Table(name = "ME_OBJ_ATTR")
public class MeObjAttr {

    /** */
    @Id
    @Column(name = "OBJ_ATTR_CD")
    String objAttrCd;

    /** */
    @Column(name = "OBJ_CD")
    String objCd;

    /** */
    @Column(name = "FK_OBJ_CD")
    String fkObjCd;

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
    @Column(name = "DT_TP_CD")
    String dtTpCd;

    /** */
    @Column(name = "UNIT_CD")
    String unitCd;

    /** */
    @Column(name = "LEN")
    BigInteger len;

    /** */
    @Column(name = "PREC")
    BigInteger prec;

    /** */
    @Column(name = "MIN_VAL")
    String minVal;

    /** */
    @Column(name = "MAX_VAL")
    String maxVal;

    /** */
    @Column(name = "DFT_VAL")
    String dftVal;

    /** */
    @Column(name = "ALIGN_CD")
    String alignCd;

    /** */
    @Column(name = "NM_CACHE_F")
    Short nmCacheF;

    /** */
    @Column(name = "UPPER_F")
    Short upperF;

    /** */
    @Column(name = "LOWER_F")
    Short lowerF;

    /** */
    @Column(name = "PK_F")
    Short pkF;

    /** */
    @Column(name = "FK_F")
    Short fkF;

    /** */
    @Column(name = "NN_F")
    Short nnF;

    /** */
    @Column(name = "UN_F")
    Short unF;

    /** */
    @Column(name = "IN_F")
    Short inF;

    /** */
    @Column(name = "PERS_F")
    Short persF;

    /** */
    @Column(name = "SECU_F")
    Short secuF;

    /** */
    @Column(name = "STA_AU_F")
    Short staAuF;

    /** */
    @Column(name = "VALI_RULE")
    String valiRule;

    /** */
    @Column(name = "SHW_FMT")
    String shwFmt;

    /** */
    @Column(name = "EDIT_HIGHT")
    BigInteger editHight;

    /** */
    @Column(name = "EDIT_WIDTH")
    BigInteger editWidth;

    /** */
    @Column(name = "GRID_COL_WIDTH")
    BigInteger gridColWidth;

    /** */
    @Column(name = "TIP_MSG_CD")
    String tipMsgCd;

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
     * Returns the fkObjCd.
     * 
     * @return the fkObjCd
     */
    public String getFkObjCd() {
        return fkObjCd;
    }

    /** 
     * Sets the fkObjCd.
     * 
     * @param fkObjCd the fkObjCd
     */
    public void setFkObjCd(String fkObjCd) {
        this.fkObjCd = fkObjCd;
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
     * Returns the unitCd.
     * 
     * @return the unitCd
     */
    public String getUnitCd() {
        return unitCd;
    }

    /** 
     * Sets the unitCd.
     * 
     * @param unitCd the unitCd
     */
    public void setUnitCd(String unitCd) {
        this.unitCd = unitCd;
    }

    /** 
     * Returns the len.
     * 
     * @return the len
     */
    public BigInteger getLen() {
        return len;
    }

    /** 
     * Sets the len.
     * 
     * @param len the len
     */
    public void setLen(BigInteger len) {
        this.len = len;
    }

    /** 
     * Returns the prec.
     * 
     * @return the prec
     */
    public BigInteger getPrec() {
        return prec;
    }

    /** 
     * Sets the prec.
     * 
     * @param prec the prec
     */
    public void setPrec(BigInteger prec) {
        this.prec = prec;
    }

    /** 
     * Returns the minVal.
     * 
     * @return the minVal
     */
    public String getMinVal() {
        return minVal;
    }

    /** 
     * Sets the minVal.
     * 
     * @param minVal the minVal
     */
    public void setMinVal(String minVal) {
        this.minVal = minVal;
    }

    /** 
     * Returns the maxVal.
     * 
     * @return the maxVal
     */
    public String getMaxVal() {
        return maxVal;
    }

    /** 
     * Sets the maxVal.
     * 
     * @param maxVal the maxVal
     */
    public void setMaxVal(String maxVal) {
        this.maxVal = maxVal;
    }

    /** 
     * Returns the dftVal.
     * 
     * @return the dftVal
     */
    public String getDftVal() {
        return dftVal;
    }

    /** 
     * Sets the dftVal.
     * 
     * @param dftVal the dftVal
     */
    public void setDftVal(String dftVal) {
        this.dftVal = dftVal;
    }

    /** 
     * Returns the alignCd.
     * 
     * @return the alignCd
     */
    public String getAlignCd() {
        return alignCd;
    }

    /** 
     * Sets the alignCd.
     * 
     * @param alignCd the alignCd
     */
    public void setAlignCd(String alignCd) {
        this.alignCd = alignCd;
    }

    /** 
     * Returns the nmCacheF.
     * 
     * @return the nmCacheF
     */
    public Short getNmCacheF() {
        return nmCacheF;
    }

    /** 
     * Sets the nmCacheF.
     * 
     * @param nmCacheF the nmCacheF
     */
    public void setNmCacheF(Short nmCacheF) {
        this.nmCacheF = nmCacheF;
    }

    /** 
     * Returns the upperF.
     * 
     * @return the upperF
     */
    public Short getUpperF() {
        return upperF;
    }

    /** 
     * Sets the upperF.
     * 
     * @param upperF the upperF
     */
    public void setUpperF(Short upperF) {
        this.upperF = upperF;
    }

    /** 
     * Returns the lowerF.
     * 
     * @return the lowerF
     */
    public Short getLowerF() {
        return lowerF;
    }

    /** 
     * Sets the lowerF.
     * 
     * @param lowerF the lowerF
     */
    public void setLowerF(Short lowerF) {
        this.lowerF = lowerF;
    }

    /** 
     * Returns the pkF.
     * 
     * @return the pkF
     */
    public Short getPkF() {
        return pkF;
    }

    /** 
     * Sets the pkF.
     * 
     * @param pkF the pkF
     */
    public void setPkF(Short pkF) {
        this.pkF = pkF;
    }

    /** 
     * Returns the fkF.
     * 
     * @return the fkF
     */
    public Short getFkF() {
        return fkF;
    }

    /** 
     * Sets the fkF.
     * 
     * @param fkF the fkF
     */
    public void setFkF(Short fkF) {
        this.fkF = fkF;
    }

    /** 
     * Returns the nnF.
     * 
     * @return the nnF
     */
    public Short getNnF() {
        return nnF;
    }

    /** 
     * Sets the nnF.
     * 
     * @param nnF the nnF
     */
    public void setNnF(Short nnF) {
        this.nnF = nnF;
    }

    /** 
     * Returns the unF.
     * 
     * @return the unF
     */
    public Short getUnF() {
        return unF;
    }

    /** 
     * Sets the unF.
     * 
     * @param unF the unF
     */
    public void setUnF(Short unF) {
        this.unF = unF;
    }

    /** 
     * Returns the inF.
     * 
     * @return the inF
     */
    public Short getInF() {
        return inF;
    }

    /** 
     * Sets the inF.
     * 
     * @param inF the inF
     */
    public void setInF(Short inF) {
        this.inF = inF;
    }

    /** 
     * Returns the persF.
     * 
     * @return the persF
     */
    public Short getPersF() {
        return persF;
    }

    /** 
     * Sets the persF.
     * 
     * @param persF the persF
     */
    public void setPersF(Short persF) {
        this.persF = persF;
    }

    /** 
     * Returns the secuF.
     * 
     * @return the secuF
     */
    public Short getSecuF() {
        return secuF;
    }

    /** 
     * Sets the secuF.
     * 
     * @param secuF the secuF
     */
    public void setSecuF(Short secuF) {
        this.secuF = secuF;
    }

    /** 
     * Returns the staAuF.
     * 
     * @return the staAuF
     */
    public Short getStaAuF() {
        return staAuF;
    }

    /** 
     * Sets the staAuF.
     * 
     * @param staAuF the staAuF
     */
    public void setStaAuF(Short staAuF) {
        this.staAuF = staAuF;
    }

    /** 
     * Returns the valiRule.
     * 
     * @return the valiRule
     */
    public String getValiRule() {
        return valiRule;
    }

    /** 
     * Sets the valiRule.
     * 
     * @param valiRule the valiRule
     */
    public void setValiRule(String valiRule) {
        this.valiRule = valiRule;
    }

    /** 
     * Returns the shwFmt.
     * 
     * @return the shwFmt
     */
    public String getShwFmt() {
        return shwFmt;
    }

    /** 
     * Sets the shwFmt.
     * 
     * @param shwFmt the shwFmt
     */
    public void setShwFmt(String shwFmt) {
        this.shwFmt = shwFmt;
    }

    /** 
     * Returns the editHight.
     * 
     * @return the editHight
     */
    public BigInteger getEditHight() {
        return editHight;
    }

    /** 
     * Sets the editHight.
     * 
     * @param editHight the editHight
     */
    public void setEditHight(BigInteger editHight) {
        this.editHight = editHight;
    }

    /** 
     * Returns the editWidth.
     * 
     * @return the editWidth
     */
    public BigInteger getEditWidth() {
        return editWidth;
    }

    /** 
     * Sets the editWidth.
     * 
     * @param editWidth the editWidth
     */
    public void setEditWidth(BigInteger editWidth) {
        this.editWidth = editWidth;
    }

    /** 
     * Returns the gridColWidth.
     * 
     * @return the gridColWidth
     */
    public BigInteger getGridColWidth() {
        return gridColWidth;
    }

    /** 
     * Sets the gridColWidth.
     * 
     * @param gridColWidth the gridColWidth
     */
    public void setGridColWidth(BigInteger gridColWidth) {
        this.gridColWidth = gridColWidth;
    }

    /** 
     * Returns the tipMsgCd.
     * 
     * @return the tipMsgCd
     */
    public String getTipMsgCd() {
        return tipMsgCd;
    }

    /** 
     * Sets the tipMsgCd.
     * 
     * @param tipMsgCd the tipMsgCd
     */
    public void setTipMsgCd(String tipMsgCd) {
        this.tipMsgCd = tipMsgCd;
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