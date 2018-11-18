package com.zakj.personnel.controller;

import com.zakj.client.OrganizationFeignClient;
import com.zakj.personnel.entity.SmdSsSchoolSubjectEntity;
import com.zakj.personnel.service.SmdSsSchoolSubjectService;
import com.zakj.utils.Query;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-19 11:24:11
 */
@RestController
@RequestMapping("/employee/schoolsubject")
public class SmdSsSchoolSubjectController {
    @Autowired
    private SmdSsSchoolSubjectService smdSsSchoolSubjectService;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpSession session) {
        String tenantId = (String) session.getAttribute("tenantId");
        String orgId = (String) session.getAttribute("orgId");
        params.put("tenantId", tenantId);
        params.put("orgId", orgId);
        //查询列表数据
        Query query = new Query(params);
        List<Map<String, Object>> smdSsSchoolSubjectList = smdSsSchoolSubjectService.queryList(query);
        int total = smdSsSchoolSubjectService.queryTotal(query);
        return R.ok(smdSsSchoolSubjectList, total);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schoolSubjectId}")
    public R info(@PathVariable("schoolSubjectId") String schoolSubjectId) {
        SmdSsSchoolSubjectEntity smdSsSchoolSubject = smdSsSchoolSubjectService.queryObject(schoolSubjectId);

        return R.ok().put("smdSsSchoolSubject", smdSsSchoolSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestParam Map<String, Object> params, HttpSession session) {
        String tenantId = (String) session.getAttribute("tenantId");
        String orgId = (String) session.getAttribute("orgId");
        SmdSsSchoolSubjectEntity smdSsSchoolSubject = new SmdSsSchoolSubjectEntity();
        smdSsSchoolSubject.setSubjectId(params.get("subject_id").toString());
        smdSsSchoolSubject.setOrgId(orgId);
        smdSsSchoolSubject.setTenantId(tenantId);
        smdSsSchoolSubjectService.save(smdSsSchoolSubject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmdSsSchoolSubjectEntity smdSsSchoolSubject) {
        smdSsSchoolSubjectService.update(smdSsSchoolSubject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestParam Map<String, Object> params) {
        String[] schoolSubjectIds = params.get("schoolSubjectId").toString().split(",");
        smdSsSchoolSubjectService.deleteBatch(schoolSubjectIds);
        return R.ok();
    }


    /**
     * 获取学科
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/getSchoolSubjects")
    public R getSchoolSubjects(HttpSession session) {
        String orgId = (String) session.getAttribute("orgId").toString();
        List<Map<String, Object>> list = smdSsSchoolSubjectService.getSchoolSubjects(orgId);
        return R.ok(list);
    }

    /**
     * 获取职工所在学校的学科
     * @param orgId
     * @return
     */
    @RequestMapping(value = "getSchoolSubjectsByEmpOrgId")
    public R getSchoolSubjectsByEmpOrgId(@RequestParam String orgId) {
        List<Map<String, Object>> list = smdSsSchoolSubjectService.getSchoolSubjects(orgId);
        return R.ok(list);
    }
}
