package pkuhit.xap.ac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.dao.auto.XapRoleActDao;
import pkuhit.xap.dao.auto.entity.MeFuAct;
import pkuhit.xap.dao.auto.entity.XapRoleAct;
import pkuhit.xap.dao.custom.CustomXapRoleActDao;
import pkuhit.xap.me.FunctionAction;
import xap.sv.model.ArrayResult;
import xap.sv.util.BeanCopyUtil;

public class RoleActionServiceImpl implements RoleActionService
{

    @Autowired
    XapRoleActDao xapRoleActDao;
    @Autowired
    CustomXapRoleActDao cusXapRoleActionDao;
    
    @Override
    public RoleAction create(RoleAction roleAction)
    {
        // TODO Auto-generated method stub
        XapRoleAct xapRoleAct = new XapRoleAct();
        BeanCopyUtil.beanCopy(xapRoleAct, roleAction);
        xapRoleActDao.insert(xapRoleAct);
        return roleAction;
    }

    @Override
    public RoleAction update(RoleAction RoleAction)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoleAction delete(String roleActionId)
    {
        // TODO Auto-generated method stub
        XapRoleAct xapRoleAct = xapRoleActDao.selectById(roleActionId);
        xapRoleActDao.delete(xapRoleAct);
        RoleAction RoleAction = new RoleAction();
        return RoleAction;
    }

    @Override
    public ArrayResult<FunctionAction> selectFuActionListByRoleCd(String roleCd)
    {
        // TODO Auto-generated method stub
        List<MeFuAct> list = cusXapRoleActionDao.selectFuActionListByRoleCd(roleCd);
        ArrayResult<FunctionAction> arrayResult = new ArrayResult<FunctionAction>();
        if (list != null)
        {
            FunctionAction [] functionActions = new FunctionAction[list.size()];
            int i =0;
            for (MeFuAct meFuAct : list)
            {
                FunctionAction functionAction = new FunctionAction();
                BeanCopyUtil.beanCopy(functionAction, meFuAct);
                functionActions[i] = functionAction;
                i++;
            }
            arrayResult.setDataList(functionActions);
        }
        return arrayResult;
    }

    @Override
    public List<RoleAction> search(RoleAction condition)
    {
        // TODO Auto-generated method stub
        List<XapRoleAct> list = cusXapRoleActionDao.selectXapRoleActList("");
        List<RoleAction> roleActionList = new ArrayList<RoleAction>();
        if (list != null)
        {
            for (XapRoleAct xapRoleAct : list)
            {
                RoleAction roleAction = new RoleAction();
                BeanCopyUtil.beanCopy(roleAction, xapRoleAct);
                roleActionList.add(roleAction);
            }
        }
        return roleActionList;
    }

}
