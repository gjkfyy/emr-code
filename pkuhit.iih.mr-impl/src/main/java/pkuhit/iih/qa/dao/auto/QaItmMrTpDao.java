package pkuhit.iih.qa.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.qa.dao.auto.entity.QaItmMrTp;
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
public interface QaItmMrTpDao {

    /**
     * @param fstCd
     * @param mrTpCd
     * @return the QaItmMrTp entity
     */
    @Select
    QaItmMrTp selectById(String fstCd, String mrTpCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(QaItmMrTp entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(QaItmMrTp entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(QaItmMrTp entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(QaItmMrTp entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(QaItmMrTp entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(QaItmMrTp entity);

    @BatchInsert
    int[] batchInsert(List<QaItmMrTp> entities);

    @BatchUpdate
    int[] batchUpdate(List<QaItmMrTp> entities);

    @BatchDelete
    int[] batchDelete(List<QaItmMrTp> entities);
    
    @ClobFactory
    Clob createClob();
}