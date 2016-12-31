package pkuhit.iih.webservice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import pkuhit.iih.mr.wr.IEMRWebService;
import xap.sv.annotation.Reference;

@WebService
public class WebServicesImpl implements WebServices {
	private static Logger log = LoggerFactory.getLogger(WebServicesImpl.class);
	
	@Reference
	IEMRWebService iEMRWebService;
	
	@Override
	public String getMrPdfList(String enPk, Boolean pdfFlag, Boolean odtFlag) {
		return iEMRWebService.getMrPdfList(enPk, pdfFlag, odtFlag);
	}


	@Override
	public String updMrPrintCount(String enPk) {
		return iEMRWebService.updMrPrintCount(enPk);
	}


	@Override
	public String selectMrsXml(String enPk) throws IOException {
		return iEMRWebService.selectXmlOnEnPk(enPk);
	}
	
	@Override
    public String isExistMrOfEncounter(String enPk, String mrTpCd){
	    List<Map<String, Object>> list = iEMRWebService.getMrByEnPkAndMrType(enPk, mrTpCd);
	    if(list != null && list.size() > 0){
	        return "1";
	    }
	    return "0";
    }
	
	@Override
	public String isFinishMrOfOrder(String enPk, String orTpCd){
	    JSONArray result = new JSONArray();
	    List<Map<String, Object>> list = iEMRWebService.getMrTypeByOrType(orTpCd);
	    if(list != null && list.size() > 0){
	        for(int i=0;i<list.size();i++){
	            Map<String, Object> map = list.get(i);
	            log.info((String)map.get("MRTPCD"));
	            log.info((String)map.get("MRTPNM"));
	            if(map.get("MRTPCD")!=null && map.get("MRTPNM")!=null && "0".equals(this.isExistMrOfEncounter(enPk, (String)map.get("MRTPCD")))){
	                JSONObject jo = new JSONObject();
	                jo.put("mrTypeCode", (String)map.get("MRTPCD"));
	                jo.put("mrTypeName", (String)map.get("MRTPNM"));
	                result.add(jo);
	            }
	        }
	    }
	    return result.toString();
	}


	//@Override
	public String selectMrTypeCodeList(String HospitalId,
			String HospitalId_DeptCode_EmpId) throws IOException {
		return iEMRWebService.selectMrTypeCodeList(HospitalId,HospitalId_DeptCode_EmpId);
	}


	@Override
	public String selectMrInfosList(String enc_ic, String pa_id, String times,
			String templateId) throws IOException {
		return iEMRWebService.selectMrInfosList( enc_ic,  pa_id,  times,
				templateId);
	}


	@Override
	public String getMrXml(String enPk, String pa_id,String times, String ctrTime,String templateId,
			String mrPk,String empId) throws IOException {
		return iEMRWebService.getMrXml( enPk, pa_id, times,  ctrTime,  templateId,
				 mrPk, empId);
	}


	@Override
	public String saveMrXml(String enPk,String pa_id,String times, String templateId, String ctrTime,
			String mrPk, String xmlData,String empId) throws IOException {
		return iEMRWebService.saveMrXml( enPk,pa_id, times,   templateId,  ctrTime,
				 mrPk, xmlData, empId);
	}


	@Override
	public String deleteMr(String mrPk, String empId) throws IOException {
		// TODO Auto-generated method stub
		return iEMRWebService.deleteMr( mrPk, empId ) ;
	}


	@Override
	public String NmrOrigFileList(String patientId, Integer times, String visitFlag) {
		return iEMRWebService.mrOrigFileList(patientId, times, visitFlag);
	}


	@Override
	public String getMrListByPaIdAndEnCnt(String paId, String ent, Boolean pdfFlag, Boolean odtFlag) {
		return iEMRWebService.getMrListByPaIdAndEnCnt(paId, ent, pdfFlag, odtFlag);
	}


	@Override
	public String selectMrAreas(String paId, String encounterCount, String typeCodes, String names) throws IOException {
		return iEMRWebService.selectMrAreas(paId, encounterCount, typeCodes, names);
	}
}
