package com.zakj.personnel.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * InnoDB free: 13312 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-03 15:31:08
 */
public class SmdEmployeeFormalEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private String employeeFormalId;
	//职工Id
	private String employeeId;
	//转正日期
	private Date formalTime;
	//试用工资
	private String trialSalary;
	//转正工资
	private String officialSalary;
	//入职日起
	private Date inductionTime;
	//合同编号
	private String contractNo;
	//合同开始日期
	private Date contractStartDate;
	//合同截止日期
	private Date contractDeadline;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//创建人所属部门
	private String createDept;

	/**
	 * 设置：id
	 */
	public void setEmployeeFormalId(String employeeFormalId) {
		this.employeeFormalId = employeeFormalId;
	}
	/**
	 * 获取：id
	 */
	public String getEmployeeFormalId() {
		return employeeFormalId;
	}
	/**
	 * 设置：职工Id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * 获取：职工Id
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * 设置：转正日期
	 */
	public void setFormalTime(Date formalTime) {
		this.formalTime = formalTime;
	}
	/**
	 * 获取：转正日期
	 */
	public Date getFormalTime() {
		return formalTime;
	}
	/**
	 * 设置：试用工资
	 */
	public void setTrialSalary(String trialSalary) {
		this.trialSalary = trialSalary;
	}
	/**
	 * 获取：试用工资
	 */
	public String getTrialSalary() {
		return trialSalary;
	}
	/**
	 * 设置：转正工资
	 */
	public void setOfficialSalary(String officialSalary) {
		this.officialSalary = officialSalary;
	}
	/**
	 * 获取：转正工资
	 */
	public String getOfficialSalary() {
		return officialSalary;
	}
	/**
	 * 设置：入职日起
	 */
	public void setInductionTime(Date inductionTime) {
		this.inductionTime = inductionTime;
	}
	/**
	 * 获取：入职日起
	 */
	public Date getInductionTime() {
		return inductionTime;
	}
	/**
	 * 设置：合同编号
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	/**
	 * 获取：合同编号
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 设置：合同开始日期
	 */
	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	/**
	 * 获取：合同开始日期
	 */
	public Date getContractStartDate() {
		return contractStartDate;
	}
	/**
	 * 设置：合同截止日期
	 */
	public void setContractDeadline(Date contractDeadline) {
		this.contractDeadline = contractDeadline;
	}
	/**
	 * 获取：合同截止日期
	 */
	public Date getContractDeadline() {
		return contractDeadline;
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
}
