package com.zakj.personnel.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * InnoDB free: 12288 kB; (`contract_id`) REFER `renren_fast/smd_ce_contract`(`cont
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
public class SmdCeAttachmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//附件id
	private String attachmentId;
	//合同id
	private String contractId;
	//附件路径
	private String attachmentUrl;
	//附件类型
	private String attachmentType;
	//附件名称
	private String attachmentName;
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

	/**
	 * 设置：附件id
	 */
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	/**
	 * 获取：附件id
	 */
	public String getAttachmentId() {
		return attachmentId;
	}
	/**
	 * 设置：合同id
	 */
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	/**
	 * 获取：合同id
	 */
	public String getContractId() {
		return contractId;
	}
	/**
	 * 设置：附件路径
	 */
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}
	/**
	 * 获取：附件路径
	 */
	public String getAttachmentUrl() {
		return attachmentUrl;
	}
	/**
	 * 设置：附件类型
	 */
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	/**
	 * 获取：附件类型
	 */
	public String getAttachmentType() {
		return attachmentType;
	}
	/**
	 * 设置：附件名称
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	/**
	 * 获取：附件名称
	 */
	public String getAttachmentName() {
		return attachmentName;
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
}
