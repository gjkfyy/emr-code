package pkuhit.iih.mr.md;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import xap.sv.annotation.Column;//自动转换
import org.seasar.doma.Id;

import xap.model.BaseMasterModel;

public class HyperlinkTemplate extends BaseMasterModel{

	public HyperlinkTemplate() {
		// TODO Auto-generated constructor stub
	}
	 /** */
    @Column(name = "DI_CD")
    private String code;

    /** */
    @Column(name = "ORG_CD")
    private String orgCode;

    /** */
    @Column(name = "NM")
    private String name;

    /** */
    @Column(name = "DES")
    private String des;

    /** */
    @Column(name = "ICD_CD")
    private String icdCode;

    /** */
    @Column(name = "INF_F")
    private Short infF;

    /** */
    @Column(name = "SYM_F")
    private Short symF;

    /** */
    @Column(name = "MEMO")
    private String memo;

    /** */
    @Column(name = "SORT_NO")
    private String sortNo;

    /** */
    @Column(name = "SPELL_NO")
    private String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    private String wubiNo;

    /** */
    @Column(name = "UPD_CNT")
    private BigInteger updCnt;

    /** */
    @Column(name = "CRT_TIME")
    private Date crtTime;

    /** */
    @Column(name = "CRT_USER_ID")
    private String crtUserId;

    /** */
    @Column(name = "CRT_DEPT_CD")
    private String crtDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    private Date lastUpdTime;

    /** */
    @Column(name = "LAST_UPD_DEPT_CD")
    private String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    private String lastUpdUserId;

    /** */
    @Column(name = "DEL_F")
    private Short delF;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public Short getInfF() {
		return infF;
	}

	public void setInfF(Short infF) {
		this.infF = infF;
	}

	public Short getSymF() {
		return symF;
	}

	public void setSymF(Short symF) {
		this.symF = symF;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSortNo() {
		return sortNo;
	}

	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	public String getSpellNo() {
		return spellNo;
	}

	public void setSpellNo(String spellNo) {
		this.spellNo = spellNo;
	}

	public String getWubiNo() {
		return wubiNo;
	}

	public void setWubiNo(String wubiNo) {
		this.wubiNo = wubiNo;
	}

	public BigInteger getUpdCnt() {
		return updCnt;
	}

	public void setUpdCnt(BigInteger updCnt) {
		this.updCnt = updCnt;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public String getCrtUserId() {
		return crtUserId;
	}

	public void setCrtUserId(String crtUserId) {
		this.crtUserId = crtUserId;
	}

	public String getCrtDeptCd() {
		return crtDeptCd;
	}

	public void setCrtDeptCd(String crtDeptCd) {
		this.crtDeptCd = crtDeptCd;
	}

	public Date getLastUpdTime() {
		return lastUpdTime;
	}

	public void setLastUpdTime(Date lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}

	public String getLastUpdDeptCd() {
		return lastUpdDeptCd;
	}

	public void setLastUpdDeptCd(String lastUpdDeptCd) {
		this.lastUpdDeptCd = lastUpdDeptCd;
	}

	public String getLastUpdUserId() {
		return lastUpdUserId;
	}

	public void setLastUpdUserId(String lastUpdUserId) {
		this.lastUpdUserId = lastUpdUserId;
	}

	public Short getDelF() {
		return delF;
	}

	public void setDelF(Short delF) {
		this.delF = delF;
	}
    
    
}
