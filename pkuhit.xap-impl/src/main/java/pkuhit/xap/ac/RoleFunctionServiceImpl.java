package pkuhit.xap.ac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.xap.dao.auto.entity.MeFu;
import pkuhit.xap.dao.auto.entity.XapRoleFu;
import pkuhit.xap.dao.custom.CustomXapRoleFuDao;
import pkuhit.xap.me.XapFunction;
import xap.sv.model.ArrayResult;
import xap.sv.util.BeanCopyUtil;

public class RoleFunctionServiceImpl implements RoleFunctionService
{

//    @Autowired
//    XapRoleFuDao xapRoleFuDao;
    @Autowired
    CustomXapRoleFuDao cusXapRoleFunctionDao;
    
    @Override
    public RoleFunction create(RoleFunction RoleFunction)
    {
        // TODO Auto-generated method stub
        XapRoleFu xapRoleFunction = new XapRoleFu();
        BeanCopyUtil.beanCopy(xapRoleFunction, RoleFunction);
//        xapRoleFuDao.insert(xapRoleFunction);
        return RoleFunction;
    }

    @Override
    public RoleFunction update(RoleFunction RoleFunction)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoleFunction delete(String roleFunctionId)
    {
        // TODO Auto-generated method stub
//        XapRoleFu xapRoleFunction = xapRoleFuDao.selectById(roleFunctionId);
//        xapRoleFuDao.delete(xapRoleFunction);
//        RoleFunction roleFunction = new RoleFunction();
        return null;
    }

    @Override
    public ArrayResult<XapFunction> selectFunctionListByRoleCd(String roleCd)
    {
        // TODO Auto-generated method stub
        List<MeFu> meFuList = cusXapRoleFunctionDao.selectFunctionListByRoleCd(roleCd);
        ArrayResult<XapFunction> arrayResult = new ArrayResult<XapFunction>();
        if (meFuList != null)
        {
            XapFunction [] xapFunctionList = new XapFunction[meFuList.size()];
            int i =0;
            for (MeFu meFu : meFuList)
            {
                XapFunction xapFunction = new XapFunction();
                BeanCopyUtil.beanCopy(xapFunction, meFu);
                xapFunctionList[i] = xapFunction;
                i++;
            }
            arrayResult.setDataList(xapFunctionList);
        }
        return arrayResult;
    }

    @Override
    public List<RoleFunction> search(RoleFunction condition)
    {
        // TODO Auto-generated method stub
        List<XapRoleFu> list = cusXapRoleFunctionDao.selectXapRoleFuList("");
        List<RoleFunction> roleFunctionList = new ArrayList<RoleFunction>();
        if (list != null)
        {
            for (XapRoleFu xapRoleFunction : list)
            {
                RoleFunction roleFunction = new RoleFunction();
                BeanCopyUtil.beanCopy(roleFunction, xapRoleFunction);
                roleFunctionList.add(roleFunction);
            }
        }
        return roleFunctionList;
    }

}
