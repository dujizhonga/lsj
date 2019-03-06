package com.yrsoft.common.utils;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 极光推送工具类
 */
public class JPushUtli {

    protected static final Logger LOG = LoggerFactory.getLogger(JPushUtli.class);
    //应用Master Secret(车主)
   /* private static final String C_MASTER_SECRET = "59f698f095bc7c24d116b4b1";
    //应用
    private static final String C_APP_KEY = "a4a01441652c2f12efbadece";*/

    //应用Master Secret(车主)
    private static final String C_MASTER_SECRET = "a41f8288bdaed8271e96977e";
    //应用
    private static final String C_APP_KEY = "daa1fbcb32ea14c2037f30d2";
/*    //应用Master Secret(货主)
    private static final String H_MASTER_SECRET = "17fe2e09a10880a78a51deab";
    //应用
    private static final String H_APP_KEY = "4e130b3d1f9e6521ca284f00";*/
    private static final String H_MASTER_SECRET = "c613ea808d6014eb242030cb";
    //应用
    private static final String H_APP_KEY = "627216ec38b91f4d7829233a";
	
    //新订单
    public static final String NEW_ORDER_TITLE = "新订单";
    //新订单内容
    public static final String NEW_ORDER_CONECT = "您有新的订单，请点击进行接单";
    //接单完成
    public static final String JD_ORDER_TITLE = "接单完成";
    //接单内容
    public static final String JD_ORDER_CONECT = "您的车主已接单，请尽快处理订单";
    //下单完成
    public static final String XD_ORDER_TITLE = "下单完成";
    //下单内容
    public static final String XD_ORDER_CONECT = "货主已经完成下单，请按照约定时间进行拉货";
    //货主确认发货
    public static final String FH_ORDER_TITLE = "货主确认发货";
    //货主确认发货内容
    public static final String FH_ORDER_CONECT = "您有运单货主已经确认发货，点击查看详情";
    //完成货运
    public static final String WC_ORDER_TITLE = "完成货运";
    //完成货运
    public static final String WC_ORDER_CONECT = "您有运单已经完成运货，点击查看详情";
    //完成评论
    public static final String WC_COMMENT_TITLE = "完成评论";
    //完成内容
    public static final String WC_COMMENT_CONECT= "您有运单已经完成，点击查看详情";
    //扫描分派标题
    public static final String SC_SHIPPER_TITLE = "您有一个可接单";
    //扫描分派内容
    public static final String SC_SHIPPER_CONECT = "您有一个可接单的运单,请前往查看";
    /**
     * 推送（200成功 其它失败）
     * @param title：标题
     * @param conect：内容
     * @param param：后台可以发给设备的key/value参数，可以通过此传值
     * @param alias：发送的唯一标识
     * @return
     */
    public static int sendToAllH(String title,String conect,Map<String,String> param,String alias){
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(H_MASTER_SECRET, H_APP_KEY, null, clientConfig);
        PushPayload payload =null;
        int status = -1;
        if (!StringUtils.isBlank(alias)){
            payload = buildPushObject_android_ios_alert(title,conect,param,alias); //别名
        }else {
            payload = buildPushObject_android_ios_alert(title,conect,param);  //广播
        }
        try {
            PushResult result = jpushClient.sendPush(payload);
            status= result.getResponseCode();
            return  status;
        } catch (APIConnectionException e) {
            LOG.info("Connection error. Should retry later. ", e);
            LOG.info("Sendno: " + payload.getSendno());
            e.printStackTrace();
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
            e.printStackTrace();
        }
        return status;
    }
    
    /**
     * 发送安卓，苹果平台消息(车主)
     * @param title：消息标题
     * @param conect：消息内容
     * @param param：推送的附加内容，后台可以传值给前端
     */
    public static boolean sendToAllC(String title,String conect,Map<String,String> param,String alias){
        boolean statu = false;
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(C_MASTER_SECRET, C_APP_KEY, null, clientConfig);
        PushPayload payload =null;
        if (!StringUtils.isBlank(alias)){
            payload = buildPushObject_android_ios_alert(title,conect,param,alias); //别名
        }else {
            payload = buildPushObject_android_ios_alert(title,conect,param);  //广播
        }
        try {
            PushResult result = jpushClient.sendPush(payload);
            int status = result.getResponseCode();
            if (status==200){ //成功发送
                statu = true;
                return statu;
            }
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.info("Connection error. Should retry later. ", e);
            LOG.info("Sendno: " + payload.getSendno());
            e.printStackTrace();
            return statu;
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.error("Sendno: " + payload.getSendno());
            e.printStackTrace();
            return statu;
        }
        return statu;
    }
    /**
     *广播推送
     * @param title：消息标题
     * @param conect：消息内容
     * @param param：推送的附加内容，后台可以传值给前端
     * @return
     */
    private static PushPayload buildPushObject_android_ios_alert(String title, String conect,Map<String,String> param) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios()) //安卓和苹果
                .setAudience(Audience.all())  //所有人
                .setNotification(Notification.newBuilder()
                        .setAlert(conect)
                        .addPlatformNotification(AndroidNotification.newBuilder().setBigText(conect).setStyle(1).setTitle(title).addExtras(param).build()) //安卓
                        .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).addExtras(param).setSound("default").build()) //苹果
                        .build())
                .build();
    }

    /**
     * 通过别名推送
      * @param title：消息标题
     * @param conect：消息内容
     * @param param：推送的附加内容，后台可以传值给前端
     * @param alias：接收对象的唯一标识;例如：会员登录的Id
     * @return
     */
    private static PushPayload buildPushObject_android_ios_alert(String title, String conect,Map<String,String> param,String alias) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.alias(alias))  //广播方式所有人
                .setNotification(Notification.newBuilder()
                        .setAlert(conect)
                        .addPlatformNotification(AndroidNotification.newBuilder().setBigText(conect).setStyle(1).setTitle(title).addExtras(param).build()) //安卓平台
                        .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).addExtras(param).build()) //苹果平台
                        .build())
                .build();
    }

    public static void main(String[] args) {
//    	//货主端；
//        Map<String,String> param = new HashMap<>();
//        param.put("id","001");
//        param.put("urlType","2");
//        //param.put("url","127.0.0.1:8080");
//            sendToAllH("标题","内容",param,
//                "40249b84b79a4e7f87dfdb9d57414176");
       //车主端；
        Map<String,String> params = new HashMap<>();
//        params.put("id","001");
        params.put("urlType","2");
            //param.put("url","127.0.0.1:8080");
        sendToAllC("标题","内容",params,
                    "fe98fdddcada467f989f741a988c4eff");
    }


}
