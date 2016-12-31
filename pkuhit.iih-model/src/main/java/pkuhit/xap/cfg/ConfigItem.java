package pkuhit.xap.cfg;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ConfigItem extends BaseMasterModel {
 public ConfigItem(){
  super();
 }
 public ConfigItem(String code){
  super(code);
 }

public static final String   OBJ_CD  = "XAPM08";

// 配置项目编码
public static final   String  CODE = "XAPM08.AT01";
// 配置项目类型编码
public static final   String  TYPE_CODE = "XAPM08.AT02";
// 配置项目分类编码
public static final   String  CATEGORY_CODE = "XAPM08.AT03";
// 名称
public static final   String  NAME = "XAPM08.AT04";
// 描述
public static final   String  DESCRIPTION = "XAPM08.AT05";
// 数据类型编码
public static final   String  DATA_TYPE_CODE = "XAPM08.AT06";
// 数据格式
public static final   String  DATA_FORMAT = "XAPM08.AT07";


// 配置项目编码
@Column(name="CFG_CD") 
private  String code;

// 配置项目类型编码
@Column(name="CFG_TP_CD") 
private  String typeCode;

// 配置项目分类编码
@Column(name="CFG_CAT_CD") 
private  String categoryCode;

// 名称
@Column(name="NM") 
private  String name;

// 描述
@Column(name="DES") 
private  String description;

// 数据类型编码
@Column(name="DT_TP_CD") 
private  String dataTypeCode;

// 数据格式
@Column(name="DT_FMT") 
private  String dataFormat;
// 配置项目类型名称
@DictionaryTag(code = "typeCode",objCd ="XAPM02")
private  String typeName;
// 配置项目分类名称
@DictionaryTag(code = "categoryCode",objCd ="XAPM03")
private  String categoryName;
// 数据类型名称
@DictionaryTag(code = "dataTypeCode",objCd ="MEM03")
private  String dataTypeName;

public String getCode()
 {
     return this.code;
 }

public  void  setCode(String code)
 {
  this.code = code;
 }

public String getTypeCode()
 {
     return this.typeCode;
 }

public  void  setTypeCode(String typeCode)
 {
  this.typeCode = typeCode;
 }

public String getCategoryCode()
 {
     return this.categoryCode;
 }

public  void  setCategoryCode(String categoryCode)
 {
  this.categoryCode = categoryCode;
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

public String getDataTypeCode()
 {
     return this.dataTypeCode;
 }

public  void  setDataTypeCode(String dataTypeCode)
 {
  this.dataTypeCode = dataTypeCode;
 }

public String getDataFormat()
 {
     return this.dataFormat;
 }

public  void  setDataFormat(String dataFormat)
 {
  this.dataFormat = dataFormat;
 }

public String getTypeName()
 {
     return this.typeName;
 }

public  void  setTypeName(String typeName)
 {
  this.typeName = typeName;
 }

public String getCategoryName()
 {
     return this.categoryName;
 }

public  void  setCategoryName(String categoryName)
 {
  this.categoryName = categoryName;
 }

public String getDataTypeName()
 {
     return this.dataTypeName;
 }

public  void  setDataTypeName(String dataTypeName)
 {
  this.dataTypeName = dataTypeName;
 }
}