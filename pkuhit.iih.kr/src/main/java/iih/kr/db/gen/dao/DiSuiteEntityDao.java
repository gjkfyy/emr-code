package iih.kr.db.gen.dao;

import iih.kr.db.gen.entity.DiSuiteEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import xap.sv.dao.annotation.RepositoryConfig;
import org.seasar.doma.BatchDelete;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.BatchUpdate;
import java.util.List;
import org.seasar.doma.ClobFactory;
import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface DiSuiteEntityDao {

    /**
     * @param diSuiteCd
     * @return the DiSuiteEntity entity
     */
    @Select
    DiSuiteEntity selectById(String diSuiteCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(DiSuiteEntity entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(DiSuiteEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(DiSuiteEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(DiSuiteEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(DiSuiteEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(DiSuiteEntity entity);

    @BatchInsert
    int[] batchInsert(List<DiSuiteEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<DiSuiteEntity> entities);

    @BatchDelete
    int[] batchDelete(List<DiSuiteEntity> entities);
    
    @ClobFactory
    Clob createClob();
}