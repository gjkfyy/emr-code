package ei.cis.db.dao;

import java.sql.Blob;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CisSignPicDao
{
    @Select
    Blob selectUserImg(String empSn);
}
