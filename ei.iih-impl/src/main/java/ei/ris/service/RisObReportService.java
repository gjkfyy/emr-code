package ei.ris.service;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.ass.ObsReport;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface RisObReportService {
	
	/**
	 *  【检查报告】查询服务（单记录）
	 * @param String id
	 * @return ObsReport
	 * @ /observation/report/14138
	 */
	@RequestMapping(value = "/ei/ob/report/{obRpPk}", method = RequestMethod.GET)
	SingleResult<ObsReport>  search(@PathVariable ("obRpPk") String obRpPk) ;
	
	/**
	 *  【检查报告】查询服务（多记录）
	 * @param  ObsReport condition
	 * @return List<ObsReport>
	 * @  /observation/report?enPk=264062
	 */
	@RequestMapping(value = "/ei/ob/reports", method = RequestMethod.GET)
	ArrayResult<ObsReport>  search(@RequestParam("enPk") String enPk,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;
	
	/**
     *  【检查报告】查询服务（多记录）直接从cis库读取
     * @param  enPk（就诊号）
     * @return List<ObsReport>
     * @author meng_xinhua
     */
    ArrayResult<ObsReport>  searchForCis(@RequestParam("enPk") String enPk,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;
    
	/**
     *  【检查报告】查询服务（多记录）
     * @param  applyCodeList（申请单号数组）
     * @return List<ObsReport>
     * @author meng_xinhua
     */
	List<ObsReport> searchObsListByObsNo(List<String> applyCodeList);

}
