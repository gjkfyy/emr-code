package pkuhit.iih.pub;

public class FirstLetterUtil {    
    private static int BEGIN = 45217;    
    private static int END = 63486;
    private static char[] chartable = {'啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈', '哈', '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然', '撒', '塌', '塌', '塌', '挖', '昔', '压', '匝',};    
    private static int[] table = new int[27];
    private static char[] initialtable = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 't', 't', 'w', 'x', 'y', 'z',};
    // 初始化    
    static {        
        for (int i = 0; i < 26; i++) {            
            table[i] = gbValue(chartable[i]);
        }        
        table[26] = END;
    }
    
    public static String getFirstLetter(String sourceStr) {        
        String result = "";        
        String str = sourceStr.toLowerCase();        
        int StrLength = str.length();        
        int i;        
        try {            
            for (i = 0; i < StrLength; i++) {                
                result += Char2Initial(str.charAt(i));           
            }       
        } catch (Exception e) {            
            result = "";        
        }       
        return result;    
    }
    
    private static char Char2Initial(char ch) {   
        if (ch >= 'a' && ch <= 'z') {            
            return ch;        
        }        
        if (ch >= 'A' && ch <= 'Z') {
            return ch;        
        }  
        int gb = gbValue(ch);
        if ((gb < BEGIN) || (gb > END)) {            
            return ch;       
        }
        int i;        
        for (i = 0; i < 26; i++) {
            if ((gb >= table[i]) && (gb < table[i + 1])) {                
                break;
            }
        }
        if (gb == END) {
            i = 25;        
        }        
        return initialtable[i];
    }
    
    private static int gbValue(char ch) {
        String str = new String();        
        str += ch;        
        try {            
            byte[] bytes = str.getBytes("GB2312");            
            if (bytes.length < 2) {                
                return 0;            
            }            
            return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);        
        } catch (Exception e) {            
            return 0;        
        }
    }

    public static void main(String[] args)   {
          System.out.print(getFirstLetter("呼吸内科门诊出诊病历"));//获取文字首字母的拼音
         
    }
}