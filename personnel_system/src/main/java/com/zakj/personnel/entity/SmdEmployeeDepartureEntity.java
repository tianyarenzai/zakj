package com.zakj.personnel.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 职工离职表; InnoDB free: 13312 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-03 11:14:24
 */
public class SmdEmployeeDepartureEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private String employeeDepartureId;
	//职工编号
	private String employeeNumber;
	//离职日期
	private Date employeeDepartureTime;
	//职工姓名
	private String employeeName;
	//入职日期
	private Date inductionTime;
	//职工岗位
	private String employeeJob;
	//离职原因
	private String departureWhy;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//创建人所属部门
	private String createDept;
	//员工id
	private String employeeId;

	/**
	 * 设置：主键id
	 */
	public void setEmployeeDepartureId(String employeeDepartureId) {
		this.employeeDepartureId = employeeDepartureId;
	}
	/**
	 * 获取：主键id
	 */
	public String getEmployeeDepartureId() {
		return employeeDepartureId;
	}
	/**
	 * 设置：职工编号
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * 获取：职工编号
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * 设置：离职日期
	 */
	public void setEmployeeDepartureTime(Date employeeDepartureTime) {
		this.employeeDepartureTime = employeeDepartureTime;
	}
	/**
	 * 获取：离职日期
	 */
	public Date getEmployeeDepartureTime() {
		return employeeDepartureTime;
	}
	/**
	 * 设置：职工姓名
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * 获取：职工姓名
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * 设置：入职日期
	 */
	public void setInductionTime(Date inductionTime) {
		this.inductionTime = inductionTime;
	}
	/**
	 * 获取：入职日期
	 */
	public Date getInductionTime() {
		return inductionTime;
	}
	/**
	 * 设置：职工岗位
	 */
	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}
	/**
	 * 获取：职工岗位
	 */
	public String getEmployeeJob() {
		return employeeJob;
	}
	/**
	 * 设置：离职原因
	 */
	public void setDepartureWhy(String departureWhy) {
		this.departureWhy = departureWhy;
	}
	/**
	 * 获取：离职原因
	 */
	public String getDepartureWhy() {
		return departureWhy;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人所属部门
	 */
	public void setCreateDept(String createDept) {
		this.createDept = createDept;
	}
	/**
	 * 获取：创建人所属部门
	 */
	public String getCreateDept() {
		return createDept;
	}
	/**
	 * 设置：员工id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * 获取：员工id
	 */
	public String getEmployeeId() {
		return employeeId;
	}
}
