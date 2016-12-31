package pkuhit.xap.ac;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.po.Portal;
import xap.sv.annotation.Service;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

@Service
public interface UserPortalService
{
    /**
     * 
     * @description 根据用户id和机构的code查询该用户可登陆的门户
     * @author jiao_xiantong
     * @date 2014年12月12日 下午1:56:52
     * @param userId
     * @param orgCd
     * @return
     */
    @RequestMapping(value = "/user/portal", method = RequestMethod.GET)
    ArrayResult<Portal> getUserPortalList(@RequestParam("userId")String userId,@RequestParam("orgCd")String orgCd);

}
