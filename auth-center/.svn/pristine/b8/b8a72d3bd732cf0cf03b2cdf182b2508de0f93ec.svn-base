package com.zakj.auth.service.impl;

import com.zakj.auth.dao.ApplicationDao;
import com.zakj.auth.dao.VersionDao;
import com.zakj.auth.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * ClassName：VersionServiceImpl
 * Description：终端版本控制服务
 *
 * @author ryh
 * @date 2018/7/18 9:37
 **/
@Service("versionService")
public class VersionServiceImpl implements VersionService {
    @Autowired
    private VersionDao versionDao;
    @Override
    public Map<String, Object>  getNewVersion(@RequestParam Map<String, Object> params) {
        return versionDao.getNewVersion(params);
    }
}