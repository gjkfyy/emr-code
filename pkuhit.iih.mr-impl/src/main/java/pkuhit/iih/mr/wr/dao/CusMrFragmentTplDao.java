
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
public interface CusMrFragmentTplDao {

    /**
     * 根据用户id查询个人知识库
     * @param userId
     * @return
     */
	@Select
	List<Map<String, Object>> selectMrFragmentTpl(String userId,String deptCd,String ownerTypeCd,String inName,String keyword);
	/**
     * @param fragmentTplCd
     */
    @Select
    Map<String, Object> selectById(String fragmentTplCd);
    
    /**
     * 根据用户id查询个人知识库
     * @param ownerCd
     * @param keyword
     * @param fragmentTplTypeCd
     * @return
     */
	@Select
	List<Map<String, Object>> selectMrFragmentTplByCondition(String ownerCd,String keyword,String fragmentTplTypeCd);
}
