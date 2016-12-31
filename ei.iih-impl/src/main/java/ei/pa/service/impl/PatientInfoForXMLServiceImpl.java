package ei.pa.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.md.PatientInfoForXMLModel;
import pkuhit.md.SysFunctionCode;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.pa.dao.PatientDao;
import ei.pa.po.PatientInfoForXMLPo;
import ei.pa.service.PatientInfoForXMLService;

/**
 * @author wang_yanli
 * 2016-04-25
 *
 */
public class PatientInfoForXMLServiceImpl implements PatientInfoForXMLService {

	@Autowired
	PatientDao patientDao;
	
	@Reference
	ParamsSetService paramsSetService;
	
	@Override
	public SingleResult<PatientInfoForXMLModel> getPatientInfoForXML(String enPk){
		// TODO Auto-generated method stub
		//enPk = "0000345377_1";
		PatientInfoForXMLModel PatientInfoForXMLModel = new  PatientInfoForXMLModel();
		List<PatientInfoForXMLPo> patientInfoForXMLPoList = null;
		
		//根据系统参数配置 传入不同的参数进行查询
		SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
		if(null != rsMapParam && null != rsMapParam.getData() && rsMapParam.getData().containsKey("XML_PA_ZY")){
			String value = rsMapParam.getData().get("XML_PA_ZY").toString();
			
			//根据patientId+inVisitTimes方式查询
			if(ParameterUtils.ASS_DS_ENPK_SPLIT.equalsIgnoreCase(value)){
				String[] arr = ParameterUtils.splitEnPk(enPk);
				if(null!= arr && !StringUtils.isBlank(arr[0]) && !StringUtils.isBlank(arr[1])){
					String patientId = arr[0];
					String inVisitTimes = arr[1];
					patientInfoForXMLPoList = patientDao.getPatientInfoForXML(patientId,inVisitTimes,"","");
				}
			}else if(ParameterUtils.ASS_DS_ENPK_DIRECT.equalsIgnoreCase(value)){
				patientInfoForXMLPoList = patientDao.getPatientInfoForXML("","","",enPk);
			}
		}
		
		SingleResultBuilder<PatientInfoForXMLModel> builder = SingleResultBuilder.newSingleResult(PatientInfoForXMLModel.class);
		
		if(patientInfoForXMLPoList!=null && patientInfoForXMLPoList.size() > 0 ){
			
			PatientInfoForXMLPo patientInfoForXMLPo = patientInfoForXMLPoList.get(0) ;
			if(null != patientInfoForXMLPo){
				BeanUtils.copyProperties( patientInfoForXMLPo,PatientInfoForXMLModel);
				builder.withData(PatientInfoForXMLModel);
			}
			
		}
		return builder.build();
	}

}
