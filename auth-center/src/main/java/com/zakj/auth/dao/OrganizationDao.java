package com.zakj.auth.dao;

import com.zakj.auth.entity.Organization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
/**
 * Created by 0ops on 2018/5/19.
 */
@Mapper
public interface OrganizationDao extends BaseDao<Organization>  {

    List<Map<String, Object>> getTreeListByOrgIds(Map<String, Object> params);

    /**
     * 通过学校id获取学校
     * @param params
     * @return
     */
   Map<String,Object> getOrganizationByOrgId(Map<String, Object> params);

    /**
     * 获取部门信息
     * @param params
     * @param params
     * @return
     */
    List<Map<String,Object>> getDepts(Map<String, Object> params);

    /**
     * 获取人员的权限信息
     * @param employeeId
     * @return
     */
    List<Map<String, Object>> getDataAuthByUserId(Map<String, Object> employeeId);

    /**
     * 根据企业id获取组织信息
     * @param params
     * @return
     */
    List<Map<String,Object>> getOrganizationByTenantId(Map<String, Object> params);


    /**
     * 获取组织机构树
     * @param params
     * @return
     */
    List<Map<String,Object>> getOrgTree(Map<String, Object> params);

    /**
     * 根据orgId获取OrgName
     * @param orgId
     * @return
     */
    String getOrgNameById(Map<String, Object> orgId);
    /**
     * 获取部门和机构
     * @param params
     * orgId
     * @return
     */
    List<Map<String,Object>> getOrganizationDept(Map<String, Object> params);

    /**
     * 获取钉钉token
     * @return
     */
    Map<String,Object> getDingtalk(Map<String, Object> params);
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
