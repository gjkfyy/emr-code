package pkuhit.org;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.servlet.mvc.annotation.RequestParam;

public interface NisWardConfigService
{
    /**
     * 
     * @description 创建机构
     * @author mengxh
     * @date 2016年6月29日 下午1:51:04
     * @return
     */
    @RequestMapping(value = "/ward/config/nis", method = RequestMethod.GET)
    List<Map<String, Object>> searchOrgByIp(@RequestParam ("ip")String ip);
}
