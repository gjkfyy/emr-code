package iih.kr.db.gen.dao;

import iih.kr.db.gen.entity.DiSuiteTemplateEntity;
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
import java.sql.Clob;


/**
 */
@Dao
@RepositoryConfig
public interface DiSuiteTemplateEntityDao {

    /**
     * @param diSuiteTemplateCd
     * @return the DiSuiteTemplateEntity entity
     */
    @Select
    DiSuiteTemplateEntity selectById(String diSuiteTemplateCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(DiSuiteTemplateEntity entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(DiSuiteTemplateEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(DiSuiteTemplateEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(DiSuiteTemplateEntity entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(DiSuiteTemplateEntity entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(DiSuiteTemplateEntity entity);

    @BatchInsert
    int[] batchInsert(List<DiSuiteTemplateEntity> entities);

    @BatchUpdate
    int[] batchUpdate(List<DiSuiteTemplateEntity> entities);

    @BatchDelete
    int[] batchDelete(List<DiSuiteTemplateEntity> entities);
    
    @ClobFactory
    Clob createClob();
}