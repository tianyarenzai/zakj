package com.zakj.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20160801.*;
import com.aliyuncs.utils.ParameterHelper;
import com.zakj.personnel.entity.AlyApSevPushMessageEntity;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lingbo on 16/8/15.
 */
public class PushMessage extends BaseTest {
//    private static String regionId = "cn-hangzhou";
//    private static String accessKeyId = "LTAI9av17dNKWrfj";
//    private static String accessKeySecret = "EAktHVik5BVQ5lNbojB72Zt61JrSza";
//    private static long appKey = 24765997;


    /**
     * 推送消息给android
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/48085.html
     */
    @Test
    public void testPushMessageToAndroid() throws Exception {

        PushMessageToAndroidRequest androidRequest = new PushMessageToAndroidRequest();
        //安全性比较高的内容建议使用HTTPS
        androidRequest.setProtocol(ProtocolType.HTTPS);
        //内容较大的请求，使用POST请求
        androidRequest.setMethod(MethodType.POST);
        androidRequest.setAppKey(appKey);
        androidRequest.setTarget("ALL");
        androidRequest.setTargetValue("ALL");
        androidRequest.setTitle("66666666666");
        androidRequest.setBody("6");
        PushMessageToAndroidResponse pushMessageToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, MessageId: %s\n",
                pushMessageToAndroidResponse.getRequestId(), pushMessageToAndroidResponse.getMessageId());
    }



    /**
     * 推送通知给android
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/48087.html
     */
    @Test
    public void testPushNoticeToAndroid() throws Exception {
	
        PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
        //安全性比较高的内容建议使用HTTPS
        androidRequest.setProtocol(ProtocolType.HTTPS);
        //内容较大的请求，使用POST请求
        androidRequest.setMethod(MethodType.POST);
        androidRequest.setAppKey(appKey);
      //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送

        androidRequest.setTarget("DEVICE");  
        androidRequest.setTargetValue("d59ae72757e3427b8b4f5ddc3277b36e"); 
      //  androidRequest.setTargetValue("1ac4db6a2951424892572f96d22b77fd"); 
        

        
      //  androidRequest.setExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)

        androidRequest.setTitle("Hello------------------------- ");
        androidRequest.setBody("天气刮风了---------------");
        androidRequest.setExtParameters("{\"category\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)
//category： 缴费   data：数据    title：消息的标题 Body消息的内容 
       // androidRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)

        PushNoticeToAndroidResponse pushNoticeToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, MessageId: %s\n",
                pushNoticeToAndroidResponse.getRequestId(), pushNoticeToAndroidResponse.getMessageId());

    }
    /**
     * 推送消息给iOS
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/48086.html
     */
    @Test
    public void testPushMessageToIOS() throws Exception {
        PushMessageToiOSRequest iOSRequest = new PushMessageToiOSRequest();
        //安全性比较高的内容建议使用HTTPS
        iOSRequest.setProtocol(ProtocolType.HTTPS);
        //内容较大的请求，使用POST请求
        iOSRequest.setMethod(MethodType.POST);
        iOSRequest.setAppKey(appKey);
        iOSRequest.setTarget("DEVICE");
        iOSRequest.setTargetValue(deviceIds);
        iOSRequest.setTitle("title");
        iOSRequest.setBody("body");


        PushMessageToiOSResponse pushMessageToiOSResponse = client.getAcsResponse(iOSRequest);
        System.out.printf("RequestId: %s, MessageId: %s\n",
                pushMessageToiOSResponse.getRequestId(), pushMessageToiOSResponse.getMessageId());
    }

    /**
     * 推送通知给iOS
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/48088.html
     */
    @Test
    public void testPushNoticeToIOS_toAll() throws Exception {

        PushNoticeToiOSRequest iOSRequest = new PushNoticeToiOSRequest();
        //安全性比较高的内容建议使用HTTPS
        iOSRequest.setProtocol(ProtocolType.HTTPS);
        //内容较大的请求，使用POST请求
        iOSRequest.setMethod(MethodType.POST);
        iOSRequest.setAppKey(appKey);
        // iOS的通知是通过APNS中心来发送的，需要填写对应的环境信息. DEV :表示开发环境, PRODUCT: 表示生产环境
        iOSRequest.setApnsEnv("PRODUCT");
        iOSRequest.setTarget("DEVICE");
        iOSRequest.setTargetValue("e24155d9f3db4e3791e5444d737c81db");
        //iOSRequest.setTitle("eewwewe");
        iOSRequest.setBody("Body");
        iOSRequest.setExtParameters("{\"k1\":\"v1\",\"k2\":\"v2\"}");


        PushNoticeToiOSResponse pushNoticeToiOSResponse = client.getAcsResponse(iOSRequest);
        System.out.printf("RequestId: %s, MessageId: %s\n",
                pushNoticeToiOSResponse.getRequestId(), pushNoticeToiOSResponse.getMessageId());
    }
    /**
     * 推送高级接口
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/48089.html
     * //
     */
    @Test
    public void testAdvancedPush() throws Exception {

        PushRequest pushRequest = new PushRequest();
        //安全性比较高的内容建议使用HTTPS
        pushRequest.setProtocol(ProtocolType.HTTPS);
        //内容较大的请求，使用POST请求
        pushRequest.setMethod(MethodType.POST);
        // 推送目标
        pushRequest.setAppKey(appKey);
       //  pushRequest.setTarget("DEVICE"); //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
       //pushRequest.setTargetValue(deviceIds); //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
       // pushRequest.setTarget("ALIAS"); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
        // pushRequest.setTargetValue("a"); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        pushRequest.setTarget("DEVICE"); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
        pushRequest.setTargetValue("all"); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
     
        
        pushRequest.setPushType("NOTICE"); // 消息类型 MESSAGE NOTICE
        pushRequest.setDeviceType("ALL"); // 设备类型 ANDROID iOS ALL.


        // 推送配置
        pushRequest.setTitle("李小萌已交费"); // 消息的标题
        pushRequest.setBody("缴费5000元SSS"); // 消息的内容

        // 推送配置: iOS
        pushRequest.setiOSBadge(5); // iOS应用图标右上角角标
	    pushRequest.setiOSSilentNotification(false);//开启静默通知
        pushRequest.setiOSMusic("default"); // iOS通知声音
        pushRequest.setiOSSubtitle("iOS10 subtitle");//iOS10通知副标题的内容
        pushRequest.setiOSNotificationCategory("iOS10 Notification Category");//指定iOS10通知Category
        pushRequest.setiOSMutableContent(true);//是否允许扩展iOS通知内容
        pushRequest.setiOSApnsEnv("DEV");//iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
        pushRequest.setiOSRemind(true); // 消息推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次。注意：离线消息转通知仅适用于生产环境
        pushRequest.setiOSRemindBody("iOSRemindBody");//iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效
        pushRequest.setiOSExtParameters("{\"_ENV_\":\"DEV\",\"k2\":\"v2\"}"); //通知的扩展属性(注意 : 该参数要以json map的格式传入,否则会解析出错)
        // 推送配置: Android
        pushRequest.setAndroidNotifyType("BOTH");//通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
        pushRequest.setAndroidNotificationBarType(1);//通知栏自定义样式0-100
        pushRequest.setAndroidNotificationBarPriority(1);//通知栏自定义样式0-100
        pushRequest.setAndroidOpenType("URL"); //点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
        pushRequest.setAndroidOpenUrl("http://www.zaxxkj.com/"); //Android收到推送后打开对应的url,仅当AndroidOpenType="URL"有效
        pushRequest.setAndroidActivity("com.alibaba.push2.demo.XiaoMiPushActivity"); // 设定通知打开的activity，仅当AndroidOpenType="Activity"有效
        pushRequest.setAndroidMusic("default"); // Android通知音乐
        pushRequest.setAndroidXiaoMiActivity("com.ali.demo.MiActivity");//设置该参数后启动小米托管弹窗功能, 此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 集成小米辅助通道；2. StoreOffline参数设为true）
        pushRequest.setAndroidXiaoMiNotifyTitle("Mi title");
        pushRequest.setAndroidXiaoMiNotifyBody("MiActivity Body");
        pushRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)


//        // 推送控制
        Date pushDate = new Date(System.currentTimeMillis()) ; // 30秒之间的时间点, 也可以设置成你指定固定时间
        String pushTime = ParameterHelper.getISO8601Time(pushDate);
        pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送
        String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
        pushRequest.setExpireTime(expireTime);
        pushRequest.setStoreOffline(true); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到


        PushResponse pushResponse = client.getAcsResponse(pushRequest);
        System.out.printf("RequestId: %s, MessageID: %s\n",
        pushResponse.getRequestId(), pushResponse.getMessageId());



    }

    /**
     * 取消定时推送
     * <p>
     * //
     */
    @Test
    public void testCancelPush() throws Exception {
        CancelPushRequest request = new CancelPushRequest();
        request.setAppKey(appKey);
        request.setMessageId("500081");
        CancelPushResponse response = client.getAcsResponse(request);
        System.out.println(response.getRequestId());

    }

    /**
     * 推送通知给Android
     * @param alyApSevPushMessage
     * @param region_id
     * @param access_key_id
     * @param access_key_secret
     * @param app_key
     */
    public Map<String, Object> PushMessageToAndroid(AlyApSevPushMessageEntity alyApSevPushMessage, String region_id, String access_key_id,
                                                    String access_key_secret, Long app_key) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
        //安全性比较高的内容建议使用HTTPS
        androidRequest.setProtocol(ProtocolType.HTTPS);
        //内容较大的请求，使用POST请求
        androidRequest.setMethod(MethodType.POST);
        androidRequest.setAppKey(app_key);
        //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
       /*androidRequest.setTarget("TAG");
         androidRequest.setTargetValue("tag1");*/
        //     androidRequest.setTarget("ALIAS");
            //androidRequest.setTargetValue("a");

        androidRequest.setTarget("DEVICE");
        androidRequest.setTargetValue("d59ae72757e3427b8b4f5ddc3277b36e");

        //  androidRequest.setExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)

        androidRequest.setTitle(alyApSevPushMessage.getTitle());
        androidRequest.setBody(alyApSevPushMessage.getBody());
        androidRequest.setExtParameters("{\"category\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)
//category： 缴费   data：数据    title：消息的标题 Body消息的内容
        // androidRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)

        IClientProfile profile = DefaultProfile.getProfile(region_id, access_key_id, access_key_secret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        PushNoticeToAndroidResponse pushNoticeToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, MessageId: %s\n",
                pushNoticeToAndroidResponse.getRequestId(), pushNoticeToAndroidResponse.getMessageId());

        map.put("requestId", pushNoticeToAndroidResponse.getRequestId());
        map.put("messageId", pushNoticeToAndroidResponse.getMessageId());
        map.put("deviceId", "d59ae72757e3427b8b4f5ddc3277b36e");
        return map;
    }
}
