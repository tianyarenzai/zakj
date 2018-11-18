package com.zakj.personnel.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zakj.client.OrganizationFeignClient;
import com.zakj.personnel.entity.SmdCeAttachmentEntity;
import com.zakj.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zakj.security.common.beans.AjaxListResult;
import com.zakj.personnel.entity.SmdCeContractEntity;
import com.zakj.personnel.service.SmdCeContractService;
import com.zakj.security.controller.BaseController;


import net.sf.json.JSONObject;


/**
 * InnoDB free: 12288 kB; (`employee_id`) REFER `renren_fast/smd_employee`(`employe
 *
 * @author zhangxia
 * @email zhangxia_rgcdlb@163.com
 * @date 2018-03-11 17:04:24
 */
@RestController
@RequestMapping("/employee/contract")
public class SmdCeContractController extends BaseController {
    @Autowired
    private SmdCeContractService smdCeContractService;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    @RequestMapping("/resume/{employeeId}")
    public ModelAndView info(@PathVariable("employeeId") String employeeId) {

        mav.addObject("employeeId", employeeId);
        mav.setViewName("test/resume");
        return mav;
    }


    /**
     * 获取合同列表信息
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/list")
    public R list(HttpServletRequest request, HttpSession session) {
        List<Map<String, Object>> list = null;
        try {
            List<Object> li = new ArrayList<Object>();
            List<Map<String, Object>> organizationList = new ArrayList<Map<String, Object>>();
            Map<String, Object> params = this.getRequestParams(request);
            String userId = (String) session.getAttribute("userId");
            String orgId = (String) session.getAttribute("orgId");
            String type = params.get("type").toString();
            params.put("userId", userId);
            params.put("orgId", orgId);
            if (type.equals("0")) {
                params.put("orgId", orgId);
                params.put("userId", userId);
                R r = organizationFeignClient.queryDataAuthOrganization(params);
                if (r.get("code").toString().equals("0")) {
                    organizationList = (List<Map<String, Object>>) r.get("data");
                    for (Iterator<Map<String, Object>> iterator = organizationList.iterator(); iterator.hasNext(); ) {
                        Map<String, Object> map1 = iterator.next();
                        li.add(map1.get("orgId"));
                    }
                    params.put("orgId", li);
                }
            } else {
                li.add(orgId);
                params.put("orgId", li);
            }
            list = this.smdCeContractService.queryList(params);
            return R.ok(list, this.smdCeContractService.queryTotal(params));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常信息: ------------------------ " + e.getMessage());
        }
        return null;
    }


    /**
     * 点击提醒
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("remind")
    @ResponseBody
    public ModelAndView remind(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = this.getRequestParams(request);
        String contractId = map.get("contractId").toString();
        System.out.println("contractId---------------------------- " + contractId);
        String userId = map.get("userId").toString();
        System.out.println("userId ------------------------------------ " + userId);
        mav.addObject("contractId", contractId);
        mav.addObject("userId", userId);
        mav.setViewName("employee/remind");
        return mav;
    }


    /**
     * 点击附件
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("upload")
    public ModelAndView upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = this.getRequestParams(request);
        String employeeId = map.get("employeeId").toString();
        System.out.println("employeeId ----------------------- " + employeeId);
        mav.addObject("employeeId", employeeId);
        mav.setViewName("employee/contractAttachment");
        return mav;
    }


    /**
     * 点击新增
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        mav.setViewName("employee/contractAdd");
        return mav;
    }


    /**
     * 新建合同
     *
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("save")
    public AjaxListResult<Map<String, Object>> save(HttpServletRequest request, HttpSession session) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String data = map.get("data").toString();
            JSONObject obj = JSONObject.fromObject(data);
            SmdCeContractEntity entity = (SmdCeContractEntity) JSONObject.toBean(obj, SmdCeContractEntity.class);
            System.out.println("职工 ID ---------------------------- " + entity.getEmployeeId());
            System.out.println("生效日期: ---------------------------- " + entity.getBeginTime());
            System.out.println("失效日期: --------------------------------- " + entity.getEndTime());
            System.out.println("提醒日期：----------------------------------" + entity.getRemindDate());
            // 企业ID
            String tenantId = (String) session.getAttribute("tenantId");
            entity.setTenantId(tenantId);
            // 创建职工ID
            String employeeId = (String) session.getAttribute("employeeId");
            entity.setCreateEmpId(employeeId);
            String employeeName = (String) session.getAttribute("employeeName");
            entity.setCreateEmpName(employeeName);
            String userId = (String) session.getAttribute("userId");
            entity.setCreateUser(userId);
            entity.setCreateDate(new Date());
            smdCeContractService.save(entity);
            result.setCode(0);
            result.setMsg("操作成功!");
        } catch (Exception e) {
            result.setCode(101);
            result.setMsg("操作失败!" + e.getMessage());
        }
        return result;
    }


    /**
     * 删除合同信息
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("delete")
    public AjaxListResult<Map<String, Object>> delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        try {
            Map<String, Object> map = this.getRequestParams(request);

            String contractId = map.get("contractId").toString();
            System.out.println("contractId------------------------ " + contractId);
            smdCeContractService.delete(contractId);
            result.setCode(0);
            result.setMsg("操作成功!");
        } catch (Exception e) {
            result.setCode(101);
            result.setMsg("发生未知异常" + e.getMessage());
        }
        return result;
    }


    /**
     * 下载预览合同(没有用了)
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("dowloadFile")
    public ModelAndView dowloadFile(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String contractId = map.get("contractId").toString();
            System.out.println("合同Id --------------------------------- " + contractId);
            // 获取当前合同的附件 下载图片
            List<SmdCeAttachmentEntity> smdCeAttachmentEntities = smdCeContractService.getAttachmentUrls(contractId);
            for (int i = 0; i < smdCeAttachmentEntities.size(); i++) {
                URL url = new URL(smdCeAttachmentEntities.get(i).getAttachmentUrl());
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
                File saveDir = new File("D:/images/img");
                if (!saveDir.exists()) {
                    saveDir.mkdir();
                }
                File file = new File(saveDir + File.separator + contractId + "_" + i + ".jpg");
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(getData);
                if (fos != null) {
                    fos.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            // 获取下载到本地的图片
            List<String> urls = readfile("D:/images/img", contractId);
            System.out.println("urls: --------------------- " + urls.size());
            mav.addObject("urls", urls);
            mav.setViewName("employee/contractPhotoView");
        } catch (Exception e) {
            System.out.println("发生未知异常: " + e.getMessage());
        }
        return mav;
    }


    /**
     * 从输入流中获取字节数组（没有用了）
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
     * 获取下载至本地的路径 （没有用了）
     *
     * @param filepath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static List<String> readfile(String filepath, String contractId) throws FileNotFoundException, IOException {
        List<String> urls = new ArrayList<String>();
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (readfile.getName().contains(contractId)) {
                        urls.add(readfile.getPath());
                    }
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath="
                                + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i], contractId);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return urls;
    }


    /**
     * 合同预览
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("contractView")
    public ModelAndView contractView(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = this.getRequestParams(request);
        try {
            String contractId = map.get("contractId").toString();
            List<SmdCeAttachmentEntity> smdCeAttachmentEntities = smdCeContractService.getAttachmentUrls(contractId);
            mav.addObject("attachments", smdCeAttachmentEntities);
            mav.setViewName("employee/contractPhotoView");
        } catch (Exception e) {
            System.out.println("发生未知异常：" + e.getMessage());
        }
        return mav;
    }


}
