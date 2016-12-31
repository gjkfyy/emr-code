package ei.cis.db.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CisMzClinicRoomConfigDao
{
    @Select
    List<Map<String,Object>> selectOrgByIp(String ip);
}
