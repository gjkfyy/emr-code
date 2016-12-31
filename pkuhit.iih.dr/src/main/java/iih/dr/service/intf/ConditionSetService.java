package iih.dr.service.intf;

import iih.dr.dao.auto.entity.IemrRetrievalCond;
import iih.dr.model.BaseTemplateModel;
import iih.dr.model.IemrRetrievalCondModel;
import iih.dr.model.MrDocTreeBean;
import iih.dr.model.PatientRetrievalModel;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.model.TreeResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * ConditionSetService
 * @author cheng_feng
 * @version 0.0.0
 */
public interface ConditionSetService {
	
	/**
	 * 查询病历模板列表
	 * 
	 */
	@RequestMapping(value = "/dr/template", method = RequestMethod.GET)
	ArrayResult<BaseTemplateModel> getBaseTemplate(@RequestParam Map<String, String> condition) throws Throwable;
	
	/**
	 * 加载病历模板树结构
	 * 
	 */
	@RequestMapping(value = "/dr/mrdoc/tree", method = RequestMethod.GET)
	TreeResult<MrDocTreeBean> analyticMrDocTree(@RequestParam Map<String, String> condition) throws Throwable;
	
	/**
	 * 创建【方案条件】
	 * @param 
	 * @return ArrayResult<IemrRetrievalCondModel>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/dr/savecondition", method = RequestMethod.POST)
	ArrayResult<IemrRetrievalCondModel> create(@ModelAttribute IemrRetrievalCondModel ircm) throws Throwable;

	/**
	 * 方案条件列表---查询病历检索方案条件
	 * @param map 查询条件
	 * @return
	 */
	@RequestMapping("/dr/retrievalcond/list")
	ArrayResult<IemrRetrievalCondModel> retrievalCondList(@RequestParam Map map);
	
	/**
	 * 方案条件列表---查询病历检索方案条件树
	 * @param map 查询条件
	 * @return
	 */
	@RequestMapping("/dr/retrievalcond/tree")
	TreeResult<IemrRetrievalCondModel> retrievalCondTree(@RequestParam Map map) throws Throwable ;
	
	/**
	 * 方案条件列表---查询病历检索方案条件
	 * @param map 查询条件
	 * @return SingleResult<IemrRetrievalCondModel>
	 */
	@RequestMapping("/dr/retrievalcond/memo")
	SingleResult<IemrRetrievalCondModel> retrievalCondMemo(@RequestParam Map map);
	
	/**
	 * 删除【检索方案】条件（单记录）
	 * @param id
	 * @return SingleResult<IemrRetrieval>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/dr/delretrievalcond/{id}", method = RequestMethod.DELETE)
	SingleResult<IemrRetrievalCond> delete(@PathVariable("id") String id) throws Throwable;
	
	
	/**
	 * 条件上移
	 * @param id
	 * @return SingleResult<IemrRetrievalCond>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/dr/retrievalcond/up/{id}", method = RequestMethod.PUT)
	SingleResult<IemrRetrievalCond> retrievalCondUp(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * 条件下移
	 * @param id
	 * @return SingleResult<IemrRetrievalCond>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/dr/retrievalcond/down/{id}", method = RequestMethod.PUT)
	SingleResult<IemrRetrievalCond> retrievalCondDown(@PathVariable("id") String id) throws Throwable;

	/**
	 * 根据检索方案查询出符合条件的病案
	 */
	@RequestMapping(value="/dr/retrievalpa/list/{id}", method = RequestMethod.GET)
	ArrayResult<PatientRetrievalModel> getMrContentByRetrieval(@PathVariable("id") String id) throws Throwable;
	
}
