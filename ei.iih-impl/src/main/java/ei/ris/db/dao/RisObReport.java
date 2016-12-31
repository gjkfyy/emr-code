package ei.ris.db.dao;

import org.seasar.doma.Entity;


@Entity
public class RisObReport {

	private String ObRpPk;

	private String enPk;

	

	public String getObRpPk() {
		return ObRpPk;
	}

	public void setObRpPk(String obRpPk) {
		ObRpPk = obRpPk;
	}

	public String getEnPk() {
		return enPk;
	}

	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}

	/**
	 * 构造器
	 */
	public RisObReport() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
