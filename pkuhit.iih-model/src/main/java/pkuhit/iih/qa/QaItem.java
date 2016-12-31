package pkuhit.iih.qa;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseBizModel;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.seasar.doma.Id;

public class QaItem extends BaseBizModel {
 public QaItem(){
  super();
 }
 public QaItem(String code){
  super(code);
 }

 /** 主键 */
 @Column(name = "QA_ITM_CD")
  private String qaItmCd;

 /** 质控要求 */
 @Column(name = "REQ")
  private String req;

 /** 质控扣分类型 */
 @Column(name = "QA_DRP_SCR_TP_CD")
  private String qaDrpScrTpCd;
 
 @DictionaryTag(code = "qaDrpScrTpCd",objCd = "QAM02")
 private String qaDrpScrTpNm;

 /** 单次扣分值 */
 @Column(name = "ONCE_DRP_SCR")
  private BigDecimal onceDrpScr;

 /** 累计最大扣分值 */
 @Column(name = "MAX_DRP_SCR")
  private BigDecimal maxDrpScr;

 /** 默认整改标志 */
 @Column(name = "DFT_RFM_F")
  private Short dftRfmF;

 /** 自动质控标志 */
 @Column(name = "AUTO_QA_F")
  private Short autoQaF;

 /** 一级分类 */
 @Column(name = "FST_CD")
  private String fstCd;

 /** 二级分类 */
 @Column(name = "SND_CD")
  private String sndCd;

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
 private Timestamp crtTime;

 /** */
 @Column(name = "CRT_USER_ID")
  private String crtUserId;

 /** */
 @Column(name = "CRT_DEPT_CD")
  private String crtDeptCd;

 /** */
 @Column(name = "LAST_UPD_TIME")
 private Timestamp lastUpdTime;

 /** */
 @Column(name = "LAST_UPD_DEPT_CD")
  private String lastUpdDeptCd;

 /** */
 @Column(name = "LAST_UPD_USER_ID")
  private String lastUpdUserId;

 /** */
 @Column(name = "DEL_F")
 private Short delF;

 /** 扣分说明 */
 @Column(name = "DEDUCT_DES")
  private String deductDes;
 
 /** 启用标识 */
 @Column(name = "USE_FLAG")
  private String useFlag;
 
 /** 质控项目类别 */
 @Column(name = "QA_ITM_TP_CD")
  private String qaItmTpCd;

public String getQaItmCd() {
	return qaItmCd;
}

public void setQaItmCd(String qaItmCd) {
	this.qaItmCd = qaItmCd;
}

public String getReq() {
	return req;
}

public void setReq(String req) {
	this.req = req;
}

public String getQaDrpScrTpCd() {
	return qaDrpScrTpCd;
}

public void setQaDrpScrTpCd(String qaDrpScrTpCd) {
	this.qaDrpScrTpCd = qaDrpScrTpCd;
}

public BigDecimal getOnceDrpScr() {
	return onceDrpScr;
}

public void setOnceDrpScr(BigDecimal onceDrpScr) {
	this.onceDrpScr = onceDrpScr;
}

public BigDecimal getMaxDrpScr() {
	return maxDrpScr;
}

public void setMaxDrpScr(BigDecimal maxDrpScr) {
	this.maxDrpScr = maxDrpScr;
}

public Short getDftRfmF() {
	return dftRfmF;
}

public void setDftRfmF(Short dftRfmF) {
	this.dftRfmF = dftRfmF;
}

public Short getAutoQaF() {
	return autoQaF;
}

public void setAutoQaF(Short autoQaF) {
	this.autoQaF = autoQaF;
}

public String getFstCd() {
	return fstCd;
}

public void setFstCd(String fstCd) {
	this.fstCd = fstCd;
}

public String getSndCd() {
	return sndCd;
}

public void setSndCd(String sndCd) {
	this.sndCd = sndCd;
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

public String getDeductDes() {
	return deductDes;
}

public void setDeductDes(String deductDes) {
	this.deductDes = deductDes;
}

public String getQaDrpScrTpNm() {
	return qaDrpScrTpNm;
}

public void setQaDrpScrTpNm(String qaDrpScrTpNm) {
	this.qaDrpScrTpNm = qaDrpScrTpNm;
}

public String getUseFlag() {
	return useFlag;
}

public void setUseFlag(String useFlag) {
	this.useFlag = useFlag;
}

public String getQaItmTpCd() {
	return qaItmTpCd;
}

public void setQaItmTpCd(String qaItmTpCd) {
	this.qaItmTpCd = qaItmTpCd;
}
}