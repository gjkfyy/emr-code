package szlh.iih.sync.dao;

import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;
import szlh.iih.sync.po.OrgPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusOrgDao {
	
	@Select 
	List<OrgPo> selectAll();
	
	 @Delete
	 int delete(OrgPo entity);
	
	 @BatchDelete
	 int[] batchDelete(List<OrgPo> entities);

}
