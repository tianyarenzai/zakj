package com.zakj.personnel.dao;

import com.zakj.personnel.entity.SmdEmployeeEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 6144 kB; (`user_id`) REFER `renren_fast/asd_user_account`(`user_id`
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-02-24 11:47:53
 */
@Mapper
public interface SmdEmployeeDao extends BaseDao<SmdEmployeeEntity> {

    /**
     * 删除职工操作
     *
     * @param employeeId
     */
    public void updateEmployeeState(String employeeId);

    /**
     * 获取所有职称
     *
     * @return
     */
    List<Map<String, Object>> getEmployeeTitles();

    /**
     * 获取岗位变更记录数
     *
     * @param map
     * @return
     */
    long getChangedJobsTotal(Map<String, Object> map);

    /**
     * 获取所有职务信息
     *
     * @return
     */
    List<Map<String, Object>> getEmployeeJobs();

    /**
     * 更新员工为正式员工
     *
     * @param employeeId
     */
    void updateEmpFormal(String employeeId);

    /**
     * 通过企业Id获取职务信息
     *
     * @param id
     * @return
     */
    List<Map<String, Object>> getEmployeeJobCombobox(String id);

    /**
     * 获取离职职工信息
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> getLeaveEmpList(Map<String, Object> map);

    /**
     * 获取离职职工信息的数量
     *
     * @param map
     * @return
     */
    int getLeaveEmpTotal(Map<String, Object> map);

    /**
     * 获取班主任及代课信息的总数
     *
     * @param map
     * @return
     */
    long getHeadTeacherTeachClazzTotal(Map<String, Object> map);


    /**
     * 获取班主任及代课信息列表
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> getHeadTeacherTeachClazzs(Map<String, Object> map);

    /**
     * 导出excel数据查询
     *
     * @param map
     * @return
     */
    List<Map<String, String>> getExportData(Map<String, Object> map);

    /**
     * 更新职工简历至smdEmployee
     *
     * @param entity
     */
    void updateResume(SmdEmployeeEntity entity);

    /**
     * 获取职工简历上传路径
     *
     * @param employeeId
     * @return
     */
    SmdEmployeeEntity getEmployeeResumeUrl(String employeeId);

    /**
     * 获取学校下的职务信息
     *
     * @param orgId
     * @param tenantId
     * @return
     */
    List<Map<String, Object>> getEmployeeJobByOrgId(@Param(value = "orgId") String orgId,
                                                    @Param(value = "tenantId") String tenantId);


    /**
     * 设置班主任
     *
     * @param entity
     */
    void setHeaderTeacher(SmdEmployeeEntity entity);

    /**
     * 查找该职工是否已是某班的班主任
     *
     * @param employeeId
     * @return
     */
    SmdEmployeeEntity isExitWhichClazz(String employeeId);


    /**
     * 是否存在职工
     *
     * @param employeeName
     * @return
     */
    List<SmdEmployeeEntity> isExistEmpName(String employeeName);

    /**
     * 判断职工身份证号码是否存在
     *
     * @param employeeIdCard
     * @return
     */
    List<SmdEmployeeEntity> isEmpIdCard(String employeeIdCard);

    /**
     * 判断职工手机号码是否存在
     *
     * @param employeePhone
     * @return
     */
    List<SmdEmployeeEntity> isExistEmpPhone(String employeePhone);

    /**
     * 根据职务 Ids获取职工信息
     *
     * @param ids
     * @return
     */
    List<Map<String, Object>> getEmployeeByJobIds(String[] ids);

    /**
     * 获取职工信息
     *
     * @param map1
     * @return
     */
    Map<String, Object> login(Map<String, Object> map1);

    /**
     * 根据部门Id查询职工
     *
     * @param orgId
     * @param deptId
     * @return
     */
    List<SmdEmployeeEntity> getEmployeesByOrgId(@Param(value = "orgId") String orgId, @Param(value = "deptId") String deptId);

    /**
     * 更新职工的钉钉Id
     *
     * @param employeeId
     * @param userid
     */
    void updateEmpDDId(@Param(value = "employeeId") String employeeId, @Param(value = "userid") String userid);

    /**
     * 更新简历状态
     * @param entity
     */
    void updateExisitIncident(SmdEmployeeEntity entity);
}
