package com.zakj.personnel.service;


import com.zakj.personnel.entity.SmdEmployeeClazzSubjectEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB; (`xk_id`) REFER `renren_fast/zyk_xk`(`xkID`); (`employee_
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-02-27 10:55:06
 */
public interface SmdEmployeeClazzSubjectService {

	/**
	 * 获取任教信息对象
	 * @param disciplineId
	 * @return
	 */
	SmdEmployeeClazzSubjectEntity queryObject(String disciplineId);

	/**
	 * 获取职工的任教信息列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryList(Map<String, Object> map);

	/**
	 * 获取职工任教信息列表的总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 新增职工的任教信息(一条记录的操作)
	 * @param smdEmployeeClazzSubject
	 */
	void save(SmdEmployeeClazzSubjectEntity smdEmployeeClazzSubject);

	/**
	 * 更新职工的任教信息(一条记录的操作)
	 * @param smdEmployeeClazzSubject
	 */
	void update(SmdEmployeeClazzSubjectEntity smdEmployeeClazzSubject);

	/**
	 * 删除任教信息
	 * @param disciplineId
	 */
	void delete(String disciplineId);

	/**
	 * 批量删除任教信息
	 * @param disciplineIds
	 */
	void deleteBatch(String[] disciplineIds);

	/**
	 * 获取当前学校的所有年级
	 * @param orgId
	 * @return
	 */
    List<Map<String,Object>> getGrades(String orgId);


	/**
	 * 获取当前年级的所有班级
	 * @param gradeId
	 * @return
	 */
	List<Map<String,Object>> getClazzs(String gradeId);

	/**
	 * 保存职工的任教信息
	 * @param list
	 * @return
	 */
	boolean saveList(List<Map<String, Object>> list);

	/**
	 * 根据学科和班级获取任教职工
	 * @param list
	 * @return
	 */
	List<Map<String, Object>> isClazzed(List<Map<String, Object>> list);


	/**
	 * 获取学位信息
	 * @param tenantId
	 * @return
	 */
    List<Map<String,Object>> getSubject(String tenantId);
}
