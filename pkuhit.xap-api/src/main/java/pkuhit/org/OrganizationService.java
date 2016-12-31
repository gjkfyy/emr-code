package pkuhit.org;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.utils.ParameterUtils;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface OrganizationService
{
    /**
     * 
     * @description 创建机构
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/organization", method = RequestMethod.POST)
    SingleResult<Organization> create(@ModelAttribute Organization organization);
    /**
     * 
     * @description 更新机构
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/organization", method = RequestMethod.PUT)
    SingleResult<Organization> update(@ModelAttribute Organization organization);
    /**
     * 
     * @description 删除机构
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
    String delete(@PathVariable("id") String organizationId);
    /**
     * 
     * @description 根据code查询机构详细信息
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    SingleResult<Organization> selectByCode(
            @PathVariable("id") String organizationId);
    /**
     * 
     * @description 根据parOrgCd和orgTpCd查询结构列表
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/organization", method = RequestMethod.GET)
    ArrayResult<Organization> search(@RequestParam Map<String, String> params);
    /**
     * 
     * @description 根据parOrgCd和orgTpCd查询结构列表
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/organization/keyword", method = RequestMethod.GET)
    ArrayResult<Organization> searchByKeyword(@RequestParam Map<String, String> params);
    /**
     * 
     * @description 根据科室编码和科室类型查询 小科室列表
     * @author guo_zhongbao
     * @date 2015年03月05日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/warddept", method = RequestMethod.GET)
     ArrayResult<Organization> searchAllWardDept(@RequestParam("deptCode") String deptCode,@RequestParam("deptTypeCode") String deptTypeCode);
    /**
     * 
     * @description 查询机构树
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:51:04
     * @param organization
     * @return
     */
    @RequestMapping(value = "/organization/tree", method = RequestMethod.GET)
    TreeResult<Organization> searchTree(@RequestParam Map<String, String> params);
    
    
	/**
     * 查询用户所属科室列表
     * @param userId String [用户ID]查询条件
     * @return 用户所属科室列表
     */
	@RequestMapping(value = "/user/departments", method = RequestMethod.GET)
	public ArrayResult<Organization> searchUserDepartments(@RequestParam Map<String, String> params);
	
	/**
	 * 根据就诊类型查询科室列表
	 * 
	 * */
	@RequestMapping(value = "/departments/entype", method = RequestMethod.GET)
	public ArrayResult<OrganizationForCombox> searcDepartmentsByEntypecode(@RequestParam Map<String, String> params);
	
	public String selectDeptType(String deptCd);
}
