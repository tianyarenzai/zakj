package com.zakj.security.common.beans;

/**
 * Integer型Ajax响应的封装，一般用于插入数据时返回ID
 * @author wangkl
 */
public class AjaxIntegerResult extends AjaxBasicResult {

	private long data;

	public long getData() {
		return data;
	}

	public void setData(long data) {
		this.data = data;
	}

}
