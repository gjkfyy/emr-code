package pkuhit.iih.sync;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TaskJobXapUserService {
	
	@RequestMapping(value = "/sync/xapuser", method = RequestMethod.GET)
	String search() ;
	
	@RequestMapping(value = "/sync/xapbatch", method = RequestMethod.GET)
    String batchSearch() ;

}
