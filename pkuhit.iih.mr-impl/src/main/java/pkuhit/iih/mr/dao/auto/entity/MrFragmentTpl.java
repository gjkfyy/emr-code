package pkuhit.iih.mr.dao.auto.entity;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MrFragmentTplListener.class)
@Table(name = "MR_FRAGMENT_TPL")
public class MrFragmentTpl {
    /** */
    @Id
    @Column(name = "FRAGMENT_TPL_CD")
    String fragmentTplCd;

    /** */
    @Column(name = "FRAGMENT_TPL_CONTENT")
    String fragmentTplContent;

    /** */
    @Column(name = "FRAGMENT_TPL_TYPE_CD")
    String fragmentTplTypeCd;

    /** */
    @Column(name = "OWNER_TYPE_CD")
    String ownerTypeCd;

    /** */
    @Column(name = "OWNER_CD")
    String ownerCd;

    /** */
    @Column(name = "FRAGMENT_TPL_NM")
    String fragmentTplNm;

    /** */
    @Column(name = "SPELL_NO")
    String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    String wubiNo;

    /** */
    @Column(name = "SORT_NO")
    Long sortNo;

    /** */
    @Column(name = "MEMO")
    String memo;

    /** */
    @Column(name = "UPD_CNT")
    Integer updCnt;

    /** */
    @Column(name = "CRT_USER_ID")
    String crtUserId;
    
    /** */
    @Column(name = "CRT_DEPT_CD")
    String crtDeptCd;
    
    /** */
    @Column(name = "CRT_TIME")
    Timestamp crtTime;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;
    
    /** */
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    /** */
    @Column(name = "DEL_F")
    Short delF;

    /** 
     * Returns the fragmentTplCd.
     * 
     * @return the fragmentTplCd
     */
    public String getFragmentTplCd() {
        return fragmentTplCd;
    }

    /** 
     * Sets the fragmentTplCd.
     * 
     * @param fragmentTplCd the fragmentTplCd
     */
    public void setFragmentTplCd(String fragmentTplCd) {
        this.fragmentTplCd = fragmentTplCd;
    }

    /** 
     * Returns the fragmentTplContent.
     * 
     * @return the fragmentTplContent
     */
    public String getFragmentTplContent() {
        return fragmentTplContent;
    }

    /** 
     * Sets the fragmentTplContent.
     * 
     * @param fragmentTplContent the fragmentTplContent
     */
    public void setFragmentTplContent(String fragmentTplContent) {
        this.fragmentTplContent = fragmentTplContent;
    }

    /** 
     * Returns the fragmentTplTypeCd.
     * 
     * @return the fragmentTplTypeCd
     */
    public String getFragmentTplTypeCd() {
        return fragmentTplTypeCd;
    }

    /** 
     * Sets the fragmentTplTypeCd.
     * 
     * @param fragmentTplTypeCd the fragmentTplTypeCd
     */
    public void setFragmentTplTypeCd(String fragmentTplTypeCd) {
        this.fragmentTplTypeCd = fragmentTplTypeCd;
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
     * Returns the fragmentTplNm.
     * 
     * @return the fragmentTplNm
     */
    public String getFragmentTplNm() {
        return fragmentTplNm;
    }

    /** 
     * Sets the fragmentTplNm.
     * 
     * @param fragmentTplNm the fragmentTplNm
     */
    public void setFragmentTplNm(String fragmentTplNm) {
        this.fragmentTplNm = fragmentTplNm;
    }

    /** 
     * Returns the sortNo.
     * 
     * @return the sortNo
     */
    public Long getSortNo() {
        return sortNo;
    }

    /** 
     * Sets the sortNo.
     * 
     * @param sortNo the sortNo
     */
    public void setSortNo(Long sortNo) {
        this.sortNo = sortNo;
    }

    public String getSpellNo()
    {
        return spellNo;
    }

    public void setSpellNo(String spellNo)
    {
        this.spellNo = spellNo;
    }

    public String getWubiNo()
    {
        return wubiNo;
    }

    public void setWubiNo(String wubiNo)
    {
        this.wubiNo = wubiNo;
    }

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String memo)
    {
        this.memo = memo;
    }

    public Integer getUpdCnt()
    {
        return updCnt;
    }

    public void setUpdCnt(Integer updCnt)
    {
        this.updCnt = updCnt;
    }

    public String getCrtUserId()
    {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId)
    {
        this.crtUserId = crtUserId;
    }

    public String getCrtDeptCd()
    {
        return crtDeptCd;
    }

    public void setCrtDeptCd(String crtDeptCd)
    {
        this.crtDeptCd = crtDeptCd;
    }

    public Timestamp getCrtTime()
    {
        return crtTime;
    }

    public void setCrtTime(Timestamp crtTime)
    {
        this.crtTime = crtTime;
    }

    public String getLastUpdUserId()
    {
        return lastUpdUserId;
    }

    public void setLastUpdUserId(String lastUpdUserId)
    {
        this.lastUpdUserId = lastUpdUserId;
    }

    public String getLastUpdDeptCd()
    {
        return lastUpdDeptCd;
    }

    public void setLastUpdDeptCd(String lastUpdDeptCd)
    {
        this.lastUpdDeptCd = lastUpdDeptCd;
    }

    public Timestamp getLastUpdTime()
    {
        return lastUpdTime;
    }

    public void setLastUpdTime(Timestamp lastUpdTime)
    {
        this.lastUpdTime = lastUpdTime;
    }

    public Short getDelF()
    {
        return delF;
    }

    public void setDelF(Short delF)
    {
        this.delF = delF;
    }
}