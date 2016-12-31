package pkuhit.iih.qa;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

import org.seasar.doma.Id;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class QaDivideModel extends BaseBizModel {
 public QaDivideModel(){
  super();
 }
 public QaDivideModel(String code){
  super(code);
 }

public static final String   OBJ_CD  = "QAM12";

/** 评分编码 */
@Column(name = "QA_DIVIDE_CD")
private  String qaDivideCd;

/** 质控项 */
@Column(name = "QA_ITM_PK")
private  String qaItmPk;

/** 质控类型 */
@Column(name = "QA_TY_CD")
private  String qaTyCd;

/** 提出时间 */
@Column(name = "SBMT_TIME")
private  Timestamp sbmtTime;

/** 提出人 */
@Column(name = "SBMT_USER_ID")
private  String sbmtUserId;

@DictionaryTag(code = "sbmtUserId", objCd = "ORGB04")
private String sbmtUserNm;

/** 提出科室 */
@Column(name = "SBMT_DEPT_CD")
private  String sbmtDeptCd;

/** 整改要求 */
@Column(name = "RFM_REQ")
private  String rfmReq;

/** 扣分说明 */
@Column(name = "DRP_DES")
private  String drpDes;

/** 就诊序号 */
@Column(name = "EN_PK")
private  String enPk;

/** 缺扣分次数 */
@Column(name = "DEDUCT_SCR_TIMES")
private  Integer deductScrTimes;

/** 最后得分 */
@Column(name = "QA_SCR")
private  BigDecimal qaScr;

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

@DictionaryTag(code = "crtDeptCd", objCd = "ORGB01")
private String crtDeptNm;

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

/** */
@Column(name = "DCT_NS_F")
private  Short dctNsF;

/** 病案号*/
	@Column(name = "AMR_NO")
	private String amrNo;
	
	/** 患者名称*/
	@Column(name = "PA_NM")
	private String patientName;
	
	/** 当前主诊断编码*/
	@Column(name = "CUR_MAIN_DI_CD")
	private String currentMainDiagnosisCode;
	
/** 当前主诊断名称*/
	@DictionaryTag(code = "currentMainDiagnosisCode", objCd = "DIM01")
	private String currentMainDiagnosisName;
	
	/** 当前主管医生ID */
 	@Column(name = "CUR_MNG_DCT_ID")
 	private String currentManageDoctorId;
    
    /** 当前主管医生名称 */
 	@DictionaryTag(code = "currentManageDoctorId", objCd = "ORGB04")
 	private String currentManageDoctorName;
 	
 	//患者ID
  	@Column(name = "PA_ID")
  	private String patientId;
    
    //性别编码
  	@Column(name = "SEX_CD")
  	private String sexCode;
  	
 // 性别名称
 	@DictionaryTag(code = "sexCode", objCd = "MDM05")
 	private String sexName;
 	
 	//年龄
	@Column(name = "AGE")
	private String age;
	
	// 当前床位编码
	@Column(name = "CUR_BED_CD")
	private String currentBedCode;
	
	// 就诊接诊时间
	@Column(name = "RCV_TIME")
	private Date receiveTime;
	
	//缺陷数
	@Column(name = "DEFECTCOUNT")
	private BigDecimal defectCount;

/** 质控要求-质控项目表 */
@Column(name = "REQ")
 private String req;

/** 编码-质控项目一级分类 */
@Column(name = "FST_CD")
private String fstCd;

/** 名称-质控项目一级分类 */
@Column(name = "NM")
private String itemFirstNM;

/** 扣分说明 */
@Column(name = "DEDUCT_DES")
private String deductDes;

/** 扣分标准-质控项目表====算分用*/
@Column(name = "ONCE_DRP_SCR")
private  BigDecimal onceDropScore;


/** 二级分类 */
@Column(name = "SND_CD")
 private String sndCd;

/** 一级分类最大分值，自定义 */
@Column(name = "FIRSTMAXSCORE")
 private BigDecimal firstMaxScore;

/** 二级分类最大分值，自定义 */
@Column(name = "SECONDMAXSCORE")
 private BigDecimal secondMaxScore;

/** 单质控项实际扣分，自定义 */
@Column(name = "ITEMSCORE")
 private BigDecimal itemScore;

/** 单质控项逻辑扣分-不判断单项最大扣分限制，自定义 */
@Column(name = "itemScoreTemp")
 private BigDecimal itemScoreTemp;

/** 质控扣分类型 */
@Column(name = "QA_DRP_SCR_TP_CD")
 private String qaDrpScrTpCd;

/** 二级分类实际得分，自定义 */

 private BigDecimal secondDropScore;
 
 /** 一级分类实际得分，自定义 */

 private BigDecimal firstDropScore;
 
 /** 二级分类如果达到扣分最大值改属性为true，自定义 */

 private boolean secondScoreFlag;
 
 /**一级分类如果达到扣分最大值改属性为true，自定义 */

 private boolean firstScoreFlag;
 
 /**单否乙得分，自定义 */

 private BigDecimal gradeBScore;
 
 /**单否丙得分，自定义 */

 private BigDecimal gradeCScore;
 


public String getQaDivideCd() {
	return qaDivideCd;
}

public void setQaDivideCd(String qaDivideCd) {
	this.qaDivideCd = qaDivideCd;
}

public String getQaItmPk() {
	return qaItmPk;
}

public void setQaItmPk(String qaItmPk) {
	this.qaItmPk = qaItmPk;
}

public String getQaTyCd() {
	return qaTyCd;
}

public void setQaTyCd(String qaTyCd) {
	this.qaTyCd = qaTyCd;
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

public Integer getDeductScrTimes() {
	return deductScrTimes;
}

public void setDeductScrTimes(Integer deductScrTimes) {
	this.deductScrTimes = deductScrTimes;
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

public String getReq() {
	return req;
}

public void setReq(String req) {
	this.req = req;
}

public String getFstCd() {
	return fstCd;
}

public void setFstCd(String fstCd) {
	this.fstCd = fstCd;
}

public String getItemFirstNM() {
	return itemFirstNM;
}

public void setItemFirstNM(String itemFirstNM) {
	this.itemFirstNM = itemFirstNM;
}

public String getDeductDes() {
	return deductDes;
}

public void setDeductDes(String deductDes) {
	this.deductDes = deductDes;
}

public BigDecimal getOnceDropScore() {
	return onceDropScore;
}

public void setOnceDropScore(BigDecimal onceDropScore) {
	this.onceDropScore = onceDropScore;
}

public String getSndCd() {
	return sndCd;
}

public void setSndCd(String sndCd) {
	this.sndCd = sndCd;
}

public boolean isSecondScoreFlag() {
	return secondScoreFlag;
}

public void setSecondScoreFlag(boolean secondScoreFlag) {
	this.secondScoreFlag = secondScoreFlag;
}

public boolean isFirstScoreFlag() {
	return firstScoreFlag;
}

public void setFirstScoreFlag(boolean firstScoreFlag) {
	this.firstScoreFlag = firstScoreFlag;
}

public BigDecimal getQaScr() {
	return qaScr;
}

public void setQaScr(BigDecimal qaScr) {
	this.qaScr = qaScr;
}

public BigDecimal getFirstMaxScore() {
	return firstMaxScore;
}

public void setFirstMaxScore(BigDecimal firstMaxScore) {
	this.firstMaxScore = firstMaxScore;
}

public BigDecimal getSecondMaxScore() {
	return secondMaxScore;
}

public void setSecondMaxScore(BigDecimal secondMaxScore) {
	this.secondMaxScore = secondMaxScore;
}

public BigDecimal getItemScore() {
	return itemScore;
}

public void setItemScore(BigDecimal itemScore) {
	this.itemScore = itemScore;
}

public BigDecimal getItemScoreTemp() {
	return itemScoreTemp;
}

public void setItemScoreTemp(BigDecimal itemScoreTemp) {
	this.itemScoreTemp = itemScoreTemp;
}

public BigDecimal getSecondDropScore() {
	return secondDropScore;
}

public void setSecondDropScore(BigDecimal secondDropScore) {
	this.secondDropScore = secondDropScore;
}

public BigDecimal getFirstDropScore() {
	return firstDropScore;
}

public void setFirstDropScore(BigDecimal firstDropScore) {
	this.firstDropScore = firstDropScore;
}


public BigDecimal getGradeBScore() {
	return gradeBScore;
}

public void setGradeBScore(BigDecimal gradeBScore) {
	this.gradeBScore = gradeBScore;
}

public BigDecimal getGradeCScore() {
	return gradeCScore;
}

public void setGradeCScore(BigDecimal gradeCScore) {
	this.gradeCScore = gradeCScore;
}

public String getQaDrpScrTpCd() {
	return qaDrpScrTpCd;
}

public void setQaDrpScrTpCd(String qaDrpScrTpCd) {
	this.qaDrpScrTpCd = qaDrpScrTpCd;
}

public String getAmrNo() {
	return amrNo;
}

public void setAmrNo(String amrNo) {
	this.amrNo = amrNo;
}

public String getPatientName() {
	return patientName;
}

public void setPatientName(String patientName) {
	this.patientName = patientName;
}

public String getCurrentMainDiagnosisCode() {
	return currentMainDiagnosisCode;
}

public void setCurrentMainDiagnosisCode(String currentMainDiagnosisCode) {
	this.currentMainDiagnosisCode = currentMainDiagnosisCode;
}

public String getCurrentMainDiagnosisName() {
	return currentMainDiagnosisName;
}

public void setCurrentMainDiagnosisName(String currentMainDiagnosisName) {
	this.currentMainDiagnosisName = currentMainDiagnosisName;
}

public String getCurrentManageDoctorId() {
	return currentManageDoctorId;
}

public void setCurrentManageDoctorId(String currentManageDoctorId) {
	this.currentManageDoctorId = currentManageDoctorId;
}

public String getCurrentManageDoctorName() {
	return currentManageDoctorName;
}

public void setCurrentManageDoctorName(String currentManageDoctorName) {
	this.currentManageDoctorName = currentManageDoctorName;
}

public String getPatientId() {
	return patientId;
}

public void setPatientId(String patientId) {
	this.patientId = patientId;
}

public String getSexCode() {
	return sexCode;
}

public void setSexCode(String sexCode) {
	this.sexCode = sexCode;
}

public String getSexName() {
	return sexName;
}

public void setSexName(String sexName) {
	this.sexName = sexName;
}

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getCurrentBedCode() {
	return currentBedCode;
}

public void setCurrentBedCode(String currentBedCode) {
	this.currentBedCode = currentBedCode;
}

public Date getReceiveTime() {
	return receiveTime;
}

public void setReceiveTime(Date receiveTime) {
	this.receiveTime = receiveTime;
}

public String getCrtDeptNm() {
	return crtDeptNm;
}

public void setCrtDeptNm(String crtDeptNm) {
	this.crtDeptNm = crtDeptNm;
}

public BigDecimal getDefectCount() {
	return defectCount;
}

public void setDefectCount(BigDecimal defectCount) {
	this.defectCount = defectCount;
}

public String getSbmtUserNm() {
	return sbmtUserNm;
}

public void setSbmtUserNm(String sbmtUserNm) {
	this.sbmtUserNm = sbmtUserNm;
}

public Short getDctNsF() {
	return dctNsF;
}

public void setDctNsF(Short dctNsF) {
	this.dctNsF = dctNsF;
}


}