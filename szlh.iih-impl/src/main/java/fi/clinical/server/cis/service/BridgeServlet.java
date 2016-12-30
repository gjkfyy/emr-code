package fi.clinical.server.cis.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xap.sv.app.Application;


public class BridgeServlet extends HttpServlet
{

    private static final Logger log = LoggerFactory.getLogger(BridgeServlet.class);

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        long startTime = System.currentTimeMillis();
        String contentType = req.getContentType();
        log.debug("contentType : " + contentType);
        log.debug("contentType : " + contentType);
        resp.setCharacterEncoding("utf-8");
        
        CisLoginVerifyService cisLoginVerifyService = Application.getInstance().getBundleContext().getServiceOfType(CisLoginVerifyService.class);
        String token = req.getParameter("token");
        token  = cisLoginVerifyService.parseCisLoginVerifyModelToken(token);
        String respStr = printHtml(token);
        resp.getWriter().print(respStr);
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
    
    private String printHtml(String token){
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("<script type=\"text/javascript\">");
    	stringBuffer.append("function plugin()");
    	stringBuffer.append("{");
    	stringBuffer.append("return document.getElementById('plugin0');");
    	stringBuffer.append("}");
    	stringBuffer.append("function addEvent(obj, name, func)");
    	stringBuffer.append("{");
    	stringBuffer.append("if (obj.attachEvent) {");
    	stringBuffer.append("obj.attachEvent(\"on\"+name, func);");
    	stringBuffer.append("} else {");
    	stringBuffer.append("obj.addEventListener(name, func, false); ");
    	stringBuffer.append(" }");
    	stringBuffer.append("}");
    	stringBuffer.append("function load() {");
    	stringBuffer.append("var patientId = '';");
    	stringBuffer.append("if(patientId == \"-1\") {");
    	stringBuffer.append("var str = '{\"token\": \""+token+"\", \"patientId\": null}';");
    	stringBuffer.append("}");
    	stringBuffer.append("else {");
    	stringBuffer.append("var str = '{\"token\": \""+token+"\", \"patientId\": \"null\"}';");
    	stringBuffer.append("}");
    	stringBuffer.append("var port = 8890;");
    	stringBuffer.append("var flag = plugin().SendtoWebkit(port, str);");
    	stringBuffer.append("if(!flag) {");
    	stringBuffer.append("var cnt = 60;");
    	stringBuffer.append("var h = setInterval(function(){		");
    	stringBuffer.append("flag = plugin().SendtoWebkit(port, str);");
    	stringBuffer.append("if(flag || cnt-- <= 0) {");
    	stringBuffer.append("clearInterval(h);");
    	stringBuffer.append("}");
    	stringBuffer.append("},50);");
    	stringBuffer.append("}");
    	stringBuffer.append("}");
    	stringBuffer.append("</script>");
    	stringBuffer.append("<object id=\"plugin0\" type=\"application/x-founderoffice\" width=\"300\" height=\"400\">");
    	stringBuffer.append("<PARAM NAME=\"LoadWebkit\" value=\"1\">");
    	stringBuffer.append("<PARAM name=\"onload\" value=\"load\" />");
    	stringBuffer.append(" </object>");
    	return stringBuffer.toString();
    }

}
