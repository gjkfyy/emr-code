package ei.en.mz.db.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.en.db.dao.po.PatientPo;

@Dao
@RepositoryConfig
public interface MzPatientInfoDao {
	 
	@Select
	public List<PatientPo> getPatientDetailForMz(String paId);
}
