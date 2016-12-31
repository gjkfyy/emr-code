package pkuhit.org.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 人员出诊科室
 */
@Entity(listener = OrgEmpDeptListener.class)
@Table(name = "ORG_EMP_DEPT")
public class OrgEmpDept {

    /** 人员出诊科室编码 */
    @Id
    @Column(name = "EMP_DEPT_CD")
    String empDeptCd;

    /** 病区科室编码 */
    @Column(name = "WARD_DEPT_CD")
    String wardDeptCd;

    /** 人员编码 */
    @Column(name = "EMP_ID")
    String empId;

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

    /**  人员审签级别 */
    @Column(name = "SIGN_LVL_CD")
    String signLvlCd;

    /** 主任医生 */
    @Column(name = "CUR_DRC_DCT_ID")
    String curDrcDctId;

    /** 副主任医生 */
    @Column(name = "CUR_DEPUTY_DRC_DCT_ID")
    String curDeputyDrcDctId;
    

    /** 
     * Returns the empDeptCd.
     * 
     * @return the empDeptCd
     */
    public String getEmpDeptCd() {
        return empDeptCd;
    }

    /** 
     * Sets the empDeptCd.
     * 
     * @param empDeptCd the empDeptCd
     */
    public void setEmpDeptCd(String empDeptCd) {
        this.empDeptCd = empDeptCd;
    }

    /** 
     * Returns the wardDeptCd.
     * 
     * @return the wardDeptCd
     */
    public String getWardDeptCd() {
        return wardDeptCd;
    }

    /** 
     * Sets the wardDeptCd.
     * 
     * @param wardDeptCd the wardDeptCd
     */
    public void setWardDeptCd(String wardDeptCd) {
        this.wardDeptCd = wardDeptCd;
    }

    /** 
     * Returns the empId.
     * 
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /** 
     * Sets the empId.
     * 
     * @param empId the empId
     */
    public void setEmpId(String empId) {
        this.empId = empId;
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
     * Returns the signLvlCd.
     * 
     * @return the signLvlCd
     */
    public String getSignLvlCd() {
        return signLvlCd;
    }

    /** 
     * Sets the signLvlCd.
     * 
     * @param signLvlCd the signLvlCd
     */
    public void setSignLvlCd(String signLvlCd) {
        this.signLvlCd = signLvlCd;
    }

    /** 
     * Returns the curDrcDctId.
     * 
     * @return the curDrcDctId
     */
    public String getCurDrcDctId() {
        return curDrcDctId;
    }

    /** 
     * Sets the curDrcDctId.
     * 
     * @param curDrcDctId the curDrcDctId
     */
    public void setCurDrcDctId(String curDrcDctId) {
        this.curDrcDctId = curDrcDctId;
    }

    /** 
     * Returns the curDeputyDrcDctId.
     * 
     * @return the curDeputyDrcDctId
     */
    public String getCurDeputyDrcDctId() {
        return curDeputyDrcDctId;
    }

    /** 
     * Sets the curDeputyDrcDctId.
     * 
     * @param curDeputyDrcDctId the curDeputyDrcDctId
     */
    public void setCurDeputyDrcDctId(String curDeputyDrcDctId) {
        this.curDeputyDrcDctId = curDeputyDrcDctId;
    }

    
    
}