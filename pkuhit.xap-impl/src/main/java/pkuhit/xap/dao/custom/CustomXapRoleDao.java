package pkuhit.xap.dao.custom;


import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.xap.dao.auto.entity.XapRole;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomXapRoleDao {

    @Select  
    List<XapRole> selectXapRoleList(); 
    
    @Select 
    XapRole selectByCode(String roleCd); 
}