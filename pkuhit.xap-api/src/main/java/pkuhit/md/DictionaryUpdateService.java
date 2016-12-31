package pkuhit.md;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.md.Dictionary.SimpleItem;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface DictionaryUpdateService
{
    @RequestMapping(value = "/dictionary/update/{dictId}", method = RequestMethod.GET)
    String updateDictionaryByDictId(@PathVariable("dictId") String dictId);

}
