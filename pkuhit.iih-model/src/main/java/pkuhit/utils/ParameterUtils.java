package pkuhit.utils;

/**
 * @author guo_zhongbao
 *  参数转换类
 */
public class ParameterUtils {
	//直接按enpk进行查询本地数据库
	public static final String ASS_DS_LOCAL = "local";
	//直接按enpk进行查询第三方数据源
	public static final String ASS_DS_ENPK_DIRECT = "direct";
	//把enPk拆成pa_id和times进行查询第三方数据源
	public static final String ASS_DS_ENPK_SPLIT = "split";
	//查询模式为 tocis，使用于与cis集成的第三方系统
	public static String ASS_DS_TOCIS = "tocis";
	//从集成平台进行查询
	public static String ASS_DS_IEREST = "ierest";
	
	public static final String LAB_READ_FROM_VIEW_KEY = "LAB_READ_FROM_VIEW"; //从视图中读取检验报告
	public static final String OB_READ_FROM_VIEW_KEY = "OB_READ_FROM_VIEW"; //从视图中读取检查报告
	
    public static String enType2DeptType(String enTypeCode){
    	String deptTypeCode = null ;
    	if(null == enTypeCode){
    		return null ;
    	}else if(enTypeCode.equalsIgnoreCase("ENM01.04")){
    		deptTypeCode = "ORGM02.01"; //住院
    	}else if(enTypeCode.equalsIgnoreCase("ENM01.01")){
    		deptTypeCode = "ORGM02.05"; //门诊
    	}
    	return deptTypeCode;
    }
    //按指定分隔字符串表达式分隔字符串
    public static String[] splitEnPk(String enPk,String splitStr) {
    	String[] arr = null ;
    	
		if(null!= enPk && null !=splitStr && enPk.contains(splitStr)){
			 arr = enPk.split(splitStr);
		}
		return arr;
    }
    //自行分隔字符
    public static String[] splitEnPk(String enPk) {
    	return splitEnPk(enPk,getSplitStr(enPk));
    }
    public static void main(String[] arg) {
    	getSplitStr("5_a");
    }
    
    //根据字符串，可以获得分隔字符
    public static String getSplitStr(String buff){

     	String tmpString =buff.replaceAll("(?i)[a-zA-Z0-9\u4E00-\u9FA5]", "");//保留非【数字 a-z A-z】
    	System.out.println(tmpString.trim());

    	return tmpString;

    }
}
