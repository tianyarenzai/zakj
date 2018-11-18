package com.zakj.personnel.controller;

import com.zakj.personnel.entity.AlyApSevPushMessageEntity;
import com.zakj.personnel.entity.SmdCeRemindEntity;
import com.zakj.personnel.service.AlyApSevPushMessageService;
import com.zakj.personnel.service.SmdCeRemindService;
import com.zakj.security.aspect.SysLog;
import com.zakj.security.controller.BaseController;
import com.zakj.utils.R;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;


/**
 * InnoDB free: 12288 kB
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@RestController
@RequestMapping("/employee/smdceremind")
public class SmdCeRemindController extends BaseController {
    @Autowired
    private SmdCeRemindService smdCeRemindService;

    @Autowired
    private AlyApSevPushMessageService alyApSevPushMessageService;


    /**
     * 保存提醒数据
     *
     * @param req
     * @param session
     * @return
     * @throws Exception
     */
    @SysLog("保存提醒数据")
    @RequestMapping(value = "save")
    public R save(HttpServletRequest req, HttpSession session)
            throws Exception {
        System.out.println("新增数据-----------------------------");
        try {
            // 1. 解析前台传递参数json，并保存在合同到期提醒表中
            Map<String, Object> map = this.getRequestParams(req);
            String json = map.get("data").toString();
            JSONObject jsonObject = JSONObject.fromObject(json);
            SmdCeRemindEntity entity = (SmdCeRemindEntity) JSONObject.toBean(jsonObject, SmdCeRemindEntity.class);
            System.out.println("employee:---------------------------  " + entity.getContent());
            String tenantId = (String) session.getAttribute("tenantId");
            entity.setTenantId(tenantId);
            String employeeId = (String) session.getAttribute("employeeId");
            entity.setCreateEmpId(employeeId);
            String userId = (String) session.getAttribute("userId");
            entity.setCreateUser(userId);
            entity.setCreateDate(new Date());
            entity.setState(0);
            this.smdCeRemindService.save(entity);

            // 2．将提醒消息内存推送给app
            if (entity.getRemindType() == 1) {
                AlyApSevPushMessageEntity messageEntity = new AlyApSevPushMessageEntity();
                messageEntity.setUserId(entity.getUserId());
                messageEntity.setTenantId(tenantId);
                messageEntity.setDisplayType(0);
                messageEntity.setTitle("提醒");
                messageEntity.setBody(entity.getContent());
                messageEntity.setSendTime(new Date());
                alyApSevPushMessageService.save(messageEntity);
            }
            return R.ok(0, "保存成功!");
        } catch (Exception e) {
            return R.error(101, "保存失败");
        }
    }

}
