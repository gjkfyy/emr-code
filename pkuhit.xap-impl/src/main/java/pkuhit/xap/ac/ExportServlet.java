package pkuhit.xap.ac;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xap.sv.app.Application;

public class ExportServlet extends HttpServlet{

	 private static final Logger log = LoggerFactory.getLogger(ExportServlet.class);
	 
	 private static final long serialVersionUID = 1L;
	 
	 private static final String FOLLOWUP = "followup";
	 private static final String ADVANCEDSEARCH = "advancedsearch";

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException
	    {
	        long startTime = System.currentTimeMillis();
	        String contentType = req.getContentType();
	        log.debug("contentType : " + contentType);
	        resp.setCharacterEncoding("utf-8");
	        
	        AdvancedSearchService advancedSearchService = Application.getInstance().getBundleContext().getServiceOfType(AdvancedSearchService.class);
	        FollowUpService followUpService = Application.getInstance().getBundleContext().getServiceOfType(pkuhit.xap.ac.FollowUpService.class);
	        Map<String, String[]> parameterMap = req.getParameterMap();
	        
	        Map<String, String> params = new HashMap<String, String>();
	        Iterator<Map.Entry<String, String[]>> entries = parameterMap.entrySet().iterator();
	        while (entries.hasNext()) {
	        		Entry<String, String[]> entry = entries.next();
	        		params.put(entry.getKey(), entry.getValue()[0]);
	        }
	        //根据参数中的from判定是哪个页面的导出
	        String from  = params.get("_from");
	        if(params.get("_from") != null){
	        	if(from.equals(FOLLOWUP)){
	        		followUpService.setResponse(resp);
	        		followUpService.exportExcel(params);
	        	}else if (from.equals(ADVANCEDSEARCH)){
	    	        advancedSearchService.setResponse(resp);
	    	        advancedSearchService.exportExcel(params);
	        	}else{
	        		log.info("无法导出！请检查导出excel的参数！");
	        	}
	        }
	        long endTime = System.currentTimeMillis();
	        log.info("web service handle time is "+(endTime-startTime)+" ms");
	    }

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException
	    {
	        log.debug("this is MainServlet doGet");
	        doPost(req, resp);
	    }
	    

}
