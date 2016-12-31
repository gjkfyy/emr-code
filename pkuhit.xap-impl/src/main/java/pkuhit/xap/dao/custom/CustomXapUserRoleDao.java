package pkuhit.xap.dao.custom;


import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.org.dao.auto.entity.OrgEmpDept;
import pkuhit.xap.dao.auto.entity.XapUserRole;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomXapUserRoleDao {

    @SuppressWarnings("rawtypes")
	@Select 
    List<XapUserRole> selectXapUserRoleList(String userId,String orgCd,String roleId); 
    
    @Select 
    Map<String, Object> deleteByUserId(String userId);   
    
    @Select 
    List<OrgEmpDept> selectXapUserOrgDeptList(String userId); 
    
    @Select 
    List<XapUserRole> selectDoctorOrNurse(String userId); 
    
    @Select 
    List<XapUserRole> selectCheckUserRole(String userId,String deptCd); 
}