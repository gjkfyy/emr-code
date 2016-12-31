package pkuhit.iih.qa.qaauto;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.CusQaAutoFltModel;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaValidateModel;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface QaAutoGenerateFaultService {
	
	@RequestMapping(value = "/qa/auto/generate/fault", method = RequestMethod.GET)
	public void execute()throws Exception ;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/qaAuto/generate/fault", method = RequestMethod.GET)
	ArrayResult<CusQaAutoFltModel> initRuleData(@RequestParam("qaTypeCode") String qaAutoTypeCode) throws Exception;
	
	/**
	 * @param  查询条件
	 *           
	 * @return 自动质控项
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/qaAutoItm/generate/fault", method = RequestMethod.GET)
	public ArrayResult<CusQaAutoFltModel> searchPreFltItm(@RequestParam("condition") Map condition) throws Exception;

	/**
	 * @param  查询条件
	 *           
	 * @return 自动质控缺陷项
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/qaAutoFlt", method = RequestMethod.GET)
	public ArrayResult<CusQaAutoFltModel> searchQaAutoFlt(@RequestParam Map map) throws Exception;

}
