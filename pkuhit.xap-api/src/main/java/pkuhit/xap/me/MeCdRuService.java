package pkuhit.xap.me;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



public interface MeCdRuService {
	
	 @RequestMapping(value = "/mecdru/{id}", method = RequestMethod.GET)
	 MeCdRuId selectById(@PathVariable("id") String id);

}
