package pkuhit.xap.dao.custom;


import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.xap.dao.auto.entity.IemrReport;
import pkuhit.xap.dao.auto.entity.IemrReportRole;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomReportRoleDao {

    @Select  
    List<IemrReport> selectReportList(); 
    
    @Select  
    List<IemrReport> selectReportListByRoleCode(String roleCode); 

    @Select  
    List<IemrReportRole> selectReportRoleListByRoleCode(String roleCode); 
}