package com.zakj.personnel.dao;

import com.zakj.personnel.entity.SmdEmployeeDepartureEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 职工离职表; InnoDB free: 13312 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-03 11:14:24
 */
@Mapper
public interface SmdEmployeeDepartureDao extends BaseDao<SmdEmployeeDepartureEntity> {
	
}
