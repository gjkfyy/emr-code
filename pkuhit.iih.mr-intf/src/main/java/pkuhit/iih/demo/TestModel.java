/**
 * <p>文件名:		TestModel.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.demo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * <p>
 * TestModel
 * </p>
 * <p>
 * TODO
 * </p>
 * 
 * @author 李德强(li_deqiang@founder.com, readwall@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李德强</td>
 *          <td>2014年11月21日 下午3:14:34</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class TestModel {
	
	String pk;

	/** */
	String fdStr;

	/** */
	Timestamp fdDate;

	/** */
	Short fdInt;

	/** */
	BigInteger fdFloat;
	
	

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getFdStr() {
		return fdStr;
	}

	public void setFdStr(String fdStr) {
		this.fdStr = fdStr;
	}

	public Timestamp getFdDate() {
		return fdDate;
	}

	public void setFdDate(Timestamp fdDate) {
		this.fdDate = fdDate;
	}

	public Short getFdInt() {
		return fdInt;
	}

	public void setFdInt(Short fdInt) {
		this.fdInt = fdInt;
	}

	public BigInteger getFdFloat() {
		return fdFloat;
	}

	public void setFdFloat(BigInteger fdFloat) {
		this.fdFloat = fdFloat;
	}

	/**
	 * 构造器
	 */
	public TestModel() {
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
