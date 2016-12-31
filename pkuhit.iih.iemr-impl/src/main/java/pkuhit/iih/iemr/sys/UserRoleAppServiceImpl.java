package pkuhit.iih.iemr.sys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;

import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserRole;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;

public class UserRoleAppServiceImpl implements UserRoleAppService
{
    @Reference
    pkuhit.xap.ac.UserService userService;
    
    @Reference
    pkuhit.xap.ac.UserRoleService userRoleService;
    
    @Override
    public UserRoleAppModel findUserRoleInfoByUserId(@PathVariable("id") String id)
    {
    	UserRoleAppModel userRoleAppModel = new UserRoleAppModel();
       
    	SingleResult<User> userResult = userService.selectById(id);
        
    	Map<String, String> params = new HashMap<String, String>();
        
        params.put("userId", id);
        
        ArrayResult<UserRole> userRolesResult = userRoleService.search(params);
        
        User user = userResult.getData();
        
        UserRole[] userRoles = userRolesResult.getDataList();
        BeanUtils.copyProperties(user,userRoleAppModel);
        //BeanCopyUtil.beanCopy(userRoleAppModel, user);
        
        if(null != user.getId()){
        	userRoleAppModel.setUserRoles(userRoles);
        }
        
        
        return userRoleAppModel;
    }
}
