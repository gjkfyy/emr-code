package pkuhit.iih.mr.md;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.org.Organization;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * 病历模板类型服务接口
 * */
public interface MrTypeService {
	/**
	 * 根据根节点，查询自定义类型树
	 * @param rootCode 根节点
	 * @param childDepth 查询层级
	 * */
	@RequestMapping(value = "/mr/md/mrtype/tree", method = RequestMethod.GET)
	TreeResult<MrType>  tree(@RequestParam("rootCode") String rootCode,@RequestParam("childDepth") String childDepth);
	
	
	/**
	 * @param rootCode 父节点
	 * */
	@RequestMapping(value = "/mr/md/mrtype/childs", method = RequestMethod.GET)
	ArrayResult<MrType>  getChild(@RequestParam  Map<String, String>  params );
	
	//查询类型数组
	@RequestMapping(value = "/mr/md/mrtype", method = RequestMethod.GET)
	ArrayResult<MrType>  search(@ModelAttribute MrType condition);
	
	/**
     * 
     * @description 创建病历文书类型
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/mr/md/mrtype", method = RequestMethod.POST)
    SingleResult<MrType> create(@ModelAttribute MrType mrType);
    /**
     * 
     * @description 更新病历文书类型
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/mr/md/mrtype", method = RequestMethod.PUT)
    SingleResult<MrType> update(@ModelAttribute MrType mrType);
    /**
     * 
     * @description 删除病历文书类型
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/mr/md/mrtype/{id}", method = RequestMethod.DELETE)
    SingleResult<MrType> delete(@PathVariable("id") String mrTypeId);
    /**
     * 
     * @description 根据id查询病历文书类型详细信息
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/mr/md/mrtype/{id}", method = RequestMethod.GET)
    SingleResult<MrType> selectByMrTypeId(
            @PathVariable("id") String mrTypeId);
    /**
     * 
     * @description 根据id查询病历文书类型详细信息
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/mr/md/mrtype/ccat/{id}", method = RequestMethod.GET)
    ArrayResult<MrType> selectByMrTypeCcatId(@PathVariable("id") String mrTypeCcatId);
}
