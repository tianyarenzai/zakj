package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdEmployeeFormalEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 13312 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-03 15:31:08
 */
public interface SmdEmployeeFormalService {

	/**
	 * 获取转正信息
	 * @param employeeFormalId
	 * @return
	 */
	SmdEmployeeFormalEntity queryObject(String employeeFormalId);

	/**
	 * 获取转正列表
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryList(Map<String, Object> map);

	/**
	 * 获取转正列表总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存转正信息
	 * @param smdEmployeeFormal
	 */
	void save(SmdEmployeeFormalEntity smdEmployeeFormal);

	/**
	 * 更新转正信息
	 * @param smdEmployeeFormal
	 */
	void update(SmdEmployeeFormalEntity smdEmployeeFormal);

	/**
	 * 删除转正信息
	 * @param employeeFormalId
	 */
	void delete(String employeeFormalId);

	/**
	 * 批量删除转正信息
	 * @param employeeFormalIds
	 */
	void deleteBatch(String[] employeeFormalIds);
}
