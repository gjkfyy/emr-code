/**
 * 
 */
package ei.cis.db.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.cis.db.dao.auto.entity.IemrEnAdtEntity;

/**
 * @author wangyanli
 * 从视图读取患者信息
 */
@Dao
@RepositoryConfig
public interface CisEnViewDao {
	
	@Select
	List<Map<String, Object>> selectEncounterFromViewByCondition(String keyword, String deptCd, String userId, String enTpCd, String groupType, String patientName, String amrNo, String currentBedCode, String startDate, String endDate, String curMgDctId, SelectOptions options);

}
