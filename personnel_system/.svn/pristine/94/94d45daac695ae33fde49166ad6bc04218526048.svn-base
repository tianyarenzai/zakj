package com.zakj.personnel.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zakj.api.AuthFeignApi;
import com.zakj.client.AuthFeignClient;
import com.zakj.client.OrganizationFeignClient;
import com.zakj.personnel.dao.SmdEmployeeDao;
import com.zakj.personnel.entity.SmdEmployeeEntity;
import com.zakj.personnel.service.SmdEmployeeService;
import com.zakj.utils.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 职工Service接口
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@Service("smdEmployeeService")
public class SmdEmployeeServiceImpl implements SmdEmployeeService {
    @Autowired
    private SmdEmployeeDao smdEmployeeDao;

    @Autowired
    private AuthFeignClient authFeignClient;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    @Override
    public SmdEmployeeEntity queryObject(String employeeId) {
        return smdEmployeeDao.queryObject(employeeId);
    }

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return smdEmployeeDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return smdEmployeeDao.queryTotal(map);
    }

    @Override
    public void save(SmdEmployeeEntity smdEmployee) {
        User user = new User();
        user.setUserId(smdEmployee.getUserId());
        user.setUserName(smdEmployee.getEmployeeName());
        user.setUserSex(smdEmployee.getEmployeeSex());
        user.setUserIdcar(smdEmployee.getEmployeeIdcard());
        /**
         * 用户访问角色：【0】访问者；【1】教职工；【2】家长；【3】即使家长也是教职工；【4】学生
         */
        user.setUserRole("1");
        user.setTenantId(smdEmployee.getTenantId());
        user.setCreateTime(DateUtils.format(new Date()));
        user.setUserLogin(smdEmployee.getEmployeePhone());
        user.setOrgId(smdEmployee.getOrgId());
        List<User> list = new ArrayList<User>();
        list.add(user);
       /* User user2 = new User();
        user2.setUserId(UUID.randomUUID().toString().replaceAll("-",""));
        user2.setUserName(smdEmployee.getEmployeeName());
        user2.setUserSex(smdEmployee.getEmployeeSex());
        user2.setUserIdcar(smdEmployee.getEmployeeIdcard());
        *//**
         * 用户访问角色：【0】访问者；【1】教职工；【2】家长；【3】即使家长也是教职工；【4】学生
         *//*
        user2.setUserRole("1");
        user2.setTenantId(smdEmployee.getTenantId());
        user2.setCreateTime(DateUtils.format(new Date()));
        user2.setUserLogin(smdEmployee.getEmployeePhone()+1);
        user2.setOrgId(smdEmployee.getOrgId());
        list.add(user2);*/
        String data = JSON.toJSONString(list);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", data);
        map.put("loginType", "0");
        R r = organizationFeignClient.generateAccount(map);
        if (r.get("code").toString().equals("0")){
            System.out.println(r.get("msg"));
            smdEmployeeDao.save(smdEmployee);
        }else if(r.get("code").toString().equals("1")){
            System.out.println("职工账号重复 "+r.get("msg"));
        }

    }

    @Override
    public void update(SmdEmployeeEntity smdEmployee) {
        smdEmployeeDao.update(smdEmployee);
    }

    @Override
    public void delete(String employeeId) {
        smdEmployeeDao.delete(employeeId);
    }

    @Override
    public void deleteBatch(String[] employeeIds) {
        smdEmployeeDao.deleteBatch(employeeIds);
    }

    @Override
    public void updateEmpState(String employeeId) {
        smdEmployeeDao.updateEmployeeState(employeeId);
    }

    @Override
    public List<Map<String, Object>> getEmployeeTitles() {
        return smdEmployeeDao.getEmployeeTitles();
    }

    @Override
    public long getChangedJobsTotal(Map<String, Object> map) {
        return smdEmployeeDao.getChangedJobsTotal(map);
    }

    @Override
    public List<Map<String, Object>> getEmployeeJobs() {
        return smdEmployeeDao.getEmployeeJobs();
    }

    @Override
    public List<Map<String, Object>> getEmployeeJobCombobox(String tenantId) {
        return smdEmployeeDao.getEmployeeJobCombobox(tenantId);
    }

    @Override
    public List<Map<String, Object>> getLeaveEmpList(Map<String, Object> map) {
        return smdEmployeeDao.getLeaveEmpList(map);
    }

    @Override
    public int getLeaveEmpTotal(Map<String, Object> map) {
        return smdEmployeeDao.getLeaveEmpTotal(map);
    }

    @Override
    public long getHeadTeacherTeachClazzTotal(Map<String, Object> map) {
        return smdEmployeeDao.getHeadTeacherTeachClazzTotal(map);
    }

    @Override
    public List<Map<String, Object>> getHeadTeacherTeachClazzs(Map<String, Object> map) {
        return smdEmployeeDao.getHeadTeacherTeachClazzs(map);
    }

    /**
     * 导出excel
     *
     * @param map
     * @param request
     * @param response
     * @return
     */
    @Override
    public void exportExcel(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HSSFWorkbook wb = getWorkBook(map);
        response.setContentType("application/vnd.ms-excel");
        if (wb.getClass().toString().contains("HSSFWorkbook")) {
            response.setHeader("Content-Disposition", "attachment; filename=\"" +
                    DateUtils.DateFormatStr(new Date()) + ".xls\"");
        } else {
            response.setHeader("Content-Disposition", "attachment; filename= \"" +
                    DateUtils.DateFormatStr(new Date()) + ".xlsx\"");
        }
        wb.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }


    private HSSFWorkbook getWorkBook(Map<String, Object> map) throws Exception {
        LinkedHashMap<String, String> fieldMap = getFields();
        List<Map<String, String>> list = getExportData(map);
        // 创建一个webbook对应的excel
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("导出数据");
        // 合并单元格
        HSSFRow row_1 = sheet.createRow(0);
        int i = 0;
        for (String key : fieldMap.keySet()) {
            HSSFCell cell = row_1.createCell(i);
            cell.setCellValue(key);
            i++;
        }
        for (int j = 1; j <= list.size(); j++) {
            HSSFRow row = sheet.createRow(j);
            Map<String, String> maps = list.get(j - 1);
            Set<String> keySet = maps.keySet();
            int a = 0;
            for (String key : fieldMap.keySet()) {
                HSSFCell cell = row.createCell(a);
                if (maps.get(fieldMap.get(key)) != null) {
                    if ("".equals(String.valueOf(maps.get(fieldMap.get(key))))) {
                        cell.setCellValue("");
                    } else {
                        cell.setCellValue(String.valueOf(maps.get(fieldMap.get(key))));
                    }
                }
                a++;
            }
        }
        return wb;
    }


    // 生成excel的表头
    private LinkedHashMap<String, String> getFields() {
        LinkedHashMap<String, String> fieldColumnsMap = new LinkedHashMap<String, String>();
        fieldColumnsMap.put("所在省", "province");
        fieldColumnsMap.put("所在市", "city");
        fieldColumnsMap.put("所在县", "county");
        fieldColumnsMap.put("学校名称", "employee_school");
        fieldColumnsMap.put("部门", "employee_deptName");
        fieldColumnsMap.put("职位", "employee_job");
        fieldColumnsMap.put("学段", "paragraph");
        fieldColumnsMap.put("科目", "subject_name");
        fieldColumnsMap.put("代课年级", "grade_year_name");
        fieldColumnsMap.put("代课班", "sys_claxx_name");
        fieldColumnsMap.put("职工姓名", "employee_name");
        fieldColumnsMap.put("性别", "employee_sex");
        fieldColumnsMap.put("手机号", "employee_phone");
        fieldColumnsMap.put("身份证号", "employee_idcard");
        fieldColumnsMap.put("班主任所带年级", "grade_year_name");
        fieldColumnsMap.put("班主任所带班级", "sys_claxx_name");
        fieldColumnsMap.put("联系人姓名", "employee_parent");
        fieldColumnsMap.put("联系人手机号码", "employee_parent_phone");
        fieldColumnsMap.put("学历", "employee_edu");

        return fieldColumnsMap;
    }


    // 获取导出excel文件的数据
    private List<Map<String, String>> getExportData(Map<String, Object> map) {
        List<Map<String, String>> list = smdEmployeeDao.getExportData(map);
        // 获取部门
        StringBuffer sbf = new StringBuffer();
        list.forEach(maps -> {
            if (maps.containsKey("employee_dept") && maps.get("employee_dept") != null) {
                sbf.append("'" + maps.get("employee_dept") + "',");
            }
        });
        if (list.size() > 0) {
            sbf.deleteCharAt(sbf.length() - 1);
        }
        // 获取职工列表中的职工所在部门
//        List<Map<String, Object>> list2 = UtilHttp.getDepts(sbf.toString());

        //将获取到的职工部门设置给每一个职工
//        list.forEach(map0 -> {
//            list2.forEach(map2 -> {
//                if (map0.get("employee_dept") != null && map0.get("employee_dept").equals(map2.get("org_id"))) {
//                    map0.put("employee_deptName", map2.get("org_name").toString());
//                }
//            });
//        });
        return list;
    }


    /**
     * 更新上传职工简历至smdEmployee表中
     *
     * @param entity
     */
    @Override
    public void updateResume(SmdEmployeeEntity entity) {
        // 1.更新简历上传路径
        smdEmployeeDao.updateResume(entity);
        //２．更新简历上传状态 ０ ：不存在； １：ｄ存在
        smdEmployeeDao.updateExisitIncident(entity);
    }

    /**
     * 获取上传简历的路径
     *
     * @param employeeId
     * @return
     */
    @Override
    public SmdEmployeeEntity getEmployeeResumeUrl(String employeeId) {
        return smdEmployeeDao.getEmployeeResumeUrl(employeeId);
    }

    /**
     * 获取学校下的职务信息
     *
     * @param orgId
     * @param tenantId
     * @return
     */
    @Override
    public List<Map<String, Object>> getEmployeeJobByOrgId(String orgId, String tenantId) {
        return smdEmployeeDao.getEmployeeJobByOrgId(orgId, tenantId);
    }


    /**
     * 设置班主任
     *
     * @param entity
     */
    @Override
    public void setHeaderTeacher(SmdEmployeeEntity entity) {
        smdEmployeeDao.setHeaderTeacher(entity);
    }


    /**
     * 查询当前 职工是否已经是班主任
     *
     * @param employeeId
     * @return
     */
    @Override
    public SmdEmployeeEntity isExitWhichClazz(String employeeId) {
        return smdEmployeeDao.isExitWhichClazz(employeeId);
    }


    /**
     * 导出excel模板
     *
     * @param map
     * @param request
     * @param response
     */
    @Override
    public void exportExcelTemplate(Map<String, Object> map, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        HSSFWorkbook workbook = getWorkBookTemplate(map);
        response.setContentType("application/vnd.ms-excel");
        if (workbook.getClass().toString().contains("HSSFWorkbook")) {
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + DateUtils.DateFormatStr(new Date()) + ".xls\"");
        } else {
            response.setHeader("Content-Disposition",
                    "attachment; filename= \"" + DateUtils.DateFormatStr(new Date()) + ".xlsx\"");
        }
        workbook.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }


    /**
     * 设置excel模板表头
     *
     * @param map
     * @return
     * @throws Exception
     */
    public HSSFWorkbook getWorkBookTemplate(Map<String, Object> map) throws Exception {
        // 创建一个webbook对应的excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("导出职工信息导入模板");
        // 合并单元格
        HSSFRow row_0 = sheet.createRow(0);
        HSSFRow row_1 = sheet.createRow(1);
        HSSFRow row_2 = sheet.createRow(2);
        String[] cols0 = new String[]{"职工信息"};
        for (int i = 0; i < cols0.length; i++) {
            HSSFCell cell = row_0.createCell(i);
            cell.setCellValue(cols0[i]);
        }

        String[] cols1 = new String[]{"带有*为必填字段"};
        for (int i = 0; i < cols1.length; i++) {
            HSSFCell cell = row_1.createCell(i);
            cell.setCellValue(cols1[i]);
        }

        String[] cols2 = new String[]{"姓名*", "性别*", "身份证号*", "职务*", "手机号码*", "擅长科目*", "入职日期*",
                "籍贯", "民族", "学历", "毕业院校", "毕业时间", "健康状况", "婚姻状况", "政治面貌", "出生日期", "所学专业",
                "特长", "职工编号", "职称", "获取职称时间", "教师资格证", "通讯地址", "家庭住址", "邮编", "QQ", "微信", "电子邮箱",
                "科目", "省", "市", "县", "家长", "家长手机号", "班主任所带年级", "班主任所带班级"};
        for (int i = 0; i < cols2.length; i++) {
            HSSFCell cell = row_2.createCell(i);
            cell.setCellValue(cols2[i]);
        }

        CellRangeAddress callRangeAddress = new CellRangeAddress(0, 0, 0, 47);// 起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress);
        CellRangeAddress callRangeAddress1 = new CellRangeAddress(1, 1, 0, 47);// 起始行,结束行,起始列,结束列
        sheet.addMergedRegion(callRangeAddress1);

        sheet.getRow(0).setHeight((short) 1000);
        sheet.getRow(1).setHeight((short) 300);
        sheet.getRow(2).setHeight((short) 300);

        return workbook;
    }

    /**
     * 保存职工数据
     *
     * @param list
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveBatch(List<SmdEmployeeEntity> list, Map<String, Object> userMap) {
        R r = organizationFeignClient.generateAccount(userMap);
        for (SmdEmployeeEntity emp : list) {
            smdEmployeeDao.save(emp);
        }
    }

    /**
     * 判断职工姓名是否存在
     *
     * @param employeeName
     * @return
     */
    @Override
    public List<SmdEmployeeEntity> isExistEmpName(String employeeName) {
        return smdEmployeeDao.isExistEmpName(employeeName);
    }

    /**
     * 判断职工身份证号码是否存在
     *
     * @param employeeIdCard
     * @return
     */
    @Override
    public List<SmdEmployeeEntity> isExistEmpIdCard(String employeeIdCard) {
        return smdEmployeeDao.isEmpIdCard(employeeIdCard);
    }

    /**
     * 判断职工手机号码是否存在
     *
     * @param employeePhone
     * @return
     */
    @Override
    public List<SmdEmployeeEntity> isExistEmpPhone(String employeePhone) {
        return smdEmployeeDao.isExistEmpPhone(employeePhone);
    }

    @Override
    public List<Map<String, Object>> getEmployeeByJobIds(String[] ids) {
        return smdEmployeeDao.getEmployeeByJobIds(ids);
    }

    @Override
    public Map<String, Object> login(Map<String, Object> map1) {
        return smdEmployeeDao.login(map1);
    }


    @Override
    public void synchronousEmpData(Map<String, Object> param) throws Exception {
        try {
            String tenantId = param.get("tenantId").toString();
            R r = authFeignClient.getDingtalk(param);
            if (r.get("code").toString().equals("0")) {
                String orgId = param.get("orgId").toString();
                String deptId = param.get("deptId").toString();
                String ddId = param.get("ddId").toString();
                List<SmdEmployeeEntity> empList = smdEmployeeDao.getEmployeesByOrgId(orgId, deptId);
                for (SmdEmployeeEntity entity : empList) {
                    JSONObject object = new JSONObject();
                    List<Integer> deptList = new ArrayList<Integer>();
                    deptList.add(Integer.parseInt(ddId));
                    object.put("name", entity.getEmployeeName());
                    object.put("department", deptList);
                    object.put("position", entity.getEmployeeJob());
                    object.put("mobile", entity.getEmployeePhone());
                    String accessToken = DingHttpsUtil.getAccessToken(r.get("corpId").toString(), r.get("corpSecret").toString());
                    String body = object.toJSONString();
                    Map<String, Object> map = DingHttpsUtil.create(accessToken, body);
                    System.out.println("map --------------------------- " + map);

                    smdEmployeeDao.updateEmpDDId(entity.getEmployeeId(), map.get("userid").toString());
                }
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
