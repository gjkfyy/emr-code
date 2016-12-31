package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapRoleFu;
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
public interface XapRoleFuDao {

    /**
     * @param roleFuCd
     * @return the XapRoleFu entity
     */
    @Select
    XapRoleFu selectById(String roleFuCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapRoleFu entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapRoleFu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapRoleFu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapRoleFu entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapRoleFu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapRoleFu entity);

    @BatchInsert
    int[] batchInsert(List<XapRoleFu> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapRoleFu> entities);

    @BatchDelete
    int[] batchDelete(List<XapRoleFu> entities);
    
    @ClobFactory
    Clob createClob();
}