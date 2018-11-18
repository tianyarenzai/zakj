package com.zakj.auth.dao;


import com.zakj.auth.entity.DataAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * ClassName：DataAuthDao
 * Description：权限数据访问层
 *
 * @author ryh
 * @date 2018/6/8 14:43
 **/
@Mapper
public interface DataAuthDao extends BaseDao<DataAuth> {
    /**
     * 获取生的账号信息
     * @param map
     * @return
     */
    Map<String,Object> getStudentUserByUserId(Map<String, Object> map);

    /**
     * 获取数据权限
     * @param map
     * @return
     */
    List<Map<String,Object>> queryDataAuth(Map<String, Object> map);
}
