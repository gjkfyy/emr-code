package pkuhit.xap.log;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.annotation.Service;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

@Service
public interface PerformanceLogService {
   
	 @RequestMapping(value = "/performancelog", method = RequestMethod.POST)
	 PerformanceLog  create(@ModelAttribute PerformanceLog performanceLog);
	 
	 @RequestMapping(value = "/performancelog",method = RequestMethod.PUT)
	 PerformanceLog update(@ModelAttribute PerformanceLog performanceLog);
	 
	 @RequestMapping(value = "/performancelog",method = RequestMethod.DELETE)
	 PerformanceLog delete(@ModelAttribute PerformanceLog performanceLog);
	 
	 @RequestMapping(value = "/performancelog", method = RequestMethod.GET)
	 PerformanceLog select();
}
