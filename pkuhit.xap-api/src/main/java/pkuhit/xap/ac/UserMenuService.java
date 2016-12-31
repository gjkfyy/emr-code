package pkuhit.xap.ac;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.annotation.Service;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

@Service
public interface UserMenuService
{
    /**
     * 
     * @description 根据登录用户、登录科室、登录门户，查询可用功能菜单
     * @author meng_xinhua
     * @date 2014年12月19日
     * @param userId
     * @param orgCd
     * @param portalCd
     * @return TreeResult
     */
    @RequestMapping(value = "/user/menu", method = RequestMethod.GET)
    TreeResult<MenuTreeData> getUserMenuTree(@RequestParam Map<String, String> condition);

}
