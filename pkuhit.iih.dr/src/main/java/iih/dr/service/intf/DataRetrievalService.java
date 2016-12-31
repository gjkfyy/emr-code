package iih.dr.service.intf;

import iih.dr.dao.auto.entity.IemrRetrieval;
import iih.dr.model.IemrRetrievalModel;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;

/**
 * DataRetrievalService
 * @author cheng_feng
 * @version 0.0.0
 */
public interface DataRetrievalService {

	/**
	 * 创建【检索方案】
	 * @param 
	 * @return ArrayResult<IemrRetrieval>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/dr/saveretrieval", method = RequestMethod.POST)
	public ArrayResult<IemrRetrievalModel> createRetrieval(@ModelAttribute IemrRetrievalModel irm) throws Throwable;
	
	/**
	 * 编辑【检索方案】服务（单记录）
	 * @param id
	 * @return SingleResult<IemrRetrieval>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/dr/editretrieval/{id}", method = RequestMethod.PUT)
	SingleResult<IemrRetrieval> editRetrieval(@PathVariable("id") String id,@ModelAttribute IemrRetrievalModel value) throws Throwable;
	
	/**
	 * 删除【检索方案】服务（单记录）
	 * @param id
	 * @return SingleResult<IemrRetrieval>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/dr/delretrieval/{id}", method = RequestMethod.DELETE)
	SingleResult<IemrRetrieval> deleteRetrieval(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * 方案列表---查询病历检索方案列表
	 * @param map 查询条件
	 * @return
	 */
	@RequestMapping(value="/dr/retrieval/list", method = RequestMethod.GET)
	ArrayResult<IemrRetrievalModel> retrievalListBrowses(@RequestParam Map map);
	
}
