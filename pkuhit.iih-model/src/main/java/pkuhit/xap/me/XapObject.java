package pkuhit.xap.me;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class XapObject extends BaseMasterModel {
 public XapObject(){
  super();
 }
 public XapObject(String code){
  super(code);
 }
// 数据对象编码
public static final   String  CODE = "MEB02.AT01";
// 父数据对象编码
public static final   String  PARENT_CODE = "MEB02.AT02";
// 领域编码
public static final   String  DOMAIN_CODE = "MEB02.AT03";
// 根数据对象编码
public static final   String  ROOT_CODE = "MEB02.AT04";
// 版本号
public static final   String  VERSION_NO = "MEB02.AT05";
// 对象类型编码
public static final   String  TYPE_CODE = "MEB02.AT06";
// 名称
public static final   String  NAME = "MEB02.AT07";
// 描述
public static final   String  DESCRIPTION = "MEB02.AT08";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "MEB02.AT09";
// 英文名称
public static final   String  ENGLISH_NAME = "MEB02.AT10";
// 数据表名
public static final   String  TABLE_NAME = "MEB02.AT11";
// 通用主数据标志
public static final   String  COMMON_MASTER_DATA_FLAG = "MEB02.AT12";
// 数据表标志
public static final   String  TABLE_FLAG = "MEB02.AT13";
// 缓存标志
public static final   String  CACHE_FLAG = "MEB02.AT14";
// 常量生成标志
public static final   String  CONSTANT_FLAG = "MEB02.AT15";
// 包名
public static final   String  PACKAGE_PATH = "MEB02.AT16";
// 基类
public static final   String  BASE_CLASS = "MEB02.AT17";

// 数据对象编码
@Column(name="OBJ_CD") 
private  String code;
// 父数据对象编码
@Column(name="PAR_OBJ_CD") 
private  String parentCode;
// 领域编码
@Column(name="DO_CD") 
private  String domainCode;
// 根数据对象编码
@Column(name="RT_OBJ_CD") 
private  String rootCode;
// 版本号
@Column(name="VER_NO") 
private  String versionNo;
// 对象类型编码
@Column(name="OBJ_TP_CD") 
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
// 数据表名
@Column(name="TAB_NM") 
private  String tableName;
// 通用主数据标志
@Column(name="COM_MD_F") 
private  Integer commonMasterDataFlag;
// 数据表标志
@Column(name="TAB_F") 
private  Integer tableFlag;
// 缓存标志
@Column(name="CACHE_F") 
private  Integer cacheFlag;
// 常量生成标志
@Column(name="CONSTANT_F") 
private  Integer constantFlag;
// 包名
@Column(name="PACKGE_PATH") 
private  String packagePath;
// 基类
@Column(name="BASE_CLASS") 
private  String baseClass;
// 领域名称
private  String domainName;
// 对象类型名称
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
public String getTableName()
 {
     return this.tableName;
 }
public  void  setTableName(String tableName)
 {
  this.tableName = tableName;
 }
public Integer getCommonMasterDataFlag()
 {
     return this.commonMasterDataFlag;
 }
public  void  setCommonMasterDataFlag(Integer commonMasterDataFlag)
 {
  this.commonMasterDataFlag = commonMasterDataFlag;
 }
public Integer getTableFlag()
 {
     return this.tableFlag;
 }
public  void  setTableFlag(Integer tableFlag)
 {
  this.tableFlag = tableFlag;
 }
public Integer getCacheFlag()
 {
     return this.cacheFlag;
 }
public  void  setCacheFlag(Integer cacheFlag)
 {
  this.cacheFlag = cacheFlag;
 }
public Integer getConstantFlag()
 {
     return this.constantFlag;
 }
public  void  setConstantFlag(Integer constantFlag)
 {
  this.constantFlag = constantFlag;
 }
public String getPackagePath()
 {
     return this.packagePath;
 }
public  void  setPackagePath(String packagePath)
 {
  this.packagePath = packagePath;
 }
public String getBaseClass()
 {
     return this.baseClass;
 }
public  void  setBaseClass(String baseClass)
 {
  this.baseClass = baseClass;
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