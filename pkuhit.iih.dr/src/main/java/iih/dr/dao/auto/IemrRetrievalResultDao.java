package iih.dr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import xap.sv.dao.annotation.RepositoryConfig;
import org.seasar.doma.BatchDelete;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.BatchUpdate;

import iih.dr.dao.auto.entity.IemrRetrievalResult;

import java.util.List;
import org.seasar.doma.ClobFactory;
import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface IemrRetrievalResultDao {

    /**
     * @param resultCd
     * @return the IemrRetrievalResult entity
     */
    @Select
    IemrRetrievalResult selectById(String resultCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(IemrRetrievalResult entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(IemrRetrievalResult entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(IemrRetrievalResult entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(IemrRetrievalResult entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(IemrRetrievalResult entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(IemrRetrievalResult entity);

    @BatchInsert
    int[] batchInsert(List<IemrRetrievalResult> entities);

    @BatchUpdate
    int[] batchUpdate(List<IemrRetrievalResult> entities);

    @BatchDelete
    int[] batchDelete(List<IemrRetrievalResult> entities);
    
    @ClobFactory
    Clob createClob();
}