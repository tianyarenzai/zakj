package com.zakj.client;

import com.zakj.utils.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * ClassName：EmployeeFeignClientHystrix
 * Description：基础数据服务接口断路器
 *
 * @author ryh
 * @date 2018/6/21 10:44
 **/
@Component
public class BasicDataFeignClientHystrix implements BasicDataFeignClient{

    @Override
    public R getEmployeeInfoByUserId(@RequestParam Map<String, Object> params) {
        return R.ok(400,"获取职工信息失败！");
    }

    @Override
    public R getStudentByUserId(@RequestParam Map<String, Object> params) {
        return R.ok(400,"获取学生数据失败！");
    }

    @Override
    public R getEmployeeJob(@RequestParam Map<String, Object> map) {
        return R.ok(400,"获取职工职位数据失败！");
    }

    @Override
    public R queryEmployeeList(@RequestParam Map<String, Object> params) {
        return R.ok(400,"获取职工列表失败！");
    }

    @Override
    public R queryStudentByUserId(@RequestParam Map<String, Object> params) {
        return R.ok(400,"获取家长登录信息失败！");
    }

    @Override
    public R getDeptEmployeeList(@RequestParam Map<String, Object> map) {
        return R.ok(400, "获取部门人员数据失败！");
    }
}