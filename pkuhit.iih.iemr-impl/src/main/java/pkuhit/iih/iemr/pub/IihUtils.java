/**
 * <p>文件名:		IihUtils.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.iemr.pub;

import java.util.Date;

/**
 * <p>
 * IihUtils
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
 *          <td>2014年12月15日 上午10:33:03</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class IihUtils {

	/**
	 * 构造器
	 */
	public IihUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 计算日期，系统时间 + days（天数）
	 * 
	 * @param days
	 *            天
	 * @return
	 */
	public static Date dateIncrease(int days) {
		return new Date(System.currentTimeMillis() + days * 24 * 3600 * 1000);
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * 判断字符str是否为null或者“”，是则返回“&nbsp”否则不处理
     * @param str
     * @return
     */
	public static String strNullToNbsp(String str) {
		if(null==str||"".equals(str)){
			str="&nbsp";
		}
		return str;
	}
}
