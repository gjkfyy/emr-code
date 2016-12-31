package pkuhit.xap.dao.custom;


import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.xap.dao.auto.entity.XapPortal;
import pkuhit.xap.dao.auto.entity.XapRolePortal;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomXapRolePortalDao {

    @Select  
    List<XapRolePortal> selectXapRolePortalList(String roleCd); 
    @Select 
    List<XapPortal> selectXapPortalListByRoleId(String roleCd);
}