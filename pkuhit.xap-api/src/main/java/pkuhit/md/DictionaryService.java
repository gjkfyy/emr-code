package pkuhit.md;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.md.Dictionary.SimpleItem;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface DictionaryService
{
    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    Dictionary[] searchDictionary(@RequestParam DictionarySearchKey key);

    Dictionary getDictionary(String dictId);

    /**
     * 取得字典项目
     * @param dictId 字典ID（例如组织机构编码ORGB01）
     * @param codes 字典项目编码列表
     * @return 字典项目列表
     */
    @RequestMapping(value = "/dictionary/{id}", method = RequestMethod.GET)
    SimpleItem[] getSimpleItems(@PathVariable("id") String dictId,
            @RequestParam("code") String... codes);

    @RequestMapping(value = "/dictionary/{id}", method = RequestMethod.DELETE)
    Dictionary remove(@PathVariable("id") String dictId);
    
    String updateDictionary(String dictId);
}
