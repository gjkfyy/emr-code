package pkuhit.iih.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TaskJobOrgEmpDeptService {
	@RequestMapping(value = "/sync/orgempdept", method = RequestMethod.GET)
	String search() ;
}
