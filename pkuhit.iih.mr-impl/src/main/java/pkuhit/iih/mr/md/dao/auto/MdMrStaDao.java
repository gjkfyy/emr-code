package pkuhit.iih.mr.md.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrSta;
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
public interface MdMrStaDao {

    /**
     * @param mrStaCd
     * @return the MdMrSta entity
     */
    @Select
    MdMrSta selectById(String mrStaCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdMrSta entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdMrSta entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdMrSta entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdMrSta entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdMrSta entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdMrSta entity);

    @BatchInsert
    int[] batchInsert(List<MdMrSta> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdMrSta> entities);

    @BatchDelete
    int[] batchDelete(List<MdMrSta> entities);
    
    @ClobFactory
    Clob createClob();
}