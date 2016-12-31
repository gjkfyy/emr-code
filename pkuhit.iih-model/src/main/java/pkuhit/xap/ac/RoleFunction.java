package pkuhit.xap.ac;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class RoleFunction extends BaseRelationModel {
 public RoleFunction(){
  super();
 }
 public RoleFunction(String code){
  super(code);
 }
// 角色功能编码
public static final   String  CODE = "XAPM15.AT01";
// 角色编码
public static final   String  ROLE_CODE = "XAPM15.AT02";
// 功能编码
public static final   String  FUNCTION_CODE = "XAPM15.AT03";

// 角色功能编码
@Column(name="ROLE_FU_CD") 
private  String code;
// 角色编码
@Column(name="ROLE_CD") 
private  String roleCode;
// 功能编码
@Column(name="FU_CD") 
private  String functionCode;
// 角色名称
private  String roleName;
// 功能名称
private  String functionName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getRoleCode()
 {
     return this.roleCode;
 }
public  void  setRoleCode(String roleCode)
 {
  this.roleCode = roleCode;
 }
public String getFunctionCode()
 {
     return this.functionCode;
 }
public  void  setFunctionCode(String functionCode)
 {
  this.functionCode = functionCode;
 }
public String getRoleName()
 {
     return this.roleName;
 }
public  void  setRoleName(String roleName)
 {
  this.roleName = roleName;
 }
public String getFunctionName()
 {
     return this.functionName;
 }
public  void  setFunctionName(String functionName)
 {
  this.functionName = functionName;
 }

}