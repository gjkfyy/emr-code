package pkuhit.xap.dao.custom;


import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.xap.dao.auto.entity.XapMenu;
import pkuhit.xap.dao.auto.entity.XapPortal;
import pkuhit.xap.dao.auto.entity.XapUser;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomXapUserDao {

    @Select/*(maxRows=50)*/ 
    List<XapUser> selectXapUserList(String orgCd,String statusCd,String userId,String name, String curDeptNm,String empId,String dctNsF,SelectOptions options);  
    
    @Select   
    List<XapPortal> selectXapPortalListByUserId(String userId,String orgCd);
    
    @Select   
    List<XapPortal> selectDefaultPortalList(String userId);
    
    @Select 
    List<XapMenu> selectXapMenuListByUserId(String userId,String portalCd,String orgCd,String parMenuCd);
    
    @Select 
    List<XapMenu> selectDefaultMenuList(String userId,String portalCd,String parMenuCd);
     
    @Select
    List<XapUser> selectXapUserOnCheck(String orgCd,String iemrPwd,String userId);
    
    @Select
    String searchJobTitle(String jobTitleCode);

}   