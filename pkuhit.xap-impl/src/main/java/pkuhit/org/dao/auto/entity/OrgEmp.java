package pkuhit.org.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 人员
 */
@Entity(listener = OrgEmpListener.class)
@Table(name = "ORG_EMP")
public class OrgEmp {

    /** 主键 */
    @Id
    @Column(name = "EMP_ID")
    String empId;

    /** 所属科室编码 */
    @Column(name = "DEPT_CD")
    String deptCd;

    /** 人员编码 */
    @Column(name = "EMP_NO")
    String empNo;

    /** 名称 */
    @Column(name = "NM")
    String nm;

    /** 名称拼音 */
    @Column(name = "NM_SPELL")
    String nmSpell;

    /** 性别编码 */
    @Column(name = "SEX_CD")
    String sexCd;

    /** 出生日期 */
    @Column(name = "BIRTHDAY")
    Timestamp birthday;

    /** 身份证号 */
    @Column(name = "ID_CARD_NO")
    String idCardNo;

    /** 电子邮件 */
    @Column(name = "EMAIL")
    String email;

    /** 职称编码 */
    @Column(name = "JOB_TITLE_CD")
    String jobTitleCd;

    /** 联系地址编码 */
    @Column(name = "POSITION_CD")
    String positionCd;

    /** PROF_CD */
    @Column(name = "PROF_CD")
    String profCd;

    /** 联系电话 */
    @Column(name = "TEL_NO")
    String telNo;

    /** 移动电话 */
    @Column(name = "MOBILE_NO")
    String mobileNo;

    /** IEMR职称编码 */
    @Column(name = "IEMR_JOB_TITLE_CD")
    String iemrJobTitleCd;

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
     * Returns the empNo.
     * 
     * @return the empNo
     */
    public String getEmpNo() {
        return empNo;
    }

    /** 
     * Sets the empNo.
     * 
     * @param empNo the empNo
     */
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
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
     * Returns the nmSpell.
     * 
     * @return the nmSpell
     */
    public String getNmSpell() {
        return nmSpell;
    }

    /** 
     * Sets the nmSpell.
     * 
     * @param nmSpell the nmSpell
     */
    public void setNmSpell(String nmSpell) {
        this.nmSpell = nmSpell;
    }

    /** 
     * Returns the sexCd.
     * 
     * @return the sexCd
     */
    public String getSexCd() {
        return sexCd;
    }

    /** 
     * Sets the sexCd.
     * 
     * @param sexCd the sexCd
     */
    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }

    /** 
     * Returns the birthday.
     * 
     * @return the birthday
     */
    public Timestamp getBirthday() {
        return birthday;
    }

    /** 
     * Sets the birthday.
     * 
     * @param birthday the birthday
     */
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    /** 
     * Returns the idCardNo.
     * 
     * @return the idCardNo
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /** 
     * Sets the idCardNo.
     * 
     * @param idCardNo the idCardNo
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /** 
     * Returns the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Sets the email.
     * 
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Returns the jobTitleCd.
     * 
     * @return the jobTitleCd
     */
    public String getJobTitleCd() {
        return jobTitleCd;
    }

    /** 
     * Sets the jobTitleCd.
     * 
     * @param jobTitleCd the jobTitleCd
     */
    public void setJobTitleCd(String jobTitleCd) {
        this.jobTitleCd = jobTitleCd;
    }

    /** 
     * Returns the positionCd.
     * 
     * @return the positionCd
     */
    public String getPositionCd() {
        return positionCd;
    }

    /** 
     * Sets the positionCd.
     * 
     * @param positionCd the positionCd
     */
    public void setPositionCd(String positionCd) {
        this.positionCd = positionCd;
    }

    /** 
     * Returns the profCd.
     * 
     * @return the profCd
     */
    public String getProfCd() {
        return profCd;
    }

    /** 
     * Sets the profCd.
     * 
     * @param profCd the profCd
     */
    public void setProfCd(String profCd) {
        this.profCd = profCd;
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
     * Returns the mobileNo.
     * 
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /** 
     * Sets the mobileNo.
     * 
     * @param mobileNo the mobileNo
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /** 
     * Returns the iemrJobTitleCd.
     * 
     * @return the iemrJobTitleCd
     */
    public String getIemrJobTitleCd() {
        return iemrJobTitleCd;
    }

    /** 
     * Sets the iemrJobTitleCd.
     * 
     * @param iemrJobTitleCd the iemrJobTitleCd
     */
    public void setIemrJobTitleCd(String iemrJobTitleCd) {
        this.iemrJobTitleCd = iemrJobTitleCd;
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