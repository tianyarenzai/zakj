package com.zakj.utils;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class StringUtil {
    public static boolean isNullOrEmpty(Object obj) {
	return obj == null || "".equals(obj.toString());
    }

    public static String toString(Object obj) {
	if (obj == null) {
	    return "null";
	}
	return obj.toString();
    }

    public static String join(Collection s, String delimiter) {
	StringBuffer buffer = new StringBuffer();
	Iterator iter = s.iterator();
	while (iter.hasNext()) {
	    buffer.append(iter.next());
	    if (iter.hasNext()) {
		buffer.append(delimiter);
	    }
	}
	return buffer.toString();
    }

    public static Date DateFormat(Date date) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(date);
	ParsePosition pos = new ParsePosition(0);
	Date currentTime_2 = formatter.parse(dateString, pos);
	return currentTime_2;
    }

    public static String DateFormatStr(Date date) {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateString = formatter.format(date);

	return dateString;
    }

    /**
     * 规范化小数的格式,将double类型转化为"0.00"的方式,保留小数点后两位
     */
    public static String numFormat(double db) {
	String str = numFormat(db, "0.00");
	// DecimalFormat df = new DecimalFormat("0.##");
	// return df.format(db);
	return str;
    }

    /**
     * 规范小数的格式，将double类型转化为制定的格式
     */
    public static String numFormat(double db, String pattern) {
	DecimalFormat df = new DecimalFormat(pattern);
	return df.format(db);
    }

    /**
     * 将字符串转换成double类型
     */
    public static Double stringToDouble(String str) {
	return Double.parseDouble(str);
    }

    /**
     * 判断传入的url有没有问号 有问号&拼接params 没有问号?号拼接params
     * 
     * @param url
     *            要判断的url
     * @param params
     *            要在url后面拼接的内容数组
     * @return
     * @throws Exception
     */
    public static String getUrlString(String url, String[] key, String[] val) throws Exception {
	if (!isNullOrEmpty(url)) { // url 不为空
	    String params = JSON.encryUrl(key, val);
	    return url + "?" + params;
	} else { // url 为空
	    return "";
	}
    }

    /**
     * 校验数组里面的内容是否全部为Null
     * 
     * @param str
     * @return flag true 全部都是null false有不是null的
     */
    public static boolean arrayIsNull(String[] str) {
	boolean flag = true; //
	for (String st : str) {
	    if (!"null".equals(st) && null != st) {
		flag = false;
		break;
	    }
	}
	return flag;
    }
}
