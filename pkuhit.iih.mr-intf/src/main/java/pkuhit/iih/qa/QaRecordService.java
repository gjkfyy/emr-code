package pkuhit.iih.qa;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.old.QaRecord;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * <p>QaRecordService</p>
 * <p>质控工作记录服务</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public interface QaRecordService {
	
	/**
	 *  【医疗记录质控工作记录】新建服务（单记录）
	 * @param String  pk  质控编码 
	 * @param String  enPk  就诊主键 
	 * @param String  qaTypeCode  质控类型编码 
	 * @param Integer  autoFlag  自动质控标志
	 * @param java.sql.Timestamp  executeBeginTime  时间开始时间
	 * @param Integer  reformDeadline  整改期限
	 * @param Integer  completedFlag  完成标志
	 * @return SingleResult<QaRecord>
	 * @throws Throwable
	 */
//	@RequestMapping(value = "/qa", method = RequestMethod.POST)
	SingleResult<QaRecord> create(@ModelAttribute QaRecord qaRecord) throws Throwable;
	
	/**
	 *  【医疗记录质控工作记录】更新服务（单记录）
	 * @param QaRecord value
	 * @param String  pk  就诊主键 
	 * @param java.sql.Timestamp planTime 计划开始质控时间
	 * @param java.sql.Timestamp executeBeginTime 实际开始时间
	 * @param java.sql.Timestamp executeEndTime 实际结束时间
	 * @param String excuteUserId 实际执行人ID
	 * @param String executeDeptCode 实际执行科室编码
	 * @param Integer completedFlag 完成标志
	 * @param Integer haveFaultFlag 有缺陷标志
	 * @param Integer needReformFaultFlag 有需要整改缺陷标志 
	 * @return SingleResult<QaRecord>
	 */
//	@RequestMapping(value = "/qa/{id}", method = RequestMethod.PUT)
	SingleResult<QaRecord> updateById(@PathVariable("id") String id, @ModelAttribute QaRecord qaRecord) throws Throwable;
	
	/**
	 *  【医疗记录质控工作记录】查询服务（单记录）
	 * @param String  pk  质控工作记录主键 
	 * @return SingleResult<QaRecord>
	 */
//	@RequestMapping(value = "/qa/{id}", method = RequestMethod.GET)
	SingleResult<QaRecord> search(@PathVariable("id") String pk) throws Throwable;
	
	/**
	 *  根据缺陷主键查询未完成的【医疗记录质控工作记录】服务（单记录）
	 * @param String  faultPk  缺陷主键 
	 * @return SingleResult<QaRecord>
	 
	@RequestMapping(value = "/qa/{id}", method = RequestMethod.GET)
	SingleResult<QaRecord> searchQaByFaultPk(@PathVariable("id") String faultPk) throws Throwable;*/
	
	/**
	 *  【医疗记录质控工作记录】删除服务（单记录）
	 * @param String  pk  质控工作记录主键 
	 * @return SingleResult<QaRecord>
	 * @throws Throwable
	 */
//	@RequestMapping(value = "/qa/{id}", method = RequestMethod.DELETE)
	SingleResult<QaRecord> delete(@PathVariable("id") String pk) throws Throwable;
	
	/**
	 *  【医疗记录质控工作记录】完成质控工作记录
	 * @param String  pk  质控工作记录主键 
	 */
	/*@RequestMapping(value = "/completed/qa/{id}", method = RequestMethod.POST)
	void complete(@PathVariable("id") String pk) throws Throwable;*/
	
	/**
	 * 判断是否有未完成的工作记录
	 * @param String  enPk  就诊主键 
	 * @return 没有：""，有：qaPk编码
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/checkExistUncompleted", method = RequestMethod.GET)	
	String checkExistUncompleted(@RequestParam("enPk") String enPk) throws Throwable;
	
	/**
	 * 查询完成本次质控统计信息
	 * @param String  qaPk  质控工作记录主键 
	 * @param String  userId  用户ID
	 * @param String  deptCd  科室ID
	 * @return SingleResult<QaRecord>
			faultTotal	共处理缺陷数
			faultTodoReform	审核通过缺陷数
			faultReviewed	再整改缺陷数
			faultReformed	新提出缺陷数
			faultSubmited	需整改缺陷数
			faultTodoReview	待审核缺陷数
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/searchFaultStatistical", method = RequestMethod.GET)	
	SingleResult<QaRecord> searchFaultStatistical(@RequestParam("qaPk") String  qaPk, @RequestParam("userId") String  userId, @RequestParam("deptCd") String  deptCd) throws Throwable;
	
	/**
	 * 根据就诊编码返回最后完成的质控工作记录对象
	 * @param enPk 就诊编码
	 * @return SingleResult<QaRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/searchLastCompleted", method = RequestMethod.GET)	
	SingleResult<QaRecord> searchLastCompleted(@RequestParam("enPk") String enPk, @RequestParam("qaTypeCode") String qaTypeCode) throws Throwable;
	
}
