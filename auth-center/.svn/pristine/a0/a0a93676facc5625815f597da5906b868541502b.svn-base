package com.zakj.auth.service;

import com.zakj.auth.entity.Organization;

import java.util.List;
import java.util.Map;

/**
 * ClassName：OrganizationService
 * Description：
 *
 * @author ryh
 * @date 2018/5/19 16:33
 **/
public interface OrganizationService {
    Organization queryObject(String orgId);

    List<Map<String, Object>> queryList(Map<String, Object> map);

    long queryTotal(Map<String, Object> map);

    void save(Organization asdOrganization);

    void update(Organization asdOrganization);

    void delete(String orgId);

    void deleteBatch(String[] orgIds);

    /**
     * 获取组织机构数据权限
     * @param params
     * @return
     */
    List<Map<String,Object>> getTreeListByOrgIds(Map<String, Object> params);


    /**
     * 通过学校id获取学校
     * @param params
     * @return
     */
    Map<String,Object> getOrganizationByOrgId(Map<String, Object> params);



    /**
     * 获取部门
     * @param params
     * @return
     */
    List<Map<String,Object>> getDepts(Map<String, Object> params);


    /**
     * 获取人员的权限信息
     * @param map
     * @userId:用户ID
     * @tenantId：企业ID
     * @return
     */
    List<Map<String, Object>> getDataAuthByUserId(Map<String, Object> map);

    /**
     * 根据企业id获取组织信息
     * @param tenantId
     * @return
     */
    List<Map<String,Object>> getOrganizationByTenantId(Map<String, Object> tenantId);


    List<Map<String,Object>> getOrgTree(Map<String, Object> params);
    /**
     * 获取部门和机构
     * @param params
     * orgId
     * @return
     */
    List<Map<String,Object>> getOrganizationDept(Map<String, Object> params);


    /**
     * 根据orgId获取OrgName
     * @param orgId
     * @return
     */
    String getOrgNameById(Map<String, Object> orgId);

     Map<String, Object>  getDingtalk(Map<String, Object> params);

    /**
     * 获取数据权限
     * @param params
     *   orgId 学校id
     * @return
     */
    List<Map<String,Object>> getOrgName(Map<String, Object> params);

    /**
     * 根据学校ID获取该学校下所有部门
     * @param params
     * orgId 学校id
     * @return
     */
    List<Map<String,Object>> getOrganizationAllDept(Map<String, Object> params);

    /**
     * 根据orgId获取OrgCode
     *
     * @param orgId orgId 学校id
     * @return
     */
    Map<String, Object> getOrgCode(String orgId);

    /**
     * 根据学校ID和密码验证
     *
     * @param params orgId 学校id
     *               orgPwd 学校验证密码
     * @return
     */
    String padInstallVali(Map<String, Object> params);
}