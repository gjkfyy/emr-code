package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrBaseTpl;
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
public interface MrBaseTplDao {

    /**
     * @param mrBaseTplCd
     * @return the MrBaseTpl entity
     */
    @Select
    MrBaseTpl selectById(String mrBaseTplCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrBaseTpl entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrBaseTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrBaseTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrBaseTpl entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrBaseTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrBaseTpl entity);

    @BatchInsert
    int[] batchInsert(List<MrBaseTpl> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrBaseTpl> entities);

    @BatchDelete
    int[] batchDelete(List<MrBaseTpl> entities);
    
    @ClobFactory
    Clob createClob();
}