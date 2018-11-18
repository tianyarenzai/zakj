package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdEmployeeDao;
import com.zakj.personnel.dao.SmdEmployeeFormalDao;
import com.zakj.personnel.entity.SmdEmployeeFormalEntity;
import com.zakj.personnel.service.SmdEmployeeFormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 职工转正Service接口
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdEmployeeFormalService")
public class SmdEmployeeFormalServiceImpl implements SmdEmployeeFormalService {
	@Autowired
	private SmdEmployeeFormalDao smdEmployeeFormalDao;

	@Autowired
	private SmdEmployeeDao smdEmployeeDao;
	
	@Override
	public SmdEmployeeFormalEntity queryObject(String employeeFormalId){
		return smdEmployeeFormalDao.queryObject(employeeFormalId);
	}
	
	@Override
	public List<Map<String,Object>> queryList(Map<String, Object> map){
		return smdEmployeeFormalDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdEmployeeFormalDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdEmployeeFormalEntity smdEmployeeFormal){
		// 保存职工转正信息
		smdEmployeeFormalDao.save(smdEmployeeFormal);
		// 更新职工状态为正式: 2
		smdEmployeeDao.updateEmpFormal(smdEmployeeFormal.getEmployeeId());
	}
	
	@Override
	public void update(SmdEmployeeFormalEntity smdEmployeeFormal){
		smdEmployeeFormalDao.update(smdEmployeeFormal);
	}
	
	@Override
	public void delete(String employeeFormalId){
		smdEmployeeFormalDao.delete(employeeFormalId);
	}
	
	@Override
	public void deleteBatch(String[] employeeFormalIds){
		smdEmployeeFormalDao.deleteBatch(employeeFormalIds);
	}
	
}
