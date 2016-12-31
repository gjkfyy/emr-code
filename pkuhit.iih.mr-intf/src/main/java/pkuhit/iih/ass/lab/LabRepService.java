package pkuhit.iih.ass.lab;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.ass.LabReport;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface LabRepService {
	/**
	 *  【检验报告】查询服务（多记录）
	 * @param  LabReport condition
	 * @return List<LabReport> 
	 * @
	 *   http://localhost:8081/diagnosticsList?enPk=241154&xmode=debug
	 */
	@RequestMapping(value = "/lab/rep/reports", method = RequestMethod.GET)
	ArrayResult<LabReport> search(@RequestParam("enPk") String enPk,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;
}
