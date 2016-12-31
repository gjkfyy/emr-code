package pkuhit.iih.qa.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.qa.dao.auto.entity.QaFltItm;
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
public interface QaFltItmDao {

    /**
     * @param qaFltItmPk
     * @return the QaFltItm entity 
     */
    @Select
    QaFltItm selectById(String qaFltItmPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(QaFltItm entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(QaFltItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(QaFltItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(QaFltItm entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(QaFltItm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(QaFltItm entity);

    @BatchInsert
    int[] batchInsert(List<QaFltItm> entities);

    @BatchUpdate
    int[] batchUpdate(List<QaFltItm> entities);

    @BatchDelete
    int[] batchDelete(List<QaFltItm> entities);
    
    @ClobFactory
    Clob createClob();
}