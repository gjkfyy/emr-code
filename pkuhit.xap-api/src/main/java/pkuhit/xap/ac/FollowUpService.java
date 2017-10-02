package pkuhit.xap.ac;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface FollowUpService
{
    /**
     * 
     * @param params
     * @return
     */
    
    @RequestMapping(value = "/followUpList", method = RequestMethod.GET)
    ArrayResult<Patient> search(@RequestParam Map<String, String> params);
    
    /**
     * 获取服务器端的当前时间
     * @return
     */
    @RequestMapping(value = "/followUp/getDate", method = RequestMethod.GET)
	public Date getDate();
    
    @RequestMapping(value = "/followUp/saveFlag/{id}", method = RequestMethod.PUT)
   	public SingleResult<Patient> saveFlag(@PathVariable("id") String patientId, @ModelAttribute Patient patient);

    @RequestMapping(value = "/followUp/exportExcel", method = RequestMethod.GET)
    public void exportExcel(Map<String, String> params);
    
    void setResponse(HttpServletResponse response);
}
