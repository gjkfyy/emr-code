package pkuhit.xap.ac;
import java.util.List;

import pkuhit.iih.qa.IemrReportModel;

import xap.sv.annotation.Column;
import xap.model.BaseRelationModel;
public class ReportRole extends BaseRelationModel {
 public ReportRole(){
  super();
 }
 public ReportRole(String code){
  super(code);
 }
 
 /** 主键 */
 @Column(name = "IEMR_REPORT_ROLE_ID")
 private String iemrReportRoleId;

 /** 报表编码 */
 @Column(name = "IEMR_REPORT_ID")
 private String iemrReportId;

 /** 角色编码 */
 @Column(name = "ROLE_CD")
 private String roleCd;

 /** 描述 */
 @Column(name = "MEMO")
 private String memo;
 
 private List<IemrReportModel> roleReportList;

public String getIemrReportRoleId() {
	return iemrReportRoleId;
}

public void setIemrReportRoleId(String iemrReportRoleId) {
	this.iemrReportRoleId = iemrReportRoleId;
}

public String getIemrReportId() {
	return iemrReportId;
}

public void setIemrReportId(String iemrReportId) {
	this.iemrReportId = iemrReportId;
}

public String getRoleCd() {
	return roleCd;
}

public void setRoleCd(String roleCd) {
	this.roleCd = roleCd;
}

public String getMemo() {
	return memo;
}

public void setMemo(String memo) {
	this.memo = memo;
}

public List<IemrReportModel> getRoleReportList() {
	return roleReportList;
}

public void setRoleReportList(List<IemrReportModel> roleReportList) {
	this.roleReportList = roleReportList;
}

}