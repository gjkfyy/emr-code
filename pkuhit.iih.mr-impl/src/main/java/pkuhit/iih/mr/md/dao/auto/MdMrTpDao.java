package pkuhit.iih.mr.md.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
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
public interface MdMrTpDao {

    /**
     * @param mrTpCd
     * @return the MdMrTp entity
     */
    @Select
    MdMrTp selectById(String mrTpCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdMrTp entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdMrTp entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdMrTp entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdMrTp entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdMrTp entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdMrTp entity);

    @BatchInsert
    int[] batchInsert(List<MdMrTp> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdMrTp> entities);

    @BatchDelete
    int[] batchDelete(List<MdMrTp> entities);
    
    @ClobFactory
    Clob createClob();
}