package com.zakj.personnel.service;

import com.zakj.personnel.entity.SmdSsSubjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 学科; InnoDB free: 12288 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-13 16:52:56
 */
public interface SmdSsSubjectService {

	/**
	 * 获取学科对象
	 * @param subjectId
	 * @return
	 */
	SmdSsSubjectEntity queryObject(String subjectId);

	/**
	 * 获取学科列表信息
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> queryList(Map<String, Object> map);

	/**
	 * 获取学科列表信息记录数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 保存学科信息
	 * @param smdSsSubject
	 */
	void save(SmdSsSubjectEntity smdSsSubject);

	/**
	 * 编辑学科信息
	 * @param smdSsSubject
	 */
	void update(SmdSsSubjectEntity smdSsSubject);

	/**
	 * 删除学科信息
	 * @param subjectId
	 */
	void delete(String subjectId);

	/**
	 * 批量删除学科信息
	 * @param subjectIds
	 */
	void deleteBatch(String[] subjectIds);
}
