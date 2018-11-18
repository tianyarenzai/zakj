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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

 /*
    * @author zhangxia
    * @email zhangxia_rgcdlb@163.com
    * @date 2018-03-11 17:04:24
    */
@Controller
@RequestMapping("/employee/headTeacher")
public class HeadTeacherAndSubsitutionController extends BaseController {

    @Autowired
    private SmdEmployeeService smdEmployeeService;

     @Autowired
     private OrganizationFeignClient organizationFeignClient;


    /**
     * 获取班主任及代课管理信息
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("getHeadTeacherTeachClazzs")
    @ResponseBody
    public R getHeadTeacherTeachClazzs(HttpServletRequest request, HttpSession session) {
        List<Object> li =new ArrayList<Object>();
        List<Map<String, Object>> organizationList = new ArrayList<Map<String, Object>>();
        Map<String, Object> params = this.getRequestParams(request);
        String userId = (String) session.getAttribute("userId");
        String orgId = (String) session.getAttribute("orgId");
        String type = params.get("type").toString();
        String orgId1 = params.get("orgId").toString();
        params.put("userId", userId);
        params.put("orgId", orgId);
        if (type.equals("0")||orgId1.equals("")) {
            params.put("orgId", orgId);
            params.put("userId", userId);
            R r = organizationFeignClient.queryDataAuthOrganization(params);
            if (r.get("code").toString().equals("0")) {
                organizationList = (List<Map<String, Object>>) r.get("data");
                for (Iterator<Map<String, Object>> iterator = organizationList.iterator(); iterator.hasNext(); ) {
                    Map<String, Object> map1 =  iterator.next();
                    li.add(map1.get("orgId"));
                }
                params.put("orgId",li);
            }
        }else {

            li.add(orgId1);
            params.put("orgId",li);
        }
        List<Map<String, Object>> list = smdEmployeeService.getHeadTeacherTeachClazzs(params);

         long i=smdEmployeeService.getHeadTeacherTeachClazzTotal(params);

        return  R.ok(list,i);
    }
}
