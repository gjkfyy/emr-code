package pkuhit.xap.task;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface TaskService
{
    @RequestMapping(value = "/task/en", method = RequestMethod.GET)
    public ArrayResult<XapTaskModel> searchTaskByEn(@RequestParam Map<String, String> params);
}
