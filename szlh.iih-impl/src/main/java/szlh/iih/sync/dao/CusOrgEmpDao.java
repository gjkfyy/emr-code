package szlh.iih.sync.dao;

import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;

import szlh.iih.sync.po.XapOrgEmpPo;
import xap.sv.dao.annotation.RepositoryConfig;
@Dao
@RepositoryConfig
public interface CusOrgEmpDao {
	
	@Select 
	List<XapOrgEmpPo> selectAll();
	
	 @Delete
	 int delete(XapOrgEmpPo entity);
	
	 @BatchDelete
	 int[] batchDelete(List<XapOrgEmpPo> entities);

}
