package com.zakj.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * ClassName：SemesterFeignApi
 * Description：学生服务远程调用接口
 *
 * @author ryh
 * @date 2018/6/1 11:03
 **/
//auth-center  //za-api
@FeignClient(value  ="basic-data-service", fallback = StudentFeignClientHystrix.class)
public interface StudentFeignClient {

  @RequestMapping(value ="/student/getSemesterList")
  public List<Map<String,Object>> getSemesterList(@RequestParam Map<String, Object> map);

  @RequestMapping(value = "/student/getGradesByOrgId")
  public   List<Map<String, Object>> getGradesByOrgId(@RequestParam Map<String, Object> map);

  @RequestMapping(value ="/student/getClazzsByGradeId")
  public List<Map<String, Object>>  getClazzsByGradeId(@RequestParam Map<String, Object> map);

  @RequestMapping(value ="/student/queryList")
  List<Map<String,Object>> queryList(@RequestParam Map<String, Object> map);
}
