package com.zakj.personnel.service.impl;

import com.zakj.personnel.dao.SmdCeContractTypeDao;
import com.zakj.personnel.entity.SmdCeContractTypeEntity;
import com.zakj.personnel.service.SmdCeContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
/**
 * 合同类型Service接口
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdCeContractTypeService")
public class SmdCeContractTypeServiceImpl implements SmdCeContractTypeService {
	@Autowired
	private SmdCeContractTypeDao smdCeContractTypeDao;
	
	@Override
	public SmdCeContractTypeEntity queryObject(String typeId){
		return smdCeContractTypeDao.queryObject(typeId);
	}
	
	@Override
	public List<Map<String,Object>> queryList(Map<String, Object> map){
		return smdCeContractTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return smdCeContractTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(SmdCeContractTypeEntity smdCeContractType){
		smdCeContractTypeDao.save(smdCeContractType);
	}
	
	@Override
	public void update(SmdCeContractTypeEntity smdCeContractType){
		smdCeContractTypeDao.update(smdCeContractType);
	}
	
	@Override
	public void delete(String typeId){
		smdCeContractTypeDao.delete(typeId);
	}
	
	@Override
	public void deleteBatch(String[] typeIds){
		smdCeContractTypeDao.deleteBatch(typeIds);
	}

	@Override
	public List<Map<String, Object>> getContractTypes(String tenantId) {
		return smdCeContractTypeDao.getContractTypes(tenantId);
	}
}
