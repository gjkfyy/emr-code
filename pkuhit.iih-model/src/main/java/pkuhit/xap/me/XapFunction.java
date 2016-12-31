package pkuhit.xap.me;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class XapFunction extends BaseMasterModel {
 public XapFunction(){
  super();
 }
 public XapFunction(String code){
  super(code);
 }
// 功能编码
public static final   String  CODE = "MEB06.AT01";
// 功能模板编码
public static final   String  TEMPLATE_CODE = "MEB06.AT02";
// 父功能编码
public static final   String  PARENT_CODE = "MEB06.AT03";
// 领域编码
public static final   String  DOMAIN_CODE = "MEB06.AT04";
// 根功能编码
public static final   String  ROOT_CODE = "MEB06.AT05";
// 版本号
public static final   String  VERSION_NO = "MEB06.AT06";
// 功能类型编码
public static final   String  TYPE_CODE = "MEB06.AT07";
// 名称
public static final   String  NAME = "MEB06.AT08";
// 描述
public static final   String  DESCRIPTION = "MEB06.AT09";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "MEB06.AT10";
// 英文名称
public static final   String  ENGLISH_NAME = "MEB06.AT11";
// 菜单标志
public static final   String  MENU_FLAG = "MEB06.AT12";
// 菜单名称
public static final   String  MENU_NAME = "MEB06.AT13";

// 功能编码
@Column(name="FU_CD") 
private  String code;
// 功能模板编码
@Column(name="FUTPL_CD") 
private  String templateCode;
// 父功能编码
@Column(name="PAR_FU_CD") 
private  String parentCode;
// 领域编码
@Column(name="DO_CD") 
private  String domainCode;
// 根功能编码
@Column(name="RT_FU_CD") 
private  String rootCode;
// 版本号
@Column(name="VER_NO") 
private  String versionNo;
// 功能类型编码
@Column(name="FU_TP_CD") 
private  String typeCode;
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
// 菜单标志
@Column(name="MENU_F") 
private  Integer menuFlag;
// 菜单名称
@Column(name="MENU_NM") 
private  String menuName;
// 领域名称
private  String domainName;
// 功能类型名称
@DictionaryTag(code = "typeCode")
private  String typeName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getTemplateCode()
 {
     return this.templateCode;
 }
public  void  setTemplateCode(String templateCode)
 {
  this.templateCode = templateCode;
 }
public String getParentCode()
 {
     return this.parentCode;
 }
public  void  setParentCode(String parentCode)
 {
  this.parentCode = parentCode;
 }
public String getDomainCode()
 {
     return this.domainCode;
 }
public  void  setDomainCode(String domainCode)
 {
  this.domainCode = domainCode;
 }
public String getRootCode()
 {
     return this.rootCode;
 }
public  void  setRootCode(String rootCode)
 {
  this.rootCode = rootCode;
 }
public String getVersionNo()
 {
     return this.versionNo;
 }
public  void  setVersionNo(String versionNo)
 {
  this.versionNo = versionNo;
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
public Integer getMenuFlag()
 {
     return this.menuFlag;
 }
public  void  setMenuFlag(Integer menuFlag)
 {
  this.menuFlag = menuFlag;
 }
public String getMenuName()
 {
     return this.menuName;
 }
public  void  setMenuName(String menuName)
 {
  this.menuName = menuName;
 }
public String getDomainName()
 {
     return this.domainName;
 }
public  void  setDomainName(String domainName)
 {
  this.domainName = domainName;
 }
public String getTypeName()
 {
     return this.typeName;
 }
public  void  setTypeName(String typeName)
 {
  this.typeName = typeName;
 }

}