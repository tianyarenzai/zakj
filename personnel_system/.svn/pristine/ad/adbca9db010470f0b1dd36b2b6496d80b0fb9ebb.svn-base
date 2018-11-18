package com.zakj.personnel.dao;

import com.zakj.personnel.entity.SmdEmployeeClazzSubjectEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 12288 kB; (`xk_id`) REFER `renren_fast/zyk_xk`(`xkID`); (`employee_
 * 
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-02-27 10:55:06
 */
@Mapper
public interface SmdEmployeeClazzSubjectDao extends BaseDao<SmdEmployeeClazzSubjectEntity> {
    /**
     * 获取所有班级
     * @return
     * @param orgId
     */
    List<Map<String,Object>> getGrades(String orgId);

    /**
     * 根据职工获取职工的任教信息
     * @param employeeId
     * @return
     */
    List<Map<String,Object>> getGradesByEmployeeId(String employeeId);

    /**
     * 获取职工任教信息的数
     * @param employeeId
     * @return
     */
    long getGradesTotal(String employeeId);

    /**
     * 根据年级Id获取年级下的所有班级信息
     * @param gradeId
     * @return
     */
    List<Map<String,Object>> getClazzs(String gradeId);

    /**
     * 更新职工的任教信息(一次更新多条记录)
     * @param map
     */
    void updateMap(Map<String, Object> map);

    /**
     * 新增职工的任教信息(一次新增多条记录)
     * @param map
     */
    void saveMap(Map<String, Object> map);

    /**
     * 判断当前当前学科的班级是否被任教,若已被任教就获取该任教职工
     * @param map
     * @return
     */
    List<Map<String, Object>> isClazzed(Map<String, Object> map);

    /**
     * 根据学科班级的任教信息更新任教职工
     * @param map
     */
    void updateEmpClazzSubjet(Map<String, Object> map);

    /**
     * 获取所有学科
     * @param tenantId
     * @return
     */
    List<Map<String,Object>> getSubject(String tenantId);
}
