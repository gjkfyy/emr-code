package pkuhit.iih.iemr.qa;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.old.QaNItem;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface QaItemService {
	
	/**
	 * 【医疗质控体系质控项目】查询服务（多记录）
	 * 
	 * @param QaSystemItem condition <br/>
	 *            enPk 就诊序号●<br>
	 *            mrTemplateCode 医疗记录类型编码 *<br>
	 *            mrSegmentTemplateCode 医疗记录段落类型编码<br>
	 * @return List<QaSystemItem>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qasys/item1", method = RequestMethod.GET)
	ArrayResult<QaNItem> search(@RequestParam Map condition) throws Throwable;
}
