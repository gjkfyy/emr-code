/**
 * <p>文件名:		DemoModel.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.iemr.demo;

import java.util.Date;
import java.util.List;

import pkuhit.iih.mr.wr.MedicalRecord;


/**
 * <p>
 * DemoModel
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
 *          <td>2014年11月29日 下午2:04:16</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class DemoModel {
	
	private String str;
	
	private Date date;
	
	private int intv;
	
	private MedicalRecord[] demos;
	private List<MedicalRecord> demos2;
	public List<MedicalRecord> getDemos2() {
		return demos2;
	}

	public void setDemos2(List<MedicalRecord> demos2) {
		this.demos2 = demos2;
	}

	public MedicalRecord[] getDemos() {
		return demos;
	}

	public void setDemos(MedicalRecord[] demos) {
		this.demos = demos;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIntv() {
		return intv;
	}

	public void setIntv(int intv) {
		this.intv = intv;
	}

	/**
	 * 构造器
	 */
	public DemoModel() {
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
