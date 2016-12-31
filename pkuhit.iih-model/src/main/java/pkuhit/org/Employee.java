package pkuhit.org;

import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Employee extends BaseMasterModel {

 public Employee(){

  super();

 }

 public Employee(String code){

  super(code);

 }

public static final String   OBJ_CD  = "ORGB04";

// 人员ID
public static final   String  ID = "ORGB04.AT01";
// 部门编码
public static final   String  DEPT_CODE = "ORGB04.AT02";
// 工号
public static final   String  EMPLOYEE_NO = "ORGB04.AT03";
// 姓名
public static final   String  NAME = "ORGB04.AT04";
// 姓名拼音
public static final   String  NAME_SPELL = "ORGB04.AT05";
// 性别编码
public static final   String  SEX_CODE = "ORGB04.AT06";
// 出生日期
public static final   String  BIRTHDAY = "ORGB04.AT07";
// 身份证号
public static final   String  ID_CARD_NO = "ORGB04.AT08";
// 电子邮箱
public static final   String  EMAIL = "ORGB04.AT09";
// 职称编码
public static final   String  JOB_TITLE_CODE = "ORGB04.AT10";
// 职务编码
public static final   String  POSITON_CODE = "ORGB04.AT11";
// 专业类别编码
public static final   String  PROFESSION_CODE = "ORGB04.AT12";
// 移动电话
public static final   String  MOBILE_NO = "ORGB04.AT13";
// 固定电话
public static final   String  TEL_NO = "ORGB04.AT14";


// 人员ID
@Column(name="EMP_ID") 
private  String id;

// 部门编码
@Column(name="DEPT_CD") 
private  String deptCode;

// 工号
@Column(name="EMP_NO") 
private  String employeeNo;

// 姓名
@Column(name="NM") 
private  String name;

// 姓名拼音
@Column(name="NM_SPELL") 
private  String nameSpell;

// 性别编码
@Column(name="SEX_CD") 
private  String sexCode;

// 出生日期
@Column(name="BIRTHDAY") 
private  Date birthday;

// 身份证号
@Column(name="ID_CARD_NO") 
private  String idCardNo;

// 电子邮箱
@Column(name="EMAIL") 
private  String email;

// 职称编码
@Column(name="JOB_TITLE_CD") 
private  String jobTitleCode;

//职称名称
@Column(name="JOB_TITLE_NM")
private  String jobTitleNm;

//业务角色编码
@Column(name="BIZ_ROLE_CD") 
private  String bizRoleCode;

// 职务编码
@Column(name="POSITION_CD") 
private  String positonCode;

// 专业类别编码
@Column(name="PROF_CD") 
private  String professionCode;

// 移动电话
@Column(name="MOBILE_NO") 
private  String mobileNo;

// 固定电话
@Column(name="TEL_NO") 
private  String telNo;
// 部门名称
//@DictionaryTag(code = "deptCode",objCd ="ORGB02")
private  String deptName;
// 性别名称
@DictionaryTag(code = "sexCode",objCd ="MDM05")
private  String sexName;
//职称名称
@DictionaryTag(code = "jobTitleCode",objCd ="")
private  String jobTitleName;

//业务角色名称
@Column(name="BIZROLENAME") 
private  String bizRoleName;

public String getJobTitleNm()
{
    return jobTitleNm;
}

public void setJobTitleNm(String jobTitleNm)
{
    this.jobTitleNm = jobTitleNm;
}

public String getId()
 {
     return this.id;
 }

public  void  setId(String id)
 {
  this.id = id;
 }

public String getDeptCode()
 {
     return this.deptCode;
 }

public  void  setDeptCode(String deptCode)
 {
  this.deptCode = deptCode;
 }

public String getEmployeeNo()
 {
     return this.employeeNo;
 }

public  void  setEmployeeNo(String employeeNo)
 {
  this.employeeNo = employeeNo;
 }

public String getName()
 {
     return this.name;
 }

public  void  setName(String name)
 {
  this.name = name;
 }

public String getNameSpell()
 {
     return this.nameSpell;
 }

public  void  setNameSpell(String nameSpell)
 {
  this.nameSpell = nameSpell;
 }

public String getSexCode()
 {
     return this.sexCode;
 }

public  void  setSexCode(String sexCode)
 {
  this.sexCode = sexCode;
 }

public Date getBirthday()
 {
     return this.birthday;
 }

public  void  setBirthday(Date birthday)
 {
  this.birthday = birthday;
 }

public String getIdCardNo()
 {
     return this.idCardNo;
 }

public  void  setIdCardNo(String idCardNo)
 {
  this.idCardNo = idCardNo;
 }

public String getEmail()
 {
     return this.email;
 }

public  void  setEmail(String email)
 {
  this.email = email;
 }

public String getJobTitleCode()
 {
     return this.jobTitleCode;
 }

public  void  setJobTitleCode(String jobTitleCode)
 {
  this.jobTitleCode = jobTitleCode;
 }

public String getPositonCode()
 {
     return this.positonCode;
 }

public  void  setPositonCode(String positonCode)
 {
  this.positonCode = positonCode;
 }

public String getProfessionCode()
 {
     return this.professionCode;
 }

public  void  setProfessionCode(String professionCode)
 {
  this.professionCode = professionCode;
 }

public String getMobileNo()
 {
     return this.mobileNo;
 }

public  void  setMobileNo(String mobileNo)
 {
  this.mobileNo = mobileNo;
 }

public String getTelNo()
 {
     return this.telNo;
 }

public  void  setTelNo(String telNo)
 {
  this.telNo = telNo;
 }

public String getDeptName()
 {
     return this.deptName;
 }

public  void  setDeptName(String deptName)
 {
  this.deptName = deptName;
 }

public String getSexName()
 {
     return this.sexName;
 }

public  void  setSexName(String sexName)
 {
  this.sexName = sexName;
 }

public String getJobTitleName()
 {
     return this.jobTitleName;
 }

public  void  setJobTitleName(String jobTitleName)
 {
  this.jobTitleName = jobTitleName;
 }


public String getBizRoleCode() {

	return bizRoleCode;
}


public void setBizRoleCode(String bizRoleCode) {

	this.bizRoleCode = bizRoleCode;
}


public String getBizRoleName() {

	return bizRoleName;
}


public void setBizRoleName(String bizRoleName) {

	this.bizRoleName = bizRoleName;
}


}