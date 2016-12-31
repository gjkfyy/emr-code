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

import pkuhit.iih.mr.dao.auto.entity.MrSplFm;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface MrSplFmDao {

    /**
     * @param splFmCd
     * @return the MrSplFm entity
     */
    @Select
    MrSplFm selectById(String splFmCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrSplFm entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrSplFm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrSplFm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrSplFm entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrSplFm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrSplFm entity);

    @BatchInsert
    int[] batchInsert(List<MrSplFm> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrSplFm> entities);

    @BatchDelete
    int[] batchDelete(List<MrSplFm> entities);
    
    @ClobFactory
    Clob createClob();
}