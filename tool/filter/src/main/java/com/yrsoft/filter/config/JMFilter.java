package com.yrsoft.filter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mz
 * @Title: JMFilter
 * @ProjectName yrsoft
 * @Description: TODO
 * @date 2019/1/3017:05
 */
@WebFilter(asyncSupported = true)
@Configuration
public class JMFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JMFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("进入过滤器");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        //处理跨越问题
        orginHadler(req,rep);

        //放过请求
        filterChain.doFilter(servletRequest,servletResponse);

    }

    private void orginHadler(HttpServletRequest req, HttpServletResponse rep) {
        String originHeads = req.getHeader("Origin");
        rep.setHeader("Access-Control-Allow-Origin", originHeads);
        // 设置服务器允许浏览器发送请求都携带cookie
        rep.setHeader("Access-Control-Allow-Credentials","true");
        // 允许的访问方法
        rep.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        rep.setHeader("Access-Control-Max-Age", "3600");
        rep.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept,mid,X-Token");

    }

    @Override
    public void destroy() {

    }
}
