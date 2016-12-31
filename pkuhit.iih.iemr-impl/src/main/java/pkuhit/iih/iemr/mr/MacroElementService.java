
package pkuhit.iih.iemr.mr;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.AllValue;
import pkuhit.iih.mr.wr.MacroElementValue;
import pkuhit.iih.mr.wr.RefreshPrescriptionAndDisposal;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface MacroElementService {

	/**
	 * 宏元素值查询服务
	 * 
	 * @param id
	 *            就诊序号
	 * @param opType
	 *            操作类型            
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/macroElement", method = RequestMethod.GET)
	SingleResult<MacroElementValue> searchById(@RequestParam Map<String, String> param)
		throws Throwable;
	/**
	 * 查询引用元素和宏元素值服务
	 * 封装成一个服务目的是为了减少前后台访问次数
	 * @param String
	 *            id
	 * @param String
	 *            enPk
	 * @return SingleResult<AllValue>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/allValue", method = RequestMethod.GET)
	SingleResult<AllValue> searchAllValueByEnPk(@RequestParam Map<String, String> param)
		throws Throwable;
	
	/**
	 * 查询门诊处方处置服务
	 * 点击“刷新门诊处置”时，调用此方法。
	 * 实现步骤：
	 * 1  从助手去的后台获取数据
	 * 2  过滤掉非当日的医嘱
	 * 3 按医嘱类型orderType分到对应的数组
	 * 4 如果数组有值，则加载对应的小模板
	 * 5返回
	 * @param String
	 * 				id 就诊序号
	 * @return SingleResult<MacroElementValue>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/omr/prescription/{id}", method = RequestMethod.GET)
	SingleResult<RefreshPrescriptionAndDisposal> searchAllPrescriptionAndDisposalByEnPk(@PathVariable("id") String id)
		throws Throwable;
}
