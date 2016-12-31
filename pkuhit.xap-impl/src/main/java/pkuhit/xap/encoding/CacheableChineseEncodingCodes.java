package pkuhit.xap.encoding;

import java.util.Map;
import org.springframework.cache.Cache;
import xap.sv.service.cache.CacheableService;

public class CacheableChineseEncodingCodes extends CacheableService<Object> implements ChineseEncodingCodesDao{

	private static String CACHE_NAME = CacheableChineseEncodingCodes.class.getName()+"_code_cache";
	
	public static String CODE_TYPE_WUBI = "wubi";
	public static String CODE_TYPE_PINYIN = "pinyin";
	
	@Override
	protected String getCacheName() {
		// TODO Auto-generated method stub
		return CACHE_NAME;
	}

	@Override
	protected Object getDelegate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void saveChineseEncodingCodes(Map<Character, String> map) {
		// TODO Auto-generated method stub
		Cache cache = getCache();
		cache.put(CODE_TYPE_PINYIN, map);
	}

	@Override
	public Map<Character, String> getChineseEncodingCodes() {
		// TODO Auto-generated method stub
		Cache cache = getCache();
		Map<Character, String> map = (Map<Character, String>) cache.get(CODE_TYPE_PINYIN).get();
		return map;
	}

}
