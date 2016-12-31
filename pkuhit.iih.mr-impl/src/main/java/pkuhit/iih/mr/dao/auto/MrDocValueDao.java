package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrDocValue;
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
public interface MrDocValueDao {

    /**
     * @param encounterSn
     * @return the MrDocValue entity
     */
    @Select
    MrDocValue selectById(String mrbMrDocValueId);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrDocValue entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrDocValue entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrDocValue entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrDocValue entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrDocValue entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrDocValue entity);

    @BatchInsert
    int[] batchInsert(List<MrDocValue> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrDocValue> entities);

    @BatchDelete
    int[] batchDelete(List<MrDocValue> entities);
    
    @ClobFactory
    Clob createClob();
}