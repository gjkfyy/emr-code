package pkuhit.iih.qa;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.old.QaFault;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * <p>FaultRecordService</p>
 * <p>质控缺陷服务</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public interface FaultRecordService {

	/**
	 * 变更【质控缺陷】（单记录）
	 * @param id 质控缺陷ID
	 * @param QaFault value 质控缺陷对象
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/{id}", method = RequestMethod.PUT)
	SingleResult<QaFault> updateById(@PathVariable("id") String id, @ModelAttribute QaFault value) throws Throwable;
	
	/**
	 * 查询【质控缺陷】（单记录）
	 * @param String id	质控缺陷编码
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/{id}", method = RequestMethod.GET)
	SingleResult<QaFault> searchById(@PathVariable("id") String id) throws Throwable;
	
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
	@RequestMapping(value = "/qa/faults", method = RequestMethod.GET)
	SingleResult<CusQaFault> search(@RequestParam Map param) throws Throwable;
	
	/**
	 * 删除【质控缺陷】服务（单记录）
	 * @param id
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/fault/{id}", method = RequestMethod.DELETE)
	SingleResult<QaFault> delete(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * 创建【质控缺陷】（单记录）
	 * @param QaFault qaFault 质控缺陷记录对象
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
//	@RequestMapping(value = "/qa/fault", method = RequestMethod.POST)
	SingleResult<QaFault>  create(@ModelAttribute QaFault qaFault) throws Throwable;
	
	/**
	 * 变更【质控缺陷】（多记录）
	 * @param List<QaFault> dataList
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/faults", method = RequestMethod.PUT)
	ArrayResult<QaFault> update(@ModelAttribute CusQaFaultArr cusQaFaultArr) throws Throwable;
	
	/**
	 * 保存【质控缺陷】（多记录）
	 * @param List<QaFault> listValue
	 * @return ListResult<QaFault>
	 * @throws Throwable
	 * 
	 * 去掉enPk，该服务考虑删除掉~~~
	 * 
	 */
	@RequestMapping(value = "/qa/saved/faults", method = RequestMethod.POST)
	void save(@RequestParam String enPk , @ModelAttribute List<QaFault> listValue) throws Throwable;
	
	/**
	 * 查询【质控缺陷】（多记录）
	 * @param CusQaFaultSearchCondition1 searchCondition 查询条件
		encounterPk	就诊编码
		qaTypeCode	质控类型编码
		statusCode	缺陷状态编码
		dropFlag	不扣分缺陷
		workScreen	调用画面
		isDept	是否勾选科室质控中
	 * @return ArrayResult<CusQaFault>
	 * @throws Throwable
	 */
	/*@RequestMapping(value = "/qa/faults", method = RequestMethod.GET)
	ArrayResult<CusQaFault> search(@ModelAttribute CusQaFaultSearchCondition searchCondition) throws Throwable;*/
	
	/**
	 * 提出【质控缺陷】服务
	 * @param List<String> id
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	/*@RequestMapping(value = "/qa/submitted/faults_", method = RequestMethod.POST)
	SingleResult<QaFault> submit(@PathVariable("id") List<String> id) throws Throwable;*/
	
	/**
	 * 整改确认【质控缺陷】服务
	 * @param id
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	/*@RequestMapping(value = "/qa/reformed/fault/{id}", method = RequestMethod.POST)
	SingleResult<QaFault> reform(@PathVariable("id") String id) throws Throwable;*/
	
	/**
	 * 取消【已整改的质控缺陷】服务
	 * @param id
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	/*@RequestMapping(value = "/qa/reformed/fault/{id}", method = RequestMethod.DELETE)
	SingleResult<QaFault> cancelReformed(@PathVariable("id") String id) throws Throwable;*/
	
	/**
	 * 审核【已整改的缺陷】服务
	 * @param id
	 * @throws Throwable
	 */
	/*@RequestMapping(value = "/qa/verified/faults", method = RequestMethod.POST)
	void verify(@PathVariable("id") String id) throws Throwable;*/
	
	/**
	 * 判断是否有未整改的缺陷
	 * @param String  qaItemPkStr  质控项目编码串
	 * @return 0：没有，1：有
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/checkIsNeedReform", method = RequestMethod.GET)
	int checkIsNeedReform(@RequestParam("qaItemPkStr") String qaItemPkStr) throws Throwable;
	
	/**
	 * 判断是否有未确认（缺陷确认结果为非扣分、非不扣分状态）的缺陷
	 * @param String  enPk  就诊编码
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/checkFaultReformResult", method = RequestMethod.GET)
	ArrayResult<QaFault> checkFaultReformResult(@RequestParam("enPk") String enPk) throws Throwable;
	
	/**
	 * 批量修改缺陷状态为“已审核”
	 * @param String  enPk  就诊编码
	 * @param String  qaPk  质控工作记录编码
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/updateFaultStatus", method = RequestMethod.PUT)
	ArrayResult<QaFault> updateFaultStatusToVerified(@RequestParam("enPk") String enPk, @RequestParam("qaPk") String qaPk) throws Throwable;
	
	/**
	 * 将环节质控的缺陷继承到终末质控
	 * @param enPk 就诊编码
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/createFaultExtendInProcess", method = RequestMethod.POST)
	String createFaultExtendInProcess(@RequestParam("enPk") String enPk, @RequestParam("qaSystemItemCode") String qaSystemItemCode) throws Throwable;
	
	/**
	 * 当前质控工作记录下需要整改的缺陷主键编码列表
	 * @param qaPk 当前质控工作记录编码
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/needReformFault", method = RequestMethod.GET)
	List<String> needReformFault(@RequestParam("qaPk") String qaPk) throws Throwable;
	/**
	 * 当前质控工作记录下需要整改的缺陷主键编码列表 待改 wangyanli
	 * @param qaPk 当前质控工作记录编码
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/unSendFault", method = RequestMethod.GET)
	List<String> unSendFault(@RequestParam("qaPk") String qaPk) throws Throwable;
	
	/**
	 * 查询质控缺陷（多记录）
	 * @param String encounterPk
	 * @param String qaTypeCode
	 * @param String statusCode
	 * @param String dropFlag
	 * @param String submittedUserId
	 * @param String submittedDeptCode
	 * @param String pageNum
	 * @param String pageSize
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/searchFaultsByCondition", method = RequestMethod.POST)
	ArrayResult<QaFault> searchByCondition(@RequestParam Map map) throws Throwable;
	
	/**
	 * 计算分数
	 * @param enPk 就诊主键
	 * @param qaTypeCode 质控类型
	 * @param qaSystemCode 质控体系编码
	 * @param encounterTypeCode 就诊类型编码
	 * @return
	 * @throws Throwable
	 */
	/*@RequestMapping(value = "/qa/calculateScore/{id}", method = RequestMethod.POST)
	BigInteger calculateScore(@PathVariable("id") String enPk, @RequestParam("qaTypeCode") String qaTypeCode, 
			@RequestParam("qaSystemCode") String qaSystemCode, @RequestParam("encounterTypeCode") String encounterTypeCode) throws Throwable;
	*/
}
