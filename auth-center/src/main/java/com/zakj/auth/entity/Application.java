package com.zakj.auth.entity;

/**
 * ClassName：Application
 * Description：应用实体类
 *
 * @author ryh
 * @date 2018/6/19 10:53
 **/
public class Application  implements java.io.Serializable {
    private String applicationId;
    private String applicationName;
    private String applicationUrl;
    private String applicationParentId;
    private String applicationType;
    private String applicationIcon;
    private Integer orderNum;
    private String remark;
    private String applicationKhdType;
    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public String getApplicationParentId() {
        return applicationParentId;
    }

    public void setApplicationParentId(String applicationParentId) {
        this.applicationParentId = applicationParentId;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicationIcon() {
        return applicationIcon;
    }

    public void setApplicationIcon(String applicationIcon) {
        this.applicationIcon = applicationIcon;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApplicationKhdType() {
        return applicationKhdType;
    }

    public void setApplicationKhdType(String applicationKhdType) {
        this.applicationKhdType = applicationKhdType;
    }


}