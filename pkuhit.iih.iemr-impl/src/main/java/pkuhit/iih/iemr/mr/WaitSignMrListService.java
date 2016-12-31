package pkuhit.iih.iemr.mr;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.SignMr;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;
public interface WaitSignMrListService {

	/**
	 * 查询待审签病历文书列表
	 * @param param Map
	 * @param personalOrWorkGroup 0-个人，1-诊疗组
	 * @return
	 */
	@RequestMapping(value = "/waitSignMrList", method = RequestMethod.GET)
	ArrayResult<SignMr> searchWaitSignMrList(@RequestParam Map<String, String> param) throws Throwable;
}
