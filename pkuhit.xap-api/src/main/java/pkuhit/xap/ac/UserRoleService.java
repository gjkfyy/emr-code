package pkuhit.xap.ac;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import xap.sv.annotation.Service;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;

/**
 * 用户角色资源相关的服务接口
 * @author wu.junhui
 *
 */
@Service
public interface UserRoleService
{
    /**
     * 1、更新用户信息，只会更新密码和用户启用状态
     * 2、更新用户权限，需要科室code，用户id和角色code
     * @description 创建用户角色
     * @author jiao_xiantong
     * @date 2014年12月12日 上午11:23:14
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/role", method = RequestMethod.POST)
    public SingleResult<UserRole> create(@ModelAttribute User user);

    /**
     * 更新用户角色
     * @param userRole
     * @return
     */
    @RequestMapping(value = "/user/role/{id}", method = RequestMethod.PUT)
    public SingleResult<UserRole> update(@PathVariable("id") String userRoleId, @ModelAttribute UserRole userRole);

    /**
     * 删除用户角色
     * @param userRoleId
     * @return
     */
    @RequestMapping(value = "/user/role/{id}", method = RequestMethod.DELETE)
    public SingleResult<UserRole> delete(@PathVariable("id") String userRoleId);

    /**
     * 获取用户角色
     * @param userRoleId
     * @return
     */
    @RequestMapping(value = "/user/role/{id}", method = RequestMethod.GET)
    public SingleResult<UserRole> selectById(@PathVariable("id") String userRoleId);

    /**
     * 查询用户角色列表
     * @param userId String [用户ID]查询条件
     * @param orgCd String [组织结构编码]查询条件
     * @param roleId String [角色id]查询条件
     * @return
     */
	@RequestMapping(value = "/user/roles", method = RequestMethod.GET)
	public ArrayResult<UserRole> search(@RequestParam Map<String, String> params);
	
	/**
	 * 根据用户id 查询角色，是医生，护士，还是科室管理员
	 * @param userId 用户id
	 * @return 医生 护士标志                  医生(临床医生 门诊医生) --1 ，护士---0，其他为null
	 * 
	 * */
    @RequestMapping(value = "/user/role/getDNFlag", method = RequestMethod.POST)
    public SingleResult<Integer> getDoctorOrNurseFlag(@RequestParam("userId") String userId);

	/**
	 * 获取有病历管理权限的科室列表
	 * @param userId 用户
	 * @param searchDeptCode 查询科室
	 * @return 全院返回空列表，科室返回科室列表，没有科室返回null
	 * 本用户有全院病历管理员权限，可以修改所有科室病历
	 * 本用户有科室病历管理员权限，可以修改自己管理的科室病历
	 * */
	@RequestMapping(value = "/user/roles/mrb", method = RequestMethod.GET)
	public List<String> userRoleMrbDeptList(@RequestParam("userId") String userId,@RequestParam("searchDeptCode") String searchDeptCode ) ;
	
	/**
	 * 验证当前是医生还是实习医生
	 * */
	public Boolean checkPracticeDoctor(String userId,String deptCd) ;
	
	/**
	 * 验证当前登录医生有没有提交病历权限
	 * 科室 登录名 密码 验证
	 * @param loginNm 用户
	 * @param Pwd 密码
	 * @param deptCd 创建科室
	 * @return 返回医生信息
	 * */
	@RequestMapping(value = "/user/roles/mrCheckSubmitUser", method = RequestMethod.POST)
	public Object mrCheckSubmitUser(@ModelAttribute User user) ;
	
}
