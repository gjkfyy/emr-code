package pkuhit.org;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class EmpDept extends BaseRelationModel {
 public EmpDept(){
  super();
 }
 public EmpDept(String code){
  super(code);
 }
// 人员工作部门编码
public static final   String  CODE = "ORGB06.AT01";
// 部门编码
public static final   String  DEPT_CODE = "ORGB06.AT02";
// 人员ID
public static final   String  EMPLOYEE_ID = "ORGB06.AT03";

// 人员工作部门编码
@Column(name="EMP_DEPT_CD") 
private  String code;
/*// 部门编码
@Column(name="DEPT_CD") 
private  String deptCode;*/
// 部门编码
@Column(name="WARD_DEPT_CD") 
private  String wardDeptCode;
// 人员ID
@Column(name="EMP_ID") 
private  String employeeId;
// 部门名称
//@DictionaryTag(code = "deptCode")
@Column(name="NM") 
private  String deptName;
// 人员名称
private  String employeeName;

@Column(name = "SORT_NO")
String sortNo;

public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }

public String getWardDeptCode() {
	return wardDeptCode;
}

public void setWardDeptCode(String wardDeptCode) {
	this.wardDeptCode = wardDeptCode;
}

public String getEmployeeId()
 {
     return this.employeeId;
 }
public  void  setEmployeeId(String employeeId)
 {
  this.employeeId = employeeId;
 }
public String getDeptName()
 {
     return this.deptName;
 }
public  void  setDeptName(String deptName)
 {
  this.deptName = deptName;
 }
public String getEmployeeName()
 {
     return this.employeeName;
 }
public  void  setEmployeeName(String employeeName)
 {
  this.employeeName = employeeName;
 }

public String getSortNo() {
	return sortNo;
}

public void setSortNo(String sortNo) {
	this.sortNo = sortNo;
}

}