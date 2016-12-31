package pkuhit.iih.mr.wr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.ac.User;
import xap.sv.model.SingleResult;
public interface SignUserService {

	/**
	 * 查询审签用户信息
	 * @return
	 */
	@RequestMapping(value = "/signUser", method = RequestMethod.GET)
	SingleResult<User> searchSignUser() throws Throwable;
}
