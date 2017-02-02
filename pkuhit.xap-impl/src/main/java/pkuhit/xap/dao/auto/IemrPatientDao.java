package pkuhit.xap.dao.auto;

import java.sql.Clob;
import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.BatchUpdate;
import org.seasar.doma.ClobFactory;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.xap.dao.auto.entity.IemrPatient;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface IemrPatientDao {

    /**
     * @param patientId
     * @return the IemrPatient entity
     */
    @Select
    IemrPatient selectIemrPatientById(String patientId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(IemrPatient entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(IemrPatient entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(IemrPatient entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(IemrPatient entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(IemrPatient entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(IemrPatient entity);

    @BatchInsert
    int[] batchInsert(List<IemrPatient> entities);

    @BatchUpdate
    int[] batchUpdate(List<IemrPatient> entities);

    @BatchDelete
    int[] batchDelete(List<IemrPatient> entities);
    
    @ClobFactory
    Clob createClob();
   
    @Select
    List<IemrPatient> selectIemrPatientList(String condition,SelectOptions options);
    
    
}