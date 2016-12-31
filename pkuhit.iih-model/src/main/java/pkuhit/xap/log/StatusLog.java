package pkuhit.xap.log;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseBizModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class StatusLog extends BaseBizModel {
 public StatusLog(){
  super();
 }
 public StatusLog(String code){
  super(code);
 }

public static final String   OBJ_CD  = "XAPB07";

// 状态日志主键
public static final   String  PK = "XAPB07.AT01";
// 用户ID
public static final   String  USER_ID = "XAPB07.AT02";
// 数据元素编码
public static final   String  OBJECT_ATTRIBUTE_CODE = "XAPB07.AT03";
// 数据对象主键
public static final   String  OBJECT_CODE = "XAPB07.AT04";
// 变更前状态编码
public static final   String  PRE_STATUS_CD = "XAPB07.AT05";
// 变更后状态编码
public static final   String  NEXT_STATUS_CD = "XAPB07.AT06";
// 执行时间
public static final   String  ACTIVE_TIME = "XAPB07.AT07";
// 执行部门编码
public static final   String  ACTIVE_DEPT_CODE = "XAPB07.AT08";


// 状态日志主键
@Column(name="STALOG_PK") 
private  String pk;

// 用户ID
@Column(name="USER_ID") 
private  String userId;

// 数据元素编码
@Column(name="OBJ_ATTR_CD") 
private  String objectAttributeCode;

// 数据对象主键
@Column(name="OB_PK") 
private  String objectCode;

// 变更前状态编码
@Column(name="PRE_STA_CD") 
private  String preStatusCd;

// 变更后状态编码
@Column(name="NEXT_STA_CD") 
private  String nextStatusCd;

// 执行时间
@Column(name="ACT_TIME") 
private  String activeTime;

// 执行部门编码
@Column(name="ACT_DEPT_CD") 
private  String activeDeptCode;
// 用户名称
//@DictionaryTag(code = "userId",objCd ="XAPM12")
private  String userName;
// 数据元素名称
@DictionaryTag(code = "objectAttributeCode",objCd ="MEB03")
private  String objectAttributeName;
// 数据对象名称
@DictionaryTag(code = "objectCode",objCd ="MEB02")
private  String objectName;
// 执行部门名称
//@DictionaryTag(code = "activeDeptCode",objCd ="ORGB01")
private  String activeDeptName;

public String getPk()
 {
     return this.pk;
 }

public  void  setPk(String pk)
 {
  this.pk = pk;
 }

public String getUserId()
 {
     return this.userId;
 }

public  void  setUserId(String userId)
 {
  this.userId = userId;
 }

public String getObjectAttributeCode()
 {
     return this.objectAttributeCode;
 }

public  void  setObjectAttributeCode(String objectAttributeCode)
 {
  this.objectAttributeCode = objectAttributeCode;
 }

public String getObjectCode()
 {
     return this.objectCode;
 }

public  void  setObjectCode(String objectCode)
 {
  this.objectCode = objectCode;
 }

public String getPreStatusCd()
 {
     return this.preStatusCd;
 }

public  void  setPreStatusCd(String preStatusCd)
 {
  this.preStatusCd = preStatusCd;
 }

public String getNextStatusCd()
 {
     return this.nextStatusCd;
 }

public  void  setNextStatusCd(String nextStatusCd)
 {
  this.nextStatusCd = nextStatusCd;
 }

public String getActiveTime()
 {
     return this.activeTime;
 }

public  void  setActiveTime(String activeTime)
 {
  this.activeTime = activeTime;
 }

public String getActiveDeptCode()
 {
     return this.activeDeptCode;
 }

public  void  setActiveDeptCode(String activeDeptCode)
 {
  this.activeDeptCode = activeDeptCode;
 }

public String getUserName()
 {
     return this.userName;
 }

public  void  setUserName(String userName)
 {
  this.userName = userName;
 }

public String getObjectAttributeName()
 {
     return this.objectAttributeName;
 }

public  void  setObjectAttributeName(String objectAttributeName)
 {
  this.objectAttributeName = objectAttributeName;
 }

public String getObjectName()
 {
     return this.objectName;
 }

public  void  setObjectName(String objectName)
 {
  this.objectName = objectName;
 }

public String getActiveDeptName()
 {
     return this.activeDeptName;
 }

public  void  setActiveDeptName(String activeDeptName)
 {
  this.activeDeptName = activeDeptName;
 }
}