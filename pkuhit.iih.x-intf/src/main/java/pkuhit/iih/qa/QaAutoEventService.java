package pkuhit.iih.qa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface QaAutoEventService {

	@RequestMapping(value = "/qa/auto/eventTypes", method = RequestMethod.GET)
	ArrayResult<EmrEventModel> getEventTypeList(@RequestParam("enPk") String enPk)  throws Throwable;
	
	
}
