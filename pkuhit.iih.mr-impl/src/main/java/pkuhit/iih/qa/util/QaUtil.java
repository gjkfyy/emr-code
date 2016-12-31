package pkuhit.iih.qa.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import pkuhit.iih.qa.dao.qacustom.CusQaMrAmrDao;
import pkuhit.iih.qa.qacustom.bizmodel.QaFaultStatistical;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;


public class QaUtil {

	public static String getStringValueFromMap(Map map,String key){
		String value = null ;
		if(map.containsKey(key)){
			value = (String)map.get(key);
			if(StringUtils.isBlank(value)){
				value = null ;
			}
		}
		return value;
	}
	
	public static Map getSessionInfo(){
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		
		Map userMap = new HashMap();
		userMap.put("userId", userId);
		userMap.put("deptId", deptId );
		
		return userMap;
	}
	
	/**
	 * 计算日期，系统时间 + days（天数）
	 * 
	 * @param days
	 *            天
	 * @return
	 */
	public static Date dateIncreaseByDays(Date currentDate, int days) {
		return new Date(currentDate.getTime() + days * 24 * 3600 * 1000);
	}
	
	/**
	 * 计算日期，系统时间 + days（天数）
	 * 
	 * @param days
	 *            天
	 * @return
	 */
	public static Date dateIncreaseByHours(Date currentDate, int hours) {
		int intval = 0;
		if(hours > 700){
			intval = hours * 3600 * 500;
			return new Date(currentDate.getTime() + intval+intval);
		}
		return new Date(currentDate.getTime()+ hours * 3600 * 1000);
	}
	
	/**
	* 计算两个日期的时间差
	* @param formatTime1
	* @param formatTime2
	* @return
	*/
	public static int[] getTimeDifference(Timestamp formatTime1, Timestamp formatTime2) {
		SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		long t1 = 0L;
		long t2 = 0L;
		try {
			t1 = timeformat.parse(getTimeStampNumberFormat(formatTime1)).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			t2 = timeformat.parse(getTimeStampNumberFormat(formatTime2)).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//因为t1-t2得到的是毫秒级,所以要初3600000得出小时.算天数或秒同理
		int hours=(int) ((t1 - t2)/3600000);
		int minutes=(int) (((t1 - t2)/1000-hours*3600)/60);
		int second=(int) ((t1 - t2)/1000-hours*3600-minutes*60);
		int[] rs = new int[3] ;
		
		rs[0] = hours;
		rs[1] = minutes;
		rs[2] = second;
		
		return rs;//""+hours+"小时"+minutes+"分"+second+"秒";
	}
	/**
	* 格式化时间
	* Locale是设置语言敏感操作
	* @param formatTime
	* @return
	*/
	public static String getTimeStampNumberFormat(Timestamp formatTime) {
	SimpleDateFormat m_format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", new Locale("zh", "cn"));
	return m_format.format(formatTime);
	}
	
	/**
	* 格式化时间
	* @param 参数数组必须保证0时1分2秒
	* @return
	*/
	public static String formatSurplusTime(int[] surplusTime,String format) {
		
		int hours,mins,seconds;
		String returnValue ="";
		if(format.equals("H")){
			hours = surplusTime[0];
			returnValue = hours+"小时";
			
		}else if(format.equals("H:M")){
			hours = surplusTime[0];
			mins = surplusTime[1];
			if(( hours > 0 && mins < 0 ) || ( hours < 0 && mins > 0 )){
				hours = hours-1;
				mins = 60 + mins;
				
			}else if(hours < 0 && mins < 0){
				mins = -mins;
				
			}
			if(hours!=0){
				returnValue = hours+"小时";
			}
			if(mins!=0){
				returnValue = returnValue+mins+"分";
			}
			
		}else if(format.equals("H:M:S")){
			//todo
		}
		
	return returnValue;
	}
	
	/**
	* 格式化时间
	* @param 参数数组必须保证0时1分2秒
	* @return
	*/
	public static Timestamp formatTimestampFromDate(Date dateTime) {
		Timestamp returnValue = null;
		if(null != dateTime){
			returnValue = new Timestamp(dateTime.getTime());
		}
		return returnValue;
	}
	public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {/*  
	    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();  
	    ObjectOutputStream out = new ObjectOutputStream(byteOut);  
	    out.writeObject(src);  
	  
	    ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());  
	    ObjectInputStream in = new ObjectInputStream(byteIn);  
	    @SuppressWarnings("unchecked")  
	    List<T> dest = (List<T>) in.readObject();  
	    return dest;  
	*/
		return null;
		} 
	
	public static String amrFinishBtnFlag(CusQaMrAmrDao cusQaMrAmrDao,DictionaryService dictionaryService, String encounterPk, String qaTypeCode) {
		/*调用服务判断表格中按钮状态*/
		String btnFlag="0";
		Map map = cusQaMrAmrDao.selectAmrFaultNoticeNum(encounterPk, qaTypeCode);
		QaFaultStatistical 	qaFaultStatistical = new QaFaultStatistical();
		BeanCopyUtil.mapToModel(qaFaultStatistical, map, dictionaryService);
		if(qaFaultStatistical!=null){
			BigDecimal toReform=qaFaultStatistical.getToReform();
			BigDecimal reformed=qaFaultStatistical.getReformed();
			BigDecimal otherState=qaFaultStatistical.getOtherState();
//				BigDecimal revisionNum=qaFaultStatistical.getRevisionNum();
			int toReformNum = 0;
			if(toReform!=null){
				toReformNum = toReform.intValue();
			}
			int reformedNum = 0;
			if(reformed!=null){
				reformedNum = reformed.intValue();
			}
			int otherStateNum = 0;
			if(otherState!=null){
				otherStateNum = otherState.intValue();
			}
			/*int revisionNumber = 0;
			if(revisionNum!=null){
				revisionNumber = revisionNum.intValue();
			}*/
			if(reformedNum>0 || toReformNum>0){
				btnFlag = "1";
			}else if(otherStateNum>0){
				int revisionNumber = cusQaMrAmrDao.selectQaNoticeNum(encounterPk, qaTypeCode);
				if(revisionNumber >0){
					btnFlag = "1";
				}else{
					btnFlag = "2";
				}
			}else{
				btnFlag = "2";
			}
		}
		return btnFlag;
	}
	 public static void main(String[] args) { 
		
	}
}
