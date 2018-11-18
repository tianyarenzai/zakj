package com.zakj.api;


import com.zakj.client.OrganizationFeignClient;
import com.zakj.client.StudentFeignClient;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * ClassName：SemesterFeignApi
 * Description：学生远程调用接口
 *
 * @author ryh
 * @date 2018/6/1 11:03
 **/

@RestController
@RequestMapping("/student")
public class StudentFeignApi {
    @Autowired
    private StudentFeignClient studentFeignClient;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    @RequestMapping(value = "/semester/querySemesterList")
    public List<Map<String, Object>> querySemesterList(@RequestParam Map<String, Object> params, HttpSession session) {
        String tenantId = (String) session.getAttribute("tenantId");
        String orgId = (String) session.getAttribute("orgId");
        params.put("tenantId", tenantId);
        if (params.get("orgId") == null || "".equals(params.get("orgId"))) {
            params.put("orgId", orgId);
        }
        String userId = (String) session.getAttribute("userId");
        params.put("userId", userId);
        R r = organizationFeignClient.queryDataAuthOrganization(params);
        List<Map<String, Object>> organizationList = new ArrayList<Map<String, Object>>();
        List<Object> li =new ArrayList<Object>();
        if (r.get("code").toString().equals("0")) {
            organizationList = (List<Map<String, Object>>) r.get("data");
            for (Iterator<Map<String, Object>> iterator = organizationList.iterator(); iterator.hasNext(); ) {
                Map<String, Object> map1 =  iterator.next();
                li.add(map1.get("orgId"));
            }
            params.put("orgId", li);
        }

        List<Map<String, Object>> list = studentFeignClient.getSemesterList(params);
        return R.list(list);
    }


    @RequestMapping(value = "/student/queryList")
    public List<Map<String, Object>> queryList(@RequestParam Map<String, Object> map, HttpSession session) {
        String tenantId = (String) session.getAttribute("tenantId");
        String orgId = (String) session.getAttribute("orgId");
        map.put("tenantId", tenantId);
        if (map.get("orgId") == null || "".equals(map.get("orgId"))) {
            map.put("orgId", orgId);
        }
        List<Map<String, Object>> list = studentFeignClient.queryList(map);
        return R.list(list);
    }


    @RequestMapping(value = "/grade/getGrade")
    public List<Map<String, Object>> getGrade(@RequestParam(value = "orgId", required = false) String orgId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orgId", orgId);
        return studentFeignClient.getGradesByOrgId(map);
    }

    @RequestMapping(value = "/grade/getGradesByOrgId")
    public R getGradesByOrgId(@RequestParam(value = "orgId", required = false) String orgId, HttpSession session) {
        String tenantId = (String) session.getAttribute("tenantId");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tenantId", tenantId);
        map.put("orgId", orgId);

        List<Map<String, Object>> list = studentFeignClient.getGradesByOrgId(map);
        return R.ok(list);
    }

    @RequestMapping(value = "/clazz/getClazzsByGradeId")
    public R getClazzsByGradeId(@RequestParam(value = "gradeId", required = false) String gradeId, HttpSession session) {
        String tenantId = (String) session.getAttribute("tenantId");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gradeId", gradeId);
        map.put("tenantId", tenantId);
        List<Map<String, Object>> list = studentFeignClient.getClazzsByGradeId(map);
        return R.ok(list);
    }


}