package pkuhit.md.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.md.dao.auto.entity.MdDi;
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
public interface MdDiDao {

    /**
     * @param diCd
     * @return the MdDi entity
     */
    @Select
    MdDi selectById(String diCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdDi entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdDi entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdDi entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdDi entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdDi entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdDi entity);

    @BatchInsert
    int[] batchInsert(List<MdDi> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdDi> entities);

    @BatchDelete
    int[] batchDelete(List<MdDi> entities);
    
    @ClobFactory
    Clob createClob();
}