package pkuhit.org.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import pkuhit.org.dao.auto.entity.Ward;
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
public interface WardDao {


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Ward entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(Ward entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Ward entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(Ward entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(Ward entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Ward entity);

    @BatchInsert
    int[] batchInsert(List<Ward> entities);

    @BatchUpdate
    int[] batchUpdate(List<Ward> entities);

    @BatchDelete
    int[] batchDelete(List<Ward> entities);
    
    @ClobFactory
    Clob createClob();
}