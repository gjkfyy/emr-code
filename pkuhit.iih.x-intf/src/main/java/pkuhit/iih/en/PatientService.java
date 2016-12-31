package pkuhit.iih.en;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.en.md.PatientModel;
import xap.sv.model.SingleResult;

/**
 * @author guo_zhongbao
 * 患者查询接口
 */
public interface PatientService {
	/**
	 * 根据就诊序号，就诊详情
	 * @param paId 就诊序号
	 * @return 就诊对象详情
	 * http://localhost:8081/patient/838535?xmode=debug
	 * */
	@RequestMapping(value = "/patient/{paId}", method = RequestMethod.GET)
	public SingleResult<PatientModel> getPatientDetail(@PathVariable("paId") String paId);
}
