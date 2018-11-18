package com.zakj.personnel.dao;

import com.zakj.personnel.entity.AlyApSevPushMessageEntity;
import com.zakj.personnel.entity.AlyApSysPushAppEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB
 * 
 * @author zhangxia
 * @email zx_hrxt@163.com
 * @date 2018-04-03 15:47:21
 */
@Mapper
public interface AlyApSevPushMessageDao extends BaseDao<AlyApSevPushMessageEntity> {
    /**
     * 获取App的信息
     * @param tenantId
     * @return
     */
    AlyApSysPushAppEntity getAppInfo(String tenantId);
}
