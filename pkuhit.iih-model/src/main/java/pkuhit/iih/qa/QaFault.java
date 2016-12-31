package pkuhit.iih.qa;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import org.seasar.doma.Id;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class QaFault extends BaseBizModel {
 public QaFault(){
  super();
 }
 public QaFault(String code){
  super(code);
 }

public static final String   OBJ_CD  = "QAM12";

/**缺陷主键 */
@Column(name="QA_FLT_PK") 
private  String qaFltPk;

/** 质控项 */
@Column(name = "QA_ITM_CD")
private  String qaItmCd;

/** 质控类型 */
@Column(name = "QA_TY_CD")
private  String qaTyCd;

/** 缺陷状态 */
@Column(name = "FLT_STA_CD")
private  String fltStaCd;

/** 缺陷状态名称 */
@DictionaryTag(code = "fltStaCd",objCd = "QAM12")
private  String fltStaNm;

/** 整改通知 */
@Column(name = "REVISION_CD")
private  String revisionCd;

/** 提出时间 */
@Column(name = "SBMT_TIME")
private  Timestamp sbmtTime;

/** 提出人 */
@Column(name = "SBMT_USER_ID")
private  String sbmtUserId;

/** 提出科室 */
@Column(name = "SBMT_DEPT_CD")
private  String sbmtDeptCd;

/** 整改要求 */
@Column(name = "RFM_REQ")
private  String rfmReq;

/** 整改时间 */
@Column(name = "RFM_TIME")
private  Timestamp rfmTime;

/** 整改人 */
@Column(name = "RFM_USER_ID")
private  String rfmUserId;

/** 整改人名称*/
@DictionaryTag(code = "rfmUserId", objCd = "ORGB04")
private  String rfmUserNm;

/** 整改科室 */
@Column(name = "RFM_DEPT_CD")
private  String rfmDeptCd;

/** 整改科室名称*/
@DictionaryTag(code = "rfmDeptCd", objCd = "ORGB01")
private  String rfmDeptNm;

/** 整改说明 */
@Column(name = "RFM_DES")
private  String rfmDes;

/** 审核时间 */
@Column(name = "VRF_TIME")
private  Timestamp vrfTime;

/** 审核人 */
@Column(name = "VRF_USER_ID")
private  String vrfUserId;

/** 审核科室 */
@Column(name = "VRF_DEPT_CD")
private  String vrfDeptCd;

/** 扣分说明 */
@Column(name = "DRP_DES")
private  String drpDes;

/** 就诊序号 */
@Column(name = "EN_PK")
private  String enPk;

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

/** 提出时间 */
@Column(name = "CRT_TIME")
private  Timestamp crtTime;

/** 提出人ID*/
@Column(name = "CRT_USER_ID")
private  String crtUserId;

/** 提出人名称*/
@DictionaryTag(code = "crtUserId", objCd = "ORGB04")
private  String crtUserNm;

/** 提出科室编码*/
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

/** 扣分标准-质控项目表*/
@Column(name = "ONCE_DRP_SCR")
private  BigDecimal onceDropScore;

/** 扣分标准-质控项目表*/
@Column(name = "REQ")
private  String req;

/** 病历文书编码 */
@Column(name = "MR_PK")
private  String mrPk;

/** 扣分说明 */
@Column(name = "DEDUCT_DES")
 private String deductDes;

/** 缺扣分次数 */
@Column(name = "DEDUCT_SCR_TIMES")
private  Integer deductScrTimes;

/** 病历文书名称 */
@Column(name = "NM")
private  String mrName;


public String getQaFltPk() {
	return qaFltPk;
}

public void setQaFltPk(String qaFltPk) {
	this.qaFltPk = qaFltPk;
}

public String getQaItmCd() {
	return qaItmCd;
}

public void setQaItmCd(String qaItmCd) {
	this.qaItmCd = qaItmCd;
}

public String getQaTyCd() {
	return qaTyCd;
}

public void setQaTyCd(String qaTyCd) {
	this.qaTyCd = qaTyCd;
}

public String getFltStaCd() {
	return fltStaCd;
}

public void setFltStaCd(String fltStaCd) {
	this.fltStaCd = fltStaCd;
}

public String getRevisionCd() {
	return revisionCd;
}

public void setRevisionCd(String revisionCd) {
	this.revisionCd = revisionCd;
}

public Timestamp getSbmtTime() {
	return sbmtTime;
}

public void setSbmtTime(Timestamp sbmtTime) {
	this.sbmtTime = sbmtTime;
}

public String getSbmtUserId() {
	return sbmtUserId;
}

public void setSbmtUserId(String sbmtUserId) {
	this.sbmtUserId = sbmtUserId;
}

public String getSbmtDeptCd() {
	return sbmtDeptCd;
}

public void setSbmtDeptCd(String sbmtDeptCd) {
	this.sbmtDeptCd = sbmtDeptCd;
}

public String getRfmReq() {
	return rfmReq;
}

public void setRfmReq(String rfmReq) {
	this.rfmReq = rfmReq;
}

public Timestamp getRfmTime() {
	return rfmTime;
}

public void setRfmTime(Timestamp rfmTime) {
	this.rfmTime = rfmTime;
}

public String getRfmUserId() {
	return rfmUserId;
}

public void setRfmUserId(String rfmUserId) {
	this.rfmUserId = rfmUserId;
}

public String getRfmDeptCd() {
	return rfmDeptCd;
}

public void setRfmDeptCd(String rfmDeptCd) {
	this.rfmDeptCd = rfmDeptCd;
}

public String getRfmDes() {
	return rfmDes;
}

public void setRfmDes(String rfmDes) {
	this.rfmDes = rfmDes;
}

public Timestamp getVrfTime() {
	return vrfTime;
}

public void setVrfTime(Timestamp vrfTime) {
	this.vrfTime = vrfTime;
}

public String getVrfUserId() {
	return vrfUserId;
}

public void setVrfUserId(String vrfUserId) {
	this.vrfUserId = vrfUserId;
}

public String getVrfDeptCd() {
	return vrfDeptCd;
}

public void setVrfDeptCd(String vrfDeptCd) {
	this.vrfDeptCd = vrfDeptCd;
}

public String getDrpDes() {
	return drpDes;
}

public void setDrpDes(String drpDes) {
	this.drpDes = drpDes;
}

public String getEnPk() {
	return enPk;
}

public void setEnPk(String enPk) {
	this.enPk = enPk;
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

public BigDecimal getOnceDropScore() {
	return onceDropScore;
}

public void setOnceDropScore(BigDecimal onceDropScore) {
	this.onceDropScore = onceDropScore;
}

public String getReq() {
	return req;
}

public void setReq(String req) {
	this.req = req;
}

public String getMrPk() {
	return mrPk;
}

public void setMrPk(String mrPk) {
	this.mrPk = mrPk;
}

public Integer getDeductScrTimes() {
	return deductScrTimes;
}

public void setDeductScrTimes(Integer deductScrTimes) {
	this.deductScrTimes = deductScrTimes;
}

public String getDeductDes() {
	return deductDes;
}

public void setDeductDes(String deductDes) {
	this.deductDes = deductDes;
}

public String getFltStaNm() {
	return fltStaNm;
}

public void setFltStaNm(String fltStaNm) {
	this.fltStaNm = fltStaNm;
}

public String getCrtUserNm() {
	return crtUserNm;
}

public void setCrtUserNm(String crtUserNm) {
	this.crtUserNm = crtUserNm;
}

public String getRfmUserNm() {
	return rfmUserNm;
}

public void setRfmUserNm(String rfmUserNm) {
	this.rfmUserNm = rfmUserNm;
}

public String getRfmDeptNm() {
	return rfmDeptNm;
}

public void setRfmDeptNm(String rfmDeptNm) {
	this.rfmDeptNm = rfmDeptNm;
}

public String getMrName() {
	return mrName;
}

public void setMrName(String mrName) {
	this.mrName = mrName;
}



}