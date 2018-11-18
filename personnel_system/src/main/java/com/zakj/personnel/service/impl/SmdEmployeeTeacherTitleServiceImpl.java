package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdEmployeeTeacherTitleDao;
import com.zakj.personnel.entity.SmdEmployeeTeacherTitleEntity;
import com.zakj.personnel.service.SmdEmployeeTeacherTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 职称Service接口
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdEmployeeTeacherTitleService")
public class SmdEmployeeTeacherTitleServiceImpl implements SmdEmployeeTeacherTitleService {
	@Autowired
	private SmdEmployeeTeacherTitleDao smdEmployeeTeacherTitleDao;
	
	@Override
	public SmdEmployeeTeacherTitleEntity queryObject(String teacherTitleId){
		return smdEmployeeTeacherTitleDao.queryObject(teacherTitleId);
	}
	
	@Override
	public List<Map<String, Object>> queryList(Map<String, Object> map){
		return smdEmployeeTeacherTitleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdEmployeeTeacherTitleDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdEmployeeTeacherTitleEntity smdEmployeeTeacherTitle){
		smdEmployeeTeacherTitleDao.save(smdEmployeeTeacherTitle);
	}
	
	@Override
	public void update(SmdEmployeeTeacherTitleEntity smdEmployeeTeacherTitle){
		smdEmployeeTeacherTitleDao.update(smdEmployeeTeacherTitle);
	}
	
	@Override
	public void delete(String teacherTitleId){
		smdEmployeeTeacherTitleDao.delete(teacherTitleId);
	}
	
	@Override
	public void deleteBatch(String[] teacherTitleIds){
		smdEmployeeTeacherTitleDao.deleteBatch(teacherTitleIds);
	}
	
}
