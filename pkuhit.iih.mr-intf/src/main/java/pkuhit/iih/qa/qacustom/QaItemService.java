package pkuhit.iih.qa.qacustom;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.QaItem;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface QaItemService {
	
	/**
	 * 【医疗质控体系质控项目】查询服务（多记录）
	 * 
	 * @param QaSystemItem condition <br/>
	 *            enPk 就诊序号●<br>
	 *            itemFirstCode 医疗记录类型编码 *<br>
	 *            mrSegmentTemplateCode 医疗记录段落类型编码<br>
	 * @return List<QaSystemItem>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qacustom/item", method = RequestMethod.GET)
	ArrayResult<QaItem> search(@RequestParam Map condition) throws Throwable;
	
	/**
	 * 【医疗质控体系质控项目】根据质控编码查询服务（单记录）
	 * 
	 * @param qaItmCd
	 * @return QaSystemItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitm/set", method = RequestMethod.GET)
	QaItem searchByQaItmCd(@RequestParam Map condition) throws Throwable;
	
	/**
	 * 【医疗质控体系质控项目】新增服务（单记录）
	 * 
	 * @param qaItmCd
	 * @return QaSystemItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitm/save", method = RequestMethod.POST)
	SingleResult<QaItem> createQaItm(@ModelAttribute QaItem value) ;
	
	/**
	 * 【医疗质控体系质控项目】更新服务（单记录）
	 * 
	 * @param qaItmCd
	 * @return QaSystemItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitm/save/{id}", method = RequestMethod.PUT)
	SingleResult<QaItem> updateQaItm(@PathVariable("id") String qaItmCd ,@ModelAttribute QaItem value) ;
	
	/**
	 * 删除【质控项目】单记录服务 
	 * @param qaItmCd
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitm/del/{id}", method = RequestMethod.DELETE)
	SingleResult<QaItem> delQaItmById(@PathVariable("id") String qaItmCd)
		throws Throwable;
	
	/**
	 * 校验【单次扣分值】是否高于二级分类分数值（仅限于扣分类型一次扣、多次扣）
	 * @param sndCd onceDrpScr
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitm/vaidator", method = RequestMethod.GET)
	public String VaidatorQaItm(@RequestParam Map<String,String> value)
		throws Throwable;
	
	
	/**
	 * 【医疗质控体系自动配置】新增服务（单记录）
	 * 
	 * @param qaItmCd
	 * @return QaSystemItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaautoitm/save", method = RequestMethod.POST)
	SingleResult<CusQaAutoItmConfig> createQaAutoItm(@ModelAttribute CusQaAutoItmConfig value) ;
	
	/**
	 * 【自动质控项目】根据质控编码查询服务（单记录）
	 * 
	 * @param qaItmCd
	 * @return QaSystemItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitm/autoconfig", method = RequestMethod.GET)
	CusQaAutoItmConfig searchAutoByQaItmCd(@RequestParam Map condition) throws Throwable;
}
