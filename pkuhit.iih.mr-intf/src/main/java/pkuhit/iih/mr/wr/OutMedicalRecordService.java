
package pkuhit.iih.mr.wr;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.md.MrType;
import pkuhit.xap.ac.User;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface OutMedicalRecordService {

	/**
	 * 【医疗记录】新建服务（单记录）
	 * 
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omr", method = RequestMethod.POST)
	SingleResult<MedicalRecord> create(@ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【医疗记录】新建签章文件（单记录）
	 * 
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omr/cafile", method = RequestMethod.POST)
	void createCaFile(@ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【医疗记录】签名提交服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/submit/omr/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> sign(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【医疗记录】撤销签名提交服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/submit/omr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> cancelSigned(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【医疗记录】判断是否可以新建指定医疗记录类型的医疗记录
	 * 
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omr/canCreate", method = RequestMethod.POST)
	SingleResult<MedicalRecord> canCreate(@ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【医疗记录】删除服务（单记录）
	 * 
	 * @param id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> delete(@PathVariable("id") String id,@ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【医疗记录】更新服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omr/{id}", method = RequestMethod.PUT)
	SingleResult<MedicalRecord> update(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【医疗记录】查询服务（单记录）
	 * 
	 * @param String
	 *            id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omr/{id}", method = RequestMethod.GET)
	SingleResult<MedicalRecord> searchById(@PathVariable("id") String id,@RequestParam("withFile")boolean withFile)
		throws Throwable;

	/**
	 * 获取急诊病历编号
	 * 
	 * @param param
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mergency/number", method = RequestMethod.GET)
	String getEmergencyMrNumber(@RequestParam Map<String, String> param)
		throws Throwable;
	/**
	 * 【医疗记录】查询服务（多记录）
	 * 
	 * @param param
	 * @param encounterPk
	 *            就诊序号
	 * @param mrTypeCustomCode
	 * 			      医疗记录自定义分类编码
	 * @param userSignLevelCode
	 * 				用户审签等级
	 * @return ArrayResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omrs", method = RequestMethod.GET)
	ArrayResult<MedicalRecord> search(@RequestParam Map<String, String> param)
		throws Throwable;
    
	
	/**
	 * 【医疗记录】查询服务（多记录）
	 * 
	 * @param param
	 * @param encounterPk
	 *            就诊序号
	 * @param mrTypeCustomCode
	 * 			      医疗记录自定义分类编码
	 * @param userSignLevelCode
	 * 				用户审签等级
	 * @return ArrayResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omrs2/{enPk}", method = RequestMethod.GET)
	ArrayResult<MedicalRecord> search2(@PathVariable("enPk") String enPk)
		throws Throwable;
	/**
     * 门诊病历书写病历文书导航树
     * @param condition.encounterCode 就诊编号
     * @return 门诊病历书写病历文书导航树
	 * @throws Throwable 
     */
    @RequestMapping(value = "/omr/tree/mrs", method = RequestMethod.GET)
    SingleResult<Map> omrDocTree(@RequestParam Map<String, String> condition) throws Throwable;
    
	/**
     * 门诊病历书写病历文书导航树
     * @param condition.encounterCode 就诊编号
     * @return 门诊病历书写病历文书导航树
	 * @throws Throwable 
     */
    @RequestMapping(value = "/omr/tree/init", method = RequestMethod.GET)
    SingleResult<Map> omrTreeInit(@RequestParam Map<String, String> condition) throws Throwable;
    
    /**
     * 门诊病历签名
     * @param userCd 用户编码
     * @return User
     * @throws Throwable 
     */
    @RequestMapping(value = "omr/signPic/{id}", method = RequestMethod.GET)
    SingleResult<User> omrSignPicByUser(@PathVariable("id") String userCd) throws Throwable;
    
    /**
	 * 记录文书打印操作日志
	 * 
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omr/print/log", method = RequestMethod.POST)
	void createOmrPrintLog(@ModelAttribute MrPrintOpLogModel value)
		throws Throwable;
}
