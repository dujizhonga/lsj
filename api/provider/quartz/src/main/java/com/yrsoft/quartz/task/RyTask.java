package com.yrsoft.quartz.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 * 
 * @author
 */
@Component("ryTask")
public class RyTask
{
    private static final Logger LOGGER = LoggerFactory.getLogger(RyTask.class);

    public void ryParams(String params)
    {
        LOGGER.info("执行有参方法:{}",params);
    }

    public void ryNoParams()
    {
        LOGGER.info("执行无参参方法:{}");
    }
}
