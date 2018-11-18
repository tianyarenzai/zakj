package com.zakj.client;

import com.zakj.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * ClassName：OrganizationFeignClient
 * Description：组织机构Feign接口
 * Created by 0ops on 2018/5/19.
 * 此接口中的方法和远程服务中contoller中的方法名和参数需保持一致
 */

@FeignClient(value  ="auth-center", fallback = AuthFeignClientHystrix.class)
public interface AuthFeignClient {
    /**
     * 根据职工ID获取数据访问权限
     */
    @RequestMapping(value ="/auth/getOrgListByTenId")
    public List<Map<String, Object>> getOrgListByTenId(@RequestParam Map<String, Object> params);

    /**
     * 根据租户ID获取组织机构列表
     */
    @RequestMapping(value ="/auth/getDataAuthTreeByUserId")
    public R getDataAuthTreeByUserId(@RequestParam Map<String, Object> params);

    /**
     * 根据组织id获取部门信息
     * @param params
     * @return
     */
    @RequestMapping(value ="/auth/getDeptsByOrgId")
    List<Map<String,Object>> getDeptsByOrgId(@RequestParam Map<String, Object> params);

    @RequestMapping(value ="/auth/getDingtalk")
    R getDingtalk(@RequestParam Map<String, Object> params);


}
