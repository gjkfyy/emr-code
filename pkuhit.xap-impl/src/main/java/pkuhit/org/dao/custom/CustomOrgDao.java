package pkuhit.org.dao.custom;


import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.org.dao.auto.entity.Org;
import pkuhit.org.dao.auto.entity.OrgEmp;
import pkuhit.org.dao.auto.entity.WardDept;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomOrgDao {

    @Select 
    List<Org> selectOrgList(String orgTpCd); 
    
    @Select
    List<WardDept> selectDeptList(String keyword,String id,String deptTpCd,SelectOptions options);
    
    @Select
    List<Org> selectUserDeptList(String userId,String deployMode);
    
     
    @Select
    List<OrgEmp> selectOrgEmpListByDept(String keyword,String deptCd,String id,SelectOptions options);
    
}