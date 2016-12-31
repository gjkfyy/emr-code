package pkuhit.xap.task;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.annotation.Service;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;


@Service
public interface TaskActionService {
	  //发送【任务】
	  @RequestMapping(value = "/sent/task", method =RequestMethod.POST)
      Task sent(@ModelAttribute Task task);
	   //查询【已发送的任务】
	  @RequestMapping(value = "/sent/task", method =RequestMethod.GET)
	  ArrayResult<Task> searchSent(@ModelAttribute Task task);
	
	  
	   //接收【已发送的任务】
	   @RequestMapping(value = "/receive/task", method =RequestMethod.POST)
	   Task receive(@ModelAttribute Task task);
	   

	   //查询【已接收的任务】	SRHR	searchReceived		get	/received/task
	   @RequestMapping(value = "/received/task", method =RequestMethod.GET)
	   Task searchReceived(@ModelAttribute Task task);
	   
	   //完成【已发送或已接收的任务】	CMPL	complete		post	/completed/task
	   @RequestMapping(value = "/completed/task", method =RequestMethod.POST)
	   Task complete(@ModelAttribute Task task);
	   //查询【已完成的任务】	SRHC	searchCompleted		get	/completed/task
	   @RequestMapping(value = "/completed/task", method =RequestMethod.GET)
	   Task searchCompleted(@ModelAttribute Task task);
	   //审核【已完成的任务】	VRF	verify		post	/verified/task
	   @RequestMapping(value = "/verified/task", method =RequestMethod.POST)
	   Task verify(@ModelAttribute Task task);
	   //查询【已审核的任务】	SRHV	searchVerified		get	/verified/task
	   @RequestMapping(value = "/verified/task", method =RequestMethod.GET)
	   Task searchVerified(@ModelAttribute Task task);
	   //查询【逾期的任务】	SRHT	searchTimeout		get	/timeout/task
	   @RequestMapping(value = "/timeout/task", method =RequestMethod.GET)
	   Task searchTimeout(@ModelAttribute Task task);
	   //查询【待审核任务】	SRHWF	searchWaitForVerify	待审核：逾期 or 已完成	get	/waitforverify/task
	   @RequestMapping(value = "/waitforverify/task", method =RequestMethod.GET)
	   Task searchWaitForVerify(@ModelAttribute Task task);
	   
	   
	  @RequestMapping(value = "/task/action/{id}", method = RequestMethod.GET)
	  Task selectById(@PathVariable("id") String id);
	  
	  @RequestMapping(value = "/task/action", method = RequestMethod.PUT)
	  Task update(@ModelAttribute Task task);
	  
	    /**
		 *  根据  tgtObCd  和  tgtObPk 查询任务
		 */
	  @RequestMapping(value = "/task/action", method = RequestMethod.GET)
	  ArrayResult<Task> search(@RequestParam Map<String,String> params);
	  
}
