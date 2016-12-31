package ei.en.zy.db.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.en.db.dao.po.VwEnZyPo;

@Dao
@RepositoryConfig
public interface  ZyCusViewEnDao {
   
	@Select 
	VwEnZyPo getViewEnZyPoByEnPk(String enPk,String patientId ,String times);
	
}
