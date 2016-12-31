package pkuhit.xap.me;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class DataAcessRule extends BaseRelationModel {
 public DataAcessRule(){
  super();
 }
 public DataAcessRule(String code){
  super(code);
 }
// 访问规则编码
public static final   String  CODE = "MEB04.AT01";
// 数据对象编码
public static final   String  OBJECT_CODE = "MEB04.AT02";
// 名称
public static final   String  NAME = "MEB04.AT03";
// 描述
public static final   String  DESCRIPTION = "MEB04.AT04";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "MEB04.AT05";
// 英文名称
public static final   String  ENGLISH_NAME = "MEB04.AT06";
// 规则
public static final   String  RULE = "MEB04.AT07";

// 访问规则编码
@Column(name="DATA_ACRU_CD") 
private  String code;
// 数据对象编码
@Column(name="OBJ_CD") 
private  String objectCode;
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
// 规则
@Column(name="RULE") 
private  String rule;
// 数据对象名称
private  String objectName;
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
public String getRule()
 {
     return this.rule;
 }
public  void  setRule(String rule)
 {
  this.rule = rule;
 }
public String getObjectName()
 {
     return this.objectName;
 }
public  void  setObjectName(String objectName)
 {
  this.objectName = objectName;
 }

}