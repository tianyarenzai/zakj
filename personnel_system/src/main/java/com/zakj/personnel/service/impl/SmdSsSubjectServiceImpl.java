package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdSsSubjectDao;
import com.zakj.personnel.entity.SmdSsSubjectEntity;
import com.zakj.personnel.service.SmdSsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 学科Service接口
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdSsSubjectService")
public class SmdSsSubjectServiceImpl implements SmdSsSubjectService {
	@Autowired
	private SmdSsSubjectDao smdSsSubjectDao;
	
	@Override
	public SmdSsSubjectEntity queryObject(String subjectId){
		return smdSsSubjectDao.queryObject(subjectId);
	}
	
	@Override
	public List<Map<String,Object>> queryList(Map<String, Object> map){
		return smdSsSubjectDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdSsSubjectDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdSsSubjectEntity smdSsSubject){
		smdSsSubjectDao.save(smdSsSubject);
	}
	
	@Override
	public void update(SmdSsSubjectEntity smdSsSubject){
		smdSsSubjectDao.update(smdSsSubject);
	}
	
	@Override
	public void delete(String subjectId){
		smdSsSubjectDao.delete(subjectId);
	}
	
	@Override
	public void deleteBatch(String[] subjectIds){
		smdSsSubjectDao.deleteBatch(subjectIds);
	}
	
}
