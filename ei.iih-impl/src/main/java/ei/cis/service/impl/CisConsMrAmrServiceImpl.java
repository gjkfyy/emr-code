/**
 * 
 */
package ei.cis.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import ei.cis.db.dao.CisDao;
import ei.cis.service.CisConsMrAmrService;

/**
 * @author guo_zhongbao
 *
 */
public class CisConsMrAmrServiceImpl implements CisConsMrAmrService {
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
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		DateFormat edf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Calendar calendar = Calendar.getInstance();
		if(!StringUtils.isBlank(oderStartTime)){
		    calendar.setTimeInMillis(Long.parseLong(oderStartTime));
		    Date sDate = calendar.getTime();
		    oderStartTime = sdf.format(sDate);
        }
		if(!StringUtils.isBlank(orderEndTime)){
            calendar.setTimeInMillis(Long.parseLong(orderEndTime));
            Date eDate = calendar.getTime();
            orderEndTime = edf.format(eDate);
        }
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
