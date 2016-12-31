package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapRoleAct;
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
public interface XapRoleActDao {

    /**
     * @param roleActCd
     * @return the XapRoleAct entity
     */
    @Select
    XapRoleAct selectById(String roleActCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapRoleAct entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapRoleAct entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapRoleAct entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapRoleAct entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapRoleAct entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapRoleAct entity);

    @BatchInsert
    int[] batchInsert(List<XapRoleAct> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapRoleAct> entities);

    @BatchDelete
    int[] batchDelete(List<XapRoleAct> entities);
    
    @ClobFactory
    Clob createClob();
}