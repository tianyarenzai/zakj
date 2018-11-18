package com.zakj.auth.controller;

import com.zakj.auth.service.OrganizationService;
import com.zakj.utils.EncrypBase;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName：OrganizationController
 * Description：组织机构控制器
 *
 * @author ryh
 * @date 2018/5/19 16:27
 **/
@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;
    @Value("${server.port}")
    String serverPort;
    /**
     * 列表
     */
    @RequestMapping(value ="/queryList")
    public List<Map<String, Object>> queryList(@RequestParam Map<String, Object> params) {
        //查询列表数据
       // String tenantId = (String) session.getAttribute("tenantId");//
       /* String tenantId = "402881f85c5d670d015c5d6938b50000";
        params.put("tenant_id", tenantId);*/
        params.put("current_port", serverPort);
        List<Map<String, Object>> organizationList = organizationService.queryList(params);
        organizationList.add(params);
        return R.list(organizationList);
    }


    @GetMapping(value ="/listOrg")
    public String listOrg(){
        /**
         * 模拟从数据库查询
         */
        String tenantId = "402881f85c5d670d015c5d6938b50000";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tenant_id", tenantId);
        List<Map<String, Object>> organizationList = organizationService.queryList(params);
        return "服务器端口号：   " + serverPort + "   |   用户信息：   " + organizationList.toString();
    }


}