package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdEmployeeJobRecordDao;
import com.zakj.personnel.entity.SmdEmployeeJobRecordEntity;
import com.zakj.personnel.service.SmdEmployeeJobRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 职工职位变更Service接口
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdEmployeeJobRecordService")
public class SmdEmployeeJobRecordServiceImpl implements SmdEmployeeJobRecordService {
	@Autowired
	private SmdEmployeeJobRecordDao smdEmployeeJobRecordDao;
	
	@Override
	public SmdEmployeeJobRecordEntity queryObject(String recordId){
		return smdEmployeeJobRecordDao.queryObject(recordId);
	}
	
	@Override
	public List<Map<String,Object>> queryList(Map<String, Object> map){
		return smdEmployeeJobRecordDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdEmployeeJobRecordDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdEmployeeJobRecordEntity smdEmployeeJobRecord){
		smdEmployeeJobRecordDao.save(smdEmployeeJobRecord);
	}
	
	@Override
	public void update(SmdEmployeeJobRecordEntity smdEmployeeJobRecord){
		smdEmployeeJobRecordDao.update(smdEmployeeJobRecord);
	}
	
	@Override
	public void delete(String recordId){
		smdEmployeeJobRecordDao.delete(recordId);
	}
	
	@Override
	public void deleteBatch(String[] recordIds){
		smdEmployeeJobRecordDao.deleteBatch(recordIds);
	}
	
}
