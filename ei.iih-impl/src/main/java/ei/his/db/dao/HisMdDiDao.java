package ei.his.db.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.his.db.dao.auto.entity.HisMdDi;


@Dao
@RepositoryConfig()
public interface HisMdDiDao {
 
	@Select 
	List<HisMdDi> selectHisMdDi();

}
