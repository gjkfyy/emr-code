package pkuhit.xap.ei;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.annotation.Service;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

@Service
public interface ExternalInterfSetService
{
    /**
     * 
     * @description 创建
     * @author wang_yanli
     * @date 2016年3月31日 上午10:47:49
     * @param Param
     * @return
     */
    @RequestMapping(value = "/externalInterf/set/list", method = RequestMethod.GET)
    ArrayResult<ExterInterf> search(@RequestParam Map<String, String> params);
    
    @RequestMapping(value = "/externalInterf/set/refresh", method = RequestMethod.GET)
    ArrayResult<ExterInterf> refresh(@RequestParam Map<String, String> params);
}
