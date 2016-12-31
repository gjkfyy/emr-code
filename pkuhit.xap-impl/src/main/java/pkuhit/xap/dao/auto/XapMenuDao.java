package pkuhit.xap.dao.auto;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import pkuhit.xap.dao.auto.entity.XapMenu;
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
public interface XapMenuDao {

    /**
     * @param menuCd
     * @return the XapMenu entity
     */
    @Select
    XapMenu selectById(String menuCd);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(XapMenu entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(XapMenu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(XapMenu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(XapMenu entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(XapMenu entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(XapMenu entity);

    @BatchInsert
    int[] batchInsert(List<XapMenu> entities);

    @BatchUpdate
    int[] batchUpdate(List<XapMenu> entities);

    @BatchDelete
    int[] batchDelete(List<XapMenu> entities);
    
    @ClobFactory
    Clob createClob();
}