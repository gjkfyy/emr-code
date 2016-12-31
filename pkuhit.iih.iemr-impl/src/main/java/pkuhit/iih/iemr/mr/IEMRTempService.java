package pkuhit.iih.iemr.mr;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.tpl.TemplateNavigatorTreeData;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * 医疗模板相关服务接口
 * @author wu.junhui
 *
 */
public interface IEMRTempService {
	/**
	 * 增加医疗模板信息
	 */
	
	
	/**
	 * 修改医疗模板信息
	 */
	
	/**
	 * 删除单条医疗模板信息
	 */
	
	/**
	 * 获得单条医疗模板信息
	 */
	
	/**
	 * 发布医疗模板
	 */
	
	
	/**
	 * 撤回医疗模板
	 */
	
	
	/**
	 * 查询医疗模板列表
	 */
	
	/**
	 * 懒加载
	 * 病历模板树   院区-所属-病历模板自定义分类-病历模板类型-病历模板模板
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	 @RequestMapping(value = "/mr/tpl/tree", method = RequestMethod.POST)
	 TreeResult<TemplateNavigatorTreeData>  getLazyTree(@ModelAttribute TemplateNavigatorTreeData io)  ; 
	 
	 /**
	  * 全部加载树，
	  * 包括按“keyWord 名称”查询，查询范围包括【科室名称，自定义分类名称，类型名称，病历模板名称】，查询结果以树形显示,鼠标定位在第一个叶节点
	  * 按“mrTemplateCode 病历模板的编码”查询结果以树形显示。定位在第一个叶节点
	  * keyWord 名称搜索关键词
	  * mrTemplateCode 病历模板编码
	  * deptCode 业务科室编码(如果有多个通过','进行分割)
	  * loadMode 加载模式。1：全量加载，2：延迟加载。默认为1
	  * */
	 @RequestMapping(value = "/mr/tpl/tree/notlazy", method = RequestMethod.GET) 	 
	 TreeResult<TemplateNavigatorTreeData>  getTree(@RequestParam Map<String, String> condition)  ; 
	
}
