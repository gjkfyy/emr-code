package pkuhit.iih.mr.md.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpSeg;
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
public interface MdMrTpSegDao {

    /**
     * @param mrTpSegCd
     * @return the MdMrTpSeg entity
     */
    @Select
    MdMrTpSeg selectById(String mrTpSegCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdMrTpSeg entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdMrTpSeg entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdMrTpSeg entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdMrTpSeg entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdMrTpSeg entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdMrTpSeg entity);

    @BatchInsert
    int[] batchInsert(List<MdMrTpSeg> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdMrTpSeg> entities);

    @BatchDelete
    int[] batchDelete(List<MdMrTpSeg> entities);
    
    @ClobFactory
    Clob createClob();
}