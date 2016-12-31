package iih.di.db.gen.dao;

import iih.di.db.gen.entity.DiEntity;
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
public interface DiEntityDao {

    /**
     * @param diSn
     * @return the DiEntity entity
     */
    @Select
    DiEntity selectById(String diSn);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(DiEntity entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(DiEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(DiEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(DiEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(DiEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(DiEntity entity);

    @BatchInsert
    int[] batchInsert(List<DiEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<DiEntity> entities);

    @BatchDelete
    int[] batchDelete(List<DiEntity> entities);
    
    @ClobFactory
    Clob createClob();
}