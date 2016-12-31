package pkuhit.iih.mr.md.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement;
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
public interface MdMetaElementDao {

    /**
     * @param dataElementCd
     * @return the MdMetaElement entity
     */
    @Select
    MdMetaElement selectById(String dataElementCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdMetaElement entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdMetaElement entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdMetaElement entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdMetaElement entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdMetaElement entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdMetaElement entity);

    @BatchInsert
    int[] batchInsert(List<MdMetaElement> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdMetaElement> entities);

    @BatchDelete
    int[] batchDelete(List<MdMetaElement> entities);
    
    @ClobFactory
    Clob createClob();
}