package pkuhit.xap.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.org.dao.auto.entity.OrgEmpDept;
import pkuhit.xap.ac.WardDeptModel;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomOrgEmpDeptDao {
	@Select 
	 List<Map<String, Object>> selectByUserId(String userId);
	
	@Select 
	List<Map<String, Object>> selectByOrgCd(String orgCd, String userId);
	
	@Select 
	Map<String, Object> selectDeptByUserId(String userId);
	
	@Select 
	Map<String, Object> selectDeptNmByDeptCd(String wardDeptCd);
	
	@Select 
	Map<String, Object> selectDeptNmByOrgCd(String orgCd);
	
	@Select 
	List<Map<String, Object>> selectWardDeptByUserId(String userId);
	
}
