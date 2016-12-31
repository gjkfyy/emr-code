package pkuhit.xap.encoding;

import java.util.Map;


public interface ChineseEncodingCodesDao {
	
	public void saveChineseEncodingCodes(Map<Character, String> map);
	
	public Map<Character, String> getChineseEncodingCodes();
}
