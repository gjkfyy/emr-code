package pkuhit.iih.qa.qacustom;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.stat.DataModule;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface QaStatisticsService {
	
	/**
	 * 统计病案等级率
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/qacustom/amrLevelRateStat", method = RequestMethod.GET)
	SingleResult<DataModule> amrLevelRateStat(@RequestParam Map param);
}
