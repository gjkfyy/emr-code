package pkuhit.md.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 医疗记录类型
 */
@Entity(listener = MdMrTpListener.class)
@Table(name = "MD_MR_TP")
public class MdMrTp {

	/** 主键 */
	@Id
	@Column(name = "MR_TP_CD")
	String mrTpCd;

	/** 名称 */
	@Column(name = "NM")
	String nm;

	/** 描述 */
	@Column(name = "DES")
	String des;

	/** 英文名称 */
	@Column(name = "NM_EN")
	String nmEn;

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

	/** 病历文书审签级别编码 */
	@Column(name = "MR_SIGN_LVL_CD")
	String mrSignLvlCd;

	/** 只可建一份标识 */
	@Column(name = "ONLY_F")
	BigInteger onlyF;

	/** 新起一页打印标识 */
	@Column(name = "NEW_PAGE_F")
	BigInteger newPageF;

	/** 独占一页打印标识 */
	@Column(name = "ALONE_PAGE_F")
	BigInteger alonePageF;

	/** 短英文名 */
	@Column(name = "SHT_NM_EN")
	String shtNmEn;

	/** 级别 */
	@Column(name = "LVL")
	BigInteger lvl;

	/** 级别 */
	@Column(name = "LEAF_F")
	BigInteger leafF;

	/** 是否允许非本人修改病历 */
	@Column(name = "PERMIT_F")
	Short permitF;

	public BigInteger getAlonePageF() {
		return alonePageF;
	}

	public void setAlonePageF(BigInteger alonePageF) {
		this.alonePageF = alonePageF;
	}

	public Short getPermitF() {
		return permitF;
	}

	public void setPermitF(Short permitF) {
		this.permitF = permitF;
	}

	/**
	 * Returns the mrTpCd.
	 * 
	 * @return the mrTpCd
	 */
	public String getMrTpCd() {
		return mrTpCd;
	}

	/**
	 * Sets the mrTpCd.
	 * 
	 * @param mrTpCd
	 *            the mrTpCd
	 */
	public void setMrTpCd(String mrTpCd) {
		this.mrTpCd = mrTpCd;
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
	 * @param nm
	 *            the nm
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
	 * @param des
	 *            the des
	 */
	public void setDes(String des) {
		this.des = des;
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
	 * @param nmEn
	 *            the nmEn
	 */
	public void setNmEn(String nmEn) {
		this.nmEn = nmEn;
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
	 * @param memo
	 *            the memo
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
	 * @param sortNo
	 *            the sortNo
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
	 * @param spellNo
	 *            the spellNo
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
	 * @param wubiNo
	 *            the wubiNo
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
	 * @param updCnt
	 *            the updCnt
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
	 * @param crtTime
	 *            the crtTime
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
	 * @param crtUserId
	 *            the crtUserId
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
	 * @param crtDeptCd
	 *            the crtDeptCd
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
	 * @param lastUpdTime
	 *            the lastUpdTime
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
	 * @param lastUpdDeptCd
	 *            the lastUpdDeptCd
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
	 * @param lastUpdUserId
	 *            the lastUpdUserId
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
	 * @param delF
	 *            the delF
	 */
	public void setDelF(Short delF) {
		this.delF = delF;
	}

	/**
	 * Returns the mrSignLvlCd.
	 * 
	 * @return the mrSignLvlCd
	 */
	public String getMrSignLvlCd() {
		return mrSignLvlCd;
	}

	/**
	 * Sets the mrSignLvlCd.
	 * 
	 * @param mrSignLvlCd
	 *            the mrSignLvlCd
	 */
	public void setMrSignLvlCd(String mrSignLvlCd) {
		this.mrSignLvlCd = mrSignLvlCd;
	}

	public BigInteger getOnlyF() {

		return onlyF;
	}

	public void setOnlyF(BigInteger onlyF) {

		this.onlyF = onlyF;
	}

	public BigInteger getNewPageF() {

		return newPageF;
	}

	public void setNewPageF(BigInteger newPageF) {

		this.newPageF = newPageF;
	}

	public String getShtNmEn() {
		return shtNmEn;
	}

	public void setShtNmEn(String shtNmEn) {
		this.shtNmEn = shtNmEn;
	}

	public BigInteger getLvl() {
		return lvl;
	}

	public void setLvl(BigInteger lvl) {
		this.lvl = lvl;
	}

	public BigInteger getLeafF() {
		return leafF;
	}

	public void setLeafF(BigInteger leafF) {
		this.leafF = leafF;
	}

}