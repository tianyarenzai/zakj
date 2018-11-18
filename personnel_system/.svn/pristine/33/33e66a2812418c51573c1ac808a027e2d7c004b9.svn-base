package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdCeContractTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
public interface SmdCeContractTypeService {
	/**
	 * 获取合同类型对象
	 * @param typeId
	 * @return
	 */
	SmdCeContractTypeEntity queryObject(String typeId);

	/**
	 * 获取合同类型信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> map);

	/**
	 * 获取合同类型信息数量
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存合同类型信息
	 * @param smdCeContractType
	 */
	void save(SmdCeContractTypeEntity smdCeContractType);

	/**
	 * 编辑合同类型信息
	 * @param smdCeContractType
	 */
	void update(SmdCeContractTypeEntity smdCeContractType);


	/**
	 * 删除合同类型信息
	 * @param typeId
	 */
	void delete(String typeId);

	/**
	 * 批量删除合同类型信息
	 * @param typeIds
	 */
	void deleteBatch(String[] typeIds);

    List<Map<String,Object>> getContractTypes(String tenantId);
}
