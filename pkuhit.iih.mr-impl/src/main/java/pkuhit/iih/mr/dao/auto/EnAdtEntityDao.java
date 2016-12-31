package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.EnAdtEntity;
import xap.sv.dao.annotation.RepositoryConfig;
import org.seasar.doma.BatchDelete;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.BatchUpdate;
import java.util.List;
import org.seasar.doma.ClobFactory;
import java.sql.Clob;


/**
 *  转科记录本地查询
 */
@Dao
@RepositoryConfig
public interface EnAdtEntityDao {

    /**
     * @param enAdtCd
     * @return the EnAdtEntity entity
     */
    @Select
    EnAdtEntity selectById(String enAdtCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(EnAdtEntity entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(EnAdtEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(EnAdtEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(EnAdtEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(EnAdtEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(EnAdtEntity entity);

    @BatchInsert
    int[] batchInsert(List<EnAdtEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<EnAdtEntity> entities);

    @BatchDelete
    int[] batchDelete(List<EnAdtEntity> entities);
    
    @ClobFactory
    Clob createClob();
}