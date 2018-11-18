package com.zakj.client;

import com.zakj.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * ClassName：EmployeeFeignClient
 * Description： 基础数据服务接口
 * Created by ryh on 2018/5/19.
 * 此接口中的方法和远程服务中contoller中的方法名和参数需保持一致
 */

@FeignClient(value  ="basic-data-service", fallback = BasicDataFeignClientHystrix.class)
public interface BasicDataFeignClient {
    @RequestMapping(value = "/employee/getEmployeeInfoByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getEmployeeInfoByUserId(@RequestParam Map<String, Object> params);

    @RequestMapping(value = "/student/getStudentByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getStudentByUserId(@RequestParam Map<String, Object> params);

    /**
     * 获取职位信息
     *
     * @param map orgId 学校id
     * @return
     */
    @RequestMapping(value = "/employee/getEmployeeJob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getEmployeeJob(@RequestParam Map<String, Object> map);

    /**
     * 获取职工信息
     *
     * @param params orgId  学校id
     *               tenantId 企业
     *               employeeJobId 职位
     *               pageSize 条数
     *               pageIndex   第几页
     * @return
     */
    @RequestMapping(value = "/employee/queryEmployeeList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R queryEmployeeList(@RequestParam Map<String, Object> params);

    /**
     * 根据登录用户ID获取家长登录信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/student/queryStudentByUserId", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R queryStudentByUserId(@RequestParam Map<String, Object> params);

    /**
     * 根据部门ID获取部门下所有人员
     *
     * @param params orgId 学校id
     * @return
     */
    @RequestMapping(value = "/employee/getDeptEmployeeList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public R getDeptEmployeeList(@RequestParam Map<String, Object> params);
}