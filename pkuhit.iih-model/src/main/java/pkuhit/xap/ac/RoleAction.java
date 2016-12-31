package pkuhit.xap.ac;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class RoleAction extends BaseRelationModel {
 public RoleAction(){
  super();
 }
 public RoleAction(String code){
  super(code);
 }
// 角色功能操作编码
public static final   String  CODE = "XAPM16.AT01";
// 角色功能编码
public static final   String  ROLE_FUNCTION_CODE = "XAPM16.AT02";
// 功能操作编码
public static final   String  FUNCTION_ACTION_CODE = "XAPM16.AT03";

// 角色功能操作编码
@Column(name="ROLE_ACT_CD") 
private  String code;
// 角色功能编码
@Column(name="ROLE_FU_CD") 
private  String roleFunctionCode;
// 功能操作编码
@Column(name="FU_ACT_CD") 
private  String functionActionCode;
// 角色功能名称
private  String roleFunctionName;
// 功能操作名称
private  String functionActionName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getRoleFunctionCode()
 {
     return this.roleFunctionCode;
 }
public  void  setRoleFunctionCode(String roleFunctionCode)
 {
  this.roleFunctionCode = roleFunctionCode;
 }
public String getFunctionActionCode()
 {
     return this.functionActionCode;
 }
public  void  setFunctionActionCode(String functionActionCode)
 {
  this.functionActionCode = functionActionCode;
 }
public String getRoleFunctionName()
 {
     return this.roleFunctionName;
 }
public  void  setRoleFunctionName(String roleFunctionName)
 {
  this.roleFunctionName = roleFunctionName;
 }
public String getFunctionActionName()
 {
     return this.functionActionName;
 }
public  void  setFunctionActionName(String functionActionName)
 {
  this.functionActionName = functionActionName;
 }

}