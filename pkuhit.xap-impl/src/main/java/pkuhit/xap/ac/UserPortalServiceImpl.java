package pkuhit.xap.ac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.dao.auto.entity.XapPortal;
import pkuhit.xap.dao.custom.CustomXapUserDao;
import pkuhit.xap.po.Portal;
import xap.sv.model.ArrayResult;
import xap.sv.util.BeanCopyUtil;

public class UserPortalServiceImpl implements UserPortalService
{
    @Autowired
    CustomXapUserDao customXapUserDao;
    /**
     * 提供根据用户ID和部门ID查询portal的功能。
     * 根据用户ID查询角色ID，根据角色ID和orgCd查询portal列表。
     * @description
     * @author jiao_xiantong
     * @date 2014年11月28日 上午9:31:29
     * @param userId
     * @param orgCd
     * @return
     * @see pkuhit.xap.ac.UserPortalService#getUserPortalList(java.lang.String, java.lang.String)
     */
    @Override
    public ArrayResult<Portal> getUserPortalList(String userId, String orgCd)
    {
        List<XapPortal> xapPortalList = new ArrayList<XapPortal>();
        if(orgCd != null)
            xapPortalList = customXapUserDao.selectXapPortalListByUserId(userId, orgCd);
        else
            xapPortalList = customXapUserDao.selectDefaultPortalList(userId);
        ArrayResult<Portal> result = new ArrayResult<Portal>();
        if (xapPortalList != null)
        {
            Portal [] portalList = new Portal[xapPortalList.size()];
            int i = 0;
            for (XapPortal xapPortal : xapPortalList)
            {
               Portal portal = new Portal();
               BeanCopyUtil.beanCopy(portal, xapPortal);
               portalList[i] = portal;
               i++;
            }
            result.setDataList(portalList);
        }
        return result;
    }
}
