/**
 * 
 */
package pkuhit.iih.en;

/**
 * @author guo_zhongbao
 * 诊疗组model
 */

public class TreatmentGroupMemberModel {
	private String		enGrpMenPk	;//	诊疗组成员主键
	private String		enPk	;//	就诊主键
	private String		empId	;//	人员ID
	private String		roleCd	;//	角色编码
	private String		patientID;
	private String		enCount;
	
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getEnCount() {
		return enCount;
	}
	public void setEnCount(String enCount) {
		this.enCount = enCount;
	}
	public String getEnGrpMenPk() {
		return enGrpMenPk;
	}
	public void setEnGrpMenPk(String enGrpMenPk) {
		this.enGrpMenPk = enGrpMenPk;
	}
	public String getEnPk() {
		return enPk;
	}
	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getRoleCd() {
		return roleCd;
	}
	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

}
