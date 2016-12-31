package pkuhit.iih.qa.old;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseBizModel;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaNItem extends BaseBizModel {
 public QaNItem(){
  super();
 }
 public QaNItem(String code){
  super(code);
 }
// 质控项目主键
public static final   String  PK = "QAB02.AT01";
// 质控主键
public static final   String  QA_PK = "QAB02.AT02";
// 质控体系质控项目编码
public static final   String  QA_SYSTEM_ITEM_CODE = "QAB02.AT03";
// 质控目标对象编码
public static final   String  TARGET_OBJECT_CODE = "QAB02.AT04";
// 质控目标对象主键
public static final   String  TARGET_OBJECT_PK = "QAB02.AT05";
// 质控来源对象编码
public static final   String  SOURCE_OBJECT_CODE = "QAB02.AT06";
// 质控来源对象主键
public static final   String  SOURCE_OBJECT_PK = "QAB02.AT07";
// 完成标志
public static final   String  COMPLETED_FLAG = "QAB02.AT08";
// 质控截止时间
public static final   String  DEADLINE_TIME = "QAB02.AT09";
// 质控执行时间
public static final   String  EXECUTE_TIME = "QAB02.AT10";
// 质控执行人ID
public static final   String  EXECUTE_USER_ID = "QAB02.AT11";
// 质控执行科室编码
public static final   String  EXECUTE_DEPT_CODE = "QAB02.AT12";
// 缺陷标志
public static final   String  FAULT_FLAG = "QAB02.AT13";
// 缺陷数
public static final   String  FAULT_COUNT = "QAB02.AT14";

@Column(name = "QA_ITM_CD")
private String qaItmCd;

@Column(name = "REQ")
private String req;// 质控项目主键
@Column(name="QA_ITM_PK") 
private  String pk;
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

// 质控主键
@Column(name="QA_PK") 
private  String qaPk;
// 质控体系质控项目编码
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
// 完成标志
@Column(name="CMPL_F") 
private  Integer completedFlag;
// 质控截止时间
@Column(name="DL_TIME") 
private  Date deadlineTime;
// 质控执行时间
@Column(name="EXEC_TIME") 
private  Date executeTime;
// 质控执行人ID
@Column(name="EXEC_USER_ID") 
private  String executeUserId;
// 质控执行科室编码
@Column(name="EXEC_DEPT_CD") 
private  String executeDeptCode;
// 缺陷标志
@Column(name="FLT_F") 
private  Integer faultFlag;
// 缺陷数
@Column(name="FLT_CNT") 
private  Integer faultCount;

//扣分标准
@Column(name="ONCE_DRP_SCR") 
private  Integer onceDropScore;
// 质控执行人名称
//@DictionaryTag(code = "executeUserId")
private  String executeUserName;
// 质控执行科室名称
//@DictionaryTag(code = "executeDeptCode")
private  String executeDeptName; 
public String getPk()
 {
     return this.pk;
 }
public  void  setPk(String pk)
 {
  this.pk = pk;
 }
public String getQaPk()
 {
     return this.qaPk;
 }
public  void  setQaPk(String qaPk)
 {
  this.qaPk = qaPk;
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
public Integer getCompletedFlag()
 {
     return this.completedFlag;
 }
public  void  setCompletedFlag(Integer completedFlag)
 {
  this.completedFlag = completedFlag;
 }
public Date getDeadlineTime()
 {
     return this.deadlineTime;
 }
public  void  setDeadlineTime(Date deadlineTime)
 {
  this.deadlineTime = deadlineTime;
 }
public Date getExecuteTime()
 {
     return this.executeTime;
 }
public  void  setExecuteTime(Date executeTime)
 {
  this.executeTime = executeTime;
 }
public String getExecuteUserId()
 {
     return this.executeUserId;
 }
public  void  setExecuteUserId(String executeUserId)
 {
  this.executeUserId = executeUserId;
 }
public String getExecuteDeptCode()
 {
     return this.executeDeptCode;
 }
public  void  setExecuteDeptCode(String executeDeptCode)
 {
  this.executeDeptCode = executeDeptCode;
 }
public Integer getFaultFlag()
 {
     return this.faultFlag;
 }
public  void  setFaultFlag(Integer faultFlag)
 {
  this.faultFlag = faultFlag;
 }
public Integer getFaultCount()
 {
     return this.faultCount;
 }
public  void  setFaultCount(Integer faultCount)
 {
  this.faultCount = faultCount;
 }
public String getExecuteUserName()
 {
     return this.executeUserName;
 }
public  void  setExecuteUserName(String executeUserName)
 {
  this.executeUserName = executeUserName;
 }
public String getExecuteDeptName()
 {
     return this.executeDeptName;
 }
public  void  setExecuteDeptName(String executeDeptName)
 {
  this.executeDeptName = executeDeptName;
 }

public Integer getOnceDropScore() {
	return onceDropScore;
}

public void setOnceDropScore(Integer onceDropScore) {
	this.onceDropScore = onceDropScore;
}

}