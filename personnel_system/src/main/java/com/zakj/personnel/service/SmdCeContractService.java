package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdCeAttachmentEntity;
import com.zakj.personnel.entity.SmdCeContractEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB; (`employee_id`) REFER `renren_fast/smd_employee`(`employe
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
public interface SmdCeContractService {

	/**
	 * 获取合同对象
	 * @param contractId
	 * @return
	 */
	SmdCeContractEntity queryObject(String contractId);

	/**
	 * 获取合同列表信息
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> map);

	/**
	 * 获取合同列表数量
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存合同信息
	 * @param smdCeContract
	 */
	void save(SmdCeContractEntity smdCeContract);

	/**
	 * 编辑合同信息
	 * @param smdCeContract
	 */
	void update(SmdCeContractEntity smdCeContract);

	/**
	 * 删除合同信息
	 * @param contractId
	 */
	void delete(String contractId);

	/**
	 * 批量删除合同信息
	 * @param contractIds
	 */
	void deleteBatch(String[] contractIds);

	/**
	 * 获取合同附件
	 * @param contractId
	 * @return
	 */
	List<SmdCeAttachmentEntity> getAttachmentUrls(String contractId);
}
