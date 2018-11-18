package com.zakj.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName：StudentFeignClientHystrix
 * Description：学生服务断路器
 *
 * @author ryh
 * @date 2018/6/4 11:33
 **/
@Component
public class StudentFeignClientHystrix implements StudentFeignClient{

    @Override
    public List<Map<String,Object>> getSemesterList(@RequestParam Map<String, Object> map) {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        map.put("fail", "调用服务接口获取学期下拉框数据失败！");
        list.add(map);
        return list;

    }

    @Override
    public List<Map<String, Object>>  getGradesByOrgId(@RequestParam Map<String, Object> map) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        map.put("fail", "调用服务接口获取年级下拉框数据失败！");
        list.add(map);

        return list;
    }

    @Override
    public List<Map<String, Object>> getClazzsByGradeId(@RequestParam Map<String, Object> map) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        map.put("fail", "调用服务接口获取班级下拉框数据失败！");
        list.add(map);
        return list;
    }

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        map.put("fail", "调用服务接口获取学生数据失败！");
        list.add(map);
        return list;
    }
}