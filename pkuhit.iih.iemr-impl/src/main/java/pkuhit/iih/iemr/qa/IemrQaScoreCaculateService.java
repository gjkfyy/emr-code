/**
 * <p>文件名:		MrQaScoreCaculateService.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.iemr.qa;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * 
 * <p>
 * IemrQaScoreCaculateService
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
 *          <td>2014年12月23日 下午5:19:59</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public interface IemrQaScoreCaculateService {

	@RequestMapping(value = "/scored/amr", method = RequestMethod.GET)
	SingleResult<Map> score(@RequestParam("enPk") String enPk) throws Exception;

}
