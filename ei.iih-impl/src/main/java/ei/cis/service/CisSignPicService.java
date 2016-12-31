package ei.cis.service;

import pkuhit.xap.ac.User;
import xap.sv.model.SingleResult;

public interface CisSignPicService
{
    /**
     * @description 查询用户签名图片
     * @author meng_xinhua
     * @date 2016年7月25日 上午10:42:06
     * @param userCd
     * @return
     */
    SingleResult<User> selectSignPicByUser(String userCd);
}
