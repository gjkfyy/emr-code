package pkuhit.xap.dao.auto;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.xap.dao.auto.entity.IemrSearchCondition;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface IemrSearchConditionDao {

    /**
     * @param patientId
     * @return the IemrPatient entity
     */
    @Select
    List<IemrSearchCondition> selectIemrSearchConditionById(String userId,SelectOptions options);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(IemrSearchCondition entity);
    

    @Update(excludeNull=true)
    int update(IemrSearchCondition entity);

}