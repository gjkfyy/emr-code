/**
 * 
 */
package ei.his.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ei.cis.db.dao.CisDao;
import ei.his.service.HisConsMrAmrService;

/**
 * @author guo_zhongbao
 *
 */
public class HisConsMrAmrServiceImpl implements HisConsMrAmrService {
    @Autowired
    CisDao cisDao;
    
	/* (non-Javadoc)
	 * @see ei.cis.service.CisConsMrAmrService#getList(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getZYList(String consRespDeptId, String consRespDctId,
			String oderStartTime,String orderEndTime) {
		String enPk = null ;
		String statusCode = "1" ;
		String orderType = "3" ;//会诊类型
		String execUnit = consRespDeptId ; //期望执行科室
		List<Map<String, Object>> consMramrFromObsOrderByEnSn = cisDao.getZYConsMramrFromObsOrderByEnSn(enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
		
		return consMramrFromObsOrderByEnSn;
	}
	@Override
	public List<Map<String, Object>> getMZList(String consRespDeptId, String consRespDctId,
			String oderStartTime,String orderEndTime) {
		String enPk = null ;
		String statusCode = "1" ;
		String orderType = "3" ;//会诊类型
		String execUnit = consRespDeptId ; //期望执行科室
		List<Map<String, Object>> consMramrFromObsOrderByEnSn = cisDao.getMZConsMramrFromObsOrderByEnSn(enPk, statusCode, orderType, execUnit, oderStartTime, orderEndTime);
		
		return consMramrFromObsOrderByEnSn;
	}
}
