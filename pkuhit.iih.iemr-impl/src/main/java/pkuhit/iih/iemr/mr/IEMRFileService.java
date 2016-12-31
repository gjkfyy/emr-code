package pkuhit.iih.iemr.mr;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.SingleResult;

public interface IEMRFileService {
	/**
	 * 基础文件查询服务（单记录） 
	 * @param id
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/basefile/{filePk}", method = RequestMethod.GET)
	SingleResult<Map> get(@PathVariable("filePk")  String filePk)  throws IOException;
}
