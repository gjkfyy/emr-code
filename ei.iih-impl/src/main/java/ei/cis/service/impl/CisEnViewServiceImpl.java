package ei.cis.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import ei.cis.db.dao.CisEnViewDao;
import ei.cis.service.CisEnViewService;

/**
 * @author wangyanli
 *从Cis 视图读取患者就诊信息 代替读取mr_amr表
 */
public class CisEnViewServiceImpl implements CisEnViewService{

	@Autowired
	CisEnViewDao cisEnViewDao;
	
	@Override
	public List<Map<String, Object>> searchEncounterFromViewList(
			Map<String, Object> map) {
		
		List<Map<String, Object>> mrAmrList = null; //患者列表
		String keyword = getStringValueFromMap(map, "keyword");
		String deptCd = getStringValueFromMap(map, "deptCd");
		String userId = getStringValueFromMap(map, "userId");
		String enTpCd = getStringValueFromMap(map, "enTpCd");
		String groupType = getStringValueFromMap(map, "groupType");
		String patientName = getStringValueFromMap(map, "patientName");
		String amrNo = getStringValueFromMap(map, "amrNo");
		String currentBedCode = getStringValueFromMap(map, "currentBedCode");
		String startDate = getStringValueFromMap(map, "startDate");
		String endDate = getStringValueFromMap(map, "endDate");
		String curMgDctId = getStringValueFromMap(map, "curMgDctId");
		String curMgNurId = getStringValueFromMap(map, "curMgNurId");
		SelectOptions options = null;
		if(map.containsKey("options") && null != map.get("options")){
			options = (SelectOptions)map.get("options");
		}
		mrAmrList = cisEnViewDao.selectEncounterFromViewByCondition(keyword, deptCd, userId, enTpCd, groupType, patientName, amrNo, currentBedCode, startDate, endDate, curMgDctId, options);
		return mrAmrList;
	}
	
	private String getStringValueFromMap(Map map,String key){
		String value = "";//null ;
		if(map.containsKey(key) && null != map.get(key)){
			value = (String)map.get(key);
			if(StringUtils.isBlank(value)){
				value = "";//null ;
			}
		}
		return value;
	}
	
}
