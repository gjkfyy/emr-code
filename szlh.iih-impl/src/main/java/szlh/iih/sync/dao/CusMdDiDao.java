package szlh.iih.sync.dao;

import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;

import szlh.iih.sync.po.MdDiPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusMdDiDao {
  
	@Select 
	List<MdDiPo> selectAll();
	
	 @Delete
	 int delete(MdDiPo entity);
	
	 @BatchDelete
	 int[] batchDelete(List<MdDiPo> entities);
}
