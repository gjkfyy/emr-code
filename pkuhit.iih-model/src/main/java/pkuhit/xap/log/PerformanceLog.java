package pkuhit.xap.log;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseBizModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class PerformanceLog extends BaseBizModel {
 public PerformanceLog(){
  super();
 }
 public PerformanceLog(String code){
  super(code);
 }

public static final String   OBJ_CD  = "XAPB06";

// 性能日志主键
public static final   String  PK = "XAPB06.AT01";
// 用户ID
public static final   String  USER_ID = "XAPB06.AT02";
// 服务编码
public static final   String  XAP_SERVICE_CODE = "XAPB06.AT03";
// 输入参数
public static final   String  INPUT_ = "XAPB06.AT04";
// 输出结果
public static final   String  OUTPUT = "XAPB06.AT05";
// 耗时(ms)
public static final   String  ELAPSED_TIME = "XAPB06.AT06";
// 开始时间
public static final   String  BEGIN_TIME = "XAPB06.AT07";
// 结束时间
public static final   String  END_TIME = "XAPB06.AT08";
// 执行部门编码
public static final   String  ACTIVE_DEPT_CODE = "XAPB06.AT09";


// 性能日志主键
@Column(name="PFMLOG_PK") 
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

// 输出结果
@Column(name="OUTPUT") 
private  String output;

// 耗时(ms)
@Column(name="ELAPSED_TIME") 
private  Integer elapsedTime;

// 开始时间
@Column(name="BEGIN_TIME") 
private  String beginTime;

// 结束时间
@Column(name="END_TIME") 
private  String endTime;

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

public String getOutput()
 {
     return this.output;
 }

public  void  setOutput(String output)
 {
  this.output = output;
 }

public Integer getElapsedTime()
 {
     return this.elapsedTime;
 }

public  void  setElapsedTime(Integer elapsedTime)
 {
  this.elapsedTime = elapsedTime;
 }

public String getBeginTime()
 {
     return this.beginTime;
 }

public  void  setBeginTime(String beginTime)
 {
  this.beginTime = beginTime;
 }

public String getEndTime()
 {
     return this.endTime;
 }

public  void  setEndTime(String endTime)
 {
  this.endTime = endTime;
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