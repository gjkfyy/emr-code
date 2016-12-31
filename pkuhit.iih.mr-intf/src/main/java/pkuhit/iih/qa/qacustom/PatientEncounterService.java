package pkuhit.iih.qa.qacustom;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.Amr;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author yao_lijie
 *
 */
public interface PatientEncounterService {
	
	/**
	 * 查询环节质控患者列表
	 * @param map 
		 	curDeptNm	就诊科室
			dangerIll	病危标志
					1：病危
			seriouslyIll	病重标志
					1：病重
			rcvTime	入院时间
					1.入院24小时内
					2.入院7日内
					3.全部在院
			leaveHospitalF	已出院（病案未完成）全部在院时不可用
			suF	手术标志
					1：手术
			amrStatus	病案状态
			qaFlag	质控标记
					0：未质控
					1：质控
	 * @return
	 * @throws Throwable
	 */
//	@RequestMapping(value = "/inprocess/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> searchProcessList(@RequestParam Map map) throws Throwable;
	
}
