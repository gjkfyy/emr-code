package ei.cis.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.ei.ExterInterf;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface CisExterInterfService
{
	  /**
     *  【处方录入】调用
     * @param  enPk
     * 
     * @author wang_yanli
     */
	@RequestMapping(value = "/externalInterf/{exterInterfCd}", method = RequestMethod.GET)
    SingleResult<ExterInterf>  searchExterInterf(@RequestParam("exterInterfCd") String exterInterfCd) ;
}
