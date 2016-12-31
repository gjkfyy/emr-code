package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface RoleService
{
    /**
     * 
     * @description 创建角色
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:48:53
     * @param role
     * @return
     */
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    SingleResult<Role> create(@ModelAttribute Role role);
    /**
     * 
     * @description 更新角色
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:48:53
     * @param role
     * @return
     */
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    SingleResult<Role> update(@ModelAttribute Role role);
    /**
     * 
     * @description 删除角色
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:48:53
     * @param role
     * @return
     */
    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    String delete(@PathVariable("id") String roleId);
    /**
     * 
     * @description 根据code查询角色详细信息
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:48:53
     * @param role
     * @return
     */
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    SingleResult<Role> selectByCode(@PathVariable("id") String roleId);
    /**
     * 
     * @description 查询角色列表
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:48:53
     * @param role
     * @return
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    ArrayResult<Role> search(@RequestParam Map<String, String> params);
}
