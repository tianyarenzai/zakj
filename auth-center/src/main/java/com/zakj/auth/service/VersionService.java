package com.zakj.auth.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by 0ops on 2018/7/6.
 */
public interface VersionService {
    /**
     * 根据终端类型获取终端最新版本
     * @param params
     * modelType: 终端类型
     * @return
     */
    Map<String, Object>  getNewVersion(@RequestParam Map<String, Object> params);
}
