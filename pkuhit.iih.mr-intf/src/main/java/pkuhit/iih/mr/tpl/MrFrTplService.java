package pkuhit.iih.mr.tpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface MrFrTplService {
	/**
	 *  【医疗记录模板】名称是否存在
	 * @param name //病历模板名称
	 * @return true已经存在   false不存在
	 */
	@RequestMapping(value = "/mr/tpl/frtpl/check", method = RequestMethod.GET)
	SingleResult<Boolean> HasDuplicationOfName(@RequestParam("code") String code,@RequestParam("name") String name);
	
	/**
	 *  【基础模板】新建服务（单记录）
	 * @param MrFrTemplate value
	 * @return MrFrTemplate
	 * @
	 */
	@RequestMapping(value = "/mr/tpl/frtpl", method = RequestMethod.POST)
	SingleResult<MrFrTemplate> create(@ModelAttribute MrFrTemplate io) ;

	
	/**
	 *  【基础模板】更新服务（单记录）
	 * @param MrFrTemplate value
	 * @return MrFrTemplate
	 * @
	 */
	@RequestMapping(value = "/mr/tpl/frtpl/{id}", method = RequestMethod.PUT)
	SingleResult<MrFrTemplate> update(@PathVariable("id") String id ,@ModelAttribute MrFrTemplate io) ;
	
	/**
	 *  【基础模板】查询服务（单记录）
	 * @param String id
	 * @return MrFrTemplate
	 */
	@RequestMapping(value = "/mr/tpl/frtpl/{id}", method = RequestMethod.GET)
	SingleResult<MrFrTemplate> searchById(@PathVariable("id")  String id) ;
	
	/**
	 *  【基础模板】查询门诊处方处置占位小模板服务
	 * @param String id
	 * @return MrFrTemplate
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/mr/tpl/outdisposal", method = RequestMethod.GET)
	SingleResult<MrPrescriptionAndDisposeTemplate> searchOutdisposalTemp() throws UnsupportedEncodingException, IOException ;
	
	/**
	 *  【基础模板】查询服务（多记录）
	 * @param excludeDelete 当输入0或false时，包含删除。否则，不包含删除
	 * @param statusCode 多个状态码，以 , 分隔
	 * @param pageNum 当前页数    从1开始。默认值为1，
	 * @param pageSize 每页记录数   默认值25
	 * @return List<MrFrTemplate>
	 */
	@RequestMapping(value = "/mr/tpl/frtpl", method = RequestMethod.GET)
	ArrayResult<MrFrTemplate> search(@RequestParam Map<String,Object> condition) ;
	

	/**
	 * 【基础模板】删除服务（单记录）
	 * @param id
	 * @return MrFrTemplate
	 */
	@RequestMapping(value = "/mr/tpl/frtpl", method = RequestMethod.DELETE)
	SingleResult<BatchOperationResult> delete(@ModelAttribute ArrayInputModel ids) ;
	/**
	 * 【基础模板】启用服务（单记录）
	 * @param id
	 * @return MrFrTemplate
	 */
	@RequestMapping(value = "/mr/tpl/activated/frtpl", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> activate(@ModelAttribute ArrayInputModel ids) ;

	/**
	 * 【基础模板】停用服务（单记录）
	 * @param id
	 * @return MrFrTemplate
	 */
	@RequestMapping(value = "/mr/tpl/stopped/frtpl", method = RequestMethod.POST)
	SingleResult<BatchOperationResult> stop(@ModelAttribute ArrayInputModel ids);
	
	/**
	 * 【个人知识库】查询服务（多记录）
	 * @return ArrayResult<MedicalRecord>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/tpl/tree/frtpl", method = RequestMethod.GET)
	SingleResult<Map<String,Object>> searchTree(@RequestParam Map<String, String> condition)
		throws Throwable;
	
}
