package pkuhit.xap.sy;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.annotation.Service;

@Service
public interface SysConfigService {
	
	   @RequestMapping(value = "/sysconfig/{id}", method = RequestMethod.GET)
	   Object getObject(@PathVariable("id") String id);

}
