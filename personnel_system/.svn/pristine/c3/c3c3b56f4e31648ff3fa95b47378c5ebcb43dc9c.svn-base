package com.zakj.client;

import com.zakj.utils.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName：OrganizationFeignClientHystrix
 * Description：组织机构
 *
 * @author ryh
 * @date 2018/6/5 8:25
 **/
@Component
public class OrganizationFeignClientHystrix implements OrganizationFeignClient {

    @Override
    public List<Map<String, Object>> getOrganizationByTenantId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        params.put("fail", "调用服务接口获取组织机构下拉框数据失败！");
        return list;
    }

    @Override
    public String listOrg() {
        return "调用组织机构服务接口，获取组织数据失败！";
    }

    @Override
    public R getOrganizationDept(Map<String, Object> params) {
        params.put("fail", "调用服务接口获取组织机构下拉框数据失败！");
        return R.ok(params);
    }

    @Override
    public R queryDataAuthOrganization(Map<String, Object> params) {
        params.put("fail", "调用数据权限服务接口获取组织机构下拉框数据失败！");
        return R.ok(params);
    }

    @Override
    public R generateAccount(@RequestParam Map<String, Object> params) {
        params.put("fail", "添加职工用户数据失败！");
        return R.ok(params);
    }
}