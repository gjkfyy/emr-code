package pkuhit.iih.qa;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.old.QaItem;

public interface QaItemService {

	/**
	 *  【医疗记录质控项目】新建服务（单记录）
	 * @param QaItem value
	 * @return QaItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qa/item", method = RequestMethod.POST)
	QaItem create(QaItem value) throws Throwable;
	

	/**
	 * 【医疗记录质控项目】删除服务（单记录）
	 * @param id
	 * @return QaItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qa/item/{id}", method = RequestMethod.GET)
	QaItem delete(String id) throws Throwable;
	
	/**
	 *  【医疗记录质控项目】更新服务（单记录）
	 * @param QaItem value
	 * @return QaItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qa/item/{id}", method = RequestMethod.PUT)
	QaItem update(QaItem value) throws Throwable;
	
	/**
	 *  【医疗记录质控项目】查询服务（单记录）
	 * @param String id
	 * @return QaItem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qa/item/{id}", method = RequestMethod.GET)
	QaItem searchById(String id) throws Throwable;
	
	/**
	 *  【医疗记录质控项目】查询服务（多记录）
	 * @param String id
	 * @return List<QaItem>
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qa/items", method = RequestMethod.GET)
	List<QaItem> search(QaItem condition) throws Throwable;	
	
}
