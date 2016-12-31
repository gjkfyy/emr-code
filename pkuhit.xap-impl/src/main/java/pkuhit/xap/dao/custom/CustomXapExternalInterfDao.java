package pkuhit.xap.dao.custom;


import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.xap.dao.auto.entity.XapExterInterf;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CustomXapExternalInterfDao {

    @Select  
    List<XapExterInterf> selectXapExternalInterList(SelectOptions options);
    
}