package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrTransDept;
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
public interface MrTransDeptDao {

    /**
     * @param mrTransDeptPk
     * @return the MrTransDept entity
     */
    @Select
    MrTransDept selectById(String mrTransDeptPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrTransDept entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrTransDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrTransDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrTransDept entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrTransDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrTransDept entity);

    @BatchInsert
    int[] batchInsert(List<MrTransDept> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrTransDept> entities);

    @BatchDelete
    int[] batchDelete(List<MrTransDept> entities);
    
    @ClobFactory
    Clob createClob();
}