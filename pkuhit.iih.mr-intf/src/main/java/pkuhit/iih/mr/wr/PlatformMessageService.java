package pkuhit.iih.mr.wr;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.MedicalRecord;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface PlatformMessageService
{
    /**
     * 发送Mq消息
     * 
     * @param 文档的操作版本
     * @param 接口服务ID、域ID
     * @param 病历xml
     * @return 消息ID
     * @throws Throwable
     */
    @RequestMapping(value = "/platform/sendMq", method = RequestMethod.POST)
    String sendMessage(@RequestParam Map<String, String> params, @ModelAttribute MedicalRecord value) throws Throwable;
}
