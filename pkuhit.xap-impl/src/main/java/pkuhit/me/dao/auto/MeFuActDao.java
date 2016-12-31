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

import pkuhit.me.dao.auto.entity.MeFuAct;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface MeFuActDao {

    /**
     * @param fuActCd
     * @return the MeFuAct entity
     */
    @Select
    MeFuAct selectById(String fuActCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MeFuAct entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MeFuAct entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MeFuAct entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MeFuAct entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MeFuAct entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MeFuAct entity);

    @BatchInsert
    int[] batchInsert(List<MeFuAct> entities);

    @BatchUpdate
    int[] batchUpdate(List<MeFuAct> entities);

    @BatchDelete
    int[] batchDelete(List<MeFuAct> entities);
    
    @ClobFactory
    Clob createClob();
}