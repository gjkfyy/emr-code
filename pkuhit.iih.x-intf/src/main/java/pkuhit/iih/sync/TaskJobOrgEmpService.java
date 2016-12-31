package pkuhit.iih.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TaskJobOrgEmpService {
	@RequestMapping(value = "/sync/orgemp", method = RequestMethod.GET)
	String search() ;
}
