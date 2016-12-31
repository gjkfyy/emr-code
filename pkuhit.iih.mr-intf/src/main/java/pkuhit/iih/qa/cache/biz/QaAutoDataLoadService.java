package pkuhit.iih.qa.cache.biz;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaValidateModel;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author wang_yanli
 *
 */
public interface QaAutoDataLoadService {

	public Map<String,List<QaAutoModel>> searchQaAutoMrList(Map map)
			throws Throwable;
	
	public Map<String,List<EmrEventModel>>  searchQaAutoEventList(Map map)
			throws Throwable;
	
}
