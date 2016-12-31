package pkuhit.iih.mr.wr;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface NsvMedocalRecordService {
	/**
	 * 【医疗记录】新建服务（单记录）
	 * 
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/nsv", method = RequestMethod.POST)
	SingleResult<MedicalRecord> create(@ModelAttribute MedicalRecord value)
		throws Throwable;
	
	/**
	 * 【护理记录】删除服务（单记录）
	 * 
	 * @param id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/nsv/{id}", method = RequestMethod.DELETE)
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
	@RequestMapping(value = "/nsv/{id}", method = RequestMethod.PUT)
	SingleResult<MedicalRecord> update(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;

	/**
	 * 【护理记录】查询服务（单记录）
	 * 
	 * @param String
	 *            id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/nsv/{id}", method = RequestMethod.GET)
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
	@RequestMapping(value = "/nsvs", method = RequestMethod.GET)
	ArrayResult<MedicalRecord> search(@RequestParam Map<String, String> param)
		throws Throwable;
	/**
     * 护理管理导航树
     * @param condition.encounterCode 就诊编号
     * @return 护理管理导航树
	 * @throws Throwable 
     */
    @RequestMapping(value = "/nsv/tree/init", method = RequestMethod.GET)
    SingleResult<Map> nsvDocTree(@RequestParam Map<String, String> condition) throws Throwable;
    
    /**
	 * 【医疗记录】签名提交服务（单记录）
	 * 
	 * @param id
	 * @param value
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/submit/nsv/{id}", method = RequestMethod.POST)
	SingleResult<MedicalRecord> sign(@PathVariable("id") String id, @ModelAttribute MedicalRecord value)
		throws Throwable;

}
