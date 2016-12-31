/**
 * 
 */
package ei.iih.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author guo_zhongbao
 *  转科记录接口
 */
public interface EnAdtService {
	//从第三方数据源同步"转科记录"
	@RequestMapping(value = "/ei/sync/en/adt", method = RequestMethod.GET)
	String syncEnAdt() ;
	

}
