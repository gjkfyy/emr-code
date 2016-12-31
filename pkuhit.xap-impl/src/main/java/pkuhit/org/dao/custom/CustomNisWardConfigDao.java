package pkuhit.org.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.org.dao.auto.entity.EiNisWardConfig;
import xap.sv.dao.annotation.RepositoryConfig;
/**
 * @author sun_yuhang
 * 护理病区
 */
@Dao
@RepositoryConfig
public interface CustomNisWardConfigDao {
	@Select
	public List<EiNisWardConfig> selectLikeIps(String ip);
	
	@Select
	List<Map<String, Object>> selectOrgByIp(String ip);
}
