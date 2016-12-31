package pkuhit.org;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import pkuhit.xap.ac.Role;

public class Organization extends BaseMasterModel {
 public Organization(){
  super();
 }
 public Organization(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "ORGB01";// 组织机构编码
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

// 组织机构编码
@Column(name="ORG_CD") 
private  String code;
// 父组织机构编码
@Column(name="PAR_ORG_CD") 
private  String parentCode;
// 地点编码
@Column(name="PLC_CD") 
private  String placeCode;
// 组织机构类型编码
@Column(name="ORG_TP_CD") 
private  String typeCode;
// 名称
@Column(name="NM") 
private  String name;
// 描述
@Column(name="DES") 
private  String description;
// 简称
@Column(name="SHT_NM") 
private  String shortName;
// 别名
@Column(name="ALIAS_NM") 
private  String aliasName;
// 区县编码
@Column(name="DIST_CD") 
private  String districtCode;
// 乡镇街道名称
@Column(name="SUBDIST_NM") 
private  String subdistrictName;
// 邮政编码
@Column(name="ZIP_NO") 
private  String zipNo;
// 固定电话
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
public String getPlaceCode()
 {
     return this.placeCode;
 }
public  void  setPlaceCode(String placeCode)
 {
  this.placeCode = placeCode;
 }
public String getTypeCode()
 {
     return this.typeCode;
 }
public  void  setTypeCode(String typeCode)
 {
  this.typeCode = typeCode;
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
public String getShortName()
 {
     return this.shortName;
 }
public  void  setShortName(String shortName)
 {
  this.shortName = shortName;
 }
public String getAliasName()
 {
     return this.aliasName;
 }
public  void  setAliasName(String aliasName)
 {
  this.aliasName = aliasName;
 }
public String getDistrictCode()
 {
     return this.districtCode;
 }
public  void  setDistrictCode(String districtCode)
 {
  this.districtCode = districtCode;
 }
public String getSubdistrictName()
 {
     return this.subdistrictName;
 }
public  void  setSubdistrictName(String subdistrictName)
 {
  this.subdistrictName = subdistrictName;
 }
public String getZipNo()
 {
     return this.zipNo;
 }
public  void  setZipNo(String zipNo)
 {
  this.zipNo = zipNo;
 }
public String getTelNo()
 {
     return this.telNo;
 }
public  void  setTelNo(String telNo)
 {
  this.telNo = telNo;
 }
public String getPlaceName()
 {
     return this.placeName;
 }
public  void  setPlaceName(String placeName)
 {
  this.placeName = placeName;
 }
public String getTypeName()
 {
     return this.typeName;
 }
public  void  setTypeName(String typeName)
 {
  this.typeName = typeName;
 }
public String getDistrictName()
 {
     return this.districtName;
 }
public  void  setDistrictName(String districtName)
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

}