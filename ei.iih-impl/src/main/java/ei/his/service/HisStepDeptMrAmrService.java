package ei.his.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 * 跨科处置就诊列表
 */
public interface HisStepDeptMrAmrService {
	
	/**
	 * 住院跨科处置患者列表
	 * @param stepRespDeptId 跨科应答科室
	 * @param stepRespDctId  跨科应答医生
	 * @param stepStartTime  跨科处置区间开始时间
	 * @param stepEndTime   跨科处置区间结束时间
	 * */
		@RequestMapping(value = "/ei/mramr/stepdept/his/zy", method = RequestMethod.GET)
	   List<Map<String, Object>> getZYList(
			   @RequestParam ("stepRespDeptId") String stepRespDeptId
			  ,@RequestParam ("stepRespDctId") String stepRespDctId
			  ,@RequestParam ("stepStartTime") String stepStartTime
			  ,@RequestParam ("stepEndTime") String stepEndTime);
		/**
		 * 门诊跨科处置患者列表
		 * @param stepRespDeptId 跨科应答科室
		 * @param stepRespDctId  跨科应答医生
		 * @param stepStartTime  跨科处置区间开始时间
		 * @param stepEndTime   跨科处置区间结束时间
		 * */
			@RequestMapping(value = "/ei/mramr/stepdept/his/mz", method = RequestMethod.GET)
		List<Map<String, Object>> getMZList(
				   @RequestParam ("stepRespDeptId") String stepRespDeptId
				  ,@RequestParam ("stepRespDctId") String stepRespDctId
				  ,@RequestParam ("stepStartTime") String stepStartTime
				  ,@RequestParam ("stepEndTime") String stepEndTime);
}
