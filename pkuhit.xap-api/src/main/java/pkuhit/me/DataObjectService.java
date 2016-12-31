package pkuhit.me;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.me.query.Query;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface DataObjectService
{
    /**
     * 
     * @param objectCd 数据对象编码
     * @param id       数据对象主键值
     * @return 数据对象
     */
    @RequestMapping(value = "/object/{objectCd}/{id}", method = RequestMethod.GET)
    DataObject getObject(@PathVariable("objectCd") String objectCd,
            @PathVariable("id") String id);

    @RequestMapping(value = "/object", method = RequestMethod.GET)
    DataObject[] getObjects(@RequestParam("objectCd") String objectCd,
            @RequestParam("idList") String... idList);

    DataObject getObjectById(DataObjectId id);

    DataObject[] executeQuery(Query query);
}
