package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdEmployeeJobRecordEntity;
import java.util.List;
import java.util.Map;

/**
 * 职位变更记录; InnoDB free: 13312 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-03 09:24:44
 */
public interface SmdEmployeeJobRecordService {
	/**
	 * 获取岗位变更记录
	 * @param recordId
	 * @return
	 */
	SmdEmployeeJobRecordEntity queryObject(String recordId);

	/**
	 * 获取岗位变更记录列表
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryList(Map<String, Object> map);

	/**
	 * 获取岗位变更记录列表总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存岗位变更信息
	 * @param smdEmployeeJobRecord
	 */
	void save(SmdEmployeeJobRecordEntity smdEmployeeJobRecord);

	/**
	 * 更新岗位变更信息
	 * @param smdEmployeeJobRecord
	 */
	void update(SmdEmployeeJobRecordEntity smdEmployeeJobRecord);

	/**
	 * 删除岗位变更信息
	 * @param recordId
	 */
	void delete(String recordId);

	/**
	 * 批量删除岗位变更信息
	 * @param recordIds
	 */
	void deleteBatch(String[] recordIds);
}
