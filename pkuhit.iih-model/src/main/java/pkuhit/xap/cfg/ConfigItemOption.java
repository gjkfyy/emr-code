package pkuhit.xap.cfg;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ConfigItemOption extends BaseMasterModel {
 public ConfigItemOption(){
  super();
 }
 public ConfigItemOption(String code){
  super(code);
 }

public static final String   OBJ_CD  = "XAPM09";

// 配置选项编码
public static final   String  CODE = "XAPM09.AT01";
// 配置项目编码
public static final   String  CONFIG_CODE = "XAPM09.AT02";
// 名称
public static final   String  NAME = "XAPM09.AT03";
// 描述
public static final   String  DESCRIPTION = "XAPM09.AT04";
// 值
public static final   String  VALUE = "XAPM09.AT05";


// 配置选项编码
@Column(name="OPTN_CD") 
private  String code;

// 配置项目编码
@Column(name="CFG_CD") 
private  String configCode;

// 名称
@Column(name="NM") 
private  String name;

// 描述
@Column(name="DES") 
private  String description;

// 值
@Column(name="VAL") 
private  String value;
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

public String getConfigCode()
 {
     return this.configCode;
 }

public  void  setConfigCode(String configCode)
 {
  this.configCode = configCode;
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

public String getValue()
 {
     return this.value;
 }

public  void  setValue(String value)
 {
  this.value = value;
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