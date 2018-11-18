package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdSsSchoolSubjectDao;
import com.zakj.personnel.entity.SmdSsSchoolSubjectEntity;
import com.zakj.personnel.service.SmdSsSchoolSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("smdSsSchoolSubjectService")
public class SmdSsSchoolSubjectServiceImpl implements SmdSsSchoolSubjectService {
	@Autowired
	private SmdSsSchoolSubjectDao smdSsSchoolSubjectDao;
	
	@Override
	public SmdSsSchoolSubjectEntity queryObject(String schoolSubjectId){
		return smdSsSchoolSubjectDao.queryObject(schoolSubjectId);
	}
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map){
		return smdSsSchoolSubjectDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdSsSchoolSubjectDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdSsSchoolSubjectEntity smdSsSchoolSubject){
		smdSsSchoolSubjectDao.save(smdSsSchoolSubject);
	}
	
	@Override
	public void update(SmdSsSchoolSubjectEntity smdSsSchoolSubject){
		smdSsSchoolSubjectDao.update(smdSsSchoolSubject);
	}
	
	@Override
	public void delete(String schoolSubjectId){
		smdSsSchoolSubjectDao.delete(schoolSubjectId);
	}
	
	@Override
	public void deleteBatch(String[] schoolSubjectIds){
		smdSsSchoolSubjectDao.deleteBatch(schoolSubjectIds);
	}

	@Override
	public List<Map<String, Object>> getSchoolSubjects(String orgId) {
		return smdSsSchoolSubjectDao.getSchoolSubjects(orgId);
	}

}
