package pkuhit.iih.mr.tpl;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface BaseTemplateService {
	/**
	 *  【医疗记录模板】名称是否存在
	 * @param name //病历模板名称
	 * @return true已经存在   false不存在
	 */
	@RequestMapping(value = "/mr/tpl/baseTemplate/HasDuplicationOfName", method = RequestMethod.GET)
	SingleResult<Boolean> HasDuplicationOfName(@RequestParam("code") String code,@RequestParam("name") String name);
	
	/**
	 *  【基础模板】新建服务（单记录）
	 * @param MrBaseTemplate value
	 * @return MrBaseTemplate
	 * @
	 */
	@RequestMapping(value = "/mr/tpl/baseTemplate", method = RequestMethod.POST)
	SingleResult<MrBaseTemplate> create(@ModelAttribute BaseTemplateInputModel io) ;

	
	/**
	 *  【基础模板】更新服务（单记录）
	 * @param MrBaseTemplate value
	 * @return MrBaseTemplate
	 * @
	 */
	@RequestMapping(value = "/mr/tpl/baseTemplate/{id}", method = RequestMethod.PUT)
	SingleResult<MrBaseTemplate> update(@PathVariable("id") String id ,@ModelAttribute BaseTemplateInputModel io) ;
	
	/**
	 *  【基础模板】查询服务（单记录）
	 * @param String id
	 * @return MrBaseTemplate
	 */
	@RequestMapping(value = "/mr/tpl/baseTemplate/{id}", method = RequestMethod.GET)
	SingleResult<MrBaseTemplate> searchById(@PathVariable("id")  String id) ;
	
	/**
	 *  【基础模板】查询服务（多记录）
	 * @param excludeDelete 当输入0或false时，包含删除。否则，不包含删除
	 * @param statusCode 多个状态码，以 , 分隔
	 * @param pageNum 当前页数    从1开始。默认值为1，
	 * @param pageSize 每页记录数   默认值25
	 * @return List<MrBaseTemplate>
	 */
	@RequestMapping(value = "/mr/tpl/baseTemplate", method = RequestMethod.GET)
	ArrayResult<MrBaseTemplate> search(@RequestParam Map condition) ;
	

	/**
	 * 【基础模板】删除服务（单记录）
	 * @param id
	 * @return MrBaseTemplate
	 */
	@RequestMapping(value = "/mr/tpl/baseTemplate", method = RequestMethod.DELETE)
	SingleResult<BatchOperationResult> delete(@ModelAttribute ArrayInputModel ids) ;
	/**
	 * 【基础模板】启用服务（单记录）
	 * @param id
	 * @return MrBaseTemplate
	 */
	@RequestMapping(value = "/mr/tpl/activated/baseTemplate", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> activate(@ModelAttribute ArrayInputModel ids) ;

	/**
	 * 【基础模板】停用服务（单记录）
	 * @param id
	 * @return MrBaseTemplate
	 */
	@RequestMapping(value = "/mr/tpl/stopped/baseTemplate", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> stop(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【基础模板】导航树
	 * @return 导航树
	 */
	@RequestMapping(value = "/mr/tpl/tree/baseTemplate", method = RequestMethod.GET)
	SingleResult<Map> tree(@RequestParam("keyword") String keyWord) ;
}
