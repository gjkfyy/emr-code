package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapPfmlog;
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
public interface XapPfmlogDao {

    /**
     * @param pfmlogPk
     * @return the XapPfmlog entity
     */
    @Select
    XapPfmlog selectById(String pfmlogPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapPfmlog entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapPfmlog entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapPfmlog entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapPfmlog entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapPfmlog entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapPfmlog entity);

    @BatchInsert
    int[] batchInsert(List<XapPfmlog> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapPfmlog> entities);

    @BatchDelete
    int[] batchDelete(List<XapPfmlog> entities);
    
    @ClobFactory
    Clob createClob();
}