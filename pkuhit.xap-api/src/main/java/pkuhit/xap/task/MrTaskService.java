package pkuhit.xap.task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.EmrEventModel;
import xap.sv.annotation.Service;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;


@Service
public interface MrTaskService {
	 //根据事件类型，处理任务规则，生成相应任务
	 @RequestMapping(value = "/sent/task", method = RequestMethod.GET)
    XapTaskModel handlerTaskRule(@ModelAttribute EmrEventModel emrEventModel)throws Exception;
}
