package pkuhit.xap.log;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseBizModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ErrorLog extends BaseBizModel {
 public ErrorLog(){
  super();
 }
 public ErrorLog(String code){
  super(code);
 }

public static final String   OBJ_CD  = "XAPB04";

// 错误日志主键
public static final   String  PK = "XAPB04.AT01";
// 用户ID
public static final   String  USER_ID = "XAPB04.AT02";
// 服务编码
public static final   String  XAP_SERVICE_CODE = "XAPB04.AT03";
// 输入参数
public static final   String  INPUT = "XAPB04.AT04";
// 错误信息
public static final   String  ERROR_INFORMATION = "XAPB04.AT05";
// 执行时间
public static final   String  ACTIVE_TIME = "XAPB04.AT06";
// 执行部门编码
public static final   String  ACTIVE_DEPT_CODE = "XAPB04.AT07";


// 错误日志主键
@Column(name="ERRLOG_PK") 
private  String pk;

// 用户ID
@Column(name="USER_ID") 
private  String userId;

// 服务编码
@Column(name="XSV_CD") 
private  String xapServiceCode;

// 输入参数
@Column(name="INPUT") 
private  String input;

// 错误信息
@Column(name="ERR_INFO") 
private  String errorInformation;

// 执行时间
@Column(name="ACT_TIME") 
private  String activeTime;

// 执行部门编码
@Column(name="ACT_DEPT_CD") 
private  String activeDeptCode;
// 服务名称
@DictionaryTag(code = "xapServiceCode",objCd ="MEB05")
private  String xapServiceName;
// 执行部门名称
//@DictionaryTag(code = "activeDeptCode",objCd ="ORGB01")
private  String activeDeptName;
// 用户名称
//@DictionaryTag(code = "userId",objCd ="XAPM12")
private  String userName;

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

public String getXapServiceCode()
 {
     return this.xapServiceCode;
 }

public  void  setXapServiceCode(String xapServiceCode)
 {
  this.xapServiceCode = xapServiceCode;
 }

public String getInput()
 {
     return this.input;
 }

public  void  setInput(String input)
 {
  this.input = input;
 }

public String getErrorInformation()
 {
     return this.errorInformation;
 }

public  void  setErrorInformation(String errorInformation)
 {
  this.errorInformation = errorInformation;
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

public String getXapServiceName()
 {
     return this.xapServiceName;
 }

public  void  setXapServiceName(String xapServiceName)
 {
  this.xapServiceName = xapServiceName;
 }

public String getActiveDeptName()
 {
     return this.activeDeptName;
 }

public  void  setActiveDeptName(String activeDeptName)
 {
  this.activeDeptName = activeDeptName;
 }

public String getUserName()
 {
     return this.userName;
 }

public  void  setUserName(String userName)
 {
  this.userName = userName;
 }

}