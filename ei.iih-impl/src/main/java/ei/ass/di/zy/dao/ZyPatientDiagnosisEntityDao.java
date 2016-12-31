package ei.ass.di.zy.dao;

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

import xap.sv.dao.annotation.RepositoryConfig;
import ei.ass.di.auto.po.ZyPatientDiagnosisEntity;


/**
 */
@Dao
@RepositoryConfig
public interface ZyPatientDiagnosisEntityDao {

    /**
     * @param sn
     * @return the ZyPatientDiagnosisEntity entity
     */
    @Select
    ZyPatientDiagnosisEntity selectById(Integer sn);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(ZyPatientDiagnosisEntity entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(ZyPatientDiagnosisEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(ZyPatientDiagnosisEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(ZyPatientDiagnosisEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(ZyPatientDiagnosisEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(ZyPatientDiagnosisEntity entity);

    @BatchInsert
    int[] batchInsert(List<ZyPatientDiagnosisEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<ZyPatientDiagnosisEntity> entities);

    @BatchDelete
    int[] batchDelete(List<ZyPatientDiagnosisEntity> entities);
    
    @ClobFactory
    Clob createClob();
}