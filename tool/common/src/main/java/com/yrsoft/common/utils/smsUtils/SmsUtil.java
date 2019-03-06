package com.yrsoft.common.utils.smsUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.yrsoft.common.utils.StringUtils;

/**
 * 短信发送工具类
 * 
 * @author guyu
 *
 */
public class SmsUtil {

	/**
	 * 发送手机验证码(注册和忘记密码时)
	 * 
	 * @param map
	 * @throws IOException
	 */
	public static Map<String, Object> sendSmsMessage(Map<String, Object> map) throws IOException {
		// 请登录zz.253.com 获取创蓝API账号(非登录账号,示例:N1234567)
		String account = "N4736340";
		
		// 请登录zz.253.com 获取创蓝API密码(非登录密码)
		String pswd = "lSpEGaOh49aa01";
		
//		String returnMsg = null;
//		URL httpTest;
//		String mobile = StringUtil.toString(map.get("mobile"));
		String captcha = StringUtils.toString(map.get("captcha"));
		String msg = "【佬司机】您的验证码是:" + captcha + ",5分钟内有效。如非本人操作,请忽略该短信。";
//		String sendMsg = URLEncoder.encode(msg, "utf-8");
//		String url = "http://smssh1.253.com/msg/send/json?" + "account=N4736340&pswd=lSpEGaOh49aa01&mobile="
//				+ mobile + "&msg=" + sendMsg + "&needstatus=false&extno";
		//短信发送的URL 请登录zz.253.com 获取完整的URL接口信息
		String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
		//手机号码
		String phone = StringUtils.toString(map.get("mobile"));
		//状态报告
		String report= "true";
		
		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);
		
		String requestJson = JSON.toJSONString(smsSingleRequest);
		
		System.out.println("before request string is: " + requestJson);
		
		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
		
		System.out.println("response after request result is :" + response);
		
		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
		
		System.out.println("response  toString is :" + smsSingleResponse);	
		
//		try {
//			in = new BufferedReader(new InputStreamReader(httpTest.openStream(), "UTF-8"));
//			String inputLine = null;
//			// 得到返回信息的xml字符串
//			while ((inputLine = in.readLine()) != null)
//				if (returnMsg != null) {
//					returnMsg += inputLine;
//				} else {
//					returnMsg = inputLine;
//				}
//			in.close();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
		map.put("sendMsg", msg);
		map.put("returnMsg", smsSingleResponse.getMsgId()+","+smsSingleResponse.getCode());
		return map;
		
		
		
	}

	
	/**
	 * 发送手机验证码(注册和忘记密码时)
	 * 
	 * @param map
	 * @throws IOException
	 */
	public static Map<String, Object> sendCarStopSmsMessage(Map<String, Object> map) throws IOException {
		String account = "N4736340";
		String pswd = "lSpEGaOh49aa01";
		String msg = "【佬司机】尊敬的用户：由于您的图片上传错误，为不影响您正常使用，您可以添加我们的官方公众号【和硕佬司机】，点击联系客服与我们联系。";
		String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
		//手机号码
		String phone = StringUtils.toString(map.get("mobile"));
		//状态报告
		String report= "true";
		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);
		String requestJson = JSON.toJSONString(smsSingleRequest);
		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
		map.put("sendMsg", msg);
		map.put("returnMsg", smsSingleResponse.getMsgId()+","+smsSingleResponse.getCode());
		return map;
	}
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("mobile","17316687078");
		try {
			Map<String, Object> stringObjectMap = sendCarStopSmsMessage(map);
			System.out.println(stringObjectMap.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
