package szlh.iih.sync.po;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(listener = WardDeptPoListener.class)
@Table(name = "iemr_ward_dept")
public class WardDeptPo {
	@Id
    @Column(name = "WARD_ID")
	private int wardId;//WARD_ID
	private String deptCd;//  DEPT_CD  ,
	private String wardCd;//  WARD_CD ,
	private String orgCd;//  ORG_CD 
	private String deptTpCd;//  DEPT_TP_CD 
	private String nm;//  NM 
	private String memo;//  MEMO 
	private String  spellNo;//SPELL_NO 
    private String delF;
	private String  flag;// FLAG 
	public int getWardId() {
		return wardId;
	}
	public void setWardId(int wardId) {
		this.wardId = wardId;
	}
	public String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	public String getWardCd() {
		return wardCd;
	}
	public void setWardCd(String wardCd) {
		this.wardCd = wardCd;
	}
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	public String getDeptTpCd() {
		return deptTpCd;
	}
	public void setDeptTpCd(String deptTpCd) {
		this.deptTpCd = deptTpCd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getSpellNo() {
		return spellNo;
	}
	public void setSpellNo(String spellNo) {
		this.spellNo = spellNo;
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
