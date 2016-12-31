package pkuhit.me.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.me.dao.auto.entity.MeObj;
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
public interface MeObjDao {

    /**
     * @param objCd
     * @return the MeObj entity
     */
    @Select
    MeObj selectById(String objCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MeObj entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MeObj entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MeObj entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MeObj entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MeObj entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MeObj entity);

    @BatchInsert
    int[] batchInsert(List<MeObj> entities);

    @BatchUpdate
    int[] batchUpdate(List<MeObj> entities);

    @BatchDelete
    int[] batchDelete(List<MeObj> entities);
    
    @ClobFactory
    Clob createClob();
}