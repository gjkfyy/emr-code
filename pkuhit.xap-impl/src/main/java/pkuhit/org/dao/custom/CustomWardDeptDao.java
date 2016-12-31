package pkuhit.org.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.org.dao.auto.entity.Org;
import pkuhit.org.dao.auto.entity.OrgEmpDept;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomWardDeptDao {
    @Select 
    List<Org> selectAll(String deptCode,String deptTypeCode); 
    
    @Select 
    List<Map<String,Object>> selectDept(String deptCode,String deptTypeCode); 
    
    @Select
    List<Map<String,Object>> selectOrgEmpDeptListByUserId(String userId,String deployMode);
}
