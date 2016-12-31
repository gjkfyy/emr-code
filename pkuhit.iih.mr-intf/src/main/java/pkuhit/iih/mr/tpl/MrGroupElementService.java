package pkuhit.iih.mr.tpl;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface MrGroupElementService {
	/**
	 *  【组合元素】新建服务（单记录）
	 * @param MrGroupElement value
	 * @return 单条组合元素
	 */
	@RequestMapping(value = "/mr/tpl/groupElement", method = RequestMethod.POST)
	SingleResult<MrGroupElement> create(@ModelAttribute MrGroupElement mrGroupElement) ;

	
	/**
	 *  【组合元素】更新服务（单记录）
	 * @param MrGroupElement value
	 * @return 单条组合元素
	 */
	@RequestMapping(value = "/mr/tpl/groupElement/{id}", method = RequestMethod.PUT)
	SingleResult<MrGroupElement> update(@PathVariable("id") String id ,@ModelAttribute MrGroupElement mrGroupElement) ;
	
	/**
	 *  【组合元素】查询服务（单记录）
	 * @param String id
	 * @return 单条组合元素
	 */
	@RequestMapping(value = "/mr/tpl/groupElement/{id}", method = RequestMethod.GET)
	SingleResult<MrGroupElement> searchById(@PathVariable("id")  String id) ;
	
	/**
	 * 【组合元素】查询服务（多记录）
	 * @param typeCode 医疗记录组合元素类型编码
	 * @param keyword 搜索关键字
	 * @param ownerTypeCode 所属类型编码
	 * @param ownerCode 所属编码 
	 * @param customCategoryCode 医疗记录组合元素的自定义分类编码
	 * @param statusCode 组合元素状态编码
	 * @param pageNum 当前页数    从1开始。默认值为1，
	 * @param pageSize 每页记录数   默认值25
	 * @return List<MrGroupElement>
	 */
	@RequestMapping(value = "/mr/tpl/groupElement", method = RequestMethod.GET)
	ArrayResult<MrGroupElement> search(@RequestParam Map<String, String> condition) ;	

	
	/**
	 *  【组合元素】删除服务（单记录）
	 * @param String id
	 * @return 单条组合元素
	 */
	@RequestMapping(value = "/mr/tpl/groupElement/{id}", method = RequestMethod.DELETE)
	SingleResult<MrGroupElement> delete(@PathVariable("id")  String id) ;
	
	/**
	 * 【组合元素】删除服务（单记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	@RequestMapping(value = "/mr/tpl/groupElement", method = RequestMethod.DELETE)
	SingleResult<BatchOperationResult> delete(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【组合元素】提交服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	@RequestMapping(value = "/mr/tpl/submitted/groupElement", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> submit(@ModelAttribute ArrayInputModel ids) ;

	/**
	 * 【组合元素】驳回服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	@RequestMapping(value = "/mr/tpl/rejected/groupElement", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> reject(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【组合元素】启用服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	@RequestMapping(value = "/mr/tpl/activated/groupElement", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> activate(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【组合元素】停用服务（多记录）
	 * @param ids 多个记录主键
	 * @return 批量更新结果
	 */
	@RequestMapping(value = "/mr/tpl/stopped/groupElement", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> stop(@ModelAttribute ArrayInputModel ids) ;
	
	/**
	 * 【组合元素】导航树
	 * @param condition.keyword 搜索关键字
	 * @param condition.typeCode 医疗记录组合元素类型编码
	 * @param condition.deptCode 业务科室编码(如果有多个通过','进行分割)
	 * @return 组合元素导航树结构
	 */
	@RequestMapping(value = "/mr/tpl/tree/groupElement", method = RequestMethod.GET)
	TreeResult<GETreeData> tree(@RequestParam Map<String, String> condition);
	
	/**
	 * 查询组合元素分类列表。需要按照树形结构在名称中进行缩进。
	 * @param condition.keyword 搜索关键字
	 * @return
	 */
	@RequestMapping(value = "/mr/tpl/groupElementCategorys", method = RequestMethod.GET)
	ArrayResult<GroupElementCategory> searchCategory(@RequestParam Map<String, String> condition);
}
