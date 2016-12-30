package szlh.iih.sync.dao;

import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;
import szlh.iih.sync.po.WardDeptPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusWardDeptDao {
	@Select 
	List<WardDeptPo> selectAll();
	
	 @Delete
	 int delete(WardDeptPo entity);
	
	 @BatchDelete
	 int[] batchDelete(List<WardDeptPo> entities);
}
