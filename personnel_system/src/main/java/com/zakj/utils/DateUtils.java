/**   
 * @Title: DateUtils.java    
 * @Package com.zayun.utils    
 * @Description: TODO(日期处理工具类)    
 * @author ryh  
 * @date 2016年10月14日 下午6:48:09    
 * @version V1.0   
 */
package com.zakj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @ClassName: DateUtils
 * @Description: TODO(日期处理工具类: 默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期)
 * @author: ryh
 * @date: 2016年10月14日 下午6:48:09
 * @ModifiedBy: 修改人
 * @Modified Date:修改日期
 */
public class DateUtils {

	public DateUtils() {
		// TODO 自动生成的构造函数存根
	}

	/**
	 * 英文简写（默认）如：2010-12-01
	 */
	public static String FORMAT_HH="HH:mm:ss";
	public static String FORMAT_M = "mm";
	public static String FORMAT_H= "HH";
	public static String FORMAT_SHORT = "yyyy-MM-dd";
	public static String FORMAT_T = "yyyy-MM";
	public static String FORMAT= "yyyy";
	/**
	 * 英文全称 如：2010-12-01 23:15:06
	 */
	public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
	 */
	public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";
	/**
	 * 中文简写 如：2010年12月01日
	 */
	public static String FORMAT_SHORT_CN = "yyyy年MM月dd";
	/**
	 * 中文全称 如：2010年12月01日 23时15分06秒
	 */
	public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";
	/**
	 * 精确到毫秒的完整中文时间
	 */
	public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

	/**
	 *@Description:  获得默认的 date pattern
	 */
	public static String getDatePattern() {
		return FORMAT_LONG;
	}

	/**
	 * @Description: 根据预设格式返回当前日期
	 * 
	 * @return
	 */
	public static String getNow() {
		return format(new Date());
	}

	/**
	 * @Description: 根据用户格式返回当前日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getNow(String format) {
		return format(new Date(), format);
	}

	/**
	 * @Description: 使用预设格式格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, getDatePattern());
	}
	
	public static String toDateTypeString( long time){
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_LONG);
		return df.format(time);
		
	}
	

	/**
	 * @Description: 使用用户格式格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}

	/**
	 * @Description: 使用预设格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @return
	 */
	public static Date parse(String strDate) {
		return parse(strDate, getDatePattern());
	}

	/**
	 * @Description: 使用用户格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static Date parse(String strDate, String pattern) {
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			 date = df.parse(strDate);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * @Description: 在日期上增加数个整月
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的月数
	 * @return
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * @Description: 在日期上增加天数
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的天数
	 * @return Date 日期
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * @Description: 获取时间戳
	 */
	public static String getTimeString() {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}

	/**
	 * @Description: 获取日期年份
	 * 
	 * @param date
	 *            日期
	 * @return 字符串
	 */
	public static String getYear(Date date) {
		return format(date).substring(0, 4);
	}
	 

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//long ff=1500468348000;
		 
	 
 
	}
	
	
	/**
	 * @Description: 按默认格式的字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 */
	public static int countDays(String date) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * @Description:  按用户格式字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static int countDays(String date, String format) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date, format));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}
	

	/**
	 * @Description: 日期转换成字符串
	 * @param date
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return 返回 字符串时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static String DateFormat(Date date,String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * @Description:  字符串转换成日期
	 * @param str：字符串
	 * @return date：日期
	 */
	public static Date StringToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static Date StringToMonth(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static Date StringToDate1(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
 
	/**
	 * @Description: 检查字符串是否是日期
	 * @param str：字符串
	 * @return boolean：true/flase
	 */
	public static boolean checkStrIsDate(String str) {
		boolean flag = false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			format.parse(str);
			flag = true;
		} catch (ParseException e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 
	* @Title: DateFormatStr    
	* @Description: TODO(日期转换成字符串)
	* @param date:日期
	* @return String: 日期字符串       
	 */
	public static String DateFormatStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String dateString = formatter.format(date);

		return dateString;
	}
	public static String DateFormatStrs(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

		String dateString = formatter.format(date);

		return dateString;
	}
	public static String DateFormatStrSss(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		String dateString = formatter.format(date);

		return dateString;
	}
	
	public static String getSerial(Date date, int index) {
		long msel = date.getTime();
		SimpleDateFormat fm = new SimpleDateFormat("MMddyyyyHHmmssSS");
		msel += index;
		date.setTime(msel);
		String serials = fm.format(date);

		return serials;
	}
	
	 /**
	  * 
	  * @Title:             sub
	  * @Description:     TODO 量时间相减
	  * @param:             @param d1
	  * @param:             @param d2
	  * @param:             @return   
	  * @return:         long   
	  * @throws
	  */
	public static long sub(Date d1, Date d2) {
		
		return d1.getTime()-d2.getTime(); 
	}

	/**
	* @Title: compareDate    
	* @Description: TODO(日期比较大小)
	* @param dt1:日期1
	* @param dt2：日期2
	* @return int:1【dt1大于dt2】; -1【dt1大于dt2】; 0【相等】；
	 */
	public int compareDate(Date dt1, Date dt2) {
		if (dt1.getTime() > dt2.getTime()) {
			// System.out.println("dt1 在dt2前");
			return 1;
		} else if (dt1.getTime() < dt2.getTime()) {
			// System.out.println("dt1在dt2后");
			return -1;
		} else {// 相等
			return 0;
		}
	}
	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            void: 参数说明
	 * @exception
	 */
	
	
	public static int daysOfTwo(Date fDate, Date oDate) {

	       Calendar aCalendar = Calendar.getInstance();

	       aCalendar.setTime(fDate);

	       int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

	       aCalendar.setTime(oDate);

	       int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

	       return day2 - day1;

	    }
	
	
	

}
