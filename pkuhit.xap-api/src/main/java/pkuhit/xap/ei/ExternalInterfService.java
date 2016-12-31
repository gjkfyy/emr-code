package pkuhit.xap.ei;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;

public interface ExternalInterfService {

	/**
	 * 
	 * 根据功能编码获取对应的系统参数配置列表 
	 * @author wang_yanli
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/externalInterf/{code}", method = RequestMethod.GET)
	public ArrayResult<ExterInterf> getExternalInterf(@PathVariable("code") String code);
	
	/**
	 * 
	 * 缓存信息 
	 * 
	 */
	public void cacheExternalInterf(ArrayResult<ExterInterf> list);
	
	
}
