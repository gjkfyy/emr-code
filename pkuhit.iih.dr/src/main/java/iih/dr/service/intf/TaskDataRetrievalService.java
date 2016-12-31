package iih.dr.service.intf;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TaskDataRetrievalService
 * @author cheng_feng
 * @version 0.0.0
 */
public interface TaskDataRetrievalService {
	
	/**
	 * 根据检索方案查询出符合条件的病案，并根据条件拆出病历内容存到数据库表中
	 */
	@RequestMapping(value = "/dr/search/retrieval", method = RequestMethod.GET)
	String searchRetrieval();
	
}
