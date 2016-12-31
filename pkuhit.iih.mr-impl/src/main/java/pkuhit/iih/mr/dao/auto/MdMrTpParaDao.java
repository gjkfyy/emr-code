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

import pkuhit.iih.mr.dao.auto.entity.MdMrTpPara;
import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface MdMrTpParaDao {

    /**
     * @param mdMrTpParaPk
     * @return the MdMrTpPara entity
     */
    @Select
    MdMrTpPara selectById(String mdMrTpParaPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdMrTpPara entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdMrTpPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdMrTpPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdMrTpPara entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdMrTpPara entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdMrTpPara entity);

    @BatchInsert
    int[] batchInsert(List<MdMrTpPara> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdMrTpPara> entities);

    @BatchDelete
    int[] batchDelete(List<MdMrTpPara> entities);
    
    @ClobFactory
    Clob createClob();
}