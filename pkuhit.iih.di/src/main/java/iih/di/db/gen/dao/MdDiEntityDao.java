package iih.di.db.gen.dao;

import iih.di.db.gen.entity.MdDiEntity;
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
import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface MdDiEntityDao {

    /**
     * @param diCd
     * @return the MdDiEntity entity
     */
    @Select
    MdDiEntity selectById(String diCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdDiEntity entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdDiEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdDiEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdDiEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdDiEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdDiEntity entity);

    @BatchInsert
    int[] batchInsert(List<MdDiEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdDiEntity> entities);

    @BatchDelete
    int[] batchDelete(List<MdDiEntity> entities);
    
    @ClobFactory
    Clob createClob();
}