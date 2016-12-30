package szlh.iih.qa.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import szlh.iih.qa.po.EmrEvent;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface  CusQaAutoEventDao {
	
	/**
	 * 
	 * @param encId
	 * @return
	 */
	@Select 
	List<EmrEvent> selectEmrEvents(String encId);
	

}
