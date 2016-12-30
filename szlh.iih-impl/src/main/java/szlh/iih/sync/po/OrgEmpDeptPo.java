package szlh.iih.sync.po;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(listener = OrgEmpDeptPoListener.class)
@Table(name = "iemr_org_emp_dept")
public class OrgEmpDeptPo {
	@Id
    @Column(name = "ORG_EMP_DEPT_ID")
	  private int  orgEmpDeptId;//ORG_EMPDEPT_ID ;
	  private String empDeptCd;//  EMP_DEPT_CD 
	  private String wardDeptCd;// WARD_DEPT_CD 
	  private String empId;// EMP_ID 
	  private String SignLvlCd;// SIGN_LVL_CD 
	  private String CurDrcDctId;// CUR_DRC_DCT_ID 
	  private String curDeputyDrcDctId;// CUR_DEPUTY_DRC_DCT_ID 
	  private String delF;// DEL_F 
	  private String flag;//	   Flag 
	public int getOrgEmpDeptId() {
		return orgEmpDeptId;
	}
	public void setOrgEmpDeptId(int orgEmpDeptId) {
		this.orgEmpDeptId = orgEmpDeptId;
	}
	public String getEmpDeptCd() {
		return empDeptCd;
	}
	public void setEmpDeptCd(String empDeptCd) {
		this.empDeptCd = empDeptCd;
	}
	public String getWardDeptCd() {
		return wardDeptCd;
	}
	public void setWardDeptCd(String wardDeptCd) {
		this.wardDeptCd = wardDeptCd;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getSignLvlCd() {
		return SignLvlCd;
	}
	public void setSignLvlCd(String signLvlCd) {
		SignLvlCd = signLvlCd;
	}
	public String getCurDrcDctId() {
		return CurDrcDctId;
	}
	public void setCurDrcDctId(String curDrcDctId) {
		CurDrcDctId = curDrcDctId;
	}
	public String getCurDeputyDrcDctId() {
		return curDeputyDrcDctId;
	}
	public void setCurDeputyDrcDctId(String curDeputyDrcDctId) {
		this.curDeputyDrcDctId = curDeputyDrcDctId;
	}
	public String getDelF() {
		return delF;
	}
	public void setDelF(String delF) {
		this.delF = delF;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
 
	  
}
