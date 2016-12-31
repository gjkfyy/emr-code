package pkuhit.me.dao.auto;

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

import pkuhit.me.dao.auto.entity.MeFuEv;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface MeFuEvDao {

    /**
     * @param fuEvCd
     * @return the MeFuEv entity
     */
    @Select
    MeFuEv selectById(String fuEvCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MeFuEv entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MeFuEv entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MeFuEv entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MeFuEv entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MeFuEv entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MeFuEv entity);

    @BatchInsert
    int[] batchInsert(List<MeFuEv> entities);

    @BatchUpdate
    int[] batchUpdate(List<MeFuEv> entities);

    @BatchDelete
    int[] batchDelete(List<MeFuEv> entities);
    
    @ClobFactory
    Clob createClob();
}