package pkuhit.iih.mr.wr.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.Mr;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface CusCaDataDao {
    
    /**
     * 根据病历id
     * @param id
     * @return
     */
    @Select
    List<Map<String, Object>> getCaSn(String mrPk);
}