package pkuhit.xap.cfg;



 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.servlet.mvc.annotation.ModelAttribute;

 


public interface ConfigItemService {
	
	 @RequestMapping(value = "/configitem", method = RequestMethod.POST)
	 int  create(@ModelAttribute ConfigItem configItem);
	 
	 @RequestMapping(value = "/configitem",method = RequestMethod.PUT)
	 int update(@ModelAttribute ConfigItem configItem);
	 
	 @RequestMapping(value = "/configitem",method = RequestMethod.DELETE)
	 int delete(@ModelAttribute ConfigItem configItem);
	 
	 @RequestMapping(value = "/configitem/{id}", method = RequestMethod.GET)
	 ConfigItem selectById(@PathVariable("id") String id);
	 
	 
//	  @RequestMapping(value = "/config/item/{tgtObCd}/{tgtObPk}", method = RequestMethod.GET)
//	  List<ConfigItem> search(@PathVariable("tgtObCd") String tgtObCd,@PathVariable("tgtObPk")String TgtObPk);

}
