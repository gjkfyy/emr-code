package pkuhit.iih.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TaskJobOrgService {

	@RequestMapping(value = "/sync/org", method = RequestMethod.GET)
	String search() ;
}
