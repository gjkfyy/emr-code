package pkuhit.xap.log;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.annotation.Service;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

@Service
public interface ErrorLogService {
   
	 @RequestMapping(value = "/errorlog", method = RequestMethod.POST)
	 ErrorLog  create(@ModelAttribute ErrorLog errorLog);
	 
	 @RequestMapping(value = "/errorlog",method = RequestMethod.PUT)
	 ErrorLog update(@ModelAttribute ErrorLog errorLog);
	 
	 @RequestMapping(value = "/errorlog",method = RequestMethod.DELETE)
	 ErrorLog delete(@ModelAttribute ErrorLog errorLog);
	 
	 @RequestMapping(value = "/errorlog", method = RequestMethod.GET)
	 ErrorLog select();
}
