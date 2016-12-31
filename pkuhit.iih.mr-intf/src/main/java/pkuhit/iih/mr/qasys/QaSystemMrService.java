package pkuhit.iih.mr.qasys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.qasys.QaSystemMr;

public interface QaSystemMrService {
	/**
	 *  【医疗质控体系医疗记录】查询服务（单记录）
	 * @param String id
	 * @return QaSystemMr
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qasys/mr/{id}", method = RequestMethod.GET)
	QaSystemMr search(String id) throws Throwable;
}
