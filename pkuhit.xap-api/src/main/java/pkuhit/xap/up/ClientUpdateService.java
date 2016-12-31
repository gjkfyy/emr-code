package pkuhit.xap.up;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface ClientUpdateService {
	
	@RequestMapping(value = "/ws/version", method = RequestMethod.GET)
    String getVersion();
}
