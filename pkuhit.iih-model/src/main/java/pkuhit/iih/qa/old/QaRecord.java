package pkuhit.iih.qa.old;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class QaRecord extends BaseBizModel {
 public QaRecord(){
  super();
 }
 public QaRecord(String code){
  super(code);
 }

public static final String   OBJ_CD  = "QAB01";
//质控类型编码 环节质控
public static final   String  QA_TYPE_CODE_INPROCESS= "QAM13.01";
//质控类型编码 科室质控
public static final   String  QA_TYPE_CODE_DEPT= "QAM13.02";
//质控类型编码 终末质控
public static final   String  QA_TYPE_CODE_TERMINAL= "QAM13.03";
// 质控主键
public static final   String  PK = "QAB01.AT01";
// 质控体系编码
public static final   String  QA_SYSTEM_CODE = "QAB01.AT02";
// 就诊主键
public static final   String  ENCOUNTER_PK = "QAB01.AT03";
// 质控类型编码
public static final   String  QA_TYPE_CODE = "QAB01.AT04";
// 自动质控标志
public static final   String  AUTO_FLAG = "QAB01.AT05";
// 计划开始质控时间
public static final   String  PLAN_TIME = "QAB01.AT06";
// 实际开始时间
public static final   String  EXECUTE_BEGIN_TIME = "QAB01.AT07";
// 实际结束时间
public static final   String  EXECUTE_END_TIME = "QAB01.AT08";
// 实际执行人ID
public static final   String  EXCUTE_USER_ID = "QAB01.AT09";
// 实际执行科室编码
public static final   String  EXECUTE_DEPT_CODE = "QAB01.AT10";
// 完成标志
public static final   String  COMPLETED_FLAG = "QAB01.AT11";
// 有缺陷标志
public static final   String  HAVE_FAULT_FLAG = "QAB01.AT12";
// 有需要整改缺陷标志
public static final   String  NEED_REFORM_FAULT_FLAG = "QAB01.AT13";
// 整改期限
public static final   String  REFORM_DEADLINE = "QAB01.AT14";

// 质控主键
@Column(name="QA_PK") 
private  String pk;
// 质控体系编码
@Column(name="QA_SYS_CD") 
private  String qaSystemCode;
// 就诊主键
@Column(name="EN_PK") 
private  String encounterPk;
// 质控类型编码
@Column(name="QA_TY_CD") 
private  String qaTypeCode;
// 自动质控标志
@Column(name="AUTO_F") 
private  Short autoFlag;
// 计划开始质控时间
@Column(name="PLAN_TIME") 
private  Date planTime;
// 实际开始时间
@Column(name="EXEC_BEGIN_TIME") 
private  Date executeBeginTime;
// 实际结束时间
@Column(name="EXEC_END_TIME") 
private  Date executeEndTime;
// 实际执行人ID
@Column(name="EXEC_USER_ID") 
private  String excuteUserId;
// 实际执行科室编码
@Column(name="EXEC_DEPT_CD") 
private  String executeDeptCode;
// 完成标志
@Column(name="CMPL_F") 
private  Short completedFlag;
// 有缺陷标志
@Column(name="HAVE_FLT_F") 
private  Short haveFaultFlag;
// 有需要整改缺陷标志
@Column(name="NEED_RFM_FLT_F") 
private  Short needReformFaultFlag;
// 整改期限
@Column(name="RFM_DEADLINE") 
private  BigInteger reformDeadline;
// 质控体系名称
@DictionaryTag(code = "qaSystemCode" ,objCd = "")
private  String qaSystemName;
// 质控类型名称
@DictionaryTag(code = "qaTypeCode")
private  String qaTypeName;
// 实际执行人名称
//@DictionaryTag(code = "excuteUserId")
private  String excuteUserName;
// 实际执行科室名称
//@DictionaryTag(code = "executeDeptCode")
private  String executeDeptName;
// 整改截止日期
private  Date deadline;


// 病案号
private  String amrNo;
// 患者姓名
private  String patientName;
// 就诊科室
private  String encounterDept;
// 床位号
private  String bedNo;
// 共处理缺陷
@Column(name = "FAULTTOTAL")
private  BigDecimal faultTotal;
// 需整改缺陷
@Column(name = "FAULTTODOREFORM")
private  BigDecimal faultTodoReform;
// 审核通过缺陷
@Column(name = "FAULTREVIEWED")
private  BigDecimal faultReviewed;
// 再整改缺陷
@Column(name = "FAULTREFORMED")
private  BigDecimal faultReformed;
//待审核缺陷
@Column(name = "FAULTTODOREVIEW")
private BigDecimal faultTodoReview;
// 新提出缺陷
@Column(name = "FAULTSUBMITED")
private  BigDecimal faultSubmited;

//质控通知 主键
@Column(name = "REVISION_CD")
private  String revisionCd;
public String getRevisionCd() {
	return revisionCd;
}

public void setRevisionCd(String revisionCd) {
	this.revisionCd = revisionCd;
}

public String getPk()
 {
     return this.pk;
 }
public  void  setPk(String pk)
 {
  this.pk = pk;
 }
public String getQaSystemCode()
 {
     return this.qaSystemCode;
 }
public  void  setQaSystemCode(String qaSystemCode)
 {
  this.qaSystemCode = qaSystemCode;
 }
public String getEncounterPk()
 {
     return this.encounterPk;
 }
public  void  setEncounterPk(String encounterPk)
 {
  this.encounterPk = encounterPk;
 }
public String getQaTypeCode()
 {
     return this.qaTypeCode;
 }
public  void  setQaTypeCode(String qaTypeCode)
 {
  this.qaTypeCode = qaTypeCode;
 }
public Short getAutoFlag()
 {
     return this.autoFlag;
 }
public  void  setAutoFlag(Short autoFlag)
 {
  this.autoFlag = autoFlag;
 }
public Date getPlanTime()
 {
     return this.planTime;
 }
public  void  setPlanTime(Date planTime)
 {
  this.planTime = planTime;
 }
public Date getExecuteBeginTime()
 {
     return this.executeBeginTime;
 }
public  void  setExecuteBeginTime(Date executeBeginTime)
 {
  this.executeBeginTime = executeBeginTime;
 }
public Date getExecuteEndTime()
 {
     return this.executeEndTime;
 }
public  void  setExecuteEndTime(Date executeEndTime)
 {
  this.executeEndTime = executeEndTime;
 }
public String getExcuteUserId()
 {
     return this.excuteUserId;
 }
public  void  setExcuteUserId(String excuteUserId)
 {
  this.excuteUserId = excuteUserId;
 }
public String getExecuteDeptCode()
 {
     return this.executeDeptCode;
 }
public  void  setExecuteDeptCode(String executeDeptCode)
 {
  this.executeDeptCode = executeDeptCode;
 }
public Short getCompletedFlag()
 {
     return this.completedFlag;
 }
public  void  setCompletedFlag(Short completedFlag)
 {
  this.completedFlag = completedFlag;
 }
public Short getHaveFaultFlag()
 {
     return this.haveFaultFlag;
 }
public  void  setHaveFaultFlag(Short haveFaultFlag)
 {
  this.haveFaultFlag = haveFaultFlag;
 }
public Short getNeedReformFaultFlag()
 {
     return this.needReformFaultFlag;
 }
public  void  setNeedReformFaultFlag(Short needReformFaultFlag)
 {
  this.needReformFaultFlag = needReformFaultFlag;
 }
public BigInteger getReformDeadline()
 {
     return this.reformDeadline;
 }
public  void  setReformDeadline(BigInteger reformDeadline)
 {
  this.reformDeadline = reformDeadline;
 }
public String getQaSystemName()
 {
     return this.qaSystemName;
 }
public  void  setQaSystemName(String qaSystemName)
 {
  this.qaSystemName = qaSystemName;
 }
public String getQaTypeName()
 {
     return this.qaTypeName;
 }
public  void  setQaTypeName(String qaTypeName)
 {
  this.qaTypeName = qaTypeName;
 }
public String getExcuteUserName()
 {
     return this.excuteUserName;
 }
public  void  setExcuteUserName(String excuteUserName)
 {
  this.excuteUserName = excuteUserName;
 }
public String getExecuteDeptName()
 {
     return this.executeDeptName;
 }
public  void  setExecuteDeptName(String executeDeptName)
 {
  this.executeDeptName = executeDeptName;
 }
public Date getDeadline()
 {
     return this.deadline;
 }
public  void  setDeadline(Date deadline)
 {
  this.deadline = deadline;
 }
public String getAmrNo()
 {
     return this.amrNo;
 }
public  void  setAmrNo(String amrNo)
 {
  this.amrNo = amrNo;
 }
public String getPatientName()
 {
     return this.patientName;
 }
public  void  setPatientName(String patientName)
 {
  this.patientName = patientName;
 }
public String getEncounterDept()
 {
     return this.encounterDept;
 }
public  void  setEncounterDept(String encounterDept)
 {
  this.encounterDept = encounterDept;
 }
public String getBedNo()
 {
     return this.bedNo;
 }
public  void  setBedNo(String bedNo)
 {
  this.bedNo = bedNo;
 }

public BigDecimal getFaultTotal() {
	return faultTotal;
}

public void setFaultTotal(BigDecimal faultTotal) {
	this.faultTotal = faultTotal;
}

public BigDecimal getFaultTodoReform() {
	return faultTodoReform;
}

public void setFaultTodoReform(BigDecimal faultTodoReform) {
	this.faultTodoReform = faultTodoReform;
}

public BigDecimal getFaultReviewed() {
	return faultReviewed;
}

public void setFaultReviewed(BigDecimal faultReviewed) {
	this.faultReviewed = faultReviewed;
}

public BigDecimal getFaultReformed() {
	return faultReformed;
}

public void setFaultReformed(BigDecimal faultReformed) {
	this.faultReformed = faultReformed;
}

public BigDecimal getFaultSubmited() {
	return faultSubmited;
}

public void setFaultSubmited(BigDecimal faultSubmited) {
	this.faultSubmited = faultSubmited;
}

public BigDecimal getFaultTodoReview() {
	return faultTodoReview;
}

public void setFaultTodoReview(BigDecimal faultTodoReview) {
	this.faultTodoReview = faultTodoReview;
}
}