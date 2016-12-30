package szlh.iih.mr.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import szlh.iih.mr.po.IemrDocContent;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusIemrDocContentDao {

	@Select
	public List<IemrDocContent> selectByDocId(String docId);
}
