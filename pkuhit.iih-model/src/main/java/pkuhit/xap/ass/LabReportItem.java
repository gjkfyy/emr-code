/**
 * 
 */
package pkuhit.xap.ass;

import xap.sv.annotation.Column;

/**
 * @author guo_zhongbao
 * 检验项目列表
 */
public class LabReportItem {
	
	
	@Column(name = "MR_LAB_RP_ITM_PK")
	private String	 mrLabRpItmPk	;//	检验报告项目主键
	
	@Column(name = "LAB_RP_PK")
	private String	 labRpPk	;//	检验报告主键
	
	@Column(name = "LAB_ITM_CD")
	private String	 labItmCd	;//	检验项目编码
	
	@Column(name = "LAB_ITM_NM")
	private String	 labItmNm	;//	检验项目名称
	
	@Column(name = "LAB_ITM_VAL")
	private String	 labItmVal	;//	检验项目值
	
	@Column(name = "MAX_NRML_VAL")
	private String	 maxNrmlVal	;//	最大正常值
	
	@Column(name = "MIN_NRML_VAL")
	private String	 minNrmlVal	;//	最小正常值
	
	@Column(name = "LAB_ITM_UNIT_CD")
	private String	 labItmUnitCd	;//	检验项目单位编码
	
	@Column(name = "LAB_ITM_UNIT_NM")
	private String	 labItmUnitNm	;//	检验项目单位名称
	
	@Column(name = "REFERENCE_RANGE")
	private String   referRange ;//参考范围
	
	@Column(name = "LAB_ITM_COMPARE")
	private String   labItmCompare ;
	
	@Column(name = "MEMO")
	private String   memo ;//wangyanli add 页面有相应显示字段
	
	public String getReferRange() {
		return referRange;
	}
	public void setReferRange(String referRange) {
		this.referRange = referRange;
	}
	public String getMrLabRpItmPk() {
		return mrLabRpItmPk;
	}
	public void setMrLabRpItmPk(String mrLabRpItmPk) {
		this.mrLabRpItmPk = mrLabRpItmPk;
	}
	public String getLabRpPk() {
		return labRpPk;
	}
	public void setLabRpPk(String labRpPk) {
		this.labRpPk = labRpPk;
	}
	public String getLabItmCd() {
		return labItmCd;
	}
	public void setLabItmCd(String labItmCd) {
		this.labItmCd = labItmCd;
	}
	public String getLabItmNm() {
		return labItmNm;
	}
	public void setLabItmNm(String labItmNm) {
		this.labItmNm = labItmNm;
	}
	public String getLabItmVal() {
		return labItmVal;
	}
	public void setLabItmVal(String labItmVal) {
		this.labItmVal = labItmVal;
	}
	public String getMaxNrmlVal() {
		return maxNrmlVal;
	}
	public void setMaxNrmlVal(String maxNrmlVal) {
		this.maxNrmlVal = maxNrmlVal;
		this.setReferRange(this.getMinNrmlVal()+maxNrmlVal);
	}
	public String getMinNrmlVal() {
		return minNrmlVal;
	}
	public void setMinNrmlVal(String minNrmlVal) {
		this.minNrmlVal = minNrmlVal;
		this.setReferRange(minNrmlVal+this.getMaxNrmlVal());
	}
	public String getLabItmUnitCd() {
		return labItmUnitCd;
	}
	public void setLabItmUnitCd(String labItmUnitCd) {
		this.labItmUnitCd = labItmUnitCd;
	}
	public String getLabItmUnitNm() {
		return labItmUnitNm;
	}
	public void setLabItmUnitNm(String labItmUnitNm) {
		this.labItmUnitNm = labItmUnitNm;
	}
	public String getLabItmCompare() {
		return labItmCompare;
	}
	public void setLabItmCompare(String labItmCompare) {
		this.labItmCompare = labItmCompare;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
