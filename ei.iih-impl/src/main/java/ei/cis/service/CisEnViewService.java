package ei.cis.service;

import java.util.List;
import java.util.Map;

import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author wangyanli
 *从Cis 视图读取患者就诊信息 代替读取mr_amr表
 */
public interface CisEnViewService {
	
	public List<Map<String, Object>> searchEncounterFromViewList(Map<String, Object> map);
}
