
package pkuhit.iih.mr.wr;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface NursingRecordService {

	/**
	 * 【护理记录】新建服务（单记录）
	 * 
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/nmr", method = RequestMethod.POST)
	SingleResult<MedicalRecord> create(@ModelAttribute MedicalRecord value)
		throws Throwable;
	
	
	/**
	 * 【护理记录】删除服务（单记录）
	 * 
	 * @param id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/nmr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> delete(@PathVariable("id") String id,@ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【护理记录】更新服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/nmr/{id}", method = RequestMethod.PUT)
	SingleResult<MedicalRecord> update(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【护理记录】签名提交服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/submit/nmr/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> sign(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【护理记录】查询服务（单记录）
	 * 
	 * @param String
	 *            id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/nmr/{id}", method = RequestMethod.GET)
	SingleResult<MedicalRecord> searchById(@PathVariable("id") String id,@RequestParam("withFile")boolean withFile)
		throws Throwable;

	/**
	 * 【护理记录】查询服务（多记录）
	 * 
	 * @param param
	 * @param encounterPk
	 *            就诊序号
	 * @param mrTypeCustomCode
	 * 			      护理记录自定义分类编码
	 * @param userSignLevelCode
	 * 				用户审签等级
	 * @return ArrayResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/nmrs", method = RequestMethod.GET)
	ArrayResult<MedicalRecord> search(@RequestParam Map<String, String> param)
		throws Throwable;
	/**
	 * 【医疗记录】开始审签服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/startApprove/nmr/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> startApprove(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;
	/**
	 * 【医疗记录】审签服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/approve/nmr/{id}", method = RequestMethod.PUT)
	SingleResult<MedicalRecord> approve(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【医疗记录】审签撤回（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/approve/nmr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> auditRevoke(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;
	/**
     * 护理病历书写病历文书导航树
     * @param condition.encounterCode 就诊编号
     * @return 护理病历书写病历文书导航树
	 * @throws Throwable 
     */
    @RequestMapping(value = "/nmr/tree/nmrs", method = RequestMethod.GET)
    SingleResult<Map> nmrDocTree(@RequestParam Map<String, String> condition) throws Throwable;

	/**
	 * 【护理记录】撤销签名提交服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/submit/nmr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> cancelSigned(@PathVariable("id") String id, @ModelAttribute MedicalRecord value) throws Throwable;
	/**
	 * 【医疗记录】驳回服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/rejected/nmr/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> reject(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【医疗记录】获取表格拆分数据（单记录）
	 * 
	 * @param enPk
	 * @return	创建时间最近一次拆分数据
	 * @throws Throwable
	 */
	@RequestMapping(value = "/spl/nmr/{id}", method = RequestMethod.GET) 
	SingleResult<Map> splData(@PathVariable("id") String id)throws Throwable; 
	/**
	 * 【医疗记录】获取表格拆分数据（单记录）
	 * 
	 * @param enPk fmType
	 * @return	创建时间最近一次拆分数据
	 * @throws Throwable
	 */
	@RequestMapping(value = "/spl/fmType/nmr", method = RequestMethod.GET) 
	SingleResult<List<MrSplFmValue>> splFmTypeData(@RequestParam("enPk") String enPk,@RequestParam("fmType") String fmType)throws Throwable; 
	/**
	 * 【护理记录】查询服务（多记录）
	 * 
	 * @return 返回患者病历文书带分页
	 * @throws Throwable
	 */
	@RequestMapping(value = "/batchPrint/mrs", method = RequestMethod.GET)
	SingleResult<Map<String,Object>> searchPrintMrs(@RequestParam Map<String, String> param)
		throws Throwable;
	
	/**
	 * 【护理记录】查询服务（多记录）
	 * @param enPk
	 * @return 返回患者病历文书状态
	 * @throws Throwable
	 */
	@RequestMapping(value = "/checkFinish/{id}", method = RequestMethod.GET)
	SingleResult<Map<String, String>> checkFinish(@PathVariable("id") String id)throws Throwable;
	
}
