package pkuhit.iih.mr.dao.auto;

import java.sql.Clob;
import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.BatchUpdate;
import org.seasar.doma.ClobFactory;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import pkuhit.iih.mr.dao.auto.entity.MrPara;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface MrParaDao {

    /**
     * @param paraPk
     * @return the MrPara entity
     */
    @Select
    MrPara selectById(String paraPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrPara entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrPara entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrPara entity);

    @BatchInsert
    int[] batchInsert(List<MrPara> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrPara> entities);

    @BatchDelete
    int[] batchDelete(List<MrPara> entities);
    
    @ClobFactory
    Clob createClob();
}