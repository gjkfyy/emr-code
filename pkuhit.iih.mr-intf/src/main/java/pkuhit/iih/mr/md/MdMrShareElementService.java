package pkuhit.iih.mr.md;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

/**
 * <p>MdMrShareElementService</p>
 * <p>共享元素服务接口</p>
 *
 * @author		李春学(li_chunxue@founder.com)
 * @version		0.0.0
 * <table style="border:1px solid gray;">
 * <tr>
 * <th width="100px">版本号</th><th width="100px">动作</th><th width="100px">修改人</th><th width="100px">修改时间</th>
 * </tr>
 * <!-- 以 Table 方式书写修改历史 -->
 * <tr>
 * <td>0.0.0</td><td>创建类</td><td>李春学</td><td>2015年3月12日 下午2:59:42</td>
 * </tr>
 * <tr>
 * <td>XXX</td><td>XXX</td><td>XXX</td><td>XXX</td>
 * </tr>
 * </table>
 */
public interface MdMrShareElementService {
	
	/**
	 * 共享元素查询服务 
	 * @param macroFlag 宏元素标识，1为宏元素，0非宏元素
	 * @return
	 */
	@RequestMapping(value = "/ws/mr/share/element", method = RequestMethod.GET)
	ArrayResult<MrShareElement>  getMrShareElements(@RequestParam("macroFlag")String macroFlag,@RequestParam("spellNo")String spellNo);
	
	/**
	 * 数据元查询服务 
	 * @param metaElementNm 数据元名字
	 * @return
	 */
	@RequestMapping(value = "/ws/mr/share/meta", method = RequestMethod.GET)
	ArrayResult<MetaElement>  getMetaElements(@RequestParam("metaElementNm")String metaElementNm,@RequestParam("spellNo")String spellNo);
	
	
	/**
	 * 数据元查询服务 
	 * @param metaElementNm 数据元名字
	 * @return
	 */
	@RequestMapping(value = "/ws/mr/share/meta/{dataElementCd}", method = RequestMethod.GET)
	ArrayResult<MetaElementValue>  getMetaElementsValue(@PathVariable("dataElementCd") String dataElementCd);
	
	@RequestMapping(value = "/mr/md/shareElement", method = RequestMethod.GET)
    ArrayResult<MrShareElement>  search(@RequestParam Map<String, String> map);
    
    @RequestMapping(value = "/mr/md/shareElement/{id}", method = RequestMethod.DELETE)
    SingleResult<MrShareElement> delete(@PathVariable("id") String id);
    
    @RequestMapping(value = "/mr/md/shareElement/{id}", method = RequestMethod.GET)
    SingleResult<MrShareElement> selectByCode(@PathVariable("id") String id);
    
    @RequestMapping(value = "/mr/md/shareElement", method = RequestMethod.POST)
    SingleResult<MrShareElement> create(@ModelAttribute MrShareElement mrShareElement);
    
    @RequestMapping(value = "/mr/md/shareElement", method = RequestMethod.PUT)
    SingleResult<MrShareElement> update(@ModelAttribute MrShareElement mrShareElement);
    
    @RequestMapping(value = "/mr/md/shareElementDict/{id}", method = RequestMethod.GET)
    ArrayResult<HyperlinkTemplate> shareElementDict(@PathVariable("id") String id,@RequestParam Map<String, String> map);
}
