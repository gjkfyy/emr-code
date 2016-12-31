package iih.kr.db.gen.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 组套诊断关系表
 */
@Entity(listener = DiSuiteDiEntityListener.class)
@Table(name = "DI_SUITE_DI")
public class DiSuiteDiEntity {

    /** 主键 */
    @Id
    @Column(name = "DI_SUITE_DI_CD")
    String diSuiteDiCd;

    /** 诊断编码 */
    @Column(name = "DI_CD")
    String diCd;

    /** 注释 */
    @Column(name = "MEMO")
    String memo;

    /** 顺序号 */
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

    /** 组套分类主键 */
    @Column(name = "DI_SUITE_TP_CD")
    String diSuiteTpCd;

    /** 组套主键 */
    @Column(name = "DI_SUITE_CD")
    String diSuiteCd;

    /** 关联诊断编码 */
    @Column(name = "REL_DI_CD")
    String relDiCd;

    /** 关联诊断名称 */
    @Column(name = "REL_DI_NM")
    String relDiNm;

    /** 关联诊断icd编码 */
    @Column(name = "REL_DI_ICD")
    String relDiIcd;

    /** 所属类型编码 */
    @Column(name = "OWNER_TYPE_CD")
    String ownerTypeCode;

    /** 所属编码 */
    @Column(name = "OWNER_CD")
    String ownerCode;

    /** 所属名称 */
    @Column(name = "OWNER_NM")
    String ownerName;

    /** 诊断名称 */
    @Column(name = "DI_NM")
    String diNm;

    /** " ENM01.01 门诊,ENM01.02	急诊,ENM01.03	留观,ENM01.04		住院 , ENM01.05		体检" */
    @Column(name = "EN_TP_CD")
    String enTypeCode;
    
    public String getEnTypeCode() {
		return enTypeCode;
	}

	public void setEnTypeCode(String enTypeCode) {
		this.enTypeCode = enTypeCode;
	}

	/** 
     * Returns the diSuiteDiCd.
     * 
     * @return the diSuiteDiCd
     */
    public String getDiSuiteDiCd() {
        return diSuiteDiCd;
    }

    /** 
     * Sets the diSuiteDiCd.
     * 
     * @param diSuiteDiCd the diSuiteDiCd
     */
    public void setDiSuiteDiCd(String diSuiteDiCd) {
        this.diSuiteDiCd = diSuiteDiCd;
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
     * Returns the relDiCd.
     * 
     * @return the relDiCd
     */
    public String getRelDiCd() {
        return relDiCd;
    }

    /** 
     * Sets the relDiCd.
     * 
     * @param relDiCd the relDiCd
     */
    public void setRelDiCd(String relDiCd) {
        this.relDiCd = relDiCd;
    }

    /** 
     * Returns the relDiNm.
     * 
     * @return the relDiNm
     */
    public String getRelDiNm() {
        return relDiNm;
    }

    /** 
     * Sets the relDiNm.
     * 
     * @param relDiNm the relDiNm
     */
    public void setRelDiNm(String relDiNm) {
        this.relDiNm = relDiNm;
    }

    /** 
     * Returns the relDiIcd.
     * 
     * @return the relDiIcd
     */
    public String getRelDiIcd() {
        return relDiIcd;
    }

    /** 
     * Sets the relDiIcd.
     * 
     * @param relDiIcd the relDiIcd
     */
    public void setRelDiIcd(String relDiIcd) {
        this.relDiIcd = relDiIcd;
    }

    /** 
     * Returns the ownerTypeCode.
     * 
     * @return the ownerTypeCode
     */
    public String getOwnerTypeCode() {
        return ownerTypeCode;
    }

    /** 
     * Sets the ownerTypeCode.
     * 
     * @param ownerTypeCode the ownerTypeCode
     */
    public void setOwnerTypeCode(String ownerTypeCode) {
        this.ownerTypeCode = ownerTypeCode;
    }

    /** 
     * Returns the ownerCode.
     * 
     * @return the ownerCode
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /** 
     * Sets the ownerCode.
     * 
     * @param ownerCode the ownerCode
     */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    /** 
     * Returns the ownerName.
     * 
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /** 
     * Sets the ownerName.
     * 
     * @param ownerName the ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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