
package ei.lis.db.dao.po;

import org.seasar.doma.Entity;

/**
 * 检验项目列表
 */
@Entity
public class LabReportItemPo {
	private String	 	mrLabRpItmPk	;//	检验报告项目主键
	private String	 	labRpPk	;//	检验报告主键
	private String	 	labItmCd	;//	检验项目编码
	private String	 	labItmNm	;//	检验项目名称
	private String	 	labItmVal	;//	检验项目值
	private String	 	maxNrmlVal	;//	最大正常值
	private String	 	minNrmlVal	;//	最小正常值
	private String	 	labItmUnitCd	;//	检验项目单位编码
	private String	 	labItmUnitNm	;//	检验项目单位名称
	private String	 	referRange	;//	参考范围
	private String	 	labItmCompare;
	
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
	}
	public String getMinNrmlVal() {
		return minNrmlVal;
	}
	public void setMinNrmlVal(String minNrmlVal) {
		this.minNrmlVal = minNrmlVal;
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
	public String getReferRange() {
		return referRange;
	}
	public void setReferRange(String referRange) {
		this.referRange = referRange;
	}
	public String getLabItmCompare() {
		return labItmCompare;
	}
	public void setLabItmCompare(String labItmCompare) {
		this.labItmCompare = labItmCompare;
	}
	
}
