package szlh.iih.sync.po;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity(listener = MdDiPoListener.class)
@Table(name = "iemr_md_di")
public class MdDiPo {
	@Id
    @Column(name = "MD_ID")
	private int    mdId;
	private String  diCd;//DI_CD
	private String nm ;//NM
	private String icdCd;//icd_cd
	private String spellNo;//SPELL_NO
	private String orgCd;//ORG_CD
	private String  delF;//del_f
	private String  flag;
	public String getDiCd() {
		return diCd;
	}
	public void setDiCd(String diCd) {
		this.diCd = diCd;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getIcdCd() {
		return icdCd;
	}
	public void setIcdCd(String icdCd) {
		this.icdCd = icdCd;
	}
	public String getSpellNo() {
		return spellNo;
	}
	public void setSpellNo(String spellNo) {
		this.spellNo = spellNo;
	}
	public String getOrgCd() {
		return orgCd;
	}
	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
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
	public int getMdId() {
		return mdId;
	}
	public void setMdId(int mdId) {
		this.mdId = mdId;
	}
	
	
	
}
