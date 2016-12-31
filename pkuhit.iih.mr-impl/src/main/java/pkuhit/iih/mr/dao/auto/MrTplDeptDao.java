package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrTplDept;
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
public interface MrTplDeptDao {

    /**
     * @param mrTplDeptPk
     * @return the MrTplDept entity
     */
    @Select
    MrTplDept selectById(String mrTplDeptPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrTplDept entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrTplDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrTplDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrTplDept entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrTplDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrTplDept entity);

    @BatchInsert
    int[] batchInsert(List<MrTplDept> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrTplDept> entities);

    @BatchDelete
    int[] batchDelete(List<MrTplDept> entities);
    
    @ClobFactory
    Clob createClob();
}