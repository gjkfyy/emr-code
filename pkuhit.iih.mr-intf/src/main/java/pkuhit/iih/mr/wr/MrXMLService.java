package pkuhit.iih.mr.wr;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.SingleResult;


public interface MrXMLService {
	/**
	 * 【XML】域信息（单记录）
	 * @param mr_pk
	 * @return XMl
	 */
	@RequestMapping(value = "/mrXml/assembledXML/{id}", method = RequestMethod.GET)
	public SingleResult<String> assembledXML(@PathVariable("id") String id)throws Throwable;
	
}
