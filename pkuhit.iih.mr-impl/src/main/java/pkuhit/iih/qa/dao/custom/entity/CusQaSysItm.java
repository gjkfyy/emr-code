package pkuhit.iih.qa.dao.custom.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import pkuhit.iih.qa.dao.auto.entity.QaSysItm;

@Entity(listener = CusQaSysItmListener.class)
public class CusQaSysItm extends QaSysItm {

	@Column(name = "MR_SEG_TP_CD")
	String mrSegTpCd;

	public String getMrSegTpCd() {
		return mrSegTpCd;
	}

	public void setMrSegTpCd(String mrSegTpCd) {
		this.mrSegTpCd = mrSegTpCd;
	}

	public CusQaSysItm() {
		// TODO Auto-generated constructor stub
	}

}
