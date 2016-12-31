package pkuhit.xap.ac;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class RoleAccessRule extends BaseRelationModel {
 public RoleAccessRule(){
  super();
 }
 public RoleAccessRule(String code){
  super(code);
 }
// 角色功能操作访问规则编码
public static final   String  CODE = "XAPM17.AT01";
// 角色功能操作编码
public static final   String  ROLE_ACTION_CODE = "XAPM17.AT02";
// 访问规则编码
public static final   String  DATA_ACCESS_RULE_CODE = "XAPM17.AT03";

// 角色功能操作访问规则编码
@Column(name="ROLE_ACRU_CD") 
private  String code;
// 角色功能操作编码
@Column(name="ROLE_ACT_CD") 
private  String roleActionCode;
// 访问规则编码
@Column(name="DATA_ACRU_CD") 
private  String dataAccessRuleCode;
// 角色功能操作名称
private  String roleActionName;
// 访问规则名称
private  String dataAccessRuleName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getRoleActionCode()
 {
     return this.roleActionCode;
 }
public  void  setRoleActionCode(String roleActionCode)
 {
  this.roleActionCode = roleActionCode;
 }
public String getDataAccessRuleCode()
 {
     return this.dataAccessRuleCode;
 }
public  void  setDataAccessRuleCode(String dataAccessRuleCode)
 {
  this.dataAccessRuleCode = dataAccessRuleCode;
 }
public String getRoleActionName()
 {
     return this.roleActionName;
 }
public  void  setRoleActionName(String roleActionName)
 {
  this.roleActionName = roleActionName;
 }
public String getDataAccessRuleName()
 {
     return this.dataAccessRuleName;
 }
public  void  setDataAccessRuleName(String dataAccessRuleName)
 {
  this.dataAccessRuleName = dataAccessRuleName;
 }

}