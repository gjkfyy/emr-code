package ei.en.mz.db.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.en.db.dao.po.VwEnMzPo;
import ei.en.db.dao.po.VwEnZyPo;

@Dao
@RepositoryConfig
public interface  MzCusViewEnDao {
   
	@Select 
	VwEnMzPo getViewEnMzPoByEnPk(String enPk,String patientId ,String times);
	
}
