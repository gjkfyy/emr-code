package pkuhit.xap.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 用户
 */
@Entity(listener = XapUserListener.class)
@Table(name = "XAP_USER")
public class XapUser {

    /** 主键 */
    @Id
    @Column(name = "XAP_USER_PK")
    String xapUserPk;

    /** 用户编码 */
    @Column(name = "USER_ID")
    String userId;

    /** 人员编码 */
    @Column(name = "EMP_ID")
    String empId;

    /** 用户状态 */
    @Column(name = "USER_STA_CD")
    String userStaCd;

    /** 用户图片 */
    @Column(name = "SIGN_PIC")
    Clob signPic;

    /** 密码 */
    @Column(name = "PWD")
    String pwd;
    
    /** 密码 */
    @Column(name = "IEMR_PWD")
    String iemrPwd;

    /** 名称 */
    @Column(name = "NM")
    String nm;

    /** 名称拼音 */
    @Column(name = "NM_SPELL")
    String nmSpell;

    /** 性别编码 */
    @Column(name = "SEX_CD")
    String sexCd;

    /** 邮箱 */
    @Column(name = "EMAIL")
    String email;

    /** 职称 */
    @Column(name = "JOB_TITLE_CD")
    String jobTitleCd;

    /** 手机 */
    @Column(name = "MOBILE_NO")
    String mobileNo;

    /** 电话 */
    @Column(name = "TEL_NO")
    String telNo;

    /** 科室 */
    @Column(name = "ORG_CD")
    String orgCd;

    /** CIS登录名称 */
    @Column(name = "LOGIN_NM")
    String loginNm;

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

    /**医护使用标记 */
    @Column(name = "DCT_NS_F")
    Short dctNsF;
    
    /** 
     * Returns the xapUserPk.
     * 
     * @return the xapUserPk
     */
    public String getXapUserPk() {
        return xapUserPk;
    }

    /** 
     * Sets the xapUserPk.
     * 
     * @param xapUserPk the xapUserPk
     */
    public void setXapUserPk(String xapUserPk) {
        this.xapUserPk = xapUserPk;
    }

    /** 
     * Returns the userId.
     * 
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * Sets the userId.
     * 
     * @param userId the userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * Returns the userStaCd.
     * 
     * @return the userStaCd
     */
    public String getUserStaCd() {
        return userStaCd;
    }

    /** 
     * Sets the userStaCd.
     * 
     * @param userStaCd the userStaCd
     */
    public void setUserStaCd(String userStaCd) {
        this.userStaCd = userStaCd;
    }

    /** 
     * Returns the signPic.
     * 
     * @return the signPic
     */
    public Clob getSignPic() {
        return signPic;
    }

    /** 
     * Sets the signPic.
     * 
     * @param signPic the signPic
     */
    public void setSignPic(Clob signPic) {
        this.signPic = signPic;
    }

    /** 
     * Returns the pwd.
     * 
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /** 
     * Sets the pwd.
     * 
     * @param pwd the pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
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
     * Returns the loginNm.
     * 
     * @return the loginNm
     */
    public String getLoginNm() {
        return loginNm;
    }

    /** 
     * Sets the loginNm.
     * 
     * @param loginNm the loginNm
     */
    public void setLoginNm(String loginNm) {
        this.loginNm = loginNm;
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

    public String getIemrPwd()
    {
        return iemrPwd;
    }

    public void setIemrPwd(String iemrPwd)
    {
        this.iemrPwd = iemrPwd;
    }

	public Short getDctNsF() {
		return dctNsF;
	}

	public void setDctNsF(Short dctNsF) {
		this.dctNsF = dctNsF;
	}

    
    
}