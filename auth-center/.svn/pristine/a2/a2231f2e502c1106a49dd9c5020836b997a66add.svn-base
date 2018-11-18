/**   
* @Title: MD5.java    
* @Package com.mmteaching.uitl    
* @Description: TODO(MD5加密文件)    
* @author ryh  
* @date 2015年12月28日 上午8:50:40    
* @version V1.0   
*/
package com.zakj.utils;

import java.security.MessageDigest;

/**
 * @ClassName: MD5 
 * @Description: TODO(MD5加密类) 
 * @author: ryh
 * @date  2015年12月28日 上午8:50:40
 * @ModifiedBy 修改人
 */
public class MD5 {
private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	
	private static String byteArrayToHexString(byte[] b) { 
		StringBuffer resultSb = new StringBuffer(); 
		for (int i = 0; i < b.length; i++) { 
			resultSb.append(byteToHexString(b[i])); 
		} 
		return resultSb.toString(); 
	} 

	private static String byteToHexString(byte b) { 
		int n = b; 
		if (n < 0) n = 256 + n; 
		int d1 = n / 16; 
		int d2 = n % 16; 
		return hexDigits[d1] + hexDigits[d2]; 
	} 

	/**
	 * @Title: MD5Encode
	 * @Description: TODO(生成32位的md5码)
	 * @param @param origin 要生成md5码的字符串
	 * @param @return 生成md5码
	 * @return String 返回类型
	 * @throws
	 */
	public static String MD5Encode(String origin) { 
		String resultString = null; 
		try { 
			resultString=new String(origin); 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			resultString=byteArrayToHexString(md.digest(resultString.getBytes())); 
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		} 
		return resultString; 
	}
	
    public static void main(String[] arg){
 	   System.out.println(MD5.MD5Encode("csset12"));

    }
}
