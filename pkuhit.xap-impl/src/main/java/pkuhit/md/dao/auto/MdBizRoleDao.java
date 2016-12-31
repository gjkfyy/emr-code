package pkuhit.md.dao.auto;

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

import pkuhit.md.dao.auto.entity.MdBizRole;

import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface MdBizRoleDao {

    /**
     * @param bizRoleCd
     * @return the MdBizRole entity
     */
    @Select
    MdBizRole selectById(String bizRoleCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdBizRole entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdBizRole entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdBizRole entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdBizRole entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdBizRole entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdBizRole entity);

    @BatchInsert
    int[] batchInsert(List<MdBizRole> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdBizRole> entities);

    @BatchDelete
    int[] batchDelete(List<MdBizRole> entities);
    
    @ClobFactory
    Clob createClob();
}