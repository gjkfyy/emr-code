package ei.util;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ei.common.RestRequestEntity;
import ei.lis.service.impl.LabReportFromIEServiceImpl;

public class HttpUrlUtil {
	public static Logger log = LoggerFactory
			.getLogger(HttpUrlUtil.class);
 
	//public static Map<String, WebServiceRequestEntity> map ;
	public static List<RestRequestEntity> list ;
	
	public static RestRequestEntity  labReportWsRequestEntity = new RestRequestEntity(); 
	public static RestRequestEntity  labReportItemWsRequestEntity = new RestRequestEntity();
	public static RestRequestEntity  patientVisitsnWsRequestEntity = new RestRequestEntity();
	public static RestRequestEntity  observationReportWsRequestEntity = new RestRequestEntity();
	public static RestRequestEntity  observationReportItemsWsRequestEntity = new RestRequestEntity(); 
	
	 static {   
	        Properties prop = new Properties();  
	        InputStream is = HttpUrlUtil.class.getResourceAsStream("/restservice.properties");       
	       /* URL location = null;
	        location = HttpUrlUtil.class.getResource("/restservice.properties");
	        //String path  = HttpUrlUtil.class.getResource(".").getPath();
	        String path  = location.getPath();
	        log.warn("logn.warn this path is ================================"+path);*/
	       /* System.out.println("this path is ================================"+path);
	         if(path != null){
	        	 path = path.substring(1);
	        	 path = path.substring(0, path.indexOf("/ei/util"));//.subString(0,path.indexOf("/ei"));
	         }*/
				      

	   
	        //InputStream in = Object.class.getResourceAsStream("/test.properties"); 
	        InputStream in;
			try {
				//FileInputStream inputStream = new FileInputStream(path);
				//log.warn("logn.warn this restservice.properties InputStream is");
				in = new BufferedInputStream(is);
				log.warn("logn.warn this restservice.properties InputStream is ================================"+in);
	            prop.load(in);  
	          
	            
	             //0检验报告 
	            
	             labReportWsRequestEntity.setEntityName("labReport");
	             labReportWsRequestEntity.setUrl(prop.getProperty("lis.http.url"));
	             labReportWsRequestEntity.setMethod(prop.getProperty("lis.http.method.labReport"));
	             labReportWsRequestEntity.setDefaultParam(prop.getProperty("lis.http.method.labReport.defaultParam"));
	            // list.add(labReportWsRequestEntity);//.put("labReport", labReportWsRequestEntity);
	             
	             //1检验报告项目
	            // WebServiceRequestEntity  labReportItemWsRequestEntity = new WebServiceRequestEntity();
	             labReportWsRequestEntity.setEntityName("labReportItem");
	             labReportItemWsRequestEntity.setUrl(prop.getProperty("lis.http.url"));
	             labReportItemWsRequestEntity.setMethod(prop.getProperty("lis.http.method.labReportItem"));
	             labReportItemWsRequestEntity.setDefaultParam(prop.getProperty("lis.http.method.labReportItem.defaultParam"));
	           //  list.add(labReportItemWsRequestEntity);//map.put("labReportItem", labReportItemWsRequestEntity);
	             
	             //2患者信息
	            // WebServiceRequestEntity patientVisitsnWsRequestEntity = new WebServiceRequestEntity();
	             labReportWsRequestEntity.setEntityName("patientVisitsn");
	             patientVisitsnWsRequestEntity.setUrl(prop.getProperty("patientInfo.http.url"));
	             patientVisitsnWsRequestEntity.setMethod(prop.getProperty("patientInfo.http.method.patientVisitsn"));
	             patientVisitsnWsRequestEntity.setDefaultParam(prop.getProperty("patientInfo.http.method.patientVisitsn.defaultParam"));
	           //  list.add(patientVisitsnWsRequestEntity);//map.put("patientVisitsn", patientVisitsnWsRequestEntity);
	             
	             //3检查报告
	            // WebServiceRequestEntity observationReportWsRequestEntity = new WebServiceRequestEntity();
	             labReportWsRequestEntity.setEntityName("observationReport");
	             observationReportWsRequestEntity.setUrl(prop.getProperty("ris.http.url"));
	             observationReportWsRequestEntity.setMethod(prop.getProperty("ris.http.method.observationReport"));
	             observationReportWsRequestEntity.setDefaultParam(prop.getProperty("ris.http.method.observationReport.defaultParam"));
	           //  list.add(observationReportWsRequestEntity);//map.put("observationReport", observationReportWsRequestEntity);
	           
	             //4检查报告项目
	           //  WebServiceRequestEntity observationReportItemsWsRequestEntity = new WebServiceRequestEntity();
	             observationReportItemsWsRequestEntity.setEntityName("observationReportItems");
	             observationReportItemsWsRequestEntity.setUrl(prop.getProperty("ris.http.url"));
	             observationReportItemsWsRequestEntity.setMethod(prop.getProperty("ris.http.method.observationReportItems"));
	             observationReportItemsWsRequestEntity.setDefaultParam(prop.getProperty("ris.http.method.observationReportItems.defaultParam"));
	           //  list.add(observationReportItemsWsRequestEntity);// map.put("observationReportItems", observationReportItemsWsRequestEntity);
	             
	            
	        } catch (IOException e) {   
	            e.printStackTrace();   
	        }   
	    } 
	 
	 
	
}
