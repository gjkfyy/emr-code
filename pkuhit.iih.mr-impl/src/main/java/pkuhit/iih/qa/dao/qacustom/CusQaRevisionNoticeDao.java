package pkuhit.iih.qa.dao.qacustom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusQaRevisionNoticeDao {
	
	/**
     * @param qaTypeCode, userId, deptId, workScreen, verifiedDeadline
     * @return List<Map>
     */
	@Select
	List<Map<String, Object>> selectQaRevisionNotice(String qaTypeCode, String userId, String deptId, String workScreen, int verifiedDeadline/*, SelectOptions options*/);
	
	@Select
	Map<String, Object> selectFaultStatistical(String revisionCd);
	
	@Select  
	List<Map<String, Object>> selectQaByCondition(String qaTypeCode, String crtTimeStart, String crtTimeEnd,
			String amrNo ,String crtUserNm , String curDeptNm, String rfmTimeStart, String rfmTimeEnd,String currentManageDoctorName ,String isNurseRole, SelectOptions options);
	
}
