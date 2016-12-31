package pkuhit.xap.cfg;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ConfigItemOptionService {
	
	 @RequestMapping(value = "/configitem/option", method = RequestMethod.POST)
	 int  create(@ModelAttribute ConfigItemOption configItemOption);
	 
	 @RequestMapping(value = "/configitem/option",method = RequestMethod.PUT)
	 int update(@ModelAttribute ConfigItemOption configItemOption);
	 
	 @RequestMapping(value = "/configitem/option",method = RequestMethod.DELETE)
	 int delete(@ModelAttribute ConfigItemOption configItemOption);
	 
	 @RequestMapping(value = "/configitem/option/{id}", method = RequestMethod.GET)
	 ConfigItemOption selectById(@PathVariable("id") String id);

}
