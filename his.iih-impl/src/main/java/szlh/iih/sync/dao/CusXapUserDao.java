package szlh.iih.sync.dao;

import java.util.List;

import org.seasar.doma.BatchDelete;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import szlh.iih.sync.po.XapUserPo;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusXapUserDao {
 
	@Select 
	List<XapUserPo> selectAll(SelectOptions options);
	
	 @Delete
	 int delete(XapUserPo entity);
	
	 @BatchDelete
	 int[] batchDelete(List<XapUserPo> entities);
}
