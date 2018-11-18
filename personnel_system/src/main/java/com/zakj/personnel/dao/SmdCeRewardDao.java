package com.zakj.personnel.dao;

import com.zakj.personnel.entity.SmdCeRewardEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * InnoDB free: 12288 kB
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-14 17:01:30
 */
@Mapper
public interface SmdCeRewardDao extends BaseDao<SmdCeRewardEntity> {

    /**
     * 保存奖惩信息
     * @param map
     */
    void saveMap(Map<String, Object> map);

    /**
     *编辑保存奖惩信息
     * @param map
     */
    void updateMap(Map<String, Object> map);
}
