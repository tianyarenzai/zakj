package com.zakj.auth.service;

import com.zakj.auth.entity.User;
import com.zakj.utils.R;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by 0ops on 2018/6/19.
 */
public interface UserService {
    /**
     * 用户登录
     * @param params
     * @return
     */
    User login(Map<String, Object> params);

    /**
     * 更新用户最后登录时间和登录次数
     * @param params
     * lastLoginDate  最后登录时间
     * total 登录次数
     * userId 用户ID
     */
    void updateLoginDate(Map<String, Object> params);

    /**
     * 获取学生账号
     * @param userId
     * @return
     */
    List<Map<String,Object>> getUserList(String[] userId);

    /**
     * 生成用户账号新信息
     * @param params
     * userLogin： 登录号账号（手机号）
     * userPwd：用户密码
     * userName：用户名
     * userSex：性别
     * userIdcar：身份证
     * terminal：终端
     * userRole：用户角色
     * createTime：注册时间
     * tenantId：企业id
     */
    void generateAccount(Map<String, Object> params);

    /**
     * 获取账号中最大值
     *
     * @param accountPrefix （模糊查询账号）前缀
     * @return
     */
    String getMaxAccount(String accountPrefix);


    /**
     * 检查账号是否存在
     *
     * @param userLogin 账号
     * @return
     */
    Integer checkLogin(String userLogin);
}
