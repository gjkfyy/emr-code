package pkuhit.xap.ac;
import java.util.List;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class User extends BaseMasterModel {
 public User(){
  super();
 }
 public User(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "ORGB04";// 姓名
public static final   String  NAME = "XAPM12.AT08";
// 姓名拼音
public static final   String  NAME_SPELL = "XAPM12.AT09";
// 性别编码
public static final   String  SEX_CODE = "XAPM12.AT10";
// 电子邮箱
public static final   String  EMAIL = "XAPM12.AT11";
// 职称编码
public static final   String  JOB_TITLE_CODE = "XAPM12.AT12";
// 移动电话
public static final   String  MOBILE_NO = "XAPM12.AT13";
// 固定电话
public static final   String  TEL_NO = "XAPM12.AT14";
// 组织机构编码
public static final   String  ORGANIZATION_CODE = "XAPM12.AT15";
// 用户ID
public static final   String  ID = "XAPM12.AT01";
// 人员ID
public static final   String  EMPLOYEE_ID = "XAPM12.AT02";
// 用户状态编码
public static final   String  STATUS_CODE = "XAPM12.AT03";
// 密码
public static final   String  PASSWORD = "XAPM12.AT04";
// 签名图片
public static final   String  SIGN_PICTURE = "XAPM12.AT05";

// 用户状态名称
@DictionaryTag(code = "statusCode", objCd ="XAPM01")
private  String statusName;
// 姓名
@Column(name="NM") 
private  String name;
// 姓名拼音
@Column(name="NM_SPELL") 
private  String nameSpell;
// 性别编码
@Column(name="SEX_CD") 
private  String sexCode;
// 电子邮箱
@Column(name="EMAIL") 
private  String email;
// 职称编码
@Column(name="JOB_TITLE_CD") 
private  String jobTitleCode;
// 移动电话
@Column(name="MOBILE_NO") 
private  String mobileNo;
// 固定电话
@Column(name="TEL_NO") 
private  String telNo;
// 组织机构编码
@Column(name="ORG_CD") 
private  String organizationCode;

// 性别名称
@DictionaryTag(code = "sexCode",  objCd = "MDM05")
private  String sexName;

// 职称名称
@DictionaryTag(code = "jobTitleCode")
private  String jobTitleName;

// 组织机构名称
@DictionaryTag(code = "organizationCode" ,objCd="ORGB01")
private  String organizationName;
// 用户ID
@Column(name="USER_ID") 
private  String id;
// 人员ID
@Column(name="EMP_ID") 
private  String employeeId;
// 用户状态编码
@Column(name="USER_STA_CD") 
private  String statusCode;

//审签等级编码
@Column(name="SIGN_LVL_CD") 
private  String signLevelCode;

//审签等级名称
@DictionaryTag(code = "signLevelCode", objCd ="MRM02")
private  String signLevelName;
// 密码
@Column(name="PWD") 
private  String password;

//密码
@Column(name="IEMR_PWD") 
private  String iemrPassword;
// 签名图片
@Column(name="SIGN_PIC") 
private  String signPicture;
// 人员名称
private  String employeeName;
//是否使用CA  1：使用，0：不使用
private  String useCa;
//是否使用图片签名1：使用，0：不使用
private  String usePicSign;

//cis中是否使用ca
private  String isUseCa;

/**
 * 用户具有角色的业务科室名称，如果有多个通过','分割。
 */
private String serviceDepartName;

@Column(name = "LOGIN_NM")
private String loginName;

@Column(name = "XAP_USER_PK")
private String xapUserPk;

private  List<WardDeptModel> wardDeptList;
private List<UserRole> userRoleList;

@Column(name = "DCT_NS_F")
private Short dctNsF;
public String getStatusName()
 {
     return this.statusName;
 }
public String getIsUseCa() {
	return isUseCa;
}

public void setIsUseCa(String isUseCa) {
	this.isUseCa = isUseCa;
}

public String getUsePicSign() {
	return usePicSign;
}

public void setUsePicSign(String usePicSign) {
	this.usePicSign = usePicSign;
}

public  void  setStatusName(String statusName)
 {
  this.statusName = statusName;
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
public String getOrganizationCode()
 {
     return this.organizationCode;
 }
public  void  setOrganizationCode(String organizationCode)
 {
  this.organizationCode = organizationCode;
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
public String getOrganizationName()
 {
     return this.organizationName;
 }
public  void  setOrganizationName(String organizationName)
 {
  this.organizationName = organizationName;
 }
public String getId()
 {
     return this.id;
 }
public  void  setId(String id)
 {
  this.id = id;
 }
public String getEmployeeId()
 {
     return this.employeeId;
 }
public  void  setEmployeeId(String employeeId)
 {
  this.employeeId = employeeId;
 }
public String getStatusCode()
 {
     return this.statusCode;
 }
public  void  setStatusCode(String statusCode)
 {
  this.statusCode = statusCode;
 }
public String getPassword()
 {
     return this.password;
 }
public  void  setPassword(String password)
 {
  this.password = password;
 }
public String getSignPicture() {
	return signPicture;
}

public void setSignPicture(String signPicture) {
	this.signPicture = signPicture;
}

public String getEmployeeName()
 {
     return this.employeeName;
 }
public  void  setEmployeeName(String employeeName)
 {
  this.employeeName = employeeName;
 }

/**
 * @return the userRoleList
 */
public List<UserRole> getUserRoleList() {
	return userRoleList;
}

/**
 * @param userRoleList the userRoleList to set
 */
public void setUserRoleList(List<UserRole> userRoleList) {
	this.userRoleList = userRoleList;
}

/**
 * @return the serviceDepartName
 */
public String getServiceDepartName() {
	return serviceDepartName;
}

/**
 * @param serviceDepartName the serviceDepartName to set
 */
public void setServiceDepartName(String serviceDepartName) {
	this.serviceDepartName = serviceDepartName;
}


public String getSignLevelCode() {

	return signLevelCode;
}


public void setSignLevelCode(String signLevelCode) {

	this.signLevelCode = signLevelCode;
}


public String getSignLevelName() {

	return signLevelName;
}


public void setSignLevelName(String signLevelName) {

	this.signLevelName = signLevelName;
}

public String getLoginName() {
	return loginName;
}

public void setLoginName(String loginName) {
	this.loginName = loginName;
}

public String getXapUserPk() {
	return xapUserPk;
}

public void setXapUserPk(String xapUserPk) {
	this.xapUserPk = xapUserPk;
}

public List<WardDeptModel> getWardDeptList() {
	return wardDeptList;
}

public void setWardDeptList(List<WardDeptModel> wardDeptList) {
	this.wardDeptList = wardDeptList;
}


public String getUseCa() {

	return useCa;
}


public void setUseCa(String useCa) {

	this.useCa = useCa;
}

public String getIemrPassword()
{
    return iemrPassword;
}

public void setIemrPassword(String iemrPassword)
{
    this.iemrPassword = iemrPassword;
}

public Short getDctNsF()
{
    return dctNsF;
}

public void setDctNsF(Short dctNsF)
{
    this.dctNsF = dctNsF;
}

}