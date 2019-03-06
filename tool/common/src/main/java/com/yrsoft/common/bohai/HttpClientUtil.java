package com.yrsoft.common.bohai;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * http请求工具类
 * @author zhanglun
 * @date 2015年11月27日 下午1:16:06 
 */
public class HttpClientUtil {

	/**
	 * post类型请求
	 * @param url 请求的地址
	 * @param nameValuePairs 请求参数，NameValuePair数组
	 * @return JSON格式字符串
	 */
	public static String postRequest(String url, NameValuePair[] nameValuePairs){
		PostMethod postMethod = null;
		try {
			HttpClient client = new HttpClient();
			
			//使用POST方法
			postMethod = new UTF8PostMethod(url);

			//请求参数
			postMethod.setRequestBody(nameValuePairs);

			//执行请求
			client.executeMethod(postMethod);
			
			StringBuffer buf = new StringBuffer();
			//服务器返回的状态，200代表成功
			if(postMethod.getStatusCode() == 200){
				//返回的信息
				InputStream stream = postMethod.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
				String line;
				while (null != (line = br.readLine())) {
					buf.append(line).append("\n");
				}
			}
			return buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(postMethod != null){
				//释放连接
				postMethod.releaseConnection();
			}
		}
	}
    
    /**
     * 向指定 URL 发送POST方法的请求
     * @param urlStr 发送请求的 URL
     * @param content 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param encoding 编码，如：utf-8、gbk
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String urlStr, String content, String encoding) {
        URL url = null;  
        HttpURLConnection connection = null;  
        try {  
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();// 新建连接实例  
            connection.setConnectTimeout(20000);// 设置连接超时时间，单位毫秒  
            connection.setReadTimeout(20000);// 设置读取数据超时时间，单位毫秒  
            connection.setDoOutput(true);// 是否打开输出流 true|false  
            connection.setDoInput(true);// 是否打开输入流true|false  
            connection.setRequestMethod("POST");// 提交方法POST|GET
            connection.setUseCaches(false);// 是否缓存true|false
            connection.setRequestProperty("Accept-Charset", encoding);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + encoding);
            connection.connect();// 打开连接端口  
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据  
            byte[] xmlByte = content.getBytes(encoding);
            out.write(xmlByte);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx  
            out.flush();// 刷新  
            out.close();// 关闭输出流  
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据  
            
            //以BufferedReader流来读取
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();// 关闭连接
            }
        }
        return null;
    }
	
	/**
	 * 内部类，重写方法设置提交的编码(字符集)
	 * @author zhanglun
	 * @date 2015年11月27日 下午2:29:38
	 */
	public static class UTF8PostMethod extends PostMethod{
	    public UTF8PostMethod(String url){     
	    	super(url);     
	    }     
	    @Override     
	    public String getRequestCharSet() {     
	        return "UTF-8";     
	    }
	}
	
}
