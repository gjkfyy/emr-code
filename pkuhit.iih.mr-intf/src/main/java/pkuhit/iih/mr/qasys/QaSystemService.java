package pkuhit.iih.mr.qasys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pkuhit.iih.qa.qasys.QaSystem;

public interface QaSystemService {

	/**
	 *  【医疗质控体系】查询服务（单记录）
	 * @param String id
	 * @return QaSystem
	 * @throws Throwable
	 */
	@RequestMapping(value = "/mr/qasys/{id}", method = RequestMethod.GET)
	QaSystem search(String id) throws Throwable;
		
}
