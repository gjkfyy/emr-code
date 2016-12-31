package pkuhit.iih.mr.md.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrShareElement;
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
public interface MdMrShareElementDao {

    /**
     * @param mrShareElementCd
     * @return the MdMrShareElement entity
     */
    @Select
    MdMrShareElement selectById(String mrShareElementCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MdMrShareElement entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MdMrShareElement entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MdMrShareElement entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MdMrShareElement entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MdMrShareElement entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MdMrShareElement entity);

    @BatchInsert
    int[] batchInsert(List<MdMrShareElement> entities);

    @BatchUpdate
    int[] batchUpdate(List<MdMrShareElement> entities);

    @BatchDelete
    int[] batchDelete(List<MdMrShareElement> entities);
    
    @ClobFactory
    Clob createClob();
}