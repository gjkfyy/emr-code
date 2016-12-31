package pkuhit.xap.po;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Portal extends BaseMasterModel {
 public Portal(){
  super();
 }
 public Portal(String code){
  super(code);
 }
// 门户编码
public static final   String  CODE = "XAPM06.AT01";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "XAPM06.AT02";
// 名称
public static final   String  NAME = "XAPM06.AT03";
// 描述
public static final   String  DESCRIPTION = "XAPM06.AT04";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "XAPM06.AT05";
// 英文名称
public static final   String  ENGLISH_NAME = "XAPM06.AT06";

// 门户编码
@Column(name="PORTAL_CD") 
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
// 组织机构名称
//@DictionaryTag(code = "organizationCode")
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
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }

}