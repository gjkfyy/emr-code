package pkuhit.xap.ac;

import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Role extends BaseMasterModel {

 public Role(){

  super();

 }

 public Role(String code){

  super(code);

 }

public static final String   OBJ_CD  = "XAPM14";

// 角色编码
public static final   String  CODE = "XAPM14.AT01";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "XAPM14.AT02";
// 名称
public static final   String  NAME = "XAPM14.AT03";
// 描述
public static final   String  DESCRIPTION = "XAPM14.AT04";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "XAPM14.AT05";
// 英文名称
public static final   String  ENGLISH_NAME = "XAPM14.AT06";
// 业务角色标志
public static final   String  BIZ_ROLE_CODE = "XAPM14.AT07";


// 角色编码
@Column(name="ROLE_CD") 
private  String code;

// 组织机构编码
@Column(name="ORG_CD") 
private  String organizationCode;

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

// 业务角色标志
@Column(name="BIZ_ROLE_CD") 
private  Integer bizRoleCode;
// 组织机构名称
//@DictionaryTag(code = "organizationCode",objCd ="ORGB01")
private  String organizationName;

public String getCode()
 {
     return this.code;
 }

public  void  setCode(String code)
 {
  this.code = code;
 }

public String getOrganizationCode()
 {
     return this.organizationCode;
 }

public  void  setOrganizationCode(String organizationCode)
 {
  this.organizationCode = organizationCode;
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

public Integer getBizRoleCode()
 {
     return this.bizRoleCode;
 }

public  void  setBizRoleCode(Integer bizRoleCode)
 {
  this.bizRoleCode = bizRoleCode;
 }

public String getOrganizationName()
 {
     return this.organizationName;
 }

public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }


}