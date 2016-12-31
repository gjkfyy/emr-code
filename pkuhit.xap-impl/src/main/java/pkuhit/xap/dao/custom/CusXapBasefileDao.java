package pkuhit.xap.dao.custom;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.xap.dao.auto.entity.XapBasefile;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 自定义文件访问 dao
 */
@Dao
@RepositoryConfig
public interface CusXapBasefileDao {
    /**
     * @param filePk
     * @return the XapBasefile entity
     */
    @Select
    XapBasefile selectByIdForUpdate(String filePk);
}
