package com.zakj.auth.entity;

import java.io.Serializable;

/**
 * ClassName：DataAuth
 * Description：数据权限实体类
 *
 * @author ryh
 * @date 2018/6/8 14:46
 **/
public class DataAuth implements Serializable {


    /**
     *数据权限ID
     */
    private String dataPowerId;
    /**
     *授权学校
     */
    private String dataOrgId;
    /**
     *职工组织机构
     */
    private String orgId;
    /**
     *职工ID
     */
    private String empId;
    /**
     *租户ID
     */
    private String tenantId;

    public String getDataPowerId() {
        return dataPowerId;
    }

    public void setDataPowerId(String dataPowerId) {
        this.dataPowerId = dataPowerId;
    }

    public String getDataOrgId() {
        return dataOrgId;
    }

    public void setDataOrgId(String dataOrgId) {
        this.dataOrgId = dataOrgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}