package ei.cis.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.servlet.mvc.annotation.RequestParam;

public interface CisMzClinicRoomConfigService
{
    /**
     * 出诊科室列表
     * @param ipAddr 机器IP地址
     * */
    @RequestMapping(value = "/ei/room/config/cis/mz", method = RequestMethod.GET)
    List<Map<String, Object>> searchDeptByIp(@RequestParam ("ip") String ip);
}
