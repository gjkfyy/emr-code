package ei.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ei.util.HttpReqUtil;
import ei.util.HttpUrlUtil;

public class RestRequestCommon {
	
	public static Logger log = LoggerFactory
			.getLogger(RestRequestCommon.class);
	public String getRequestUrl(String param,RestRequestEntity wsRequestEntity){
		
		String url = wsRequestEntity.getUrl();
		String method = wsRequestEntity.getMethod();
		String defaultParam = wsRequestEntity.getDefaultParam();
		if(defaultParam != null && !defaultParam.equals("")){
			param = param+"&"+defaultParam;
		}
		String urlStr = url+method;//+"?"+param; //wang 测试通过要改回来
		log.warn("this rest url is :"+urlStr);
		return urlStr;
		 
	 }
	 
	 public  Map<String,String> getPatientInfo(String enPk){
			
			String[] enPkArr = enPk.split("_");
			String enCount = "0";
			String patientId = "";
			if(enPkArr.length==2){
				patientId = enPkArr[0];
				enCount = enPkArr[1];
			}
			
			Map<String,String> rsMap = new HashMap();
			String param = "vistTimes="+enCount+"&patientLid="+patientId;
			String urlStr = getRequestUrl(param,HttpUrlUtil.patientVisitsnWsRequestEntity);
			String result = "";
			String patientSn = "";
			String visitSn = "";
			try {
			        
				result = HttpReqUtil.getServerResultOfStr(urlStr, HttpMethod.GET);
				JSONArray array = JSON.parseArray(result); 
				if(array != null && array.size()>0){
					
					JSONObject jsonObject = array.getJSONObject(0); 
					patientSn = jsonObject.getString("patient_sn");
					visitSn = jsonObject.getString("visit_sn");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rsMap.put("patientSn", patientSn);
			rsMap.put("visitSn", visitSn);
			return rsMap;
		}
}
