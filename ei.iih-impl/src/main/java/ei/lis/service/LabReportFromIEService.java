package ei.lis.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.ass.LabReport;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface LabReportFromIEService {
	/**
	 *  【检验报告】查询服务（单记录）
	 * @param String id
	 * @return LabReport
	 * @   http://localhost:8081/lab/report/906569?xmode=debug
	 */
	@RequestMapping(value = "/ei/lab/report/ie/{labRpPk}", method = RequestMethod.GET)
	SingleResult<LabReport> search(@RequestParam("labRpPk")    String labRpPk) ;
	
	/**
	 *  【检验报告】查询服务（多记录）
	 * @param  LabReport condition
	 * @return List<LabReport> 
	 * @
	 *   http://localhost:8081/diagnosticsList?enPk=241154&xmode=debug
	 */
	@RequestMapping(value = "/ei/lab/ie/reports", method = RequestMethod.GET)
	ArrayResult<LabReport> search(@RequestParam("enPk") String enPk,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;
    
}
