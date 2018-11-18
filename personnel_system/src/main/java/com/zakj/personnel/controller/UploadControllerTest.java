package com.zakj.personnel.controller;

import com.zakj.utils.OSSFactory;
import com.zakj.utils.UploadImage;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadControllerTest {

    @RequestMapping(value = "/upload/uploadBase64", method = RequestMethod.POST)
    @ResponseBody
    public String base64UpLoad(@RequestParam String base64Data, HttpServletRequest request, HttpServletResponse response) {
        List<String> urlList = new ArrayList<String>();
        try {
            String dataPrix = "";
            String data = "";
            if (base64Data == null || "".equals(base64Data)) {
                throw new Exception("上传失败，上传图片数据为空");
            } else {
                String[] d = base64Data.split("base64,");
                if (d != null && d.length == 2) {
                    dataPrix = d[0];
                    data = d[1];
                } else {
                    throw new Exception("上传失败，数据不合法");
                }
            }
            String suffix = "";
            if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {//data:image/jpeg;base64,base64编码的jpeg图片数据
                suffix = ".jpg";
            } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {//data:image/x-icon;base64,base64编码的icon图片数据
                suffix = ".ico";
            } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {//data:image/gif;base64,base64编码的gif图片数据
                suffix = ".gif";
            } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {//data:image/png;base64,base64编码的png图片数据
                suffix = ".png";
            } else {
                throw new Exception("上传图片格式不合法");
            }
            String tempFileName = UUID.randomUUID().toString() + suffix;

            //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
            byte[] bs = Base64Utils.decodeFromString(data);
//            InputStream inputStream;
            try {
//                inputStream = new ByteArrayInputStream(bs);
                String url = OSSFactory.build().uploadSuffix(bs, suffix);
                System.out.println("url ------------------------" + url);
                urlList.add(url);

//                FileUtils.writeByteArrayToFile(new File(request.getServletContext().getRealPath("/upload"), tempFileName), bs);
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
                throw new Exception("上传失败，写入文件失败，" + ee.getMessage());
            }
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }


//    @RequestMapping(value = "/upload/uploadBase64", method = RequestMethod.POST)
//    @ResponseBody
//    public String base64UpLoad(@RequestParam String base64Data, HttpServletRequest request, HttpServletResponse response) {
//        String [] array = base64Data.split("@");
//        System.out.println(array);
//
//        List<String> urlList = new ArrayList<String>();
//        try {
//            String dataPrix = "";
//            String data = "";
//            if (array.length == 0) {
//                throw new Exception("上传失败，上传图片数据为空");
//            } else {
//                for(int i = 0; i < array.length; i ++){
//                    String[] d = array[i].split("base64,");
//                    if (d != null && d.length == 2) {
//                        dataPrix = d[0];
//                        data = d[1];
//                    } else {
//                        throw new Exception("上传失败，数据不合法");
//                    }
//
//                    String suffix = "";
//                    if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {   //data:image/jpeg;base64,base64编码的jpeg图片数据
//                        suffix = ".jpg";
//                    } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {   //data:image/x-icon;base64,base64编码的icon图片数据
//                        suffix = ".ico";
//                    } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {   //data:image/gif;base64,base64编码的gif图片数据
//                        suffix = ".gif";
//                    } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {   //data:image/png;base64,base64编码的png图片数据
//                        suffix = ".png";
//                    } else {
//                        throw new Exception("上传图片格式不合法");
//                    }
//                    String tempFileName = UUID.randomUUID().toString() + suffix;
//
//                    //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
//                    byte[] bs = Base64Utils.decodeFromString(data);
//                    try {
//                        //使用apache提供的工具类操作流
//                        System.out.println(request.getServletContext().getRealPath("/upload"));
//                        FileUtils.writeByteArrayToFile(new File(request.getServletContext().getRealPath("/upload"), tempFileName), bs);
//                    } catch (Exception ee) {
//                        throw new Exception("上传失败，写入文件失败，" + ee.getMessage());
//                    }
//                }
//            }
//            return "success";
//        } catch (Exception e) {
//            return "error";
//        }
//    }


    /**
     * base64上传文件
     * @param base64Data
     * @param request
     * @param response
     * @return
     */
/*    @RequestMapping(value = "/upload/uploadBase64", method = RequestMethod.POST)
    @ResponseBody
    public R base64UpLoad(@RequestParam String base64Data, HttpServletRequest request, HttpServletResponse response) {
        String [] array = base64Data.split("@");
        System.out.println(array);

        List<String> urlList = new ArrayList<String>();
        try {
            String dataPrix = "";
            String data = "";
            if (array.length == 0) {
                throw new Exception("上传失败，上传图片数据为空");
            } else {
                for(int i = 0; i < array.length; i ++){
                    String[] d = array[i].split("base64,");
                    if (d != null && d.length == 2) {
                        dataPrix = d[0];
                        data = d[1];
                    } else {
                        throw new Exception("上传失败，数据不合法");
                    }
                    System.out.println("dataPrix ----------------------------- " + dataPrix);
                    String suffix = "";
                    if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {   //data:image/jpeg;base64,base64编码的jpeg图片数据
                        suffix = ".jpg";
                    } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {   //data:image/x-icon;base64,base64编码的icon图片数据
                        suffix = ".ico";
                    } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {   //data:image/gif;base64,base64编码的gif图片数据
                        suffix = ".gif";
                    } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {   //data:image/png;base64,base64编码的png图片数据
                        suffix = ".png";
                    } else {
                        throw new Exception("上传图片格式不合法");
                    }
                    String tempFileName = UUID.randomUUID().toString() + suffix;

                    //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
                    byte[] bs = Base64Utils.decodeFromString(data);
                    InputStream inputStream;
                    try {
                        inputStream = new ByteArrayInputStream(bs);
                        //使用apache提供的工具类操作流
                        System.out.println(request.getServletContext().getRealPath("/upload"));
                        String uploadPic = UploadImage.uploadFile(tempFileName, inputStream, "AA");
                        System.out.println("uploadPic ------------------------------ " + uploadPic);
                        urlList.add(uploadPic);
//                        FileUtils.writeByteArrayToFile(new File(request.getServletContext().getRealPath("/upload"), tempFileName), bs);
                    } catch (Exception ee) {
                        throw new Exception("上传失败，写入文件失败，" + ee.getMessage());
                    }
                }
            }
            return R.ok(urlList);
        } catch (Exception e) {
            return R.error(101, "发生未异常：" + e.getMessage());
        }
    }*/

}
