package iih.kr.db.gen.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 病历模板
 */
@Entity(listener = MrTplEntityListener.class)
@Table(name = "MR_TPL")
public class MrTplEntity {

    /** 主键 */
    @Id
    @Column(name = "MR_TPL_CD")
    String mrTplCd;

    /** 机构编码 */
    @Column(name = "ORG_CD")
    String orgCd;

    /** 基础模板编码 */
    @Column(name = "MR_BASE_TPL_CD")
    String mrBaseTplCd;

    /** 文件编码 */
    @Column(name = "FILE_PK")
    String filePk;

    /** 模板状态 */
    @Column(name = "MR_TPL_STA_CD")
    String mrTplStaCd;

    /** 名称 */
    @Column(name = "NM")
    String nm;

    /** 描述 */
    @Column(name = "DES")
    String des;

    /** 所属类型编码 */
    @Column(name = "OWN_TP_CD")
    String ownTpCd;

    /** 所属编码 */
    @Column(name = "OWN_CD")
    String ownCd;

    /** 医疗记录类型 */
    @Column(name = "MR_TP_CD")
    String mrTpCd;

    /** 审签级别 */
    @Column(name = "MR_SIGN_LVL_CD")
    String mrSignLvlCd;
    
    

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

    /** " ENM01.01 门诊,ENM01.02	急诊,ENM01.03	留观,ENM01.04		住院 , ENM01.05		体检" */
    @Column(name = "EN_TP_CD")
    String enTpCd;

    /** */
    @Column(name = "DEFAULT_F")
    Short defaultF;

    /** 
     * Returns the mrTplCd.
     * 
     * @return the mrTplCd
     */
    public String getMrTplCd() {
        return mrTplCd;
    }

    /** 
     * Sets the mrTplCd.
     * 
     * @param mrTplCd the mrTplCd
     */
    public void setMrTplCd(String mrTplCd) {
        this.mrTplCd = mrTplCd;
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
     * Returns the mrBaseTplCd.
     * 
     * @return the mrBaseTplCd
     */
    public String getMrBaseTplCd() {
        return mrBaseTplCd;
    }

    /** 
     * Sets the mrBaseTplCd.
     * 
     * @param mrBaseTplCd the mrBaseTplCd
     */
    public void setMrBaseTplCd(String mrBaseTplCd) {
        this.mrBaseTplCd = mrBaseTplCd;
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
     * Returns the mrTplStaCd.
     * 
     * @return the mrTplStaCd
     */
    public String getMrTplStaCd() {
        return mrTplStaCd;
    }

    /** 
     * Sets the mrTplStaCd.
     * 
     * @param mrTplStaCd the mrTplStaCd
     */
    public void setMrTplStaCd(String mrTplStaCd) {
        this.mrTplStaCd = mrTplStaCd;
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
     * Returns the mrTpCd.
     * 
     * @return the mrTpCd
     */
    public String getMrTpCd() {
        return mrTpCd;
    }

    /** 
     * Sets the mrTpCd.
     * 
     * @param mrTpCd the mrTpCd
     */
    public void setMrTpCd(String mrTpCd) {
        this.mrTpCd = mrTpCd;
    }

    /** 
     * Returns the mrSignLvlCd.
     * 
     * @return the mrSignLvlCd
     */
    public String getMrSignLvlCd() {
        return mrSignLvlCd;
    }

    /** 
     * Sets the mrSignLvlCd.
     * 
     * @param mrSignLvlCd the mrSignLvlCd
     */
    public void setMrSignLvlCd(String mrSignLvlCd) {
        this.mrSignLvlCd = mrSignLvlCd;
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
     * Returns the enTpCd.
     * 
     * @return the enTpCd
     */
    public String getEnTpCd() {
        return enTpCd;
    }

    /** 
     * Sets the enTpCd.
     * 
     * @param enTpCd the enTpCd
     */
    public void setEnTpCd(String enTpCd) {
        this.enTpCd = enTpCd;
    }

    /** 
     * Returns the defaultF.
     * 
     * @return the defaultF
     */
    public Short getDefaultF() {
        return defaultF;
    }

    /** 
     * Sets the defaultF.
     * 
     * @param defaultF the defaultF
     */
    public void setDefaultF(Short defaultF) {
        this.defaultF = defaultF;
    }
}