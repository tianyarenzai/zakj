package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdEmployeeDepartureEntity;

import java.util.List;
import java.util.Map;

/**
 * 职工离职表; InnoDB free: 13312 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-03 11:14:24
 */
public interface SmdEmployeeDepartureService {
	/**
	 * 获取离职信息
	 * @param employeeDepartureId
	 * @return
	 */
	SmdEmployeeDepartureEntity queryObject(String employeeDepartureId);

	/**
	 * 获取离职信息列表
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryList(Map<String, Object> map);

	/**
	 * 获取离职信息列表总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存离职信息
	 * @param smdEmployeeDeparture
	 */
	void save(SmdEmployeeDepartureEntity smdEmployeeDeparture);

	/**
	 * 更新离职信息
	 * @param smdEmployeeDeparture
	 */
	void update(SmdEmployeeDepartureEntity smdEmployeeDeparture);

	/**
	 * 删除离职信息
	 * @param employeeDepartureId
	 */
	void delete(String employeeDepartureId);

	/**
	 * 批量删除离职信息
	 * @param employeeDepartureIds
	 */
	void deleteBatch(String[] employeeDepartureIds);
}
