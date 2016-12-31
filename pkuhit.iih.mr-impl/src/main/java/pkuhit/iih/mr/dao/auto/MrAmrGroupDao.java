package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrAmrGroup;
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
public interface MrAmrGroupDao {

    /**
     * @param mrAmrGroupCd
     * @return the MrAmrGroup entity
     */
    @Select
    MrAmrGroup selectById(String mrAmrGroupCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrAmrGroup entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrAmrGroup entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrAmrGroup entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrAmrGroup entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrAmrGroup entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrAmrGroup entity);

    @BatchInsert
    int[] batchInsert(List<MrAmrGroup> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrAmrGroup> entities);

    @BatchDelete
    int[] batchDelete(List<MrAmrGroup> entities);
    
    @ClobFactory
    Clob createClob();
}