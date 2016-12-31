package ei.iih.db.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import ei.iih.db.dao.auto.entity.VwNisWardConfig;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface VwNisWardConfigDao {
	
	 @Select
	 List<VwNisWardConfig> selectNisWarkConfigs();
}
