package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrSign;
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
public interface MrSignDao {

    /**
     * @param mrSignPk
     * @return the MrSign entity
     */
    @Select
    MrSign selectById(String mrSignPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrSign entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrSign entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrSign entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrSign entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrSign entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrSign entity);

    @BatchInsert
    int[] batchInsert(List<MrSign> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrSign> entities);

    @BatchDelete
    int[] batchDelete(List<MrSign> entities);
    
    @ClobFactory
    Clob createClob();
}