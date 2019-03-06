package com.yrsoft.condemo;


import com.yrsoft.common.constant.UrlContants;
import com.yrsoft.common.utils.JsonResult;
import com.yrsoft.condemo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class YrsoftAppApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger("TEST");

    @Autowired
    private Student student;

    @Test
    public void test() {
        LOGGER.info("{}", UrlContants.AUTH);
    }

    @Test
    public void student() {
        LOGGER.info("{}=============", student.getName());
    }

    @Test
    public void json(){
        LOGGER.info("==========={}", JsonResult.success("000000000"));
    }
}

