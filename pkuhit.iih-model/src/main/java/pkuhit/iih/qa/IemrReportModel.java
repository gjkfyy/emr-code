package pkuhit.iih.qa;

import org.seasar.doma.Column;

import xap.model.BaseBizModel;
import xap.sv.annotation.DictionaryTag;

/**
 * IEMR——报表
 */
public class IemrReportModel extends BaseBizModel {
	
	 public IemrReportModel(){

	  super();

	 }

	 public IemrReportModel(String reportCd){

	  super(reportCd);

	 }

    /** 主键 */
    @Column(name = "ID")
    private String reportCd;

    /** 名称 */
    @Column(name = "NM")
    private String reportName;

    /** 科室编码 */
    @Column(name = "DEPT_CD")
    private String deptCd;
    
    /** 科室编码 */
    @DictionaryTag(code = "deptCd", objCd = "ORGB01")
    private String deptName;

    /** 报表路径 */
    @Column(name = "URL")
    private String url;

    /** 描述 */
    @Column(name = "DES")
    private String reportDes;

    /** 参数名称, 参数名称  多个参数 用  ; 分开 */
    @Column(name = "PARA_NM")
    private String paraNm;

    /** 参数类型  1 月度， 2 季度， 3 年度，  4 时间段 */
    @Column(name = "PARA_TP")
    private String paraTp;

    /** */
    @Column(name = "MEMO")
    private String memo;

    /** */
    @Column(name = "SORT_NO")
    private String sortNo;

    /** */
    @Column(name = "SPELL_NO")
    private String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    private String wubiNo;

	public String getReportCd() {
		return reportCd;
	}

	public void setReportCd(String reportCd) {
		this.reportCd = reportCd;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReportDes() {
		return reportDes;
	}

	public void setReportDes(String reportDes) {
		this.reportDes = reportDes;
	}

	public String getParaNm() {
		return paraNm;
	}

	public void setParaNm(String paraNm) {
		this.paraNm = paraNm;
	}

	public String getParaTp() {
		return paraTp;
	}

	public void setParaTp(String paraTp) {
		this.paraTp = paraTp;
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

}