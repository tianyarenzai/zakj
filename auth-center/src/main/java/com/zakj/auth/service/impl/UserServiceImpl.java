package com.zakj.auth.service.impl;

import com.zakj.auth.dao.UserDao;
import com.zakj.auth.entity.User;
import com.zakj.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * ClassName：UserServiceImpl
 * Description：用户服务实现类
 *
 * @author ryh
 * @date 2018/6/19 11:55
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(Map<String, Object> params) {
        return (User) userDao.getUserByCondition(params);
    }

    @Override
    public void updateLoginDate(Map<String, Object> params) {
        userDao.updateLoginDate(params);
    }

    /**
     * 获取学生账号
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> getUserList(String[] userId) {
        return  userDao.getUserList(userId);
    }

    @Override
    public void generateAccount(Map<String, Object> params) {
        userDao.generateAccount(params);
    }

    @Override
    public String getMaxAccount(String accountPrefix) {
        return userDao.getMaxAccount(accountPrefix);
    }

    @Override
    public Integer checkLogin(String userLogin) {
        return userDao.checkLogin(userLogin);
    }
}