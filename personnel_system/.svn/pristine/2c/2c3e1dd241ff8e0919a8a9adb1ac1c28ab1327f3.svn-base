package com.zakj.client;

import com.zakj.utils.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName：AuthFeignClientHystrix
 * Description：权限断路器实现类
 *
 * @author ryh
 * @date 2018/6/8 15:59
 **/
@Component
public class AuthFeignClientHystrix implements AuthFeignClient {
    @Override
    public List<Map<String, Object>> getOrgListByTenId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        params.put("fail", "调用服务接口获取组织机构下拉框数据失败！");
        return list;
    }

    @Override
    public R getDataAuthTreeByUserId(@RequestParam Map<String, Object> params) {
        return R.error(101, "调用数据访问服务接口，获取数据访问权限失败！");
    }

    @Override
    public List<Map<String, Object>> getDeptsByOrgId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("101", "调用数据访问服务接口，获取数据访问权限失败");
        list.add(map);
        return list;
    }


    @Override
    public R getDingtalk(@RequestParam Map<String, Object> params) {
        return R.ok(101, "调用数据访问服务接口，获取数据访问权限失败");
    }
}