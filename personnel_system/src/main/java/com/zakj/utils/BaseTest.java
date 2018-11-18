package com.zakj.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.testng.annotations.BeforeClass;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * 推送的OpenAPI文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/openapi.html
 */
public class BaseTest {

    protected static String region;
    protected static long appKey;
    protected static String deviceIds;
    protected static String deviceId;
    protected static String accounts;
    protected static String account;
    protected static String aliases;
    protected static String alias;
    protected static String tag;
    protected static String tagExpression;

    protected static DefaultAcsClient client;


    /**
     * 从配置文件中读取配置值，初始化Client
     * <p>
     * 1. 如何获取 accessKeyId/accessKeySecret/appKey 照见README.md 中的说明<br/>
     * 2. 先在 push.properties 配置文件中 填入你的获取的值
     */
    @BeforeClass
    public static void beforeClass() throws Exception {
//        InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("push.properties");
//        Properties properties = new Properties();
//        properties.load(inputStream);

        /*
            accessKeyId=LTAI9av17dNKWrfj
            accessKeySecret =EAktHVik5BVQ5lNbojB72Zt61JrSza
            appKey = 24765997
        */

        String accessKeyId = "LTAI9av17dNKWrfj";
                // properties.getProperty("accessKeyId");
        assertNotNull("先在 push.properties 配置文件中配置 accessKeyId", accessKeyId);
        String accessKeySecret = "EAktHVik5BVQ5lNbojB72Zt61JrSza";
                // properties.getProperty("accessKeySecret");
        assertNotNull("先在 push.properties 配置文件中配置 accessKeySecret", accessKeySecret);

        String key = "24765997";
                // properties.getProperty("appKey");
        assertNotNull("先在 push.properties 配置文件中配置 appKey", key);

        region = "cn-hangzhou";
// //properties.getProperty("regionId");
          appKey = Long.valueOf(key);
//        deviceIds = properties.getProperty("deviceIds");
//        deviceId = properties.getProperty("deviceId");
//        accounts = properties.getProperty("accounts");
//        account = properties.getProperty("account");
//        aliases = properties.getProperty("aliases");
//        alias = properties.getProperty("alias");
//        tag = properties.getProperty("tag");
//        tagExpression = properties.getProperty("tagExpression");

        IClientProfile profile = DefaultProfile.getProfile(region, accessKeyId, accessKeySecret);
        client = new DefaultAcsClient(profile);
    }
}
