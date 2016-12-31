package pkuhit.md;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;


public class BizRole extends BaseMasterModel {

 public BizRole(){

  super();

 }

 public BizRole(String code){

  super(code);

 }

public static final String   OBJ_CD  = "MDM10";

// 业务角色编码
public static final   String  CODE = "MDM10.AT01";
// 审签等级编码
public static final   String  SIGN_LVL_CODE = "MDM10.AT02";
// 名称
public static final   String  NAME = "MDM10.AT03";
// 描述
public static final   String  DESCRIPTION = "MDM10.AT04";
// 英文名称
public static final   String  ENGLISH_NAME = "MDM10.AT05";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME = "MDM10.AT06";


// 业务角色编码
@Column(name="BIZ_ROLE_CD") 
private  String code;

// 审签等级编码
@Column(name="SIGN_LVL_CD") 
private  String signLvlCode;

// 名称
@Column(name="NM") 
private  String name;

// 描述
@Column(name="DES") 
private  String description;

// 英文名称
@Column(name="NM_EN") 
private  String englishName;

// 英文简称
@Column(name="SHT_NM_EN") 
private  String shortEnglishName;
// 审签等级名称
@DictionaryTag(code = "signLvlCode",objCd ="null")
private  String signLvlName;

public String getCode()
 {
     return this.code;
 }

public  void  setCode(String code)
 {
  this.code = code;
 }

public String getSignLvlCode()
 {
     return this.signLvlCode;
 }

public  void  setSignLvlCode(String signLvlCode)
 {
  this.signLvlCode = signLvlCode;
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

public String getEnglishName()
 {
     return this.englishName;
 }

public  void  setEnglishName(String englishName)
 {
  this.englishName = englishName;
 }

public String getShortEnglishName()
 {
     return this.shortEnglishName;
 }

public  void  setShortEnglishName(String shortEnglishName)
 {
  this.shortEnglishName = shortEnglishName;
 }

public String getSignLvlName()
 {
     return this.signLvlName;
 }

public  void  setSignLvlName(String signLvlName)
 {
  this.signLvlName = signLvlName;
 }


}