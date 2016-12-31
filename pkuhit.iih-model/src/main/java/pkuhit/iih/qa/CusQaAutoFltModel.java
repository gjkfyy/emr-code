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


public class CusQaAutoFltModel extends BaseBizModel {

 public CusQaAutoFltModel(){

  super();

 }

 public CusQaAutoFltModel(String code){

  super(code);

 }
 
 public static final String TIMELIMIT = "QAM06.02";   //时限性
 public static final String FREQUENCY = "QAM06.05";    //频率性
 public static final String INTEGRITY = "QAM06.04";    //完整性
 
	 /** 主键 */
	 @Id
	 @Column(name = "QA_AUTO_FLT_PK")
	 String qaAutoFltPk;
	
	 /** 质控项编码 */
	 @Column(name = "QA_ITM_CD")
	 String qaItmCd;
	
	 /** 文书 */
	 @Column(name = "DOC_SN")
	 String docSn;
	
	 /** 事件编码 */
	 @Column(name = "EVENT_ID")
	 String eventId;
	
	 /** 开始时间 */
	 @Column(name = "BEGIN_TIME")
	 Timestamp beginTime;
	
	 /** 结束时间 */
	 @Column(name = "END_TIME")
	 Timestamp endTime;
	
	 /** 就诊序号 */
	 @Column(name = "ENCOUNTER_SN")
	 String encounterSn;
	
	 /** 完成时间 */
	 @Column(name = "COMPLETE_TIME")
	 Date completeTime;
	
	 /** 申请标识。0：未生成申请 1已生成申请 */
	 @Column(name = "APPLY_FLAG")
	 Short applyFlag;
	
	 /** 缺陷标识。0：未生成缺陷 1已生成缺陷 */
	 @Column(name = "FLT_FLAG")
	 Short fltFlag;
	
	 @Column(name = "QA_ITM_CONFIG_CD")
	 String qaItmConfigCd;
	
	
	 /** 质控项说明 */
	 @Column(name = "REQ")
	 String req;
	
	 /** 病历文书类型 */
	 @Column(name = "MR_TYPES")
	 String mrTypes;
	
	 /** 事件类型 */
	 @Column(name = "EVENT_TYPE_CODE")
	 String eventTypeCode;
	
	 /** 期限时间 */
	 @Column(name = "DEAD_HOURS")
	 BigDecimal deadHours;
	
	 /** 启用标记 */
	 @Column(name = "USE_FLAG")
	 String useFlag;

	 /** 描述*/
	 @Column(name = "MEMO")
	 String memo;
	 
	 /** 质控项目类别*/
	 @Column(name = "QA_ITM_TP_CD")
	 String qaItmType;

	 /** 文书操作类型 */
    @Column(name = "MR_OP_TYPE")
    String mrOpType;

    /** 质控项目类别,主数据QAM06：时限性、频率性、完整性 */
    @Column(name = "QA_ITM_TP_CD")
    String qaItmTpCd;

    /** 医生操作类型 01提交 02查房 */
    @Column(name = "DCT_OP_TP_CD")
    String dctOpTpCd;

    /** 医生职称 */
    @Column(name = "JOB_TITLE_CD")
    String jobTitleCd;

    /** 校验规则类型，频率质控：01重复性 02连续性 */
    @Column(name = "QA_RL_TP_CD")
    String qaRlTpCd;

    /** 校验规则 */
    @Column(name = "QA_RL_CD")
    BigDecimal qaRlCd;
    
    /** 校验规则 王艳丽 */
    @Column(name = "QA_RL_CD")
    String qaRuleCd;
	 
    /** 当前主管医生ID */
 	@Column(name = "CUR_MNG_DCT_ID")
 	private String currentManageDoctorId;
    
    /** 当前主管医生名称 */
 	@DictionaryTag(code = "currentManageDoctorId", objCd = "ORGB04")
 	private String currentManageDoctorName;
 	
 // 当前科室编码
 	@Column(name = "CUR_DEPT_CD")
 	private String currentDeptCode;
 	
 // 当前科室名称
 	@DictionaryTag(code = "currentDeptCode", objCd = "ORGB01")
 	private String currentDeptName;
 	
 // 出诊科室编码
  	@Column(name = "DEPT_CD")
  	private String deptCd;
 	
  //住院号
  	@Column(name = "AMR_NO")
  	private String amrNo;
 	//患者名称
	@Column(name = "PA_NM")
	private String patientName;
	
	//病历文书类型名称
	@Column(name = "NM")
	private String nm;
 	
 	//缺陷数
 	@Column(name = "DEFECTCOUNT")
 	private BigDecimal defectCount;
    
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
	
	 /** */
	 @Column(name = "DIV_FLAG")
	 Short divFlag;
	 
	 
	 
	 public Short getDivFlag() {
		return divFlag;
	}

	public void setDivFlag(Short divFlag) {
		this.divFlag = divFlag;
	}

	/** 
	  * Returns the qaItmConfigCd.
	  * 
	  * @return the qaItmConfigCd
	  */
	 public String getQaItmConfigCd() {
	     return qaItmConfigCd;
	 }
	
	 /** 
	  * Sets the qaItmConfigCd.
	  * 
	  * @param qaItmConfigCd the qaItmConfigCd
	  */
	 public void setQaItmConfigCd(String qaItmConfigCd) {
	     this.qaItmConfigCd = qaItmConfigCd;
	 }
	
	 /** 
	  * Returns the qaItmCd.
	  * 
	  * @return the qaItmCd
	  */
	 public String getQaItmCd() {
	     return qaItmCd;
	 }
	
	 /** 
	  * Sets the qaItmCd.
	  * 
	  * @param qaItmCd the qaItmCd
	  */
	 public void setQaItmCd(String qaItmCd) {
	     this.qaItmCd = qaItmCd;
	 }
	
	 /** 
	  * Returns the req.
	  * 
	  * @return the req
	  */
	 public String getReq() {
	     return req;
	 }
	
	 /** 
	  * Sets the req.
	  * 
	  * @param req the req
	  */
	 public void setReq(String req) {
	     this.req = req;
	 }
	
	 /** 
	  * Returns the mrTypes.
	  * 
	  * @return the mrTypes
	  */
	 public String getMrTypes() {
	     return mrTypes;
	 }
	
	 /** 
	  * Sets the mrTypes.
	  * 
	  * @param mrTypes the mrTypes
	  */
	 public void setMrTypes(String mrTypes) {
	     this.mrTypes = mrTypes;
	 }
	
	 /** 
	  * Returns the eventTypeCode.
	  * 
	  * @return the eventTypeCode
	  */
	 public String getEventTypeCode() {
	     return eventTypeCode;
	 }
	
	 /** 
	  * Sets the eventTypeCode.
	  * 
	  * @param eventTypeCode the eventTypeCode
	  */
	 public void setEventTypeCode(String eventTypeCode) {
	     this.eventTypeCode = eventTypeCode;
	 }
	
	 /** 
	  * Returns the deadHours.
	  * 
	  * @return the deadHours
	  */
	 public BigDecimal getDeadHours() {
	     return deadHours;
	 }
	
	 /** 
	  * Sets the deadHours.
	  * 
	  * @param deadHours the deadHours
	  */
	 public void setDeadHours(BigDecimal deadHours) {
	     this.deadHours = deadHours;
	 }
	
	 /** 
	  * Returns the useFlag.
	  * 
	  * @return the useFlag
	  */
	 public String getUseFlag() {
	     return useFlag;
	 }
	
	 /** 
	  * Sets the useFlag.
	  * 
	  * @param useFlag the useFlag
	  */
	 public void setUseFlag(String useFlag) {
	     this.useFlag = useFlag;
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

	public String getMrOpType() {
		return mrOpType;
	}

	public void setMrOpType(String mrOpType) {
		this.mrOpType = mrOpType;
	}

	public String getQaItmType() {
		return qaItmType;
	}

	public void setQaItmType(String qaItmType) {
		this.qaItmType = qaItmType;
	}

	public String getQaItmTpCd() {
		return qaItmTpCd;
	}

	public void setQaItmTpCd(String qaItmTpCd) {
		this.qaItmTpCd = qaItmTpCd;
	}

	public String getDctOpTpCd() {
		return dctOpTpCd;
	}

	public void setDctOpTpCd(String dctOpTpCd) {
		this.dctOpTpCd = dctOpTpCd;
	}

	public String getJobTitleCd() {
		return jobTitleCd;
	}

	public void setJobTitleCd(String jobTitleCd) {
		this.jobTitleCd = jobTitleCd;
	}

	public String getQaRlTpCd() {
		return qaRlTpCd;
	}

	public void setQaRlTpCd(String qaRlTpCd) {
		this.qaRlTpCd = qaRlTpCd;
	}

	public BigDecimal getQaRlCd() {
		return qaRlCd;
	}

	public void setQaRlCd(BigDecimal qaRlCd) {
		this.qaRlCd = qaRlCd;
	}

	public String getQaRuleCd() {
		return qaRuleCd;
	}

	public void setQaRuleCd(String qaRuleCd) {
		this.qaRuleCd = qaRuleCd;
	}

	public String getQaAutoFltPk() {
		return qaAutoFltPk;
	}

	public void setQaAutoFltPk(String qaAutoFltPk) {
		this.qaAutoFltPk = qaAutoFltPk;
	}

	public String getDocSn() {
		return docSn;
	}

	public void setDocSn(String docSn) {
		this.docSn = docSn;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Timestamp getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getEncounterSn() {
		return encounterSn;
	}

	public void setEncounterSn(String encounterSn) {
		this.encounterSn = encounterSn;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Short getApplyFlag() {
		return applyFlag;
	}

	public void setApplyFlag(Short applyFlag) {
		this.applyFlag = applyFlag;
	}

	public Short getFltFlag() {
		return fltFlag;
	}

	public void setFltFlag(Short fltFlag) {
		this.fltFlag = fltFlag;
	}

	public static String getTimelimit() {
		return TIMELIMIT;
	}

	public static String getFrequency() {
		return FREQUENCY;
	}

	public static String getIntegrity() {
		return INTEGRITY;
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

	public BigDecimal getDefectCount() {
		return defectCount;
	}

	public void setDefectCount(BigDecimal defectCount) {
		this.defectCount = defectCount;
	}

	public String getCurrentDeptCode() {
		return currentDeptCode;
	}

	public void setCurrentDeptCode(String currentDeptCode) {
		this.currentDeptCode = currentDeptCode;
	}

	public String getCurrentDeptName() {
		return currentDeptName;
	}

	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	public String getAmrNo() {
		return amrNo;
	}

	public void setAmrNo(String amrNo) {
		this.amrNo = amrNo;
	}
	
}