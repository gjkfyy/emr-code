package pkuhit.xap.encoding;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.SingleResult;

public interface SimpleChineseEncodingService {
	
	@RequestMapping(value = "/encoding/dept", method = RequestMethod.GET)
    SingleResult<Object> encodingDept();
}
