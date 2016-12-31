package pkuhit.xap.ac;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.me.FunctionAction;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;


public interface RoleActionService
{
    
    @RequestMapping(value = "/role/action", method = RequestMethod.POST)
    RoleAction create(@ModelAttribute RoleAction roleAction);

    @RequestMapping(value = "/role/action", method = RequestMethod.PUT)
    RoleAction update(@ModelAttribute RoleAction roleAction);

    @RequestMapping(value = "/role/action/{id}", method = RequestMethod.DELETE)
    RoleAction delete(@PathVariable("id") String roleActionId);

    @RequestMapping(value = "/role/action/{roleCd}", method = RequestMethod.GET)
    public ArrayResult<FunctionAction> selectFuActionListByRoleCd(String roleCd);

    @RequestMapping(value = "/role/action", method = RequestMethod.GET)
    List<RoleAction> search(@ModelAttribute RoleAction condition);
}
