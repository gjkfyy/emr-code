package szlh.iih.sync.po;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(listener = OrgPoListener.class)
@Table(name = "iemr_org")
public class OrgPo {
	@Id
    @Column(name = "ORG_ID")
	private int orgId;
	private String orgCd;//主键	ORG_CD
	private String orgTpCd;//科室类型	ORG_TP_CD
	private String nm;//名称	NM
	private String des;//描述	DES
	private String shtNm;//简写	SHT_NM
	private String aliasNm;//别名	ALIAS_NM
	private String distCd;//区县编码	DIST_CD
	private String subdistNm;//乡镇街道名称	SUBDIST_NM
	private String zipNo;//邮政编码	ZIP_NO
	private String telNo;//联系电话	TEL_NO
	private String delF;//删除标记
	private String spellNo;//拼音码 spellNo
	private String flag;   //I 插入，U 更新，D 删除
	
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}
	public String getOrgTpCd() {
		return orgTpCd;
	}
	public void setOrgTpCd(String orgTpCd) {
		this.orgTpCd = orgTpCd;
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
	public String getShtNm() {
		return shtNm;
	}
	public void setShtNm(String shtNm) {
		this.shtNm = shtNm;
	}
	public String getAliasNm() {
		return aliasNm;
	}
	public void setAliasNm(String aliasNm) {
		this.aliasNm = aliasNm;
	}
	public String getDistCd() {
		return distCd;
	}
	public void setDistCd(String distCd) {
		this.distCd = distCd;
	}
	public String getSubdistNm() {
		return subdistNm;
	}
	public void setSubdistNm(String subdistNm) {
		this.subdistNm = subdistNm;
	}
	public String getZipNo() {
		return zipNo;
	}
	public void setZipNo(String zipNo) {
		this.zipNo = zipNo;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
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
	public String getSpellNo() {
		return spellNo;
	}
	public void setSpellNo(String spellNo) {
		this.spellNo = spellNo;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	
	
	

}
