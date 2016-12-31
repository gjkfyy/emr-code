package pkuhit.iih.iemr.qa.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class QaUtil {

	public String getStringValueFromMap(Map map,String key){
		String value = null ;
		if(map.containsKey(key)){
			value = (String)map.get(key);
			if(StringUtils.isBlank(value)){
				value = null ;
			}
		}
		return value;
	}
}
