package com.zakj.personnel.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * InnoDB free: 9216 kB
 * 
 * @author zhangxia
 * @email zx_hrxt@163.com
 * @date 2018-04-08 15:27:35
 */
public class AlyApSevPushMessageItemEntity extends AlyApSevPushMessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long itemId;
	//
	private Long messageId;
	//
	private String deviceId;
	//0:未到达, 1:到达
	private Integer isDelivery;
	//0:未打开, 1:打开
	private Integer isOpen;
	//0:未删除，1：删除
	private Integer isDelete;
	//
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	/**
	 * 获取：
	 */
	public Long getItemId() {
		return itemId;
	}
	/**
	 * 设置：
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	/**
	 * 获取：
	 */
	public Long getMessageId() {
		return messageId;
	}
	/**
	 * 设置：
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：0:未到达, 1:到达
	 */
	public void setIsDelivery(Integer isDelivery) {
		this.isDelivery = isDelivery;
	}
	/**
	 * 获取：0:未到达, 1:到达
	 */
	public Integer getIsDelivery() {
		return isDelivery;
	}
	/**
	 * 设置：0:未打开, 1:打开
	 */
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}
	/**
	 * 获取：0:未打开, 1:打开
	 */
	public Integer getIsOpen() {
		return isOpen;
	}
	/**
	 * 设置：0:未删除，1：删除
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：0:未删除，1：删除
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
