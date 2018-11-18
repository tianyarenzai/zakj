package com.zakj.utils;

import com.alibaba.fastjson.JSONObject;


public class JSON {
	
	
	/**
	 * 获取问号后面的加密参数并解析
	 * @return
	 */
	public static JSONObject getUrlParams(String params){
		String param = EncrypBase.decodeStr(params);
		return JSONObject.parseObject(param);
	}

	/**
	 * 加密问号后面的参数
	 * @param key 问号后面的key 也就是等号前面的key
	 * @param val 问号后面的value 也就是等号后面的value
	 * @return
	 */
	public static String encryUrl(String[] key,String[] val) {
		JSONObject json = new JSONObject();
		for (int i = 0; i < key.length; i++) {
			json.put(key[i], val[i]);
		}
		String params = json.toString();
		return EncrypBase.encodeStr(params).replaceAll("[\\s*\t\n\r]", "");
	}
}

