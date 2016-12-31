package pkuhit.xap.cfg;

import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface ConfigItemDataService {
      
	 @RequestMapping(value = "/configitem/data", method = RequestMethod.POST)
	 int  create(@ModelAttribute ConfigItemData configItemData);
	 
	 @RequestMapping(value = "/configitem/data",method = RequestMethod.PUT)
	 int update(@ModelAttribute ConfigItemData configItemData);
	 
	 @RequestMapping(value = "/configitem/data",method = RequestMethod.DELETE)
	 int delete(@ModelAttribute ConfigItemData configItemData);
	 
	 @RequestMapping(value = "/configitem/data/{id}", method = RequestMethod.GET)
	 ConfigItemData selectById(@PathVariable("id") String id);
	 
	 /**
	  * String orgCode, 
	  * String configCode
	  * @param params
	  * @return
	  */
	 @RequestMapping(value="/configitem/data",method=RequestMethod.GET)
	 SingleResult<ConfigItemData> search(@RequestParam Map<String,String> params);
}
