package com.yrsoft.filter.config;


import com.alibaba.fastjson.JSON;

import com.yrsoft.common.config.Global;
import com.yrsoft.common.utils.AES;
import com.yrsoft.common.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author mz
 * @Title: ParameterFilter
 * @ProjectName yrsoft
 * @Description: TODO
 * @date 2018/10/1920:40
 */
@WebFilter(asyncSupported = true)
@Configuration
public class ParameterFilter extends OncePerRequestFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(ParameterFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("进入参数过滤器");
    	request.getParameterMap();
        Map<String , Object> extendParams = new HashMap<String , Object>();
        ParameterRequestWrapper paramWrapper = new ParameterRequestWrapper(request,extendParams);
        filterChain.doFilter(paramWrapper,response);
    }
}

//参数包装类
class ParameterRequestWrapper extends HttpServletRequestWrapper {

    private Map<String , String[]> params = new HashMap<String, String[]>();

    @SuppressWarnings("unchecked")
    public ParameterRequestWrapper(HttpServletRequest request) {
        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
        super(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        this.params.putAll(request.getParameterMap());
        this.modifyParameterValues();
    }
    //重载一个构造方法
    public ParameterRequestWrapper(HttpServletRequest request , Map<String , Object> extendParams) {
        this(request);

        //配置项是否进行解密
        if(!Global.getRequestAES()){
            return;
        }

        //判断登陆类型是否进行解密
        String type = request.getParameter("loginType");
        if (StringUtils.equals("0",type)|| StringUtils.equals("1", type)){

            //获取请求的参数
            String data = request.getParameter("data");
            if (!StringUtils.isBlank(data)) {

                //解密之后封装到requst中
                String jmData = AES.decrypt(data);
                Map<String,Object> map = JSON.parseObject(jmData, Map.class);
                for (String key : map.keySet()) {
                    params.put(key,new String[]{StringUtils.objToStr(map.get(key))});
                }
			}
        }
    }

    public void modifyParameterValues(){//将parameter的值去除空格后重写回去
        Set<String> set =params.keySet();
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String key= (String) it.next();
            String[] values = params.get(key);
            //values[0] = values[0].trim();
            params.put(key, values);
        }
    }

    // 重写几个HttpServletRequestWrapper中的方法
    /**
     * 获取所有参数名
     *
     * @return 返回所有参数名
     */
    @Override
    public Enumeration<String> getParameterNames() {
        Vector<String> vector = new Vector<String>(params.keySet());
        return vector.elements();
    }

    /**
     * 获取指定参数名的值，如果有重复的参数名，则返回第一个的值 接收一般变量 ，如text类型
     *
     * @param name
     *            指定参数名
     * @return 指定参数名的值
     */
    @Override
    public String getParameter(String name) {
        String[] results = params.get(name);
        if (results == null || results.length <= 0)
            return null;
        else {
            return results[0];
        }
    }

    /**
     * 获取指定参数名的所有值的数组，如：checkbox的所有数据
     * 接收数组变量 ，如checkobx类型
     */
    @Override
    public String[] getParameterValues(String name) {
        String[] results = params.get(name);
        if (results == null || results.length <= 0)
            return null;
        else {
            int length = results.length;
            for (int i = 0; i < length; i++) {
                results[i] = results[i];
            }
            return results;
        }
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> paramMap = new HashMap<>();
        String values[] = null;
        for (Enumeration<String> en = getParameterNames(); en.hasMoreElements();) {
            String paramName = (String) en.nextElement();
            values = getParameterValues(paramName);
            int n = values.length;
            paramMap.put(paramName, values);
            this.getRequest().setAttribute(paramName, values);
        }
        return paramMap;
    }
}