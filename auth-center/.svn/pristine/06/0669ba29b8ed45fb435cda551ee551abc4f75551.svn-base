package com.zakj.auth.dao;

import com.zakj.auth.entity.Application;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * ClassName：DataAuthDao
 * Description：应用模块访问层
 *
 * @author ryh
 * @date 2018/6/8 14:43
 **/
@Mapper
public interface ApplicationDao  extends BaseDao<Application> {
    List<Map<String, Object>> getAuthByUserId(Map<String, Object> params);
}
