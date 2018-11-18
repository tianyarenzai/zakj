package com.zakj.security.common.beans;

import com.zakj.security.exception.BasicException;

public class AjaxBaseResult {
	private int code;
	/**
	 * 错误消息
	 */
	private String msg;
	
	public AjaxBaseResult() {
		
		this.msg = ErrorCode.getValue(ErrorCode.SUCCESS);
	}

	

	public AjaxBaseResult( int code, String msg) {
		
		this.code = code;
		this.msg = msg;
	}

	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setError(int status) {
		
		this.msg = ErrorCode.getValue(status);
	}

	public void setError(int status, String msg) {
	
		this.msg = msg;
	}

	public void setError(int status, int code, String msg) {
		
		this.code = code;
		this.msg = msg;
	}

	public void setError(BasicException e) {
		
		this.code = e.getSubCode();
		this.msg = e.getMsg();
	}

	
}
