/**
 * 
 */
package pkuhit.iih.mr.md;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * @author guo_zhongbao
 * 病历模板分类 与 病历模板类型 的关系
 */
public interface MrTypeCustomCategoryItemService {
	/**
	 * 根据病历模板类型编码查询，所关联的分类
	 * */
	@RequestMapping(value = "/mr/md/mrccat/type", method = RequestMethod.GET)
	ArrayResult<MrTypeCustomCategoryItem>  getMdMrTpCcatItmByTemplateType(@RequestParam("typeCode") String typeCode);
	/**
	 * 根据病历模板分类编码查询，所关联的类型
	 * */
	@RequestMapping(value = "/mr/md/mrccat/ccat", method = RequestMethod.GET)
	ArrayResult<MrTypeCustomCategoryItem> getMdMrTpCcatItmByTemplateCategory(@RequestParam("categoryCode") String categoryCode);
	
	/**
     * 根据病历模板类型编码查询其所属就诊类型(去掉重复)
     * */
    @RequestMapping(value = "/mr/md/mrccatitem/entype", method = RequestMethod.GET)
    ArrayResult<MrTypeCustomCategoryItem> searchEnTypeByTemplateType(@RequestParam("typeCode") String typeCode);
    
    /**
     * 根据病历模板类型编码查询其所属分组(去掉重复)
     * */
    @RequestMapping(value = "/mr/md/mrccatitem/ccat", method = RequestMethod.GET)
    ArrayResult<MrTypeCustomCategoryItem> searchMrTpCcatByTemplateType(@RequestParam("typeCode") String typeCode);
}
