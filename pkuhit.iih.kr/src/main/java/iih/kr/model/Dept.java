/**
 * 
 */
package iih.kr.model;

/**
 * @author guo_zhongbao
 * 科室
 */
public class Dept {
  private String deptCode; //科室编码
  private String deptName; //科室名称
  private boolean checked;//是否选中
  
public boolean isChecked() {
	return checked;
}
public void setChecked(boolean checked) {
	this.checked = checked;
}
public String getDeptCode() {
	return deptCode;
}
public void setDeptCode(String deptCode) {
	this.deptCode = deptCode;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
  
}
