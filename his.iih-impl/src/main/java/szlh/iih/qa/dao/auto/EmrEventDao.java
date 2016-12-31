package szlh.iih.qa.dao.auto;

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

import szlh.iih.qa.po.EmrEvent;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface EmrEventDao {

    /**
     * @param eventid
     * @return the EmrEvent entity
     */
    @Select
    EmrEvent selectById(Integer eventid);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(EmrEvent entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(EmrEvent entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(EmrEvent entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(EmrEvent entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(EmrEvent entity);

    @BatchInsert
    int[] batchInsert(List<EmrEvent> entities);

    @BatchUpdate
    int[] batchUpdate(List<EmrEvent> entities);

    @BatchDelete
    int[] batchDelete(List<EmrEvent> entities);
    
    @ClobFactory
    Clob createClob();
}