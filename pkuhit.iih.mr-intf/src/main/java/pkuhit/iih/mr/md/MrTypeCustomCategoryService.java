package pkuhit.iih.mr.md;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 病历模板自定义分类服务接口
 * */
public interface MrTypeCustomCategoryService {
	/**
	 * 根据根节点，查询自定义分类树
	 * @param orgCode 院区编码
	 * @param rootCode 根节点
	 * @param childDepth 查询层级
	 * */
	@RequestMapping(value = "/mr/md/mrccat/tree", method = RequestMethod.GET)
	TreeResult<MrTypeCustomCategory>  tree(@RequestParam("orgCode") String orgCode ,@RequestParam("rootCode") String rootCode,@RequestParam("childDepth") int childDepth);
	
	/**
	 * @param rootCode 父节点
	 * */
	@RequestMapping(value = "/mr/md/mrccat/childs", method = RequestMethod.GET)
	ArrayResult<MrTypeCustomCategory>  getChild(@RequestParam  Map<String, String>  params );
	
	//查询所有的病历文书类型组(展现形式为grid)
	@RequestMapping(value = "/mr/md/mrccat", method = RequestMethod.GET)
	ArrayResult<MrTypeCustomCategory>  search();
	
	//查询所有的病历文书类型组(展现形式为tree)
    @RequestMapping(value = "/mr/md/mrccattree", method = RequestMethod.GET)
    SingleResult<Map>  searchTree();
	/**
     * 
     * @description 创建病历文书类型组
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param MrTypeCustomCategory
     * @return
     */
    @RequestMapping(value = "/mrtypecustomcategory", method = RequestMethod.POST)
    SingleResult<MrTypeCustomCategory> create(@ModelAttribute MrTypeCustomCategory mrTypeCustomCategory);
    /**
     * 
     * @description 更新病历文书类型组
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param MrTypeCustomCategory
     * @return
     */
    @RequestMapping(value = "/mrtypecustomcategory", method = RequestMethod.PUT)
    SingleResult<MrTypeCustomCategory> update(@ModelAttribute MrTypeCustomCategory mrTypeCustomCategory);
    /**
     * 
     * @description 删除病历文书类型组
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param MrTypeCustomCategory
     * @return
     */
    @RequestMapping(value = "/mrtypecustomcategory/{id}", method = RequestMethod.DELETE)
    SingleResult<MrTypeCustomCategory> delete(@PathVariable("id") String mrTypeCustomCategoryId);
    /**
     * 
     * @description 根据code查询病历文书类型组详细信息
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param MrTypeCustomCategory
     * @return
     */
    @RequestMapping(value = "/mrtypecustomcategory/{id}", method = RequestMethod.GET)
    SingleResult<MrTypeCustomCategory> selectByCode(
            @PathVariable("id") String mrTypeCustomCategoryId);
}
