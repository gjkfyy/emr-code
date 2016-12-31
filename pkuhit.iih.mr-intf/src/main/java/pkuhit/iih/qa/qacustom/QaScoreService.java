package pkuhit.iih.qa.qacustom;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.qacustom.bizmodel.CusCreateQaDivide;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;
/**
 * 
 * @author wang_yanli
 *
 */
public interface QaScoreService {

	/**
	 * 创建【扣分项】（多记录）
	 * @param enPk 就诊编码
	 * @param qaTypeCode 质控类型编码
	 * @param List<QaFault> listValue 质控缺陷记录对象列表
	 * @return ArrayResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/dropScoreItems", method = RequestMethod.POST)
	ArrayResult<QaDivideModel> create(@ModelAttribute CusCreateQaDivide map) throws Throwable;
	
	
	/**
	 * 查询【扣分项】（多记录）
	 * @param Map  param 查询条件
		encounterPk	就诊编码
		qaTypeCode	质控类型编码
		workScreen  工作场景		
	 * @return SingleResult<CusQaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/dropScoreItems", method = RequestMethod.GET)
	ArrayResult<QaDivideModel> search(@RequestParam Map param) throws Throwable;
	
	/**
	 * 删除【扣分项】服务（单记录）
	 * @param id
	 * @return SingleResult<QaFault>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/dropScoreItem/{id}", method = RequestMethod.DELETE)
	SingleResult<QaDivideModel> delete(@PathVariable("id") String id) throws Throwable;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @param qaTypeCode
	 *            就诊类型编码
	 * @param qaSysCode
	 *            质控体系编码
	 * @return 质控评分
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/amrScore", method = RequestMethod.GET)
	SingleResult<Amr> score(@RequestParam("enPk") String enPk,
			@RequestParam("qaTypeCode") String qaTypeCode,
			@RequestParam("qaSysCode") String qaSysCode) throws Exception;
	
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 完成质控评分
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/completeScore/{enPk}", method = RequestMethod.POST)
	SingleResult<Amr> completeScore(@PathVariable("enPk") String enPk,@RequestParam Map param) throws Exception;
	
	/**
	 * @param enPk
	 *            就诊序号
	 * @return 完成科室质控评分
	 * @throws Exception
	 */
	@RequestMapping(value = "/qacustom/deptCompleteScore/{enPk}", method = RequestMethod.POST)
	SingleResult<Amr> deptCompleteScore(@PathVariable("enPk") String enPk,@RequestParam Map param) throws Exception;
	
	
}
