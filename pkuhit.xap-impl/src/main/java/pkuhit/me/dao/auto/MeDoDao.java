package pkuhit.me.dao.auto;

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

import pkuhit.me.dao.auto.entity.MeDo;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface MeDoDao {

    /**
     * @param doCd
     * @return the MeDo entity
     */
    @Select
    MeDo selectById(String doCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MeDo entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MeDo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MeDo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MeDo entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MeDo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MeDo entity);

    @BatchInsert
    int[] batchInsert(List<MeDo> entities);

    @BatchUpdate
    int[] batchUpdate(List<MeDo> entities);

    @BatchDelete
    int[] batchDelete(List<MeDo> entities);
    
    @ClobFactory
    Clob createClob();
}