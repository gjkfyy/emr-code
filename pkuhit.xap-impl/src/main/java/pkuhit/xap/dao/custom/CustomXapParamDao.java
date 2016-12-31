package pkuhit.xap.dao.custom;


import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.md.dao.auto.entity.MdGs;
import pkuhit.xap.dao.auto.entity.XapParam;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomXapParamDao {

    @Select  
    List<XapParam> selectXapParamList(SelectOptions options);
    
    @Select  
    List<XapParam> selectXapParamListByCondition(List<String>  conditionNmList ,String code ,SelectOptions options);
    
    @Select  
    String selectXapParamNm(String nm,String paramCd);
    
    @Select  
    String selectXapParamCodeAndKey(String paramCd,String code,String key); 
    
    @Select  
    List<XapParam> selectXapParamByCode(String code);
    
    @Select
    List<MdGs> selectMdGsList(String keyword,String id,SelectOptions options);
   
}