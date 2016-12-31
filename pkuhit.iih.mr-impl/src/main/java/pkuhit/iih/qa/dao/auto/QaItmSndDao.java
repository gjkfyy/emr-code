package pkuhit.iih.qa.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.qa.dao.auto.entity.QaItmSnd;
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
public interface QaItmSndDao {

    /**
     * @param sndCd
     * @return the QaItmSnd entity
     */
    @Select
    QaItmSnd selectById(String sndCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(QaItmSnd entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(QaItmSnd entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(QaItmSnd entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(QaItmSnd entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(QaItmSnd entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(QaItmSnd entity);

    @BatchInsert
    int[] batchInsert(List<QaItmSnd> entities);

    @BatchUpdate
    int[] batchUpdate(List<QaItmSnd> entities);

    @BatchDelete
    int[] batchDelete(List<QaItmSnd> entities);
    
    @ClobFactory
    Clob createClob();
}