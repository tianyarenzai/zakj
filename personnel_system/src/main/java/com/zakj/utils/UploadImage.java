package com.zakj.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Date;


/**
 * 类描述： 上传阿里云公共方法
 * 创建人：lxm  
 * 创建时间：2017-7-18   
 * @version  1.0
 *
 */
public class UploadImage {

	private static OSSClient ossClient;
	private static String bucketName = "zzjyoss";
	// endpoint以杭州为例，其它region请按实际情况填写df
	static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
	// accessKey请登录https://ak-console.aliyun.com/#/查看
	static String accessKeyId = "LTAISAmeEIv2Cl8D";
	static String accessKeySecret = "Iq6yOiH80jpEGJI5w9zW5zm71QErZH";
	
	/**
	 * 图片上传
	 * @param fileFileName 文件的名字
	 * @param file 上传的文件file
	 * @param path 本地的缓存的路径 上传完阿里云是要删除的
	 * @param aliyunPaht 阿里云的路径
	 * @return 返回阿里云的路径 可直接入库
	 */
	public static String saveImg(String fileFileName,File file,String aliyunPaht){
		try {
			//String url = path+fileFileName;
			//File newfile = new File(url);
            //FileUtils.copyFile(file, newfile);  //拷贝文件 以供上传阿里云
            String docPath = uploadFile(fileFileName,file, aliyunPaht) + ",";// 返回图片路径
           // newfile.delete();// 上传完成后删除服务器该文件
            return docPath;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}


	/**
	 * 阿里云图片上传
	 * @param fileName 新的文件名字
	 *
	 * @param aliyunPath 阿里云路径
	 * @return
	 * @throws OSSException
	 * @throws ClientException
	 * @throws FileNotFoundException
	 */
	public static String uploadFile(String fileName, byte[] file, String aliyunPath)
			throws OSSException, ClientException, FileNotFoundException {
		//String LocalFile = realpath + "\\" + fileName;
		String lujin = "";// 图片路劲
		// 创建OSSClient实例
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 断点续传上传
		try {
			// 带进度条的上传
			/*PutObjectResult objectResult = ossClient.putObject(new PutObjectRequest(bucketName, aliyunPath
							+ fileName, file).<PutObjectRequest> withProgressListener(new PutObjectProgressListener()));
			*/

			ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(file));
//			ossClient.putObject(bucketName, fileName, inputStream);
			lujin = getUrl(aliyunPath + fileName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// 关闭client
		ossClient.shutdown();
		return lujin;
	}



	/**
	 * 阿里云图片上传
	 * @param fileName 新的文件名字
	 * @param aliyunPath 阿里云路径
	 * @return
	 * @throws OSSException
	 * @throws ClientException
	 * @throws FileNotFoundException
	 */
	public static String uploadFile(String fileName, File file, String aliyunPath)
			throws OSSException, ClientException, FileNotFoundException {
		//String LocalFile = realpath + "\\" + fileName;
		String lujin = "";// 图片路劲
		// 创建OSSClient实例
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 断点续传上传
		try {
			// 带进度条的上传
			PutObjectResult objectResult = ossClient.putObject(new PutObjectRequest(bucketName, aliyunPath
							+ fileName, file).<PutObjectRequest> withProgressListener(new PutObjectProgressListener()));
			lujin = getUrl(aliyunPath + fileName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// 关闭client
		ossClient.shutdown();
		return lujin;
	}
	
	/**
	 * 获得url链接
	 * 
	 * @param key
	 * @return
	 */
	public static String getUrl(String key) {
		String urls = "";
		// 设置URL过期时间为10年 3600l* 1000*24*365*10
		Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24
				* 365 * 10);
		// 生成URL
		URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
		if (url != null) {
			urls = url.toString();
		}
		return urls;
	}
}
