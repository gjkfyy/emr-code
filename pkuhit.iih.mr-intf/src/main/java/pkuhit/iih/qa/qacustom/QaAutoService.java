package pkuhit.iih.qa.qacustom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaValidateModel;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author wang_yanli
 *
 */
public interface QaAutoService {

	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/qaAuto1", method = RequestMethod.GET)
	ArrayResult<QaDivideModel> qaAutoTest(@RequestParam("enPk") String enPk) throws Exception;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/needSubmitMr", method = RequestMethod.GET)
	ArrayResult<QaValidateModel> needSubmitMr(@RequestParam("enPk") String enPk) throws Exception;
	
}
