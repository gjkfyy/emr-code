package pkuhit.iih.qa.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.qa.dao.auto.entity.QaSys;
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
public interface QaSysDao {

    /**
     * @param qaSysCd
     * @return the QaSys entity
     */
    @Select
    QaSys selectById(String qaSysCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(QaSys entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(QaSys entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(QaSys entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(QaSys entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(QaSys entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(QaSys entity);

    @BatchInsert
    int[] batchInsert(List<QaSys> entities);

    @BatchUpdate
    int[] batchUpdate(List<QaSys> entities);

    @BatchDelete
    int[] batchDelete(List<QaSys> entities);
    
    @ClobFactory
    Clob createClob();
}