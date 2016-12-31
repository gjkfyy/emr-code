package pkuhit.xap.cfg;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ConfigItemData extends BaseRelationModel {
 public ConfigItemData(){
  super();
 }
 public ConfigItemData(String code){
  super(code);
 }

public static final String   OBJ_CD  = "XAPM10";

// 配置数据编码
public static final   String  CODE = "XAPM10.AT01";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "XAPM10.AT02";
// 配置项目编码
public static final   String  CONFIG_CODE = "XAPM10.AT03";
// 值
public static final   String  VALUE = "XAPM10.AT04";
// 最大值
public static final   String  MAX_VALUE = "XAPM10.AT05";
// 最小值
public static final   String  MIN_VALUE = "XAPM10.AT06";


// 配置数据编码
@Column(name="CFG_DATA_CD") 
private  String code;

// 组织机构编码
@Column(name="ORG_CD") 
private  String organizationCode;

// 配置项目编码
@Column(name="CFG_CD") 
private  String configCode;

// 值
@Column(name="VAL") 
private  String value;

// 最大值
@Column(name="MAX_VAL") 
private  String maxValue;

// 最小值
@Column(name="MIN_VAL") 
private  String minValue;
// 组织机构名称
//@DictionaryTag(code = "organizationCode",objCd ="ORGB01")
private  String organizationName;
// 配置项目名称
@DictionaryTag(code = "configCode",objCd ="XAPM08")
private  String configName;

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

public String getConfigCode()
 {
     return this.configCode;
 }

public  void  setConfigCode(String configCode)
 {
  this.configCode = configCode;
 }

public String getValue()
 {
     return this.value;
 }

public  void  setValue(String value)
 {
  this.value = value;
 }

public String getMaxValue()
 {
     return this.maxValue;
 }

public  void  setMaxValue(String maxValue)
 {
  this.maxValue = maxValue;
 }

public String getMinValue()
 {
     return this.minValue;
 }

public  void  setMinValue(String minValue)
 {
  this.minValue = minValue;
 }

public String getOrganizationName()
 {
     return this.organizationName;
 }

public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }

public String getConfigName()
 {
     return this.configName;
 }

public  void  setConfigName(String configName)
 {
  this.configName = configName;
 }
}