package pkuhit.iih.qa.qaauto;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.QaDivideModel;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface QaItemService {
	
	@RequestMapping(value = "/qa/auto", method = RequestMethod.GET)
	public void execute()throws Exception ;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/qaAuto", method = RequestMethod.GET)
	ArrayResult<QaDivideModel> qaAutoTest(@RequestParam("enPk") String enPk,@RequestParam("qaTypeCode") String qaAutoTypeCode) throws Exception;
	
	/**
	 * @param  查询条件
	 *           
	 * @return 自动质控项
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/qaAutoItm", method = RequestMethod.GET)
	public ArrayResult<CusQaAutoItmConfig> searchQaAutoItm(@RequestParam("condition") Map condition) throws Exception;
}
