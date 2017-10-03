package pkuhit.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class DateUtil {
	// ~ Static fields/initializers  
    // =============================================  
	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    private static String defaultDatePattern = null;  
    private static String timePattern = "HH:mm";  
    private static Calendar cale = Calendar.getInstance();  
    public static final String TS_FORMAT = DateUtil.getDatePattern() + " HH:mm:ss.S";  
    /** 日期格式yyyy-MM字符串常量 */  
    private static final String MONTH_FORMAT = "yyyy-MM";  
    /** 日期格式yyyy-MM-dd字符串常量 */  
    private static final String DATE_FORMAT = "yyyy-MM-dd";  
    /** 日期格式HH:mm:ss字符串常量 */  
    private static final String HOUR_FORMAT = "HH:mm:ss";  
    /** 日期格式yyyy-MM-dd HH:mm:ss字符串常量 */  
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";  
    /** 某天开始时分秒字符串常量  00:00:00 */  
    private static final String DAY_BEGIN_STRING_HHMMSS = " 00:00:00";  
    /**  某天结束时分秒字符串常量  23:59:59  */  
    public static final String DAY_END_STRING_HHMMSS = " 23:59:59";  
    private static SimpleDateFormat sdf_date_format = new SimpleDateFormat(DATE_FORMAT);  
    private static SimpleDateFormat sdf_hour_format = new SimpleDateFormat(HOUR_FORMAT);  
    private static SimpleDateFormat sdf_datetime_format = new SimpleDateFormat(DATETIME_FORMAT);  
      
  
    // ~ Methods  
    // ================================================================  
  
    public DateUtil() {  
    }  
  
    /** 
     * 获得服务器当前日期及时间，以格式为：yyyy-MM-dd HH:mm:ss的日期字符串形式返回 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getDateTime() {  
        try {  
            return sdf_datetime_format.format(cale.getTime());  
        } catch (Exception e) {  
            logger.debug("DateUtil.getDateTime():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /** 
     * 获得服务器当前日期，以格式为：yyyy-MM-dd的日期字符串形式返回 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getDate() {  
        try {  
            return sdf_date_format.format(cale.getTime());  
        } catch (Exception e) {  
            logger.debug("DateUtil.getDate():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /** 
     * 获得服务器当前时间，以格式为：HH:mm:ss的日期字符串形式返回 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getTime() {  
        String temp = " ";  
        try {  
            temp += sdf_hour_format.format(cale.getTime());  
            return temp;  
        } catch (Exception e) {  
            logger.debug("DateUtil.getTime():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /** 
     * 统计时开始日期的默认值 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getStartDate() {  
        try {  
            return getYear() + "-01-01";  
        } catch (Exception e) {  
            logger.debug("DateUtil.getStartDate():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /** 
     * 统计时结束日期的默认值 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getEndDate() {  
        try {  
            return getDate();  
        } catch (Exception e) {  
            logger.debug("DateUtil.getEndDate():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /** 
     * 获得服务器当前日期的年份 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getYear() {  
        try {  
            return String.valueOf(cale.get(Calendar.YEAR));  
        } catch (Exception e) {  
            logger.debug("DateUtil.getYear():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /** 
     * 获得服务器当前日期的月份 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getMonth() {  
        try {  
            java.text.DecimalFormat df = new java.text.DecimalFormat();  
            df.applyPattern("00;00");  
            return df.format((cale.get(Calendar.MONTH) + 1));  
        } catch (Exception e) {  
            logger.debug("DateUtil.getMonth():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /** 
     * 获得服务器在当前月中天数 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getDay() {  
        try {  
            return String.valueOf(cale.get(Calendar.DAY_OF_MONTH));  
        } catch (Exception e) {  
            logger.debug("DateUtil.getDay():" + e.getMessage());  
            return "";  
        }  
    }  
  
    /** 
     * 比较两个日期相差的天数 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static int getMargin(String date1, String date2) {  
        int margin;  
        try {  
            ParsePosition pos = new ParsePosition(0);  
            ParsePosition pos1 = new ParsePosition(0);  
            Date dt1 = sdf_date_format.parse(date1, pos);  
            Date dt2 = sdf_date_format.parse(date2, pos1);  
            long l = dt1.getTime() - dt2.getTime();  
            margin = (int) (l / (24 * 60 * 60 * 1000));  
            return margin;  
        } catch (Exception e) {  
            logger.debug("DateUtil.getMargin():" + e.toString());  
            return 0;  
        }  
    }  
  
    /** 
     * 比较两个日期相差的天数 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static double getDoubleMargin(String date1, String date2) {  
        double margin;  
        try {  
            ParsePosition pos = new ParsePosition(0);  
            ParsePosition pos1 = new ParsePosition(0);  
            Date dt1 = sdf_datetime_format.parse(date1, pos);  
            Date dt2 = sdf_datetime_format.parse(date2, pos1);  
            long l = dt1.getTime() - dt2.getTime();  
            margin = (l / (24 * 60 * 60 * 1000.00));  
            return margin;  
        } catch (Exception e) {  
            logger.debug("DateUtil.getMargin():" + e.toString());  
            return 0;  
        }  
    }  
  
    /** 
     * 比较两个日期相差的月数 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static int getMonthMargin(String date1, String date2) {  
        int margin;  
        try {  
            margin = (Integer.parseInt(date2.substring(0, 4)) - Integer.parseInt(date1.substring(0, 4))) * 12;  
            margin += (Integer.parseInt(date2.substring(4, 7).replaceAll("-0",  
                    "-")) - Integer.parseInt(date1.substring(4, 7).replaceAll("-0", "-")));  
            return margin;  
        } catch (Exception e) {  
            logger.debug("DateUtil.getMargin():" + e.toString());  
            return 0;  
        }  
    }  
  
    /** 
     * 返回日期加X天后的日期 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param date 
     * @param i 
     * @return 
     */  
    public static String addDay(String date, int i) {  
        try {  
            GregorianCalendar gCal = new GregorianCalendar(  
                    Integer.parseInt(date.substring(0, 4)),   
                    Integer.parseInt(date.substring(5, 7)) - 1,   
                    Integer.parseInt(date.substring(8, 10)));  
            gCal.add(GregorianCalendar.DATE, i);  
            return sdf_date_format.format(gCal.getTime());  
        } catch (Exception e) {  
            logger.debug("DateUtil.addDay():" + e.toString());  
            return getDate();  
        }  
    }  
  
    /** 
     * 返回日期加X月后的日期 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param date 
     * @param i 
     * @return 
     */  
    public static String addMonth(String date, int i) {  
        try {  
            GregorianCalendar gCal = new GregorianCalendar(  
                    Integer.parseInt(date.substring(0, 4)),   
                    Integer.parseInt(date.substring(5, 7)) - 1,   
                    Integer.parseInt(date.substring(8, 10)));  
            gCal.add(GregorianCalendar.MONTH, i);  
            return sdf_date_format.format(gCal.getTime());  
        } catch (Exception e) {  
            logger.debug("DateUtil.addMonth():" + e.toString());  
            return getDate();  
        }  
    }  
  
    /** 
     * 返回日期加X年后的日期 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param date 
     * @param i 
     * @return 
     */  
    public static String addYear(String date, int i) {  
        try {  
            GregorianCalendar gCal = new GregorianCalendar(  
                    Integer.parseInt(date.substring(0, 4)),   
                    Integer.parseInt(date.substring(5, 7)) - 1,   
                    Integer.parseInt(date.substring(8, 10)));  
            gCal.add(GregorianCalendar.YEAR, i);  
            return sdf_date_format.format(gCal.getTime());  
        } catch (Exception e) {  
            logger.debug("DateUtil.addYear():" + e.toString());  
            return "";  
        }  
    }  
  
    /** 
     * 返回某年某月中的最大天 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param year 
     * @param month 
     * @return 
     */  
    public static int getMaxDay(int iyear, int imonth) {  
        int day = 0;  
        try {  
            if (imonth == 1 || imonth == 3 || imonth == 5 || imonth == 7  
                    || imonth == 8 || imonth == 10 || imonth == 12) {  
                day = 31;  
            } else if (imonth == 4 || imonth == 6 || imonth == 9 || imonth == 11) {  
                day = 30;  
            } else if ((0 == (iyear % 4)) && (0 != (iyear % 100)) || (0 == (iyear % 400))) {  
                day = 29;  
            } else {  
                day = 28;  
            }  
            return day;  
        } catch (Exception e) {  
            logger.debug("DateUtil.getMonthDay():" + e.toString());  
            return 1;  
        }  
    }  
  
    /** 
     * 格式化日期 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param orgDate 
     * @param Type 
     * @param Span 
     * @return 
     */  
    @SuppressWarnings("static-access")  
    public String rollDate(String orgDate, int Type, int Span) {  
        try {  
            String temp = "";  
            int iyear, imonth, iday;  
            int iPos = 0;  
            char seperater = '-';  
            if (orgDate == null || orgDate.length() < 6) {  
                return "";  
            }  
  
            iPos = orgDate.indexOf(seperater);  
            if (iPos > 0) {  
                iyear = Integer.parseInt(orgDate.substring(0, iPos));  
                temp = orgDate.substring(iPos + 1);  
            } else {  
                iyear = Integer.parseInt(orgDate.substring(0, 4));  
                temp = orgDate.substring(4);  
            }  
  
            iPos = temp.indexOf(seperater);  
            if (iPos > 0) {  
                imonth = Integer.parseInt(temp.substring(0, iPos));  
                temp = temp.substring(iPos + 1);  
            } else {  
                imonth = Integer.parseInt(temp.substring(0, 2));  
                temp = temp.substring(2);  
            }  
  
            imonth--;  
            if (imonth < 0 || imonth > 11) {  
                imonth = 0;  
            }  
  
            iday = Integer.parseInt(temp);  
            if (iday < 1 || iday > 31)  
                iday = 1;  
  
            Calendar orgcale = Calendar.getInstance();  
            orgcale.set(iyear, imonth, iday);  
            temp = this.rollDate(orgcale, Type, Span);  
            return temp;  
        } catch (Exception e) {  
            return "";  
        }  
    }  
  
    public static String rollDate(Calendar cal, int Type, int Span) {  
        try {  
            String temp = "";  
            Calendar rolcale;  
            rolcale = cal;  
            rolcale.add(Type, Span);  
            temp = sdf_date_format.format(rolcale.getTime());  
            return temp;  
        } catch (Exception e) {  
            return "";  
        }  
    }  
  
    /** 
     * 返回默认的日期格式 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static synchronized String getDatePattern() {  
        defaultDatePattern = "yyyy-MM-dd";  
        return defaultDatePattern;  
    }  
  
    /** 
     * 将指定日期按默认格式进行格式代化成字符串后输出如：yyyy-MM-dd 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param aDate 
     * @return 
     */  
    public static final String getDate(Date aDate) {  
        SimpleDateFormat df = null;  
        String returnValue = "";  
        if (aDate != null) {  
            df = new SimpleDateFormat(getDatePattern());  
            returnValue = df.format(aDate);  
        }  
        return (returnValue);  
    }  
  
    /** 
     * 取得给定日期的时间字符串，格式为当前默认时间格式 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param theTime 
     * @return 
     */  
    public static String getTimeNow(Date theTime) {  
        return getDateTime(timePattern, theTime);  
    }  
  
    /** 
     * 取得当前时间的Calendar日历对象 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     * @throws ParseException 
     */  
    public Calendar getToday() throws ParseException {  
        Date today = new Date();  
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());  
        String todayAsString = df.format(today);  
        Calendar cal = new GregorianCalendar();  
        cal.setTime(convertStringToDate(todayAsString));  
        return cal;  
    }  
  
    /** 
     * 将日期类转换成指定格式的字符串形式 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param aMask 
     * @param aDate 
     * @return 
     */  
    public static final String getDateTime(String aMask, Date aDate) {  
        SimpleDateFormat df = null;  
        String returnValue = "";  
  
        if (aDate == null) {  
            logger.error("aDate is null!");  
        } else {  
            df = new SimpleDateFormat(aMask);  
            returnValue = df.format(aDate);  
        }  
        return (returnValue);  
    }  
  
    /** 
     * 将指定的日期转换成默认格式的字符串形式 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param aDate 
     * @return 
     */  
    public static final String convertDateToString(Date aDate) {  
        return getDateTime(getDatePattern(), aDate);  
    }  
  
    /** 
     * 将日期字符串按指定格式转换成日期类型 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param aMask 指定的日期格式，如:yyyy-MM-dd 
     * @param strDate 待转换的日期字符串 
     * @return 
     * @throws ParseException 
     */  
    public static final Date convertStringToDate(String aMask, String strDate)  
            throws ParseException {  
        SimpleDateFormat df = null;  
        Date date = null;  
        df = new SimpleDateFormat(aMask);  
  
        if (logger.isDebugEnabled()) {  
            logger.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");  
        }  
        try {  
            date = df.parse(strDate);  
        } catch (ParseException pe) {  
            logger.error("ParseException: " + pe);  
            throw pe;  
        }  
        return (date);  
    }  
  
    /** 
     * 将日期字符串按默认格式转换成日期类型 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param strDate 
     * @return 
     * @throws ParseException 
     */  
    public static Date convertStringToDate(String strDate)  
            throws ParseException {  
        Date aDate = null;  
  
        try {  
            if (logger.isDebugEnabled()) {  
                logger.debug("converting date with pattern: " + getDatePattern());  
            }  
            aDate = convertStringToDate(getDatePattern(), strDate);  
        } catch (ParseException pe) {  
            logger.error("Could not convert '" + strDate + "' to a date, throwing exception");  
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());  
        }  
        return aDate;  
    }  
  
    /** 
     * 返回一个JAVA简单类型的日期字符串 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    public static String getSimpleDateFormat() {  
        SimpleDateFormat formatter = new SimpleDateFormat();  
        String NDateTime = formatter.format(new Date());  
        return NDateTime;  
    }  
      
    /** 
     * 将指定字符串格式的日期与当前时间比较 
     * @author DYLAN 
     * @date Feb 17, 2012 
     * @param strDate 需要比较时间 
     * @return  
     *      <p> 
     *      int code 
     *      <ul> 
     *      <li>-1 当前时间 < 比较时间 </li> 
     *      <li> 0 当前时间 = 比较时间 </li> 
     *      <li>>=1当前时间 > 比较时间 </li> 
     *      </ul> 
     *      </p> 
     */  
    public static int compareToCurTime (String strDate) {  
       // if (StringUtils.isBlank(strDate)) {  
        if (null != strDate) {  
            return -1;  
        }  
        Date curTime = cale.getTime();  
        String strCurTime = null;  
        try {  
            strCurTime = sdf_datetime_format.format(curTime);  
        } catch (Exception e) {  
            if (logger.isDebugEnabled()) {  
                logger.debug("[Could not format '" + strDate + "' to a date, throwing exception:" + e.getLocalizedMessage() + "]");  
            }  
        }  
        //if (StringUtils.isNotBlank(strCurTime)) {  
        if (null != strCurTime) {  
            return strCurTime.compareTo(strDate);  
        }  
        return -1;  
    }  
      
    /** 
     * 为查询日期添加最小时间 
     *  
     * @param 目标类型Date 
     * @param 转换参数Date 
     * @return 
     */  
    @SuppressWarnings("deprecation")  
    public static Date addStartTime(Date param) {  
        Date date = new Date(param.toString());  
        try {  
            date.setHours(0);  
            date.setMinutes(0);  
            date.setSeconds(0);  
            return date;  
        } catch (Exception ex) {  
            return date;  
        }  
    }  
  
    /** 
     * 为查询日期添加最大时间 
     *  
     * @param 目标类型Date 
     * @param 转换参数Date 
     * @return 
     */  
    @SuppressWarnings("deprecation")  
    public static Date addEndTime(Date param) {  
        Date date = new Date(param.toString());  
        try {  
            date.setHours(23);  
            date.setMinutes(59);  
            date.setSeconds(0);  
            return date;  
        } catch (Exception ex) {  
            return date;  
        }  
    }  
  
    /** 
     * 返回系统现在年份中指定月份的天数 
     *  
     * @param 月份month 
     * @return 指定月的总天数 
     */  
    @SuppressWarnings("deprecation")  
    public static String getMonthLastDay(int month) {  
        Date date = new Date();  
        int[][] day = { { 0, 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },  
                { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };  
        int year = date.getYear() + 1900;  
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {  
            return day[1][month] + "";  
        } else {  
            return day[0][month] + "";  
        }  
    }  
  
    /** 
     * 返回指定年份中指定月份的天数 
     *  
     * @param 年份year 
     * @param 月份month 
     * @return 指定月的总天数 
     */  
    public static String getMonthLastDay(int year, int month) {  
        int[][] day = { { 0, 30, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },  
                { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };  
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {  
            return day[1][month] + "";  
        } else {  
            return day[0][month] + "";  
        }  
    }  
  
    /** 
     * 判断是平年还是闰年 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param year 
     * @return 
     */   
    public static boolean isLeapyear(int year) {  
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400) == 0) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
    /** 
     * 取得当前时间的日戳 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @return 
     */  
    @SuppressWarnings("deprecation")  
    public static String getTimestamp() {  
        Date date = cale.getTime();  
        String timestamp = "" + (date.getYear() + 1900) + date.getMonth()  
                + date.getDate() + date.getMinutes() + date.getSeconds()  
                + date.getTime();  
        return timestamp;  
    }  
  
    /** 
     * 取得指定时间的日戳 
     *  
     * @return 
     */  
    @SuppressWarnings("deprecation")  
    public static String getTimestamp(Date date) {  
        String timestamp = "" + (date.getYear() + 1900) + date.getMonth()  
                + date.getDate() + date.getMinutes() + date.getSeconds()  
                + date.getTime();  
        return timestamp;  
    }  
}
