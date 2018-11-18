package com.zakj.auth.service.impl;

import com.zakj.auth.dao.OrganizationDao;
import com.zakj.auth.entity.Organization;
import com.zakj.auth.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
/**
 * ClassName：OrganizationServiceImpl
 * Description：
 *
 * @author ryh
 * @date 2018/5/19 16:34
 **/
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public Organization queryObject(String orgId){
        return organizationDao.queryObject(orgId);
    }

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map){
        return organizationDao.queryList(map);
    }

    @Override
    public long queryTotal(Map<String, Object> map){
        return organizationDao.queryTotal(map);
    }

    @Override
    public void save(Organization asdOrganization){
        organizationDao.save(asdOrganization);
    }

    @Override
    public void update(Organization asdOrganization){
        organizationDao.update(asdOrganization);
    }

    @Override
    public void delete(String orgId){
        organizationDao.delete(orgId);
    }

    @Override
    public void deleteBatch(String[] orgIds){
        organizationDao.deleteBatch(orgIds);
    }

    @Override
    public List<Map<String, Object>> getTreeListByOrgIds(Map<String, Object> params) {
       return organizationDao.getTreeListByOrgIds(params);
    }

    /**
     * 通过学校id获取学校
     * @param params
     * @return
     */
    @Override
    public Map<String,Object> getOrganizationByOrgId(Map<String, Object> params) {
        return organizationDao.getOrganizationByOrgId(params);
    }

    @Override
    public List<Map<String, Object>> getDepts(Map<String, Object> params) {
        return organizationDao.getDepts(params);
    }

    @Override
    public List<Map<String, Object>> getDataAuthByUserId(Map<String, Object> params) {
        return organizationDao.getDataAuthByUserId(params);
    }

    @Override
    public List<Map<String, Object>> getOrganizationByTenantId(Map<String, Object> params) {
        return organizationDao.getOrganizationByTenantId(params);
    }

    @Override
    public List<Map<String, Object>> getOrgTree(Map<String, Object> params) {
        return organizationDao.getOrgTree(params);
    }
    /**
     * 获取部门和机构
     * @param params
     * orgId
     * @return
     */
    @Override
    public List<Map<String, Object>> getOrganizationDept(Map<String, Object> params) {
        return organizationDao.getOrganizationDept(params);
    }


    @Override
    public String getOrgNameById(Map<String, Object> orgId) {
        return organizationDao.getOrgNameById(orgId);
    }

    @Override
    public Map<String,Object> getDingtalk(Map<String, Object> params) {
        return organizationDao.getDingtalk(params);
    }
    /**
     * 获取数据权限
     * @param params
     *   orgId 学校id
     * @return
     */
    @Override
    public List<Map<String, Object>> getOrgName(Map<String, Object> params) {
        return organizationDao.getOrgName(params);
    }

    @Override
    public List<Map<String, Object>> getOrganizationAllDept(Map<String, Object> params) {
        return organizationDao.getOrganizationAllDept(params);
    }

    @Override
    public Map<String, Object> getOrgCode(String orgId) {
        return organizationDao.getOrgCode(orgId);
    }

    @Override
    public String padInstallVali(Map<String, Object> params) {
        return organizationDao.padInstallVali(params);
    }


}