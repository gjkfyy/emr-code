package ei.util;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ei.common.RestArrayResult;
import ei.common.RestModelArray;

public class HttpReqUtil {

	static ObjectMapper mapper = new ObjectMapper();
	
	
	//返回对象集合
	public static Object[] getServerResult(String urlStr,HttpMethod httpMethod,Class<?> clazz)
			throws Exception {
		  
		RestTemplate rest = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
		
		ResponseEntity<String> responseEntity = rest.exchange(urlStr, httpMethod, requestEntity, String.class);
		
		
		RestArrayResult httpArrayResult = null;
		
		Object[] arrayResult= null;
		HttpStatus code = responseEntity.getStatusCode();
        if (HttpStatus.OK.equals(code))
        {
        	JavaType javaType = getCollectionType(RestArrayResult.class, clazz);
        	httpArrayResult = mapper.readValue(responseEntity.getBody(), javaType);
        	if(null != httpArrayResult && httpArrayResult.getCode() != null && httpArrayResult.getCode().equals("1")){
        		arrayResult = httpArrayResult.getResult();
        	}
        }
        else
        {
            throw new RestClientException("rest error [" + code + "]");
        }
		return arrayResult;
		
	}
	
	//直接返回json类型的串
	public static String getServerResultOfStr(String urlStr,HttpMethod httpMethod)
			throws Exception {
		  
		RestTemplate rest = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
		
		ResponseEntity<String> responseEntity = rest.exchange(urlStr, httpMethod, requestEntity, String.class);
		String result ="[]";
		String resultStr = "";
		HttpStatus code = responseEntity.getStatusCode();
        if (HttpStatus.OK.equals(code))
        {
        	resultStr = responseEntity.getBody() == null ? "" : responseEntity.getBody();
        	JSONObject  json = JSON.parseObject(resultStr);
    		String reCode = json.getString("code");
    		if(reCode.equals("1")){
    			result = json.getString("result");
    		}
        }
        else
        {
            throw new RestClientException("rest error [" + code + "]");
        }
	
		return result;
	}
	
	public static Object[] getResultObject(String resultStr,Class<?> clazz){
		RestModelArray restModelArray = null;
		Object[]  resultObj = null;
		String rsStr = "{\"modelArray\":"+resultStr+"}";
		try {
		  	JavaType javaType = getCollectionType(RestModelArray.class, clazz);
			restModelArray =  mapper.readValue(rsStr, javaType);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(restModelArray != null){
			resultObj = restModelArray.getModelArray();
		}
		return resultObj;
	}
	
	
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
         return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	 } 
}
