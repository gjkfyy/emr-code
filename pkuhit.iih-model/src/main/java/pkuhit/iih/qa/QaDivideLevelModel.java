package pkuhit.iih.qa;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import org.seasar.doma.Id;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;

public class QaDivideLevelModel extends BaseBizModel {
 public QaDivideLevelModel(){
  super();
 }
 public QaDivideLevelModel(String code){
  super(code);
 }

public static final String   OBJ_CD  = "QAM12";

/** 评分等级 */
@Column(name = "QA_DIVIDE_LEVEL_CD")
private String qaDivideLevelCd;

/** 缺扣分次数 */
@Column(name = "DEDUCT_SCR_TIMES")
private  Integer deductScrTimes;

/** 最后得分 */
@Column(name = "MIN_SCR")
private  BigDecimal minScr;

/** 最后得分 */
@Column(name = "MAX_SCR")
private  BigDecimal maxScr;

/** 级别 */
@Column(name = "LVL")
private String lvl;

/** */
@Column(name = "MEMO")
private  String memo;

/** */
@Column(name = "SORT_NO")
private  String sortNo;

/** */
@Column(name = "SPELL_NO")
private  String spellNo;

/** */
@Column(name = "WUBI_NO")
private  String wubiNo;

/** */
@Column(name = "UPD_CNT")
private  BigInteger updCnt;

/** */
@Column(name = "CRT_TIME")
private  Timestamp crtTime;

/** */
@Column(name = "CRT_USER_ID")
private  String crtUserId;

/** */
@Column(name = "CRT_DEPT_CD")
private  String crtDeptCd;

/** */
@Column(name = "LAST_UPD_TIME")
private  Timestamp lastUpdTime;

/** */
@Column(name = "LAST_UPD_DEPT_CD")
private  String lastUpdDeptCd;

/** */
@Column(name = "LAST_UPD_USER_ID")
private  String lastUpdUserId;

/** */
@Column(name = "DEL_F")
private  Short delF;

public String getQaDivideLevelCd() {
	return qaDivideLevelCd;
}

public void setQaDivideLevelCd(String qaDivideLevelCd) {
	this.qaDivideLevelCd = qaDivideLevelCd;
}

public Integer getDeductScrTimes() {
	return deductScrTimes;
}

public void setDeductScrTimes(Integer deductScrTimes) {
	this.deductScrTimes = deductScrTimes;
}




public BigDecimal getMinScr() {
	return minScr;
}

public void setMinScr(BigDecimal minScr) {
	this.minScr = minScr;
}

public BigDecimal getMaxScr() {
	return maxScr;
}

public void setMaxScr(BigDecimal maxScr) {
	this.maxScr = maxScr;
}

public String getLvl() {
	return lvl;
}

public void setLvl(String lvl) {
	this.lvl = lvl;
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

public Timestamp getCrtTime() {
	return crtTime;
}

public void setCrtTime(Timestamp crtTime) {
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

public Timestamp getLastUpdTime() {
	return lastUpdTime;
}

public void setLastUpdTime(Timestamp lastUpdTime) {
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