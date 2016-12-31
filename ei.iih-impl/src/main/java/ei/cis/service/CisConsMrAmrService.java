package ei.cis.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 * 会诊就诊列表
 */
public interface CisConsMrAmrService {
	
	/**
	 * 住院会诊患者列表
	 * @param consRespDeptId 会诊应答科室
	 * @param consRespDctId  会诊应答医生
	 * @param oderStartTime  会诊区间开始时间
	 * @param orderEndTime   会诊区间结束时间
	 * */
		@RequestMapping(value = "/ei/mramr/cons/cis/zy", method = RequestMethod.GET)
	   List<Map<String, Object>> getZYList(
			   @RequestParam ("consRespDeptId") String consRespDeptId
			  ,@RequestParam ("consRespDctId") String consRespDctId
			  ,@RequestParam ("oderStartTime") String oderStartTime
			  ,@RequestParam ("orderEndTime") String orderEndTime);
		/**
		 * 门诊会诊患者列表
		 * @param consRespDeptId 会诊应答科室
		 * @param consRespDctId  会诊应答医生
		 * @param oderStartTime  会诊区间开始时间
		 * @param orderEndTime   会诊区间结束时间
		 * */
			@RequestMapping(value = "/ei/mramr/cons/cis/mz", method = RequestMethod.GET)
		   List<Map<String, Object>> getMZList(
				   @RequestParam ("consRespDeptId") String consRespDeptId
				  ,@RequestParam ("consRespDctId") String consRespDctId
				  ,@RequestParam ("oderStartTime") String oderStartTime
				  ,@RequestParam ("orderEndTime") String orderEndTime);
}
