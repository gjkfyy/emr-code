package pkuhit.iih.mr.wr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xap.sv.model.ArrayResult;

public interface MrService {

	@RequestMapping(value = "/mr/searchmrs", method = RequestMethod.GET)
	 <MrDO> ArrayResult<MrDO> search( @RequestParam String enPk) throws Throwable;
}
