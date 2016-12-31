/**
 * 
 */
package ei.iih.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.SysFunctionCode;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import ei.cis.service.CisSyncEnAdtService;
import ei.his.service.HisSyncEnAdtService;
import ei.iih.service.EnAdtService;

/**
 * @author guo_zhongbao
 *  同步转科记录实现
 */
public class EnAdtServiceImpl implements EnAdtService {
	private Logger log = LoggerFactory.getLogger(EnAdtServiceImpl.class);
	@Reference
	ParamsSetService paramsSetService;
	
	@Autowired
	HisSyncEnAdtService hisSyncEnAdtService;
	
	@Autowired
	CisSyncEnAdtService cisSyncEnAdtService;
	/* (non-Javadoc)
	 * @see ei.iih.service.impl.EnAdtService#syncEnAdt()
	 */
	@Override
	public String syncEnAdt() {
		//读取转科记录数据源， 0-本库   1-his 2-cis 3-第三方其他数据源
		SingleResult<Map> rsMapParam = paramsSetService.searchByCode(SysFunctionCode.DATA_SOURCE);
		if(null != rsMapParam && null != rsMapParam.getData()){
			if(rsMapParam.getData().containsKey("EN_ADT_DS")){
				String value = rsMapParam.getData().get("EN_ADT_DS").toString();
				if("0".equalsIgnoreCase(value) ){
					//从his读取转科记录
					log.info("系统参数表中code为SYSM01.16,key为EN_ADT_DS的value为0");
				}else if("1".equalsIgnoreCase(value) ){
					//从his读取转科记录
					hisSyncEnAdtService.SychronizeEncounterAdtFromHis(null);
					log.info("系统参数表中code为SYSM01.16,key为EN_ADT_DS的value为1(his)");
					
				}else 	if("2".equalsIgnoreCase(value) ){
					cisSyncEnAdtService.SychronizeEncounterAdtFromCis(null);
					//从cis读取转科记录
					log.info("系统参数表中code为SYSM01.16,key为EN_ADT_DS的value为2(cis)");
				}
			}
			else{
				log.info("系统参数表中不存在key为EN_ADT_DS的数据记录");
			}
			
		}else{
			log.info("系统参数表中不存在code为SYSM01.16的数据记录");
		}
		return null;
	}
	

}
