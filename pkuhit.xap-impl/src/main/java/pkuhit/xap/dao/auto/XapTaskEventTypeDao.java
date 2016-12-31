package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapTaskEventType;
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
public interface XapTaskEventTypeDao {

    /**
     * @param taskEventTypeCd
     * @return the XapTaskEventType entity
     */
    @Select
    XapTaskEventType selectById(String taskEventTypeCd);
 

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapTaskEventType entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapTaskEventType entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapTaskEventType entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapTaskEventType entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapTaskEventType entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapTaskEventType entity);

    @BatchInsert
    int[] batchInsert(List<XapTaskEventType> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapTaskEventType> entities);

    @BatchDelete
    int[] batchDelete(List<XapTaskEventType> entities);
    
    @ClobFactory
    Clob createClob();
}