package pkuhit.xap.me;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class XapService extends BaseMasterModel {
 public XapService(){
  super();
 }
 public XapService(String code){
  super(code);
 }
// 服务编码
public static final   String  CODE = "MEB05.AT01";
// 数据对象编码
public static final   String  OBJECT_CODE = "MEB05.AT02";
// 根服务编码
public static final   String  ROOT_CODE = "MEB05.AT03";
// 版本号
public static final   String  VERSION_NO = "MEB05.AT04";
// 名称
public static final   String  NAME = "MEB05.AT05";
// 描述
public static final   String  DESCRIPTION = "MEB05.AT06";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "MEB05.AT07";
// 英文名称
public static final   String  ENGLISH_NAME = "MEB05.AT08";
// REST操作编码
public static final   String  REST_ACTION_CODE = "MEB05.AT09";
// REST资源
public static final   String  REST_RESOURCE = "MEB05.AT10";
// 访问审计标志
public static final   String  ACCESS_AUDIT_FLAG = "MEB05.AT11";
// 性能设计标志
public static final   String  PERFORMANCE_AUDIT_FLAG = "MEB05.AT12";

// 服务编码
@Column(name="XSV_CD") 
private  String code;
// 数据对象编码
@Column(name="OBJ_CD") 
private  String objectCode;
// 根服务编码
@Column(name="RT_XSV_CD") 
private  String rootCode;
// 版本号
@Column(name="VER_NO") 
private  String versionNo;
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
// REST操作编码
@Column(name="REST_ACT_CD") 
private  String restActionCode;
// REST资源
@Column(name="REST_RE") 
private  String restResource;
// 访问审计标志
@Column(name="AC_AU_F") 
private  Integer accessAuditFlag;
// 性能设计标志
@Column(name="PFM_AU_F") 
private  Integer performanceAuditFlag;
// 数据对象名称
private  String objectName;
// REST操作名称
@DictionaryTag(code = "restActionCode")
private  String restActionName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getObjectCode()
 {
     return this.objectCode;
 }
public  void  setObjectCode(String objectCode)
 {
  this.objectCode = objectCode;
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
public String getRestActionCode()
 {
     return this.restActionCode;
 }
public  void  setRestActionCode(String restActionCode)
 {
  this.restActionCode = restActionCode;
 }
public String getRestResource()
 {
     return this.restResource;
 }
public  void  setRestResource(String restResource)
 {
  this.restResource = restResource;
 }
public Integer getAccessAuditFlag()
 {
     return this.accessAuditFlag;
 }
public  void  setAccessAuditFlag(Integer accessAuditFlag)
 {
  this.accessAuditFlag = accessAuditFlag;
 }
public Integer getPerformanceAuditFlag()
 {
     return this.performanceAuditFlag;
 }
public  void  setPerformanceAuditFlag(Integer performanceAuditFlag)
 {
  this.performanceAuditFlag = performanceAuditFlag;
 }
public String getObjectName()
 {
     return this.objectName;
 }
public  void  setObjectName(String objectName)
 {
  this.objectName = objectName;
 }
public String getRestActionName()
 {
     return this.restActionName;
 }
public  void  setRestActionName(String restActionName)
 {
  this.restActionName = restActionName;
 }

}