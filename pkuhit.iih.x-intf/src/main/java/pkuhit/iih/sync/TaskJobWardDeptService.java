package pkuhit.iih.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TaskJobWardDeptService {
 
	@RequestMapping(value = "/sync/warddept", method = RequestMethod.GET)
	String search() ;
}
