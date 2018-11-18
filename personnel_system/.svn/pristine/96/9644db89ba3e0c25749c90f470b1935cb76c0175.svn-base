package com.zakj.security.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统日志
 * 
 * @author yy
 * @email sunlightcs@gmail.com
 * @date 2017-03-08 10:40:56
 */
public class SysLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户操作
	 */
	private String operation;
	/**
	 * 请求方法
	 */
	private String method;
	/**
	 * 请求参数
	 */
	private String params;
	/**
	 * 执行时长(毫秒)
	 */
	private Long time;
	/**
	 * IP地址
	 */
	private String ip;
	/**
	 * 创建时间
	 */
 
	private Date createDate;
	private String userId;
	private String empId;
	private String accessAddress;
	
	private String orgId;

	
	
	private String tenantId;
	
	
	
	 

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：用户操作
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/**
	 * 获取：用户操作
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * 设置：请求方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * 获取：请求方法
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * 设置：请求参数
	 */
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 获取：请求参数
	 */
	public String getParams() {
		return params;
	}
	/**
	 * 设置：IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 获取：IP地址
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateDate() {
		return createDate;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	public String getUserId() {
	    return userId;
	}
	public void setUserId(String userId) {
	    this.userId = userId;
	}
	public String getEmpId() {
	    return empId;
	}
	public void setEmpId(String empId) {
	    this.empId = empId;
	}
	public String getAccessAddress() {
	    return accessAddress;
	}
	public void setAccessAddress(String accessAddress) {
	    this.accessAddress = accessAddress;
	}
	public String getOrgId() {
	    return orgId;
	}
	public void setOrgId(String orgId) {
	    this.orgId = orgId;
	}
	public String getTenantId() {
	    return tenantId;
	}
	public void setTenantId(String tenantId) {
	    this.tenantId = tenantId;
	}
	
	
}
