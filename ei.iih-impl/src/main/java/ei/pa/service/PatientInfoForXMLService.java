package ei.pa.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.en.md.PatientInfoForXMLModel;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author wang_yanli
 * 患者信息查询接口
 */
public interface PatientInfoForXMLService {
	
	/**
	 * @return 就诊对象详情
	 * http://localhost:8081/patient/838535?xmode=debug
	 * 可以根据传入参数有无，判断使用哪个字段进行查询患者及就诊信息
	 * */
	@RequestMapping(value = "/ei/pa/{enPk}", method = RequestMethod.GET)
	SingleResult<PatientInfoForXMLModel> getPatientInfoForXML(@RequestParam("enPk")  String enPk);
	
	/*
	@RequestMapping(value = "/ei/lab/report/{labRpPk}", method = RequestMethod.GET)
	SingleResult<LabReport> search(@RequestParam("labRpPk")    String labRpPk) ;*/
}
