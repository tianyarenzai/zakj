package com.zakj.personnel.dao;

import com.zakj.personnel.entity.SmdCeContractTypeEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Mapper
public interface SmdCeContractTypeDao extends BaseDao<SmdCeContractTypeEntity> {

    /**
     * 获取合同类型
     * @return
     * @param tenantId
     */
    List<Map<String,Object>> getContractTypes(String tenantId);
}
