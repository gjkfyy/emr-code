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

import pkuhit.xap.dao.auto.entity.MeCdRu;

import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface MeCdRuDao {

    /**
     * @param objAttrCd
     * @return the MeCdRu entity
     */
    @Select
    MeCdRu selectById(String objAttrCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MeCdRu entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MeCdRu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MeCdRu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MeCdRu entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MeCdRu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MeCdRu entity);

    @BatchInsert
    int[] batchInsert(List<MeCdRu> entities);

    @BatchUpdate
    int[] batchUpdate(List<MeCdRu> entities);

    @BatchDelete
    int[] batchDelete(List<MeCdRu> entities);
    
    @ClobFactory
    Clob createClob();
}