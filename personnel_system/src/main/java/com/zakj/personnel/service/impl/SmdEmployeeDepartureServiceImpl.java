package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdEmployeeDao;
import com.zakj.personnel.dao.SmdEmployeeDepartureDao;
import com.zakj.personnel.entity.SmdEmployeeDepartureEntity;
import com.zakj.personnel.entity.SmdEmployeeJobRecordEntity;
import com.zakj.personnel.service.SmdEmployeeDepartureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 职工离职管理Service接口
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */

@Service("smdEmployeeDepartureService")
public class SmdEmployeeDepartureServiceImpl implements SmdEmployeeDepartureService {
	@Autowired
	private SmdEmployeeDepartureDao smdEmployeeDepartureDao;

	@Autowired
	private SmdEmployeeDao smdEmployeeDao;
	
	@Override
	public SmdEmployeeDepartureEntity queryObject(String employeeDepartureId){
		return smdEmployeeDepartureDao.queryObject(employeeDepartureId);
	}
	
	@Override
	public List<Map<String,Object>> queryList(Map<String, Object> map){
		return smdEmployeeDepartureDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdEmployeeDepartureDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdEmployeeDepartureEntity smdEmployeeDeparture){
		// 保存职工的离职信息
		smdEmployeeDepartureDao.save(smdEmployeeDeparture);
		// 修改职工状态为离职 3
		System.out.println("employeeId====================================== " + smdEmployeeDeparture.getEmployeeId() );
		smdEmployeeDao.updateEmployeeState(smdEmployeeDeparture.getEmployeeId());

	}
	
	@Override
	public void update(SmdEmployeeDepartureEntity smdEmployeeDeparture){
		smdEmployeeDepartureDao.update(smdEmployeeDeparture);
	}
	
	@Override
	public void delete(String employeeDepartureId){
		smdEmployeeDepartureDao.delete(employeeDepartureId);
	}
	
	@Override
	public void deleteBatch(String[] employeeDepartureIds){
		smdEmployeeDepartureDao.deleteBatch(employeeDepartureIds);
	}
	
}
