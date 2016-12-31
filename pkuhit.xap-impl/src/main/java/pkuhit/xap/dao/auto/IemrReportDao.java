package pkuhit.xap.dao.auto;

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

import pkuhit.xap.dao.auto.entity.IemrReport;

import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface IemrReportDao {

    /**
     * @param id
     * @return the IemrReport entity
     */
    @Select
    IemrReport selectById(String id);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(IemrReport entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(IemrReport entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(IemrReport entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(IemrReport entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(IemrReport entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(IemrReport entity);

    @BatchInsert
    int[] batchInsert(List<IemrReport> entities);

    @BatchUpdate
    int[] batchUpdate(List<IemrReport> entities);

    @BatchDelete
    int[] batchDelete(List<IemrReport> entities);
    
    @ClobFactory
    Clob createClob();
}