package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdEmployeeJobEntity;

import java.util.List;
import java.util.Map;

/**
 * 职位表; InnoDB free: 7168 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-19 14:36:02
 */
public interface SmdEmployeeJobService {

	/**
	 * 查询职位对象
	 * @param employeeJobId
	 * @return
	 */
	SmdEmployeeJobEntity queryObject(String employeeJobId);

	/**
	 * 查询职位列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> map);

	/**
	 * 查询职位列表数量
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 更新职位
	 * @param smdEmployeeJob
	 */
	void update(SmdEmployeeJobEntity smdEmployeeJob);

	/**
	 * 删除职位
	 * @param employeeJobId
	 */
	void delete(String employeeJobId);

	/**
	 * 批量删除职位
	 * @param employeeJobIds
	 */
	void deleteBatch(String[] employeeJobIds);

	/**
	 * 保存职位信息
	 * @param employeeJobEntity
	 */
	void save(SmdEmployeeJobEntity employeeJobEntity);
}
