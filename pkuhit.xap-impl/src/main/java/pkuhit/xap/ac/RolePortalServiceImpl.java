package pkuhit.xap.ac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.dao.auto.XapRolePortalDao;
import pkuhit.xap.dao.auto.entity.XapPortal;
import pkuhit.xap.dao.auto.entity.XapRolePortal;
import pkuhit.xap.dao.custom.CustomXapRolePortalDao;
import pkuhit.xap.po.Portal;
import xap.sv.model.ArrayResult;
import xap.sv.util.BeanCopyUtil;

public class RolePortalServiceImpl implements RolePortalService
{
    
    @Autowired
    XapRolePortalDao xapRolePortalDao;
    @Autowired
    CustomXapRolePortalDao cusXapRolePortalDao;
    
    @Override
    public RolePortal create(RolePortal rolePortal)
    {
        // TODO Auto-generated method stub
        XapRolePortal xapRolePortal = new XapRolePortal();
        BeanCopyUtil.beanCopy(xapRolePortal, rolePortal);
        xapRolePortalDao.insert(xapRolePortal);
        return rolePortal;
    }

    @Override
    public RolePortal update(RolePortal rolePortal)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RolePortal delete(String rolePortalId)
    {
        // TODO Auto-generated method stub
        XapRolePortal xapRolePortal = xapRolePortalDao.selectById(rolePortalId);
        xapRolePortalDao.delete(xapRolePortal);
        RolePortal rolePortal = new RolePortal();
        return rolePortal;
    }

    @Override
    public ArrayResult<Portal> selectPortalListByRoleCd(String roleCd)
    {
        // TODO Auto-generated method stub
        List<XapPortal> xapPortalList = cusXapRolePortalDao.selectXapPortalListByRoleId(roleCd);
        ArrayResult<Portal> list = new ArrayResult<Portal>();
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
            list.setDataList(portalList);
        }
        return list;
    }

    @Override
    public List<RolePortal> search(RolePortal condition)
    {
        // TODO Auto-generated method stub
        List<XapRolePortal> list = cusXapRolePortalDao.selectXapRolePortalList("");
        List<RolePortal> rolePortalList = new ArrayList<RolePortal>();
        if (list != null)
        {
            for (XapRolePortal xapRolePortal : list)
            {
                RolePortal rolePortal = new RolePortal();
                BeanCopyUtil.beanCopy(rolePortal, xapRolePortal);
                rolePortalList.add(rolePortal);
            }
        }
        return rolePortalList;
    }

}
