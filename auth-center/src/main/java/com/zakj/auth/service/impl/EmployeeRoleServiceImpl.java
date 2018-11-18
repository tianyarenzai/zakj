package com.zakj.auth.service.impl;

import com.zakj.auth.dao.EmployeeRoleDao;
import com.zakj.auth.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * ClassName：EmployeeRoleServiceImpl
 * Description：
 *
 * @author ryh
 * @date 2018/6/28 10:49
 **/
@Service("employeeRoleService")
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    private EmployeeRoleDao employeeRoleDao;
    @Override
    public List<Map<String, Object>> getRoleCheckByUserId(Map<String, Object> params) {
        return employeeRoleDao.getRoleCheckByUserId(params);
    }

    @Override
    public  List<Map<String, Object>> getManyRoleCheckByUserId(Map<String, Object> params) {
        return employeeRoleDao.getManyRoleCheckByUserId(params);
    }

    @Override
    public  List<Map<String, Object>> getUserLoginRole(Map<String, Object> params) {
        return employeeRoleDao.getUserLoginRole(params);
    }

    @Override
    public List<Map<String, Object>> getAllRoleByTenId(Map<String, Object> params) {
        return employeeRoleDao.getAllRoleByTenId(params);
    }

    @Override
    public void saveUserRoleAuth(Map<String, Object> params) {
        String[] userId = params.get("userIds").toString().split(",");
        String[] roleId =  params.get("roleIds").toString().split(",");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (String user:userId){
            for (String role:roleId){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userRoleId", UUID.randomUUID().toString().replace("-", ""));
                map.put("userId",user);
                map.put("roleId",role);
                list.add(map);
            }
        }
        employeeRoleDao.saveUserRoleAuth(list);
    }

    @Override
    public void deleteUserRoleAuthByUserId(Map<String, Object> params) {

        employeeRoleDao.deleteUserRoleAuthByUserId(params);
    }

    @Override
    public void saveUserRoleManyAuth(Map<String, Object> params) {
        String[] userId = params.get("userIds").toString().split(",");
        String[] roleId =  params.get("roleIds").toString().split(",");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (String user:userId){
            for (String role:roleId){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userRoleId", UUID.randomUUID().toString().replace("-", ""));
                map.put("userId",user);
                map.put("roleId",role);
                list.add(map);
            }
        }
        employeeRoleDao.saveUserRoleManyAuth(list);
    }

    @Override
    public void deleteUserRoleManyAuthByUserId(Map<String, Object> params) {
        String[] userId = params.get("userIds").toString().split(",");
        String[] roleId =  params.get("roleIds").toString().split(",");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            for (String user:userId){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userId",user);
                list.add(map);
            }

        employeeRoleDao.deleteUserRoleManyAuthByUserId(list);
    }
}