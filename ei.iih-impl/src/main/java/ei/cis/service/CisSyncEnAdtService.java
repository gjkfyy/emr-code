package ei.cis.service;

import java.util.Map;

import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 *从Cis中 同步 “转科记录”
 */
public interface CisSyncEnAdtService {
	void SychronizeEncounterAdtFromCis(@RequestParam Map map);
}
