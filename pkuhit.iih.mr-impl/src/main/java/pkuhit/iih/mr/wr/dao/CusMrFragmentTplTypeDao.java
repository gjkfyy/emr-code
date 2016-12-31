
package pkuhit.iih.mr.wr.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CusMrFragmentTplTypeDao {

    /**
     * 根据用户id查询个人知识库
     * @param userId
     * @return
     */
	@Select
	List<Map<String, Object>> selectMrFragmentTplType(String userId);
	
	/**
     * 根据用户id查询个人知识库
     * @param userId
     * @return
     */
	@Select
	List<Map<String, Object>> selectMrFragmentTplAllType();
	
}
