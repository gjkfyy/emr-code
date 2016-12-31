package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.ObsReportCollectEntity;
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
public interface ObsReportCollectEntityDao {

    /**
     * @param obRpPk
     * @return the ObsReportCollectEntity entity
     */
    @Select
    ObsReportCollectEntity selectById(String obRpPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(ObsReportCollectEntity entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(ObsReportCollectEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(ObsReportCollectEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(ObsReportCollectEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(ObsReportCollectEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(ObsReportCollectEntity entity);

    @BatchInsert
    int[] batchInsert(List<ObsReportCollectEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<ObsReportCollectEntity> entities);

    @BatchDelete
    int[] batchDelete(List<ObsReportCollectEntity> entities);
    
    @ClobFactory
    Clob createClob();
}