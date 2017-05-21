package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface AdvancedSearchService
{
    /**
     * 
     * @param params
     * @return
     */
    
    @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET)
    ArrayResult<Patient> search(@RequestParam Map<String, String> params);
    
}
