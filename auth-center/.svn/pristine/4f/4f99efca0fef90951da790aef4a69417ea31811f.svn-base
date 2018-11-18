package com.zakj.auth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * ClassName：VersionDao
 * Description：
 *
 * @author ryh
 * @date 2018/7/18 9:40
 **/
@Mapper
public interface VersionDao {
    /**
     * 根据终端类型获取终端最新版本
     * @param params
     * modelType: 终端类型
     * @return
     */
    Map<String, Object> getNewVersion(@RequestParam Map<String, Object> params);
}