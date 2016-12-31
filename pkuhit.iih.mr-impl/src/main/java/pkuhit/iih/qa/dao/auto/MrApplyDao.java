package pkuhit.iih.qa.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import xap.sv.dao.annotation.RepositoryConfig;
import org.seasar.doma.BatchDelete;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.BatchUpdate;
import java.util.List;
import org.seasar.doma.ClobFactory;

import pkuhit.iih.qa.dao.auto.entity.MrApply;

import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface MrApplyDao {

    /**
     * @param applyCd
     * @return the MrApply entity
     */
    @Select
    MrApply selectById(String applyCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrApply entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrApply entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrApply entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrApply entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrApply entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrApply entity);

    @BatchInsert
    int[] batchInsert(List<MrApply> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrApply> entities);

    @BatchDelete
    int[] batchDelete(List<MrApply> entities);
    
    @ClobFactory
    Clob createClob();
}