package pkuhit.xap.ac;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.me.XapFunction;
import xap.sv.annotation.Service;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

@Service
public interface RoleFunctionService
{
    
    @RequestMapping(value = "/role/function", method = RequestMethod.POST)
    RoleFunction create(@ModelAttribute RoleFunction roleFunction);

    @RequestMapping(value = "/role/function", method = RequestMethod.PUT)
    RoleFunction update(@ModelAttribute RoleFunction roleFunction);

    @RequestMapping(value = "/role/function/{id}", method = RequestMethod.DELETE)
    RoleFunction delete(@PathVariable("id") String roleFunctionId);

    @RequestMapping(value = "/role/function/{roleCd}", method = RequestMethod.GET)
    public ArrayResult<XapFunction> selectFunctionListByRoleCd(String roleCd);

    @RequestMapping(value = "/role/function", method = RequestMethod.GET)
    List<RoleFunction> search(@ModelAttribute RoleFunction condition);
}
