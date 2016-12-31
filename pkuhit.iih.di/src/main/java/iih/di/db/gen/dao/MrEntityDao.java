package iih.di.db.gen.dao;

import iih.di.db.gen.entity.MrEntity;
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
public interface MrEntityDao {

    /**
     * @param mrPk
     * @return the MrEntity entity
     */
    @Select
    MrEntity selectById(String mrPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrEntity entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrEntity entity);

    @BatchInsert
    int[] batchInsert(List<MrEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrEntity> entities);

    @BatchDelete
    int[] batchDelete(List<MrEntity> entities);
    
    @ClobFactory
    Clob createClob();
}