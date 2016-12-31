package pkuhit.iih.mr.md;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;

public class MrTypeSignlevel extends BaseRelationModel {
 public MrTypeSignlevel(){
  super();
 }
 public MrTypeSignlevel(String code){
  super(code);
 }
// 医疗记录类型审签级别编码
public static final   String  CODE = "MRM18.AT01";
// 医疗记录类型编码
public static final   String  MR_TYPE_CODE = "MRM18.AT02";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "MRM18.AT03";
// 诊断编码
public static final   String  DIAGNOSIS_CODE = "MRM18.AT04";
// 审签级别编码
public static final   String  MR_SIGN_LEVEL_CODE = "MRM18.AT05";

// 医疗记录类型审签级别编码
@Column(name="MR_TP_SIGN_LVL_CD") 
private  String code;
// 医疗记录类型编码
@Column(name="MR_TP_CD") 
private  String mrTypeCode;
// 组织机构编码
@Column(name="ORG_CD") 
private  String organizationCode;
// 诊断编码
@Column(name="DI_CD") 
private  String diagnosisCode;
// 审签级别编码
@Column(name="MR_SIGN_LVL_CD") 
private  String mrSignLevelCode;
// 医疗记录类型名称
@DictionaryTag(code = "mrTypeCode")
private  String mrTypeName;
// 组织机构名称
//@DictionaryTag(code = "organizationCode")
private  String organizationName;
// 诊断名称
@DictionaryTag(code = "diagnosisCode")
private  String diagnosisName;
// 审签级别名称
@DictionaryTag(code = "mrSignLevelCode")
private  String mrSignLevelName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getMrTypeCode()
 {
     return this.mrTypeCode;
 }
public  void  setMrTypeCode(String mrTypeCode)
 {
  this.mrTypeCode = mrTypeCode;
 }
public String getOrganizationCode()
 {
     return this.organizationCode;
 }
public  void  setOrganizationCode(String organizationCode)
 {
  this.organizationCode = organizationCode;
 }
public String getDiagnosisCode()
 {
     return this.diagnosisCode;
 }
public  void  setDiagnosisCode(String diagnosisCode)
 {
  this.diagnosisCode = diagnosisCode;
 }
public String getMrSignLevelCode()
 {
     return this.mrSignLevelCode;
 }
public  void  setMrSignLevelCode(String mrSignLevelCode)
 {
  this.mrSignLevelCode = mrSignLevelCode;
 }
public String getMrTypeName()
 {
     return this.mrTypeName;
 }
public  void  setMrTypeName(String mrTypeName)
 {
  this.mrTypeName = mrTypeName;
 }
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }
public String getDiagnosisName()
 {
     return this.diagnosisName;
 }
public  void  setDiagnosisName(String diagnosisName)
 {
  this.diagnosisName = diagnosisName;
 }
public String getMrSignLevelName()
 {
     return this.mrSignLevelName;
 }
public  void  setMrSignLevelName(String mrSignLevelName)
 {
  this.mrSignLevelName = mrSignLevelName;
 }

}