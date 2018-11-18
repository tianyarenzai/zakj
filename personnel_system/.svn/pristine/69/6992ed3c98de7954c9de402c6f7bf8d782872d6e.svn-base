package com.zakj.personnel.controller;

import com.zakj.client.OrganizationFeignClient;
import com.zakj.personnel.service.SmdEmployeeService;
import com.zakj.security.common.beans.AjaxListResult;
import com.zakj.security.controller.BaseController;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 离职管理; InnoDB free: 5120 kB
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-02-26 14:40:06
 */
@RestController
@RequestMapping("/employee/leaveEmployee")
public class SmdLeaveEmployeeController  extends BaseController {

    @Autowired
    private SmdEmployeeService smdEmployeeService;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    @RequestMapping(value = "getLeaveEmps")
    public AjaxListResult<Map<String, Object>> getLeaveEmps(HttpServletRequest request, HttpSession session){
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> params = this.getRequestParams(request);
        String userId = (String) session.getAttribute("userId");
        params.put("userId", userId);
        String orgId = (String) session.getAttribute("orgId");
        params.put("orgId", orgId);
        R r = organizationFeignClient.queryDataAuthOrganization(params);
        List<Map<String, Object>> orgList = new ArrayList<Map<String, Object>>();
        List<String> li =new ArrayList<String>();
        if (r.get("code").toString().equals("0")) {
            orgList = (List<Map<String, Object>>) r.get("data");
            for (Iterator<Map<String, Object>> iterator = orgList.iterator(); iterator.hasNext(); ) {
                Map<String, Object> map1 =  iterator.next();
                li.add(map1.get("orgId").toString());
            }
            System.out.println("li ----------------------- " + li.toString());
            params.put("orgId", li);
        }
        List<Map<String, Object>> list = this.smdEmployeeService.getLeaveEmpList(params);
        result.setData(list);
        result.setTotal(this.smdEmployeeService.getLeaveEmpTotal(params));
        return result;
    }



}
