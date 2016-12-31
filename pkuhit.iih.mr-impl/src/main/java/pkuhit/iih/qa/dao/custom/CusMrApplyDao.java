package pkuhit.iih.qa.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusMrApplyDao {
	
	@Select 
    List<Map<String, Object>> selectApplyByEnPk(String applyTypeCd, String userId, String enPk, String dtcCd, String curDeptCd, String applyStatus, String timeStart, String timeEnd, SelectOptions options);
	
	@Select
	Map<String, Object> selectApplyInfoById(String applyCd);
	
	@Select
    int isMedicalWorkDept(String deptCd);
	
	@Select
	String selectApplyDocCdByEnpk(String enPk);
}
