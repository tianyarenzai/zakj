package com.zakj.client;

import com.zakj.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by 0ops on 2018/6/5.
 */
@FeignClient(value  ="auth-center", fallback = OrganizationFeignClientHystrix.class)
public interface OrganizationFeignClient {
    @RequestMapping(value ="/auth/getOrganizationByTenantId")
    public List<Map<String, Object>> getOrganizationByTenantId(@RequestParam Map<String, Object> params);
    @GetMapping(value ="/org/listOrg")
    public String listOrg();
    @RequestMapping(value ="/auth/getOrganizationDept")
    public R getOrganizationDept(@RequestParam Map<String, Object> params);

    /**
     * 获取自己的组织机构或者数据权限
     * @param params
     * @return
     */
    @RequestMapping(value ="/auth/queryDataAuthOrganization")
    R queryDataAuthOrganization(@RequestParam Map<String, Object> params);

    @RequestMapping(value ="/user/generateAccount")
    R generateAccount(@RequestParam Map<String, Object> params);
}
