package pkuhit.iih.mr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 科室三级审签表 
 */
@Entity(listener = MrDeptThreeSignListener.class)
@Table(name = "MR_DEPT_THREE_SIGN")
public class MrDeptThreeSign {

    /** 编码 */
    @Id
    @Column(name = "SING_CD")
    String singCd;

    /** 科室编码 */
    @Column(name = "DEPT_CD")
    String deptCd;

    /** 审签医生Cd */
    @Column(name = "EMPLOYEE_CD")
    String employeeCd;

    /** 审签级别编码 */
    @Column(name = "SIGN_LVL_CD")
    String signLvlCd;

    /** 上级上级医生CODE（主任） */
    @Column(name = "MNG_DCT_ID")
    String mngDctId;

    /** 上级医生CODE（主治） */
    @Column(name = "SUP_DCT_ID")
    String supDctId;

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
     * Returns the singCd.
     * 
     * @return the singCd
     */
    public String getSingCd() {
        return singCd;
    }

    /** 
     * Sets the singCd.
     * 
     * @param singCd the singCd
     */
    public void setSingCd(String singCd) {
        this.singCd = singCd;
    }

    /** 
     * Returns the deptCd.
     * 
     * @return the deptCd
     */
    public String getDeptCd() {
        return deptCd;
    }

    /** 
     * Sets the deptCd.
     * 
     * @param deptCd the deptCd
     */
    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    /** 
     * Returns the employeeCd.
     * 
     * @return the employeeCd
     */
    public String getEmployeeCd() {
        return employeeCd;
    }

    /** 
     * Sets the employeeCd.
     * 
     * @param employeeCd the employeeCd
     */
    public void setEmployeeCd(String employeeCd) {
        this.employeeCd = employeeCd;
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
     * Returns the mngDctId.
     * 
     * @return the mngDctId
     */
    public String getMngDctId() {
        return mngDctId;
    }

    /** 
     * Sets the mngDctId.
     * 
     * @param mngDctId the mngDctId
     */
    public void setMngDctId(String mngDctId) {
        this.mngDctId = mngDctId;
    }

    /** 
     * Returns the supDctId.
     * 
     * @return the supDctId
     */
    public String getSupDctId() {
        return supDctId;
    }

    /** 
     * Sets the supDctId.
     * 
     * @param supDctId the supDctId
     */
    public void setSupDctId(String supDctId) {
        this.supDctId = supDctId;
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