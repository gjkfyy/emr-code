package pkuhit.iih.di;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.di.his.HisDiagnosisListModel;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface DiagnosisService {
	
	
	/**
	 * 根据就诊序号，获取诊断列表
	 * @param enPk 就诊序号
	 * @param isMainF 只查询主诊断
	 * @param onlyNotStop 只查询活动
	 * @param currentPageIndex 起始序号
	 * @param pageSize 每页记录数
	 * @return map.put("dataList",List<DibDiDetail>);map.put("totalSize",int)
	 * http://localhost:8081/diagnosticsList?enPk=870719&isMainF=true&currentPageIndex=1&pageSize=2&xmode=debug
	 */
	@RequestMapping(value = "/diagnosises", method = RequestMethod.GET)
	ArrayResult<DiagnosisModel> search(@RequestParam("enPk") String enPk,@RequestParam("isMainF") String isMainF,@RequestParam("onlyNotStop") String onlyNotStop,@RequestParam("currentPageIndex") String currentPageIndex ,@RequestParam("pageSize") String pageSize );
	
	/**
	 * 根据诊断序号，获取诊断详情
	 * @param diagnosisSn 诊断序号
	 * @return 诊断详情
	 * http://localhost:8081/diagnosticsDetail/522119?xmode=debug
	 */
	@RequestMapping(value = "/diagnosis/{id}", method = RequestMethod.GET)
	SingleResult<DiagnosisModel> search(@PathVariable ("diPk") String diPk);

	/**
	 * 同步诊断到HIS
	 * @param HisDiagnosisListModel his诊断列表
	 * @param patientId 患者id
	 * @param times 患者就诊次数
	 * @return 诊断详情
	 * http://localhost:8081/diagnosticsDetail/522119?xmode=debug
	 */
	@RequestMapping(value = "/diagnosis/syschronize2his", method = RequestMethod.GET)
	void saveOrUpdateDiagnosis(@ModelAttribute HisDiagnosisListModel list,@RequestParam("patientId") String patient_id,@RequestParam("times") String times);

	/**
	 * 删除HIS中的一条诊断，并设置主诊断
	 * @param  delDiCode  需要删除的主诊断
	 * @param  mainDiCode 新的主诊断
	 * @param patientId 患者id
	 * @param times 患者就诊次数
	 * */
	@RequestMapping(value = "/diagnosis/his/delete", method = RequestMethod.GET)
	void delDiagnosis(@RequestParam("delDiCode") String delDiCode,@RequestParam("mainDiCode") String mainDiCode,@RequestParam("patientId") String patient_id,@RequestParam("times") String times);

}
