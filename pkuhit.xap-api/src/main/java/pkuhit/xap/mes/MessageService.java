package pkuhit.xap.mes;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface MessageService {
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public boolean sendMessage(@ModelAttribute Message message);
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public ArrayResult<Message> getMessageByUser(@RequestParam Map<String, String> params);
	
	@RequestMapping(value = "/message/read", method = RequestMethod.GET)
	public ArrayResult<Message> getMessageByUserAndReadFlag(@RequestParam Map<String, String> params);
	
	@RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public SingleResult<Message> getMessageById(@PathVariable("id") String messageId);
	
	@RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
	public boolean deleteMessage(@PathVariable("id") String messageId);
	
	@RequestMapping(value = "/message/batch", method = RequestMethod.DELETE)
	public boolean batchDeleteMessage(@ModelAttribute Map map);
	
	@RequestMapping(value = "/message/read/{id}", method = RequestMethod.PUT)
	public boolean changeMessageReadFlag(@PathVariable("id") String messageId);
	
	@RequestMapping(value = "/message/batch", method = RequestMethod.PUT)
    public boolean batchChangeMessageReadFlag(@ModelAttribute Map map);
	
}
