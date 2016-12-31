package pkuhit.org.dao.auto;

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

import pkuhit.org.dao.auto.entity.EiNisWardConfig;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface EiNisWardConfigDao {

    /**
     * @param deptSn
     * @return the EiNisWardConfig entity
     */
    @Select
    EiNisWardConfig selectById(String deptSn);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(EiNisWardConfig entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(EiNisWardConfig entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(EiNisWardConfig entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(EiNisWardConfig entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(EiNisWardConfig entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(EiNisWardConfig entity);

    @BatchInsert
    int[] batchInsert(List<EiNisWardConfig> entities);

    @BatchUpdate
    int[] batchUpdate(List<EiNisWardConfig> entities);

    @BatchDelete
    int[] batchDelete(List<EiNisWardConfig> entities);
    
    @ClobFactory
    Clob createClob();
}