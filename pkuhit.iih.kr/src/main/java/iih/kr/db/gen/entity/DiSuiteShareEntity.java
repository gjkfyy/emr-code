package iih.kr.db.gen.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 组套共享配置表
 */
@Entity(listener = DiSuiteShareEntityListener.class)
@Table(name = "DI_SUITE_SHARE")
public class DiSuiteShareEntity {

    /** 主键 */
    @Id
    @Column(name = "DI_SUITE_SHARE_CD")
    String diSuiteShareCd;

    /** 共享源类型 */
    @Column(name = "OWNER_TYPE_CD")
    String ownerTypeCd;

    /** 共享源编码 */
    @Column(name = "OWNER_CD")
    String ownerCd;

    /** 共享源名称 */
    @Column(name = "SHARE_NM")
    String shareNm;

    /** 共享目标类型 */
    @Column(name = "TO_OWNER_TYPE_CD")
    String toOwnerTypeCd;

    /** 共享目标编码 */
    @Column(name = "TO_OWNER_CD")
    String toOwnerCd;

    /** 共享目标名称 */
    @Column(name = "TO_SHARE_NM")
    String toShareNm;

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

    /** 
     * Returns the diSuiteShareCd.
     * 
     * @return the diSuiteShareCd
     */
    public String getDiSuiteShareCd() {
        return diSuiteShareCd;
    }

    /** 
     * Sets the diSuiteShareCd.
     * 
     * @param diSuiteShareCd the diSuiteShareCd
     */
    public void setDiSuiteShareCd(String diSuiteShareCd) {
        this.diSuiteShareCd = diSuiteShareCd;
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
     * Returns the shareNm.
     * 
     * @return the shareNm
     */
    public String getShareNm() {
        return shareNm;
    }

    /** 
     * Sets the shareNm.
     * 
     * @param shareNm the shareNm
     */
    public void setShareNm(String shareNm) {
        this.shareNm = shareNm;
    }

    /** 
     * Returns the toOwnerTypeCd.
     * 
     * @return the toOwnerTypeCd
     */
    public String getToOwnerTypeCd() {
        return toOwnerTypeCd;
    }

    /** 
     * Sets the toOwnerTypeCd.
     * 
     * @param toOwnerTypeCd the toOwnerTypeCd
     */
    public void setToOwnerTypeCd(String toOwnerTypeCd) {
        this.toOwnerTypeCd = toOwnerTypeCd;
    }

    /** 
     * Returns the toOwnerCd.
     * 
     * @return the toOwnerCd
     */
    public String getToOwnerCd() {
        return toOwnerCd;
    }

    /** 
     * Sets the toOwnerCd.
     * 
     * @param toOwnerCd the toOwnerCd
     */
    public void setToOwnerCd(String toOwnerCd) {
        this.toOwnerCd = toOwnerCd;
    }

    /** 
     * Returns the toShareNm.
     * 
     * @return the toShareNm
     */
    public String getToShareNm() {
        return toShareNm;
    }

    /** 
     * Sets the toShareNm.
     * 
     * @param toShareNm the toShareNm
     */
    public void setToShareNm(String toShareNm) {
        this.toShareNm = toShareNm;
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
}