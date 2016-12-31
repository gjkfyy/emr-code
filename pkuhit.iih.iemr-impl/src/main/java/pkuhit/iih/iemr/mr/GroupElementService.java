package pkuhit.iih.iemr.mr;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.tpl.GETreeData;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface GroupElementService {
	/**
	 * 【组合元素】导航树
	 * @param condition.keyword 搜索关键字
	 * @param condition.typeCode 医疗记录组合元素类型编码
	 * @return 组合元素导航树结构
	 */
//	@RequestMapping(value = "/mr/tpl/tree/groupElement", method = RequestMethod.GET)
	TreeResult<GETreeData> tree(@RequestParam Map<String, String> condition);
}
