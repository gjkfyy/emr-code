package ei.en.zy.db.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.en.db.dao.po.PatientPo;

@Dao
@RepositoryConfig
public interface ZyPatientInfoDao {
	@Select
	public List<PatientPo> getPatientDetailForZy(String paId);
}
