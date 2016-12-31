package pkuhit.iih.mr.tth.dao.auto;

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

import pkuhit.iih.mr.tth.dao.auto.entity.MrTeethExam;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface MrTeethExamDao
{
    /**
     * @param teethPk
     * @return the MrTeethExam entity
     */
    @Select
    MrTeethExam selectById(String teethPk);


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MrTeethExam entity);
    
    /**
     * 为null的字段不会更新到数据表
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull=true)
    int insertExludeNull(MrTeethExam entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MrTeethExam entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull=true)
    int updateExcludeNull(MrTeethExam entity);

    /**
     * 标记删除
     * @param entity
     * 对实体进行标记删除时entity需要设置三个值，updCount，主键，del_f（=1）
     * @return affected rows
     */
    @Update(excludeNull=true)
    int markDelete(MrTeethExam entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MrTeethExam entity);

    @BatchInsert
    int[] batchInsert(List<MrTeethExam> entities);

    @BatchUpdate
    int[] batchUpdate(List<MrTeethExam> entities);

    @BatchDelete
    int[] batchDelete(List<MrTeethExam> entities);
    
    @ClobFactory
    Clob createClob();
}
