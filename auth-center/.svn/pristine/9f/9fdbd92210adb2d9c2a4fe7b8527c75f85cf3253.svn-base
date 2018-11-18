package com.zakj.utils;

import org.apache.commons.codec.binary.Base64;

public class EncrypBase {
	/** 
     * 解密 
     *  
     * @param pwd 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static String decodeStr(String pwd)  
    {  
        Base64 base64 = new Base64();  
        byte[] debytes = Base64.decodeBase64(new String(pwd).getBytes());  
        return new String(debytes);  
    }  
  
    /** 
     * 加密 
     *  
     * @param pwd 
     * @return 
     * @see [类、类#方法、类#成员] 
     */  
    public static String encodeStr(String pwd)  
    {  
        Base64 base64 = new Base64();  
        byte[] enbytes = Base64.encodeBase64Chunked(pwd.getBytes());  
        return new String(enbytes);  
    } 
    
 
    
    public static void main(String[] arg){

     	//String ss = "{"account":"13723559541","role":"1","module":"11"}";
     	//encodeStr(ss);
     	 System.out.println(decodeStr("eyJhY2NvdW50IjoiMTM3MjM1NTk1NDEiLCJyb2xlIjoiMSIsIm1vZHVsZSI6IjExIn0"));

     }
}
