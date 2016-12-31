package pkuhit.iih.mr.tpl;
import xap.model.BaseRelationModel;
import xap.sv.annotation.Column;

public class MrTemplateDiagnosis extends BaseRelationModel {
 public MrTemplateDiagnosis(){
  super();
 }
 public MrTemplateDiagnosis(String code){
  super(code);
 }
public static final String   OBJ_CD  = "MRK03";

// 医疗记录模板诊断编码
public static final   String  CODE = "MRK03.AT01";
// 医疗记录模板编码
public static final   String  MR_TEMPLATE_CODE = "MRK03.AT02";
// 诊断编码
public static final   String  DIAGNOSIS_CODE = "MRK03.AT03";

// 医疗记录模板诊断编码
@Column(name="MR_TPL_DI_CD") 
private  String code;
// 医疗记录模板编码
@Column(name="MR_TPL_CD") 
private  String mrTemplateCode;
// 诊断编码
@Column(name="DI_CD") 
private  String diagnosisCode;
// 医疗记录模板名称
private  String mrTemplateName;
// 诊断名称
private  String diagnosisName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getMrTemplateCode()
 {
     return this.mrTemplateCode;
 }
public  void  setMrTemplateCode(String mrTemplateCode)
 {
  this.mrTemplateCode = mrTemplateCode;
 }
public String getDiagnosisCode()
 {
     return this.diagnosisCode;
 }
public  void  setDiagnosisCode(String diagnosisCode)
 {
  this.diagnosisCode = diagnosisCode;
 }
public String getMrTemplateName()
 {
     return this.mrTemplateName;
 }
public  void  setMrTemplateName(String mrTemplateName)
 {
  this.mrTemplateName = mrTemplateName;
 }
public String getDiagnosisName()
 {
     return this.diagnosisName;
 }
public  void  setDiagnosisName(String diagnosisName)
 {
  this.diagnosisName = diagnosisName;
 }

}