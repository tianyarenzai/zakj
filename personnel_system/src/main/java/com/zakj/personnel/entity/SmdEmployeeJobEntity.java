package com.zakj.personnel.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 职位表; InnoDB free: 7168 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-19 14:36:02
 */
public class SmdEmployeeJobEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String employeeJobId;
	//拼音简称
	private String jobLogo;
	//职工职务
	private String employeeJob;
	//备注
	private String employeeJobNote;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//人数
	private String numberPeople;
	//职位对应的学校
	private String jobSchool;
	//职位对应的学校名
	private String schoolName;
	//职位等级
	private Integer jobRank;
	//企业id
	private String tenantId;

	/**
	 * 设置：主键
	 */
	public void setEmployeeJobId(String employeeJobId) {
		this.employeeJobId = employeeJobId;
	}
	/**
	 * 获取：主键
	 */
	public String getEmployeeJobId() {
		return employeeJobId;
	}
	/**
	 * 设置：拼音简称
	 */
	public void setJobLogo(String jobLogo) {
		this.jobLogo = jobLogo;
	}
	/**
	 * 获取：拼音简称
	 */
	public String getJobLogo() {
		return jobLogo;
	}
	/**
	 * 设置：职工职务
	 */
	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}
	/**
	 * 获取：职工职务
	 */
	public String getEmployeeJob() {
		return employeeJob;
	}
	/**
	 * 设置：备注
	 */
	public void setEmployeeJobNote(String employeeJobNote) {
		this.employeeJobNote = employeeJobNote;
	}
	/**
	 * 获取：备注
	 */
	public String getEmployeeJobNote() {
		return employeeJobNote;
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
	 * 设置：人数
	 */
	public void setNumberPeople(String numberPeople) {
		this.numberPeople = numberPeople;
	}
	/**
	 * 获取：人数
	 */
	public String getNumberPeople() {
		return numberPeople;
	}
	/**
	 * 设置：职位对应的学校
	 */
	public void setJobSchool(String jobSchool) {
		this.jobSchool = jobSchool;
	}
	/**
	 * 获取：职位对应的学校
	 */
	public String getJobSchool() {
		return jobSchool;
	}
	/**
	 * 设置：职位对应的学校名
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/**
	 * 获取：职位对应的学校名
	 */
	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * 设置：职位等级
	 */
	public void setJobRank(Integer jobRank) {
		this.jobRank = jobRank;
	}
	/**
	 * 获取：职位等级
	 */
	public Integer getJobRank() {
		return jobRank;
	}
	/**
	 * 设置：企业id
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * 获取：企业id
	 */
	public String getTenantId() {
		return tenantId;
	}
}
