package iih.kr.db.gen.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 组套模板关系表
 */
@Entity(listener = DiSuiteTemplateEntityListener.class)
@Table(name = "DI_SUITE_TEMPLATE")
public class DiSuiteTemplateEntity {

    /** 主键 */
    @Id
    @Column(name = "DI_SUITE_TEMPLATE_CD")
    String diSuiteTemplateCd;

    /** 组套编码 */
    @Column(name = "DI_SUITE_CD")
    String diSuiteCd;

    /** 模板编码 */
    @Column(name = "MR_TEMPLATE_CD")
    String mrTemplateCd;

    /** 诊断编码 */
    @Column(name = "DI_CD")
    String diCd;

    /** " ENM01.01 门诊,ENM01.02	急诊,ENM01.03	留观,ENM01.04		住院 , ENM01.05		体检" */
    @Column(name = "EN_TP_CD")
    String enTypeCode;
    
    
    /** */
    @Column(name = "MEMO")
    String memo;

    /** */
    @Column(name = "SORT_NO")
    Integer sortNo;

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

    /** 组套分类编码 */
    @Column(name = "DI_SUITE_TP_CD")
    String diSuiteTpCd;

    /** 模板名称 */
    @Column(name = "MR_TEMPLATE_NM")
    String mrTemplateNm;

    /** 所属类型编码 */
    @Column(name = "OWNER_TYPE_CD")
    String ownerTypeCd;

    /** 所属编码 */
    @Column(name = "OWNER_CD")
    String ownerCd;

    /** 所属名称 */
    @Column(name = "OWNER_NM")
    String ownerNm;

    /** 诊断名称 */
    @Column(name = "DI_NM")
    String diNm;
    
    /** 
     * Returns the diSuiteTemplateCd.
     * 
     * @return the diSuiteTemplateCd
     */
    public String getDiSuiteTemplateCd() {
        return diSuiteTemplateCd;
    }

    /** 
     * Sets the diSuiteTemplateCd.
     * 
     * @param diSuiteTemplateCd the diSuiteTemplateCd
     */
    public void setDiSuiteTemplateCd(String diSuiteTemplateCd) {
        this.diSuiteTemplateCd = diSuiteTemplateCd;
    }

    /** 
     * Returns the diSuiteCd.
     * 
     * @return the diSuiteCd
     */
    public String getDiSuiteCd() {
        return diSuiteCd;
    }

    /** 
     * Sets the diSuiteCd.
     * 
     * @param diSuiteCd the diSuiteCd
     */
    public void setDiSuiteCd(String diSuiteCd) {
        this.diSuiteCd = diSuiteCd;
    }

    /** 
     * Returns the mrTemplateCd.
     * 
     * @return the mrTemplateCd
     */
    public String getMrTemplateCd() {
        return mrTemplateCd;
    }

    /** 
     * Sets the mrTemplateCd.
     * 
     * @param mrTemplateCd the mrTemplateCd
     */
    public void setMrTemplateCd(String mrTemplateCd) {
        this.mrTemplateCd = mrTemplateCd;
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
    public Integer getSortNo() {
        return sortNo;
    }

    /** 
     * Sets the sortNo.
     * 
     * @param sortNo the sortNo
     */
    public void setSortNo(Integer sortNo) {
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

    public String getEnTypeCode() {
		return enTypeCode;
	}

	public void setEnTypeCode(String enTypeCode) {
		this.enTypeCode = enTypeCode;
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
     * Returns the diSuiteTpCd.
     * 
     * @return the diSuiteTpCd
     */
    public String getDiSuiteTpCd() {
        return diSuiteTpCd;
    }

    /** 
     * Sets the diSuiteTpCd.
     * 
     * @param diSuiteTpCd the diSuiteTpCd
     */
    public void setDiSuiteTpCd(String diSuiteTpCd) {
        this.diSuiteTpCd = diSuiteTpCd;
    }

    /** 
     * Returns the mrTemplateNm.
     * 
     * @return the mrTemplateNm
     */
    public String getMrTemplateNm() {
        return mrTemplateNm;
    }

    /** 
     * Sets the mrTemplateNm.
     * 
     * @param mrTemplateNm the mrTemplateNm
     */
    public void setMrTemplateNm(String mrTemplateNm) {
        this.mrTemplateNm = mrTemplateNm;
    }

    /** 
     * Returns the ownerTypeCd.
     * 
     * @return the ownerTypeCd
     */
    public String getOwnerTypeCd() {
        return ownerTypeCd;
    }

    /** 
     * Sets the ownerTypeCd.
     * 
     * @param ownerTypeCd the ownerTypeCd
     */
    public void setOwnerTypeCd(String ownerTypeCd) {
        this.ownerTypeCd = ownerTypeCd;
    }

    /** 
     * Returns the ownerCd.
     * 
     * @return the ownerCd
     */
    public String getOwnerCd() {
        return ownerCd;
    }

    /** 
     * Sets the ownerCd.
     * 
     * @param ownerCd the ownerCd
     */
    public void setOwnerCd(String ownerCd) {
        this.ownerCd = ownerCd;
    }

    /** 
     * Returns the ownerNm.
     * 
     * @return the ownerNm
     */
    public String getOwnerNm() {
        return ownerNm;
    }

    /** 
     * Sets the ownerNm.
     * 
     * @param ownerNm the ownerNm
     */
    public void setOwnerNm(String ownerNm) {
        this.ownerNm = ownerNm;
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
}