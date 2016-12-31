package pkuhit.xap.dao.custom;


import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.xap.dao.auto.entity.MeFu;
import pkuhit.xap.dao.auto.entity.XapRoleFu;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomXapRoleFuDao {

    @Select
    List<XapRoleFu> selectXapRoleFuList(String roleCd);
    @Select  
    List<MeFu> selectFunctionListByRoleCd(String roleCd);  
}