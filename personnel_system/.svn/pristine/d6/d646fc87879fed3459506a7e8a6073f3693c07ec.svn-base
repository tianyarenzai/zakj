package com.zakj.personnel.service;


import com.zakj.personnel.entity.SmdSsSchoolSubjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-19 11:24:11
 */
public interface SmdSsSchoolSubjectService {
	
	SmdSsSchoolSubjectEntity queryObject(String schoolSubjectId);
	
	List<Map<String, Object>> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);
	
	void save(SmdSsSchoolSubjectEntity smdSsSchoolSubject);
	
	void update(SmdSsSchoolSubjectEntity smdSsSchoolSubject);
	
	void delete(String schoolSubjectId);
	
	void deleteBatch(String[] schoolSubjectIds);

	/**
	 * 获取学校学科
	 * @param orgId
	 * @return
	 */
    List<Map<String,Object>> getSchoolSubjects(String orgId);
}
