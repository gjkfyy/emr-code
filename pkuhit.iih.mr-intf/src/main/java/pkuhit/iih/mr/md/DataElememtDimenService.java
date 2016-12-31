package pkuhit.iih.mr.md;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.mr.tpl.ArrayInputModel;
import pkuhit.iih.mr.tpl.BatchOperationResult;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 * 数据元素管理-链接元素-维度管理
 */
public interface DataElememtDimenService {
	//获取 链接元素列表 主表	
	@RequestMapping(value = "/md/mr/Dimen/code", method = RequestMethod.GET)
   ArrayResult<MetaElement> getDataElememtDimenCodeList(@RequestParam Map map);
	
	//获取最新的可用的编码，主键
	@RequestMapping(value = "md/mr/Dimen/getNewCode", method = RequestMethod.GET)
	String getNewCode(@RequestParam Map map);
	
	//添加 链接元素列表 主表	
	@RequestMapping(value = "/md/mr/Dimen/code", method = RequestMethod.POST)
	SingleResult<MetaElement> createDataElememtDimenCode(@ModelAttribute MetaElement model);
	//更新链接元素编码 名称
	@RequestMapping(value = "/md/mr/Dimen/code/{id}", method = RequestMethod.PUT)
	SingleResult<MetaElement> updateDataElememtDimenCode(@PathVariable("id") String id ,@ModelAttribute MetaElement value);
	//删除 链接元素列表 主表	
	@RequestMapping(value = "/md/mr/Dimen/code", method = RequestMethod.DELETE)
   SingleResult<BatchOperationResult> deleteDataElememtDimenCodeList(@ModelAttribute ArrayInputModel delModel);
	//获取 链接元素列表 明细表	
	@RequestMapping(value = "/md/mr/Dimen/code/{dataElementCd}", method = RequestMethod.GET)
    ArrayResult<MetaElementValue> getDataElememtDimenValueList(@PathVariable("dataElementCd") String dataElementCd);
	//获取最新的可用的编码，主键
	@RequestMapping(value = "md/mr/Dimen/getNewValueCode", method = RequestMethod.GET)
	String getNewValueCode(@RequestParam Map map);
 //添加 链接元素列表 明细表	
	@RequestMapping(value = "/md/mr/Dimen/value", method = RequestMethod.POST)
	SingleResult<MetaElementValue> createDataElememtDimenValue(@ModelAttribute MetaElementSaveModel model);
	//更新链接元素的码表
	@RequestMapping(value = "/md/mr/Dimen/value/{id}", method = RequestMethod.PUT)
	SingleResult<MetaElementValue> updateDataElememtDimenValue(@PathVariable("id") String id ,@ModelAttribute MetaElementSaveModel value);
   //删除 链接元素列表 明细表		
	@RequestMapping(value = "/md/mr/Dimen/value", method = RequestMethod.DELETE)
   SingleResult<BatchOperationResult> deleteDataElememtDimenValueList(@ModelAttribute ArrayInputModel delModel);
	   //获取码表 中code的最新值	
		@RequestMapping(value = "/md/mr/Dimen/value/codeValue", method = RequestMethod.GET)
		SingleResult<String> getDataElememtDimenValueCodeFromDB(@RequestParam("dataElementCd") String dataElementCd);
	   
}
