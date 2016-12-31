package pkuhit.iih.mr.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.dao.auto.entity.MrPrintOpLog;
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
public interface MrPrintOpLogDao {

    /**
     * @param printLogCd
     * @return the MrPrintOpLog entity
     */
    @Select
    MrPrintOpLog selectById(String printLogCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrPrintOpLog entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrPrintOpLog entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrPrintOpLog entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrPrintOpLog entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrPrintOpLog entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrPrintOpLog entity);

    @BatchInsert
    int[] batchInsert(List<MrPrintOpLog> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrPrintOpLog> entities);

    @BatchDelete
    int[] batchDelete(List<MrPrintOpLog> entities);
    
    @ClobFactory
    Clob createClob();
}