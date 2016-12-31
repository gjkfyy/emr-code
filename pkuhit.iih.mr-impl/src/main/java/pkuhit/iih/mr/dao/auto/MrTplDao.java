package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrTpl;
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
public interface MrTplDao {

    /**
     * @param mrTplCd
     * @return the MrTpl entity
     */
    @Select
    MrTpl selectById(String mrTplCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrTpl entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrTpl entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrTpl entity);

    @BatchInsert
    int[] batchInsert(List<MrTpl> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrTpl> entities);

    @BatchDelete
    int[] batchDelete(List<MrTpl> entities);
    
    @ClobFactory
    Clob createClob();
}