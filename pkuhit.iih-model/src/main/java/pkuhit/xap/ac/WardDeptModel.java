package pkuhit.xap.ac;


import xap.model.BaseRelationModel;
import xap.sv.annotation.Column;

/**
 * 小科室
 */
public class WardDeptModel extends BaseRelationModel {
	
	 public WardDeptModel(){

	  super();

	 }

	 public WardDeptModel(String code){

	  super(code);

	 }

	 public static final String   OBJ_CD  = "ORGB02";
	 
    /** 科室编码 */
    @Column(name = "DEPT_CD")
    private String deptCd;

    /** 病区编码 */
    @Column(name = "WARD_CD")
    private String wardCd;

    /** 主键 */
    @Column(name = "ORG_CD")
    private String orgCd;

    /** 科室类型编码 */
    @Column(name = "DEPT_TP_CD")
    private String deptTpCd;

    /** 名称 */
    @Column(name = "NM")
    private String nm;
    
    /** ORG_EMP_DEPT主键 */
    @Column(name = "EMP_DEPT_CD")
    private String empDeptCd;
    
    /** 审签等级 */
    @Column(name = "SIGN_LVL_CD")
    private String signLvlCd;
    
    /** 主任医生 */
    @Column(name = "CUR_DRC_DCT_ID")
    private String curDrcDctId;
    
    /** 副主任医生 */
    @Column(name = "CUR_DEPUTY_DRC_DCT_ID")
    private String curDeputyDrcDctId;
    
    @Column(name = "MEMO")
    private String memo;

    @Column(name = "SORT_NO")
    private String sortNo;

    @Column(name = "SPELL_NO")
    private String spellNo;

    @Column(name = "WUBI_NO")
    private String wubiNo;

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

	public String getSortNo() {
		return sortNo;
	}

	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}

	public String getSpellNo() {
		return spellNo;
	}

	public void setSpellNo(String spellNo) {
		this.spellNo = spellNo;
	}

	public String getWubiNo() {
		return wubiNo;
	}

	public void setWubiNo(String wubiNo) {
		this.wubiNo = wubiNo;
	}

	public String getSignLvlCd() {
		return signLvlCd;
	}

	public void setSignLvlCd(String signLvlCd) {
		this.signLvlCd = signLvlCd;
	}

	public String getCurDrcDctId() {
		return curDrcDctId;
	}

	public void setCurDrcDctId(String curDrcDctId) {
		this.curDrcDctId = curDrcDctId;
	}

	public String getCurDeputyDrcDctId() {
		return curDeputyDrcDctId;
	}

	public void setCurDeputyDrcDctId(String curDeputyDrcDctId) {
		this.curDeputyDrcDctId = curDeputyDrcDctId;
	}

	public String getEmpDeptCd() {
		return empDeptCd;
	}

	public void setEmpDeptCd(String empDeptCd) {
		this.empDeptCd = empDeptCd;
	}
	
}