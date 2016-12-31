package pkuhit.xap.log;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xap.sv.annotation.Service;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

@Service
public interface AccessLogService {
   
	 @RequestMapping(value = "/aclog", method = RequestMethod.POST)
	 AccessLog  create(@ModelAttribute AccessLog accessLog);
	 
	 @RequestMapping(value = "/aclog",method = RequestMethod.PUT)
	 AccessLog update(@ModelAttribute AccessLog accessLog);
	 
	 @RequestMapping(value = "/aclog",method = RequestMethod.DELETE)
	 AccessLog delete(@ModelAttribute AccessLog accessLog);
	 
	 @RequestMapping(value = "/aclog", method = RequestMethod.GET)
	 AccessLog select();
}
