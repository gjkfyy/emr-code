package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapTask;
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
public interface XapTaskDao {

    /** 
     * @param taskId
     * @return the XapTask entity
     */
    @Select
    XapTask selectById(String taskId);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapTask entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapTask entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapTask entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapTask entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapTask entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapTask entity);

    @BatchInsert
    int[] batchInsert(List<XapTask> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapTask> entities);

    @BatchDelete
    int[] batchDelete(List<XapTask> entities);
    
    @ClobFactory
    Clob createClob();
}