/**
 * 
 */
package ei.his.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ei.cis.db.dao.CisDao;
import ei.his.service.HisStepDeptMrAmrService;

/**
 * @author guo_zhongbao
 *
 */
public class HisStepDeptMrAmrServiceImp implements HisStepDeptMrAmrService {
    @Autowired
    CisDao cisDao;
	/* (non-Javadoc)
	 * @see ei.cis.service.CisStepDeptMrAmrService#getList(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getZYList(String stepRespDeptId, String stepRespDctId,
			String stepStartTime, String stepEndTime) {
		// TODO Auto-generated method stub
		String enPk = null ;
		String statusCode = "1" ;
		String orderType = "3" ;//会诊类型
		String execUnit = stepRespDeptId ; //期望执行科室
		List<Map<String, Object>> stepMramrFromObsOrderByEnSn = cisDao.getZYStepMramrFromObsOrderByEnSn(enPk, statusCode, orderType, execUnit, stepStartTime, stepEndTime);
		
		return stepMramrFromObsOrderByEnSn;
	}
	@Override
	public List<Map<String, Object>> getMZList(String stepRespDeptId, String stepRespDctId,
			String stepStartTime, String stepEndTime) {
		// TODO Auto-generated method stub
		String enPk = null ;
		String statusCode = "1" ;
		String orderType = "3" ;//会诊类型
		String execUnit = stepRespDeptId ; //期望执行科室
		List<Map<String, Object>> stepMramrFromObsOrderByEnSn = cisDao.getMZStepMramrFromObsOrderByEnSn(enPk, statusCode, orderType, execUnit, stepStartTime, stepEndTime);
		
		return stepMramrFromObsOrderByEnSn;
	}
}
