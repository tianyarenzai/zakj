package com.zakj.personnel.dao;

import com.zakj.personnel.entity.SmdEmployeeJobEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 职位表; InnoDB free: 7168 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-19 14:36:02
 */
@Mapper
public interface SmdEmployeeJobDao extends BaseDao<SmdEmployeeJobEntity> {
	
}
