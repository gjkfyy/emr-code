package szlh.iih.sync.dao;

import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;
import szlh.iih.sync.po.OrgEmpDeptPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusOrgEmpDeptDao {
	@Select 
	List<OrgEmpDeptPo> selectAll();
	
	 @Delete
	 int delete(OrgEmpDeptPo entity);
	
	 @BatchDelete
	 int[] batchDelete(List<OrgEmpDeptPo> entities);
}
