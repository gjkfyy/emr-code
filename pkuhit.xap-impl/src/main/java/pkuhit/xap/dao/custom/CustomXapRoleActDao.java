package pkuhit.xap.dao.custom;


import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.xap.dao.auto.entity.MeFuAct;
import pkuhit.xap.dao.auto.entity.XapRoleAct;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomXapRoleActDao {

    @Select
    List<XapRoleAct> selectXapRoleActList(String roleCd);
    
    @Select
    List<MeFuAct> selectFuActionListByRoleCd(String roleCd); 
}