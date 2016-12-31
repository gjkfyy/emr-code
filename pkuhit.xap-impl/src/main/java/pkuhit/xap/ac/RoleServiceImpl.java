package pkuhit.xap.ac;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import pkuhit.xap.dao.auto.XapRoleDao;
import pkuhit.xap.dao.auto.entity.XapRole;
import pkuhit.xap.dao.auto.entity.XapUser;
import pkuhit.xap.dao.custom.CustomXapRoleDao;
import pkuhit.xap.pub.MessageCode;
import xap.sv.annotation.Reference;
import xap.sv.i18n.MessageSource;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.BeanCopyUtil;

public class RoleServiceImpl implements RoleService
{
    
    @Autowired
    XapRoleDao xapRoleDao;
    @Autowired
    CustomXapRoleDao cusXapRoleDao;
    @Reference
    MessageSource messageSource;
    
    @Override
    public SingleResult<Role> create(Role role)
    {
        // TODO Auto-generated method stub
        if (StringUtils.isEmpty(role.getCode()))
        {
            throw new NotificationException(new Notification(MessageCode.M10010, messageSource.fetchMessage(MessageCode.M10024)));
        }
        
        if (StringUtils.isEmpty(role.getName()))
        {
            throw new NotificationException(new Notification(MessageCode.M10010, messageSource.fetchMessage(MessageCode.M10025)));
        }
        
        if (StringUtils.isEmpty(role.getOrganizationCode()))
        {
            throw new NotificationException(new Notification(MessageCode.M10010, messageSource.fetchMessage(MessageCode.M10023)));
        }
        XapRole xapRole = new XapRole();
        BeanCopyUtil.ModelToEntity(xapRole, role);
        xapRoleDao.insert(xapRole);
        BeanCopyUtil.beanCopy(role, xapRole);
        SingleResult<Role> singleResult = new SingleResult<Role>();
        singleResult.setData(role);
        return singleResult;
    }

    @Override
    public SingleResult<Role> update(Role role)
    {
        // TODO Auto-generated method stub
        if(StringUtils.isEmpty(role.getCode())){
            throw new NotificationException(new Notification(MessageCode.M10010, messageSource.fetchMessage(MessageCode.M10024)));
        }
        XapRole xapRole = new XapRole();
        BeanCopyUtil.ModelToEntity(xapRole, role);
        xapRoleDao.updateExcludeNull(xapRole);
        BeanCopyUtil.beanCopy(role, xapRole);
        SingleResult<Role> singleResult = new SingleResult<Role>();
        singleResult.setData(role);
        return singleResult;
    }

    @Override
    public String delete(String roleCd)
    {
        // TODO Auto-generated method stub
        if(StringUtils.isEmpty(roleCd)){
            throw new NotificationException(new Notification(MessageCode.M10010, messageSource.fetchMessage(MessageCode.M10024)));
        }
        XapRole xapRole = xapRoleDao.selectById(roleCd);
        xapRoleDao.delete(xapRole);
        return "";
    }

    @Override
    public SingleResult<Role> selectByCode(String roleCd)
    {
        // TODO Auto-generated method stub
        XapRole xapRole = cusXapRoleDao.selectByCode(roleCd);
        Role role = new Role();
        BeanCopyUtil.beanCopy(role, xapRole);
        SingleResult<Role> singleResult = new SingleResult<Role>();
        singleResult.setData(role);
        return singleResult;
    }

    @Override
    public ArrayResult<Role> search(Map<String, String> params)
    {
        // TODO Auto-generated method stub
        List<XapRole> list = cusXapRoleDao.selectXapRoleList();
        ArrayResult<Role> arrayResult = new ArrayResult<Role>();
        if (list != null)
        {
            Role [] roleList = new Role[list.size()];
            int i = 0;
            for (XapRole xapRole : list)
            {
                Role role = new Role();
                BeanCopyUtil.beanCopy(role, xapRole);
                roleList[i] = role;
                i++;
            }
            arrayResult.setDataList(roleList);
        }
        return arrayResult;
    }

}
