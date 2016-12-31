package pkuhit.iih.iemr.qa;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.qasys.QaSystemQaItem;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

public interface QaSystemItemService {
	/**
	 * 【医疗质控体系质控项目】查询服务（单记录）
	 * 
	 * @param String
	 *            id
	 * @return QaSystemItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qasys/item/{id}", method = RequestMethod.GET)
	QaSystemQaItem search(String id) throws Throwable;

	/**
	 * 【医疗质控体系质控项目】查询服务（多记录）
	 * 
	 * @param QaSystemItem
	 *            condition
	 * @return List<QaSystemItem>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qasys/item/{id}/f", method = RequestMethod.GET)
	List<QaSystemQaItem> search(QaSystemQaItem condition) throws Throwable;

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
	@RequestMapping(value = "/mr/qasys/item", method = RequestMethod.GET)
	ArrayResult<QaSystemQaItem> search(@RequestParam Map condition) throws Throwable;
}
