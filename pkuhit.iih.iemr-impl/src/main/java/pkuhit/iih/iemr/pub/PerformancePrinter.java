/**
 * <p>文件名:		PerformancePrinter.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.iemr.pub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xap.sv.util.ThreadContext;

/**
 * <p>
 * PerformancePrinter
 * </p>
 * <p>
 * 执行时间记录器，使用log或sysp打印输出内容
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
 *          <td>2015年1月7日 上午10:21:30</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class PerformancePrinter {

	public static boolean DEBUG = true;

	public static ThreadLocal<Long> ttl = new ThreadLocal<Long>();
	
	static Logger log = LoggerFactory.getLogger(PerformancePrinter.class);
	/**
	 * 构造器
	 */
	private PerformancePrinter() {

	}

	public static void start(String msg) {
		if (!DEBUG)
			return;
		if (null == msg) {
			log.debug("PerformancePrinter开始：msg为null");
			return;
		}
//		ttl.remove();
		Long time = System.currentTimeMillis();
		ThreadContext.put(msg, time);
//		ttl.set(time);
		log.debug("PerformancePrinter开始：" + msg);
	}

	public static void end(String msg) {
		if (!DEBUG)
			return;
		if (null == msg) {
			log.debug("PerformancePrinter结束：msg为null");
			return;
		}
		long end = System.currentTimeMillis();
		Long time = ThreadContext.get(msg, Long.class);
		ThreadContext.remove(msg);
//		Long time = ttl.get();
//		ttl.remove();
		if (time == null) {
			log.debug("PerformancePrinter：" + msg
					+ "，没有开始时间，请确认调用了start方法");
		} else {
			long consume = end - time;
			log.debug("PerformancePrinter结束：" + msg + "，共使用" + consume
					+ "毫秒");
		}
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PerformancePrinter.start("执行方法1");
		PerformancePrinter.end("执行方法1");

		PerformancePrinter.start("执行方法2");
		PerformancePrinter.end("执行方法2");
		
		PerformancePrinter.start("执行方法3");
		PerformancePrinter.end("执行方法3");
		
		PerformancePrinter.start("执行方法4");
		PerformancePrinter.end("执行方法4");
	}

}
