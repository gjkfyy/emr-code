package pkuhit.iih.di.dao.auto;

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

import pkuhit.iih.di.dao.auto.entity.DiIn;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface DiInDao {

    /**
     * @param diSn
     * @return the DiIn entity
     */
    @Select
    DiIn selectById(String diSn);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(DiIn entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(DiIn entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(DiIn entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(DiIn entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(DiIn entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(DiIn entity);

    @BatchInsert
    int[] batchInsert(List<DiIn> entities);

    @BatchUpdate
    int[] batchUpdate(List<DiIn> entities);

    @BatchDelete
    int[] batchDelete(List<DiIn> entities);
    
    @ClobFactory
    Clob createClob();
}