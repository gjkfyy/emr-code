package pkuhit.org;

import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import pkuhit.xap.ac.Role;








 public static final String   OBJ_CD  = "ORGB01";
public static final   String  CODE = "ORGB01.AT01";
// 父组织机构编码
public static final   String  PARENT_CODE = "ORGB01.AT02";
// 地点编码
public static final   String  PLACE_CODE = "ORGB01.AT03";
// 组织机构类型编码
public static final   String  TYPE_CODE = "ORGB01.AT04";
// 名称
public static final   String  NAME = "ORGB01.AT05";
// 描述
public static final   String  DESCRIPTION = "ORGB01.AT06";
// 简称
public static final   String  SHORT_NAME = "ORGB01.AT07";
// 别名
public static final   String  ALIAS_NAME = "ORGB01.AT08";
// 区县编码
public static final   String  DISTRICT_CODE = "ORGB01.AT09";
// 乡镇街道名称
public static final   String  SUBDISTRICT_NAME = "ORGB01.AT10";
// 邮政编码
public static final   String  ZIP_NO = "ORGB01.AT11";
// 固定电话
public static final   String  TEL_NO = "ORGB01.AT12";


@Column(name="ORG_CD") 
private  String code;

@Column(name="PAR_ORG_CD") 
private  String parentCode;

@Column(name="PLC_CD") 
private  String placeCode;

@Column(name="ORG_TP_CD") 
private  String typeCode;

@Column(name="NM") 
private  String name;

@Column(name="DES") 
private  String description;

@Column(name="SHT_NM") 
private  String shortName;

@Column(name="ALIAS_NM") 
private  String aliasName;

@Column(name="DIST_CD") 
private  String districtCode;

@Column(name="SUBDIST_NM") 
private  String subdistrictName;

@Column(name="ZIP_NO") 
private  String zipNo;

@Column(name="TEL_NO") 
private  String telNo;
// 地点名称
private  String placeName;
// 组织机构类型名称
@DictionaryTag(code = "typeCode")
private  String typeName;
// 区县名称
@DictionaryTag(code = "districtCode")
private  String districtName;

public List<Role> roleList;

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
     return this.placeCode;
 }

 {
  this.placeCode = placeCode;
 }

 {
     return this.typeCode;
 }

 {
  this.typeCode = typeCode;
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
     return this.shortName;
 }

 {
  this.shortName = shortName;
 }

 {
     return this.aliasName;
 }

 {
  this.aliasName = aliasName;
 }

 {
     return this.districtCode;
 }

 {
  this.districtCode = districtCode;
 }

 {
     return this.subdistrictName;
 }

 {
  this.subdistrictName = subdistrictName;
 }

 {
     return this.zipNo;
 }

 {
  this.zipNo = zipNo;
 }

 {
     return this.telNo;
 }

 {
  this.telNo = telNo;
 }

 {
     return this.placeName;
 }

 {
  this.placeName = placeName;
 }

 {
     return this.typeName;
 }

 {
  this.typeName = typeName;
 }

 {
     return this.districtName;
 }

 {
  this.districtName = districtName;
 }

public List<Role> getRoleList()
{
    return roleList;
}

public void setRoleList(List<Role> roleList)
{
    this.roleList = roleList;
}

