package pkuhit.xap.task;

import java.util.Date;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class Task extends BaseBizModel {

	 public Task(){

	  super();

	 }

	 public Task(String code){

	  super(code);

	 }

	public static final String   OBJ_CD  = "XAPB03";

	// 任务主键
	public static final   String  PK = "XAPB03.AT01";
	// 子任务主键
	public static final   String  PARENT_PK = "XAPB03.AT02";
	// 前次任务主键
	public static final   String  PRE_PK = "XAPB03.AT03";
	// 任务类型编码
	public static final   String  TYPE_CODE = "XAPB03.AT04";
	// 任务来源对象编码
	public static final   String  SORCE_OBJECT_CODE = "XAPB03.AT05";
	// 任务来源数据主键
	public static final   String  SORCE_OBJECT_PK = "XAPB03.AT06";
	// 任务目标对象编码
	public static final   String  TARGET_OBJECT_CODE = "XAPB03.AT07";
	// 任务目标数据主键
	public static final   String  TARGET_OBJECT_PK = "XAPB03.AT08";
	// 名称
	public static final   String  NAME = "XAPB03.AT09";
	// 描述
	public static final   String  DESCRIPTION = "XAPB03.AT10";
	// 组标志
	public static final   String  GROUP_FLAG = "XAPB03.AT11";
	// 任务状态编码
	public static final   String  STATUS_CODE = "XAPB03.AT12";
	// 计划开始时间
	public static final   String  PLAN_BEGIN_TIME = "XAPB03.AT13";
	// 计划完成时间
	public static final   String  PLAN_END_TIME = "XAPB03.AT14";
	// 计划工期
	public static final   String  PLAN_DURATION = "XAPB03.AT15";
	// 计划执行者ID
	public static final   String  PLAN_EXEC_USER_ID = "XAPB03.AT16";
	// 计划执行科室编码
	public static final   String  PLAN_EXEC_DEPT_CODE = "XAPB03.AT17";
	// 发送时间
	public static final   String  SENT_TIME = "XAPB03.AT18";
	// 发送人ID
	public static final   String  SENT_USER_ID = "XAPB03.AT19";
	// 发送科室编码
	public static final   String  SENT_DEPT_CODE = "XAPB03.AT20";
	// 接收时间
	public static final   String  RECEVIED_TIME = "XAPB03.AT21";
	// 接收人ID
	public static final   String  RECEVIED__USER_ID = "XAPB03.AT22";
	// 接收科室编码
	public static final   String  RECEVIED__DEPT_CODE = "XAPB03.AT23";
	// 实际工期
	public static final   String  ACTUAL_DURATION = "XAPB03.AT24";
	// 实际开始时间
	public static final   String  ACTUAL_BEGIN_TIME = "XAPB03.AT25";
	// 实际完成时间
	public static final   String  ACTUAL_END_TIME = "XAPB03.AT26";
	// 实际执行者ID
	public static final   String  ACTUAL_USER_ID = "XAPB03.AT27";
	// 实际执行科室编码
	public static final   String  ACTUAL_DEPT_CODE = "XAPB03.AT28";
	// 完成说明
	public static final   String  COMPLETED_DESCRIPTION = "XAPB03.AT29";
	// 审核时间
	public static final   String  VERIFIED_TIME = "XAPB03.AT30";
	// 审核者ID
	public static final   String  VERIFIED_USER_ID = "XAPB03.AT31";
	// 审核科室编码
	public static final   String  VERIFIED_DEPT_CODE = "XAPB03.AT32";
	// 审核意见
	public static final   String  VERIFIED_DESCRIPTION = "XAPB03.AT33";


	// 任务主键
	@Column(name="TASK_PK") 
	private  String pk;

	// 父任务主键
	@Column(name="PAR_TASK_PK") 
	private  String parentPk;

	// 前次任务主键
	@Column(name="PRE_TASK_PK") 
	private  String prePk;

	// 任务类型编码
	@Column(name="TASK_TP_CD") 
	private  String typeCode;

	// 任务来源对象编码
	@Column(name="SRC_OB_CD") 
	private  String sorceObjectCode;

	// 任务来源数据主键
	@Column(name="SRC_OB_PK") 
	private  String sorceObjectPk;

	// 任务目标对象编码
	@Column(name="TGT_OB_CD") 
	private  String targetObjectCode;

	// 任务目标数据主键
	@Column(name="TGT_OB_PK") 
	private  String targetObjectPk;

	// 名称
	@Column(name="NM") 
	private  String name;

	// 描述
	@Column(name="DES") 
	private  String description;

	// 组标志
	@Column(name="GRP_F") 
	private  Integer groupFlag;

	// 任务状态编码
	@Column(name="TASK_STA_CD") 
	private  String statusCode;

	// 计划开始时间
	@Column(name="PLAN_BEGIN_TIME") 
	private  Date planBeginTime;

	// 计划完成时间
	@Column(name="PLAN_END_TIME") 
	private  String planEndTime;

	// 计划工期
	@Column(name="PLAN_DURA") 
	private  Integer planDuration;

	// 计划执行者ID
	@Column(name="PLAN_EXEC_BY_ID") 
	private  String planExecUserId;

	// 计划执行科室编码
	@Column(name="PLAN_EXEC_BY_DEPT_CD") 
	private  String planExecDeptCode;

	// 发送时间
	@Column(name="SEND_TIME") 
	private  Date sentTime;

	// 发送人ID
	@Column(name="SEND_USER_ID") 
	private  String sentUserId;

	// 发送科室编码
	@Column(name="SEND_DEPT_CD") 
	private  String sentDeptCode;

	// 接收时间
	@Column(name="RCV_TIME") 
	private  String receviedTime;

	// 接收人ID
	@Column(name="RCV_USER_ID") 
	private  String receviedUserId;

	// 接收科室编码
	@Column(name="RCV_DEPT_CD") 
	private  String receviedDeptCode;

	// 实际工期
	@Column(name="ACT_DURA") 
	private  Integer actualDuration;

	// 实际开始时间
	@Column(name="ACT_BEGIN_TIME") 
	private  String actualBeginTime;

	// 实际完成时间
	@Column(name="ACT_END_TIME") 
	private  String actualEndTime;

	// 实际执行者ID
	@Column(name="ACT_USER_ID") 
	private  String actualUserId;

	// 实际执行科室编码
	@Column(name="ACT_DEPT_CD") 
	private  String actualDeptCode;

	// 完成说明
	@Column(name="CMPL_DES") 
	private  String completedDescription;

	// 审核时间
	@Column(name="VRF_TIME") 
	private  String verifiedTime;

	// 审核者ID
	@Column(name="VRF_USER_ID") 
	private  String verifiedUserId;

	// 审核科室编码
	@Column(name="VRF_DEPT_CD") 
	private  String verifiedDeptCode;

	// 审核意见
	@Column(name="VRF_DES") 
	private  String verifiedDescription;
	// 任务类型名称
	@DictionaryTag(code = "typeCode",objCd ="XAPM04")
	private  String typeName;
	// 任务来源对象名称
	private  String sorceObjectName;
	// 任务目标对象名称
	private  String targetObjectName;
	// 任务状态名称
	@DictionaryTag(code = "statusCode",objCd ="XAPM05")
	private  String statusName;
	// 计划执行者名称
	//@DictionaryTag(code = "planExecUserId",objCd ="XAPM12")
	private  String planExecUserName;
	// 计划执行科室名称
	//@DictionaryTag(code = "planExecDeptCode",objCd ="ORGB01")
	private  String planExecDeptName;
	// 发送人名称
	//@DictionaryTag(code = "sentUserId",objCd ="XAPM12")
	private  String sentUserName;
	// 发送科室名称
	//@DictionaryTag(code = "sentDeptCode",objCd ="ORGB01")
	private  String sentDeptName;
	// 接收人名称
	//@DictionaryTag(code = "receviedUserId",objCd ="XAPM12")
	private  String receviedUserName;
	// 接收科室名称
	//@DictionaryTag(code = "receviedDeptCode",objCd ="ORGB01")
	private  String receviedDeptName;
	// 实际执行者名称
	//@DictionaryTag(code = "actualUserId",objCd ="XAPM12")
	private  String actualUserName;
	// 实际执行科室名称
	//@DictionaryTag(code = "actualDeptCode",objCd ="ORGB01")
	private  String actualDeptName;
	// 审核者名称
	//@DictionaryTag(code = "verifiedUserId",objCd ="XAPM12")
	private  String verifiedUserName;
	// 审核科室名称
	//@DictionaryTag(code = "verifiedDeptCode",objCd ="ORGB01")
	private  String verifiedDeptName;

	public String getPk()
	 {
	     return this.pk;
	 }

	public  void  setPk(String pk)
	 {
	  this.pk = pk;
	 }

	public String getParentPk()
	 {
	     return this.parentPk;
	 }
	public  void  setParentPk(String parentPk)
	 {
	  this.parentPk = parentPk;
	 }

	public String getPrePk()
	 {
	     return this.prePk;
	 }

	public  void  setPrePk(String prePk)
	 {
	  this.prePk = prePk;
	 }

	public String getTypeCode()
	 {
	     return this.typeCode;
	 }

	public  void  setTypeCode(String typeCode)
	 {
	  this.typeCode = typeCode;
	 }

	public String getSorceObjectCode()
	 {
	     return this.sorceObjectCode;
	 }

	public  void  setSorceObjectCode(String sorceObjectCode)
	 {
	  this.sorceObjectCode = sorceObjectCode;
	 }

	public String getSorceObjectPk()
	 {
	     return this.sorceObjectPk;
	 }

	public  void  setSorceObjectPk(String sorceObjectPk)
	 {
	  this.sorceObjectPk = sorceObjectPk;
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

	public String getName()
	 {
	     return this.name;
	 }

	public  void  setName(String name)
	 {
	  this.name = name;
	 }

	public String getDescription()
	 {
	     return this.description;
	 }

	public  void  setDescription(String description)
	 {
	  this.description = description;
	 }

	public Integer getGroupFlag()
	 {
	     return this.groupFlag;
	 }

	public  void  setGroupFlag(Integer groupFlag)
	 {
	  this.groupFlag = groupFlag;
	 }

	public String getStatusCode()
	 {
	     return this.statusCode;
	 }

	public  void  setStatusCode(String statusCode)
	 {
	  this.statusCode = statusCode;
	 }

	public Date getPlanBeginTime()
	 {
	     return this.planBeginTime;
	 }

	public  void  setPlanBeginTime(Date planBeginTime)
	 {
	  this.planBeginTime = planBeginTime;
	 }

	public String getPlanEndTime()
	 {
	     return this.planEndTime;
	 }

	public  void  setPlanEndTime(String planEndTime)
	 {
	  this.planEndTime = planEndTime;
	 }

	public Integer getPlanDuration()
	 {
	     return this.planDuration;
	 }

	public  void  setPlanDuration(Integer planDuration)
	 {
	  this.planDuration = planDuration;
	 }

	public String getPlanExecUserId()
	 {
	     return this.planExecUserId;
	 }

	public  void  setPlanExecUserId(String planExecUserId)
	 {
	  this.planExecUserId = planExecUserId;
	 }

	public String getPlanExecDeptCode()
	 {
	     return this.planExecDeptCode;
	 }

	public  void  setPlanExecDeptCode(String planExecDeptCode)
	 {
	  this.planExecDeptCode = planExecDeptCode;
	 }

	public Date getSentTime()
	 {
	     return this.sentTime;
	 }

	public  void  setSentTime(Date sentTime)
	 {
	  this.sentTime = sentTime;
	 }

	public String getSentUserId()
	 {
	     return this.sentUserId;
	 }

	public  void  setSentUserId(String sentUserId)
	 {
	  this.sentUserId = sentUserId;
	 }

	public String getSentDeptCode()
	 {
	     return this.sentDeptCode;
	 }

	public  void  setSentDeptCode(String sentDeptCode)
	 {
	  this.sentDeptCode = sentDeptCode;
	 }

	public String getReceviedTime()
	 {
	     return this.receviedTime;
	 }

	public  void  setReceviedTime(String receviedTime)
	 {
	  this.receviedTime = receviedTime;
	 }

	public String getReceviedUserId()
	 {
	     return this.receviedUserId;
	 }

	public  void  setReceviedUserId(String receviedUserId)
	 {
	  this.receviedUserId = receviedUserId;
	 }

	public String getReceviedDeptCode()
	 {
	     return this.receviedDeptCode;
	 }

	public  void  setReceviedDeptCode(String receviedDeptCode)
	 {
	  this.receviedDeptCode = receviedDeptCode;
	 }

	public Integer getActualDuration()
	 {
	     return this.actualDuration;
	 }

	public  void  setActualDuration(Integer actualDuration)
	 {
	  this.actualDuration = actualDuration;
	 }

	public String getActualBeginTime()
	 {
	     return this.actualBeginTime;
	 }

	public  void  setActualBeginTime(String actualBeginTime)
	 {
	  this.actualBeginTime = actualBeginTime;
	 }

	public String getActualEndTime()
	 {
	     return this.actualEndTime;
	 }

	public  void  setActualEndTime(String actualEndTime)
	 {
	  this.actualEndTime = actualEndTime;
	 }

	public String getActualUserId()
	 {
	     return this.actualUserId;
	 }

	public  void  setActualUserId(String actualUserId)
	 {
	  this.actualUserId = actualUserId;
	 }

	public String getActualDeptCode()
	 {
	     return this.actualDeptCode;
	 }

	public  void  setActualDeptCode(String actualDeptCode)
	 {
	  this.actualDeptCode = actualDeptCode;
	 }

	public String getCompletedDescription()
	 {
	     return this.completedDescription;
	 }

	public  void  setCompletedDescription(String completedDescription)
	 {
	  this.completedDescription = completedDescription;
	 }

	public String getVerifiedTime()
	 {
	     return this.verifiedTime;
	 }

	public  void  setVerifiedTime(String verifiedTime)
	 {
	  this.verifiedTime = verifiedTime;
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

	public String getVerifiedDescription()
	 {
	     return this.verifiedDescription;
	 }

	public  void  setVerifiedDescription(String verifiedDescription)
	 {
	  this.verifiedDescription = verifiedDescription;
	 }

	public String getTypeName()
	 {
	     return this.typeName;
	 }

	public  void  setTypeName(String typeName)
	 {
	  this.typeName = typeName;
	 }

	public String getSorceObjectName()
	 {
	     return this.sorceObjectName;
	 }

	public  void  setSorceObjectName(String sorceObjectName)
	 {
	  this.sorceObjectName = sorceObjectName;
	 }

	public String getTargetObjectName()
	 {
	     return this.targetObjectName;
	 }

	public  void  setTargetObjectName(String targetObjectName)
	 {
	  this.targetObjectName = targetObjectName;
	 }

	public String getStatusName()
	 {
	     return this.statusName;
	 }

	public  void  setStatusName(String statusName)
	 {
	  this.statusName = statusName;
	 }

	public String getPlanExecUserName()
	 {
	     return this.planExecUserName;
	 }

	public  void  setPlanExecUserName(String planExecUserName)
	 {
	  this.planExecUserName = planExecUserName;
	 }

	public String getPlanExecDeptName()
	 {
	     return this.planExecDeptName;
	 }

	public  void  setPlanExecDeptName(String planExecDeptName)
	 {
	  this.planExecDeptName = planExecDeptName;
	 }

	public String getSentUserName()
	 {
	     return this.sentUserName;
	 }

	public  void  setSentUserName(String sentUserName)
	 {
	  this.sentUserName = sentUserName;
	 }

	public String getSentDeptName()
	 {
	     return this.sentDeptName;
	 }

	public  void  setSentDeptName(String sentDeptName)
	 {
	  this.sentDeptName = sentDeptName;
	 }

	public String getReceviedUserName()
	 {
	     return this.receviedUserName;
	 }

	public  void  setReceviedUserName(String receviedUserName)
	 {
	  this.receviedUserName = receviedUserName;
	 }

	public String getReceviedDeptName()
	 {
	     return this.receviedDeptName;
	 }

	public  void  setReceviedDeptName(String receviedDeptName)
	 {
	  this.receviedDeptName = receviedDeptName;
	 }

	public String getActualUserName()
	 {
	     return this.actualUserName;
	 }

	public  void  setActualUserName(String actualUserName)
	 {
	  this.actualUserName = actualUserName;
	 }

	public String getActualDeptName()
	 {
	     return this.actualDeptName;
	 }

	public  void  setActualDeptName(String actualDeptName)
	 {
	  this.actualDeptName = actualDeptName;
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

}