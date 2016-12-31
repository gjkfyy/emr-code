package pkuhit.org.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.org.dao.auto.entity.WardDept;
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
public interface WardDeptDao {

    /**
     * @param deptCd
     * @return the WardDept entity
     */
    @Select
    WardDept selectById(String deptCd);
 

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(WardDept entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(WardDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(WardDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(WardDept entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(WardDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(WardDept entity);

    @BatchInsert
    int[] batchInsert(List<WardDept> entities);

    @BatchUpdate
    int[] batchUpdate(List<WardDept> entities);

    @BatchDelete
    int[] batchDelete(List<WardDept> entities);
    
    @ClobFactory
    Clob createClob();
}