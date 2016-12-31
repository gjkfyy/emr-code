package pkuhit.iih.qa.old;
import java.math.BigDecimal;
import java.util.Date;

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

public static final String   OBJ_CD  = "QAB03";

//缺陷确认结果编码 未确认
public static final   String  FLT_CFM_RST_CD_UNCONFIRMED= "QAM07.01";
//缺陷确认结果编码 需整改
public static final   String  FLT_CFM_RST_CD_NEEDREFORM= "QAM07.02";
//缺陷确认结果编码 需扣分
public static final   String  FLT_CFM_RST_CD_NEETDROPSCORE= "QAM07.03";
//缺陷确认结果编码 不扣分
public static final   String  FLT_CFM_RST_CD_NONDROPSCORE= "QAM07.04";


//质控项目扣分类型 仅一次扣
public static final   String  QA_TYPE_CODE_ONCE= "QAM02.01";
//质控项目扣分类型 可多次扣分
public static final   String  QA_TYPE_CODE_MTO= "QAM02.02";
//质控项目扣分类型 单否乙级
public static final   String  QA_TYPE_CODE_GRADEB= "QAM02.03";
//质控项目扣分类型 单否丙级
public static final   String  QA_TYPE_CODE_GRADEC= "QAM02.04";


//缺陷状态 新建
public static final   String  STATUS_CODE_CREATED= "QAM01.01";
//缺陷状态 已提出
public static final   String  STATUS_CODE_SUBMITTED= "QAM01.02";
//缺陷状态 已整改
public static final   String  STATUS_CODE_REFORMED= "QAM01.03";
//缺陷状态 已审核
public static final   String  STATUS_CODE_VERIFIED= "QAM01.04";
// 缺陷主键
public static final   String  PK = "QAB03.AT01";
// 质控项目主键
public static final   String  QA_ITEM_PK = "QAB03.AT02";
// 质控体系质控项目编码
public static final   String  QA_SYSTEM_ITEM_CODE = "QAB03.AT03";
// 质控目标对象编码
public static final   String  TARGET_OBJECT_CODE = "QAB03.AT04";
// 质控目标对象主键
public static final   String  TARGET_OBJECT_PK = "QAB03.AT05";
// 质控来源对象编码
public static final   String  SOURCE_OBJECT_CODE = "QAB03.AT06";
// 质控来源对象主键
public static final   String  SOURCE_OBJECT_PK = "QAB03.AT07";
// 缺陷状态编码
public static final   String  STATUS_CODE = "QAB03.AT08";
// 提出时间
public static final   String  SUBMITTED_TIME = "QAB03.AT09";
// 提出人ID
public static final   String  SUBMITTED_USER_ID = "QAB03.AT10";
// 提出科室编码
public static final   String  SUBMITTED_DEPT_CODE = "QAB03.AT11";
// 整改要求
public static final   String  REFORM_REQUIREMENT = "QAB03.AT12";
// 整改标志
public static final   String  REFORM_FLAG = "QAB03.AT13";
// 整改时间
public static final   String  REFORMED_TIME = "QAB03.AT14";
// 整改人ID
public static final   String  REFORMED_USER_ID = "QAB03.AT15";
// 整改科室编码
public static final   String  REFORMED_DEPT_CODE = "QAB03.AT16";
// 整改说明
public static final   String  REFORMED_DESCRIPTION = "QAB03.AT17";
// 审核时间
public static final   String  VERIFIED_TIME = "QAB03.AT18";
// 审核者ID
public static final   String  VERIFIED_USER_ID = "QAB03.AT19";
// 审核科室编码
public static final   String  VERIFIED_DEPT_CODE = "QAB03.AT20";
// 扣分标志
public static final   String  DROP_FLAG = "QAB03.AT21";
// 扣分说明
public static final   String  DROP_DESCRIPTION = "QAB03.AT22";
// 段落类型编码
public static final   String  SEGMENT_TYPE_CODE = "QAB03.AT23";
// 缺陷来源编码
public static final   String  FAULT_FROM_CODE = "QAB03.AT24";
// 质控类型-环节质控
public static final   String  QA_TY_CD_PROCESS = "QAM13.01";
//质控类型-科室质控
public static final   String  QA_TY_CD_DEPT = "QAM13.02";
//质控类型-终末质控
public static final   String  QA_TY_CD_TERMINAL = "QAM13.03";



// 缺陷主键
@Column(name="QA_FLT_PK") 
private  String pk;
// 质控项目主键
@Column(name="QA_ITM_PK") 
private  String qaItemPk;
// 质控体系质控项目编码
@Column(name="EN_PK") 
private  String enPk;

//就诊编码
@Column(name="QA_SYS_ITM_CD") 
private  String qaSystemItemCode;
// 质控目标对象编码
@Column(name="TAR_OBJ_CD") 
private  String targetObjectCode;
// 质控目标对象主键
@Column(name="TAR_OBJ_PK") 
private  String targetObjectPk;
// 质控来源对象编码
@Column(name="SRC_OBJ_CD") 
private  String sourceObjectCode;
// 质控来源对象主键
@Column(name="SRC_OBJ_PK") 
private  String sourceObjectPk;
// 缺陷状态编码
@Column(name="FLT_STA_CD") 
private  String statusCode;
// 提出时间
@Column(name="SBMT_TIME") 
private  Date submittedTime;
// 提出人ID
@Column(name="SBMT_USER_ID") 
private  String submittedUserId;
// 提出科室编码
@Column(name="SBMT_DEPT_CD") 
private  String submittedDeptCode;
// 整改要求
@Column(name="RFM_REQ") 
private  String reformRequirement;
// 整改时间
@Column(name="RFM_TIME") 
private  Date reformedTime;
// 整改人ID
@Column(name="RFM_USER_ID") 
private  String reformedUserId;
// 整改科室编码
@Column(name="RFM_DEPT_CD") 
private  String reformedDeptCode;
// 整改说明
@Column(name="RFM_DES") 
private  String reformedDescription;
// 审核时间
@Column(name="VRF_TIME") 
private  Date verifiedTime;
// 审核者ID
@Column(name="VRF_USER_ID") 
private  String verifiedUserId;
// 审核科室编码
@Column(name="VRF_DEPT_CD") 
private  String verifiedDeptCode;
// 扣分说明
@Column(name="DRP_DES") 
private  String dropDescription;
// 段落类型编码
@Column(name="SEG_TP_CD") 
private  String segmentTypeCode;
// 缺陷来源编码
@Column(name="FLT_FROM_CD") 
private  String faultFromCode;

//缺陷确认结果编码
@Column(name="FLT_CFM_RST_CD")
private String faultConfirmResult;

//缺陷确认结果编码名称
@DictionaryTag(code = "faultConfirmResultName",objCd ="QAM07")
private String faultConfirmResultName;

// 缺陷状态名称
@DictionaryTag(code = "statusCode",objCd ="QAM12")
private  String statusName;

// 提出人名
//@DictionaryTag(code = "submittedUserId",objCd ="XAPM12")
private  String submittedUserName;

// 提出科室名称
//@DictionaryTag(code = "submittedDeptCode",objCd ="ORGB01")
private  String submittedDeptName;

// 整改人名
//@DictionaryTag(code = "reformedUserId",objCd ="XAPM12")
private  String reformedUserName;

// 整改科室名称
//@DictionaryTag(code = "reformedDeptCode",objCd ="ORGB01")
private  String reformedDeptName;

// 审核者名
//@DictionaryTag(code = "verifiedUserId",objCd ="XAPM12")
private  String verifiedUserName;

// 审核科室名称
//@DictionaryTag(code = "verifiedDeptCode",objCd ="ORGB01")
private  String verifiedDeptName;

// 段落类型名称
@DictionaryTag(code = "segmentTypeCode",objCd ="MRM01")
private  String segmentTypeName;

// 缺陷来源名称
@DictionaryTag(code = "faultFromCode",objCd ="QAM05")
private  String faultFromName;

// 逾期标志
@Column(name = "CANOVERDUE")
private  BigDecimal canOverdue;

// 可编辑标志
@Column(name = "CANEDIT")
private  BigDecimal canEdit;

// 质控目标对象名称
@DictionaryTag(code = "targetObjectCode",objCd ="MEB02")
private  String targetObjectName;

//医疗文书名称
@Column(name = "MRNAME")
private  String mrName;

// 质控体系质控项目名称
@Column(name = "QASYSTEMITEMNAME")
private  String qaSystemItemName;

/*// 单次扣分值
@Column(name = "ONCEDROPSCORE")
private  BigDecimal onceDropScore;*/

// 截止日期
@Column(name = "DEADLINE")
private  Date deadline;

// 质控来源对象名称
@DictionaryTag(code = "sourceObjectCode",objCd ="MEB02")
private  String sourceObjectName;

//质控工作记录编码
@Column(name = "QAPK")
private String qaPk;

//可整改标志
@Column(name = "CANREFORM")
private  BigDecimal canReform;

// 质控通知 主键
@Column(name = "REVISION_CD")
private  String revisionCd;

//质控通知 主键
@Column(name = "QA_TY_CD")
private  String qaTypeCode;


//扣分标准-质控项目表
@Column(name = "ONCE_DRP_SCR")
private  BigDecimal onceDropScore;

//扣分标准-质控项目表
@Column(name = "REQ")
private  String req;

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
public String getQaItemPk()
 {
     return this.qaItemPk;
 }
public  void  setQaItemPk(String qaItemPk)
 {
  this.qaItemPk = qaItemPk;
 }
public String getQaSystemItemCode()
 {
     return this.qaSystemItemCode;
 }
public  void  setQaSystemItemCode(String qaSystemItemCode)
 {
  this.qaSystemItemCode = qaSystemItemCode;
 }
public String getTargetObjectCode()
 {
     return this.targetObjectCode;
 }
public  void  setTargetObjectCode(String targetObjectCode)
 {
  this.targetObjectCode = targetObjectCode;
 }
public String getTargetObjectPk()
 {
     return this.targetObjectPk;
 }
public  void  setTargetObjectPk(String targetObjectPk)
 {
  this.targetObjectPk = targetObjectPk;
 }
public String getSourceObjectCode()
 {
     return this.sourceObjectCode;
 }
public  void  setSourceObjectCode(String sourceObjectCode)
 {
  this.sourceObjectCode = sourceObjectCode;
 }
public String getSourceObjectPk()
 {
     return this.sourceObjectPk;
 }
public  void  setSourceObjectPk(String sourceObjectPk)
 {
  this.sourceObjectPk = sourceObjectPk;
 }
public String getStatusCode()
 {
     return this.statusCode;
 }
public  void  setStatusCode(String statusCode)
 {
  this.statusCode = statusCode;
 }
public String getSubmittedUserId()
 {
     return this.submittedUserId;
 }
public  void  setSubmittedUserId(String submittedUserId)
 {
  this.submittedUserId = submittedUserId;
 }
public String getSubmittedDeptCode()
 {
     return this.submittedDeptCode;
 }
public  void  setSubmittedDeptCode(String submittedDeptCode)
 {
  this.submittedDeptCode = submittedDeptCode;
 }
public String getReformRequirement()
 {
     return this.reformRequirement;
 }
public  void  setReformRequirement(String reformRequirement)
 {
  this.reformRequirement = reformRequirement;
 }
public String getReformedUserId()
 {
     return this.reformedUserId;
 }
public  void  setReformedUserId(String reformedUserId)
 {
  this.reformedUserId = reformedUserId;
 }
public String getReformedDeptCode()
 {
     return this.reformedDeptCode;
 }
public  void  setReformedDeptCode(String reformedDeptCode)
 {
  this.reformedDeptCode = reformedDeptCode;
 }
public String getReformedDescription()
 {
     return this.reformedDescription;
 }
public  void  setReformedDescription(String reformedDescription)
 {
  this.reformedDescription = reformedDescription;
 }
public String getVerifiedUserId()
 {
     return this.verifiedUserId;
 }
public  void  setVerifiedUserId(String verifiedUserId)
 {
  this.verifiedUserId = verifiedUserId;
 }
public String getVerifiedDeptCode()
 {
     return this.verifiedDeptCode;
 }
public  void  setVerifiedDeptCode(String verifiedDeptCode)
 {
  this.verifiedDeptCode = verifiedDeptCode;
 }
public String getDropDescription()
 {
     return this.dropDescription;
 }
public  void  setDropDescription(String dropDescription)
 {
  this.dropDescription = dropDescription;
 }
public String getSegmentTypeCode()
 {
     return this.segmentTypeCode;
 }
public  void  setSegmentTypeCode(String segmentTypeCode)
 {
  this.segmentTypeCode = segmentTypeCode;
 }
public String getFaultFromCode()
 {
     return this.faultFromCode;
 }
public  void  setFaultFromCode(String faultFromCode)
 {
  this.faultFromCode = faultFromCode;
 }
public String getStatusName()
 {
     return this.statusName;
 }
public  void  setStatusName(String statusName)
 {
  this.statusName = statusName;
 }
public String getSubmittedUserName()
 {
     return this.submittedUserName;
 }
public  void  setSubmittedUserName(String submittedUserName)
 {
  this.submittedUserName = submittedUserName;
 }
public String getSubmittedDeptName()
 {
     return this.submittedDeptName;
 }
public  void  setSubmittedDeptName(String submittedDeptName)
 {
  this.submittedDeptName = submittedDeptName;
 }
public String getReformedUserName()
 {
     return this.reformedUserName;
 }
public  void  setReformedUserName(String reformedUserName)
 {
  this.reformedUserName = reformedUserName;
 }
public String getReformedDeptName()
 {
     return this.reformedDeptName;
 }
public  void  setReformedDeptName(String reformedDeptName)
 {
  this.reformedDeptName = reformedDeptName;
 }
public String getVerifiedUserName()
 {
     return this.verifiedUserName;
 }
public  void  setVerifiedUserName(String verifiedUserName)
 {
  this.verifiedUserName = verifiedUserName;
 }
public String getVerifiedDeptName()
 {
     return this.verifiedDeptName;
 }
public  void  setVerifiedDeptName(String verifiedDeptName)
 {
  this.verifiedDeptName = verifiedDeptName;
 }
public String getSegmentTypeName()
 {
     return this.segmentTypeName;
 }
public  void  setSegmentTypeName(String segmentTypeName)
 {
  this.segmentTypeName = segmentTypeName;
 }
public String getFaultFromName()
 {
     return this.faultFromName;
 }
public  void  setFaultFromName(String faultFromName)
 {
  this.faultFromName = faultFromName;
 }
public BigDecimal getCanOverdue()
 {
     return this.canOverdue;
 }
public  void  setCanOverdue(BigDecimal canOverdue)
 {
  this.canOverdue = canOverdue;
 }
public BigDecimal getCanEdit()
 {
     return this.canEdit;
 }
public  void  setCanEdit(BigDecimal canEdit)
 {
  this.canEdit = canEdit;
 }
public String getTargetObjectName()
 {
     return this.targetObjectName;
 }
public  void  setTargetObjectName(String targetObjectName)
 {
  this.targetObjectName = targetObjectName;
 }
public String getQaSystemItemName()
 {
     return this.qaSystemItemName;
 }
public  void  setQaSystemItemName(String qaSystemItemName)
 {
  this.qaSystemItemName = qaSystemItemName;
 }
public BigDecimal getOnceDropScore()
 {
     return this.onceDropScore;
 }
public  void  setOnceDropScore(BigDecimal onceDropScore)
 {
  this.onceDropScore = onceDropScore;
 }
public String getSourceObjectName()
 {
     return this.sourceObjectName;
 }
public  void  setSourceObjectName(String sourceObjectName)
 {
  this.sourceObjectName = sourceObjectName;
 }

public String getQaPk() {
	return qaPk;
}

public void setQaPk(String qaPk) {
	this.qaPk = qaPk;
}

public String getMrName() {
	return mrName;
}

public void setMrName(String mrName) {
	this.mrName = mrName;
}

public BigDecimal getCanReform() {
	return canReform;
}

public void setCanReform(BigDecimal canReform) {
	this.canReform = canReform;
}

public String getFaultConfirmResult() {
	return faultConfirmResult;
}

public void setFaultConfirmResult(String faultConfirmResult) {
	this.faultConfirmResult = faultConfirmResult;
}

public String getFaultConfirmResultName() {
	return faultConfirmResultName;
}

public void setFaultConfirmResultName(String faultConfirmResultName) {
	this.faultConfirmResultName = faultConfirmResultName;
}

public Date getSubmittedTime() {
	return submittedTime;
}

public void setSubmittedTime(Date submittedTime) {
	this.submittedTime = submittedTime;
}

public Date getReformedTime() {
	return reformedTime;
}

public void setReformedTime(Date reformedTime) {
	this.reformedTime = reformedTime;
}

public Date getVerifiedTime() {
	return verifiedTime;
}

public void setVerifiedTime(Date verifiedTime) {
	this.verifiedTime = verifiedTime;
}

public Date getDeadline() {
	return deadline;
}

public void setDeadline(Date deadline) {
	this.deadline = deadline;
}

public String getEnPk() {
	return enPk;
}

public void setEnPk(String enPk) {
	this.enPk = enPk;
}

public String getQaTypeCode() {
	return qaTypeCode;
}

public void setQaTypeCode(String qaTypeCode) {
	this.qaTypeCode = qaTypeCode;
}

public String getReq() {
	return req;
}

public void setReq(String req) {
	this.req = req;
}

}