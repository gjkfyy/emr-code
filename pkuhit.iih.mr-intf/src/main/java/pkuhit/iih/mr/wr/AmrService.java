package pkuhit.iih.mr.wr;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.en.md.PatientModel;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface AmrService {

	/**
	 *【病案】新建服务（单记录）
	 * @param io
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amr", method = RequestMethod.POST)
	SingleResult<Amr> create(@RequestParam Amr value) throws Throwable;
	
	/**
	 *【病案】删除服务（单记录）
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amr/{id}", method = RequestMethod.DELETE)
	SingleResult<Amr> delete(@PathVariable("id") String id) throws Throwable;
	
	/**
	 *【病案】更新服务（单记录）
	 * @param id
	 * @param io
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amr/{id}", method = RequestMethod.PUT)
	SingleResult<Amr> update(@PathVariable("id") String id,@RequestParam Amr value) throws Throwable;
	
	/**
	 *【病案】查询服务（单记录） 
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amr/{id}", method = RequestMethod.GET)
	SingleResult<Amr> get(@PathVariable("id")  String id) throws Throwable;
	/**
	 *【病案】查询服务（单记录） 
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/amr/{id}", method = RequestMethod.GET)
	SingleResult<Amr> getAmr(@PathVariable("id")  String id) throws Throwable;
	/**
	 *【病案】查询服务（多记录）
	 * @param ids
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/search/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> search( @RequestParam Map map) throws Throwable;	

	/**
	 *【病案】查询管理服务（多记录）
	 * @param ids
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mrb/search/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> searchForMrb( @RequestParam Map map) throws Throwable;	
	/**
	 *【病案】开始书写服务（单记录）
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/writeStarted/amr/{id}", method = RequestMethod.POST)
	SingleResult<Amr> startWrite(@PathVariable("id") String id) throws Throwable;

	/**
	 *【病案】完成书写服务（单记录）
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/writeCompleted/amr/{id}", method = RequestMethod.POST)
	SingleResult<Amr> completeWrite(@PathVariable("id") String id) throws Throwable;
	
	/**
	 *【病案】判断就诊是否符合就诊组条件
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amr/group/{id}", method = RequestMethod.GET)
	SingleResult<Map> checkAmrGroup(@PathVariable("id") String id) throws Throwable;
	/**
	 *【病案】创建就诊组
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amr/group/{id}", method = RequestMethod.POST)
	void createAmrGroup(@PathVariable("id") String id) throws Throwable;
	

	/**
	 *【病案】取消就诊组
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/writeCompleted/amr/{id}", method = RequestMethod.DELETE)
	SingleResult<Amr> cancelWriteCompleted(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * 【病案】开始质控服务（单记录）
	 * @param id
	 * @return
	 * @throws Throwable
	 */
//	@RequestMapping(value = "/mr/qaStarted/amr/{id}", method = RequestMethod.POST)
	SingleResult<Amr> startQa(@PathVariable("id") String id) throws Throwable;

	/**
	 *【病案】完成质控服务（单记录）
	 * @param id
	 * @return
	 * @throws Throwable
	 */
//	@RequestMapping(value = "/mr/qaCompleted/amr/{id}", method = RequestMethod.POST)
	SingleResult<Amr> completeQa(@PathVariable("id") String id) throws Throwable;

	/**
	 * 【病案】撤销完成质控服务（单记录）
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qaCompleted/amr/{id}", method = RequestMethod.DELETE)
	SingleResult<Amr> cancelQaCompleted(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * 【病案】病案归档服务（单记录）
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/archived/amr/{id}", method = RequestMethod.POST)
	SingleResult<Amr> archived(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * 【病案】病案自动归档服务
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	void autoAmrarchived();
	
	/**
	 * 【病案】病案取消归档服务（单记录）
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/archived/amr/{id}", method = RequestMethod.DELETE)
	SingleResult<Amr> cancelArchived(@PathVariable("id") String id) throws Throwable;
	
	
    /**
	 * 查询病案列表
	 * @param condition.keword 搜索关键字（根据病案患者姓名、床位号)
	 * @param condition.当前科室编码  (匹配病案患者当前就诊科室)
	 * @param condition.当前诊疗组编码  (匹配病案患者当前诊疗组)
	 * @param condition.主管医生
	 * @param condition.就诊类型
	 * @param condition.就诊状态
	 * @param condition.主诊断编码
	 * @param condition.分页
	 * @return 病案列表
	 *//*
	@RequestMapping(value = "/mr/amrs", method = RequestMethod.GET)
	ArrayResult<Amr> search(@RequestParam Map<String, String> condition);*/
	
	/**
	 *【病案】从第三方插入或更新就诊，然后返回就诊单记录 
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amr/getfromthird/{id}", method = RequestMethod.GET)
	SingleResult<Amr> insertOrUpdateEn(@PathVariable("id")  String id,@RequestParam Map map) throws Throwable;
	
	
	/**
	 *查看其他病历
	 * @param id
	 * @return
	 * @throws Throwable
	 */
//	@RequestMapping(value = "/mr/other/{id}", method = RequestMethod.GET)
//	SingleResult<String> searchOtherOmr(@PathVariable("id")  String id,@RequestParam Map map) throws Throwable;
	@RequestMapping(value = "/mr/other", method = RequestMethod.GET)
	SingleResult<String> searchOtherOmr(@RequestParam Map<String, String> condition) throws Throwable;

	@RequestMapping(value = "/mr/call/his", method = RequestMethod.GET)
	SingleResult<Map> iemrCallHis() throws Throwable;
	
	/**
	 * 会诊患者列表
	 * @param consRespDeptId 会诊应答科室
	 * @param consRespDctId  会诊应答医生
	 * @param oderStartTime  会诊区间开始时间
	 * @param orderEndTime   会诊区间结束时间
	 * @param enTpCd         就诊类型
	 * */
	@RequestMapping(value = "/mramr/cons", method = RequestMethod.GET)
	ArrayResult<Amr> getMrAmrForCons(
			   @RequestParam ("respDeptId") String consRespDeptId
			  ,@RequestParam ("respDctId") String consRespDctId
			  ,@RequestParam ("startDate") String oderStartTime
			  ,@RequestParam ("endDate") String orderEndTime
			  ,@RequestParam ("enTpCd") String enTpCd
			   );

		
	
	/**
	 * 跨科处置患者列表
	 * @param stepRespDeptId 跨科应答科室
	 * @param stepRespDctId  跨科应答医生
	 * @param stepStartTime  跨科处置区间开始时间
	 * @param stepEndTime   跨科处置区间结束时间
	 * @param enTpCd         就诊类型
	 * */
		@RequestMapping(value = "/mramr/stepdept", method = RequestMethod.GET)
		ArrayResult<Amr> getMrAmrForStepDept(
			   @RequestParam ("respDeptId") String stepRespDeptId
			  ,@RequestParam ("respDctId") String stepRespDctId
			  ,@RequestParam ("startDate") String stepStartTime
			  ,@RequestParam ("endDate") String stepEndTime
			  ,@RequestParam ("enTpCd") String enTpCd
			  );
		
		
	/**
	 * 如果患者从视图读取，则在点击患者时，如果数据库没有该条记录，需要同步
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/amr/syncpatomramr", method = RequestMethod.GET)
	SingleResult<Amr> syncPaToMrAmr(@RequestParam Map<String, String> condition) throws Throwable;
	
	/**
	 * 从视图获取患者信息
	 * 
	 * */
	@RequestMapping(value = "/mr/amr/getpainfofromview", method = RequestMethod.GET)
	PatientModel getPatientDetail(@RequestParam Map<String, String> condition);
}
