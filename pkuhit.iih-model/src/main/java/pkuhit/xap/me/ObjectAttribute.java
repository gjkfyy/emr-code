package pkuhit.xap.me;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ObjectAttribute extends BaseMasterModel {
 public ObjectAttribute(){
  super();
 }
 public ObjectAttribute(String code){
  super(code);
 }
// 数据元素编码
public static final   String  CODE = "MEB03.AT01";
// 数据对象编码
public static final   String  OBJECT_CODE = "MEB03.AT02";
// 外键数据对象编码
public static final   String  FK_OBJECT_CODE = "MEB03.AT03";
// 名称
public static final   String  NAME = "MEB03.AT04";
// 描述
public static final   String  DESCRIPTION = "MEB03.AT05";
// 英文简称
public static final   String  SHORT_ENGLISH_NAME_ = "MEB03.AT06";
// 英文名称
public static final   String  ENGLISH_NAME = "MEB03.AT07";
// 数据类型编码
public static final   String  DATA_TYPE_CODE = "MEB03.AT08";
// 单位编码
public static final   String  UNIT_CODE = "MEB03.AT09";
// 长度(byte)
public static final   String  LENGTH = "MEB03.AT10";
// 精度(10进制小数位数)
public static final   String  PRECISION = "MEB03.AT11";
// 最小值(默认单位)
public static final   String  MIN_VALUE = "MEB03.AT12";
// 最大值(默认单位)
public static final   String  MAX_VALUE = "MEB03.AT13";
// 默认值(默认单位)
public static final   String  DEFAULT_VALUE = "MEB03.AT14";
// 对齐方式编码
public static final   String  ALIGN_CODE = "MEB03.AT15";
// 名称从缓存中获取
public static final   String  NAME_FROM_CACHE_FLAG = "MEB03.AT16";
// 大写标志
public static final   String  UPPER_FLAG = "MEB03.AT17";
// 小写标志
public static final   String  LOWER_FLAG = "MEB03.AT18";
// 主键标志
public static final   String  PK_FLAG = "MEB03.AT19";
// 外键标志
public static final   String  FK_FLAG = "MEB03.AT20";
// 非空标志
public static final   String  NOT_NULL_FLAG = "MEB03.AT21";
// 唯一标志
public static final   String  UNIQUE_FLAG = "MEB03.AT22";
// 索引标志
public static final   String  INDEX_FLAG = "MEB03.AT23";
// 持久化标志
public static final   String  PERSISTENT_FLAG = "MEB03.AT24";
// 保密标志
public static final   String  SECRET_FLAG = "MEB03.AT25";
// 状态审计标志
public static final   String  STATUS_AUDIT_FLAG = "MEB03.AT26";
// 自定义校验规则
public static final   String  VERIFY_RULE = "MEB03.AT27";
// 显示格式
public static final   String  SHOW_FORMAT = "MEB03.AT28";
// 编辑框高度(px)
public static final   String  EDIT_HIGHT = "MEB03.AT29";
// 编辑框宽度(px)
public static final   String  EDIT_WIDTH = "MEB03.AT30";
// 表格列宽度(px)
public static final   String  GRID_COLUMN_WIDTH = "MEB03.AT31";
// 提示信息编码
public static final   String  TIP_MESSAGE_CODE = "MEB03.AT32";

// 数据元素编码
@Column(name="OBJ_ATTR_CD") 
private  String code;
// 数据对象编码
@Column(name="OBJ_CD") 
private  String objectCode;
// 外键数据对象编码
@Column(name="FK_OBJ_CD") 
private  String fkObjectCode;
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
// 数据类型编码
@Column(name="DT_TP_CD") 
private  String dataTypeCode;
// 单位编码
@Column(name="UNIT_CD") 
private  String unitCode;
// 长度(byte)
@Column(name="LEN") 
private  Integer length;
// 精度(10进制小数位数)
@Column(name="PREC") 
private  Integer precision;
// 最小值(默认单位)
@Column(name="MIN_VAL") 
private  String minValue;
// 最大值(默认单位)
@Column(name="MAX_VAL") 
private  String maxValue;
// 默认值(默认单位)
@Column(name="DFT_VAL") 
private  String defaultValue;
// 对齐方式编码
@Column(name="ALIGN_CD") 
private  String alignCode;
// 名称从缓存中获取
@Column(name="NM_CACHE_F") 
private  Integer nameFromCacheFlag;
// 大写标志
@Column(name="UPPER_F") 
private  Integer upperFlag;
// 小写标志
@Column(name="LOWER_F") 
private  Integer lowerFlag;
// 主键标志
@Column(name="PK_F") 
private  Integer pkFlag;
// 外键标志
@Column(name="FK_F") 
private  Integer fkFlag;
// 非空标志
@Column(name="NN_F") 
private  Integer notNullFlag;
// 唯一标志
@Column(name="UN_F") 
private  Integer uniqueFlag;
// 索引标志
@Column(name="IN_F") 
private  Integer indexFlag;
// 持久化标志
@Column(name="PERS_F") 
private  Integer persistentFlag;
// 保密标志
@Column(name="SECU_F") 
private  Integer secretFlag;
// 状态审计标志
@Column(name="STA_AU_F") 
private  Integer statusAuditFlag;
// 自定义校验规则
@Column(name="VALI_RULE") 
private  String verifyRule;
// 显示格式
@Column(name="SHW_FMT") 
private  String showFormat;
// 编辑框高度(px)
@Column(name="EDIT_HIGHT") 
private  Integer editHight;
// 编辑框宽度(px)
@Column(name="EDIT_WIDTH") 
private  Integer editWidth;
// 表格列宽度(px)
@Column(name="GRID_COL_WIDTH") 
private  Integer gridColumnWidth;
// 提示信息编码
@Column(name="TIP_MSG_CD") 
private  String tipMessageCode;
// 数据对象名称
private  String objectName;
// 数据类型名称
@DictionaryTag(code = "dataTypeCode")
private  String dataTypeName;
// 单位名称
@DictionaryTag(code = "unitCode")
private  String unitName;
// 对齐方式名称
@DictionaryTag(code = "alignCode")
private  String alignName;
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
public String getFkObjectCode()
 {
     return this.fkObjectCode;
 }
public  void  setFkObjectCode(String fkObjectCode)
 {
  this.fkObjectCode = fkObjectCode;
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
public String getDataTypeCode()
 {
     return this.dataTypeCode;
 }
public  void  setDataTypeCode(String dataTypeCode)
 {
  this.dataTypeCode = dataTypeCode;
 }
public String getUnitCode()
 {
     return this.unitCode;
 }
public  void  setUnitCode(String unitCode)
 {
  this.unitCode = unitCode;
 }
public Integer getLength()
 {
     return this.length;
 }
public  void  setLength(Integer length)
 {
  this.length = length;
 }
public Integer getPrecision()
 {
     return this.precision;
 }
public  void  setPrecision(Integer precision)
 {
  this.precision = precision;
 }
public String getMinValue()
 {
     return this.minValue;
 }
public  void  setMinValue(String minValue)
 {
  this.minValue = minValue;
 }
public String getMaxValue()
 {
     return this.maxValue;
 }
public  void  setMaxValue(String maxValue)
 {
  this.maxValue = maxValue;
 }
public String getDefaultValue()
 {
     return this.defaultValue;
 }
public  void  setDefaultValue(String defaultValue)
 {
  this.defaultValue = defaultValue;
 }
public String getAlignCode()
 {
     return this.alignCode;
 }
public  void  setAlignCode(String alignCode)
 {
  this.alignCode = alignCode;
 }
public Integer getNameFromCacheFlag()
 {
     return this.nameFromCacheFlag;
 }
public  void  setNameFromCacheFlag(Integer nameFromCacheFlag)
 {
  this.nameFromCacheFlag = nameFromCacheFlag;
 }
public Integer getUpperFlag()
 {
     return this.upperFlag;
 }
public  void  setUpperFlag(Integer upperFlag)
 {
  this.upperFlag = upperFlag;
 }
public Integer getLowerFlag()
 {
     return this.lowerFlag;
 }
public  void  setLowerFlag(Integer lowerFlag)
 {
  this.lowerFlag = lowerFlag;
 }
public Integer getPkFlag()
 {
     return this.pkFlag;
 }
public  void  setPkFlag(Integer pkFlag)
 {
  this.pkFlag = pkFlag;
 }
public Integer getFkFlag()
 {
     return this.fkFlag;
 }
public  void  setFkFlag(Integer fkFlag)
 {
  this.fkFlag = fkFlag;
 }
public Integer getNotNullFlag()
 {
     return this.notNullFlag;
 }
public  void  setNotNullFlag(Integer notNullFlag)
 {
  this.notNullFlag = notNullFlag;
 }
public Integer getUniqueFlag()
 {
     return this.uniqueFlag;
 }
public  void  setUniqueFlag(Integer uniqueFlag)
 {
  this.uniqueFlag = uniqueFlag;
 }
public Integer getIndexFlag()
 {
     return this.indexFlag;
 }
public  void  setIndexFlag(Integer indexFlag)
 {
  this.indexFlag = indexFlag;
 }
public Integer getPersistentFlag()
 {
     return this.persistentFlag;
 }
public  void  setPersistentFlag(Integer persistentFlag)
 {
  this.persistentFlag = persistentFlag;
 }
public Integer getSecretFlag()
 {
     return this.secretFlag;
 }
public  void  setSecretFlag(Integer secretFlag)
 {
  this.secretFlag = secretFlag;
 }
public Integer getStatusAuditFlag()
 {
     return this.statusAuditFlag;
 }
public  void  setStatusAuditFlag(Integer statusAuditFlag)
 {
  this.statusAuditFlag = statusAuditFlag;
 }
public String getVerifyRule()
 {
     return this.verifyRule;
 }
public  void  setVerifyRule(String verifyRule)
 {
  this.verifyRule = verifyRule;
 }
public String getShowFormat()
 {
     return this.showFormat;
 }
public  void  setShowFormat(String showFormat)
 {
  this.showFormat = showFormat;
 }
public Integer getEditHight()
 {
     return this.editHight;
 }
public  void  setEditHight(Integer editHight)
 {
  this.editHight = editHight;
 }
public Integer getEditWidth()
 {
     return this.editWidth;
 }
public  void  setEditWidth(Integer editWidth)
 {
  this.editWidth = editWidth;
 }
public Integer getGridColumnWidth()
 {
     return this.gridColumnWidth;
 }
public  void  setGridColumnWidth(Integer gridColumnWidth)
 {
  this.gridColumnWidth = gridColumnWidth;
 }
public String getTipMessageCode()
 {
     return this.tipMessageCode;
 }
public  void  setTipMessageCode(String tipMessageCode)
 {
  this.tipMessageCode = tipMessageCode;
 }
public String getObjectName()
 {
     return this.objectName;
 }
public  void  setObjectName(String objectName)
 {
  this.objectName = objectName;
 }
public String getDataTypeName()
 {
     return this.dataTypeName;
 }
public  void  setDataTypeName(String dataTypeName)
 {
  this.dataTypeName = dataTypeName;
 }
public String getUnitName()
 {
     return this.unitName;
 }
public  void  setUnitName(String unitName)
 {
  this.unitName = unitName;
 }
public String getAlignName()
 {
     return this.alignName;
 }
public  void  setAlignName(String alignName)
 {
  this.alignName = alignName;
 }

}