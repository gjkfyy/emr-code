package pkuhit.iih.qa.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.qa.dao.auto.entity.QaItmFst;
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
public interface QaItmFstDao {

    /**
     * @param fstCd
     * @return the QaItmFst entity
     */
    @Select
    QaItmFst selectById(String fstCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(QaItmFst entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(QaItmFst entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(QaItmFst entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(QaItmFst entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(QaItmFst entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(QaItmFst entity);

    @BatchInsert
    int[] batchInsert(List<QaItmFst> entities);

    @BatchUpdate
    int[] batchUpdate(List<QaItmFst> entities);

    @BatchDelete
    int[] batchDelete(List<QaItmFst> entities);
    
    @ClobFactory
    Clob createClob();
}