package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapRolePortal;
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
public interface XapRolePortalDao {

    /**
     * @param rolePoCd
     * @return the XapRolePortal entity
     */
    @Select
    XapRolePortal selectById(String rolePoCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapRolePortal entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapRolePortal entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapRolePortal entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapRolePortal entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapRolePortal entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapRolePortal entity);

    @BatchInsert
    int[] batchInsert(List<XapRolePortal> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapRolePortal> entities);

    @BatchDelete
    int[] batchDelete(List<XapRolePortal> entities);
    
    @ClobFactory
    Clob createClob();
}