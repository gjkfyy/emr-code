/**
 * <p>文件名:		TestService.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.demo;

import java.lang.reflect.InvocationTargetException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * <p>
 * TestService
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
 *          <td>2014年11月20日 上午11:46:01</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public interface TestService {

	/**
	 * http://127.0.0.1:8081/dbget?xmode=debug
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "dbget", method = RequestMethod.GET)
	TestModel dbget(@RequestParam("cd") String cd) throws IllegalAccessException,
			InvocationTargetException;
	/**
	 * http://127.0.0.1:8081/dbadd?xmode=debug
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws TestException 
	 */
	@RequestMapping(value = "dbadd", method = RequestMethod.GET)
	String dbadd(@RequestParam String cd) throws IllegalAccessException,
	InvocationTargetException, TestException;
}
