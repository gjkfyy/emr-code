package pkuhit.iih.iemr.qa;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.old.QaRecord;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

/**
 * 
 * <p>QaService</p>
 * <p>质控工作记录接口</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public interface QaService {
	
	/**
	 *  【医疗记录质控工作记录】新建服务（单记录）
	 * @param QaRecord qaRecord
	 	String  pk  质控编码 
	 	String  enPk  就诊主键 
	 	String  qaTypeCode  质控类型编码 
	 	Integer  autoFlag  自动质控标志
	 	java.sql.Timestamp  executeBeginTime  时间开始时间
	 	Integer  reformDeadline  整改期限
	 	Integer  completedFlag  完成标志
	 */
	@RequestMapping(value = "/qa", method = RequestMethod.POST)
	void create(@ModelAttribute QaRecord qaRecord) throws Throwable;
	
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
	@RequestMapping(value = "/qa/{id}", method = RequestMethod.PUT)
	SingleResult<QaRecord> update(@PathVariable("id") String id, @ModelAttribute QaRecord qaRecord) throws Throwable;
	
	/**
	 *  【医疗记录质控工作记录】查询服务（单记录）
	 * @param String  pk  就诊主键 
	 * @return SingleResult<QaRecord>
	 */
	@RequestMapping(value = "/qa/{id}", method = RequestMethod.GET)
	SingleResult<QaRecord> search(@PathVariable("id") String pk) throws Throwable;
	
	/**
	 *  【医疗记录质控工作记录】删除服务（单记录）
	 * @param String  pk  就诊主键 
	 */
	@RequestMapping(value = "/qa/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable("id") String pk) throws Throwable;
	
	/**
	 *  【医疗记录质控工作记录】完成质控工作记录
	 * @param String  pk  就诊主键 
	 * @param int reformDeadline
	 * 
	 * 参数定义为QaRecord~~~~~~~~~~~~~~~
	 * 
	 */
	@RequestMapping(value = "/completed/qa/{id}", method = RequestMethod.POST)
	void complete(@PathVariable("id") String pk) throws Throwable;
	
	
}
