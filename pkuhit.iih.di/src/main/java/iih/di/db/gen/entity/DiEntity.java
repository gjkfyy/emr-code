package iih.di.db.gen.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 诊断业务表
 */
@Entity(listener = DiEntityListener.class)
@Table(name = "DI")
public class DiEntity {

    /** 主键 */
    @Id
    @Column(name = "DI_SN")
    String diSn;

    /** */
    @Column(name = "EN_SN")
    String enSn;

    /** */
    @Column(name = "PAR_DI_SN")
    String parDiSn;

    /** */
    @Column(name = "ORG_CD")
    String orgCd;

    /** */
    @Column(name = "LVL")
    Short lvl;

    /** */
    @Column(name = "LVL1_SORT_NO")
    Short lvl1SortNo;

    /** */
    @Column(name = "LVL2_SORT_NO")
    Short lvl2SortNo;

    /** */
    @Column(name = "DI_CD")
    String diCd;

    /** 诊断名称 */
    @Column(name = "DI_NM")
    String diNm;

    /** ICD编码 */
    @Column(name = "ICD_CD")
    String icdCd;

    /** 补充说明 */
    @Column(name = "ADD_DESCR")
    String addDescr;

    /** 主诊断标志 */
    @Column(name = "MAIN_F")
    Short mainF;

    /** 疑似标志 */
    @Column(name = "UNCERTAIN_F")
    Short uncertainF;

    /** 状态。待处理、处理中、已处理 */
    @Column(name = "CONTAGION_F")
    Short contagionF;

    /** 治疗结果编码 */
    @Column(name = "TREAT_RESULT_CD")
    String treatResultCd;

    /** 就诊日期 */
    @Column(name = "DI_TIME")
    Timestamp diTime;

    /** 诊断医生编码 */
    @Column(name = "DI_EMP_ID")
    String diEmpId;

    /** 就诊科室编码 */
    @Column(name = "DI_DEPT_CD")
    String diDeptCd;

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

    
    @Column(name = "UPD_CNT")
    Integer updCnt; 

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

    /** 待查标志 */
    @Column(name = "UNKNOW_F")
    Short unknowF;

    /** 所属标志 */
    @Column(name = "SET_OWNER_TYPE_CD")
    String setOwnerTypeCd;

    /** 所属编码 */
    @Column(name = "SET_OWNER_CD")
    String setOwnerCd;

    /** 复制标志 */
    @Column(name = "COPY_FLAG")
    Short copyFlag;

    /** 
     * Returns the diSn.
     * 
     * @return the diSn
     */
    public String getDiSn() {
        return diSn;
    }

    /** 
     * Sets the diSn.
     * 
     * @param diSn the diSn
     */
    public void setDiSn(String diSn) {
        this.diSn = diSn;
    }

    /** 
     * Returns the enSn.
     * 
     * @return the enSn
     */
    public String getEnSn() {
        return enSn;
    }

    /** 
     * Sets the enSn.
     * 
     * @param enSn the enSn
     */
    public void setEnSn(String enSn) {
        this.enSn = enSn;
    }

    /** 
     * Returns the parDiSn.
     * 
     * @return the parDiSn
     */
    public String getParDiSn() {
        return parDiSn;
    }

    /** 
     * Sets the parDiSn.
     * 
     * @param parDiSn the parDiSn
     */
    public void setParDiSn(String parDiSn) {
        this.parDiSn = parDiSn;
    }

    /** 
     * Returns the ogrCd.
     * 
     * @return the ogrCd
     */
    public String getOrgCd() {
        return orgCd;
    }

    /** 
     * Sets the ogrCd.
     * 
     * @param ogrCd the ogrCd
     */
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    /** 
     * Returns the lvl.
     * 
     * @return the lvl
     */
    public Short getLvl() {
        return lvl;
    }

    /** 
     * Sets the lvl.
     * 
     * @param lvl the lvl
     */
    public void setLvl(Short lvl) {
        this.lvl = lvl;
    }

    /** 
     * Returns the lvl1SortNo.
     * 
     * @return the lvl1SortNo
     */
    public Short getLvl1SortNo() {
        return lvl1SortNo;
    }

    /** 
     * Sets the lvl1SortNo.
     * 
     * @param lvl1SortNo the lvl1SortNo
     */
    public void setLvl1SortNo(Short lvl1SortNo) {
        this.lvl1SortNo = lvl1SortNo;
    }

    /** 
     * Returns the lvl2SotrNo.
     * 
     * @return the lvl2SotrNo
     */
    public Short getLvl2SortNo() {
        return lvl2SortNo;
    }

    /** 
     * Sets the lvl2SotrNo.
     * 
     * @param lvl2SotrNo the lvl2SotrNo
     */
    public void setLvl2SortNo(Short lvl2SortNo) {
        this.lvl2SortNo = lvl2SortNo;
    }

    /** 
     * Returns the diCd.
     * 
     * @return the diCd
     */
    public String getDiCd() {
        return diCd;
    }

    /** 
     * Sets the diCd.
     * 
     * @param diCd the diCd
     */
    public void setDiCd(String diCd) {
        this.diCd = diCd;
    }

    /** 
     * Returns the diNm.
     * 
     * @return the diNm
     */
    public String getDiNm() {
        return diNm;
    }

    /** 
     * Sets the diNm.
     * 
     * @param diNm the diNm
     */
    public void setDiNm(String diNm) {
        this.diNm = diNm;
    }

    /** 
     * Returns the icdCd.
     * 
     * @return the icdCd
     */
    public String getIcdCd() {
        return icdCd;
    }

    /** 
     * Sets the icdCd.
     * 
     * @param icdCd the icdCd
     */
    public void setIcdCd(String icdCd) {
        this.icdCd = icdCd;
    }

    /** 
     * Returns the addDescr.
     * 
     * @return the addDescr
     */
    public String getAddDescr() {
        return addDescr;
    }

    /** 
     * Sets the addDescr.
     * 
     * @param addDescr the addDescr
     */
    public void setAddDescr(String addDescr) {
        this.addDescr = addDescr;
    }

    /** 
     * Returns the mainF.
     * 
     * @return the mainF
     */
    public Short getMainF() {
        return mainF;
    }

    /** 
     * Sets the mainF.
     * 
     * @param mainF the mainF
     */
    public void setMainF(Short mainF) {
        this.mainF = mainF;
    }

    /** 
     * Returns the uncertainF.
     * 
     * @return the uncertainF
     */
    public Short getUncertainF() {
        return uncertainF;
    }

    /** 
     * Sets the uncertainF.
     * 
     * @param uncertainF the uncertainF
     */
    public void setUncertainF(Short uncertainF) {
        this.uncertainF = uncertainF;
    }

    /** 
     * Returns the contagionF.
     * 
     * @return the contagionF
     */
    public Short getContagionF() {
        return contagionF;
    }

    /** 
     * Sets the contagionF.
     * 
     * @param contagionF the contagionF
     */
    public void setContagionF(Short contagionF) {
        this.contagionF = contagionF;
    }

    /** 
     * Returns the treatResultCd.
     * 
     * @return the treatResultCd
     */
    public String getTreatResultCd() {
        return treatResultCd;
    }

    /** 
     * Sets the treatResultCd.
     * 
     * @param treatResultCd the treatResultCd
     */
    public void setTreatResultCd(String treatResultCd) {
        this.treatResultCd = treatResultCd;
    }

    /** 
     * Returns the diTime.
     * 
     * @return the diTime
     */
    public Timestamp getDiTime() {
        return diTime;
    }

    /** 
     * Sets the diTime.
     * 
     * @param diTime the diTime
     */
    public void setDiTime(Timestamp diTime) {
        this.diTime = diTime;
    }

    /** 
     * Returns the diEmpId.
     * 
     * @return the diEmpId
     */
    public String getDiEmpId() {
        return diEmpId;
    }

    /** 
     * Sets the diEmpId.
     * 
     * @param diEmpId the diEmpId
     */
    public void setDiEmpId(String diEmpId) {
        this.diEmpId = diEmpId;
    }

    /** 
     * Returns the diDeptCd.
     * 
     * @return the diDeptCd
     */
    public String getDiDeptCd() {
        return diDeptCd;
    }

    /** 
     * Sets the diDeptCd.
     * 
     * @param diDeptCd the diDeptCd
     */
    public void setDiDeptCd(String diDeptCd) {
        this.diDeptCd = diDeptCd;
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
    public Integer getUpdCnt() {
        return updCnt;
    }

    /** 
     * Sets the updCnt.
     * 
     * @param updCnt the updCnt
     */
    public void setUpdCnt(Integer updCnt) {
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
     * Returns the unknowF.
     * 
     * @return the unknowF
     */
    public Short getUnknowF() {
        return unknowF;
    }

    /** 
     * Sets the unknowF.
     * 
     * @param unknowF the unknowF
     */
    public void setUnknowF(Short unknowF) {
        this.unknowF = unknowF;
    }

    /** 
     * Returns the setOwnerTypeCd.
     * 
     * @return the setOwnerTypeCd
     */
    public String getSetOwnerTypeCd() {
        return setOwnerTypeCd;
    }

    /** 
     * Sets the setOwnerTypeCd.
     * 
     * @param setOwnerTypeCd the setOwnerTypeCd
     */
    public void setSetOwnerTypeCd(String setOwnerTypeCd) {
        this.setOwnerTypeCd = setOwnerTypeCd;
    }

    /** 
     * Returns the setOwnerCd.
     * 
     * @return the setOwnerCd
     */
    public String getSetOwnerCd() {
        return setOwnerCd;
    }

    /** 
     * Sets the setOwnerCd.
     * 
     * @param setOwnerCd the setOwnerCd
     */
    public void setSetOwnerCd(String setOwnerCd) {
        this.setOwnerCd = setOwnerCd;
    }

    /** 
     * Returns the copyFlag.
     * 
     * @return the copyFlag
     */
    public Short getCopyFlag() {
        return copyFlag;
    }

    /** 
     * Sets the copyFlag.
     * 
     * @param copyFlag the copyFlag
     */
    public void setCopyFlag(Short copyFlag) {
        this.copyFlag = copyFlag;
    }
}