package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.org.Employee;
import xap.sv.annotation.Service;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

@Service
public interface UserService
{
    /**
     * 
     * @description 创建用户
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:47:49
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    User create(@ModelAttribute User user);
    /**
     * 
     * @description 更新用户
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:48:01
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    SingleResult<User> update(@PathVariable("id") String userId, @ModelAttribute User user);
    /**
     * 
     * @description 删除用户
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:48:01
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    String delete(@PathVariable("id") String userId);
    /**
     * 
     * @description 查询单个用户详细信息
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:48:01
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    SingleResult<User> selectById(@PathVariable("id") String userId);
    
    /**
     * 
     * @description 查询单个用户详细信息
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:48:01
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/clean/{id}", method = RequestMethod.GET)
    SingleResult<User> selectUserById(@PathVariable("id") String userId);
    
    /**
     * map中key值：
     * 1、orgCd：机构的code，用于根据机构code查询用户列表。
     * 2、statusCd：用户状态，表示启用不启用等。
     * 3、userId：用户名。
     * 4、name：用户姓名。
     * @description 查询用户
     * @author jiao_xiantong
     * @date 2014年12月12日 上午10:42:06
     * @param params
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ArrayResult<User> search(@RequestParam Map<String, String> params);
    
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    ArrayResult<Employee> searchEmp(@RequestParam Map<String, String> params);
    
    /**
     * 
//     * @description 查询单个用户是否图片签名
     * @author sun_yuhang
     * @date 2016年1月8日 上午15:21:01
     * @param user
     * @return
     */
    @RequestMapping(value = "mrSign/user/{id}", method = RequestMethod.GET)
    SingleResult<User> selectMrSignById(@PathVariable("id") String userId);
}
