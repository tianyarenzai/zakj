package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdEmployeeTeacherTitleEntity;

import java.util.List;
import java.util.Map;

/**
 * 职称表; InnoDB free: 5120 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-02-26 14:40:06
 */
public interface SmdEmployeeTeacherTitleService {

	/**
	 * 获取职称信息
	 * @param teacherTitleId
	 * @return
	 */
	SmdEmployeeTeacherTitleEntity queryObject(String teacherTitleId);

	/**
	 * 获取职称信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> map);

	/**
	 * 获取职称信息列表总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存职称信息
	 * @param smdEmployeeTeacherTitle
	 */
	void save(SmdEmployeeTeacherTitleEntity smdEmployeeTeacherTitle);

	/**
	 * 更新职称信息
	 * @param smdEmployeeTeacherTitle
	 */
	void update(SmdEmployeeTeacherTitleEntity smdEmployeeTeacherTitle);

	/**
	 * 删除职称信息
	 * @param teacherTitleId
	 */
	void delete(String teacherTitleId);

	/**
	 * 批量删除职称信息
	 * @param teacherTitleIds
	 */
	void deleteBatch(String[] teacherTitleIds);
}
