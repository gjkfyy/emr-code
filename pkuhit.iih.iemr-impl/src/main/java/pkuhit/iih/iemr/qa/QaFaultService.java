package pkuhit.iih.iemr.qa;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.CusQaFault;
import pkuhit.iih.qa.old.QaFault;
import pkuhit.iih.qa.old.QaRecord;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author wang_yanli
 *
 */
public interface QaFaultService {

	/**
	 * 创建【质控缺陷】（多记录）
	 * @param enPk 就诊编码
	 * @param qaTypeCode 质控类型编码
	 * @param List<QaFault> listValue 质控缺陷记录对象列表
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault1", method = RequestMethod.POST)
	ArrayResult<QaFault> create(@ModelAttribute CusCreateQaFault map) throws Throwable;
	
	/**
	 * 查询【完成本次质控统计信息】
	 * @param String encounterPk 就诊号
	 * @param String qaTypeCode 质控类型
	 * @return SingleResult<QaRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/statics1", method = RequestMethod.GET)
	SingleResult<QaRecord> searchStatics(@RequestParam("encounterPk") String encounterPk, 
			@RequestParam("qaTypeCode") String qaTypeCode) throws Throwable;
	
	/**
	 * 查询【质控缺陷】（多记录）
	 * @param Map  param 查询条件
		encounterPk	就诊编码
		qaTypeCode	质控类型编码
		statusCode	缺陷状态编码
		dropFlag	不扣分缺陷
		workScreen	调用画面
		isDept	是否勾选科室质控中
	 * @return SingleResult<CusQaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/biz/qa/faults", method = RequestMethod.GET)
	SingleResult<CusQaFault> search(@RequestParam Map param) throws Throwable;
	
}
