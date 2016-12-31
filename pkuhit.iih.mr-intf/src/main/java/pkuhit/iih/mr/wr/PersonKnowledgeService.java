
package pkuhit.iih.mr.wr;

import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface PersonKnowledgeService {

	/**
	 * 【个人知识库】新建服务（单记录）
	 * @param io
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/knowledge", method = RequestMethod.POST)
	SingleResult<MrFragment> create(@ModelAttribute MrFragment value)
		throws Throwable;

	/**
	 * 【个人知识库】删除服务（单记录）
	 * @param id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/knowledge/{id}", method = RequestMethod.DELETE)
	SingleResult<MrFragment> delete(@PathVariable("id") String id)
		throws Throwable;

	/**
	 * 【个人知识库】更新服务（单记录）
	 * @param id
	 * @param value
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/knowledge", method = RequestMethod.PUT)
	SingleResult<MrFragment> update(@ModelAttribute MrFragment value)
		throws Throwable;

	/**
	 * 【个人知识库】查询服务（单记录）
	 * @param String id
	 * @return SingleResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/knowledge/{id}", method = RequestMethod.GET)
	SingleResult<MrFragment> searchById(@PathVariable("id") String id)
		throws Throwable;

	/**
	 * 【个人知识库】查询服务（多记录）
	 * @return ArrayResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/knowledges", method = RequestMethod.PUT)
	ArrayResult<MrFragment> search(@ModelAttribute Map<String, Object> param)
		throws Throwable;
	/**
     * 【类别】查询类型服务（多记录）
     * @return ArrayResult<MedicalRecord>
     * @throws Throwable
     */
    @RequestMapping(value = "/knowledgesType", method = RequestMethod.GET)
    ArrayResult<MrFragmentType> searchType(@RequestParam Map<String, String> param)
        throws Throwable;
    
    /**
     * 【类别】修改和新建类型服务
     * @return ArrayResult<MedicalRecord>
     * @throws Throwable
     */
    @RequestMapping(value = "/knowledgesType", method = RequestMethod.PUT)
    void updateAndAddType(@ModelAttribute Map<String, Object> param)
        throws Throwable;
    
    /**
     * 【类别】删除服务（单记录）
     * @param id
     * @throws Throwable
     */
    @RequestMapping(value = "/knowledgesType/{id}", method = RequestMethod.DELETE)
    void deleteType(@PathVariable("id") String id) 
        throws Throwable;
    
    /**
	 * 【个人知识库】查询服务（多记录）
	 * @return ArrayResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/knowledges/tree", method = RequestMethod.GET)
	SingleResult<Map<String,Object>> searchTree(@RequestParam Map<String, String> condition)
		throws Throwable;
	
}
