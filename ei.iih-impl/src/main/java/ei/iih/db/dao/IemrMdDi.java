/**
 * <p>文件名:		HisDiagnosis.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package ei.iih.db.dao;

import org.seasar.doma.Entity;


@Entity
public class IemrMdDi {

	private String diCd;

	

	/**
	 * 构造器
	 */
	public IemrMdDi() {
		// TODO Auto-generated constructor stub
	}

	public String getDiCd() {
		return diCd;
	}

	public void setDiCd(String diCd) {
		this.diCd = diCd;
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
