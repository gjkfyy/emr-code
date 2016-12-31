package pkuhit.xap.pm;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;

public interface ParamsService {

	/**
	 * 
	 * 根据功能编码获取对应的系统参数配置列表 
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/param/{code}", method = RequestMethod.GET)
	public ArrayResult<Param> getParam(@PathVariable("code") String code);
	
	/**
	 * 
	 * FIXME 
	 * @param param
	 */
	public void putParam(Param param);
	
	/**
	 * 
	 * 将指定功能编码的配置信息加载到内存 
	 * @param code
	 */
	@RequestMapping(value = "/param/{code}", method = RequestMethod.PUT)
	public void updateParamsByCode(String code);
	
	
}
