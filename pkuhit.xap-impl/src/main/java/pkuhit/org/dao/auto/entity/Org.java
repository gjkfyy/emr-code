package pkuhit.org.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 大科室
 */
@Entity(listener = OrgListener.class)
@Table(name = "ORG")
public class Org {

    /** 主键 */
    @Id
    @Column(name = "ORG_CD")
    String orgCd;

    /** 科室类型 */
    @Column(name = "ORG_TP_CD")
    String orgTpCd;

    /** 名称 */
    @Column(name = "NM")
    String nm;

    /** 描述 */
    @Column(name = "DES")
    String des;

    /** 简写 */
    @Column(name = "SHT_NM")
    String shtNm;

    /** 别名 */
    @Column(name = "ALIAS_NM")
    String aliasNm;

    /** 区县编码 */
    @Column(name = "DIST_CD")
    String distCd;

    /** 乡镇街道名称 */
    @Column(name = "SUBDIST_NM")
    String subdistNm;

    /** 邮政编码 */
    @Column(name = "ZIP_NO")
    String zipNo;

    /** 联系电话 */
    @Column(name = "TEL_NO")
    String telNo;

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
     * Returns the orgTpCd.
     * 
     * @return the orgTpCd
     */
    public String getOrgTpCd() {
        return orgTpCd;
    }

    /** 
     * Sets the orgTpCd.
     * 
     * @param orgTpCd the orgTpCd
     */
    public void setOrgTpCd(String orgTpCd) {
        this.orgTpCd = orgTpCd;
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
     * Returns the shtNm.
     * 
     * @return the shtNm
     */
    public String getShtNm() {
        return shtNm;
    }

    /** 
     * Sets the shtNm.
     * 
     * @param shtNm the shtNm
     */
    public void setShtNm(String shtNm) {
        this.shtNm = shtNm;
    }

    /** 
     * Returns the aliasNm.
     * 
     * @return the aliasNm
     */
    public String getAliasNm() {
        return aliasNm;
    }

    /** 
     * Sets the aliasNm.
     * 
     * @param aliasNm the aliasNm
     */
    public void setAliasNm(String aliasNm) {
        this.aliasNm = aliasNm;
    }

    /** 
     * Returns the distCd.
     * 
     * @return the distCd
     */
    public String getDistCd() {
        return distCd;
    }

    /** 
     * Sets the distCd.
     * 
     * @param distCd the distCd
     */
    public void setDistCd(String distCd) {
        this.distCd = distCd;
    }

    /** 
     * Returns the subdistNm.
     * 
     * @return the subdistNm
     */
    public String getSubdistNm() {
        return subdistNm;
    }

    /** 
     * Sets the subdistNm.
     * 
     * @param subdistNm the subdistNm
     */
    public void setSubdistNm(String subdistNm) {
        this.subdistNm = subdistNm;
    }

    /** 
     * Returns the zipNo.
     * 
     * @return the zipNo
     */
    public String getZipNo() {
        return zipNo;
    }

    /** 
     * Sets the zipNo.
     * 
     * @param zipNo the zipNo
     */
    public void setZipNo(String zipNo) {
        this.zipNo = zipNo;
    }

    /** 
     * Returns the telNo.
     * 
     * @return the telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /** 
     * Sets the telNo.
     * 
     * @param telNo the telNo
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
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