package pkuhit.org;
import xap.sv.annotation.Column;
import xap.model.BaseRelationModel;
public class WorkGroupEmp extends BaseRelationModel {
 public WorkGroupEmp(){
  super();
 }
 public WorkGroupEmp(String code){
  super(code);
 }
// 工作组成员编码
public static final   String  CODE = "ORGB05.AT01";
// 人员ID
public static final   String  EMPLOYEE_ID = "ORGB05.AT02";
// 工作组编码
public static final   String  WORK_GROUP_CODE = "ORGB05.AT03";
// 业务角色编码
public static final   String  BIZ_ROLE_CODE = "ORGB05.AT04";

// 工作组成员编码
@Column(name="WG_EMP_CD") 
private  String code;
// 人员ID
@Column(name="EMP_ID") 
private  String employeeId;
// 工作组编码
@Column(name="WG_CD") 
private  String workGroupCode;
// 业务角色编码
@Column(name="BIZ_ROLE_CD") 
private  String bizRoleCode;

// 业务审签等级编码
private String signLvlCd;

// 人员名称
private  String employeeName;
// 工作组名称
private  String workGroupName;
// 业务角色名称
private  String bizRoleName;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getEmployeeId()
 {
     return this.employeeId;
 }
public  void  setEmployeeId(String employeeId)
 {
  this.employeeId = employeeId;
 }
public String getWorkGroupCode()
 {
     return this.workGroupCode;
 }
public  void  setWorkGroupCode(String workGroupCode)
 {
  this.workGroupCode = workGroupCode;
 }
public String getBizRoleCode()
 {
     return this.bizRoleCode;
 }
public  void  setBizRoleCode(String bizRoleCode)
 {
  this.bizRoleCode = bizRoleCode;
 }
public String getEmployeeName()
 {
     return this.employeeName;
 }
public  void  setEmployeeName(String employeeName)
 {
  this.employeeName = employeeName;
 }
public String getWorkGroupName()
 {
     return this.workGroupName;
 }
public  void  setWorkGroupName(String workGroupName)
 {
  this.workGroupName = workGroupName;
 }
public String getBizRoleName()
 {
     return this.bizRoleName;
 }
public  void  setBizRoleName(String bizRoleName)
 {
  this.bizRoleName = bizRoleName;
 }

/**
 * @return the signLvlCd
 */
public String getSignLvlCd() {
	return signLvlCd;
}

/**
 * @param signLvlCd the signLvlCd to set
 */
public void setSignLvlCd(String signLvlCd) {
	this.signLvlCd = signLvlCd;
}
}