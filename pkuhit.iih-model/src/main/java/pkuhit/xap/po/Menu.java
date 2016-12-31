package pkuhit.xap.po;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Menu extends BaseMasterModel {
 public Menu(){
  super();
 }
 public Menu(String code){
  super(code);
 }
// 菜单编码
public static final   String  CODE = "XAPM07.AT01";
// 父菜单编码
public static final   String  PARENT_CODE = "XAPM07.AT02";
// 门户编码
public static final   String  PORTAL_CODE = "XAPM07.AT03";
// 功能编码
public static final   String  FUNCTION_CODE = "XAPM07.AT04";
// 名称
public static final   String  NAME = "XAPM07.AT05";
// 描述
public static final   String  DESCRIPTION = "XAPM07.AT06";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "XAPM07.AT07";
// 英文名称
public static final   String  ENGLISH_NAME = "XAPM07.AT08";

// 菜单编码
@Column(name="MENU_CD") 
private  String code;
// 父菜单编码
@Column(name="PAR_MENU_CD") 
private  String parentCode;
// 门户编码
@Column(name="PORTAL_CD") 
private  String portalCode;
// 功能编码
@Column(name="FU_CD") 
private  String functionCode;
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
// 门户名称
private  String portalName;
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
public String getParentCode()
 {
     return this.parentCode;
 }
public  void  setParentCode(String parentCode)
 {
  this.parentCode = parentCode;
 }
public String getPortalCode()
 {
     return this.portalCode;
 }
public  void  setPortalCode(String portalCode)
 {
  this.portalCode = portalCode;
 }
public String getFunctionCode()
 {
     return this.functionCode;
 }
public  void  setFunctionCode(String functionCode)
 {
  this.functionCode = functionCode;
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
public String getPortalName()
 {
     return this.portalName;
 }
public  void  setPortalName(String portalName)
 {
  this.portalName = portalName;
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