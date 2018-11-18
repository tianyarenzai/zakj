package com.zakj.auth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zakj.auth.entity.User;
import com.zakj.auth.service.ApplicationService;
import com.zakj.auth.service.DataAuthService;
import com.zakj.auth.service.OrganizationService;
import com.zakj.auth.service.UserService;
import com.zakj.client.BasicDataFeignClient;
import com.zakj.utils.GradeTools;
import com.zakj.utils.MD5;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * ClassName：AuthController
 * Description： 权限控制器
 *
 * @author ryh
 * @date 2018/6/8 14:38
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private DataAuthService dataAuthService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private UserService userService;

    @Autowired
    private BasicDataFeignClient basicDataFeignClient;
    @Value("${server.port}")
    String serverPort;

    /**
     * 根据职工ID获取数据访问权限
     * empId:员工ID
     * tenantId：企业ID
     */
   /* @RequestMapping(value = "/getDataAuthTreeByEmpId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Map<String, Object>> getDataAuthTreeByEmpId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = null;
        if(params.size()>0) {
            params.put("current_port", serverPort);
            // 获取人员的权限信息
            list = organizationService.getDataAuthByEmpId(params);
            return list;
        }
        return list;
    }*/




    /**
     * 根据职工ID获取数据访问权限或者根据组织机构id获取机构和部门
     * userId:用户ID
     * tenantId：企业ID
     */
    @RequestMapping(value = "/getDataAuthTreeByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getDataAuthTreeByUserId(@RequestParam Map<String, Object> params) {
        try {
            if (params.get("tenantId") == null) {
                return R.ok("企业id不能为空");
            }
            if (params.get("userId") == null) {
                return R.ok("用户id不能为空");
            }
            if (params.get("orgId") == null) {
                return R.ok("学校id不能为空");
            }

            // 获取人员的权限信息
            List<Map<String, Object>> list = organizationService.getDataAuthByUserId(params);
            if (list.size() > 0) {
                return R.ok(0, "操作成功!").put("data", list);
            } else {
                List<Map<String, Object>> list1 = organizationService.getOrganizationDept(params);
                return R.ok(0, "操作成功!").put("data",list1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }


    }


    /**
     * 根据租户ID获取组织机构列表
     *
     * @param params tenantId：企业ID
     * @return
     */
    @RequestMapping(value = "/getOrgListByTenId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Map<String, Object>> getOrgListByTenId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = null;
        if (params.size() > 0) {
            //查询列表数据
            params.put("current_port", serverPort);
            list = organizationService.queryList(params);
        }
        return R.list(list);
    }


    /**
     * 获取部门
     *
     * @param params orgId: 组织机构ID
     * @return
     */
    @RequestMapping(value = "/getOrganizationByOrgId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getOrganizationByOrgId(@RequestParam Map<String, Object> params) {
        //查询列表数据
        if (params.size() > 0) {
            params.put("current_port", serverPort);
            Map<String, Object> map = organizationService.getOrganizationByOrgId(params);

            return R.ok(map);
        } else {
            return R.error("未传入任何参数！");
        }

    }

    /**
     * 获取部门
     *
     * @param params userID: 用户ID
     * @return
     */
    @RequestMapping(value = "/getStudentUserByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getStudentUserByUserId(@RequestParam Map<String, Object> params) {
        if (params.size() > 0) {
            //查询列表数据
            params.put("current_port", serverPort);
            Map<String, Object> map = dataAuthService.getStudentUserByUserId(params);
            if (map != null) {
                return R.ok(map);
            } else {
                return R.ok(0, "未授权");
            }

        } else {
            return R.error("未传入任何参数！");
        }
    }


    /**
     * 获取部门
     *
     * @param params orgId: 组织机构ID
     * @return
     */
    @RequestMapping(value = "/getDeptsByOrgId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Map<String, Object>> getDeptsByOrgId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = null;
        if (params.size() > 0) {
            params.put("current_port", serverPort);
            list = organizationService.getDepts(params);
        }
        return R.list(list);
    }


    /**
     * 根据企业id获取组织信息
     * tenantId：企业ID
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/getOrganizationByTenantId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Map<String, Object>> getOrganizationByTenantId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = null;
        if (params.size() > 0) {
            params.put("current_port", serverPort);
            list = organizationService.getOrganizationByTenantId(params);
        }
        return R.list(list);
    }

    @RequestMapping(value = "/getOrganizationListByTenId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getOrganizationListByTenId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = null;

        list = organizationService.queryList(params);

        return R.ok(list);
    }

    /**
     * APP根据企业id获取组织信息
     * tenantId：企业ID
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/getOrganization", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getOrganization(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(0);
        try {
          /*if(params.get("tenantId")==null) {
              return R.ok("企业id不能为空");

          }*/
            list = organizationService.getOrganizationByTenantId(params);
            return R.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }


    /**
     * 根据orgId获取orgName
     *
     * @param orgId
     * @return
     */
    @RequestMapping(value = "/getOrgNameById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getOrgNameById(@RequestParam Map<String, Object> orgId) {
        String orgName = organizationService.getOrgNameById(orgId);
        return orgName;
    }


    /**
     * 根据用户ID获取访问权限
     *
     * @param params userId：用户ID
     *               parentId：应用模块父ID
     *               moduleType：应用模块类型
     * @return
     */
    @RequestMapping(value = "/getAuthByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Map<String, Object>> getAuthByUserId(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = null;
        if (params.size() > 0) {
            list = applicationService.getAuthByUserId(params);
        }
        return R.list(list);
    }


    /**
     * 获取部门和机构
     *
     * @param params orgId
     * @return
     */

    @RequestMapping(value = "/getOrganizationDept", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getOrganizationDept(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = null;
        try {
            if (params.get("orgId") == null) {
                return R.ok("机构id不能为空");
            }
            list = organizationService.getOrganizationDept(params);

            return R.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * 登陆入口（APP、Pad）
     *
     * @param params loginName:登录账号（测试账号： APP:13686183541；pad:523000100012510321；）
     *               userPwd:密码；（测试密码；APP：123；Pad：123456）
     *               terminal：终端（1：PC，2:APP，3：小程序,4:pad,5:教师客户端）；
     *               moduleType：级别（1：模块，2、应用，3：菜单）；
     *               parentId：模块父ID；
     *               userRole:用户访问角色：【0】游客；【1】教职工；【2】家长；【3】即使家长也是教职工；【4】学生；
     * @return
     */
    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R login(@RequestParam Map<String, Object> params) {
        try {
            if (StringUtils.isEmpty(params.get("userPwd")) || StringUtils.isEmpty(params.get("loginName"))) {
                return R.error(400, "用户名或者密码为空");
            } else {
                /** 密码MD5加密为防止访问路径被劫持而泄露,在前端进行密码MD5加密*/
                params.put("userPwd", MD5.MD5Encode(params.get("userPwd").toString()));
                User user = userService.login(params);
                if (user == null) {
                    return R.error(400, "用户名或者密码错误");
                } else {

                    Map<String, Object> map = new HashMap<String, Object>();
                    R userInfo = null;
                    Map<String, Object> org = null;
                    switch (Integer.parseInt(params.get("terminal").toString())) {
                        case 1:
                            break;
                        case 2:
                            params.put("userId", user.getUserId());
                            switch (Integer.parseInt(params.get("userRole").toString())) {
                                case 1:
                                    userInfo = basicDataFeignClient.getEmployeeInfoByUserId(params);
                                    break;
                                case 2:
                                    userInfo = basicDataFeignClient.queryStudentByUserId(params);
                                    map.put("userId", user.getUserId());
                                    map.put("userName", "");
                                    map.put("sex", "");
                                    map.put("phone", "");
                                    break;
                                default:
                                    break;
                            }
                            List<Map<String, Object>> list = getAuthByUserId(params);
                            map.put("userInfo", userInfo);
                            map.put("auth", list);
                            map.put("userRole", params.get("userRole"));
                            break;
                        case 3:
                            break;
                        case 4:
                            map.put("userId", user.getUserId());
                            userInfo = basicDataFeignClient.getStudentByUserId(map);
                            map.put("orgId", userInfo.get("orgId"));
                            org = organizationService.getOrganizationByOrgId(map);
                            map.put("studentId", userInfo.get("studentId"));
                            map.put("sysClazzName", userInfo.get("sysClazzName"));
                            map.put("studentName", userInfo.get("studentName"));
                            map.put("gradeYearName", userInfo.get("gradeYearName"));
                            map.put("orgName", org.get("orgName"));
                            break;
                        case 5:
                            params.put("userId", user.getUserId());
                            userInfo = basicDataFeignClient.getEmployeeInfoByUserId(params);
                            map.put("orgId", userInfo.get("orgId"));
                            org = organizationService.getOrganizationByOrgId(map);
                            int schoolNumber = Integer.parseInt(org.get("schoolNumber").toString());

                            List<Map<String, Object>> clist = (List<Map<String, Object>>) userInfo.get("class");
                            for (Map<String, Object> objMap : clist) {
                                String year = objMap.get("gradeYearName").toString().substring(0, 4);
                                String grade = GradeTools.getGrade(schoolNumber, year, org.get("xdName").toString());
                                objMap.put("gradeName", grade);
                            }
                            map.put("empInfo", userInfo);
                            map.put("orgName", org.get("orgName"));
                            break;
                        default:
                            break;
                    }
                    if (userInfo.get("code").equals(0)) {
                        map.put("code", 0);
                        map.put("msg", "登录成功");
                        map.put("token", UUID.randomUUID().toString());

                        /**更新用户登录次数和最后登录时间**/
                        Map<String, Object> userMap = new HashMap<String, Object>();
                        userMap.put("userId", user.getUserId());
                        userMap.put("lastLoginDate", new Date());
                        userMap.put("total", user.getTotal() + 1);
                        userService.updateLoginDate(userMap);
                        return R.ok(map);
                    } else {
                        if (params.get("userRole") != null) {
                            return R.error(400, "角色选择错误");
                        } else {
                            return R.error(400, "登录失败");
                        }

                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @RequestMapping(value = "/getDingtalk", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getDingtalk(@RequestParam Map<String, Object> params) {
        try {
            if (params.get("tenantId") == null) {
                return R.ok("企业id不能为空");
            }
            Map<String, Object> map = this.organizationService.getDingtalk(params);
            return R.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * 获取数据权限
     *
     * @param params
     * @return
     */

    @RequestMapping(value = "/queryDataAuth", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R queryDataAuth(@RequestParam Map<String, Object> params) {
        try {
            if (params.get("userId") == null) {
                return R.ok("用户id不能为空");
            }
            List<Map<String, Object>> list = this.dataAuthService.queryDataAuth(params);
            return R.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * 获取数自己的机构信息
     *
     * @param params orgId 学校id
     * @return
     */
    @RequestMapping(value = "/getOrgName", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getOrgName(@RequestParam Map<String, Object> params) {
        try {
            if (params.get("orgId") == null) {
                return R.ok("学校id不能为空");
            }
            List<Map<String, Object>> list = this.organizationService.getOrgName(params);
            return R.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * 获取自己的组织机构或者数据权限
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryDataAuthOrganization", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R queryDataAuthOrganization(@RequestParam Map<String, Object> map) {
        try {

            if (map.get("userId") == null) {
                return R.ok("用户id不能为空");
            }
            if (map.get("orgId") == null) {
                return R.ok("学校id不能为空");
            }
            List<Map<String, Object>> list = this.dataAuthService.queryDataAuth(map);
            if (list.size() == 0) {
                List<Map<String, Object>> list1 = this.organizationService.getOrgName(map);
                return R.ok(list1);
            } else {
                return R.ok(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }

    }

    @RequestMapping(value = "/getDept", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getDept(@RequestParam Map<String, Object> params) {
        try {
            if (params.get("orgId") == null) {
                return R.ok("学校id不能为空");
            }
            List<Map<String, Object>> list = this.organizationService.getDepts(params);
            return R.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * 根据学校ID获取该学校下所有部门和部门下人员
     *
     * @param params orgId 学校id
     * @return
     */
    @RequestMapping(value = "/getAllDeptAndEmpByOrgId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getAllDeptAndEmpByOrgId(@RequestParam Map<String, Object> params) {
        try {
            if (params.get("orgId") == null) {
                return R.ok("学校id不能为空");
            }
            List<Map<String, Object>> list = this.organizationService.getOrganizationAllDept(params);

            for (Map<String, Object> map : list) {
                Map<String, Object> deptMap = new HashMap<>();
                deptMap.put("employeeDept", map.get("deptId"));
                deptMap.put("orgId", params.get("orgId"));
                R r = basicDataFeignClient.getDeptEmployeeList(deptMap);
                map.put("emp", r);
            }

            return R.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * 根据学校ID和密码验证
     *
     * @param params orgId 学校id
     *               orgPwd 学校验证密码
     * @return
     */
    @RequestMapping(value = "/pad/install/validation", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R padInstallVali(@RequestParam Map<String, Object> params) {
        String vali = organizationService.padInstallVali(params);
        if (vali != null && vali.equals("1")) {
            return R.ok(0, "验证密码成功");
        } else {
            return R.ok(1, "验证密码失败");
        }


    }
}