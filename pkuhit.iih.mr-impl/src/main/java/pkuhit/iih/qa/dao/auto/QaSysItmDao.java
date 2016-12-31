package pkuhit.iih.qa.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.qa.dao.auto.entity.QaSysItm;
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
public interface QaSysItmDao {

    /**
     * @param qaSysItmCd
     * @return the QaSysItm entity
     */
    @Select
    QaSysItm selectById(String qaSysItmCd);

 
    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(QaSysItm entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(QaSysItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(QaSysItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(QaSysItm entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(QaSysItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(QaSysItm entity);

    @BatchInsert
    int[] batchInsert(List<QaSysItm> entities);

    @BatchUpdate
    int[] batchUpdate(List<QaSysItm> entities);

    @BatchDelete
    int[] batchDelete(List<QaSysItm> entities);
    
    @ClobFactory
    Clob createClob();
}