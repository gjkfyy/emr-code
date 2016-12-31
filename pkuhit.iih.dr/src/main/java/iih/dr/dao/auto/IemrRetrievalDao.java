package iih.dr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import iih.dr.dao.auto.entity.IemrRetrieval;
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
public interface IemrRetrievalDao {

    /**
     * @param retrievalCd
     * @return the IemrRetrieval entity
     */
    @Select
    IemrRetrieval selectById(String retrievalCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(IemrRetrieval entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(IemrRetrieval entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(IemrRetrieval entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(IemrRetrieval entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(IemrRetrieval entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(IemrRetrieval entity);

    @BatchInsert
    int[] batchInsert(List<IemrRetrieval> entities);

    @BatchUpdate
    int[] batchUpdate(List<IemrRetrieval> entities);

    @BatchDelete
    int[] batchDelete(List<IemrRetrieval> entities);
    
    @ClobFactory
    Clob createClob();
}