package pkuhit.iih.system.status;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SystemStatusService {
	
	@RequestMapping(value = "/ws/session/size", method = RequestMethod.GET)
	public int getSessionSize();
	
	@RequestMapping(value = "/ws/system/status", method = RequestMethod.GET)
	public String getSystemStatus();
}
