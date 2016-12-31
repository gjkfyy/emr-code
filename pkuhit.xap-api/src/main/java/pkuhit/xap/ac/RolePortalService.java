package pkuhit.xap.ac;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.xap.po.Portal;
import xap.sv.annotation.Service;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

@Service
public interface RolePortalService
{
    
    @RequestMapping(value = "/role/portal", method = RequestMethod.POST)
    RolePortal create(@ModelAttribute RolePortal rolePortal);

    @RequestMapping(value = "/role/portal", method = RequestMethod.PUT)
    RolePortal update(@ModelAttribute RolePortal rolePortal);

    @RequestMapping(value = "/role/portal/{id}", method = RequestMethod.DELETE)
    RolePortal delete(@PathVariable("id") String rolePortalId);

    @RequestMapping(value = "/role/portal/{roleCd}", method = RequestMethod.GET)
    public ArrayResult<Portal> selectPortalListByRoleCd(@PathVariable("roleCd") String roleCd);

    @RequestMapping(value = "/role/portal", method = RequestMethod.GET)
    List<RolePortal> search(@ModelAttribute RolePortal condition);
}
