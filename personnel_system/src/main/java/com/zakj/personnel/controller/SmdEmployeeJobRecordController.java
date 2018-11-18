package com.zakj.personnel.controller;

import com.zakj.personnel.entity.SmdEmployeeJobRecordEntity;
import com.zakj.personnel.service.SmdEmployeeJobRecordService;
import com.zakj.security.aspect.SysLog;
import com.zakj.security.common.beans.AjaxListResult;
import com.zakj.security.controller.BaseController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 职位变更记录; InnoDB free: 13312 kB
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-03 09:24:44
 */
@RestController
@RequestMapping("/employee/smdemployeejobrecord")
public class SmdEmployeeJobRecordController extends BaseController {
    @Autowired
    private SmdEmployeeJobRecordService smdEmployeeJobRecordService;


    /**
     * 保存岗位变更记录
     * @param request
     * @return
     * @throws Exception
     */
    @SysLog("保存岗位变更记录")
    @RequestMapping("saveData")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> saveData(HttpServletRequest request, HttpSession session) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        try {
            Map<String, Object> map = this.getRequestParams(request);
            String json = map.get("data").toString();
            JSONObject jsonObject = JSONObject.fromObject(json);
            SmdEmployeeJobRecordEntity empRecord = (SmdEmployeeJobRecordEntity) JSONObject.
                    toBean(jsonObject, SmdEmployeeJobRecordEntity.class);
            System.out.println("employeeId ----------------------- " + empRecord.getEmployeeId());
            System.out.println("employeeName:---------------------  " + empRecord.getEmployeeName());
            String userId = (String) session.getAttribute("userId");
            empRecord.setCreatorUserId(userId);
            String userName = (String) session.getAttribute("userName");
            empRecord.setCreatorUserName(userName);
            empRecord.setCreatorTime(new Date());
            this.smdEmployeeJobRecordService.save(empRecord);
            result.setCode(0);
            result.setMsg("保存成功");
        } catch (Exception e) {
            result.setCode(101);
            result.setMsg("保存失败");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获取当前职工的岗位变更记录
     *
     * @param req
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getChangedJobs", method = RequestMethod.POST)
    @ResponseBody
    public AjaxListResult<Map<String, Object>> getChangedJobs(HttpServletRequest req, HttpSession session)
            throws Exception {
        AjaxListResult<Map<String, Object>> data = new AjaxListResult<Map<String, Object>>();
        List<Map<String, Object>> list = null;
        try {
            Map<String, Object> map = this.getRequestParams(req);
            String employeeId = map.get("employeeId").toString();
            System.out.println("employeeId ------------------------ " + employeeId);
            list = this.smdEmployeeJobRecordService.queryList(map);
            data.setData(list);
            data.setTotal(this.smdEmployeeJobRecordService.queryTotal(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
