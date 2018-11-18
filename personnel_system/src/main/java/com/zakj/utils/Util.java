
package com.zakj.utils;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static String getDate(String str) {
	String str_return = "";
	if (str != null && str.length() == 8) {
	    String yy = str.substring(0, 4) + "年";
	    String mm = str.substring(4, 6) + "月";
	    String dd = str.substring(6) + "日";
	    str_return = yy + mm + dd;
	}
	return str_return;
    }

    public static String getDatebyYYMMDD(String str) {
	String str_return = "";
	if (str != null && str.length() >= 8) {
	    String yy = str.substring(0, 4) + "年";
	    String mm = str.substring(4, 6) + "月";
	    String dd = str.substring(6, 8) + "日";
	    str_return = yy + mm + dd;
	}
	return str_return;
    }

    public static String getDateyymm(String str) {
	String str_return = "";
	if (str != null && str.length() == 6) {
	    String yy = str.substring(0, 4) + "年";
	    String mm = str.substring(4, 6) + "月";
	    str_return = yy + mm;
	}
	return str_return;
    }

    public static String getDateyymm1(String str) {
	String str_return = "";
	if (str != null && str.length() >= 6) {
	    String yy = str.substring(0, 4) + "年";
	    String mm = str.substring(4, 6) + "月";
	    str_return = yy + mm;
	}
	return str_return;
    }

    public static String getDateyy(String str) {
	String str_return = "";
	if (str != null && str.length() == 4) {
	    String yy = str.substring(0, 4) + "年";
	    str_return = yy;
	}
	return str_return;
    }

    public static String getDate1(String str) {
	String str_return = "";
	if (str != null && str.length() == 8) {
	    String yy = str.substring(0, 4) + "-";
	    String mm = str.substring(4, 6) + "-";
	    String dd = str.substring(6);
	    str_return = yy + mm + dd;
	}
	return str_return;
    }

    public static String getTime2(String str) {
	String result = "";
	if (str != null && str.length() == 6) {
	    result = str.substring(0, 2) + ":";
	    result += str.substring(2, 4) + ":";
	    result += str.substring(4);
	}
	return result;
    }

    public static String getTime1(String str) {
	String str_return = "";
	if (str != null && str.length() == 4) {
	    String hh = str.substring(0, 2) + "-";
	    String mm = str.substring(2);
	    str_return = hh + mm;
	} else {
	    str_return = str;
	}
	return str_return;
    }

    public static String getTime4(String str) {
	String str_return = "";
	if (str != null && str.length() >= 4) {
	    String hh = str.substring(0, 2) + ":";
	    String mm = str.substring(2, 4);
	    str_return = hh + mm;
	} else {
	    str_return = str;
	}
	return str_return;
    }

    public static boolean isEmpty(final String str) {
	if (str == null) {
	    return true;
	}
	if (str.trim().length() == 0) {
	    return true;
	}
	return false;
    }

    public static String getToday() {
	Date today1 = new Date();
	DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	String mydate = fmt.format(today1);
	return mydate;
    }

    public static String getToday2() {
	Date today1 = new Date();
	DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	String mydate = fmt.format(today1);
	return mydate;
    }

    public static String getHourMinute() {
	Date today1 = new Date();
	DateFormat fmt = new SimpleDateFormat("HHmm");
	String mydate = fmt.format(today1);
	return mydate;
    }

    public static String getDateDB(String strdate) {
	DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd");
	String mydate = "";
	if (strdate != null && !strdate.equals("") && strdate.indexOf("-") >= 0) {
	    try {
		mydate = fmt.format(fmt2.parse((strdate)));
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	} else {
	    mydate = strdate;
	}
	return mydate;
    }

    public static String getTimeOfString(String time) {
	String mytime = "";
	if (time != null) {
	    mytime = time.replaceAll(":", "");
	    if (mytime.length() == 4) {
		mytime += "00";
	    }
	}
	return mytime;
    }

    public static Integer getAge(String birthday) throws ParseException {
	Integer age = 0;
	if (birthday != null && birthday.length() == 8) {
	    DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	    Date today = new Date();
	    Date birth = fmt.parse(birthday);
	    long day = (today.getTime() - birth.getTime()) / (24 * 60 * 60 * 1000) + 1;
	    age = (int) (day / 365f);
	}
	return age;
    }

    // ---------根据 HcPurchaseItem 状态 返回 字符串---------
    public static String getHcPurchaseItemState(Integer flag) {
	String strState = "";
	if (flag != null) {
	    if (flag == 0) {
		strState = "<font color='#FF0000'>未入库</font>";
	    } else if (flag == 1) {
		strState = "<font color='#00FF00'>已入库</font>";
	    }
	}

	return strState;
    }

    public static String getPercent(double data) {
	NumberFormat nf = NumberFormat.getPercentInstance();
	return nf.format(data);
    }

    public static Date getDateByMonths(int months, Date baseDate) {
	Calendar l_cal = Calendar.getInstance();
	l_cal.setTime(new Date());
	l_cal.add(Calendar.MONTH, months);
	Date l_date = l_cal.getTime();
	return l_date;
    }

    public static String toStrDateYYYYMMDD(final Date date) {
	SimpleDateFormat l_format = (SimpleDateFormat) DateFormat.getInstance();
	l_format.applyPattern("yyyyMMdd");
	return toStrDate(date, l_format);
    }

    public static String toStrDateYYYYMMDD2(final Date date) {
	SimpleDateFormat l_format = (SimpleDateFormat) DateFormat.getInstance();
	l_format.applyPattern("yyyy-MM-dd");
	return toStrDate(date, l_format);
    }

    public static String toStrDateYYYYMM(final Date date) {
	SimpleDateFormat l_format = (SimpleDateFormat) DateFormat.getInstance();
	l_format.applyPattern("yyyyMM");
	return toStrDate(date, l_format);
    }

    public static String toStrDate(final Date date, final SimpleDateFormat format) {
	if (date == null) {
	    return null;
	}
	return format.format(date);
    }

    public static Date getCurDate() {
	Date l_date = new Date();
	return l_date;
    }

    public static String toDateDb(final String dateInput, final String type) {
	String l_dateDb = "";
	if (!isEmpty(dateInput)) {
	    String[] l_date = dateInput.split(type);
	    l_dateDb = l_date[0];
	    if (!isEmpty(l_date[1]) && l_date[1].length() == 1) {
		l_dateDb += "0";
	    }
	    l_dateDb += l_date[1];
	    if (!isEmpty(l_date[2]) && l_date[2].length() == 1) {
		l_dateDb += "0";
	    }
	    l_dateDb += l_date[2];
	}
	return l_dateDb;
    }

    public static String toDateDb2(final String dateInput, final String type) {
	String l_dateDb = "";
	if (!isEmpty(dateInput)) {
	    String[] l_date = dateInput.split(type);
	    l_dateDb = l_date[2];
	    if (!isEmpty(l_date[1]) && l_date[1].length() == 1) {
		l_dateDb += "0";
	    }
	    l_dateDb += l_date[1];
	    if (!isEmpty(l_date[0]) && l_date[0].length() == 1) {
		l_dateDb += "0";
	    }
	    l_dateDb += l_date[2];
	}
	return l_dateDb;
    }

    public static String toStrDateYYYYMMDD3(final String dateInput, final String type) {
	String l_date = "";
	if (!isEmpty(dateInput) && dateInput.length() == 8) {
	    l_date = dateInput.substring(0, 4) + type + dateInput.substring(4, 6) + type + dateInput.substring(6);
	}
	return l_date;
    }

    public static String toStrDateYYYYMMDD4(final String dateInput, final String type) {
	String l_date = "";
	if (!isEmpty(dateInput) && dateInput.length() == 8) {
	    l_date = dateInput.substring(6) + type + dateInput.substring(4, 6) + type + dateInput.substring(0, 4);
	}
	return l_date;
    }

    public static String toStrDateHHMMSS(final String dateInput, final String type) {
	String l_date = "";
	if (!isEmpty(dateInput) && dateInput.length() == 6) {
	    l_date = dateInput.substring(0, 2) + type + dateInput.substring(2, 4) + type + dateInput.substring(4);
	}
	return l_date;
    }

    public static String toStrDateHHMM(final String dateInput, final String type) {
	String l_date = "";
	if (!isEmpty(dateInput) && dateInput.length() == 4) {
	    l_date = dateInput.substring(0, 2) + type + dateInput.substring(2, 4);
	}
	return l_date;
    }

    public static String toStrDateHHMMNew(final String dateInput, final String type) {
	String l_date = "";
	if (!isEmpty(dateInput) && dateInput.length() == 6) {
	    l_date = dateInput.substring(0, 2) + type + dateInput.substring(2, 4);
	}
	return l_date;
    }

    public static long getDays(final String dateFrom, final String dateTo) {
	DateFormat format = new SimpleDateFormat("yyyyMMdd");
	try {
	    return new Long(
		    (format.parse(dateFrom).getTime() - format.parse(dateTo).getTime()) / (1000 * 60 * 60 * 24) + 1)
			    .intValue();
	} catch (ParseException e) {
	    return 0;
	}
    }

    public static String toStrDateHHMMSS(final Date date) {
	SimpleDateFormat l_format = (SimpleDateFormat) DateFormat.getInstance();
	l_format.applyPattern("HHmmss");
	return toStrDate(date, l_format);
    }

    public static String toStrDateHHMMSS2(final Date date) {
	SimpleDateFormat l_format = (SimpleDateFormat) DateFormat.getInstance();
	l_format.applyPattern("HH:mm:ss");
	return toStrDate(date, l_format);
    }

    public static Date toDateFromYYYYMMDD(String strDate) {
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	try {
	    date = format.parse(strDate); // Thu Jan 18 00:00:00 CST 2007
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	return date;
    }

    public static Date toDateFromYYYYMMDD2(String strDate) {
	DateFormat format = new SimpleDateFormat("yyyyMMdd");
	Date date = new Date();
	try {
	    date = format.parse(strDate); // Thu Jan 18 00:00:00 CST 2007
	} catch (ParseException e) {

	    e.printStackTrace();
	    return null;
	}
	return date;
    }

    public static String getNowYYYYMMDDHHMMSS() {
	String result = "";
	SimpleDateFormat l_sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	result = l_sdf.format(new Date());
	return result;
    }

    public static String getNowTm() {
	SimpleDateFormat l_sdf = new SimpleDateFormat("HHmmss");
	return l_sdf.format(new Date());
    }

    public static String getStrDateForYYYYMMDDHHMMSS(Date date) {
	String result = "";
	if (date == null) {
	    return result;
	}
	SimpleDateFormat l_sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	result = l_sdf.format(date);
	return result;
    }

    public static String getStartTimeByMonth(Date date) {
	Calendar calender = Calendar.getInstance();
	calender.setTime(date);
	calender.set(Calendar.DAY_OF_MONTH, 1);
	calender.set(Calendar.HOUR_OF_DAY, 0);
	calender.set(Calendar.MINUTE, 0);
	calender.set(Calendar.SECOND, 0);
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	return format.format(calender.getTime());
    }

    public static String getEndTimeByMonth(Date date) {
	Calendar calender = Calendar.getInstance();
	calender.setTime(date);
	calender.add(Calendar.MONTH, 1);
	calender.set(Calendar.DAY_OF_MONTH, 1);
	calender.add(Calendar.DAY_OF_MONTH, -1);
	calender.set(Calendar.HOUR_OF_DAY, 23);
	calender.set(Calendar.MINUTE, 59);
	calender.set(Calendar.SECOND, 59);
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	return format.format(calender.getTime());
    }

    public static String getStartDateByMonth(Date date) {
	Calendar calender = Calendar.getInstance();
	calender.setTime(date);
	calender.set(Calendar.DAY_OF_MONTH, 1);
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	return format.format(calender.getTime());
    }

    public static String getEndDateByMonth(Date date) {
	Calendar calender = Calendar.getInstance();
	calender.setTime(date);
	calender.add(Calendar.MONTH, 1);
	calender.set(Calendar.DAY_OF_MONTH, 1);
	calender.add(Calendar.DAY_OF_MONTH, -1);
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	return format.format(calender.getTime());
    }

    public static String getStartDateByMonth1(Date date) {
	Calendar calender = Calendar.getInstance();
	calender.setTime(date);
	calender.set(Calendar.DAY_OF_MONTH, 1);
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	return format.format(calender.getTime());
    }

    public static String getEndDateByMonth1(Date date) {
	Calendar calender = Calendar.getInstance();
	calender.setTime(date);
	calender.add(Calendar.MONTH, 1);
	calender.set(Calendar.DAY_OF_MONTH, 1);
	calender.add(Calendar.DAY_OF_MONTH, -1);
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	return format.format(calender.getTime());
    }

    public static String getEndDateByYear(Date date) {
	Calendar calender = Calendar.getInstance();
	calender.setTime(date);
	calender.set(Calendar.MONTH, 11);
	calender.set(Calendar.DAY_OF_MONTH, 31);
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	return format.format(calender.getTime());
    }

    public static String appendZeroLeft(String strObj, int len) {
	if (strObj == null) {
	    return "";
	}
	if (strObj.length() >= len) {
	    return strObj;
	}
	return (StringUtils.repeat("0", len - strObj.length()) + strObj);
    }

    public static Integer convertToInt(String str) {
	try {
	    return Integer.parseInt(str);
	} catch (Exception e) {
	    return 0;
	}
    }

    public static Float convertToFloat(String str) {
	try {
	    return Float.parseFloat(str);
	} catch (Exception e) {
	    return 0f;
	}
    }

    public static Long getOffsetDay(String startDate, String endDate) {
	Date start = toDateFromYYYYMMDD(startDate);
	Date end = toDateFromYYYYMMDD(endDate);
	long offset = end.getTime() - start.getTime();
	return (offset / (24 * 60 * 60 * 1000));
    }

    // 以秒返回
    public static Long getOffsetSeconds(String startDate, String endDate) {
	Date start = toDateFromYYYYMMDDHHMMSS(startDate);
	Date end = toDateFromYYYYMMDDHHMMSS(endDate);
	long offset = end.getTime() - start.getTime();
	return offset / 1000;
    }

    public static String toStrDateYYYYMMDD5(final String date, String format) {
	if (Util.isEmpty(date)) {
	    return "";
	}
	SimpleDateFormat l_format = new SimpleDateFormat(format);
	DateFormat l_dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	try {
	    return l_dateFormat.format(l_format.parse(date));
	} catch (ParseException e) {
	    return "";
	}
    }

    public static Date toDateFromYYYYMMDDHHMMSS(String strDate) {
	DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
	try {
	    date = format.parse(strDate); // Thu Jan 18 00:00:00 CST 2007
	} catch (ParseException e) {
	    date = null;
	}
	return date;
    }

    public static Date toDateFromYYYYMMDD1(String strDate) {
	DateFormat format = new SimpleDateFormat("yyyyMMdd");
	Date date = new Date();
	try {
	    date = format.parse(strDate); // Thu Jan 18 00:00:00 CST 2007
	} catch (ParseException e) {
	    date = null;
	}
	return date;
    }

    public static Long offsetMinite(String strDate) {
	Date objDate = toDateFromYYYYMMDDHHMMSS(strDate);
	if (objDate == null) {
	    return 0L;
	} else {
	    Date cruDate = new Date();
	    Long offset = (cruDate.getTime() - objDate.getTime()) / (60 * 1000);
	    return offset;
	}
    }

    public static String getDateDisp(String strdate) {
	DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd");
	String mydate = "";
	if (strdate != null && !strdate.equals("")) {
	    try {
		mydate = fmt2.format(fmt.parse((strdate)));
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	}
	return mydate;
    }

    public static String getYMDisp(String strdate) {
	DateFormat fmt = new SimpleDateFormat("yyyyMM");
	DateFormat fmt2 = new SimpleDateFormat("yyyy-MM");
	String mydate = "";
	if (strdate != null && !strdate.equals("")) {
	    try {
		if (strdate.length() > 4) {
		    mydate = fmt2.format(fmt.parse((strdate)));
		} else {
		    mydate = strdate;
		}
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	}
	return mydate;
    }

    public static String getDateDispYYYYMM(String strdate) {
	DateFormat fmt = new SimpleDateFormat("yyyyMM");
	DateFormat fmt2 = new SimpleDateFormat("yyyy-MM");
	String mydate = "";
	if (strdate != null && !strdate.equals("")) {
	    try {
		mydate = fmt2.format(fmt.parse((strdate)));
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	}
	return mydate;
    }

    public static String getDateYYYYMMDDHHMMSS(String strdate) {
	DateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String mydate = "";
	if (strdate != null && !strdate.equals("")) {
	    try {
		mydate = fmt2.format(fmt.parse((strdate)));
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	}
	return mydate;
    }

    // 到期日期
    public static String getPaymentDate(Integer paymentDays) {
	if (paymentDays == null) {
	    return "";
	}
	Calendar calendar = Calendar.getInstance();
	calendar.set(Calendar.DAY_OF_MONTH, paymentDays);
	return toStrDateYYYYMMDD2(calendar.getTime());
    }

    // ---------返回当月首日-----------
    public static String getFirstDayOfMonth() {
	Calendar calendar = new GregorianCalendar();
	calendar.set(Calendar.DATE, 1);
	DateFormat simpleFormate = new SimpleDateFormat("yyyyMMdd");
	String sd = simpleFormate.format(calendar.getTime());
	return sd;
    }

    // ---------返回当月尾日-----------
    public static String getLastDayOfMonth() {
	Calendar calendar = new GregorianCalendar();
	DateFormat simpleFormate = new SimpleDateFormat("yyyyMMdd");
	calendar.set(Calendar.DATE, 1);
	calendar.roll(Calendar.DATE, -1);
	String ed = simpleFormate.format(calendar.getTime());
	return ed;
    }

    // ---------返回当月首日-----------
    public static String getFirstDayOfMonth(int year, int month) {
	Calendar calendar = new GregorianCalendar();
	calendar.set(Calendar.YEAR, year);
	calendar.set(Calendar.MONTH, month - 1);
	calendar.set(Calendar.DATE, 1);
	DateFormat simpleFormate = new SimpleDateFormat("yyyyMMdd");
	String sd = simpleFormate.format(calendar.getTime());
	return sd;
    }

    // ---------返回当月尾日-----------
    public static String getLastDayOfMonth(int year, int month) {
	Calendar calendar = new GregorianCalendar();
	calendar.set(Calendar.YEAR, year);
	calendar.set(Calendar.MONTH, month - 1);
	calendar.set(Calendar.DATE, 1);
	calendar.roll(Calendar.DATE, -1);
	DateFormat simpleFormate = new SimpleDateFormat("yyyyMMdd");
	String ed = simpleFormate.format(calendar.getTime());
	return ed;
    }

    /**
     * ----获取当前 年月日等
     * 
     * @return
     */
    public static int getNowYear() {
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date());
	int year = cal.get(Calendar.YEAR);
	return year;
    }

    public static String getNowMonth() {
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date());
	int month = cal.get(Calendar.MONTH) + 1;

	if (month < 10) {
	    return "0" + month;
	} else {
	    return String.valueOf(month);
	}
    }

    public static String getStandardFloat(Float f) {
	if (f == null) {
	    return "0.00";
	}
	DecimalFormat df = new DecimalFormat("0.00");
	return df.format(f);
    }

    public static int maxMonthDays() {
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MONTH, 1);
	cal.set(Calendar.DAY_OF_MONTH, 1);
	cal.add(Calendar.DAY_OF_MONTH, -1);
	return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int maxMonthDays(Date date) {
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	cal.add(Calendar.MONTH, 1);
	cal.set(Calendar.DAY_OF_MONTH, 1);
	cal.add(Calendar.DAY_OF_MONTH, -1);
	return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static String getnextPaymentdate(Date prePaymentdate) {

	Calendar cal = Calendar.getInstance();
	cal.setTime(prePaymentdate);

	if (cal.get(Calendar.DAY_OF_MONTH) > maxMonthDays()) {
	    return getLastDayOfMonth();
	} else {
	    cal.add(Calendar.MONTH, 1);
	    return toStrDateYYYYMMDD(cal.getTime());
	}
    }

    public static Integer validateInt(String str) {
	try {
	    return Integer.parseInt(str);
	} catch (Exception e) {
	    return null;
	}
    }

    public static String numFormart(Integer num) {
	if (num == null) {
	    return "0";
	}
	DecimalFormat df1 = new DecimalFormat("##,##0");
	return (df1.format(num));
    }

    public static String priceFormart(Float price) {
	if (price == null) {
	    return "0.00";
	}
	String priceStr = price.toString();
	BigDecimal decimalPrice = new BigDecimal(priceStr);
	DecimalFormat df1 = new DecimalFormat("##,##0.00");
	return (df1.format(decimalPrice));
    }

    public static String priceFormart(BigDecimal price) {
	if (price == null) {
	    return "0.00";
	}
	DecimalFormat df1 = new DecimalFormat("##,##0.00");
	return (df1.format(price));
    }

    public static String priceFormart1(Float price) {
	if (price == null) {
	    return "0.00";
	}
	String priceStr = price.toString();
	BigDecimal decimalPrice = new BigDecimal(priceStr);
	DecimalFormat df1 = new DecimalFormat("##0.00");
	return (df1.format(decimalPrice));
    }

    public static BigDecimal convertdecimal(String price) {
	if (Util.isEmpty(price)) {
	    return BigDecimal.ZERO;
	}
	BigDecimal decimalPrice = new BigDecimal(price);
	decimalPrice = decimalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	return decimalPrice;
    }

    public static BigDecimal convertdecimal1(String price) {
	if (Util.isEmpty(price)) {
	    return BigDecimal.ZERO;
	}
	BigDecimal decimalPrice = new BigDecimal(price);
	return decimalPrice;
    }

    public static String getDateDisp1(String strdate) {
	DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	DateFormat fmt2 = new SimpleDateFormat("MM-dd");
	String mydate = "";
	if (strdate != null && !strdate.equals("")) {
	    try {
		mydate = fmt2.format(fmt.parse((strdate)));
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	}
	return mydate;
    }

    public static String getWeekDisp(Calendar cal) {
	int week = cal.get(Calendar.DAY_OF_WEEK);
	String weekDisp = "";
	switch (week) {
	case 1:
	    weekDisp = "(周日)";
	    break;
	case 2:
	    weekDisp = "(周一)";
	    break;
	case 3:
	    weekDisp = "(周二)";
	    break;
	case 4:
	    weekDisp = "(周三)";
	    break;
	case 5:
	    weekDisp = "(周四)";
	    break;
	case 6:
	    weekDisp = "(周五)";
	    break;
	case 7:
	    weekDisp = "(周六)";
	    break;
	default:
	    break;
	}
	return weekDisp;
    }

    public static BigDecimal getRate(double d1, double d2) {
	if (d1 == 0 || d2 == 0) {
	    return BigDecimal.ZERO;
	}
	BigDecimal decimal1 = new BigDecimal(d1);
	BigDecimal decimal2 = new BigDecimal(d2);
	BigDecimal rate = decimal1.divide(decimal2, 2, BigDecimal.ROUND_HALF_UP);
	return rate;
    }

    public static String toPercentage(BigDecimal rate) {
	if (rate == null) {
	    return "0%";
	}
	BigDecimal percentage = rate.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN);
	percentage = percentage.setScale(0);
	return (percentage.toPlainString()) + "%";
    }

    public static Float getPriceforrate(Float price, Float rate) {
	if (rate == null) {
	    return price;
	}
	if (price == null) {
	    return 0f;
	}
	BigDecimal bigdecimalprice = new BigDecimal(price);
	BigDecimal bigdecimalrate = new BigDecimal(rate);
	bigdecimalprice = bigdecimalprice.multiply(bigdecimalrate);
	bigdecimalprice = bigdecimalprice.setScale(2, BigDecimal.ROUND_HALF_UP);
	return bigdecimalprice.floatValue();
    }

    public static String getDateYYYYMMDDHHMMSS1(String strdate) {
	DateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String mydate = "";
	if (strdate != null && !strdate.equals("")) {
	    try {
		mydate = fmt2.format(fmt.parse((strdate)));
	    } catch (ParseException e) {
		e.printStackTrace();
	    }
	}
	return mydate;
    }

    public static String delNull(String str) {
	if (str == null || str.equals("null")) {
	    str = "";
	}
	return str;
    }

    public static String getQuarterStart() {
	Calendar cal = Calendar.getInstance();
	int month = cal.get(Calendar.MONTH) + 1;
	int year = cal.get(Calendar.YEAR);
	String startdate = "";
	if (1 <= month && month <= 3) {
	    startdate = String.valueOf(year) + "0101";
	}
	if (4 <= month && month <= 6) {
	    startdate = String.valueOf(year) + "0401";
	}
	if (7 <= month && month <= 9) {
	    startdate = String.valueOf(year) + "0701";
	}
	if (10 <= month && month <= 12) {
	    startdate = String.valueOf(year) + "1001";
	}
	return startdate;
    }

    public static String getQuarterEnd() {
	Calendar cal = Calendar.getInstance();
	int month = cal.get(Calendar.MONTH) + 1;
	int year = cal.get(Calendar.YEAR);
	String startdate = "";
	if (1 <= month && month <= 3) {
	    startdate = String.valueOf(year) + "0331";
	}
	if (4 <= month && month <= 6) {
	    startdate = String.valueOf(year) + "0630";
	}
	if (7 <= month && month <= 9) {
	    startdate = String.valueOf(year) + "0930";
	}
	if (10 <= month && month <= 12) {
	    startdate = String.valueOf(year) + "1231";
	}
	return startdate;
    }

    public static String getYearStart() {
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	return (String.valueOf(year) + "0101");
    }

    public static String getYearEnd() {
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	return (String.valueOf(year) + "1231");
    }

    public static String getSmname(Integer smid) {
	if (smid == null) {
	    return "";
	}
	if (smid.equals(0)) {
	    return "会员卡";
	}
	if (smid.equals(1)) {
	    return "现付";
	}
	if (smid.equals(2)) {
	    return "月结";
	}
	return "";
    }

    public static String toStrDateYYYYMMDD6(final String date, final String time) {
	if (Util.isEmpty(date)) {
	    return "";
	}
	if (Util.isEmpty(time)) {
	    SimpleDateFormat l_format = new SimpleDateFormat("yyyyMMdd");
	    DateFormat l_dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    try {
		return l_dateFormat.format(l_format.parse(date));
	    } catch (ParseException e) {
		return "";
	    }

	} else {
	    SimpleDateFormat l_format = new SimpleDateFormat("yyyyMMddHHmmss");
	    DateFormat l_dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	    try {
		return l_dateFormat.format(l_format.parse(date + time));
	    } catch (ParseException e) {
		return "";
	    }
	}

    }

    public static String getStrItemStatus(int itemstatus) {
	String str = "";
	switch (itemstatus) {
	case 1:
	    str = "待核价";
	    break;
	case 2:
	    str = "已核价";
	    break;
	case 3:
	    str = "已发布、未派工";
	    break;
	case 4:
	    str = "待施工";
	    break;
	case 5:
	    str = "施工中";
	    break;
	case 6:
	    str = "待复核";
	    break;
	case 7:
	    str = "复核中";
	    break;
	case 8:
	    str = "不合格";
	    break;

	case 9:
	    str = "完工";
	    break;
	}

	return str;
    }

    public static String getDateforCn(String str) {
	String str_return = "";
	if (str != null && str.length() == 14) {
	    String yy = str.substring(0, 4) + "年";
	    String mm = str.substring(4, 6) + "月";
	    String dd = str.substring(6, 8) + "日";
	    String hh = str.substring(8, 10) + "时";
	    String mi = str.substring(10, 12) + "分";
	    str_return = yy + mm + dd + hh + mi;
	}
	return str_return;
    }

    public static String getDateForOffset(String date, int fieldtype, int offset) {
	Date objdate = toDateFromYYYYMMDD1(date);
	Calendar cal = Calendar.getInstance();
	cal.setTime(objdate);
	cal.add(fieldtype, offset);
	String formarteddate = toStrDateYYYYMMDD(cal.getTime());
	return formarteddate;
    }

    public static String getDateForOffset(Date date, int fieldtype, int offset) {
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	cal.add(fieldtype, offset);
	String formarteddate = toStrDateYYYYMMDD(cal.getTime());
	return formarteddate;
    }

    public static boolean isEndmonthdate(String date) {
	Date objdate = toDateFromYYYYMMDD1(date);
	Calendar cal = Calendar.getInstance();
	cal.setTime(objdate);
	int orgmonth = cal.get(Calendar.MONTH);
	int orgyear = cal.get(Calendar.YEAR);
	cal.add(Calendar.DAY_OF_MONTH, 1);
	int month = cal.get(Calendar.MONTH);
	int year = cal.get(Calendar.YEAR);
	if (orgmonth == month && orgyear == year) {
	    return false;
	} else {
	    return true;
	}
    }

    public static Long getOffsetDay2(String startDate, String endDate) {
	Date start = toDateFromYYYYMMDD2(startDate);
	Date end = toDateFromYYYYMMDD2(endDate);
	long offset = end.getTime() - start.getTime();
	return (offset / (24 * 60 * 60 * 1000));
    }

    public static boolean isStartmonthdate(String date) {
	Date objdate = toDateFromYYYYMMDD1(date);
	Calendar cal = Calendar.getInstance();
	cal.setTime(objdate);
	int orgday = cal.get(Calendar.DAY_OF_MONTH);
	if (orgday == 1) {
	    return true;
	} else {
	    return false;
	}
    }

    public static String formartdispdate(String date) {
	if (Util.isEmpty(date)) {
	    return "";
	} else {
	    if (date.length() == 14) {
		return Util.getDateYYYYMMDDHHMMSS(date);
	    } else if (date.length() == 12) {
		return Util.getDateYYYYMMDDHHMMSS(date + "00");
	    } else if (date.length() == 8) {
		return Util.getDateDisp(date);
	    } else {
		return "";
	    }

	}
    }

    public static String getAlertDate(String targetDate, int beforehandDays) {
	Date objdate = toDateFromYYYYMMDD1(targetDate);
	Calendar cal = Calendar.getInstance();
	cal.setTime(objdate);
	cal.add(Calendar.DAY_OF_MONTH, beforehandDays);
	Date alertDate = cal.getTime();
	Date now = new Date();
	if (now.compareTo(alertDate) >= 0) {
	    return toStrDateYYYYMMDD(now);
	} else {
	    return toStrDateYYYYMMDD(alertDate);
	}
    }

    public static String getDateAfterDays(String date, int days) {
	System.out.println(date + "," + days);
	Date d = toDateFromYYYYMMDDHHMMSS(date + "120000");
	Calendar cal = Calendar.getInstance();
	cal.setTime(d);
	cal.add(Calendar.DAY_OF_MONTH, days);
	d = cal.getTime();

	return toStrDateYYYYMMDD(d);
    }

    public static boolean isNumeric(String str) {
	for (int i = str.length(); --i >= 0;) {
	    int chr = str.charAt(i);
	    if ((chr >= 48 && chr <= 57) || chr == 47) {
		return true;
	    }
	}
	return false;
    }

    public static String getTodayYYYYMMDD(Calendar curdate) {
	Date today = curdate.getTime();
	DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
	String mydate = fmt.format(today);
	return mydate;
    }

    public static String getTodayHHmmss(Calendar curdate) {
	Date today = curdate.getTime();
	DateFormat fmt = new SimpleDateFormat("HHmmss");
	String mytime = fmt.format(today);
	return mytime;
    }

    public static String getcode(int code, int cnt) {
	String code1 = String.valueOf(code);

	int offset = cnt - code1.length();

	if (offset < 0) {
	    return code1;
	}

	String pix = StringUtils.repeat("0", offset);

	return pix + code1;
    }

    public static String numFormart(Number num) {
	if (num == null) {
	    return "0";
	}
	DecimalFormat df1 = new DecimalFormat("####0.##");
	return (df1.format(num));
    }

    public static String formatchar(String input, String formatString) {
	// String input = "dsaf";
	// String formatString = "%";
	if (Util.isEmpty(input) || Util.isEmpty(formatString)) {
	    return "";
	}
	StringBuffer newstr = new StringBuffer();
	for (int i = 0; i < input.length(); i++) {
	    String substr = input.substring(i, i + 1);
	    newstr.append(formatString);
	    newstr.append(substr);
	}
	return newstr.substring(1).toString();
    }

    public static String getRandomCharAndNumr(Integer length) {
	String str = "";
	Random random = new Random();
	for (int i = 0; i < length; i++) {
	    boolean b = random.nextBoolean();
	    if (b) { // 字符串
		// int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
		str += (char) (65 + random.nextInt(26));// 取得大写字母
	    } else { // 数字
		str += String.valueOf(random.nextInt(10));
	    }
	}
	return str;
    }

    public static BigDecimal formatbigdecimal(BigDecimal obj) {
	DecimalFormat myformat = new DecimalFormat("0.00");
	String str = myformat.format(obj);
	BigDecimal rtn = new BigDecimal(str);
	return rtn;
    }

    /**
     * 
     * @param sidx
     * @param sord
     * @param start
     * @param rows
     * @param flg
     *            0:排序加分页，1:只排序，2:只分页，3+无
     * @return
     */
    public static String getOrderLimit(String sidx, String sord, Integer start, Integer rows, int flg, String prefix) {
	String ordrelimit = "";
	if (flg == 0 || flg == 1) {
	    if (Util.isEmpty(sidx)) {
		return "";
	    }
	}
	if (Util.isEmpty(sord)) {
	    sord = "desc";
	}
	if (start == null) {
	    start = 0;
	}
	if (rows == null) {
	    rows = 0;
	}
	if (flg == 0) {
	    ordrelimit = " order by " + prefix + sidx + " " + sord + " limit " + start + "," + rows + " ";
	} else if (flg == 1) {
	    ordrelimit = " order by " + prefix + sidx + " " + sord + " ";
	} else if (flg == 2) {
	    ordrelimit = " limit " + start + "," + rows + " ";
	} else {

	}
	return ordrelimit;
    }

    public static String getHalfYearStart() {
	Calendar cal = Calendar.getInstance();
	int month = cal.get(Calendar.MONTH) + 1;
	int year = cal.get(Calendar.YEAR);
	String startdate = "";
	if (1 <= month && month <= 6) {
	    startdate = String.valueOf(year) + "0101";
	} else {
	    startdate = String.valueOf(year) + "0701";
	}
	return startdate;
    }

    public static String getHalfYearEnd() {
	Calendar cal = Calendar.getInstance();
	int month = cal.get(Calendar.MONTH) + 1;
	int year = cal.get(Calendar.YEAR);
	String startdate = "";
	if (1 <= month && month <= 6) {
	    startdate = String.valueOf(year) + "0630";
	}
	if (7 <= month && month <= 12) {
	    startdate = String.valueOf(year) + "1231";
	}
	return startdate;
    }

    // 排量
    public static String getpl(String plstr) {
	if (Util.isEmpty(plstr)) {
	    return "0";
	}
	String pl = "";
	int index = 0;
	for (char cha : plstr.toCharArray()) {
	    int chrint = cha;
	    if (chrint >= 48 && chrint <= 57) {
		pl += cha;
	    } else if ('.' == cha && index == 0) {
		pl += cha;
		index++;
	    } else {
		break;
	    }
	}
	if (Util.isEmpty(pl)) {
	    pl = "0";
	} else {
	    if (pl.endsWith(".")) {
		pl = pl.substring(0, pl.length() - 1);
	    }
	    if (pl.startsWith(".")) {
		pl = pl.substring(1);
	    }
	}

	return pl;
    }

    public static void main(String[] args) {
	// Map<String,Object> para = new HashMap<>();
	// para.put("col1", 10);
	// para.put("col2", 11);
	// para.put("col3", 100);
	//
	// System.out.println("result:" + judge(para,1));

	try {
	    String selldate = Util.getDateForOffset("20160102", Calendar.DAY_OF_MONTH, 30);
	    System.out.println(selldate);
	    int day = Util.getmonthofday(selldate);
	    selldate = Util.getDateyymm1(selldate);
	    if (!Util.isEmpty(selldate)) {
		if (day <= 10) {
		    selldate += "上旬";
		} else if (day <= 20) {

		    selldate += "中旬";
		} else {

		    selldate += "下旬";
		}
		System.out.println(selldate);
	    } else {

		System.out.println("2");
	    }
	} catch (Exception e) {
	    System.out.println("3");
	}

	String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
		+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
		+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
		+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
	Pattern pattern = Pattern.compile(ip);
	Matcher matcher = pattern.matcher("192.186.1.2");
	System.out.println("dddddd：" + matcher.matches());

	BigDecimal wfmiles = (new BigDecimal(52000)).divide(new BigDecimal(10000), 1, BigDecimal.ROUND_HALF_UP);
	float fmiles = wfmiles.floatValue();
	System.out.println(fmiles);
	//
	// Properties props=System.getProperties(); //系统属性
	// System.out.println("操作系统的名称："+props.getProperty("os.name"));
	System.out.println(Integer.parseInt("1.222"));
    }

    public static int getmonthofday(String date) {
	Calendar cal = Calendar.getInstance();
	cal.setTime(Util.toDateFromYYYYMMDD2(date));
	int day = cal.get(Calendar.DAY_OF_MONTH);
	return day;
    }

    public static String priceFormart7(BigDecimal price) {
	if (price == null) {
	    return "0.00";
	}
	DecimalFormat df1 = new DecimalFormat("##,##0.#");
	return (df1.format(price));
    }

    public static int getdaysnow(String dstr) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	// String dstr="20160112";
	Date date = null;
	try {
	    date = sdf.parse(dstr);
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    return 0;
	}
	long s1 = date.getTime();// 将时间转为毫秒
	long s2 = System.currentTimeMillis();// 得到当前的毫秒
	int day = (int) ((s1 - s2) / 1000 / 60 / 60 / 24);
	return day;
    }

    public static String getDateforCn1(String str) {
	String str_return = "";
	if (str != null && str.length() == 14) {
	    String yy = str.substring(0, 4) + "年";
	    String mm = str.substring(4, 6) + "月";
	    String dd = str.substring(6, 8) + "日";
	    String hh = str.substring(8, 10) + "时";
	    str_return = yy + mm + dd + hh;
	}
	return str_return;
    }

    public static String getDateforCn3(String str) {
	String str_return = "";
	if (str != null && str.length() == 14) {
	    int mm = Util.convertToInt(str.substring(4, 6));
	    int dd = Util.convertToInt(str.substring(6, 8));
	    int hh = Util.convertToInt(str.substring(8, 10));
	    int mi = Util.convertToInt(str.substring(10, 12));
	    str_return = mm + "/" + dd + " " + hh + ":" + mi;
	}
	return str_return;
    }

    public static String getDateforCn2(String str) {
	String str_return = "";
	if (str != null && str.length() == 14) {
	    String yy = str.substring(0, 4) + "年";
	    String mm = str.substring(4, 6) + "月";
	    String dd = str.substring(6, 8) + "日 ";
	    String hh = str.substring(8, 10);
	    String mi = ":" + str.substring(10, 12);
	    String ss = ":" + str.substring(12, 14);
	    str_return = yy + mm + dd + hh + mi + ss;
	}
	return str_return;
    }

    public static String formatdecimal0(Object obj) {
	String result = "err";
	NumberFormat nf = NumberFormat.getInstance();
	try {
	    result = nf.format(obj);
	} catch (Exception e) {
	    System.out.println("格式转化错误");
	    e.printStackTrace();
	}
	return result;
    }

    public static String format(String birth) {

	String studentBirth = null;
	switch (birth.length()) { // 10-7-13
	case 6:
	    studentBirth = "20" + birth.replace("-", "-0");
	    break;
	case 7:
	    int bb = birth.lastIndexOf("-"); // 16-12-1
	    StringBuffer buffer = new StringBuffer(birth);

	    if (bb == 4) {
		buffer.replace(2, 3, "-0");
		studentBirth = "20" + buffer.toString();
	    } else {
		buffer.replace(5, 6, "-0");
		studentBirth = "20" + buffer.toString();
	    }
	    break;
	case 8:
	    studentBirth = "20" + birth;
	    break;

	default:
	    studentBirth = birth;
	    break;
	}
	return studentBirth;

    }

}