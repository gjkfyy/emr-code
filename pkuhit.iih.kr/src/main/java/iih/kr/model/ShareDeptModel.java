package iih.kr.model;

public class ShareDeptModel {
	private String deptCodeSrc;//共享源code
	private String deptNameSrc;//共享源name
	private Dept[] deptDstArr;//共享目标

	public String getDeptCodeSrc() {
		return deptCodeSrc;
	}
	public void setDeptCodeSrc(String deptCodeSrc) {
		this.deptCodeSrc = deptCodeSrc;
	}
	public Dept[] getDeptDstArr() {
		return deptDstArr;
	}
	public void setDeptDstArr(Dept[] deptDstArr) {
		this.deptDstArr = deptDstArr;
	}
	public String getDeptNameSrc() {
		return deptNameSrc;
	}
	public void setDeptNameSrc(String deptNameSrc) {
		this.deptNameSrc = deptNameSrc;
	}
	

}
