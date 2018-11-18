package com.zakj.auth.service.impl;

import com.zakj.auth.dao.ApplicationDao;
import com.zakj.auth.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName：ApplicationServiceImpl
 * Description：应用实现类
 *
 * @author ryh
 * @date 2018/6/19 11:02
 **/
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationDao applicationDao;
    @Override
    public List<Map<String, Object>> getAuthByUserId(Map<String, Object> params) {
        return applicationDao.getAuthByUserId(params);
    }
}