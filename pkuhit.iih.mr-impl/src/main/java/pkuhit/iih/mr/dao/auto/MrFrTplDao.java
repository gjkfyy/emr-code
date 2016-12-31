package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrFrTpl;
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
public interface MrFrTplDao {

    /**
     * @param mrFrTplCd
     * @return the MrFrTpl entity
     */
    @Select
    MrFrTpl selectById(String mrFrTplCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrFrTpl entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrFrTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrFrTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrFrTpl entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrFrTpl entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrFrTpl entity);

    @BatchInsert
    int[] batchInsert(List<MrFrTpl> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrFrTpl> entities);

    @BatchDelete
    int[] batchDelete(List<MrFrTpl> entities);
    
    @ClobFactory
    Clob createClob();
}