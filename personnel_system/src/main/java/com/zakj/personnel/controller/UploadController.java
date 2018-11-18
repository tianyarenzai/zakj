package com.zakj.personnel.controller;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.zakj.security.common.beans.AjaxListResult;
import com.zakj.utils.ConfigUtil;
import com.zakj.utils.DateUtils;
import com.zakj.utils.UploadImage;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/file")
public class UploadController {

    @RequestMapping("/toFile")
    public String toFileUpload() {
        return "fileUpload";
    }

    @RequestMapping("/toFile2")
    public String toFileUpload2() {
        return "fileUpload2";
    }

    /**
     * 方法一上传文件
     */
    @RequestMapping("/onefile")
    public String oneFileUpload(
            @RequestParam("file") CommonsMultipartFile file,
            HttpServletRequest request, ModelMap model) {

        // 获得原始文件名  
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);

        // 新文件名  
        String newFileName = UUID.randomUUID() + fileName;

        // 获得项目的路径  
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置  
        String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  

        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("上传图片到:" + path + newFileName);
        // 保存文件地址，用于JSP页面回显  
        model.addAttribute("fileUrl", path + newFileName);
        return "sys/img";
    }

    /**
     * 方法二上传文件，一次一张
     */
    @RequestMapping(value = "/onefile2", produces = {"application/json;charset = UTF-8"})
    public @ResponseBody
    AjaxListResult<Map<String, Object>> oneFileUpload2(HttpServletRequest request,
                                                       HttpServletResponse response) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
        Iterator<String> files = mRequest.getFileNames();
        while (files.hasNext()) {
            MultipartFile mFile = mRequest.getFile(files.next());
            if (mFile != null) {
                String fileName = UUID.randomUUID() + mFile.getOriginalFilename();
                String path = "d:/upload/" + fileName;

                File localFile = new File(path);
                mFile.transferTo(localFile);
                request.setAttribute("fileUrl", path);
                Map<String, Object> map = new HashMap<String, Object>();
                String uploadPic = UploadImage.uploadFile(fileName, localFile, "AA");
                System.out.println("uploadPic ------------------------------- " + uploadPic);
                map.put("url", uploadPic);
                result.setMap(map);
            }
        }
        return result;
    }

    /**
     * 方法二上传文件，一次一张
     */
    @RequestMapping("/onefile3")
    public String oneFileUpload3(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();

        CommonsMultipartResolver cmr = new CommonsMultipartResolver(
                request.getServletContext());
        if (cmr.isMultipart(request)) {
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
            Iterator<String> files = mRequest.getFileNames();
            while (files.hasNext()) {
                MultipartFile mFile = mRequest.getFile(files.next());
                if (mFile != null) {
                    String fileName = UUID.randomUUID()
                            + mFile.getOriginalFilename();
                    String path = "d:/upload/" + fileName;

                    File localFile = new File(path);
                    mFile.transferTo(localFile);
                    request.setAttribute("fileUrl", path);
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("url", path);
                    result.setMap(map);
                }
            }
        }
        return "9888";
    }

    @RequestMapping("/threeFile1")
    public String threeFileUpload1(
            @PathVariable("file") CommonsMultipartFile files[],
            HttpServletRequest request, ModelMap model) {

        System.out.println("156339964");
        return null;


    }


    /**
     * 一次上传多张图片
     */
    @RequestMapping(value = "/threeFile", produces = {"application/json;charset = UTF-8"})
    public @ResponseBody
    AjaxListResult<Map<String, Object>> threeFileUpload(@RequestParam("file") MultipartFile files[],
            HttpServletRequest request, ModelMap model) {
        AjaxListResult<Map<String, Object>> result = new AjaxListResult<Map<String, Object>>();
        List<String> urlList = new ArrayList<String>();
        // 获得项目的路径
        //   ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        //   String paths = sc.getRealPath("/img") + "/"; // 设定文件保存的目录

        String path = "d:/upload/";
                // ConfigUtil.getValue("path");
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }

        String fileNameStr = "";
        String fileTypeStr = "";
        for (int i = 0; i < files.length; i++) {
            // 获得原始文件名
            String fileName = files[i].getOriginalFilename();
            System.out.println("原始文件名:" + fileName);

            String fileStr = fileName.substring(0, fileName.indexOf("."));
            fileNameStr += fileStr + ";";
            System.out.println("fileNameStr ------------------------------ " + fileNameStr);
            String typeStr = fileName.substring(fileName.lastIndexOf(".") + 1);
            fileTypeStr += typeStr + ";";
            System.out.println("fileTypeStr -------------------------------- " + fileTypeStr);
            // 新文件名
            String newFileName = UUID.randomUUID() + fileName;
            if (!files[i].isEmpty()) {
                try {
                    FileOutputStream fos = new FileOutputStream(path
                            + newFileName);
                    InputStream in = files[i].getInputStream();
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        fos.write(b);
                    }
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            File file = new File(path + newFileName);
            System.out.println("上传图片到:" + path + newFileName);
            // list.add(path + newFileName);
            String uploadPic = null;
            try {
                uploadPic = UploadImage.uploadFile(fileName, file, "BB/");
            } catch (OSSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClientException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(uploadPic);
            urlList.add(uploadPic);
        }
        System.out.println("fileNameStr   1111111 ------------------------------ " + fileNameStr);
        System.out.println("fileTypeStr 1111111-------------------------------- " + fileTypeStr);
        result.setArray(urlList.toArray());
        result.setFileNameStr(fileNameStr);
        result.setFileTypeStr(fileTypeStr);
        return result;
    }


    /**
     * 歌曲上传
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "uploadSong", method = RequestMethod.POST)
    public @ResponseBody
    String uploadSong(HttpServletRequest request,
                      HttpServletResponse response, ModelMap model, HttpSession session) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile mFile = multipartRequest.getFile("song");
        String path = "E:\\";//替换成你所要保存的文件的位置
        String filename = mFile.getOriginalFilename();
        System.out.println("filename:" + filename);
        InputStream inputStream = mFile.getInputStream();
        byte[] b = new byte[1048576];
        int length = inputStream.read(b);
        String url = path + filename;
        System.out.println(url);
        FileOutputStream outputStream = new FileOutputStream(url);
        outputStream.write(b, 0, length);
        inputStream.close();
        outputStream.close();
        return filename;
    }



    @RequestMapping(value="/file/upload", produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String uploadFileHandler(HttpServletRequest request, @RequestParam("file") MultipartFile file){
        String result = "";
        //上传文件每日单独保存
        String path = "D:/upload/"+ DateUtils.getNow()+"/";

        if (file.getSize() > 0) {
            //获取绝对路径
            String uploadPath = request.getSession().getServletContext().getRealPath(path);
            try {
                //创建目标文件
                File targetFile = new File(uploadPath, file.getOriginalFilename());
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }

                file.transferTo(targetFile);
                result =  JSON.toJSONString(path+file.getOriginalFilename());
                System.out.println("result ---------------------------- "+  result);
            } catch (Exception e) {

            }
        }
        return result;
    }


}