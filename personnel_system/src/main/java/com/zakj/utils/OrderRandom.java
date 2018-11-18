package com.zakj.utils;
import java.util.Random;

/**
 * 
 * 类描述：  订单随机生成类
 * 创建人：ssxu  
 * 创建时间：2017-11-13 下午4:06:42   
 * @version  1.0
 *
 */
public class OrderRandom {

	/**
	 * 当前时间的毫秒数字符串 32-17=15
	 * 
	 * @return
	 */
	public static String nowTime() {
	//	Date date = new Date();
	//	long ss=date.getTime();
	//	DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		try {
			
			
			//return	ss+"";
			return System.currentTimeMillis()+"";
			
			
			//return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取15位的随机数
	 * 
	 * @return
	 */
	public static String random() {
		StringBuilder ran = new StringBuilder();
		int values[] = new int[100];
		int temp1, temp2, temp3;
		Random r = new Random();
		for (int i = 0; i < values.length; i++) {
			values[i] = i + 1;
		}

		// 随机交换values.length次
		for (int i = 0; i < values.length; i++) {
			temp1 = Math.abs(r.nextInt()) % (values.length - 1); // 随机产生一个位置
			temp2 = Math.abs(r.nextInt()) % (values.length - 1); // 随机产生另一个位置

			if (temp1 != temp2) {
				temp3 = values[temp1];
				values[temp1] = values[temp2];
				values[temp2] = temp3;
			}
		}

		for (int i = 0; i < 20; i++) {
			ran.append(values[i]);
		}
		String ret = ran.toString();
		return ret.length() > 7 ? ret.substring(0,7) : ret;
	}

	
	
	public static String order() {
	    
	    return  nowTime()+random();
	}
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(OrderRandom.nowTime()+"-"+ OrderRandom.random());
		}
	}
}
