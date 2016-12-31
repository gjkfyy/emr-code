/**
 * 
 */
package pkuhit.iih.di;

/**
 * @author guo_zhongbao
 * 诊断字典
 */
public class MasterDataDiagnosisModel {
	private  String 	diCd	;//	诊断编码
	private  String 	orgCd	;//	组织机构编码
	private  String 	nm	;//	名称
	private  String 	des	;//	描述
	private  String 	icdCd	;//	ICD编码
	private  Integer 	infF	;//	传染病标志
	private  Integer 	symF	;//	症状标志
	public String getDiCd() {
		return diCd;
	}
	public void setDiCd(String diCd) {
		this.diCd = diCd;
	}
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getIcdCd() {
		return icdCd;
	}
	public void setIcdCd(String icdCd) {
		this.icdCd = icdCd;
	}
	public Integer getInfF() {
		return infF;
	}
	public void setInfF(Integer infF) {
		this.infF = infF;
	}
	public Integer getSymF() {
		return symF;
	}
	public void setSymF(Integer symF) {
		this.symF = symF;
	}

}
