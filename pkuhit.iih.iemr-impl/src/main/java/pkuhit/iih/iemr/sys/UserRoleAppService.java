package pkuhit.iih.iemr.sys;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author wang_yanli
 *
 */
public interface UserRoleAppService
{
    /**
     * 获取用户信息和用户角色信息
     * @return UserId
     * @throws Throwable
     */
    @RequestMapping(value = "/userRoleInfo/{id}", method = RequestMethod.GET)
    UserRoleAppModel findUserRoleInfoByUserId(@PathVariable("id") String id);

}
