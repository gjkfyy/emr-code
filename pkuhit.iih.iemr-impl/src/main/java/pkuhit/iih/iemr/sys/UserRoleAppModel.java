package pkuhit.iih.iemr.sys;

import java.util.List;

import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserRole;

/**
 * 
 * @author wang_yanli
 *
 */
public class UserRoleAppModel extends User
{
	private UserRole[] userRoles;

	public UserRole[] getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRole[] userRoles) {
		this.userRoles = userRoles;
	}

	
	
	
}
