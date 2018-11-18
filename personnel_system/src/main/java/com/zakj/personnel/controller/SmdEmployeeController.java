package com.zakj.personnel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zakj.client.OrganizationFeignClient;
import com.zakj.personnel.entity.SmdEmployeeEntity;
import com.zakj.personnel.entity.SmdEmployeeJobEntity;
import com.zakj.personnel.entity.SmdEmployeeTeacherTitleEntity;
import com.zakj.personnel.entity.SmdSsSubjectEntity;
import com.zakj.personnel.service.SmdEmployeeJobService;
import com.zakj.personnel.service.SmdEmployeeService;
import com.zakj.personnel.service.SmdEmployeeTeacherTitleService;
import com.zakj.personnel.service.SmdSsSubjectService;
import com.zakj.security.aspect.SysLog;
import com.zakj.security.common.beans.AjaxListResult;
import com.zakj.security.controller.BaseController;
import com.zakj.utils.*;
import jxl.*;
import jxl.read.biff.BiffException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * InnoDB free: 6144 kB; (`user_id`) REFER `renren_fast/asd_user_account`(`user_id`
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-02-24 11:47:53
 */
@Controller
@RequestMapping("/personnel/employee")
public class SmdEmployeeController extends BaseController {

    /**
     * 职工Servie
     */
    @Autowired
    private SmdEmployeeService smdEmployeeService;

    /**
     * 职工职务service
     */
    @Autowired
    private SmdEmployeeJobService smdEmployeeJobService;

    /**
     * 学科service
     */
    @Autowired
    private SmdSsSubjectService smdSsSubjectService;

    /**
     * 职称Service
     */
    @Autowired
    private SmdEmployeeTeacherTitleService teacherTitleService;


    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    /**
     * 获取职工信息列表
     */
    @RequestMapping(value = "list")
    public @ResponseBody
    AjaxListResult<Map<String, Object>> list(HttpServletRequest req, HttpSession session)
            throws Exception {
        AjaxListResult<Map<String, Object>> data = new AjaxListResult<Map<String, Object>>();
        List<Map<String, Object>> list = null;
        try {
            List<Map<String, Object>> orgList = new ArrayList<Map<String, Object>>();
            List<Object> li = new ArrayList<Object>();
            Map<String, Object> map = this.getRequestParams(req);
            String orgFatherId = map.get("orgFatherId").toString();
            String orgId = map.get("orgId").toString();
            String orgName = map.get("orgName").toString();
            String orgCategory = map.get("orgCategory").toString();
            String employee_name = map.get("employeeName").toString();
            String employee_job = map.get("employeeJob").toString();
            String type = map.get("type").toString();
            String userId = (String) session.getAttribute("userId");
            String orgId1 = (String) session.getAttribute("orgId");
            map.put("employeeName", employee_name);
            map.put("userId", userId);
            map.put("orgId", orgId1);

            if (orgId != null && orgCategory.equals("2")) {
                map.put("employeeDept", orgId);
                //  map.put("orgId", orgFatherId);
                orgId1 = orgFatherId;
            } else if (orgCategory.equals("1")) {
                // map.put("orgId", orgId);
                orgId1 = orgId;
            } else {
                //  map.put("orgId", orgId);
                orgId1 = orgId;
            }
            if (type.equals("0")) {
                R r = organizationFeignClient.queryDataAuthOrganization(map);
                if (r.get("code").toString().equals("0")) {
                    orgList = (List<Map<String, Object>>) r.get("data");
                    for (Iterator<Map<String, Object>> iterator = orgList.iterator(); iterator.hasNext(); ) {
                        Map<String, Object> map1 = iterator.next();
                        li.add(map1.get("orgId"));
                    }
                    System.out.println("li ----------------------- " + li.toString());
                    map.put("orgId", li);
                }
            } else {
                li.add(orgId1);
                map.put("orgId", li);
            }
            // 获取职工列表信息
            list = this.smdEmployeeService.queryList(map);
            System.out.println("list:  ------------------------------ " + list.toString());
            data.setData(list);
            data.setTotal(this.smdEmployeeService.queryTotal(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


    /**
     * 获取职工信息
     */
    @RequestMapping("/employeeInfo")
    public ModelAndView employeeInfo(Model model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        System.out.println("employeeId: ------------------- " + employeeId);
        SmdEmployeeEntity emp = smdEmployeeService.queryObject(employeeId);
        System.out.println("employeeName: --------------------- " + emp.getEmployeeName());
        mav.addObject("emp", emp);
        mav.setViewName("employee/personnel_edit");
        return mav;
    }

    /**
     * 进入职工增加界面
     *
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView addNew(Model model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        String orgId = map.get("orgId").toString();
        mav.addObject("orgId", orgId);
        String employeeDept = map.get("employeeDept").toString();
        mav.addObject("employeeDept", employeeDept);
        mav.setViewName("employee/personnel_add");
        return mav;
    }

    /**
     * 编辑人员信息
     *
     * @param req
     * @param session
     * @return
     * @throws Exception
     */
    @SysLog("编辑人员信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody
    AjaxListResult<Map<String, Object>> update(HttpServletRequest req, HttpSession session)
            throws Exception {
        System.out.println("保存编辑后的数据 ---------------------------");
        AjaxListResult<Map<String, Object>> data = new AjaxListResult<Map<String, Object>>();
        try {
            Map<String, Object> map = this.getRequestParams(req);
            String json = map.get("data").toString();
            System.out.println("json ---------------------------- " + json);
            SmdEmployeeEntity employee = (SmdEmployeeEntity) JSONObject.parseObject(json, SmdEmployeeEntity.class);
            this.smdEmployeeService.update(employee);
            data.setCode(0);
            data.setMsg("保存成功");
        } catch (Exception e) {
            data.setCode(101);
            data.setMsg("保存失败");
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 新增人员信息
     *
     * @param req
     * @param session
     * @return
     * @throws Exception
     */
    @SysLog("新增人员信息")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    AjaxListResult<Map<String, Object>> save(HttpServletRequest req, HttpSession session)
            throws Exception {
        System.out.println(" 新增数据-----------------------------  ");
        AjaxListResult<Map<String, Object>> data = new AjaxListResult<Map<String, Object>>();
        try {
            Map<String, Object> map = this.getRequestParams(req);
            String json = map.get("data").toString();
            SmdEmployeeEntity employee = (SmdEmployeeEntity) JSONObject.parseObject(json, SmdEmployeeEntity.class);
            System.out.println("employee: " + employee.getEmployeeName());
            String tenantId = (String) session.getAttribute("tenantId");
            String gradeId = (String) session.getAttribute("gradeId");
            String clazzId = (String) session.getAttribute("clazzId");
            employee.setUserId(Ids.uuid2());
            employee.setTenantId(tenantId);
            employee.setGradeId(gradeId);
            employee.setClazzId(clazzId);
            employee.setEmployeeState("1");
            employee.setInductionTime(new Date());
            this.smdEmployeeService.save(employee);
            data.setCode(0);
            data.setMsg("保存成功");
        } catch (Exception e) {
            data.setCode(101);
            data.setMsg("保存失败");
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 删除人员信息
     *
     * @param req
     * @param session
     * @return
     * @throws Exception
     */
    @SysLog("删除人员信息")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public @ResponseBody
    AjaxListResult<Map<String, Object>> dele(HttpServletRequest req, HttpSession session)
            throws Exception {
        AjaxListResult<Map<String, Object>> data = new AjaxListResult<Map<String, Object>>();
        try {
            Map<String, Object> map = this.getRequestParams(req);
            String employeeId = map.get("employeeId").toString();
            this.smdEmployeeService.updateEmpState(employeeId);
            data.setCode(0);
            data.setMsg("操作成功");
        } catch (Exception e) {
            data.setCode(101);
            data.setMsg("操作失败");
            e.printStackTrace();
        }
        return data;
    }


    /**
     * 获取所有职称信息
     *
     * @param req
     * @param session
     * @return
     */
    @RequestMapping(value = "employeeTitles", method = RequestMethod.GET)
    public @ResponseBody
    AjaxListResult<Map<String, Object>> employeeTitles(HttpServletRequest req, HttpSession session) {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        String tenantId = (String) session.getAttribute("tenantId");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = this.smdEmployeeService.getEmployeeTitles();
        result.setData(list);
        return result;
    }


    /**
     * 职工任教
     *
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("onTeach")
    public ModelAndView onTeach(Model model, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入任教页面......................... ");
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        System.out.println("employeeId:--------------------------- " + employeeId);
        String orgId = map.get("orgId").toString();
        System.out.println("orgId : -----------------------------------" + orgId);
        mav.addObject("employeeId", employeeId);
        mav.addObject("orgId", orgId);
        mav.setViewName("employee/teach_sub_clazz");
        return mav;
    }

    /**
     * 调岗
     *
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "onDept")
    public ModelAndView onDept(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("进入调岗页面..................... ");
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        System.out.println("employeeId:--------------------------- " + employeeId);
        String employeeName = map.get("employeeName").toString();
        employeeName = java.net.URLDecoder.decode(employeeName, "UTF-8");
        System.out.println("employeeName ----------------------------- " + employeeName);
        mav.addObject("employeeId", employeeId);
        mav.addObject("employeeName", employeeName);
        mav.setViewName("employee/employeeDept");
        return mav;
    }


    /**
     * 获取组织下的部门
     *
     * @param req
     * @param session
     * @return
     */
    @RequestMapping(value = "getDepts")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> getDepts(HttpServletRequest req, HttpSession session) {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> map = this.getRequestParams(req);
        String orgId = map.get("orgId").toString();
        String tenantId = (String) session.getAttribute("tenantId");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        list = UtilHttp.getDepts(tenantId, orgId);
        result.setData(list);
        return result;
    }


    /**
     * 岗位变更信息
     *
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("onJobRecord")
    public ModelAndView onJobRecord(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("岗位变更信息------------------ ");
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        System.out.println("employeeId:--------------------------- " + employeeId);
        String employeeName = map.get("employeeName").toString();
        employeeName = java.net.URLDecoder.decode(employeeName, "UTF-8");
        System.out.println("employeeName : -----------------------------------" + employeeName);
        mav.addObject("employeeId", employeeId);
        mav.addObject("employeeName", employeeName);
        mav.setViewName("employee/employee_Job_List");
        return mav;
    }


    /**
     * 获取当前人员的职务信息
     *
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("getEmployeeJobs")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> getEmployeeJobs(Model model, HttpServletRequest request,
                                                               HttpServletResponse response)
            throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list = this.smdEmployeeService.getEmployeeJobs();
        result.setData(list);
        return result;
    }


    /**
     * 单击离职
     *
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("onDeparture")
    public ModelAndView onDeparture(Model model, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        System.out.println("进入职工离职信息页面................................");
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        System.out.println("employeeId:--------------------------- " + employeeId);
        String employeeName = map.get("employeeName").toString();
        employeeName = java.net.URLDecoder.decode(employeeName, "UTF-8");
        System.out.println("employeeName : -----------------------------------" + employeeName);
        String employeeJob = map.get("employeeJob").toString();
        employeeJob = java.net.URLDecoder.decode(employeeJob, "UTF-8");
        System.out.println("employeeJob ----------------------------------- " + employeeJob);
//        String employeeNo = map.get("employeeNo").toString();
//        System.out.println("employeeNo ------------------------------------ " + employeeNo);
        String inductionTime = map.get("inductionTime").toString();
        System.out.println("inductionTime ----------------------------------- " + inductionTime);
        mav.addObject("employeeId", employeeId);
        mav.addObject("employeeName", employeeName);
        mav.addObject("employeeJob", employeeJob);
//        mav.addObject("employeeNo", employeeNo);
        mav.addObject("inductionTime", inductionTime);
        mav.setViewName("employee/leave_personnel");
        return mav;
    }


    /**
     * 职工转正
     *
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("onFormal")
    public ModelAndView onFormal(Model model, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        System.out.println("进入职工转正页面............................... ");
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        System.out.println("employeeId: -------------------- " + employeeId);
        String inductionTime = map.get("inductionTime").toString();
        System.out.println("inductionTime--------------------- " + inductionTime);
        mav.addObject("employeeId", employeeId);
        mav.addObject("inductionTime", inductionTime);
        mav.setViewName("employee/formal_personnel");
        return mav;
    }


    /**
     * 获取所有职务
     *
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("getEmployeeJobCombobox")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> getEmployeeJobCombobox(HttpServletRequest request,
                                                                      HttpSession session) throws Exception {
        System.out.println("获取所有职务信息........................ ");
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> map = this.getRequestParams(request);
        String tenantId = (String) session.getAttribute("tenantId");
        System.out.println("tenantId: ----------------------- " + tenantId);
        List<Map<String, Object>> empJobs = this.smdEmployeeService.getEmployeeJobCombobox(tenantId);
        result.setData(empJobs);
        return result;
    }


    /**
     * 根据学校获取职务信息
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("getEmployeeJobByOrgId")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> getEmployeeJobByOrgId(HttpServletRequest request, HttpSession session) {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        String orgId = (String) session.getAttribute("orgId");
        String tenantId = (String) session.getAttribute("tenantId");
        List<Map<String, Object>> maps = smdEmployeeService.getEmployeeJobByOrgId(orgId, tenantId);
        result.setData(maps);
        return result;
    }

    /**
     * 导出职工的excel
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("导出excel ....................... ");
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String orgFatherId = map.get("orgFatherId").toString();
            String orgId = map.get("orgId").toString();
            String orgCategory = map.get("orgCategory").toString();
            if (orgCategory.equals("2") && orgId != null) {
                map.put("employeeDept", orgId);
                map.put("orgId", orgFatherId);
            }
            this.smdEmployeeService.exportExcel(map, request, response);
        } catch (Exception e) {
            System.out.println("发生未知异常: " + e);
        }
    }


    /**
     * 上传简历
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("uploadResume")
    public ModelAndView uploadResume(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        mav.addObject("employeeId", employeeId);
        mav.setViewName("employee/resumeUpload");
        return mav;
    }


    /**
     * 更新简历路径至SmdEmployee表
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("updateResume")
    @ResponseBody
    public AjaxListResult<Map<String, Object>> updateResume(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String data = map.get("data").toString();
            SmdEmployeeEntity entity = (SmdEmployeeEntity) JSONObject.parseObject(data, SmdEmployeeEntity.class);
            smdEmployeeService.updateResume(entity);
            result.setCode(0);
            result.setMsg("操作成功!");
        } catch (Exception e) {
            result.setCode(101);
            result.setMsg("发生未知异常: " + e.getMessage());
        }
        return result;
    }


    /**
     * 点击预览
     *
     * @return
     */
    @RequestMapping("resumeView")
    public ModelAndView resumeView(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        System.out.println("employeeId ----------------------------- " + employeeId);
        HttpSession session = request.getSession();
        session.setAttribute("empId", employeeId);
        mav.setViewName("employee/resumeView");
        return mav;
    }


    /**
     * 下载
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "dowloadFile", method = RequestMethod.POST)
    @ResponseBody
    public AjaxListResult<Map<String, Object>> downLoadFromUrl(HttpServletRequest request, HttpServletResponse response) {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String employeeId = map.get("employeeId").toString();
            SmdEmployeeEntity entity = smdEmployeeService.getEmployeeResumeUrl(employeeId);
            URL url = new URL(entity.getEmployeeImgurlEdu());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 得到输入流
            InputStream inputStream = conn.getInputStream();
            // 获取自己数组
            byte[] getData = readInputStream(inputStream);

            // 文件保存位置
            File saveDir = new File("D:/download");
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + entity.getEmployeeName() + "简历" + ".docx");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            result.setCode(0);
            result.setMsg("操作成功");
        } catch (Exception e) {
            result.setCode(101);
            result.setMsg("发生未知异常: " + e.getMessage());
        }
        return result;

    }



    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }


    /**
     * 设置班主任
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("headerTeacher")
    public ModelAndView headerTeacher(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        String orgId = map.get("orgId").toString();
        String gradeId = map.get("gradeId").toString();
        String clazzId = map.get("clazzId").toString();
        mav.addObject("employeeId", employeeId);
        mav.addObject("orgId", orgId);
        mav.addObject("gradeId", gradeId);
        mav.addObject("clazzId", clazzId);
        mav.setViewName("employee/setHeaderTeacher");
        return mav;
    }


    /**
     * 更新班主任
     *
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("setHeaderTeacher")
    @ResponseBody
    public R setHeaderTeacher(HttpServletRequest request, HttpSession session) throws Exception {
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String data = map.get("data").toString();
            SmdEmployeeEntity entity = (SmdEmployeeEntity) JSONObject.parseObject(data, SmdEmployeeEntity.class);
            // 1.先查找该职工是否已经是某年级某班的班主任
            // 2.如果已经是某班的班主任，将班主任返回,若不是，则设置班主任
            SmdEmployeeEntity employeeEntity = smdEmployeeService.isExitWhichClazz(entity.getEmployeeId());
            if (employeeEntity.getTeachClazz() != null) {
                return R.ok(1, employeeEntity.getTeachClazz() + "的班主任是" + employeeEntity.getEmployeeName());
            } else {
                smdEmployeeService.setHeaderTeacher(entity);
                return R.ok(0, "操作成功!");
            }
        } catch (Exception e) {
            return R.ok(101, "发生未知异常: " + e.getMessage());
        }
    }


    /**
     * 继续将当前老师设置为其它班的班主任
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("againSetHeaderTeacher")
    public R againSetHeaderTeacher(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String data = map.get("data").toString();
            SmdEmployeeEntity entity = (SmdEmployeeEntity) JSONObject.parseObject(data, SmdEmployeeEntity.class);

            smdEmployeeService.setHeaderTeacher(entity);
            return R.ok(0, "操作成功!");
        } catch (Exception e) {
            return R.ok(101, "发生未知异常：" + e.getMessage());
        }
    }


    /**
     * 进入职工导入页面
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("excel")
    public ModelAndView excel(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        String orgFatherId = map.get("orgFatherId").toString();
        String orgId = map.get("orgId").toString();
        String orgCategory = map.get("orgCategory").toString();
        String employeeDept = "";
        if (orgCategory.equals("2") && orgId != null) {
//            map.put("employee_dept", orgId);
//            map.put("org_id", orgFatherId);
            employeeDept = orgId;
            orgId = orgFatherId;
        }
        System.out.println("orgCategory =====================================  " + orgCategory);
        System.out.println("orgId ============================================ " + orgId);
        System.out.println("employeeDept ============================================ " + employeeDept);
        mav.addObject("orgId", orgId);
        mav.addObject("employeeDept", employeeDept);
        mav.setViewName("employee/import_excel");
        return mav;
    }


    /**
     * 导出模板
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("exportExcelTemplate")
    public void exportExcelTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("导出excel ....................... ");
        Map<String, Object> map = this.getRequestParams(request);
        try {
            smdEmployeeService.exportExcelTemplate(map, request, response);
        } catch (Exception e) {
            System.out.println("发生未知异常: " + e);
        }
    }


    /**
     * 数据验证
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/oneFileUpload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    R oneFileUpload(HttpServletRequest request,
                    HttpServletResponse response) throws Exception {
        String path = null;
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
        Iterator<String> files = mRequest.getFileNames();
        while (files.hasNext()) {
            MultipartFile mFile = mRequest.getFile(files.next());
            if (mFile != null) {
                String fileName = UUID.randomUUID() + mFile.getOriginalFilename();
                path = "d:/upload/" + fileName;

                File localFile = new File(path);
                mFile.transferTo(localFile);
                request.setAttribute("fileUrl", path);
                //  Map<String, Object> map =new HashMap<String, Object>();
                //   importExcel(localFile);
                //  String uploadPic = UploadImage.uploadFile( fileName,  localFile,   "AA");
                // System.out.println("uploadPic ------------------------------- " + uploadPic);
                //  map.put("url", uploadPic);
            }
        }
        try {
            InputStream is = new FileInputStream(path);
            Workbook rwb = Workbook.getWorkbook(is);
            //获得工作薄（Workbook）中工作表（Sheet）的个数，示例：
            int sheets = rwb.getNumberOfSheets();
            //获取第一张Sheet表
            Sheet rs = rwb.getSheet(0);
            String sheetName = rs.getName();
            System.out.println(sheets + "  " + sheetName);
            //获取第二行，第二列的值
            Cell c11 = rs.getCell(1, 1);//第一个是列数，第二个是行数
            String strc11 = c11.getContents();
            //获取第四行，第二列的值
            Cell c13 = rs.getCell(1, 3);
            String strc13 = c13.getContents();
            //第三列 二行
            Cell c21 = rs.getCell(2, 1);
            String strc21 = c21.getContents();
            System.out.println("Cell(1, 1)" + " value : " + strc11 + "; type : " + c11.getType());
            System.out.println("Cell(1, 3)" + " value : " + strc13 + "; type : " + c13.getType());
            System.out.println("Cell(2, 1)" + " value : " + strc21 + "; type : " + c21.getType());

            int clos = rs.getColumns(); // 得到所有的列
            int rows = rs.getRows(); // 得到所有的行

            System.out.println(clos + " rows:" + rows);
            StringBuffer sb = new StringBuffer();
            for (int i = 3; i < rows; i++) {
                /** 姓名 **/
                String employeeName = rs.getCell(0, i).getContents();

                /**性别*/
                String employeeSex = rs.getCell(1, i).getContents();

                /** 身份证号 **/
                String employeeIdCard = rs.getCell(2, i).getContents();

                /**职务*/
                String employeeJob = rs.getCell(3, i).getContents();

                /**手机号码*/
                String employeePhone = rs.getCell(4, i).getContents();

                /**擅长科目*/
                String subjectName = rs.getCell(5, i).getContents();

                /**入职日期*/
                String inductionTime = rs.getCell(6, i).getContents();

                /**籍贯*/
                String employeeNativePlace = rs.getCell(7, i).getContents();

                /**民族*/
                String employeeNation = rs.getCell(8, i).getContents();

                /**学历*/
                String employeeEdu = rs.getCell(9, i).getContents();

                /**毕业院校*/
                String employeeGraduationSchool = rs.getCell(10, i).getContents();

                /**毕业时间*/
                String employeeGraduationDate = rs.getCell(11, i).getContents();

                /**健康状况*/
                String employeeHealth = rs.getCell(12, i).getContents();

                /**婚姻状况*/
                String isMarried = rs.getCell(13, i).getContents();

                /**政治面貌*/
                String employeePolitical = rs.getCell(14, i).getContents();

                /**出生日期*/
                String employeeBirthday = rs.getCell(15, i).getContents();

                /**所学专业*/
                String employeeMajor = rs.getCell(16, i).getContents();

                /**特长*/
                String employeeSkill = rs.getCell(17, i).getContents();

                /**职工编号*/
                String employeeNo = rs.getCell(18, i).getContents();

                /**职称*/
                String employeeTitle = rs.getCell(19, i).getContents();

                /**获取职称时间*/
                String employeeTitleDate = rs.getCell(20, i).getContents();

                /**教师资格证*/
                String employeeQualification = rs.getCell(21, i).getContents();

                /**通讯地址*/
                String employeeAddr = rs.getCell(22, i).getContents();

                /**家庭住址*/
                String employeeAddrHome = rs.getCell(23, i).getContents();

                /**邮编*/
                String employeePostcode = rs.getCell(24, i).getContents();

                /**QQ*/
                String employeeQq = rs.getCell(25, i).getContents();

                /**微信*/
                String employeeWebchat = rs.getCell(26, i).getContents();

                /**电子邮箱*/
                String employeeEmail = rs.getCell(27, i).getContents();

                /**省*/
                String provice = rs.getCell(28, i).getContents();

                /**市*/
                String city = rs.getCell(29, i).getContents();

                /**县*/
                String county = rs.getCell(30, i).getContents();

                /**家长*/
                String employeeParent = rs.getCell(31, i).getContents();

                /**家长手机号*/
                String employeeParentPhone = rs.getCell(32, i).getContents();

                /**班主任所带年级*/
                String gradeName = rs.getCell(33, i).getContents();

                /**班主任所带班级*/
                String clazzName = rs.getCell(34, i).getContents();

                sb.append("<tr>");
                sb.append("<td bgcolor='#FFFFFF' >" + i + "</td>");
                sb.append("<td bgcolor='#FFFFFF' >" + employeeName + "</td>");
                if (ValidUtils.isIDCard(employeeIdCard)) {
                    sb.append("<td bgcolor='#FFFFFF' >" + employeeIdCard + "</td>");
                } else {
                    sb.append("<td bgcolor='#FF0000'>" + employeeIdCard + "</td>");
                }

                sb.append("<td bgcolor='#FFFFFF' >" + employeeSex + "</td>");
                sb.append("<td bgcolor='#FFFFFF' >" + employeeJob + "</td>");

                if (ValidUtils.isMobile(employeePhone)) {
                    sb.append("<td bgcolor='#FFFFFF' >" + employeePhone + "</td>");
                } else {
                    sb.append("<td bgcolor='#FF0000'>" + employeePhone + "</td>");
                }

                sb.append("<td bgcolor='#FFFFFF' >" + subjectName + "</td>");


                if (ValidUtils.isDate(inductionTime)) {
                    sb.append("<td bgcolor='#FFFFFF' >" + inductionTime + "</td>");
                } else {
                    sb.append("<td bgcolor='#FFFFFF' >" + inductionTime + "</td>");
                }

                sb.append("<td bgcolor='#FFFFFF' >" + employeeNativePlace + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeNation + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeEdu + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeGraduationSchool + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeGraduationDate + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeHealth + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + isMarried + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeePolitical + "</td>");

                if (ValidUtils.isDate(employeeBirthday)) {
                    sb.append("<td bgcolor='#FFFFFF' >" + employeeBirthday + "</td>");
                } else {
                    sb.append("<td bgcolor='#FFFFFF' >" + employeeBirthday + "</td>");
                }

                sb.append("<td bgcolor='#FFFFFF' >" + employeeMajor + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeSkill + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeNo + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeTitle + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeTitleDate + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeQualification + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeAddr + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeAddrHome + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeePostcode + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeQq + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeWebchat + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeEmail + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + provice + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + city + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + county + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeParent + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + employeeParentPhone + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + gradeName + "</td>");

                sb.append("<td bgcolor='#FFFFFF' >" + clazzName + "</td>");
                sb.append("</tr>");
            }
            System.out.println(sb.toString());
            return R.ok(0, "操作成功!").put("data", sb.toString());
            // 总结
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 保存导入职工信息到数据库
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toDb", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    R toDb(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = null;
        CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());
        if (cmr.isMultipart(request)) {
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
            Iterator<String> files = mRequest.getFileNames();
            while (files.hasNext()) {
                MultipartFile mFile = mRequest.getFile(files.next());
                if (mFile != null) {
                    String fileName = UUID.randomUUID() + mFile.getOriginalFilename();
                    path = "d:/upload/" + fileName;
                    File localFile = new File(path);
                    mFile.transferTo(localFile);
                    request.setAttribute("fileUrl", path);
                }
            }
        }

        Map<String, Object> map = this.getRequestParams(request);
        String orgId = map.get("orgId").toString();
        String employeeDept = map.get("employeeDept").toString();
        System.out.println("orgId  --------------------------- " + orgId);
        System.out.println("employeeDept ---------------------- " + employeeDept);
        InputStream is = new FileInputStream(path);
        Workbook rwb = Workbook.getWorkbook(is);
        //获得工作薄（Workbook）中工作表（Sheet）的个数，示例：
        int sheets = rwb.getNumberOfSheets();
        //获取第一张Sheet表
        Sheet rs = rwb.getSheet(0);
        String sheetName = rs.getName();
        System.out.println(sheets + "  " + sheetName);
        //获取第二行，第二列的值
        Cell c11 = rs.getCell(1, 1);//第一个是列数，第二个是行数
        String strc11 = c11.getContents();
        //获取第四行，第二列的值
        Cell c13 = rs.getCell(1, 3);
        String strc13 = c13.getContents();
        //第三列 二行
        Cell c21 = rs.getCell(2, 1);
        String strc21 = c21.getContents();
        System.out.println("Cell(1, 1)" + " value : " + strc11 + "; type : " + c11.getType());
        System.out.println("Cell(1, 3)" + " value : " + strc13 + "; type : " + c13.getType());
        System.out.println("Cell(2, 1)" + " value : " + strc21 + "; type : " + c21.getType());

        int clos = rs.getColumns();//得到所有的列
        int rows = rs.getRows();//得到所有的行

        System.out.println(clos + " rows:" + rows);
        List<SmdEmployeeEntity> list = new ArrayList<SmdEmployeeEntity>(0);
        /**职工entity*/
        SmdEmployeeEntity employeeEntity = null;
        /**职务entity*/
        SmdEmployeeJobEntity employeeJobEntity = null;
        /**学科entity*/
        SmdSsSubjectEntity subjectEntity = null;
        /**职称entity*/
        SmdEmployeeTeacherTitleEntity teacherTitleEntity = null;
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
//        String orgId = (String)session.getAttribute("orgId");
        String tenantId = (String) session.getAttribute("tenantId");
        String employeeId = (String) session.getAttribute("employeeId");
        String userName = (String) session.getAttribute("userName");

        // 存放用户信息
        Map<String, Object> userMap = new HashMap<String, Object>();
        for (int i = 3; i < rows; i++) {
            employeeEntity = new SmdEmployeeEntity();
            employeeJobEntity = new SmdEmployeeJobEntity();
            subjectEntity = new SmdSsSubjectEntity();
            teacherTitleEntity = new SmdEmployeeTeacherTitleEntity();

            /** 姓名 **/
            String employeeName = rs.getCell(0, i).getContents();
            if (employeeName.trim().equals("")) {
                break;
            }
            // 判断该员工是否存在
            if (!employeeName.isEmpty()) {
                List<SmdEmployeeEntity> empNames = smdEmployeeService.isExistEmpName(employeeName);
                if (empNames.size() == 0) {
                    employeeEntity.setEmployeeName(employeeName);
                } else {
                    continue;
                }

            }

            /**性别*/
            String employeeSex = rs.getCell(1, i).getContents();
            if (employeeSex.trim().equals("")) {
                break;
            }
            employeeEntity.setEmployeeSex(employeeSex);

            /** 身份证号 **/
            String employeeIdCard = rs.getCell(2, i).getContents();
            // 判断身份证号码是否存在
            if (!employeeIdCard.isEmpty()) {
                List<SmdEmployeeEntity> empCards = smdEmployeeService.isExistEmpIdCard(employeeIdCard);
                if (empCards.size() == 0) {
                    employeeEntity.setEmployeeIdcard(employeeIdCard);
                } else {
                    continue;
                }
            }

            /**职务*/
            String employeeJob = rs.getCell(3, i).getContents();
            // 1.先将职务保存在职务表中
            employeeJobEntity.setEmployeeJob(employeeJob);
            employeeJobEntity.setCreateTime(new Date());
            employeeJobEntity.setCreateUser(userId);
            employeeJobEntity.setTenantId(tenantId);
            smdEmployeeJobService.save(employeeJobEntity);

            // 2.再将职务 Id及职务名称设置在职工表中
            employeeEntity.setEmployeeJobId(employeeJobEntity.getEmployeeJobId());
            employeeEntity.setEmployeeJob(employeeJobEntity.getEmployeeJob());

            /**手机号码*/
            String employeePhone = rs.getCell(4, i).getContents();
            if (!employeePhone.isEmpty()) {
                List<SmdEmployeeEntity> empPhones = smdEmployeeService.isExistEmpPhone(employeePhone);
                if (empPhones.size() == 0) {
                    employeeEntity.setEmployeePhone(employeePhone);
                } else {
                    continue;
                }
            }
            System.out.println("employeePhone*******************************" + employeePhone);
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + employeeEntity.getEmployeePhone());

            /**擅长科目*/
            String subjectName = rs.getCell(5, i).getContents();
            // 1. 创建科目
            subjectEntity.setSubjectName(subjectName);
            subjectEntity.setTenantId(tenantId);
            subjectEntity.setOrgId(orgId);
            smdSsSubjectService.save(subjectEntity);
            // 2. 将科目的id及名称设置在职工对象中
            employeeEntity.setSubjectId(subjectEntity.getSubjectId());
            employeeEntity.setEmployeeSubject(subjectEntity.getSubjectName());

            /**入职日期*/
//            String inductionTime = rs.getCell(7,i).getContents();
//            System.out.println("inductionTime ---------------------------------- " + inductionTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String inductionTime = "";
            if (rs.getCell(6, i).getType() == CellType.DATE) {
                DateCell dc = (DateCell) rs.getCell(6, i);
                Date date = dc.getDate();
                SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
                inductionTime = ds.format(date);
            }
            Date inductionDate = sdf.parse(inductionTime);
            employeeEntity.setInductionTime(inductionDate);

            /**籍贯*/
            String employeeNativePlace = rs.getCell(7, i).getContents();
            employeeEntity.setEmployeeNativePlace(employeeNativePlace);

            /**民族*/
            String employeeNation = rs.getCell(8, i).getContents();
            employeeEntity.setEmployeeNation(employeeNation);

            /**学历*/
            String employeeEdu = rs.getCell(9, i).getContents();
            employeeEntity.setEmployeeEdu(employeeEdu);

            /**毕业院校*/
            String employeeGraduationSchool = rs.getCell(10, i).getContents();
            employeeEntity.setEmployeeGraduationSchool(employeeGraduationSchool);

            /**毕业时间*/
            String employeeGraduationDate = "";
            SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
            if (rs.getCell(11, i).getType() == CellType.DATE) {
                DateCell dc = (DateCell) rs.getCell(11, i);
                Date date = dc.getDate();
                employeeGraduationDate = ds.format(date);
            } else {
                employeeGraduationDate = ds.format(new Date());
            }
            Date graduationDate = sdf.parse(employeeGraduationDate);
            employeeEntity.setEmployeeGraduationDate(graduationDate);

            /**健康状况*/
            String employeeHealth = rs.getCell(12, i).getContents();
            employeeEntity.setEmployeeHealth(employeeHealth);

            /**婚姻状况*/
            String isMarried = rs.getCell(13, i).getContents();
            employeeEntity.setIsMarried(isMarried);

            /**政治面貌*/
            String employeePolitical = rs.getCell(14, i).getContents();
            employeeEntity.setEmployeePolitical(employeePolitical);

            /**出生日期*/
            String birthdayDate = "";
            if (rs.getCell(15, i).getType() == CellType.DATE) {
                DateCell dc = (DateCell) rs.getCell(15, i);
                Date date = dc.getDate();
                birthdayDate = ds.format(date);
            } else {
                birthdayDate = ds.format(new Date());
            }
            Date birthDate = sdf.parse(birthdayDate);
            employeeEntity.setEmployeeBirthday(birthDate);

            /**所学专业*/
            String employeeMajor = rs.getCell(16, i).getContents();
            employeeEntity.setEmployeeMajor(employeeMajor);

            /**特长*/
            String employeeSkill = rs.getCell(17, i).getContents();
            employeeEntity.setEmployeeSkill(employeeSkill);

            /**职工编号*/
            String employeeNo = rs.getCell(18, i).getContents();
            employeeEntity.setEmployeeNo(employeeNo);

            /**职称*/
            String employeeTitle = rs.getCell(19, i).getContents();
            // 1.创建职称
            teacherTitleEntity.setTeacherTitleName(employeeTitle);
            teacherTitleEntity.setCreateTime(new Date());
            teacherTitleEntity.setTenantId(tenantId);
            teacherTitleEntity.setCreateEmpId(employeeId);
            teacherTitleEntity.setCreateUserId(userId);
            teacherTitleEntity.setCreateUserName(userName);
            teacherTitleEntity.setOrgId(orgId);
            teacherTitleService.save(teacherTitleEntity);
            // 2.设置称职id和名称给职工对象
            employeeEntity.setEmployeeTitle(teacherTitleEntity.getTeacherTitleId());

            /**获取职称时间*/
            String employeeTitleDate = "";
            if (rs.getCell(20, i).getType() == CellType.DATE) {
                DateCell dc = (DateCell) rs.getCell(20, i);
                Date date = dc.getDate();
                employeeTitleDate = ds.format(date);
            } else {
                employeeTitleDate = ds.format(new Date());
            }
            Date titleDate = sdf.parse(employeeTitleDate);
            employeeEntity.setEmployeeTitleDate(titleDate);

            /**教师资格证*/
            String employeeQualification = rs.getCell(21, i).getContents();
            employeeEntity.setEmployeeQualification(employeeQualification);

            /**通讯地址*/
            String employeeAddr = rs.getCell(22, i).getContents();
            employeeEntity.setEmployeeAddr(employeeAddr);

            /**家庭住址*/
            String employeeAddrHome = rs.getCell(23, i).getContents();
            employeeEntity.setEmployeeAddrHome(employeeAddrHome);

            /**邮编*/
            String employeePostcode = rs.getCell(24, i).getContents();
            employeeEntity.setEmployeePostcode(employeePostcode);

            /**QQ*/
            String employeeQq = rs.getCell(25, i).getContents();
            employeeEntity.setEmployeeQq(employeeQq);

            /**微信*/
            String employeeWebchat = rs.getCell(26, i).getContents();
            employeeEntity.setEmployeeWebchat(employeeWebchat);

            /**电子邮箱*/
            String employeeEmail = rs.getCell(27, i).getContents();
            employeeEntity.setEmployeeEmail(employeeEmail);

            /**省*/
            String provice = rs.getCell(28, i).getContents();
            employeeEntity.setProvince(provice);

            /**市*/
            String city = rs.getCell(29, i).getContents();
            employeeEntity.setCity(city);

            /**县*/
            String county = rs.getCell(30, i).getContents();
            employeeEntity.setCounty(county);

            /**家长*/
            String employeeParent = rs.getCell(31, i).getContents();
            employeeEntity.setEmployeeParent(employeeParent);

            /**家长手机号*/
            String employeeParentPhone = rs.getCell(32, i).getContents();
            employeeEntity.setEmployeeParentPhone(employeeParentPhone);

            /**班主任所带年级*/
            String gradeName = rs.getCell(33, i).getContents();

            /**班主任所带班级*/
            String clazzName = rs.getCell(34, i).getContents();

            employeeEntity.setOrgId(orgId);
            employeeEntity.setEmployeeDept(employeeDept);
            employeeEntity.setTenantId(tenantId);
            String uuId = UUID.randomUUID().toString().replaceAll("-", "");
            employeeEntity.setUserId(uuId);
            employeeEntity.setEmployeeState("1");
            employeeEntity.setCreateTime(new Date());
            employeeEntity.setImportExcelFlag(1);

            list.add(employeeEntity);

            User user = new User();
            user.setUserId(uuId);
            user.setUserName(employeeEntity.getEmployeeName());
            user.setUserSex(employeeEntity.getEmployeeSex());
            user.setUserIdcar(employeeEntity.getEmployeeIdcard());
            /**
             * 用户访问角色：【0】访问者；【1】教职工；【2】家长；【3】即使家长也是教职工；【4】学生
             */
            user.setUserRole("1");
            user.setTenantId(employeeEntity.getTenantId());
            user.setOrgId(orgId);
            user.setCreateTime(DateUtils.format(new Date()));
            user.setUserLogin(employeeEntity.getEmployeePhone());
            List<User> userList = new ArrayList<User>();
            userList.add(user);
            String data = JSON.toJSONString(userList);
            userMap.put("data", data);
            userMap.put("loginType", "0");
        }
        if (!list.isEmpty()) {
            smdEmployeeService.saveBatch(list, userMap);
            return R.ok("保存成功");
        } else {
            return R.error("当前导入职工已存在！");
        }
    }


    /**
     * 同步数据
     *
     * @param request
     * @return
     * @Param ddId
     */
    @RequestMapping("synchronousData")
    public @ResponseBody
    R synchronousData(HttpServletRequest request, HttpSession session) {
        try {
            String tenantId = (String) session.getAttribute("tenantId");
            Map<String, Object> map = this.getRequestParams(request);
            map.put("tenantId", tenantId);
            smdEmployeeService.synchronousEmpData(map);
            return R.ok(0, "操作成功!");
        } catch (Exception e) {
            return R.error(101, "发生未知异常：" + e.getMessage());
        }
    }

}
