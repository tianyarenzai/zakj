package com.zakj.api;

import com.zakj.client.AuthFeignClient;
import com.zakj.client.OrganizationFeignClient;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * ClassName：AuthFeignApi
 * Description：权限远程调用接口
 *
 * @author ryh
 * @date 2018/6/8 16:02
 **/
@RestController
@RequestMapping("/auth")
public class AuthFeignApi {
    @Autowired
    private AuthFeignClient authFeignClient;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;


    /**
     * 根据职工ID和企业ID获取数据访问权限
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/org/treeList")
    public List<Map<String, Object>> getDataAuthTreeByEmpId(@RequestParam Map<String, Object> params, HttpSession session) {
        try {
            String tenantId = (String) session.getAttribute("tenantId");
            String userId = (String) session.getAttribute("userId");
            String employeeId = (String) session.getAttribute("employeeId");
            String orgId = (String) session.getAttribute("orgId");
            params.put("tenantId", tenantId);
            params.put("employeeId", employeeId);
            params.put("userId", userId);
            params.put("orgId", orgId);
            R r = authFeignClient.getDataAuthTreeByUserId(params);
            List<Map<String, Object>> organizationList = (List<Map<String, Object>>) r.get("data");
            return organizationList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取学校数据
     *
     * @param params
     * @param session
     * @return
     */
    @RequestMapping(value = "/org/getOrganizations")
    public List<Map<String, Object>> getOrganizations(@RequestParam Map<String, Object> params, HttpSession session) {
        try {
            String tenantId = (String) session.getAttribute("tenantId");
            params.put("tenantId", tenantId);
            String userId = (String) session.getAttribute("userId");
            params.put("userId", userId);
            String orgId = (String) session.getAttribute("orgId");
            params.put("orgId", orgId);
            R r = organizationFeignClient.queryDataAuthOrganization(params);
            List<Map<String, Object>> orgList = new ArrayList<Map<String, Object>>();
            List<Object> li = new ArrayList<Object>();
            if (r.get("code").toString().equals("0")) {
                orgList = (List<Map<String, Object>>) r.get("data");
            }
            return R.list(orgList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取部门
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/org/getDeptsByOrgId")
    public List<Map<String, Object>> getDeptsByOrgId(@RequestParam Map<String, Object> params, HttpSession session) {
        String tenantId = (String) session.getAttribute("tenantId");
        params.put("tenantId", tenantId);
        List<Map<String, Object>> list = null;
        if (params.containsKey("orgId")) {
            list = authFeignClient.getDeptsByOrgId(params);
        } else {
            list = authFeignClient.getDeptsByOrgId(params);
        }
        System.out.println("list: ----------------------------- " + list);
        return R.list(list);
    }
}