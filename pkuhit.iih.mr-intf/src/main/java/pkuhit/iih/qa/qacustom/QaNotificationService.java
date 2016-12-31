package pkuhit.iih.qa.qacustom;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.QaNotification;
import pkuhit.iih.qa.QaWork;
import pkuhit.iih.qa.qacustom.bizmodel.CusQaFault;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * <p>QaNotificationService</p>
 * <p>整改通知服务</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public interface QaNotificationService {
	
	/**
	 * 查询整改通知列表
	 * @param qaTypeCode 质控类型
	 * @return ArrayResult<QaNotification>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/notifications", method = RequestMethod.GET)	
	ArrayResult<QaNotification> searchQaRevisionNotice(@RequestParam Map map) throws Throwable;
	
	/**
	 * 完成本次审核
	 * @param revisionCd 整改通知编码
	 * @return SingleResult<QaNotification>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/notification/finishCheck/{id}", method = RequestMethod.PUT)	
	SingleResult<QaNotification> finishQaRevisionNotice(@PathVariable("id") String revisionCd) throws Throwable;

	/**
	 * 完成本次审核(整改)前判断整改通知书下的缺陷状态
	 * @param revisionCd 整改通知编码
	 * @return SingleResult<QaFaultStatistical>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/notification/faultStatistical", method = RequestMethod.GET)	
	public String notificationFaultStatistical(@RequestParam Map map) throws Throwable;
	
	/**
	 * 开始整改
	 * @param revisionCd 整改通知编码
	 * @return SingleResult<QaNotification>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/notification/startRfm/{id}", method = RequestMethod.PUT)	
	SingleResult<QaNotification> startRfmRevisionNotice(@PathVariable("id") String revisionCd) throws Throwable;
	
	/**
	 * 完成本次整改
	 * @param revisionCd 整改通知编码
	 * @return SingleResult<QaNotification>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/notification/finishRfm/{id}", method = RequestMethod.PUT)	
	SingleResult<QaNotification> finishRfmRevisionNotice(@PathVariable("id") String revisionCd) throws Throwable;
	
	/**
	 * 根据通知ID查询缺陷列表
	 * @param revisionCd 质控通知ID
	 * @return SingleResult<CusQaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/notification/faults", method = RequestMethod.GET)	
	SingleResult<CusQaFault> searchQaFaultByRevisionCd(@RequestParam Map map) throws Throwable;
	
	/**
	 * 根据患者查询所有缺陷列表
	 * @param pk 就诊序号
	 * @return SingleResult<CusQaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/patient/faults", method = RequestMethod.GET)	
	SingleResult<CusQaFault> searchQaFaultByPk(@RequestParam Map map) throws Throwable;
	
	/**
	 * 环节质控工作查询
	 * @param revisionCd 质控通知ID
	 * @return SingleResult<CusQaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qa/inprocesswork", method = RequestMethod.GET)	
	ArrayResult<QaWork> searchInprocessWork(@RequestParam Map map) throws Throwable;
}
