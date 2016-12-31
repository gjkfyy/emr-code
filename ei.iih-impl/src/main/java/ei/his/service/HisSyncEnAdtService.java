package ei.his.service;

import java.util.Map;

import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 * 从His中 同步 “转科记录”
 */
public interface HisSyncEnAdtService {
	void SychronizeEncounterAdtFromHis(@RequestParam Map map);
}
