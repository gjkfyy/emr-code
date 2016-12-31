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

import pkuhit.iih.mr.dao.auto.entity.MdMrPara;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface MdMrParaDao {

    /**
     * @param mdMrParaCd
     * @return the MdMrPara entity
     */
    @Select
    MdMrPara selectById(String mdMrParaCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdMrPara entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdMrPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdMrPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdMrPara entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdMrPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdMrPara entity);

    @BatchInsert
    int[] batchInsert(List<MdMrPara> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdMrPara> entities);

    @BatchDelete
    int[] batchDelete(List<MdMrPara> entities);
    
    @ClobFactory
    Clob createClob();
}