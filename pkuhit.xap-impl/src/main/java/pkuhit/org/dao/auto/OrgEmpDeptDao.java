package pkuhit.org.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.org.dao.auto.entity.OrgEmpDept;
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
public interface OrgEmpDeptDao {

    /**
     * @param empDeptCd
     * @return the OrgEmpDept entity
     */
    @Select
    OrgEmpDept selectById(String empDeptCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(OrgEmpDept entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(OrgEmpDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(OrgEmpDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(OrgEmpDept entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(OrgEmpDept entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(OrgEmpDept entity);

    @BatchInsert
    int[] batchInsert(List<OrgEmpDept> entities);

    @BatchUpdate
    int[] batchUpdate(List<OrgEmpDept> entities);

    @BatchDelete
    int[] batchDelete(List<OrgEmpDept> entities);
    
    @ClobFactory
    Clob createClob();
}