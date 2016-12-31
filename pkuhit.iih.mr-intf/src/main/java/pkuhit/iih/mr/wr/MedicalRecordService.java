
package pkuhit.iih.mr.wr;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.md.MrType;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface MedicalRecordService {
	/**
	 * 获取Oracle当前时间
	 */
	@RequestMapping(value = "/mr/dataBaseTime", method = RequestMethod.GET)
	SingleResult<DataBaseTime> getDataBaseTime();
	/**
	 * 【医疗记录】新建服务（单记录）
	 * 
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr", method = RequestMethod.POST)
	SingleResult<MedicalRecord> create(@ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【医疗记录】判断是否可以新建指定医疗记录类型的医疗记录
	 * 
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/canCreate", method = RequestMethod.POST)
	SingleResult<MedicalRecord> canCreate(@ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【医疗记录】删除服务（单记录）
	 * 
	 * @param id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> delete(@PathVariable("id") String id,@ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【医疗记录】保存引用元素
	 * 
	 * @param id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	boolean saveDocValue(String enPk, String mrPk, Map<String, Object> elemValue)
		throws Throwable;
	/**
	 *  将病历段落内容转换到二维表
	 * 
	 * @return boolean
	 * @throws Throwable
	 */
	boolean xmlConvertToTable()throws Throwable;
	
	/**
	 * 【医疗记录】更新服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/{id}", method = RequestMethod.PUT)
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
	@RequestMapping(value = "/mr/{id}", method = RequestMethod.GET)
	SingleResult<MedicalRecord> searchById(@PathVariable("id") String id,@RequestParam("withFile")boolean withFile)
		throws Throwable;
	
	/**
	 * 【医疗记录】查询服务（单记录）
	 * 
	 * @param String
	 *            id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mrfile/{id}", method = RequestMethod.GET)
	SingleResult<MedicalRecord> searchFileById(@PathVariable("id") String id)
		throws Throwable;
	
	/**
	 * 【医疗记录文件】查询服务（单记录）
	 * 
	 * @param String
	 *            id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/file/{id}", method = RequestMethod.GET)
	SingleResult<MedicalRecord> searchFilePk(@PathVariable("id") String id)
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
	@RequestMapping(value = "/mrs", method = RequestMethod.GET)
	ArrayResult<MedicalRecord> search(@RequestParam Map<String, String> param)
		throws Throwable;
	/**
	 * 【医疗记录】查询服务（多记录）
	 * 
	 * @param param
	 * @param enPK
	 *            患者编号
	 * @return ArrayResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/search/mrs", method = RequestMethod.GET)
	ArrayResult<MedicalRecord> searchArchivceMrs(@RequestParam Map<String, String> param)
		throws Throwable;
	
	/**
	 * 【医疗记录】查询服务（多记录）For 续打
	 * 
	 * @param param
	 * @param enPK
	 *            患者编号
	 * @return ArrayResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mrs/for/continue/print", method = RequestMethod.GET)
	ArrayResult<MedicalRecord> searchForContinuePrint(@RequestParam Map<String, String> param)
		throws Throwable;
	
	/**
	 * 【医疗记录】签名提交服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/submit/mr/{id}", method = RequestMethod.POST)
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
	@RequestMapping(value = "/submit/mr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> cancelSigned(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【医疗记录】开始审签服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/startApprove/mr/{id}", method = RequestMethod.POST)
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
	@RequestMapping(value = "/approve/mr/{id}", method = RequestMethod.PUT)
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
	@RequestMapping(value = "/approve/mr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> auditRevoke(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【医疗记录】编辑锁申请服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
/*	@RequestMapping(value = "/locked/mr/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> lock(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;*/

	/**
	 * 【医疗记录】编辑锁解除服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
/*	@RequestMapping(value = "/locked/mr/{id}", method = RequestMethod.DELETE)
	SingleResult<MedicalRecord> unlock(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;*/

	/**
	 * 【医疗记录】驳回服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/rejected/mr/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> reject(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;
	/**
	 * 【医疗记录】新建画面初始化服务
	 * @param workGroupCd 就诊所属工作组
	 * @return SingleResult<MedicalRecordCreateInit>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/create/init", method = RequestMethod.GET)
	SingleResult<MedicalRecordCreateInit> createMrInit(@RequestParam Map<String,String> value)
		throws Throwable; 
	/**
	 * 【医疗记录】新建画面初始化服务
	 * @param workGroupCd 就诊所属工作组
	 * @return SingleResult<MedicalRecordCreateInit>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/app/sup/doctors", method = RequestMethod.GET)
	SingleResult<ApproveAndSupDoctors> getSuperDoctors(@RequestParam Map<String,String> value)
		throws Throwable; 
	/**
	 * 医疗记录类型查询服务 
	 * @param mrTypeCustomCategoryCd
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mrtypes", method = RequestMethod.GET)
	ArrayResult<MrType> getMrTypesByMrTypeCustomCategoryCd(@RequestParam Map<String,String> value)
		throws Throwable; 
	
	/**
	 * 病历文书导航树
	 * @param condition.encounterCode 就诊编号
	 * @param condition.custCategoryCode 医疗记录自定义分类编码
	 * @param condition.loadMode 加载模式  1:全量加载（默认） 2:异步加载
	 * @return 病历文书导航树
	 */
	@RequestMapping(value = "/tree/mrs", method = RequestMethod.GET)
	TreeResult<MrTreeData> tree(@RequestParam Map<String, String> condition);
	
	/**
     * 助手区病历文书导航树
     * @param condition.encounterCode 就诊编号
     * @param condition.custCategoryCode 医疗记录自定义分类编码
     * @param condition.loadMode 加载模式  1:全量加载（默认） 2:异步加载
     * @return 助手区病历文书导航树
	 * @throws Throwable 
     */
    @RequestMapping(value = "/mr_doc_tree/mrs", method = RequestMethod.GET)
    SingleResult<Map> mrDocTree(@RequestParam Map<String, String> condition) throws Throwable;
    
//	/**
//     * 门诊病历书写病历文书导航树
//     * @param condition.encounterCode 就诊编号
//     * @return 门诊病历书写病历文书导航树
//	 * @throws Throwable 
//     */
//    @RequestMapping(value = "omr/tree/mrs", method = RequestMethod.GET)
//    SingleResult<Map> omrDocTree(@RequestParam Map<String, String> condition) throws Throwable;
	
	/**
     * 病历文书分类导航树 
     * zhangdan
     * @return 病历文书分类导航树
     */
    @RequestMapping(value = "/sorttree/mrs", method = RequestMethod.GET)
    SingleResult<Map> sortTree(@RequestParam Map<String, String> condition);
    
    
    /**
     * 得到已审签通过的患者列表
     * @param condition.userId 用户id  
     * @param condition.deptCd 登陆科室
     * @return 已审签患者列表
     */
    @RequestMapping(value = "/signed/patients", method = RequestMethod.GET)
    ArrayResult<SignMr> getSignedPatients(@RequestParam Map<String, String> condition)throws Throwable;
    
    /**
     * 得到待科室审签的患者列表
     * @param condition.userId 用户id  
     * @param condition.deptCd 登陆科室
     * @return 待科室审签的患者列表
     */
    @RequestMapping(value = "/wait/dept/sign/patients", method = RequestMethod.GET)
    ArrayResult<SignMr> getWaitDeptSignPatients(@RequestParam Map<String, String> condition)throws Throwable;
    
	/**
	 * 个人已审签文书列表查询
	 * @param condition.userId 用户id	
	 * @param condition.deptCd 登陆科室
	 * @return 文书列表
	 */
	@RequestMapping(value = "/signed/mrs", method = RequestMethod.GET)
	ArrayResult<SignMr> getSignedMrs(@RequestParam Map<String, String> condition)throws Throwable;
	
	/**
	 * 个人待审签文书列表查询
	 * @param condition.userId 用户id	
	 * @param condition.deptCd 用户登录科室
	 * @return 文书列表
	 */
	@RequestMapping(value = "/waitSign/mrs", method = RequestMethod.GET)
	ArrayResult<SignMr> getWaitSignedMrs(@RequestParam Map<String, String> condition)throws Throwable;
	
	/**
     * 科室待审签文书列表查询
     * @param condition.userId 用户id 
     * @param condition.amrStaCd 用户登录科室
     * @return 文书列表
     */
    @RequestMapping(value = "/waitDeptSign/mrs", method = RequestMethod.GET)
    ArrayResult<SignMr> getWaitDeptSignedMrs(@RequestParam Map<String, String> condition)throws Throwable;
    
	/**
	 * 查询引用元素值
	 * @param String
	 *            id
	 * @param String
	 *            enPk
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mrDocValue/{id}", method = RequestMethod.GET)
	ArrayResult<MrElemValue> searchMrDocValueByMrPk(@PathVariable("id") String id,@RequestParam("enPk")String enPk)
		throws Throwable;
	

	/**
	 * 【医疗记录】验证是否允许打印病历
	 * 
	 * @param id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/checkMrPrint/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> checkMrPrint(@PathVariable("id") String id)
		throws Throwable;

	/**
	 * 【医疗记录】修改病历打印次数
	 * 
	 * @param id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/updateMrPrintCount/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> updateMrPrintCount(@PathVariable("id") String id)
		throws Throwable;
	
	String getSignLevelCode() throws Throwable;
	
	/**
     * 住院病历提交验证是否实习医生提交
     * @param 
     * @return 
	 * @throws Throwable 
     */
    @RequestMapping(value = "/mr/xapUserCheckMrSubmit", method = RequestMethod.POST)
    Object xapUserCheckMrSubmit(@ModelAttribute MedicalRecord value) throws Throwable;
    
    /**
	 * 验证是否遗漏某份病历
	 * @param condition.enPk 就诊号	
	 * @param condition.qaItmTpCd QAM06.03 依赖质控
	 * @param condition.qaMrType 当前新建文书类型
	 * @return msg
	 */
	@RequestMapping(value = "/qaCheckCreateMr/mr", method = RequestMethod.GET)
	SingleResult<Map> qaCheckCreateMr(@RequestParam Map<String, String> condition)throws Throwable;
}
