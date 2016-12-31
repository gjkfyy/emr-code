package pkuhit.iih.mr.tth;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

public interface TeethExamService
{
    /**
     * 查询
     * @param enPk
     * @return
     */
    @RequestMapping(value = "/teeth/search/{enPk}", method = RequestMethod.GET)
    TeethExamModel search(@PathVariable("enPk") String enPk);
    
    /**
     * 保存
     * @param map
     * @return
     */
    @RequestMapping(value = "/teeth/save", method = RequestMethod.POST)
    void save(@ModelAttribute TeethExamModel model) ;
    
    /**
     * 删除
     * @param pk
     * @return
     */
    @RequestMapping(value = "/teeth/delete/{pk}", method = RequestMethod.DELETE)
    TeethExamModel delete(@PathVariable("pk") String enPk);
}
