package pkuhit.xap.encoding;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


public class PinyinChineseEncodingImpl implements ChineseEncoding{
	
	@Autowired
	ChineseEncodingCodesService chineseEncodingCodesService;
	
	@Override
	public String encode(String sourceString) {
		// TODO 暂时采用缓存实现
		if (sourceString == null || "".equals(sourceString))
        {
            return sourceString;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceString.length(); i++)
        {
            char ch = sourceString.charAt(i);
            Character code = getSimpleCode(ch);
            if (code == null)
            {
                // 如果ch非汉字，则保持原样
                sb.append(ch);
            }
            else
            {
                sb.append(code);
            }
        }
        return sb.toString();
	}
	
	/**
     * 获取单个汉字的拼音简码或五笔简码
     * @param ch 单个汉字
     * @param codeType 拼音或五笔
     * @return
     * 如果非汉字返回null
     */
    public Character getSimpleCode(char ch)
    {
        Map<Character, String> codeMap = null;
        codeMap = chineseEncodingCodesService.getChineseEncodingCodes();
        Set<Entry<Character, String>> entrySet = codeMap.entrySet();
        for (Entry<Character, String> entry : entrySet)
        {
            if (entry.getValue().contains(ch + ""))
            {
                return entry.getKey();
            }
        }
        return null;
    }


}
