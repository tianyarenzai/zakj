package com.zakj.auth.service.impl;

import com.zakj.auth.dao.DataAuthDao;
import com.zakj.auth.dao.OrganizationDao;
import com.zakj.auth.service.DataAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName：DataAuthServiceImpl
 * Description：数据权限
 *
 * @author ryh
 * @date 2018/6/8 15:31
 **/
@Service("dataAuthService")
public class DataAuthServiceImpl implements DataAuthService {
    @Autowired
    private DataAuthDao dataAuthDao;
    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return dataAuthDao.queryList(map);
    }
    /**
     * 获取生的账号信息
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> getStudentUserByUserId(Map<String, Object> map) {
        return dataAuthDao.getStudentUserByUserId(map);
    }
    /**
     * 获取数据权限
     * @param map
     * @return
     */
    @Override
    public List<Map<String,Object>> queryDataAuth(Map<String, Object> map) {
        return dataAuthDao.queryDataAuth(map);
    }
}