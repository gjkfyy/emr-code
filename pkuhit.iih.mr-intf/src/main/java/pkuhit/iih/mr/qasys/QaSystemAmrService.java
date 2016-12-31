package pkuhit.iih.mr.qasys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.qasys.QaSystemAmr;

public interface QaSystemAmrService {
	/**
	 *  【医疗质控体系病案】查询服务（单记录）
	 * @param String id
	 * @return QaSystemAmr
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qasys/amr/{id}", method = RequestMethod.GET)
	QaSystemAmr search(String id) throws Throwable;
}
