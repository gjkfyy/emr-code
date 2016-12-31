/**
 * <p>文件名:		AnnotationCache.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.xap.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.seasar.doma.Column;

/**
 * <p>
 * AnnotationCache
 * </p>
 * <p>
 * beancopyutils的注解内存缓存类
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
 *          <td>2015年1月7日 下午3:40:58</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class AnnotationCache {

	public static boolean OPEN = true;

	private static Map<String, Column> domaAnnotMap = new ConcurrentHashMap<String, Column>();

	private static Map<String, xap.sv.annotation.Column> modelAnnotMap = new ConcurrentHashMap<String, xap.sv.annotation.Column>();

	/**
	 * 构造器
	 */
	public AnnotationCache() {
		// TODO Auto-generated constructor stub
	}

	public static void putDoma(String key, Column value) {
		if (!OPEN)
			return;
		domaAnnotMap.put(key, value);
		return;
	}

	public static Column getDoma(String key) {
		if (!OPEN)
			return null;
		return domaAnnotMap.get(key);
	}

	public static void putXap(String key, xap.sv.annotation.Column value) {
		if (!OPEN)
			return;
		modelAnnotMap.put(key, value);
		return;
	}

	public static xap.sv.annotation.Column getXap(String key) {
		if (!OPEN)
			return null;
		return modelAnnotMap.get(key);
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
