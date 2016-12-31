package pkuhit.iih.mr.qasys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.qasys.QaSystemSegment;

public interface QaSystemSegementService {
	/**
	 *  【医疗质控体系段落】查询服务（单记录）
	 * @param String id
	 * @return QaSystemSegment
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qasys/segment/{id}", method = RequestMethod.GET)
	QaSystemSegment search(String id) throws Throwable;
}
