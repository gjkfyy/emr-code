package pkuhit.xap.po;

import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;









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


@Column(name="MENU_CD") 
private  String code;

@Column(name="PAR_MENU_CD") 
private  String parentCode;

@Column(name="PORTAL_CD") 
private  String portalCode;

@Column(name="FU_CD") 
private  String functionCode;

@Column(name="NM") 
private  String name;

@Column(name="DES") 
private  String description;

@Column(name="SHT_NM_EN") 
private  String shortEnglishName;

@Column(name="NM_EN") 
private  String englishName;
// 门户名称
private  String portalName;
// 功能名称
private  String functionName;

 {
     return this.code;
 }

 {
  this.code = code;
 }

 {
     return this.parentCode;
 }

 {
  this.parentCode = parentCode;
 }

 {
     return this.portalCode;
 }

 {
  this.portalCode = portalCode;
 }

 {
     return this.functionCode;
 }

 {
  this.functionCode = functionCode;
 }

 {
     return this.name;
 }

 {
  this.name = name;
 }

 {
     return this.description;
 }

 {
  this.description = description;
 }

 {
     return this.shortEnglishName;
 }

 {
  this.shortEnglishName = shortEnglishName;
 }

 {
     return this.englishName;
 }

 {
  this.englishName = englishName;
 }

 {
     return this.portalName;
 }

 {
  this.portalName = portalName;
 }

 {
     return this.functionName;
 }

 {
  this.functionName = functionName;
 }

