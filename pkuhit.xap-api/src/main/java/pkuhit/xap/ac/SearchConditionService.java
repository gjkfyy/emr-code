package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface SearchConditionService
{
    /**
     * 
     * @param params
     * @return
     */
    
    @RequestMapping(value = "/searchConditionList", method = RequestMethod.GET)
    ArrayResult<Condition> search(@RequestParam Map<String, String> params);
    
    /**
     * 获取服务器端的当前时间
     * @return
     */
    @RequestMapping(value = "/searchCondition", method = RequestMethod.POST)
	public Condition insert(@ModelAttribute Condition condition);
    
    @RequestMapping(value = "/deleteCondition/{id}", method = RequestMethod.DELETE)
   	public ArrayResult<Condition> delete(@PathVariable("id") String id);
}
