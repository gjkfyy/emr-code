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

import pkuhit.md.dao.auto.entity.MdMrTpCcatItm;

import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface MdMrTpCcatItmDao {

    /**
     * @param mrTpCcatItmCd
     * @return the MdMrTpCcatItm entity
     */
    @Select
    MdMrTpCcatItm selectById(String mrTpCcatItmCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdMrTpCcatItm entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdMrTpCcatItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdMrTpCcatItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdMrTpCcatItm entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdMrTpCcatItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdMrTpCcatItm entity);

    @BatchInsert
    int[] batchInsert(List<MdMrTpCcatItm> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdMrTpCcatItm> entities);

    @BatchDelete
    int[] batchDelete(List<MdMrTpCcatItm> entities);
    
    @ClobFactory
    Clob createClob();
}