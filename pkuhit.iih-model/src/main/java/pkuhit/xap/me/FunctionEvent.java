package pkuhit.xap.me;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class FunctionEvent extends BaseRelationModel {
 public FunctionEvent(){
  super();
 }
 public FunctionEvent(String code){
  super(code);
 }
// 功能元素事件编码
public static final   String  CODE = "MEB08.AT01";
// 功能元素编码
public static final   String  FUNCTION_ELEMENT_CODE = "MEB08.AT02";
// 功能操作编码
public static final   String  FUNCTION_ACTION_CODE = "MEB08.AT03";
// 事件类型编码
public static final   String  EVENT_TYPE_CODE = "MEB08.AT04";

// 功能元素事件编码
@Column(name="FU_EV_CD") 
private  String code;
// 功能元素编码
@Column(name="FU_EL_CD") 
private  String functionElementCode;
// 功能操作编码
@Column(name="FU_ACT_CD") 
private  String functionActionCode;
// 事件类型编码
@Column(name="EV_TP_CD") 
private  String eventTypeCode;
// 功能元素名称
private  String functionElementName;
// 功能操作名称
private  String functionActionName;
// 事件类型名称
@DictionaryTag(code = "eventTypeCode")
private  String eventTypeName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getFunctionElementCode()
 {
     return this.functionElementCode;
 }
public  void  setFunctionElementCode(String functionElementCode)
 {
  this.functionElementCode = functionElementCode;
 }
public String getFunctionActionCode()
 {
     return this.functionActionCode;
 }
public  void  setFunctionActionCode(String functionActionCode)
 {
  this.functionActionCode = functionActionCode;
 }
public String getEventTypeCode()
 {
     return this.eventTypeCode;
 }
public  void  setEventTypeCode(String eventTypeCode)
 {
  this.eventTypeCode = eventTypeCode;
 }
public String getFunctionElementName()
 {
     return this.functionElementName;
 }
public  void  setFunctionElementName(String functionElementName)
 {
  this.functionElementName = functionElementName;
 }
public String getFunctionActionName()
 {
     return this.functionActionName;
 }
public  void  setFunctionActionName(String functionActionName)
 {
  this.functionActionName = functionActionName;
 }
public String getEventTypeName()
 {
     return this.eventTypeName;
 }
public  void  setEventTypeName(String eventTypeName)
 {
  this.eventTypeName = eventTypeName;
 }

}