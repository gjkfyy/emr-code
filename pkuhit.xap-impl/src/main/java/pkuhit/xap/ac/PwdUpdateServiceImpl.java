package pkuhit.xap.ac;

import java.util.Map;

import org.apache.shiro.codec.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapUserDao;
import pkuhit.xap.dao.auto.entity.XapUser;
import pkuhit.xap.dao.custom.CustomXapUserDao;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

public class PwdUpdateServiceImpl implements PwdUpdateService
{
    @Autowired
    XapUserDao xapUserDao;

    @Autowired
    CustomXapUserDao cusXapUserDao;
    
   	@Reference
	private DictionaryService dictionaryService;

	@Override
	public String VaidatorOldPwd(Map<String, String> value)throws Throwable {
		String m ="1";
		String userId = value.get("userId");
		String oldPwd = value.get("oldPwd");
		XapUser user = xapUserDao.selectById(userId);
		String pwd =user.getPwd();
		String pwdS = Base64.decodeToString(pwd);
		String iemrPwd =user.getIemrPwd();
		String iemrPwdS = Base64.decodeToString(iemrPwd);
		if(pwdS.equals(oldPwd) || iemrPwdS.equals(oldPwd)){
			m="0";
		}
		return m;
	}

	@Override
	public SingleResult<User> saveNewPwd(User value) {
		String iemrPwd = value.getIemrPassword();
		String iemrPwds = Base64.encodeToString(iemrPwd.getBytes());
		String userId = value.getId();
		XapUser xapUser = xapUserDao.selectById(userId);
		if(xapUser != null){
			xapUser.setIemrPwd(iemrPwds);
			xapUserDao.update(xapUser);
		}
		return SingleResultBuilder.newSingleResult(User.class).build();
	}
}
