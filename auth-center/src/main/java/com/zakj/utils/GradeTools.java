package com.zakj.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 类描述：根据入学年费算是几年级的工具类  
 * 创建人：ssxu  
 * 创建时间：2017-7-4 下午3:25:06   
 * @version  1.0
 *
 */
public class GradeTools {

	/**
	 * 获取年级
	 * @param xxName 学制
	 * @param ruxueDate 入学时间
	 * @param   xxName   学段
	 * @return
	 */
	public static String getGrade(int njshu,String ruxueDate,String xxName){
		boolean flag = compareDate(); // true 升级  false 不升级
		int ruxeuYear = Integer.parseInt(ruxueDate);  //入学的年费
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);  //当前年
		int xcYear = nowYear - ruxeuYear; //相差多少年
		if (flag) { // 升学
			xcYear ++;
			/**if (xcYear < njshu){
				xcYear ++;
			} *//**else {
				return "毕业了";
			}*/
		}/** else { //没有升级
			//xcYear --;
		}*/
		//xcYear = njshu !=3 ? xcYear : xcYear + 6;
		if (xxName.indexOf("初中") != -1){
			if (xcYear > 3){
				return "初中毕业";
			} else {
				xcYear = xcYear +6;
			}
		} else if (xxName.indexOf("小学") != -1){
			if (xcYear > 6){
				return "小学毕业";
			}
		} else if (xxName.indexOf("学前") != -1){  //幼儿园需要与第一个值比对
			if (xcYear > njshu){
				return "幼儿园毕业";
			} else {
				return garten(xcYear);
			}
			
		}else if (xxName.indexOf("九年一贯制") != -1){
			if (xcYear > 9){
				return "已毕业";
			}
		} 
		return NumberChangeToChinese.numberToChinese(xcYear)+"年级";
	}
	

	/**
	 * 当前时间与8月1日比较 大余8月1号返回true 否则返回false 第二个是表示升学的截止日期
	 * DATE 要比较的时间 也就是定义的升学的时间
	 * @return
	 */
	private static boolean compareDate() {
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);  //当前年
		String bjDate = nowYear+"-8-1";  //8月1日是升级的截止日期
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = new Date();
			Date dt2 = df.parse(bjDate);
			if (dt1.getTime() > dt2.getTime()) {
				return true;
			} else if (dt1.getTime() < dt2.getTime()) {
				return false;
			} else {
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 翻译幼儿园
	 * xcYear 需要翻译成什么字
	 * schoolNum 有多少个班
	 * @return
	 */
	private static String garten(int xcYear){
		String retu = "";
		switch (xcYear){
			case 0:
			retu = "小小班";
			break;
			case -1:
			retu = "小小班";
			break;
			case 1:
			retu = "小班";
			break;
			case 2:
			retu = "中班班";
			break;
			case 3:
			retu = "大班";
			break;
			default:
			retu = "幼儿园毕业了";
		}
		return retu;
	} 
}
