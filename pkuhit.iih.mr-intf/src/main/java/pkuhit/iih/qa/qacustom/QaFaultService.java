package pkuhit.iih.qa.qacustom;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.QaFault;
import pkuhit.iih.qa.qacustom.bizmodel.CusCreateQaFault;
import pkuhit.iih.qa.qacustom.bizmodel.CusQaFault;
import pkuhit.xap.ac.User;
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
	@RequestMapping(value = "/qacustom/fault", method = RequestMethod.POST)
	ArrayResult<QaFault> create(@ModelAttribute CusCreateQaFault map) throws Throwable;
	
	
	/**
	 * 查询【质控缺陷】（多记录）
	 * @param Map  param 查询条件
		encounterPk	就诊编码
		qaTypeCode	质控类型编码
		statusCode	缺陷状态编码
		workScreen  工作场景		
	 * @return SingleResult<CusQaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/faults", method = RequestMethod.GET)
	SingleResult<CusQaFault> search(@RequestParam Map param) throws Throwable;
	
	/**
	 * 删除【质控缺陷】服务（单记录）
	 * @param id
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/fault/{id}", method = RequestMethod.DELETE)
	SingleResult<QaFault> delete(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * 编辑【质控缺陷】服务（单记录）
	 * @param id
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/saverfmdes/{id}", method = RequestMethod.PUT)
	SingleResult<QaFault> edit(@PathVariable("id") String id,@ModelAttribute QaFault value) throws Throwable;
	
	/**
	 * 保存通知单
	 * @param fault
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/submitted/faults", method = RequestMethod.POST)
	SingleResult<QaFault> submit(@ModelAttribute CusCreateQaFault fault) throws Throwable;
	
	/**
	 * 审核通过
	 * @param faultPk 缺陷编码
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/checkpass/{id}", method = RequestMethod.PUT)	
	SingleResult<QaFault> checkPass(@PathVariable("id") String faultPk) throws Throwable;
	
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
	
	/**
	 * 整改
	 * @param faultPk 缺陷编码
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/rfm/{id}", method = RequestMethod.PUT)	
	SingleResult<QaFault> rfmDefect(@PathVariable("id") String faultPk) throws Throwable;
	
	/**
	 * 撤回
	 * @param faultPk 缺陷编码
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/back/{id}", method = RequestMethod.PUT)	
	SingleResult<QaFault> backDefect(@PathVariable("id") String faultPk) throws Throwable;
	
	/**
	 * 查询【本科室护士】（多记录）
	 * @param Map  param 查询条件
		currDept 当前登录科室/病区
	 * @return SingleResult<CusQaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/deptemps", method = RequestMethod.GET)
	ArrayResult<User> searchDeptEmps(@RequestParam Map param) throws Throwable;
}
