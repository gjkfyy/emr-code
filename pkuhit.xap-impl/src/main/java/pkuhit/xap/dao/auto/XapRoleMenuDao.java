package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapRoleMenu;
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
public interface XapRoleMenuDao {

    /**
     * @param roleMenuCd
     * @return the XapRoleMenu entity
     */ 
    @Select
    XapRoleMenu selectById(String roleMenuCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapRoleMenu entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapRoleMenu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapRoleMenu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapRoleMenu entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapRoleMenu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapRoleMenu entity);

    @BatchInsert
    int[] batchInsert(List<XapRoleMenu> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapRoleMenu> entities);

    @BatchDelete
    int[] batchDelete(List<XapRoleMenu> entities);
    
    @ClobFactory
    Clob createClob();
}