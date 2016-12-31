package ei.ass.nu.mz.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.nu.Vitalsign;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface MzDirectVitalsignService {
	/**
	 *  【生命体征】查询服务（单记录）为宏元素
	 * @param String enPk 就诊主键
	 * @return Vitalsign
	 */ 
	@RequestMapping(value = "/nu/mz/direct/vitalsigns/macro", method = RequestMethod.GET)
	SingleResult<Vitalsign> searchRecodeForMacro(@RequestParam("enPk") String enPk) ;
	/**
	 *  【生命体征】查询服务（单记录）
	 * @param String id
	 * @return Vitalsign
	 * /nursing/vitalsign/147062
	 */ 
	@RequestMapping(value = "/nursing/mz/direct/vitalsign/{vitalSignPk}", method = RequestMethod.GET)
	SingleResult<Vitalsign> search(@PathVariable("vitalSignPk")  String vitalSignPk) ;
	
	/**
	 *  【生命体征】查询服务（多记录）
	 * @param  Vitalsign condition
	 * @return List<Vitalsign>
	 * @   /nu/vitalsigns?enPk=838535&acquisitionStartTime=2010-02-19 21:05:10&acquisitionStopTime=2020-02-19 21:05:10
	 */
	@RequestMapping(value = "/nu/mz/direct/vitalsigns", method = RequestMethod.GET)
	ArrayResult<Vitalsign> search(@RequestParam("enPk") String enPk,@RequestParam("acquisitionStartTime") String acquisitionStartTime ,@RequestParam("acquisitionStopTime") String acquisitionStopTime,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize) ;
}
