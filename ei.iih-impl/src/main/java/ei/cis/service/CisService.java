package ei.cis.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.ass.ObsReport;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface CisService
{
    /**
     *  【检查报告】查询服务（多记录）
     * @param  enPk
     * @return List<ObservationReport>
     * @author meng_xinhua
     */
    ArrayResult<ObsReport>  searchByObsOrder(@RequestParam("enPk") String enPk,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;
   
    /**
	 *  将某个表数据导入本系统库（nis_ward_config）
	 * @return boolean
	 *
	 */
	@RequestMapping(value = "/ei/ob/importNisWardConfig", method = RequestMethod.GET)
	SingleResult<String>  importNisWardConfig();
	
	List<Map<String, Object>> searchUserByCert(String caSubject,String strCertId);
	
	List<Map<String, Object>> getCaState(String userId);
}
