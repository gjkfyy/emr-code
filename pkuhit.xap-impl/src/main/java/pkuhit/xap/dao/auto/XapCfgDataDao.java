package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapCfgData;
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
public interface XapCfgDataDao {

    /**
     * @param cfgDataCd
     * @return the XapCfgData entity
     */
    @Select
    XapCfgData selectById(String cfgDataCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapCfgData entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapCfgData entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapCfgData entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapCfgData entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapCfgData entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapCfgData entity);

    @BatchInsert
    int[] batchInsert(List<XapCfgData> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapCfgData> entities);

    @BatchDelete
    int[] batchDelete(List<XapCfgData> entities);
    
    @ClobFactory
    Clob createClob();
}