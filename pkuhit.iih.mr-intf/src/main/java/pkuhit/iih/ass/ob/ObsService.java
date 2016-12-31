package pkuhit.iih.ass.ob;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.ass.ObsReport;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;


public interface ObsService {
	/**
	 *  【检查报告】查询服务（单记录）
	 * @param String id
	 * @return ObservationReport
	 * @ /observation/report/14138
	 */
	@RequestMapping(value = "/obs/report/{obRpPk}", method = RequestMethod.GET)
	SingleResult<ObsReport>  search(@PathVariable ("obRpPk") String obRpPk) ;
	
	/**
	 *  【检查报告】查询服务（多记录）
	 * @param  ObservationReport condition
	 * @return List<ObservationReport>
	 * @  /observation/report?enPk=264062
	 */
	@RequestMapping(value = "/obs/reports", method = RequestMethod.GET)
	ArrayResult<ObsReport>  search(@RequestParam("enPk") String enPk,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;

	/**
     *  【检查报告】查询服务（多记录）
     * @param  ObsReport condition
     * @return List<ObsReport>
     * @  /observation/report?enPk=264062
     */
    @RequestMapping(value = "/obs/observation/reports", method = RequestMethod.GET)
    ArrayResult<ObsReport>  searchByObsOrder(@RequestParam("enPk") String enPk,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;

	/**
     *  【检查报告】查询本地服务
     * @param  ObsReport condition
     * @return List<ObsReport>
     * @  /observation/report?enPk=264062
     */
    @RequestMapping(value = "/obs/observation/reports/local", method = RequestMethod.GET)
	ArrayResult<ObsReport> searchFromLocal(@RequestParam("enPk") String enPk,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;

}
