package pkuhit.iih.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TaskJobMdDiService {

	
	@RequestMapping(value = "/sync/mddi", method = RequestMethod.GET)
	String search() ;
}
