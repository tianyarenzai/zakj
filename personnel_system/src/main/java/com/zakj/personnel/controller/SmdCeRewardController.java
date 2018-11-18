package com.zakj.personnel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zakj.client.OrganizationFeignClient;
import com.zakj.personnel.entity.SmdCeRewardEntity;
import com.zakj.personnel.service.SmdCeRewardService;
import com.zakj.security.aspect.SysLog;
import com.zakj.security.common.beans.AjaxListResult;
import com.zakj.security.controller.BaseController;

import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * InnoDB free: 12288 kB
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-14 17:01:30
 */
@RestController
@RequestMapping("/employee/reward")
public class SmdCeRewardController extends BaseController {

    @Autowired
    private SmdCeRewardService smdCeRewardService;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    /**
     * 获取奖惩信息列表
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public R list(HttpServletRequest request, HttpSession session) {
        List<Object> li =new ArrayList<Object>();
        List<Map<String, Object>> organizationList = new ArrayList<Map<String, Object>>();

        Map<String, Object> params = this.getRequestParams(request);
        try {
            String userId = (String) session.getAttribute("userId");
            params.put("userId", userId);
            String orgId = (String) session.getAttribute("orgId");

            String type = params.get("type").toString();
            params.put("userId", userId);
            params.put("orgId", orgId);
            if (type.equals("0")) {
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
                li.add(orgId);
                params.put("orgId",li);
            }
            List<Map<String, Object>> list = smdCeRewardService.queryList(params);

            int i =smdCeRewardService.queryTotal(params);
            return R.ok(list,i);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }

    }


    /**
     * 进入新增页面
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        mav.setViewName("employee/addReward");
        return mav;
    }


    /**
     * 保存奖惩信息
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @SysLog("保存奖惩信息")
    @RequestMapping("save")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> save(HttpServletRequest request, HttpSession session) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String data = map.get("data").toString();
           /* JSONObject obj = JSONObject.parseObject(data);
            SmdCeRewardEntity entity = (SmdCeRewardEntity)
                    JSONObject.toBean(obj, SmdCeRewardEntity.class);*/
            SmdCeRewardEntity entity = JSON.parseObject(data, new TypeReference<SmdCeRewardEntity>() {});

            String employeeId = (String) session.getAttribute("employeeId");
            String employeeName = (String) session.getAttribute("employeeName");
            entity.setCreateEmpName(employeeName);
            String userId = (String) session.getAttribute("userId");
            entity.setCreateUser(userId);
            entity.setCreateDate(new Date());
            entity.setState(0);

            this.smdCeRewardService.save(entity);
            result.setCode(0);
            result.setMsg("操作成功！");
        } catch (Exception e) {
            result.setCode(101);
            result.setMsg("发生未知异常： " + e.getMessage());
        }
        return result;
    }


    /**
     * 删除奖惩信息
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SysLog("删除奖惩信息")
    @RequestMapping("delete")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String rewardId = map.get("rewardId").toString();
            this.smdCeRewardService.delete(rewardId);
            result.setCode(0);
            result.setMsg("操作成功!");
        } catch (Exception e) {
            result.setCode(101);
            result.setMsg("发生未知异常: " + e.getMessage());
        }
        return result;
    }


    /**
     * 进入编辑页面
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        String rewardId = map.get("rewardId").toString();
        SmdCeRewardEntity entity = this.smdCeRewardService.queryObject(rewardId);
        mav.addObject("reward", entity);
        mav.setViewName("employee/editReward");
        return mav;
    }

    /**
     * 编辑保存奖惩信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SysLog("编辑保存奖惩信息")
    @RequestMapping("update")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String data = map.get("data").toString();
          /*  JSONObject obj = JSONObject.fromObject(data);
            SmdCeRewardEntity entity = (SmdCeRewardEntity) JSONObject.toBean(obj, SmdCeRewardEntity.class);*/
            SmdCeRewardEntity entity = JSON.parseObject(data, new TypeReference<SmdCeRewardEntity>() {});
            entity.setUpdateTime(new Date());
            this.smdCeRewardService.update(entity);
            result.setCode(0);
            result.setMsg("操作成功！");
        } catch (Exception e) {
            result.setCode(101);
            result.setMsg("发生未知异常： " + e.getMessage());
        }
        return result;
    }

}
