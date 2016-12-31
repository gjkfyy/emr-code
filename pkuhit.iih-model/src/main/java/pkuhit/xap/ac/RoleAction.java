package pkuhit.xap.ac;

import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;









public static final   String  CODE = "XAPM16.AT01";
// 角色功能编码
public static final   String  ROLE_FUNCTION_CODE = "XAPM16.AT02";
// 功能操作编码
public static final   String  FUNCTION_ACTION_CODE = "XAPM16.AT03";


@Column(name="ROLE_ACT_CD") 
private  String code;

@Column(name="ROLE_FU_CD") 
private  String roleFunctionCode;

@Column(name="FU_ACT_CD") 
private  String functionActionCode;
// 角色功能名称
private  String roleFunctionName;
// 功能操作名称
private  String functionActionName;

 {
     return this.code;
 }

 {
  this.code = code;
 }

 {
     return this.roleFunctionCode;
 }

 {
  this.roleFunctionCode = roleFunctionCode;
 }

 {
     return this.functionActionCode;
 }

 {
  this.functionActionCode = functionActionCode;
 }

 {
     return this.roleFunctionName;
 }

 {
  this.roleFunctionName = roleFunctionName;
 }

 {
     return this.functionActionName;
 }

 {
  this.functionActionName = functionActionName;
 }

