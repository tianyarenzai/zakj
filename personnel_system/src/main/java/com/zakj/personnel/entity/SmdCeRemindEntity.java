package com.zakj.personnel.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * InnoDB free: 12288 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
public class SmdCeRemindEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//提醒id
	private String remindId;
	//提醒时间
	private Date remindTime;
	//1:消息，2:邮件，3:短信 ...........
	private Integer remindType;
	//内荣
	private String content;

	// 合同Id
	private String contractId;

	//企业
	private String tenantId;
	//机构
	private String orgId;
	//创建人id
	private String createUser;
	//
	private Date createDate;
	//创建职工id
	private String createEmpId;
	//创建职工
	private String createEmpName;
	//修改时间
	private Date updateTime;
	//0:正常，1:删除
	private Integer state;

	private String userId;

	/**
	 * 设置：提醒id
	 */
	public void setRemindId(String remindId) {
		this.remindId = remindId;
	}
	/**
	 * 获取：提醒id
	 */
	public String getRemindId() {
		return remindId;
	}
	/**
	 * 设置：提醒时间
	 */
	public void setRemindTime(Date remindTime) {
		this.remindTime = remindTime;
	}
	/**
	 * 获取：提醒时间
	 */
	public Date getRemindTime() {
		return remindTime;
	}
	/**
	 * 设置：1:消息，2:邮件，3:短信 ...........
	 */
	public void setRemindType(Integer remindType) {
		this.remindType = remindType;
	}
	/**
	 * 获取：1:消息，2:邮件，3:短信 ...........
	 */
	public Integer getRemindType() {
		return remindType;
	}
	/**
	 * 设置：内荣
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内荣
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：企业
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * 获取：企业
	 */
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * 设置：机构
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：机构
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人id
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：创建职工id
	 */
	public void setCreateEmpId(String createEmpId) {
		this.createEmpId = createEmpId;
	}
	/**
	 * 获取：创建职工id
	 */
	public String getCreateEmpId() {
		return createEmpId;
	}
	/**
	 * 设置：创建职工
	 */
	public void setCreateEmpName(String createEmpName) {
		this.createEmpName = createEmpName;
	}
	/**
	 * 获取：创建职工
	 */
	public String getCreateEmpName() {
		return createEmpName;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：0:正常，1:删除
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0:正常，1:删除
	 */
	public Integer getState() {
		return state;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
