package szlh.iih.mr.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import szlh.iih.mr.po.IemrDocContent;
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
public interface IemrDocContentDao {

    /**
     * @param id
     * @return the IemrDocContent entity
     */
    @Select
    IemrDocContent selectById(Integer id);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(IemrDocContent entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(IemrDocContent entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(IemrDocContent entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(IemrDocContent entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(IemrDocContent entity);

    @BatchInsert
    int[] batchInsert(List<IemrDocContent> entities);

    @BatchUpdate
    int[] batchUpdate(List<IemrDocContent> entities);

    @BatchDelete
    int[] batchDelete(List<IemrDocContent> entities);
    
    @ClobFactory
    Clob createClob();
}