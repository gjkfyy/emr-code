package szlh.iih.di.dao;

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

import szlh.iih.di.po.MzPatientDiagnosisEntity;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface MzPatientDiagnosisEntityDao {

    /**
     * @param sn
     * @return the MzPatientDiagnosisEntity entity
     */
    @Select
    MzPatientDiagnosisEntity selectById(Integer sn);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MzPatientDiagnosisEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MzPatientDiagnosisEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MzPatientDiagnosisEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MzPatientDiagnosisEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MzPatientDiagnosisEntity entity);

    @BatchInsert
    int[] batchInsert(List<MzPatientDiagnosisEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<MzPatientDiagnosisEntity> entities);

    @BatchDelete
    int[] batchDelete(List<MzPatientDiagnosisEntity> entities);
    
    @ClobFactory
    Clob createClob();
}