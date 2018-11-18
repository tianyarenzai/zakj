package com.zakj.api;


import com.zakj.client.OrganizationFeignClient;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName：OrganizationApi
 * Description：组织机构远程调用接口
 *
 * @author ryh
 * @date 2018/5/21 14:46
 **/
@RestController
@RequestMapping("/org")//注意请求映射不能加应用名，即spring.application.name=charge
public class OrganizationFeignApi {
    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    @RequestMapping(value = "/queryList")
    public R queryList(HttpSession session){
        String tenantId = (String)session.getAttribute("tenantId");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tenantId", tenantId);
        List<Map<String, Object>> organizationList = organizationFeignClient.getOrganizationByTenantId(params);
        return R.ok(organizationList);
    }


    /**
     *  获取自己的组织机构或者数据权限
     * @param session
     * @return
     */
    @RequestMapping(value = "/queryDataAuthOrganization")
    public List<Map<String, Object>> queryDataAuthOrganization(HttpSession session){
        List<Map<String, Object>> organizationList =new ArrayList<Map<String, Object>>();

      try{
       String tenantId = (String)session.getAttribute("tenantId");
        String userId = (String)session.getAttribute("userId");
        String orgId = (String)session.getAttribute("orgId");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tenantId", tenantId);
        params.put("userId", userId);
        params.put("orgId", orgId);

        R r =organizationFeignClient.queryDataAuthOrganization(params);
        if (r.get("code").toString().equals("0")){
            organizationList = (List<Map<String, Object>>)r.get("data");
        }
      }catch(Exception e) {
          e.printStackTrace();
      }
        return organizationList;
    }

    @GetMapping(value = "/listOrg")
    public String listOrg(){
        return organizationFeignClient.listOrg();
    }


}