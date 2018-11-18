package com.zakj.auth.dao;

import com.zakj.auth.entity.Organization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * ClassName：EmployeeRoleDao
 * Description：员工角色
 *
 * @author ryh
 * @date 2018/6/28 11:06
 **/
@Mapper
public interface EmployeeRoleDao {

    List<Map<String, Object>> getRoleCheckByUserId(Map<String, Object> params) ;
    List<Map<String, Object>> getManyRoleCheckByUserId(Map<String, Object> params);
    List<Map<String, Object>> getAllRoleByTenId(Map<String, Object> params);
    List<Map<String, Object>> getUserLoginRole(Map<String, Object> params);
    void saveUserRoleAuth(List<Map<String, Object>> params);
    void deleteUserRoleAuthByUserId(Map<String, Object> params);
    void saveUserRoleManyAuth(List<Map<String, Object>> params);
    void deleteUserRoleManyAuthByUserId(List<Map<String, Object>> params);
}