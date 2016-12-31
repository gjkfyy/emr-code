package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.org.Employee;
import xap.sv.annotation.Service;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

@Service
public interface PwdUpdateService
{
	/**
	 * 校验【原密码】是否正确
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/pwdupdate/vaidatoroldpwd", method = RequestMethod.GET)
	public String VaidatorOldPwd(@RequestParam Map<String, String> condition)
		throws Throwable;

	/**
	 *  更新密码
	 */
	@RequestMapping(value = "/pwdupdate/save", method = RequestMethod.PUT)
	SingleResult<User> saveNewPwd(@ModelAttribute User value) ;
}
