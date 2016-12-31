/**
 * <p>文件名:		DemoService.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.iemr.demo;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.XapRequestBody;

/**
 * <p>
 * DemoService
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
 *          <td>2014年11月29日 下午2:03:42</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public interface DemoService {

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	List<DemoModel> getDemo(@RequestParam Map demo);

	@RequestMapping(value = "/demo/{id}", method = RequestMethod.GET)
	List<DemoModel> getDemoList(@PathVariable("id") String id);

	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	public void addDemo(@ModelAttribute DemoModel model);

	@RequestMapping(value = "/demo", method = RequestMethod.PUT)
	public void updateDemo(@XapRequestBody DemoModel model);

	@RequestMapping(value = "/demo/{id}", method = RequestMethod.DELETE)
	public void removeDemo(@PathVariable("id") String id);

}
