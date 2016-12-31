package pkuhit.iih.mr.wr;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseBizModel;
import java.util.Date;

public class MrSign extends BaseBizModel {
 public MrSign(){
  super();
 }
 public MrSign(String code){
  super(code);
 }
// 医疗记录签名主键
public static final   String  PK = "MRB03.AT01";
// 医疗记录主键
public static final   String  MEDICAL_RECORD_PK = "MRB03.AT02";
// 审签级别编码
public static final   String  SIGN_LEVEL_CODE = "MRB03.AT03";
// 审签时间
public static final   String  SIGN_TIME = "MRB03.AT04";
// 审签人ID
public static final   String  SIGN_USER_ID = "MRB03.AT05";
// 审签科室编码
public static final   String  SIGN_DEPT_CODE = "MRB03.AT06";

// 医疗记录签名主键
@Column(name="MR_SIGN_PK") 
private  String pk;
// 医疗记录主键
@Column(name="MR_PK") 
private  String medicalRecordPk;
// 审签级别编码
@Column(name="SIGN_LVL_CD") 
private  String signLevelCode;
// 审签时间
@Column(name="SIGN_TIME") 
private  Date signTime;
// 审签人ID
@Column(name="SIGN_USER_ID") 
private  String signUserId;
// 审签科室编码
@Column(name="SIGN_DEPT_CD") 
private  String signDeptCode;
// 审签级别名称
@DictionaryTag(code = "signLevelCode")
private  String signLevelName;
// 审签人名
//@DictionaryTag(code = "signUserId")
private  String signUserName;
// 审签科室名称
//@DictionaryTag(code = "signDeptCode")
private  String signDeptName;
public String getPk()
 {
     return this.pk;
 }
public  void  setPk(String pk)
 {
  this.pk = pk;
 }
public String getMedicalRecordPk()
 {
     return this.medicalRecordPk;
 }
public  void  setMedicalRecordPk(String medicalRecordPk)
 {
  this.medicalRecordPk = medicalRecordPk;
 }
public String getSignLevelCode()
 {
     return this.signLevelCode;
 }
public  void  setSignLevelCode(String signLevelCode)
 {
  this.signLevelCode = signLevelCode;
 }
public Date getSignTime()
 {
     return this.signTime;
 }
public  void  setSignTime(Date signTime)
 {
  this.signTime = signTime;
 }
public String getSignUserId()
 {
     return this.signUserId;
 }
public  void  setSignUserId(String signUserId)
 {
  this.signUserId = signUserId;
 }
public String getSignDeptCode()
 {
     return this.signDeptCode;
 }
public  void  setSignDeptCode(String signDeptCode)
 {
  this.signDeptCode = signDeptCode;
 }
public String getSignLevelName()
 {
     return this.signLevelName;
 }
public  void  setSignLevelName(String signLevelName)
 {
  this.signLevelName = signLevelName;
 }
public String getSignUserName()
 {
     return this.signUserName;
 }
public  void  setSignUserName(String signUserName)
 {
  this.signUserName = signUserName;
 }
public String getSignDeptName()
 {
     return this.signDeptName;
 }
public  void  setSignDeptName(String signDeptName)
 {
  this.signDeptName = signDeptName;
 }

}