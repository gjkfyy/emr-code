package pkuhit.xap.me;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class FunctionAction extends BaseRelationModel {
 public FunctionAction(){
  super();
 }
 public FunctionAction(String code){
  super(code);
 }
// 功能操作编码
public static final   String  CODE = "MEB07.AT01";
// 功能编码
public static final   String  FUNCTION_CODE = "MEB07.AT02";
// 服务编码
public static final   String  XAP_SERVICE_CODE = "MEB07.AT03";
// 操作类型编码
public static final   String  ACTION_TYPE_CODE = "MEB07.AT04";
// 名称
public static final   String  NAME = "MEB07.AT05";
// 描述
public static final   String  DESCRIPTION = "MEB07.AT06";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "MEB07.AT07";
// 英文名称
public static final   String  ENGLISH_NAME = "MEB07.AT08";

// 功能操作编码
@Column(name="FU_ACT_CD") 
private  String code;
// 功能编码
@Column(name="FU_CD") 
private  String functionCode;
// 服务编码
@Column(name="XSV_CD") 
private  String xapServiceCode;
// 操作类型编码
@Column(name="ACT_TP_CD") 
private  String actionTypeCode;
// 名称
@Column(name="NM") 
private  String name;
// 描述
@Column(name="DES") 
private  String description;
// 英文简称
@Column(name="SHT_NM_EN") 
private  String shortEnglishName;
// 英文名称
@Column(name="NM_EN") 
private  String englishName;
// 功能名称
private  String functionName;
// 服务名称
private  String xapServiceName;
// 操作类型名称
@DictionaryTag(code = "actionTypeCode")
private  String actionTypeName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getFunctionCode()
 {
     return this.functionCode;
 }
public  void  setFunctionCode(String functionCode)
 {
  this.functionCode = functionCode;
 }
public String getXapServiceCode()
 {
     return this.xapServiceCode;
 }
public  void  setXapServiceCode(String xapServiceCode)
 {
  this.xapServiceCode = xapServiceCode;
 }
public String getActionTypeCode()
 {
     return this.actionTypeCode;
 }
public  void  setActionTypeCode(String actionTypeCode)
 {
  this.actionTypeCode = actionTypeCode;
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
public String getShortEnglishName()
 {
     return this.shortEnglishName;
 }
public  void  setShortEnglishName(String shortEnglishName)
 {
  this.shortEnglishName = shortEnglishName;
 }
public String getEnglishName()
 {
     return this.englishName;
 }
public  void  setEnglishName(String englishName)
 {
  this.englishName = englishName;
 }
public String getFunctionName()
 {
     return this.functionName;
 }
public  void  setFunctionName(String functionName)
 {
  this.functionName = functionName;
 }
public String getXapServiceName()
 {
     return this.xapServiceName;
 }
public  void  setXapServiceName(String xapServiceName)
 {
  this.xapServiceName = xapServiceName;
 }
public String getActionTypeName()
 {
     return this.actionTypeName;
 }
public  void  setActionTypeName(String actionTypeName)
 {
  this.actionTypeName = actionTypeName;
 }

}