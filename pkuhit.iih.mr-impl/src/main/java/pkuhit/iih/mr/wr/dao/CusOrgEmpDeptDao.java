
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
public interface CusOrgEmpDeptDao {

	@Select
	List<Map<String,Object>> selectByDeptCdAndEmpId(String deptCd, String empId);
}
