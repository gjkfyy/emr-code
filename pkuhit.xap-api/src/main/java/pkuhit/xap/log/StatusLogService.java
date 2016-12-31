package pkuhit.xap.log;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.annotation.Service;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

@Service
public interface StatusLogService {
	
	 @RequestMapping(value = "/statuslog", method = RequestMethod.POST)
	 StatusLog  create(@ModelAttribute StatusLog statusLog);
	 
	 @RequestMapping(value = "/statuslog",method = RequestMethod.PUT)
	 StatusLog update(@ModelAttribute StatusLog statusLog);
	 
	 @RequestMapping(value = "/statuslog",method = RequestMethod.DELETE)
	 StatusLog delete(@ModelAttribute StatusLog statusLog);
	 
	 @RequestMapping(value = "/statuslog", method = RequestMethod.GET)
	 StatusLog select();
}
