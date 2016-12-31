package pkuhit.iih.mr.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;

public class MrTypeCustomCategoryItem extends BaseRelationModel {
 public MrTypeCustomCategoryItem(){
  super();
 }
 public MrTypeCustomCategoryItem(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "MRM15";// 医疗记录类型自定义分类项目编码
public static final   String  CODE = "MRM15.AT01";
// 医疗记录自定义分类编码
public static final   String  MR_TYPE_CUSTOM_CODE = "MRM15.AT02";
// 医疗记录类型编码
public static final   String  MR_TYPE__CODE = "MRM15.AT03";
// 就诊类型编码
public static final   String  ENCOUNTER_TYPE_CODE = "MRM15.AT04";

// 医疗记录类型自定义分类项目编码
@Column(name="MR_TP_CCAT_ITM_CD") 
private  String code;
// 医疗记录自定义分类编码
@Column(name="MR_TP_CCAT_CD") 
private  String mrTypeCustomCode;
// 医疗记录类型编码
@Column(name="MR_TP_CD") 
private  String mrTypeCode;
// 就诊类型编码
@Column(name="EN_TP_CD") 
private  String encounterTypeCode;
// 医疗记录自定义分类名称
//@DictionaryTag(code = "mrTypeCustomCode")
private  String mrTypeCustomName;
// 医疗记录类型名称
//@DictionaryTag(code = "mrTypeCode")
private  String mrTypeName;
// 就诊类型名称
@DictionaryTag(code = "encounterTypeCode",objCd ="ENM01")
private  String encounterTypeName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getMrTypeCustomCode()
 {
     return this.mrTypeCustomCode;
 }
public  void  setMrTypeCustomCode(String mrTypeCustomCode)
 {
  this.mrTypeCustomCode = mrTypeCustomCode;
 }
public String getMrTypeCode()
 {
     return this.mrTypeCode;
 }
public  void  setMrTypeCode(String mrTypeCode)
 {
  this.mrTypeCode = mrTypeCode;
 }
public String getEncounterTypeCode()
 {
     return this.encounterTypeCode;
 }
public  void  setEncounterTypeCode(String encounterTypeCode)
 {
  this.encounterTypeCode = encounterTypeCode;
 }
public String getMrTypeCustomName()
 {
     return this.mrTypeCustomName;
 }
public  void  setMrTypeCustomName(String mrTypeCustomName)
 {
  this.mrTypeCustomName = mrTypeCustomName;
 }
public String getMrTypeName()
 {
     return this.mrTypeName;
 }
public  void  setMrTypeName(String mrTypeName)
 {
  this.mrTypeName = mrTypeName;
 }
public String getEncounterTypeName()
 {
     return this.encounterTypeName;
 }
public  void  setEncounterTypeName(String encounterTypeName)
 {
  this.encounterTypeName = encounterTypeName;
 }

}