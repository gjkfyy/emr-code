package pkuhit.iih.iemr.mr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pkuhit.iih.iemr.sys.PortalService;

import xap.sv.app.Application;

public class MrPubilcServlet extends HttpServlet
{
    private static final Logger log = LoggerFactory.getLogger(MrPubilcServlet.class);

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
        
        PortalService portalService = Application.getInstance().getBundleContext().getServiceOfType(PortalService.class);
        String enc_id = req.getParameter("enc_id");
        int mrCnt  = portalService.searchMrCountByPatient(enc_id);
        resp.getWriter().print(mrCnt);
        long endTime = System.currentTimeMillis();
        log.info("web service handle time is "+(endTime-startTime)+" ms");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        log.debug("this is MrPubilcServlet doGet");
        doPost(req, resp);
    }
}
