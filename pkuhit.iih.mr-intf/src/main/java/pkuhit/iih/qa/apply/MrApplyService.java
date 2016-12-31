package pkuhit.iih.qa.apply;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.CusQaAutoFltModel;
import pkuhit.iih.qa.MrApplyModel;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * MrApplyService
 * @author cheng_feng
 * @version 0.0.0
 */
public interface MrApplyService {
	
	/**
	 * 查询病历超时申请列表
	 */
	@RequestMapping(value = "/mr/applylist", method = RequestMethod.GET)
	ArrayResult<MrApplyModel> getMrApplyList(@RequestParam Map<String, String> condition) throws Throwable;
	
	/**
	 * 查询病历超时申请列表
	 */
	@RequestMapping(value = "/mr/getapplyinfo/{id}", method = RequestMethod.GET)
	SingleResult<MrApplyModel> getMrApplyByCd(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * 创建【病历超时申请】
	 * @param 
	 * @return ArrayResult<MrApplyModel>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/saveapply", method = RequestMethod.POST)
	SingleResult<MrApplyModel> create(@ModelAttribute CusQaAutoFltModel qaAutoFlt) throws Throwable ;
	
	/**
	 * 创建【归档撤回申请】
	 * @param 
	 * @return ArrayResult<MrApplyModel>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/addapply", method = RequestMethod.POST)
	ArrayResult<MrApplyModel> create(@ModelAttribute MrApplyModel mrApplyModel) throws Throwable ;
	
	/**
	 * 编辑【病历超时申请表】
	 * @param 
	 * @return SingleResult<HlDictGeneralModel>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/editapply/{id}", method = RequestMethod.PUT)
	SingleResult<MrApplyModel> editMrApply(@PathVariable("id") String id, @ModelAttribute MrApplyModel mrApplyModel) throws Throwable;
	
	/**
	 * 通过【病历超时申请表】
	 */
	@RequestMapping(value = "/mr/editapplypass/{id}", method = RequestMethod.PUT)
	SingleResult<MrApplyModel> editMrApplyPass(@PathVariable("id") String id, @ModelAttribute MrApplyModel mrApplyModel) throws Throwable;
	
	/**
	 * 拒绝【病历超时申请表】
	 */
	@RequestMapping(value = "/mr/editapplyrefuse/{id}", method = RequestMethod.PUT)
	SingleResult<MrApplyModel> editMrApplyRefuse(@PathVariable("id") String id, @ModelAttribute MrApplyModel mrApplyModel) throws Throwable;

}
