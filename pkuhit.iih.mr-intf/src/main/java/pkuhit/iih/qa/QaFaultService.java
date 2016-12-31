package pkuhit.iih.qa;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.old.QaFault;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * <p>QaFaultService</p>
 * <p>质控缺陷服务</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public interface QaFaultService {
	
	/**
	 * 审核通过
	 * @param faultPk 缺陷编码
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/checkpass/{id}", method = RequestMethod.PUT)	
	SingleResult<QaFault> checkPass(@PathVariable("id") String faultPk) throws Throwable;
	
	/**
	 * 全部审核通过
	 * @param revisionCd 整改通知编码
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/allCheckPass/{id}", method = RequestMethod.PUT)	
	SingleResult<QaFault> allCheckPass(@PathVariable("id") String revisionCd) throws Throwable;
	
	/**
	 * 扣分
	 * @param faultPk 缺陷编码
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/deduction/{id}", method = RequestMethod.PUT)	
	SingleResult<QaFault> deduction(@PathVariable("id") String faultPk) throws Throwable;
	
	/**
	 * 再整改
	 * @param faultPk 缺陷编码
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/rectification/{id}", method = RequestMethod.PUT)	
	SingleResult<QaFault> rectification(@PathVariable("id") String faultPk) throws Throwable;
	
}
