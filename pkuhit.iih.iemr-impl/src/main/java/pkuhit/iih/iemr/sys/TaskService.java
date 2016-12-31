package pkuhit.iih.iemr.sys;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.task.Task;

import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * 
 * @author meng.xinhua
 *
 */
public interface TaskService
{
    /**
     * 获取任务/问题列表
     * @param tgtObCd(任务目标对象编码)
     * @param tgtObPk(任务目标数据主键)
     * @return TaskModel
     * @throws Throwable
     */
    @RequestMapping(value = "/searchTask", method = RequestMethod.GET)
    TaskModel[] selectTask(@RequestParam Map<String, String> params) throws Throwable;
    
    /**
     * 任务整改完成
     * @param taskPk(任务主键)
     * @param taskArray(填写了整改说明的缺陷数组)
     * @return Task
     * @throws Throwable
     */
    @RequestMapping(value = "/completeTask", method = RequestMethod.PUT)
    Task completeTask(@ModelAttribute CusCompleteTask map) throws Throwable;
}
