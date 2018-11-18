package com.zakj.security.exception;

import  com.zakj.security.common.beans.ErrorCode;;


/**
 * 基础异常封闭
 * 
 * @author wangkl
 *
 */
public class BasicException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 状态码
	 * 
	 * @see com.zakj.security.common.beans.ErrorCode
	 */
	private int status;
	/**
	 * 自定义错误码。可跟据业务来自行指定。
	 */
	private int subCode;
	/**
	 * 错误消息
	 */
	private String msg;

	public BasicException() {
	}

	public BasicException(int status) {
		this.status = status;
		this.msg = ErrorCode.getValue(status);
	}

	public BasicException(int status, Throwable cause) {
		super(cause);
		this.status = status;
		this.msg = ErrorCode.getValue(status);
	}

	public BasicException(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public BasicException(int status, String msg, Throwable cause) {
		super(cause);
		this.status = status;
		this.msg = msg;
	}

	public BasicException(int status, int subCode, String msg) {
		this.status = status;
		this.subCode = subCode;
		this.msg = msg;
	}

	public BasicException(int status, int subCode, String msg, Throwable cause) {
		super(cause);
		this.status = status;
		this.subCode = subCode;
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSubCode() {
		return subCode;
	}

	public void setSubCode(int subCode) {
		this.subCode = subCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getContext() {
		StringBuffer info = new StringBuffer();
		info.append(this.status);
		if (subCode == 0) {
			info.append("-" + subCode);
		}
		info.append(":");
		info.append(this.getMsg());
		return info.toString();
	}

}
