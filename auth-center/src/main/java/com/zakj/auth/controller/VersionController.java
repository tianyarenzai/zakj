package com.zakj.auth.controller;

import com.zakj.auth.service.VersionService;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * ClassName：VersionController
 * Description：版本控制
 *
 * @author ryh
 * @date 2018/7/6 11:03
 **/
@RestController
@RequestMapping("/version")
public class VersionController {

    @Autowired
    private VersionService versionService;
    /**
     * 根据终端类型获取终端最新版本
     * @param params
     * modelType: 终端类型
     * editionType:版本类型，测试版/正式版
     * @return
     */
    @RequestMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getNewVersion(@RequestParam Map<String, Object> params) {
        if(params.get("modelType")!=null ||params.get("editionType")!=null){
            Map<String, Object> map = versionService.getNewVersion(params);
            return R.ok(map);
        }
        return R.error(400,"参数不合法");
    }
}