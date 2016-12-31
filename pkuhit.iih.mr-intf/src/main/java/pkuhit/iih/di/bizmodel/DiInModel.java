package pkuhit.iih.di.bizmodel;

import java.util.Date;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class DiInModel extends BaseBizModel{
	
	 public DiInModel(){

		  super();

		 }
	 
	 public DiInModel(String code) {

			super(code);

		}
	public static final String   OBJ_CD  = "MRM16";

    /** 主键 */
    @Column(name = "DI_SN")
    private String diSn;

    /** 就诊主键 */
    @Column(name = "EN_SN")
    private String enSn;

    /** 父诊断编码 */
    @Column(name = "PAR_DI_SN")
    private String parDiSn;

    /** 组织机构编码 */
    @Column(name = "ORG_CD")
    private String orgCd;

    /** 级别 */
    @Column(name = "LVL")
    private Short lvl;

    /** */
    @Column(name = "LVL1_SORT_NO")
    private Short lvl1SortNo;

    /** */
    @Column(name = "LVL2_SORT_NO")
    private Short lvl2SortNo;

    /** 诊断类别 */
    @Column(name = "DI_TYPE_CD")
    private String diTypeCd;
    
    /** 诊断类别 */
    @Column(name = "DI_TYPE_NM")
    private String diTypeNm;

    /** 诊断编码 */
    @Column(name = "DI_CD")
    private String diCd;

    /** 诊断名称 */
    @Column(name = "DI_NM")
    private String diNm;

    /** ICD编码 */
    @Column(name = "ICD_CD")
    private String icdCd;

    /** 诊断内容 */
    @Column(name = "ADD_DESCR")
    private String addDescr;

    /** 主诊断标志 */
    @Column(name = "MAIN_F")
    private Short mainF;

    /** 诊断日期 */
    @Column(name = "DI_TIME")
	private Date diTime;

    /** 诊断医生编码 */
    @Column(name = "DI_EMP_ID")
    private String diEmpId;
    
 // 当前主管医生名称
 	@DictionaryTag(code = "diEmpId", objCd = "ORGB04")
 	private String diEmpNm;

    /** 就诊科室编码 */
    @Column(name = "DI_DEPT_CD")
    private String diDeptCd;
    
	@DictionaryTag(code = "diDeptCd", objCd = "ORGB01")
	private String diDeptNm;

    /** */
    @Column(name = "MEMO")
    private String memo;

	public String getDiSn() {
		return diSn;
	}

	public void setDiSn(String diSn) {
		this.diSn = diSn;
	}

	public String getEnSn() {
		return enSn;
	}

	public void setEnSn(String enSn) {
		this.enSn = enSn;
	}

	public String getParDiSn() {
		return parDiSn;
	}

	public void setParDiSn(String parDiSn) {
		this.parDiSn = parDiSn;
	}

	public String getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}

	public Short getLvl() {
		return lvl;
	}

	public void setLvl(Short lvl) {
		this.lvl = lvl;
	}

	public Short getLvl1SortNo() {
		return lvl1SortNo;
	}

	public void setLvl1SortNo(Short lvl1SortNo) {
		this.lvl1SortNo = lvl1SortNo;
	}

	public Short getLvl2SortNo() {
		return lvl2SortNo;
	}

	public void setLvl2SortNo(Short lvl2SortNo) {
		this.lvl2SortNo = lvl2SortNo;
	}

	public String getDiTypeCd() {
		return diTypeCd;
	}

	public void setDiTypeCd(String diTypeCd) {
		this.diTypeCd = diTypeCd;
	}

	public String getDiTypeNm() {
		return diTypeNm;
	}

	public void setDiTypeNm(String diTypeNm) {
		this.diTypeNm = diTypeNm;
	}

	public String getDiCd() {
		return diCd;
	}

	public void setDiCd(String diCd) {
		this.diCd = diCd;
	}

	public String getDiNm() {
		return diNm;
	}

	public void setDiNm(String diNm) {
		this.diNm = diNm;
	}

	public String getIcdCd() {
		return icdCd;
	}

	public void setIcdCd(String icdCd) {
		this.icdCd = icdCd;
	}

	public String getAddDescr() {
		return addDescr;
	}

	public void setAddDescr(String addDescr) {
		this.addDescr = addDescr;
	}

	public Short getMainF() {
		return mainF;
	}

	public void setMainF(Short mainF) {
		this.mainF = mainF;
	}

	

	public Date getDiTime() {
		return diTime;
	}

	public void setDiTime(Date diTime) {
		this.diTime = diTime;
	}

	public String getDiEmpId() {
		return diEmpId;
	}

	public void setDiEmpId(String diEmpId) {
		this.diEmpId = diEmpId;
	}

	public String getDiEmpNm() {
		return diEmpNm;
	}

	public void setDiEmpNm(String diEmpNm) {
		this.diEmpNm = diEmpNm;
	}

	public String getDiDeptCd() {
		return diDeptCd;
	}

	public void setDiDeptCd(String diDeptCd) {
		this.diDeptCd = diDeptCd;
	}

	public String getDiDeptNm() {
		return diDeptNm;
	}

	public void setDiDeptNm(String diDeptNm) {
		this.diDeptNm = diDeptNm;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
    
}
