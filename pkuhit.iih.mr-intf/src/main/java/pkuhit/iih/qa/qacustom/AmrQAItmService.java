
package pkuhit.iih.qa.qacustom;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.QaDivideLevelModel;
import pkuhit.iih.qa.QaDivideSetModel;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.qacustom.bizmodel.QaItemCreateInit;
import pkuhit.iih.qa.qacustom.bizmodel.QaItmFstCategory;
import pkuhit.iih.qa.qacustom.bizmodel.QaItmSndCategory;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface AmrQAItmService {

	/**
	 * 【质控项目】新建画面初始化服务
	 * @param 
	 * @return SingleResult<QaItemCreateInit>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qaitm/init", method = RequestMethod.GET)
	SingleResult<QaItemCreateInit> createQaItmInit(@RequestParam Map<String,String> value)
		throws Throwable; 
	
	/**
	 * 【质控项目二级分类】查询服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/itmsnd", method = RequestMethod.GET)
	ArrayResult<QaItmSndCategory> getAmrItmSndCategoryCd(@RequestParam Map<String,String> value)
		throws Throwable; 
	
	
	
	/**
	 * 【病案等级】查询服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qadividelevel", method = RequestMethod.GET)
	List<QaDivideLevelModel> searchQaDivideLevel(@RequestParam Map<String,String> value)
		throws Throwable;
	
	/**
	 * 【病案等级】根据等级编码查询服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qadividelevel/set", method = RequestMethod.GET)
	QaDivideSetModel searchQaDivideLevelById(@RequestParam Map<String,String> value)
		throws Throwable;
	
	/**
	 * 删除【病案等级】单记录服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qadividelevel/del/{id}", method = RequestMethod.DELETE)
	SingleResult<QaDivideSetModel> delQaDivideLevelById(@PathVariable("id") String qaDivideLevelCd)
		throws Throwable;
	
	/**
	 * 校验【病案等级分类】名字是否重复 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qadividelevel/vaidatorNm/{id}", method = RequestMethod.GET)
	public String VaidatorQaDivideLevelByLvl(@PathVariable("id") String qaDivideLevelCd)
		throws Throwable;
	
	/**
	 *  【病案等级】新建服务（单记录）
	 * @param QaItmFstCategory value
	 * @return QaItmFstCategory
	 * @
	 */
	@RequestMapping(value = "/qadividelevel/save", method = RequestMethod.POST)
	SingleResult<QaDivideSetModel> createLvl(@ModelAttribute QaDivideSetModel value) ;

	
	/**
	 *  【病案等级】更新服务（单记录）
	 * @param QaItmFstCategory value
	 * @return QaItmFstCategory
	 * @
	 */
	@RequestMapping(value = "/qadividelevel/save/{id}", method = RequestMethod.PUT)
	SingleResult<QaDivideSetModel> updateLvl(@PathVariable("id") String qaDivideLevelCd ,@ModelAttribute QaDivideSetModel value) ;
	

	
	
	/**
	 * 【质控项目一级分类】查询服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitmfst", method = RequestMethod.GET)
	List<QaItmFstCategory> getQaItmFstCategory(@RequestParam Map<String,String> value)
		throws Throwable; 
	
	
	/**
	 * 【质控项目一级分类】根据一级分类编码查询服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitmfst/set", method = RequestMethod.GET)
	QaItmFstCategory searchQaItmFstById(@RequestParam Map<String,String> value)
		throws Throwable;
	
	/**
	 * 删除【质控项目一级分类】单记录服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitmfst/del/{id}", method = RequestMethod.DELETE)
	SingleResult<QaItmFstCategory> delQaItmFstById(@PathVariable("id") String fstCd)
		throws Throwable;
	
	
	/**
	 * 校验【质控项目一级分类】名字是否重复 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitmfst/vaidatorNm/{id}", method = RequestMethod.GET)
	public String VaidatorQaItmFstByNm(@PathVariable("id") String nm)
		throws Throwable;
	
	
	/**
	 *  【质控项目一级分类】新建服务（单记录）
	 * @param QaItmFstCategory value
	 * @return QaItmFstCategory
	 * @
	 */
	@RequestMapping(value = "/qaitmfst/save", method = RequestMethod.POST)
	SingleResult<QaItmFstCategory> createFst(@ModelAttribute QaItmFstCategory value) ;

	
	/**
	 *  【质控项目一级分类】更新服务（单记录）
	 * @param QaItmFstCategory value
	 * @return QaItmFstCategory
	 * @
	 */
	@RequestMapping(value = "/qaitmfst/save/{id}", method = RequestMethod.PUT)
	SingleResult<QaItmFstCategory> updateFst(@PathVariable("id") String fstCd ,@ModelAttribute QaItmFstCategory value) ;
	
	/**
     * 一级分类导航树 
     * zhangdan
     * @return 一级分类导航树
     */
    @RequestMapping(value = "/qaitmsnd/tree", method = RequestMethod.GET)
    SingleResult<Map> qaItmFstTree(@RequestParam Map<String, String> condition);
    
    /**
	 * 【质控项目二级分类】根据二级分类编码查询服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitmsnd/set", method = RequestMethod.GET)
	QaItmSndCategory searchQaItmSndById(@RequestParam Map<String,String> value)
		throws Throwable;
	
	/**
	 * 删除【质控项目二级分类】单记录服务 
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitmsnd/del/{id}", method = RequestMethod.DELETE)
	SingleResult<QaItmSndCategory> delQaItmSndById(@PathVariable("id") String sndCd)
		throws Throwable;
	
	/**
	 * 校验【质控项目二级分类】名字是否重复 /分数是否高于上级分类
	 * @param amrScoreCode
	 * @return
	 * @throws Throwable
	 */
	@RequestMapping(value = "/qaitmsnd/vaidatorNm", method = RequestMethod.GET)
	public String VaidatorQaItmSndByNm(@RequestParam Map<String,String> value)
		throws Throwable;
	
	/**
	 *  【质控项目二级分类】新建服务（单记录）
	 * @param QaItmFstCategory value
	 * @return QaItmFstCategory
	 * @
	 */
	@RequestMapping(value = "/qaitmsnd/save", method = RequestMethod.POST)
	SingleResult<QaItmSndCategory> createSnd(@ModelAttribute QaItmSndCategory value) ;

	
	/**
	 *  【质控项目二级分类】更新服务（单记录）
	 * @param QaItmFstCategory value
	 * @return QaItmFstCategory
	 * @
	 */
	@RequestMapping(value = "/qaitmsnd/save/{id}", method = RequestMethod.PUT)
	SingleResult<QaItmSndCategory> updateSnd(@PathVariable("id") String sndCd ,@ModelAttribute QaItmSndCategory value) ;
	
	
	/**
     * 二级分类导航树 
     * yaolijie
     * @return 二级分类导航树
     */
    @RequestMapping(value = "/qaitm/tree", method = RequestMethod.GET)
    SingleResult<Map> qaItmTree(@RequestParam Map<String, String> condition);

}
