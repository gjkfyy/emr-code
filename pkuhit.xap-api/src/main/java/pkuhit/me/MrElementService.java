package pkuhit.me;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface MrElementService {
	/**
	 * 数据元列表查询
	 * @param condition.keyword 搜索关键字
	 * @param condition.type 类型  0:所有  1：宏元素  2:普通
	 * @param condition.pageNum 当前页数   (从1开始且默认值为1）
	 * @param condition.pageSize 每页记录数 （默认值25）	 
	 * @return 数据元列表
	 */
    @RequestMapping(value = "/mr_elements", method = RequestMethod.GET)
    ArrayResult<MrElement> getElements(@RequestParam Map<String, String> condition);
}
