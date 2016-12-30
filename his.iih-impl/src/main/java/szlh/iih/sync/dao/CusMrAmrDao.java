package szlh.iih.sync.dao;

import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.jdbc.SelectOptions;

import szlh.iih.sync.po.MrAmrPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface  CusMrAmrDao {
   
	@Select 
	List<MrAmrPo> selectAll(SelectOptions options);
	
	 @Delete
	 int delete(MrAmrPo entity);
	
	 @BatchDelete
	 int[] batchDelete(List<MrAmrPo> entities);
	 @Update
	 int update(MrAmrPo entity);
}
