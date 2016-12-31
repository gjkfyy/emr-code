package pkuhit.iih.qa;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * <p>QaReportService</p>
 * <p>质控报表服务</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public interface QaReportService {
	
	/**
	 *  质控报表查询服务（多记录）
	 * @return ArrayResult<QaRecord>
	 */
	@RequestMapping(value = "/qa/reports", method = RequestMethod.GET)
	ArrayResult<IemrReportModel> search(@RequestParam Map param) throws Throwable;
	
	/**
     *  质控报表查询服务（单记录）
     * @return SingleResult<QaRecord>
     */
	@RequestMapping(value = "/qa/reports/{id}", method = RequestMethod.GET)
    SingleResult<IemrReportModel> get(@PathVariable("id")  String id) ;
	
}
