package pkuhit.iih.qa.cache.biz;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaValidateModel;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author wang_yanli
 *
 */
public interface QaAutoCacheService {

	/**
	 * @param enPk
	 *            就诊序号
	 * @return 自动质控测试实现
	 * @throws Exception
	 */
	//@RequestMapping(value = "/qacustom/qaAuto1", method = RequestMethod.GET)
	public void putAutoDataToCache(Map map)
			throws Throwable;
	
}
