package pkuhit.iih.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TaskJobMrAmrService {
	
	@RequestMapping(value = "/sync/mramr", method = RequestMethod.GET)
	String search() ;

}
