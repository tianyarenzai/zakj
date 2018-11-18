package com.zakj.security.common.beans;

import com.zakj.security.exception.BasicException;

/**
 * 基础Ajax响应
 * @author wangkl
 * 
 * 
 */
public class AjaxBasicResult {

	/**
	 * 状态码
	 * 
	 * @see com.zajy.security.common.beans.ErrorCode
	 */
	private int status;
	/**
	 * 自定义错误码。可跟据业务来自行指定。
	 */
	private int code;
	/**
	 * 错误消息
	 */
	private String msg;
	
	public AjaxBasicResult() {
		this.status = ErrorCode.SUCCESS;
		this.msg = ErrorCode.getValue(ErrorCode.SUCCESS);
	}

	public AjaxBasicResult(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public AjaxBasicResult(int status, int code, String msg) {
		this.status = status;
		this.code = code;
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		this.status = status;
		this.msg = ErrorCode.getValue(status);
	}

	public void setError(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public void setError(int status, int code, String msg) {
		this.status = status;
		this.code = code;
		this.msg = msg;
	}

	public void setError(BasicException e) {
		this.status = e.getStatus();
		this.code = e.getSubCode();
		this.msg = e.getMsg();
	}

	
	
}
