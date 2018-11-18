package com.zakj.auth.controller;

import com.zakj.auth.service.OrganizationService;
import com.zakj.auth.service.UserService;
import com.zakj.utils.JsonTools;
import com.zakj.utils.MD5;
import com.zakj.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${server.port}")
    String serverPort;

    @Autowired
    private UserService userService;
    @Autowired
    private OrganizationService organizationService;
    @RequestMapping(value = "/getUserList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getUserList(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> list = null;
        if (params.get("userId")==null){
            return R.ok("用户id不能为空");
        }
        String [] userId=params.get("userId").toString().split(",");
        list=userService.getUserList(userId);
        return R.ok(list);
    }

    /**
     * 生成用户账号新信息
     * @param params
     * userLogin： 登录号账号（手机号）
     * userPwd：用户密码(MD5加密后的密码)
     * userName：用户名
     * userSex：性别
     * userIdcar：身份证
     * userRole：用户角色
     * createTime：注册时间
     * tenantId：企业id
     * orgId:  组织机构ID
     * userId:用户ID（调用者生成UUID）
     * loginType:账号类型，0：教师账号；1：学生账号
     * @return
     */
    @RequestMapping(value = "/generateAccount", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R generateAccount(@RequestParam Map<String, Object> params) {

        List<Map<String, Object>> list = JsonTools.parseJSON2List(params.get("data").toString());
        List<Map<String, Object>> errlist = new ArrayList<>();
        if (list.size() < 1) {
            return R.ok("未传入账号信息");
        }
        Map<String, Object> dataMap = null;
        for (Map<String, Object> map : list) {
            dataMap = new HashMap<String, Object>();

            map.put("createTime", new Date());
            String userPwd = "";
            if (map.get("userPwd") == null || map.get("userPwd").toString().equals("")) {
                userPwd = MD5.MD5Encode("123456");
            } else {
                userPwd = map.get("userPwd").toString();
            }
            map.put("userPwd", userPwd);
            String userId = "";
            if (map.get("userId") == null || map.get("userId").toString().equals("")) {
                userId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            } else {
                userId = map.get("userId").toString();
            }
            map.put("userId", userId);
            /**
             *  如果参数loginType不传或传0时，表示以手机号生成教师或家长账号；否则按规则自动生成学生账号
             */

            if (params.get("loginType") != null && params.get("loginType").toString().equals("1")) {
                if (!autoStudentAccount(map.get("orgId").toString()).equals("0")) {
                    map.put("userLogin", autoStudentAccount(map.get("orgId").toString()));
                    userService.generateAccount(map);
                } else {
                    errlist.add(map);
                }

            }else{
                if (userService.checkLogin(map.get("userLogin").toString()) < 1) {
                    userService.generateAccount(map);
                }else {
                    errlist.add(map);
                }
            }

        }
        String msg = params.get("loginType").equals("0") ? "个教师账号生成成功" : "个学生账号生成成功";
        Map<String, Object> result = new HashMap<>();
        result.put("repeatAccount",errlist);
        result.put("msg", list.size() - errlist.size() + msg);
        return R.ok(result);
    }



    /**
     * 自动生成学生账号
     * 账号生成规则：1+学段序号（0-5）+三位学校编码 + 二位年份（18年）+四位自增自然数（0001）=11位账号，12102180001
     * @param orgId 学校ID
     * @return
     */
    private String autoStudentAccount(String orgId) {
        String account = "";
        Map<String, Object> omap = organizationService.getOrgCode(orgId);
        String year = new SimpleDateFormat("yy").format(new Date());

        String accountPrefix = "1" + omap.get("xdXh").toString() + omap.get("orgCode").toString() + year;
        account = userService.getMaxAccount(accountPrefix);
        if (account == null) {
            account = accountPrefix + "0001";
        } else {
            if (account.length() == 11) {
                account = String.valueOf(Long.valueOf(account) + 1);
            } else {
                account = "0";
                logger.debug("------------------【" + account + "】学生账号生成错误");
            }
        }
        return account;
    }


    /**
     * 家长APP账号注册
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R register(@RequestParam Map<String, Object> params) {

        if (userService.checkLogin(params.get("userLogin").toString()) < 1) {
            String userId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("userLogin", params.get("userLogin"));
            map.put("userPwd", params.get("userPwd"));
            map.put("userRole", "2");

            userService.generateAccount(map);
            return R.ok(200, "注册成功");
        } else {
            return R.ok(400, "该账号已存在，请更换其他账号注册");
        }


    }
}
