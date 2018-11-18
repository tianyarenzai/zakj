package com.zakj.personnel.dao;

import com.zakj.personnel.entity.SmdSsSchoolSubjectEntity;
import com.zakj.security.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-19 11:24:11
 */
@Mapper
public interface SmdSsSchoolSubjectDao extends BaseDao<SmdSsSchoolSubjectEntity> {

    /**
     * 获取学校学科信息
     * @param orgId
     * @return
     */
    List<Map<String,Object>> getSchoolSubjects(String orgId);
}
