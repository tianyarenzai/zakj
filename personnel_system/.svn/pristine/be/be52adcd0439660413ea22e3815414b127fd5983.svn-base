package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdCeAttachmentEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB; (`contract_id`) REFER `renren_fast/smd_ce_contract`(`cont
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
public interface SmdCeAttachmentService {

	/**
	 * 获取合同附件对象
	 * @param attachmentId
	 * @return
	 */
	SmdCeAttachmentEntity queryObject(String attachmentId);

	/**
	 * 获取合同附件列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> map);

	/**
	 * 获取合同附件列表Total
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);


	/**
	 * 保存合同附件信息
	 * @param smdCeAttachment
	 */
	void save(SmdCeAttachmentEntity smdCeAttachment);

	/**
	 * 编辑合同附件信息
	 * @param smdCeAttachment
	 */
	void update(SmdCeAttachmentEntity smdCeAttachment);

	/**
	 * 删除合同附件信息
	 * @param attachmentId
	 */
	void delete(String attachmentId);

	/**
	 * 批量删除附件信息
	 * @param attachmentIds
	 */
	void deleteBatch(String[] attachmentIds);
}
