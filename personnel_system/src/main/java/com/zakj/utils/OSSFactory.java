package com.zakj.utils;

import com.aliyun.oss.OSSClient;

/**
 * 文件上传Factory
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 10:18
 */
public final class OSSFactory {

    private static OSSClient ossClient;

    // 域名
    private static String aliyunDomain = "oss-cn-shenzhen.aliyuncs.com";
    private static String bucketName = "zzjyoss";
    // endpoint以杭州为例，其它region请按实际情况填写df
    private static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    // accessKey请登录https://ak-console.aliyun.com/#/查看
    private static String accessKeyId = "LTAISAmeEIv2Cl8D";
    private static String accessKeySecret = "Iq6yOiH80jpEGJI5w9zW5zm71QErZH";
    // 阿里云路径前缀
    private static String aliyunPrefix = "ali";

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = new CloudStorageConfig();
        config.setAliyunDomain(aliyunDomain);
        config.setAliyunBucketName(bucketName);
        config.setAliyunEndPoint(endpoint);
        config.setAliyunAccessKeyId(accessKeyId);
        config.setAliyunAccessKeySecret(accessKeySecret);
        config.setAliyunPrefix(aliyunPrefix);
        return new AliyunCloudStorageService(config);
    }

}
