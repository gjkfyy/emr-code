package szlh.iih.qa.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import szlh.iih.qa.po.EmrEvent;
import szlh.iih.sync.po.MdDiPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface  AutoQaTaskDao {
	
	/**  
	 * 
	 * @param encId
	 * @return
	 */
	@Select 
	List<EmrEvent> selectEmrEventsByTime(String startTime,String endTime);
	

}
