package pkuhit.me.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * ME_DATA_ACRU

 */
@Entity(listener = MeDataAcruListener.class)
@Table(name = "ME_DATA_ACRU")
public class MeDataAcru {

    /** */
    @Id
    @Column(name = "DATA_ACRU_CD")
    String dataAcruCd;

    /** */
    @Column(name = "OBJ_CD")
    String objCd;

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
    @Column(name = "RULE")
    String rule;

    /** */
    @Column(name = "SORT_NO")
    String sortNo;

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
     * Returns the dataAcruCd.
     * 
     * @return the dataAcruCd
     */
    public String getDataAcruCd() {
        return dataAcruCd;
    }

    /** 
     * Sets the dataAcruCd.
     * 
     * @param dataAcruCd the dataAcruCd
     */
    public void setDataAcruCd(String dataAcruCd) {
        this.dataAcruCd = dataAcruCd;
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
     * Returns the rule.
     * 
     * @return the rule
     */
    public String getRule() {
        return rule;
    }

    /** 
     * Sets the rule.
     * 
     * @param rule the rule
     */
    public void setRule(String rule) {
        this.rule = rule;
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