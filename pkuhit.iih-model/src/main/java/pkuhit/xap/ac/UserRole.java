package pkuhit.xap.ac;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
public class UserRole extends BaseRelationModel {
 public UserRole(){
  super();
 }
 public UserRole(String code){
  super(code);
 }
// 用户业务组角色编码
public static final   String  CODE = "XAPM13.AT01";
// 用户ID
public static final   String  USER_ID = "XAPM13.AT02";
// 角色编码
public static final   String  ROLE_CODE = "XAPM13.AT03";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "XAPM13.AT04";
// 启用时间
public static final   String  START_TIME = "XAPM13.AT05";
// 停用时间
public static final   String  STOP_TIME = "XAPM13.AT06";

// 用户业务组角色编码
@Column(name="USER_ROLE_CD") 
private  String code;
// 用户ID
@Column(name="USER_ID") 
private  String userId;
// 角色编码
@Column(name="ROLE_CD") 
private  String roleCode;
// 组织机构编码
@Column(name="ORG_CD") 
private  String organizationCode;
// 启用时间
@Column(name="START_TIME") 
private  String startTime;
// 停用时间
@Column(name="STOP_TIME") 
private  String stopTime;
// 用户名称
//@DictionaryTag(code = "userId")
private  String userName;
// 角色名称
//@DictionaryTag(code = "roleCode")
private  String roleName;
// 组织机构名称
@DictionaryTag(code = "organizationCode" ,objCd="ORGB01")
private  String organizationName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getUserId()
 {
     return this.userId;
 }
public  void  setUserId(String userId)
 {
  this.userId = userId;
 }
public String getRoleCode()
 {
     return this.roleCode;
 }
public  void  setRoleCode(String roleCode)
 {
  this.roleCode = roleCode;
 }
public String getOrganizationCode()
 {
     return this.organizationCode;
 }
public  void  setOrganizationCode(String organizationCode)
 {
  this.organizationCode = organizationCode;
 }
public String getStartTime()
 {
     return this.startTime;
 }
public  void  setStartTime(String startTime)
 {
  this.startTime = startTime;
 }
public String getStopTime()
 {
     return this.stopTime;
 }
public  void  setStopTime(String stopTime)
 {
  this.stopTime = stopTime;
 }
public String getUserName()
 {
     return this.userName;
 }
public  void  setUserName(String userName)
 {
  this.userName = userName;
 }
public String getRoleName()
 {
     return this.roleName;
 }
public  void  setRoleName(String roleName)
 {
  this.roleName = roleName;
 }
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }

}