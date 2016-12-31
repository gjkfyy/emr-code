package pkuhit.iih.di;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pkuhit.iih.di.bizmodel.DiInModel;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

public interface DiInService {
	
	/**
	 * 查询诊断列表
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/di/in/initGrid/{id}", method = RequestMethod.GET)
	List<DiInModel> searchDiInList(@PathVariable("id") String enSn)
		throws Throwable;
	
	/**
	 * 保存诊断
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/di/in/save", method = RequestMethod.POST)
	SingleResult<DiInModel> saveDiIn(@ModelAttribute DiInModel diInModel) ;
	
	
	/**
	 * 删除一条诊断
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/di/in/del/{id}", method = RequestMethod.DELETE)
	SingleResult<DiInModel> delDiIn(@PathVariable("id") String diSn)
		throws Throwable;
	
	/**
	 * 获取诊断列表,给助手区使用
	 * @param map
	 * @return
	 * testJson\01getDisByEnSn_01.js
	 */
	@RequestMapping("/di/in/list/{enSn}")
	ArrayResult<DiagnosisModel> getDiInsListByEnSn(@PathVariable("enSn") String enSn, @RequestParam Map map);
	
}
